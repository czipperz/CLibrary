package com.czipperz.cLibrary.math.wrappers;

import com.czipperz.cLibrary.exceptions.CDoNotCallException;

public class CPercent extends CRangeInt {
	private CDoNotCallException ex = new CDoNotCallException();
	private int done = 0;
	
	public enum Type {
		/**
		 * From zero to one.  Others won't throw exceptions.
		 */
		TYPE_1, 
		/**
		 * From zero to one hundred.  Others won't throw exceptions.
		 */
		TYPE_100;
	}
	
	boolean setup = false;
	Type t;
	
	public CPercent(Object val, Type t) {
		super(val);
		this.t = t;
		super.setMin(0);
		super.setMax(t == Type.TYPE_1 ? 1 : 100);
		setup = true;
	}
	
	public CRangeInt setMin(Object min) {
		throw ex;
	}

	public CRangeInt setMax(Object max) {
		throw ex;
	}
	
	public CPercent removeBounds() {
		return this;
	}
	
	public CPercent setBounds(Object min, Object max) {
		throw ex;
	}
	
	public CPercent toCPercentOne() {
		return t == Type.TYPE_1 ? this : new CPercent(get() / 100, Type.TYPE_1);
	}
	
	public CPercent toCPercentOneHundred() {
		return t == Type.TYPE_100 ? this : new CPercent(get() * 100,  Type.TYPE_100);
	}
	
	public CRangeInt toCPercentInt() {
		return this.toCPercentOneHundred();
	}
}