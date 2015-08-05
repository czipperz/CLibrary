package io.czipperz.github.cLibrary.location;

import java.awt.geom.Point2D;

/**
* @author czipperz on 4/8/15.
*/
public abstract class CMoveHelper {
	public static <E extends Point2D> E moveTowardOneTick(E current, E goal, int speed) {
		E result = current;
		double x1 = current.x;
		double x2 = goal.x;
		double y1 = current.y;
		double y2 = goal.y;
		double distanceX = x2 - x1;
		double distanceY = y2 - y1;
		double distancePy = current.distance(goal);
		double div = distancePy / speed;
		result.setLocation(x1 + distanceX / div, y2 + distanceY / div);
		return result;
	}

	public static <E extends Point2D> E moveTowardOneTickNoOvershoot(E current, E goal, int speed) {
		E result = moveTowardOneTick(current, goal, speed);
		if(current.x < goal.x && result.x > goal.x)
			result.setLocation(goal.x, result.y);
		else if(current.x > goal.x && result.x < goal.x)
			result.setLocation(goal.x, result.y);
		if(current.y < goal.y && result.y > goal.y)
			result.setLocation(result.x, goal.y);
		else if(current.y > goal.y && result.y < goal.y)
			result.setLocation(result.x, goal.y);
		return result;
	}
}
