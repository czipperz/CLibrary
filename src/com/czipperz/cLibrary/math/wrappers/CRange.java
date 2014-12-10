package com.czipperz.cLibrary.math.wrappers;


public abstract class CRange extends CVal {
	private boolean bounds = false;

	public CRange(Object val) {
		super(val);
		removeBounds();
	}

	public CRange(Object val, Object min, Object max) {
		super(val);
		setBounds(min, max);
	}

	public abstract Object getMin();
	public abstract CRange setMin(Object min);

	public abstract Object getMax();
	public abstract CRange setMax(Object max);

	public abstract Object get();

	public boolean hasBounds() {
		return bounds;
	}
	
	public boolean isBounded() {
		return hasBounds();
	}

	public CRange setBounds(Object min, Object max) {
		bounds = true;
		this.setMin(min);
		this.setMax(max);
		return this;
	}

	public CRange removeBounds() {
		synchronized(this) {
			this.setMin(0.0);
			this.setMax(0.0);
		}
		bounds = false;
		return this;
	}
	
	public abstract CPercent toCPercent();
}
