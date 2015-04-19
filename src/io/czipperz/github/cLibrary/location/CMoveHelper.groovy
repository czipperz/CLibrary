package io.czipperz.github.cLibrary.location

import java.awt.geom.Point2D

/**
* @author czipperz on 4/8/15.
*/
abstract class CMoveHelper {
	static <E extends Point2D> E moveTowardOneTick(E current, E goal, int speed) {
		E result = current
		def x1 = current.x
		def x2 = goal.x
		def y1 = current.y
		def y2 = goal.y
		def distanceX = x2 - x1
		def distanceY = y2 - y1
		def distancePy = current.distance(goal)
		def div = distancePy / speed
		result.setLocation(x1 + distanceX / div, y2 + distanceY / div)
		result
	}

	static <E extends Point2D> E moveTowardOneTickNoOvershoot(E current, E goal, int speed) {
		E result = moveTowardOneTick(current, goal, speed)
		if(current.x < goal.x && result.x > goal.x)
			result.setLocation(goal.x, result.y)
		else if(current.x > goal.x && result.x < goal.x)
			result.setLocation(goal.x, result.y)
		if(current.y < goal.y && result.y > goal.y)
			result.setLocation(result.x, goal.y)
		else if(current.y > goal.y && result.y < goal.y)
			result.setLocation(result.x, goal.y)
		result
	}
}
