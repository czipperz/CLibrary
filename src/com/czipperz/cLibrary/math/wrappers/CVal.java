package com.czipperz.cLibrary.math.wrappers;

import com.czipperz.cLibrary.math.IMathType;

public abstract class CVal implements IMathType {
	public CVal(Object val) {
		this.set(val);
	}
	
	public abstract Object get();
	
	public abstract CVal set(Object val);
	public abstract CVal setRel(Object val);
	
	public abstract CDouble toCDouble();
	
	public abstract CInt toCInt();
	
	public boolean equals(Object o) {
		if(o instanceof CVal) {
			return ((CVal) o).get() == get();
		}
		return super.equals(o);
	}
}
