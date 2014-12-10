package com.czipperz.cLibrary.math.operators;

import com.czipperz.cLibrary.math.wrappers.CDouble;

public interface IArityOperation extends IOperation {
	public CDouble perform(CDouble[] vals);
	public double perform(double[] vals);
}
