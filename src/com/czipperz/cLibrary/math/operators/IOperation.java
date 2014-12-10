package com.czipperz.cLibrary.math.operators;

import com.czipperz.cLibrary.math.wrappers.CDouble;

public interface IOperation {
	/**
	 * Performs the operation by calling the perform method defined by the subclass with the values passed in.
	 * The {@link com.czipperz.cLibrary.math.operators.INullaryOperation} class will discard all values passed in, so passing in null is fine.
	 * @param vals - the values to be used by the subclass to perform the operation.
	 * @return {@link CDouble} - the result of the performance.
	 */
	public CDouble perform(CDouble[] vals);
	/**
	 * Performs the operation by calling the perform method defined by the subclass with the values passed in.
	 * The {@link com.czipperz.cLibrary.math.operators.INullaryOperation} class will discard all values passed in, so passing in null is fine.
	 * @param vals - the values to be used by the subclass to perform the operation.
	 * @return double - the result of the performance.
	 */
	public double perform(double[] vals);
}
