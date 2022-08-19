package com.kotlame.gameobjects

import android.graphics.Canvas
import android.graphics.Paint
import com.kotlame.component.Component

class GameObject private constructor() {
    class Builder() {
        private val gameObject = GameObject()

        fun withComponent(component: Component) = apply {
            gameObject.addComponent(component)
        }
    }

    private val components = arrayListOf<Component>()

    var destroyed = false

    fun addComponent(component: Component): Boolean {
        if (components.add(component)) {

        }

        return false
    }

    fun update(deltaTime: Double) = components.forEach { }
    fun draw(canvas: Canvas, paint: Paint?) = components.forEach { }
}