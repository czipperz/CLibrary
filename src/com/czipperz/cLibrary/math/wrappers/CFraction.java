package com.czipperz.cLibrary.math.wrappers;

import java.security.InvalidParameterException;

public class CFraction extends CVal {
	private CDouble top, bot;
	
	public CFraction() {
		this(new CDouble(1.0));
	}
	
	public CFraction(CDouble top) {
		this(top, new CDouble(1.0));
	}
	
	public CFraction(CDouble top, CDouble bot) {
		super(top.get() / bot.get());
		this.top = top;
		this.bot = bot;
	}

	public CDouble get() {
		return new CDouble(top.get() / bot.get());
	}

	public CFraction set(Object val) {
		if(val instanceof Double) {
			top.set(((Double) val));
			bot.set(1);
			return this;
		}
		if(val instanceof CFraction) {
			top.set(((CFraction) val).getTop());
			bot.set(((CFraction) val).getBot());
			return this;
		}
		if(val instanceof CVal) {
			top.set(((CVal) val).toCDouble().get());
			bot.set(1);
			return this;
		}
		throw new InvalidParameterException("Cannot input that type of value");
	}

	public CFraction setRel(Object val) {
		if(val instanceof Double) {
			top.setRel(((Double) val) * bot.get());
			return this;
		}
		if(val instanceof CVal) {
			top.setRel(((CVal) val).toCDouble().get());
			bot.set(1);
			return this;
		}
		throw new InvalidParameterException("Cannot input that type of value");
	}

	public CDouble toCDouble() {
		return get();
	}

	public CInt toCInt() {
		return get().toCInt();
	}

	public CDouble getTop() {
		return top;
	}

	public CDouble getBot() {
		return bot;
	}
}
