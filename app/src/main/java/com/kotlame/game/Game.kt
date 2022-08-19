package com.kotlame.game

import android.content.Context
import android.view.SurfaceView
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class Game(ctx: Context): SurfaceView(ctx) {
    @Volatile var running = false

    fun resume() = MainScope().launch {
        running = true

        while (running) {
            update()
            draw()
        }
    }

    fun pause() {
        running = false
    }

    private fun update() {
        
    }

    private fun draw() {
        if (!holder.surface.isValid) return

        val canvas = holder.lockCanvas()

        /* Draw your game objects */

        canvas.restore()

        /* Draw UI */

        holder.unlockCanvasAndPost(canvas)
    }
}