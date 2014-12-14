package com.czipperz.cLibrary.math;

import com.czipperz.cLibrary.math.wrappers.CDouble;
import com.czipperz.cLibrary.math.wrappers.CVal;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class CExpression implements IMathType, Serializable {
	private static final long serialVersionUID = -226985950114769624L;
	private IMathType[] items;
	
	public CExpression(IMathType[] items) {
		setItems(items);
	}
	
	public CExpression(ArrayList<IMathType> items) {
		setItems(items);
	}

	public IMathType[] getItems() {
		return items;
	}

	public CExpression setItems(IMathType[] items) {
		if(items.length > 0) {
		this.items = items;
		return this;
		}
		throw new InvalidParameterException("Cannot input an array with 0 length");
	}
	
	public CExpression setItems(ArrayList<IMathType> items) {
		return this.setItems((IMathType[]) items.toArray());
	}
	
	public CDouble evaluate() {
		CDouble result = new CDouble(0.0);
		for(int i = 0; i < items.length; i++) {
			IMathType t = items[i];
			if(t instanceof CVal) {
				
			}
		}
		return result;
	}
}
