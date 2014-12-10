package com.czipperz.cLibrary.math.wrappers;

import java.security.InvalidParameterException;


public class CRangeInt extends CRange {
	private Integer val = 0, min = val, max = val;
	
	public CRangeInt(Object val) {
		super(val);
	}
	
	public CRangeInt(Object val, Object min, Object max) {
		super(val, min, max);
	}

	public Integer getMin() {
		return min;
	}

	public CRangeInt setMin(Object min) {
		if(this.hasBounds()) {
			if(min instanceof CVal) {
				this.min = ((CVal) min).toCInt().get();
				if(val < this.min) {
					val = this.min;
				}
			}
			if(min instanceof Integer) {
				this.min = (Integer) min;
				if(val < this.min) {
					val = this.min;
				}
			}
		}
		else {
			throw new InvalidParameterException("Have to call setBounds(min, max)");
		}
		return this;
	}

	public Integer getMax() {
		return max;
	}

	public CRangeInt setMax(Object max) {
		if(this.hasBounds()) {
			if(max instanceof CVal) {
				this.max = ((CVal) max).toCInt().get();
				if(val > this.max) {
					val = this.max;
				}
			}
			if(max instanceof Integer) {
				this.max = (Integer) max;
				if(val > this.max) {
					val = this.max;
				}
			}
		}
		else {
			throw new InvalidParameterException("Have to call setBounds(min, max)");
		}
		return this;
	}

	public Integer get() {
		return val;
	}

	public CRangeInt set(Object val) {
		Integer v = 0;
		if(val instanceof CVal) {
			v = ((CVal) val).toCInt().get();
		}
		else if(val instanceof Integer) {
			v = (Integer) val;
		}
		else {
			throw new InvalidParameterException();
		}
		if(this.hasBounds()) {
			if(v > min && v < max) {
				this.val = v;
			}
		}
		else {
			this.val = v;
		}
		return this;
	}

	public CRangeInt setRel(Object val) {
		Integer v = this.val;
		if(val instanceof CVal) {
			v += ((CVal) val).toCInt().get();
		}
		else if(val instanceof Integer) {
			v += (Integer) val;
		}
		else {
			throw new InvalidParameterException();
		}
		return this.set(v);
	}

	public CDouble toCDouble() {
		return new CDouble((double) this.get());
	}

	public CInt toCInt() {
		return new CInt(this.get().intValue());
	}
	
	public CPercent toCPercent() {
		int range = max + min;
		int disp = val - min;
		return new CPercent(disp / range, CPercent.Type.TYPE_1);
	}
}
