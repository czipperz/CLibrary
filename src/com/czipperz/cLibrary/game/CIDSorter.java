package com.czipperz.cLibrary.game;

import java.util.Comparator;

public class CIDSorter implements Comparator<IIDAble> {
	public int compare(IIDAble id1, IIDAble id2) {
		return id1.getInstanceID().compareTo(id2.getInstanceID());
	}
}
