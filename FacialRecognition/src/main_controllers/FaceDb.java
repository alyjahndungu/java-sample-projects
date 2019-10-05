/**
 *
 */
package main_controllers;

import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;

/**
 * @author snipper
 *
 */
public class FaceDb {


	  private HashMultimap<String, BufferedImage> pics = HashMultimap.create();
	  private Map<String, BufferedImage> idIndex = Maps.newHashMap();

	  public String add(String name, BufferedImage pic) {
	    pics.put(name, pic);
	    final String id = UUID.randomUUID().toString();
	    idIndex.put(id, pic);
	    afterWrite();
	    return id;
	  }

	  public Set<BufferedImage> get(String name) {
	    return pics.get(name);
	  }

	  public Set<String> names() {
	    return pics.keySet();
	  }

	  public int size() {
	    return pics.values().size();
	  }

	  // todo: delete function

	  @Override
	  public int hashCode() {
	    return pics.hashCode() ^ idIndex.hashCode();
	  }

	  @Override
	  public boolean equals(Object that) {
	    return that instanceof FaceDb && ((FaceDb) that).idIndex.equals(idIndex) && ((FaceDb) that).pics.equals(pics);
	  }

	  private void afterWrite() {
	    FacialRecognator.invalidateTrainingCache(this);
	  }


}
