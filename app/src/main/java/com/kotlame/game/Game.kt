package com.kotlame.game

import android.content.Context
import android.view.SurfaceView

class Game(ctx: Context): SurfaceView(ctx) {
    @Volatile var running = false

    fun resume() {
        running = true
    }

    fun pause() {
        running = false
    }
}