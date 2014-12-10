package com.czipperz.cLibrary.math.wrappers;

import java.security.InvalidParameterException;

public class CInt extends CVal {
	private Integer val;
	
	public CInt() {
		this(0);
	}
	
	public CInt(Integer val) {
		super(val);
	}

	public Integer get() {
		return val;
	}

	public CInt set(Object val) {
		if(val instanceof Integer) {
			this.val = ((Integer) val);
			return this;
		}
		if(val instanceof CVal) {
			this.val = ((CVal) val).toCInt().get();
			return this;
		}
		throw new InvalidParameterException("Cannot input that type of value");
	}

	public CInt setRel(Object val) {
		if(val instanceof Integer) {
			this.val += ((Integer) val);
			return this;
		}
		if(val instanceof CVal) {
			this.val += ((CVal) val).toCInt().get();
			return this;
		}
		throw new InvalidParameterException("Cannot input that type of value");
	}
	
	public CDouble toCDouble() {
		return new CDouble((double) val.intValue());
	}
	
	public CInt toCInt() {
		return this;
	}
}
