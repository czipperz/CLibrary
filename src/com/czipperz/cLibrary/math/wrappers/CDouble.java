package com.czipperz.cLibrary.math.wrappers;

import java.security.InvalidParameterException;

public class CDouble extends CVal {
	private Double val;
	
	public CDouble() {
		this(0.0);
	}
	
	public CDouble(Double val) {
		super(val);
	}
	
	public Double get() {
		return val;
	}

	public CVal set(Object val) {
		if(val instanceof Double) {
			this.val = ((Double) val);
			return this;
		}
		if(val instanceof CVal) {
			this.val = ((CVal) val).toCDouble().get();
			return this;
		}
		throw new InvalidParameterException("Cannot input that type of value");
	}

	public CVal setRel(Object val) {
		if(val instanceof Double) {
			this.val += ((Double) val);
			return this;
		}
		if(val instanceof CVal) {
			this.val += ((CVal) val).toCDouble().get();
			return this;
		}
		throw new InvalidParameterException("Cannot input that type of value");
	}
	
	public CDouble toCDouble() {
		return this;
	}
	
	public CInt toCInt() {
		return new CInt(val.intValue());
	}
}
