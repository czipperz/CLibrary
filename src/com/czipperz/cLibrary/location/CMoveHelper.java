package com.czipperz.cLibrary.location;

import java.awt.geom.Point2D;

public abstract class CMoveHelper {
	/**
	 * Moves the Point2D towards the goal at the speed of the parameter speed.
	 * @param current - the current location.
	 * @param goal - the location the Point2D should go to.
	 * @param speed - the distance in which the Point2D shall travel.
	 * @return the new location.
	 */
	public static <E extends Point2D> E moveTowardOneTick(E current, E goal, int speed) {
		E result = current;
		double x1 = current.getX();
		double x2 = goal.getY();
		double y1 = current.getY();
		double y2 = goal.getY();
		double distanceX = x2 - x1;
		double distanceY = y2 - y1;
		double distancePy = current.distance(goal);
		double div = distancePy / speed;
		result.setLocation(x1 + distanceX / div, x2 + distanceY / div);
		return result;
	}

	public static <E extends Point2D> E moveTowardOneTickNoOvershoot(E current, E goal, int speed) {
		E result = moveTowardOneTick(current, goal, speed);
		while(true) {
			if(current.getX() < goal.getX() && result.getX() > goal.getX()) {
				result.setLocation(goal.getX(), result.getY());
				break;
			}
			if(current.getX() > goal.getX() && result.getX() < goal.getX()) {
				result.setLocation(goal.getX(), result.getY());
			}
			break;
		}
		while(true) {
			if(current.getY() < goal.getY() && result.getY() > goal.getY()) {
				result.setLocation(result.getX(), goal.getY());
				break;
			}
			if(current.getY() > goal.getY() && result.getY() < goal.getY()) {
				result.setLocation(result.getX(), goal.getY());
			}
			break;
		}
		return result;
	}
}
