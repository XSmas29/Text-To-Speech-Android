package com.example.cobatexttospeech

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var tts : TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var edText = findViewById<EditText>(R.id.edText)
        var btnSpeak = findViewById<Button>(R.id.btnSpeak)

        btnSpeak.setOnClickListener {
            Toast.makeText(applicationContext, "TEST", Toast.LENGTH_SHORT).show()
            tts = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
                if (it==TextToSpeech.SUCCESS){
                    tts.language = Locale("ID");
                    tts.setSpeechRate(0.8f)
                    tts.speak(edText.text.toString(), TextToSpeech.QUEUE_ADD, null)

                }
                Toast.makeText(applicationContext, "" + it, Toast.LENGTH_SHORT).show()
            })
        }
    }
}