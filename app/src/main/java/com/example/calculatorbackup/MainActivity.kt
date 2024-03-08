package com.example.calculatorbackup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //너무 급해서 숫자버튼 하드코딩
        val bt_0 = findViewById<Button>(R.id.bt_zero)
        val bt_1 = findViewById<Button>(R.id.bt_one)
        val bt_2 = findViewById<Button>(R.id.bt_two)
        val bt_3 = findViewById<Button>(R.id.bt_three)
        val bt_4 = findViewById<Button>(R.id.bt_four)
        val bt_5 = findViewById<Button>(R.id.bt_five)
        val bt_6 = findViewById<Button>(R.id.bt_six)
        val bt_7 = findViewById<Button>(R.id.bt_seven)
        val bt_8 = findViewById<Button>(R.id.bt_eight)
        val bt_9 = findViewById<Button>(R.id.bt_nine)
        //사칙연산
        val bt_add = findViewById<Button>(R.id.bt_add)
        val bt_subtract = findViewById<Button>(R.id.bt_subtract)
        val bt_multiply = findViewById<Button>(R.id.bt_multiply)
        val bt_divide = findViewById<Button>(R.id.bt_divide)
        //=, C
        val bt_equals = findViewById<Button>(R.id.bt_equals)
        val bt_clear = findViewById<Button>(R.id.bt_clear)
        //텍스트뷰 불러오기
        val tv_calLog = findViewById<TextView>(R.id.tv_calLog) //현재입력
        val tv_resultLog = findViewById<TextView>(R.id.tv_resultLog) //최종결과
        //계산 위한 따로저장 인스턴스 String들
        var calLog: String = ""
        var resultLog: String = ""
        var operators: String = ""

        //숫자 버튼이 눌릴 때
        bt_0.setOnClickListener { calLog += bt_0.text; tv_calLog.text = calLog }
        bt_1.setOnClickListener { calLog += bt_1.text; tv_calLog.text = calLog }
        bt_2.setOnClickListener { calLog += bt_2.text; tv_calLog.text = calLog }
        bt_3.setOnClickListener { calLog += bt_3.text; tv_calLog.text = calLog }
        bt_4.setOnClickListener { calLog += bt_4.text; tv_calLog.text = calLog }
        bt_5.setOnClickListener { calLog += bt_5.text; tv_calLog.text = calLog }
        bt_6.setOnClickListener { calLog += bt_6.text; tv_calLog.text = calLog }
        bt_7.setOnClickListener { calLog += bt_7.text; tv_calLog.text = calLog }
        bt_8.setOnClickListener { calLog += bt_8.text; tv_calLog.text = calLog }
        bt_9.setOnClickListener { calLog += bt_9.text; tv_calLog.text = calLog }

        bt_add.setOnClickListener {calLog += "+"; tv_calLog.text = calLog; operators += "+"}
        bt_subtract.setOnClickListener {calLog += "-"; tv_calLog.text = calLog; operators += "-"}
        bt_multiply.setOnClickListener {calLog += "*"; tv_calLog.text = calLog; operators += "*"}
        bt_divide.setOnClickListener {calLog += "/"; tv_calLog.text = calLog; operators += "/"}

        bt_clear.setOnClickListener { calLog = ""; tv_calLog.text = calLog
            resultLog = ""; tv_resultLog.text = resultLog}
        bt_equals.setOnClickListener {

        resultLog = calLog; var splitResults = resultLog.split("+", "-", "*", "/")
        var reallyOperates = 0f
        for (splitResult in splitResults) {
            reallyOperates = Simple().calAdd(reallyOperates, splitResult.toFloat())
        }
        tv_resultLog.text = reallyOperates.toString()
        calLog = ""; tv_calLog.text = calLog
        }

    }
}