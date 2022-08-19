package com.kotlame.gameobjects

import android.graphics.Canvas
import android.graphics.Paint
import com.kotlame.components.Component

class GameObject private constructor() {
    class Builder() {
        private val gameObject = GameObject()

        fun withComponent(component: Component) = apply {
            gameObject.addComponent(component)
        }

        fun build() = gameObject
    }

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