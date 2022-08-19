package com.kotlame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.kotlame.game.Game

class GameActivity : AppCompatActivity() {
    lateinit var game: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val frame = FrameLayout(this)

        game = Game(this)

        frame.addView(game)
        setContentView(frame)
    }

    override fun onResume() {
        super.onResume()
        game.resume()
    }

    override fun onPause() {
        super.onPause()
        game.pause()
    }
}