package com.kotlame.components

import com.kotlame.math.Vector2

data class Transform(var position: Vector2 = Vector2.zero, var rotation: Float = .0f): Component()
