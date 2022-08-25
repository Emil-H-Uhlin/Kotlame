package com.kotlame.game

import android.content.Context
import android.view.SurfaceView
import com.kotlame.gameobjects.GameObject
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class Game(ctx: Context): SurfaceView(ctx) {
    @Volatile var running = false

    var prevFrameTime: Long = -1

    private val deltaTime get() = (System.currentTimeMillis() - prevFrameTime).toDouble() / 1000
    private val scaledDeltaTime get() = deltaTime * timeScale;

    private var gameObjects = listOf<GameObject>()

    companion object {
        @JvmStatic var timeScale = 1.0f
    }

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

    private fun update(deltaTime: Double = scaledDeltaTime) {

        gameObjects.forEach { it.update(deltaTime) }
        gameObjects = gameObjects.filter { !it.destroyed }

        /* Put game logic */

        prevFrameTime = System.currentTimeMillis()
    }

    private fun draw() {
        if (!holder.surface.isValid) return

        val canvas = holder.lockCanvas()

        gameObjects.forEach { it.draw(canvas, null) }

        canvas.restore()


        /* Draw UI */


        holder.unlockCanvasAndPost(canvas)
    }
}