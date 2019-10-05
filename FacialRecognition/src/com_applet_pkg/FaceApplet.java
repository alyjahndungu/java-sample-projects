/**
 *
 */
package com_applet_pkg;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JApplet;

/**
 * @author snipper
 *
 */
import com.google.common.collect.Lists;
import javax.swing.*;
import java.awt.*;


import main_controllers.FacialRecognator;
import main_controllers.FacialRecognator.PotentialFace;
import main_controllers.Webcam;
import main_controllers.FaceDb;

public class FaceApplet extends JApplet implements Runnable, MouseListener {

private final Webcam cam=new Webcam();

private List<Rectangle> currentFaces= Lists.newArrayList();
private BufferedImage currentDisplay;

private boolean running=true;
private boolean dialog=false;
@Override
public void init() {
  cam.start();
  BufferedImage first;
  while((first = cam.capture()) .equals(cam));
  setSize(first.getWidth(), first.getHeight());
  addMouseListener(this);
}

@Override
public void start() {
  new Thread(this).start();
}

public void run() {
  while (running) {
    repaint();
  }
}

@Override
public void update(Graphics g) {
  paint(g);
}

@Override
public void paint(Graphics g) {
  currentDisplay = cam.capture();
  if (currentDisplay == null || dialog) {
    return;
  }

  drawFaces(currentDisplay);
  g.drawImage(currentDisplay, 0, 0, null);
}

public void drawFaces(BufferedImage image) {
  final List<PotentialFace> faces = FacialRecognator.run(image, db);
  if (faces.isEmpty()) {
    return;
  }
  Graphics2D g2 = image.createGraphics();
  g2.setStroke(new BasicStroke(2));
  currentFaces.clear();
  for (PotentialFace face : faces) {
    final Rectangle r = face.box;
    final Color c1, c2;
    final String msg;
    if (face.name == null) {
      c1 = c2 = new Color(scale(r.x, getWidth(), 255d), scale(r.y, getHeight(), 255d), 0).brighter();
      msg = "Click to tag";
    } else {
      c1 = new Color(face.name.hashCode()).brighter();
      c2 = new Color((int) (c1.getRGB() - 10*face.confidence));
      msg = String.format("%s: %f", face.name, face.confidence);
    }
    g2.setColor(c1);
    g2.drawRect(r.x, r.y, r.width, r.height);
    g2.setColor(c2);
    g2.drawString(msg, r.x + 5, r.y - 5);
    currentFaces.add(r);
  }
}

private static int scale(double num, double maxNum, double maxTarget) {
  return (int) (num*maxTarget/maxNum);
}

@Override
public void stop() {
  running = false;
}

@Override
public void destroy() {
  cam.stop();
}

private final FaceDb db = new FaceDb();

@Override
public void mouseClicked(MouseEvent evt) {
  if (currentFaces == null) {
    System.out.println("No face in frame");
    return;
  }
  dialog = true;
  for(Rectangle r : currentFaces) {
    if (r.contains(evt.getPoint())) {
      final BufferedImage clickedFace = currentDisplay.getSubimage(r.x, r.y, r.width, r.height);
      final ImageIcon preview = new ImageIcon(clickedFace, "Preview");
      final String name = (String) JOptionPane.showInputDialog(null, "Save as?", "Tag", JOptionPane.QUESTION_MESSAGE, preview, null, null);
      if (name != null) {
        System.out.println("Saving " + name + "...");
        db.add(name, clickedFace);
      }
      break;
    }
  }
  dialog = false;

}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
