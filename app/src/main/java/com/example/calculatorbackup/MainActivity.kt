package com.example.calculatorbackup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //너무 급해서 숫자버튼 하드코딩
        //resultLog라는 말이 이미 있어서 무한로딩, 강제종료 이슈가 생겼나..???
        val bt0 = findViewById<Button>(R.id.bt_zero)
        val bt1 = findViewById<Button>(R.id.bt_one)
        val bt2 = findViewById<Button>(R.id.bt_two)
        val bt3 = findViewById<Button>(R.id.bt_three)
        val bt4 = findViewById<Button>(R.id.bt_four)
        val bt5 = findViewById<Button>(R.id.bt_five)
        val bt6 = findViewById<Button>(R.id.bt_six)
        val bt7 = findViewById<Button>(R.id.bt_seven)
        val bt8 = findViewById<Button>(R.id.bt_eight)
        val bt9 = findViewById<Button>(R.id.bt_nine)
        //사칙연산
        val btAdd = findViewById<Button>(R.id.bt_add)
        val btSubtract = findViewById<Button>(R.id.bt_subtract)
        val btMultiply = findViewById<Button>(R.id.bt_multiply)
        val btDivide = findViewById<Button>(R.id.bt_divide)
        //=, C
        val btEquals = findViewById<Button>(R.id.bt_equals)
        val btClear = findViewById<Button>(R.id.bt_clear)
        //텍스트뷰 불러오기
        val tvCalLog = findViewById<TextView>(R.id.tv_calLog) // = 누르기 전 현재입력이 출력되는 텍스트뷰
        val tvResultLog = findViewById<TextView>(R.id.tv_resultLog) //최종결과가 출력되는 텍스트뷰
        //계산 위한 따로저장 인스턴스 String들
        var calLog = "" //버튼 입력에 따라 현재입력에 문자를 하나씩 추가할 String 변수
        var operators = "" //split으로 쪼개느라 사라진 연산자들을 차례로 저장할 String 변수


        //숫자 버튼이 눌릴 때 calLog 인스턴스에 저장 > 텍스트뷰의 글자로 보내기
        bt0.setOnClickListener { calLog += bt0.text; tvCalLog.text = calLog }
        bt1.setOnClickListener { calLog += bt1.text; tvCalLog.text = calLog }
        bt2.setOnClickListener { calLog += bt2.text; tvCalLog.text = calLog }
        bt3.setOnClickListener { calLog += bt3.text; tvCalLog.text = calLog }
        bt4.setOnClickListener { calLog += bt4.text; tvCalLog.text = calLog }
        bt5.setOnClickListener { calLog += bt5.text; tvCalLog.text = calLog }
        bt6.setOnClickListener { calLog += bt6.text; tvCalLog.text = calLog }
        bt7.setOnClickListener { calLog += bt7.text; tvCalLog.text = calLog }
        bt8.setOnClickListener { calLog += bt8.text; tvCalLog.text = calLog }
        bt9.setOnClickListener { calLog += bt9.text; tvCalLog.text = calLog }

        //사칙연산 기호가 눌릴 때 calLog 인스턴스에 저장 > 텍스트뷰의 글자로 보내기, 오퍼레이터스에도 문자열 쌓아두기
        btAdd.setOnClickListener {calLog += "+"; tvCalLog.text = calLog; operators += "+"}
        btSubtract.setOnClickListener {calLog += "-"; tvCalLog.text = calLog; operators += "-"}
        btMultiply.setOnClickListener {calLog += "*"; tvCalLog.text = calLog; operators += "*"}
        btDivide.setOnClickListener {calLog += "/"; tvCalLog.text = calLog; operators += "/"}

        //여태까지는 계산 결과값이 안 뜨다가, = 기호를 누르면 나와야 한다.
        btEquals.setOnClickListener {
            var resLog = calLog //여태까지 개무시했던 resLog에 우선 String을 저장한다.
            val numList = resLog.split("+", "-", "*", "/") //여태까지 입력된 수의 list
            Log.e("TAG", "${numList.indices}")
            for (i in numList.indices) {
                if (i < operators.length && numList[0].isNotEmpty()) { //아예 사칙연산만 눌렀을 때에도 예외 처리!
                    resLog = when (operators[i]) { //문자열을 인덱스로 끊어두면 나오는 건 String이 아닌 Char!
                        '+' -> Simple().calAdd(numList[i], numList.getOrNull(i+1) ?:"")
                        '-' -> Simple().calSubtract(numList[i], numList.getOrNull(i+1) ?:"")
                        '*' -> Simple().calMultiply(numList[i], numList.getOrNull(i+1) ?:"")
                        '/' -> Simple().calDivide(numList[i], numList.getOrNull(i+1) ?:"")
                        else -> resLog //얘가 없었어서 강종이 계속 됐나?
                }
            }
            tvResultLog.text = resLog; println(resLog)
            calLog = ""; tvCalLog.text = calLog; operators = ""
        } //calLog, operators, resLog 초기화 및 텍스트뷰에 반영 (아래와 똑같음)


        //C 버튼 눌렀을 때 calLog, operators, resLog 초기화 및 텍스트뷰에 반영
        btClear.setOnClickListener {
            calLog = ""; tvCalLog.text = calLog
            operators = ""
            resLog = ""; tvResultLog.text = resLog
        }
    }
}

}