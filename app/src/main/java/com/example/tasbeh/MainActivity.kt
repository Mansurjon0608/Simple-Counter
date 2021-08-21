package com.example.tasbeh

import android.content.Context
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val kesh = getSharedPreferences("Kesh", Context.MODE_PRIVATE)
        val editor = kesh.edit()
        var click = 0

        click=kesh.getInt("key0", 0)
        txt_view.text = click.toString()


        btn_count.setOnClickListener {
            click++
            txt_view.text=click.toString()
            editor.putInt("key0", txt_view.text.toString().toInt())
            editor.apply()

            val mediaPlayer = MediaPlayer.create(this, R.raw.mixkit)
            mediaPlayer.start()

        }


        btn_clear.setOnClickListener {
            click = 0
            txt_view.text = click.toString()

            editor.putInt("key0", 0)
            editor.apply()

            val mediaPlayer = MediaPlayer.create(this, R.raw.juntos)
            mediaPlayer.start()



        }
    }
}