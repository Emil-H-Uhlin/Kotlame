package com.kotlame.math

import kotlin.math.abs
import kotlin.math.sqrt

data class Vector2(var x: Float, var y: Float) {
    constructor(x: Number, y: Number): this(x.toFloat(), y.toFloat())

    companion object {
        val zero = Vector2(0, 0); get() = field.copy()
        val one = Vector2(1, 1); get() = field.copy()
        val right = Vector2(1, 0); get() = field.copy()
        val left = Vector2(-1, 0); get() = field.copy()
        val up = Vector2(0, -1); get() = field.copy()
        val down = Vector2(0, 1); get() = field.copy()

        fun distance(vector: Vector2, other: Vector2) = (other - vector).length
    }

    val length get() = sqrt(lengthSquared)
    val lengthSquared get() = x * x + y * y

    fun normalize() {
        if (abs(length) < 1e-10)
            return

        x /= length
        y /= length
    }

    inline val normalized
        get() = copy().apply {
            normalize()
        }

    operator fun plus(other: Vector2) = Vector2(x + other.x, y + other.y)

    operator fun times(value: Float) = Vector2(x * value, y * value)

    operator fun div(value: Float) = Vector2(x / value, y / value)

    operator fun minus(other: Vector2) = Vector2(x - other.x, y - other.y)

    operator fun unaryMinus() = Vector2(-x, -y)
}
