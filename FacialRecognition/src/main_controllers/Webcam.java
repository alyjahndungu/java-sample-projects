package main_controllers;

import java.awt.image.BufferedImage;

import com.google.common.base.Throwables;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;

public class Webcam {

	private final int CAMERA_NUMBER=0;
	private final FrameGrabber grabber= initGrabber();
	public void start(){
		try {
			grabber.start();

		} catch (FrameGrabber.Exception e) {

		Throwables.propagate(e);
		}

	}

	public  BufferedImage capture () {
		try {
			return grabber.grab().getBufferedImage(CAMERA_NUMBER);
		} catch (FrameGrabber.Exception e) {
			Throwables.propagate(e);
		}
		//return new BufferedImage(CAMERA_NUMBER, CAMERA_NUMBER, CAMERA_NUMBER);
		return null;

	}

	public void stop(){
		try {
			grabber.stop();
			grabber.release();
		} catch (FrameGrabber.Exception e) {
			Throwables.propagate(e);
		}

	}


	private FrameGrabber initGrabber() {
	 try {
		return FrameGrabber.createDefault(CAMERA_NUMBER);

	} catch (FrameGrabber.Exception e) {
		Throwables.propagate(e);
	}
		return new OpenCVFrameGrabber(CAMERA_NUMBER);
	}

}
