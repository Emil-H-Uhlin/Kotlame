package com.kotlame.physics

import com.kotlame.components.Component
import com.kotlame.math.Vector2

class PhysicsBody(var velocity: Vector2 = Vector2.zero,
                  var angleVelocity: Float = .0f,
                  var useGravity: Boolean = true,
                  var useDamping: Boolean = true,
                  var mass: Float = 1.0f,): Component() {

    fun addForce(force: Vector2) {
        velocity += force / mass
    }

    fun addAngleForce(amount: Number) {
        angleVelocity += amount.toFloat()
    }
}