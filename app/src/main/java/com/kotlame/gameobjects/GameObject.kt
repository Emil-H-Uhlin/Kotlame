package com.kotlame.gameobjects

import android.graphics.Canvas
import android.graphics.Paint
import com.kotlame.components.Component
import com.kotlame.components.Transform
import com.kotlame.math.Vector2

class GameObject private constructor() {
    class Builder() {
        private val gameObject = GameObject()

        fun withComponent(component: Component) = apply {
            gameObject.addComponent(component)
        }

        fun withPosition(position: Vector2) = apply {
            gameObject.transform.position = position
        }

        fun withRotation(rotation: Float) = apply {
            gameObject.transform.rotation = rotation
        }

        fun build() = gameObject
    }

    val transform = Transform()
    val components = arrayListOf<Component>()

    var destroyed = false

    fun addComponent(component: Component): Boolean {
        if (components.add(component)) {
            component.gameObject = this
            component.initialize()

            return true
        }

        return false
    }

    fun update(deltaTime: Double) = components.forEach { it.update(deltaTime) }
    fun draw(canvas: Canvas, paint: Paint?) = components.forEach { it.draw(canvas, paint) }

    inline fun <reified componentType: Component> getComponent(): componentType? = components.find { component -> component is componentType } as componentType?
}