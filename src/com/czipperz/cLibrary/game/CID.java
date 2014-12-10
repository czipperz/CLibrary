package com.czipperz.cLibrary.game;

import java.io.Serializable;
import java.security.InvalidParameterException;

import com.czipperz.cLibrary.exceptions.CEnumTypeNotListedException;

/**
 * This is an ID that acts to identity objects (mostly implementing <code>IIDAble</code> from each other.<br />
 * <strong>NOTE:</strong> <i>IDs are <u>different</u> at <u>every runtime!</u></i>  <u><strong>DO NOT</strong> EXPECT</u> TO GET THE SAME VALUES WHEN <code>UNSERIALIZING</code>!
 * @author Chris Gregory
 * @see {@link #createClassID()} to make an <code>ID</code> to identify a <code>class</code> (replaces getClass().equals calls) 
 * @see {@link #createInstanceID()} to make an <code>ID</code> to identify a <code>instance</code> (replaces equals calls)
 */
public class CID implements Comparable<CID>, Serializable {
	public enum EIDType {
		TYPE_CLASS_ID, TYPE_INSTANCE_ID;
	}

	private final EIDType idType;
	private final int id;

	private CID(EIDType idType) {
		this.idType = idType;
		if(idType == EIDType.TYPE_CLASS_ID)
			id = classID();
		else if(idType == EIDType.TYPE_INSTANCE_ID)
			id = instanceID();
		else
			throw new RuntimeException("Need to add code to assign different types of IDs.");
	}

	/**
	 * @return The type of this <code>CID</code> instance.
	 */
	public EIDType getIDType() {
		return idType;
	}

	private static int classID = 990000, instanceID = 0;

	private static int classID() {
		classID += (int)(Math.random() * 7) + 7;
		return classID;
	}

	private static int instanceID() {
		instanceID += (int)(Math.random() * 5) + 8;
		return instanceID;
	}

	/**
	 * Creates a CID object for a class (note: this should be statically set for a class)
	 * @return the CID for the class.
	 */
	public static CID createClassID() {
		return new CID(EIDType.TYPE_CLASS_ID);
	}

	/**
	 * Creates a CID object for a class (note: this should be set in the constructor of a class)
	 * @return
	 */
	public static CID createInstanceID() {
		return new CID(EIDType.TYPE_INSTANCE_ID);
	}

	/**
	 * Returns true if the other object is <code>IIDAble</code> (or this - note this class is NOT implementing <code>IIDAble</code>), has the same IDType, and has the same identifier.
	 */
	public boolean equals(Object other) {
		if(other == null) {
			throw new InvalidParameterException("Object can't be null!");
		}
		if(other instanceof IIDAble) {
			if(this.idType == EIDType.TYPE_CLASS_ID) 
				return ((IIDAble) other).getClassID().id == this.id;
			if(this.idType == EIDType.TYPE_INSTANCE_ID)
				return ((IIDAble) other).getInstanceID().id == this.id;
			throw new CEnumTypeNotListedException();
		}
		if(other instanceof CID) {
			return ((CID) other).id == this.id && ((CID) other).idType == this.idType;
		}
		return false;
	}

	/**
	 * @return the difference between the other <code>CID</code> object and this one.
	 * @throws java.security.InvalidParameterException if the other CID is not of the same type.  (Class IDs is not comparable to Instance IDs.)
	 */
	public int compareTo(CID other) throws InvalidParameterException {
		if(other.idType != idType)
			throw new InvalidParameterException("You cannot compare IDs of differentiating types.");
		return other.id - this.id;
	}
	
	/**
	 * @return a String object that shows the class / instance represented.
	 */
	public String toString() {
		return "A CID Object representing a" + (idType == EIDType.TYPE_CLASS_ID ? " class" : idType == EIDType.TYPE_INSTANCE_ID ? "n instance" : CEnumTypeNotListedException.it().toString());
	}
}
