package io.github.czipperz.cLibrary.commands

/**
 * Created by czipperz on 4/9/15.
 */
class CCommandParameter {
	@Delegate final CCommandParameterType type
	private ArrayList<String> values

	CCommandParameter(CCommandParameterType type, ArrayList<String> values = new ArrayList<>()) {
		this.type = type
		this.values = values
	}

	CCommandParameter(CCommandParameterType type, String value) {
		this(type)
		values.add value
	}

	ArrayList<String> getAdditionalValues() {
		return values
	}
}
