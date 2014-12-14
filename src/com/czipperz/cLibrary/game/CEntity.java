package com.czipperz.cLibrary.game;

import com.czipperz.cLibrary.imaging.CImage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * This class is an example of a {@link CObjectDrawAble} that allows for {@link CEntitySubtype}
 * to be collectivized in a single object.  This is a miniature form of a {@link CView},
 * not incapsulating a view but components of an object.
 * @author Chris Gregory
 */
public class CEntity extends CObjectDrawAble {
	private ArrayList<CEntitySubtype> subtypes;
	private Rectangle locScreen;
	private CImage image;

	/**
	 * Creates a CEntity and calls the super method.
	 * @param displayOn - the {@link CGameFrame} to display the CEntity on. Only inputted to pass to the super.
	 * @param depth - the depth at which the CEntity will be drawn. (Note that the depth of the sub-objects is relative to this object as if the CEntity is 0.  They are all rendered at the same time.
	 * @param image - the image that will be displayed by the CEntity.
	 */
	public CEntity(CGameFrame displayOn, int depth, CImage image) {
		super(displayOn, depth, image);
		setup(image);
	}

	/**
	 * Creates a CEntity with a depth of 0 and calls the super method.
	 * @param displayOn - the {@link CGameFrame} to display the CEntity on. Only inputted to pass to the super.
	 * @param image - the image that will be displayed by the CEntity.
	 */
	public CEntity(CGameFrame displayOn, CImage image) {
		super(displayOn, image);
		setup(image);
	}

	private CEntity setup(CImage image) {
		this.image = image;
		subtypes = new ArrayList<CEntitySubtype>();
		return this;
	}
	
	/**
	 * Adds all the CEntitySubtypes to the collection stored in the object.  Allows for multiplicity.
	 * @param subs
	 * @return this object.
	 */
	public CEntity addAllSubtypes(Collection<? extends CEntitySubtype> subs) {
		subtypes.addAll(subs);
		return this;
	}
	
	/**
	 * Adds the CEntitySubtype to the collection stored in the object.  Allows for multiplicity.
	 * @param sub
	 * @return this object.
	 */
	public CEntity addSubtype(CEntitySubtype sub) {
		subtypes.add(sub);
		return this;
	}

	/**
	 * Access all subtypes and edit the list of subtypes through this method.
	 * @return a list of the subtypes of this object.
	 */
	public List<CEntitySubtype> getSubtypes() {
		return subtypes;
	}

	/**
	 * Sorts the CEntitys by depth then draws them. 
	 */
	public CEntity draw(Graphics g) {
		Collections.sort(subtypes, new CDepthSorter());
		for(CEntitySubtype s : subtypes) {
			if(s.drawBeforeEntity()) {
				s.draw(g);
			}
		}
		image.draw(g);
		for(CEntitySubtype s : subtypes) {
			if(s.drawAfterEntity()) {
				s.draw(g);
			}
		}
		return this;
	}

	public Rectangle getBounds() {
		Rectangle e = new Rectangle(0, 0, -1, -1);
		for(CEntitySubtype s : subtypes) {
			e.add(s.getBounds());
		}
		e.add(locScreen);
		return e;
	}

	public void mouseDragged(MouseEvent arg0) {
		
	}

	public void mouseMoved(MouseEvent arg0) {
		
	}

	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}
}
