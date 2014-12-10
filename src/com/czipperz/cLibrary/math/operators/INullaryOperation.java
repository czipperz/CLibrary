package com.czipperz.cLibrary.math.operators;

import com.czipperz.cLibrary.math.wrappers.CDouble;

public interface INullaryOperation extends IOperation {
	public CDouble perform(CDouble[] vals);
	public CDouble perform();
	public double perform(double[] vals);
}
