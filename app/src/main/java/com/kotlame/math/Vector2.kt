package com.kotlame.math

data class Vector2(var x: Float, var y: Float) {
    constructor(x: Number, y: Number): this(x.toFloat(), y.toFloat())

    companion object {
        val zero = Vector2(0, 0); get() = field.copy()
        val one = Vector2(1, 1); get() = field.copy()
        val right = Vector2(1, 0); get() = field.copy()
        val left = Vector2(-1, 0); get() = field.copy()
        val up = Vector2(0, -1); get() = field.copy()
        val down = Vector2(0, 1); get() = field.copy()
    }
}
