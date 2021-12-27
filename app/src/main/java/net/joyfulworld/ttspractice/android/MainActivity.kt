package net.joyfulworld.ttspractice.android

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.ERROR
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var tts: TextToSpeech
    private var editText: EditText? = null
    private var button01: Button? = null
    private var button02: Button? = null
    private var button03: Button? = null
    private var button04: Button? = null
    private var button05: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
    }

    private fun setupUI() {
        editText = findViewById<View>(R.id.editText) as EditText
        button01 = findViewById<View>(R.id.button01) as Button
        button02 = findViewById<View>(R.id.button02) as Button
        button03 = findViewById<View>(R.id.button03) as Button
        button04 = findViewById<View>(R.id.button04) as Button
        button05 = findViewById<View>(R.id.button05) as Button

        // TTS를 생성하고 OnInitListener로 초기화 한다.
        tts = TextToSpeech(this) { status ->
            if (status != ERROR) {
                // 언어를 선택한다.
                tts.language = Locale.KOREAN
            }
        }

        button01?.setOnClickListener {
            Log.d("TEST", "onClick: $tts")
            // editText에 있는 문장을 읽는다.
            tts.speak(editText?.text.toString(), TextToSpeech.QUEUE_FLUSH, null, "123")
        }
        button02?.setOnClickListener {
            tts.setPitch(2.0f) // 음성 톤을 2.0배 올려준다.
            tts.setSpeechRate(1.0f) // 읽는 속도는 기본 설정
            // editText에 있는 문장을 읽는다.
            tts.speak(editText?.text.toString(), TextToSpeech.QUEUE_FLUSH, null, "123")
        }
        button03?.setOnClickListener {
            tts.setPitch(0.5f) // 음성 톤을 0.5배 내려준다.
            tts.setSpeechRate(1.0f) // 읽는 속도는 기본 설정
            // editText에 있는 문장을 읽는다.
            tts.speak(editText?.text.toString(), TextToSpeech.QUEUE_FLUSH, null, "123")
        }
        button04?.setOnClickListener {
            tts.setPitch(1.0f) // 음성 톤은 기본 설정
            tts.setSpeechRate(2.0f) // 읽는 속도를 2배 빠르기로 설정
            // editText에 있는 문장을 읽는다.
            tts.speak(editText?.text.toString(), TextToSpeech.QUEUE_FLUSH, null, "123")
        }
        button05?.setOnClickListener {
            tts.setPitch(1.0f) // 음성 톤은 기본 설정
            tts.setSpeechRate(0.5f) // 읽는 속도를 0.5빠르기로 설정
            // editText에 있는 문장을 읽는다.
            tts.speak(editText?.text.toString(), TextToSpeech.QUEUE_FLUSH, null, "123")
        }
    }
}