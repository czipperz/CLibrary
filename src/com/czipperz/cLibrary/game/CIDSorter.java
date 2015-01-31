package com.czipperz.cLibrary.game;

import java.util.Comparator;

public class CIDSorter implements Comparator<CIDAble> {
	public int compare(CIDAble id1, CIDAble id2) {
		return id1.getInstanceID().compareTo(id2.getInstanceID());
	}
}
