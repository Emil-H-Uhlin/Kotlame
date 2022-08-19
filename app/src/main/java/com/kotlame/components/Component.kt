package com.kotlame.components

import android.graphics.Canvas
import android.graphics.Paint
import com.kotlame.gameobjects.GameObject

abstract class Component {
    lateinit var gameObject: GameObject

    open fun initialize(): Unit? = null
    open fun update(): Unit? = null
    open fun draw(canvas: Canvas, paint: Paint?): Unit? = null
}