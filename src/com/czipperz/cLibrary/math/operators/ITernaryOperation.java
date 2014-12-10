package com.czipperz.cLibrary.math.operators;

import com.czipperz.cLibrary.math.wrappers.CDouble;

public interface ITernaryOperation extends IOperation {
	public CDouble perform(CDouble[] vals);
	public CDouble perform(CDouble a, CDouble b, CDouble c);
	public double perform(double[] vals);
	public double perform(double a, double b, double c);
}
