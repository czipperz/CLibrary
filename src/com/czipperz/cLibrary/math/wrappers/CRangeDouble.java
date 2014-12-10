package com.czipperz.cLibrary.math.wrappers;

import java.security.InvalidParameterException;


public class CRangeDouble extends CRange {
	private Double val = 0.0, min = val, max = val;
	
	public CRangeDouble(Object val) {
		super(val);
	}
	
	public CRangeDouble(Object val, Object min, Object max) {
		super(val, min, max);
	}

	public Double getMin() {
		return min;
	}

	public CRangeDouble setMin(Object min) {
		if(this.hasBounds()) {
			if(min instanceof CVal) {
				this.min = ((CVal) min).toCDouble().get();
				if(val < this.min) {
					val = this.min;
				}
			}
			if(min instanceof Double) {
				this.min = (Double) min;
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

	public Double getMax() {
		return max;
	}

	public CRangeDouble setMax(Object max) {
		if(this.hasBounds()) {
			if(max instanceof CVal) {
				this.max = ((CVal) max).toCDouble().get();
				if(val > this.max) {
					val = this.max;
				}
			}
			if(max instanceof Double) {
				this.max = (Double) max;
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

	public Double get() {
		return val;
	}

	public CRangeDouble set(Object val) {
		Double v = 0.0;
		if(val instanceof CVal) {
			v = ((CVal) val).toCDouble().get();
		}
		else if(val instanceof Double) {
			v = (Double) val;
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

	public CRangeDouble setRel(Object val) {
		Double v = this.val;
		if(val instanceof CVal) {
			v += ((CVal) val).toCDouble().get();
		}
		else if(val instanceof Double) {
			v += (Double) val;
		}
		else {
			throw new InvalidParameterException();
		}
		return this.set(v);
	}

	public CDouble toCDouble() {
		return new CDouble(this.get());
	}

	public CInt toCInt() {
		return new CInt(this.get().intValue());
	}
	
	public CPercent toCPercent() {
		double range = max + min;
		double disp = val - min;
		return new CPercent(disp / range, CPercent.Type.TYPE_1);
	}
}
