package io.czipperz.github.cLibrary.game.controller

import groovy.transform.SelfType

/**
 * Created by czipperz on 4/26/15.
 */
@SelfType(CControllerImmutable)
trait CControllerImmutableXBox {
    boolean isXPressed() {
        ((CControllerImmutable) this).buttonPressed[CControllerXBox.buttonX]
    }

    boolean isYPressed() {
        ((CControllerImmutable) this).buttonPressed[CControllerXBox.buttonY]
    }

    boolean isAPressed() {
        ((CControllerImmutable) this).buttonPressed[CControllerXBox.buttonA]
    }

    boolean isBPressed() {
        ((CControllerImmutable) this).buttonPressed[CControllerXBox.buttonB]
    }

    boolean isBackPressed() {
        ((CControllerImmutable) this).buttonPressed[CControllerXBox.buttonBack]
    }
}
