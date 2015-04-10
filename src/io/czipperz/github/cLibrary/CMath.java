package io.czipperz.github.cLibrary;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class CMath {
	public static final int INT_POS_INF = Integer.MAX_VALUE;
	public static final int INT_NEG_INF = -Integer.MIN_VALUE;
	public static final long LONG_POS_INF = Long.MAX_VALUE;
	public static final long LONG_NEG_INF = Long.MIN_VALUE;
	
	public static Point toPoint(Point2D p) {
		return new Point((int) p.getX(), (int) p.getY());
	}
	
	public static boolean chanceIn(int i) {
		return ((int) (Math.random() * i) == i - 1);
	}
	
	public static double roundUp(double toRound, double interval) {
		return toRound + interval - (toRound % interval);
	}
	
	public static double roundDown(double toRound, double interval) {
		return toRound - (toRound % interval);
	}
	
	public static double round(double toRound, double interval) {
		double up = roundUp(toRound, interval);
		double down = roundDown(toRound, interval);
		double u = up - toRound;
		double d = toRound - down;
		if(u > d) {
			return down;
		}
		if(u < d) {
			return up;
		}
		return up;
	}
	
	public static double sqrt(double x) {
		return Math.sqrt(x);
	}
	
	public static double squareRoot(double x) {
		return Math.sqrt(x);
	}

	public static double distanceTo(Point a, Point b) {
		double result = 0;
		double first = power(b.x - a.x, 2);
		double second = power(b.y - a.y, 2);
		
		result = sqrt(first + second);

		return result;
	}

	public static int nCr(int n, int r) {
		if(n == 0 && r == 1) {
			return 0;
		}
		int result = 0;
		result = (factorial(n))/(factorial(r) * factorial(n-r));
		return result;
	}

	public static int nPr(int n, int r) {
		if(n == 0 && r == 1) {
			return 0;
		}
		int result = 0;
		result = (factorial(n))/(factorial(r));
		return result;
	}

	public static int factorial(int num) {
		int result = 1;
		for(int i = 1; i <= num; i++) {
			result = result * i;
		}
		return result;
	}

	public static class PythagorianTheorem {
		public static double findHypotenuse(double a, double b) {
			return power(power(a, 2) + power(b, 2), .5);
		}
		
		public static double findSide(double a, double c) {
			return power(power(c,2) - power(a,2), .5);
		}
	}

	public static double power(double i, double power) {
		return Math.pow(i, power);
	}
	
	public static int smallestOf(int[] i) {
		int result = i[0];
		for(int x = 0; x < i.length; x++) {
			if(i[x] < result) {
				result = i[x];
			}
		}
		return result;
	}
	
	public static int largestOf(int[] i) {
		int result = i[0];
		for(int x = 0; x < i.length; x++) {
			if(i[x] > result) {
				result = i[x];
			}
		}
		return result;
	}

	public String toString() {
		return "A MathHelper";
	}
}