package io.czipperz.github.cLibrary.game.controller

import groovy.transform.SelfType

/**
 * Created by czipperz on 4/26/15.
 */
@SelfType(CControllerImmutable)
trait CControllerImmutablePS3 {
    boolean isCrossPressed() {
        ((CControllerImmutable) this).buttonPressed[CControllerPS3.buttonCross]
    }

    boolean isCirclePressed() {
        ((CControllerImmutable) this).buttonPressed[CControllerPS3.buttonCircle]
    }

    boolean isTrianglePressed() {
        ((CControllerImmutable) this).buttonPressed[CControllerPS3.buttonTriangle]
    }

    boolean isSquarePressed() {
        ((CControllerImmutable) this).buttonPressed[CControllerPS3.buttonSquare]
    }

    boolean isSelectPressed() {
        ((CControllerImmutable) this).buttonPressed[CControllerPS3.buttonSelect]
    }
}