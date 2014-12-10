package com.czipperz.cLibrary.math.operators;

import com.czipperz.cLibrary.math.wrappers.CDouble;

public interface IUnaryOperation extends IOperation {
	public CDouble perform(CDouble[] vals);
	public CDouble perform(CDouble a);
	public double perform(double[] vals);
	public double perform(double a);
}
