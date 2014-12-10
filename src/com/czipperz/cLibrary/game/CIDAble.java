package com.czipperz.cLibrary.game;

import java.io.Serializable;

/**
 * A basic class that allows for Serialization and IDing.
 * @author Chris Gregory
 * @see com.czipperz.cLibrary.game.CID
 */
public abstract class CIDAble implements IIDAble, Serializable {
	private static CID classID = CID.createClassID();
	private CID id = CID.createInstanceID();

	public CID getClassID() {
		return classID;
	}

	public CID getInstanceID() {
		return id;
	}
	
	public boolean equals(Object other) {
		return id.equals(other);
	}
	
	public boolean actuallyEquals(Object other) {
		return super.equals(other);
	}

	public int compareTo(IIDAble other) {
		return id.compareTo(other.getInstanceID());
	}
}