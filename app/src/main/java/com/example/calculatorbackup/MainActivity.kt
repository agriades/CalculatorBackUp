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
        //resultLog라는 말이 이미 있어서 무한로딩, 강제종료 이슈가 생겼나..???
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
        val tv_calLog = findViewById<TextView>(R.id.tv_calLog) // = 누르기 전 현재입력이 출력되는 텍스트뷰
        val tv_resultLog = findViewById<TextView>(R.id.tv_resultLog) //최종결과가 출력되는 텍스트뷰
        //계산 위한 따로저장 인스턴스 String들
        var calLog: String = "" //버튼 입력에 따라 현재입력에 문자를 하나씩 추가할 String 변수
        var operators: String = "" //split으로 쪼개느라 사라진 연산자들을 차례로 저장할 String 변수


        var resLog: String = ""


        //숫자 버튼이 눌릴 때 calLog 인스턴스에 저장 > 텍스트뷰의 글자로 보내기
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

        //사칙연산 기호가 눌릴 때 calLog 인스턴스에 저장 > 텍스트뷰의 글자로 보내기, 오퍼레이터스에도 문자열 쌓아두기
        bt_add.setOnClickListener {calLog += "+"; tv_calLog.text = calLog; operators += "+"}
        bt_subtract.setOnClickListener {calLog += "-"; tv_calLog.text = calLog; operators += "-"}
        bt_multiply.setOnClickListener {calLog += "*"; tv_calLog.text = calLog; operators += "*"}
        bt_divide.setOnClickListener {calLog += "/"; tv_calLog.text = calLog; operators += "/"}

        //여태까지는 계산 결과값이 안 뜨다가, = 기호를 누르면 나와야 한다.
        bt_equals.setOnClickListener {
        resLog = calLog //여태까지 개무시했던 resLog에 우선 String을 저장한다.
        println(resLog.split("+", "-", "*", "/")); println(operators)

        var numList = resLog.split("+", "-", "*", "/") //여태까지 입력된 수의 list
        for (i in numList.indices) {
            when (operators[i]) { //문자열을 인덱스로 끊어두면 나오는 건 String이 아닌 Char!
                '+' -> resLog = Simple().calAdd(numList[i], numList[i+1])
                '-' -> resLog = Simple().calSubtract(numList[i], numList[i+1])
                '*' -> resLog = Simple().calMultiply(numList[i], numList[i+1])
                '/' -> resLog = Simple().calDivide(numList[i], numList[i+1])
                else -> continue //얘가 없었어서 강종이 계속 됐나?
            }
        }


        //calLog, operators, resLog 초기화 및 텍스트뷰에 반영 (아래와 똑같음)
        tv_resultLog.text = resLog
        println(tv_resultLog)
        resLog = ""


        //C 버튼 눌렀을 때 calLog, operators, resLog 초기화 및 텍스트뷰에 반영
        bt_clear.setOnClickListener {
            calLog = ""; tv_calLog.text = calLog
            operators = "";
            resLog = ""; tv_resultLog.text = resLog
        }
    }
}

}