package io.czipperz.github.cLibrary.util

/**
 * Created by czipperz on 4/9/15.
 */
final class CClosureHelper {
	private CClosureHelper() {}

	/**
	 * Performs a command for each object in an array
	 * @param list
	 * @param fail - return true if the final Closure is going to be skipped
	 * @param command
	 */
	static <T> void forEach(List<T> list, Closure<Boolean> fail, Closure command) {
		for(T t : list) {
			if(!fail(t))
				command(t)
		}
	}
}
