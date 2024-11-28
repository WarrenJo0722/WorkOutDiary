package com.example.workoutdiary

import ListViewAdapter2
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.reflect.KMutableProperty0

class RoutineActivity : AppCompatActivity() {
    // 각 버튼에 대한 클릭 상태 추적 변수
    private var isChestClicked = false
    private var isSholderClicked = false
    private var isBackClicked = false
    private var isAbsClicked = false
    private var isArmClicked = false
    private var isLegClicked = false
    private var isHipClicked = false
    private var isAllClicked = false
    private var isCardioClicked = false

    private lateinit var chestButton: Button
    private lateinit var sholderButton: Button
    private lateinit var backButton: Button
    private lateinit var absButton: Button
    private lateinit var armButton: Button
    private lateinit var legButton: Button
    private lateinit var hipButton: Button
    private lateinit var allButton: Button
    private lateinit var cardioButton: Button

    val exercises: MutableList<Exercise> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_routine)

        val listView = findViewById<ListView>(R.id.routineList)
        val adapter = ListViewAdapter2(exercises)
        listView.adapter = adapter

        //변수 초기화
        val saveButton = findViewById<Button>(R.id.saveButton)
        val titleTextView = findViewById<TextView>(R.id.titleTv)
        val routineNameTextView = findViewById<TextView>(R.id.routineNameTv)
        val routineEditText = findViewById<EditText>(R.id.routineET)
        val targetTextView = findViewById<TextView>(R.id.targetTv)
        val infoTextView = findViewById<TextView>(R.id.infoTv)
        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            exercises.add(Exercise.ABS)
            adapter.notifyDataSetChanged()
        }

        // 버튼 초기화
        chestButton = findViewById(R.id.chestButton)
        sholderButton = findViewById(R.id.sholderButton)
        backButton = findViewById(R.id.backButton)
        absButton = findViewById(R.id.absButton)
        armButton = findViewById(R.id.armButton)
        legButton = findViewById(R.id.legButton)
        hipButton = findViewById(R.id.hipButton)
        allButton = findViewById(R.id.allButton)
        cardioButton = findViewById(R.id.cardioButton)


        // 입력값을 저장할 변수
        var routineText: String = ""

        // EditText 클릭 시 초기화
//        routineEditText.setOnClickListener {
//            routineEditText.text.clear() // EditText 내용 초기화
//        }

        // 각 버튼의 클릭 리스너 설정
        chestButton.setOnClickListener {
            resetButtonStates() // 다른 버튼들 초기화
            toggleButtonState(chestButton, ::isChestClicked)
        }
        sholderButton.setOnClickListener {
            resetButtonStates() // 다른 버튼들 초기화
            toggleButtonState(sholderButton, ::isSholderClicked)
        }
        backButton.setOnClickListener {
            resetButtonStates() // 다른 버튼들 초기화
            toggleButtonState(backButton, ::isBackClicked)
        }
        absButton.setOnClickListener {
            resetButtonStates() // 다른 버튼들 초기화
            toggleButtonState(absButton, ::isAbsClicked)
        }
        armButton.setOnClickListener {
            resetButtonStates() // 다른 버튼들 초기화
            toggleButtonState(armButton, ::isArmClicked)
        }
        legButton.setOnClickListener {
            resetButtonStates() // 다른 버튼들 초기화
            toggleButtonState(legButton, ::isLegClicked)
        }
        hipButton.setOnClickListener {
            resetButtonStates() // 다른 버튼들 초기화
            toggleButtonState(hipButton, ::isHipClicked)
        }
        allButton.setOnClickListener {
            resetButtonStates() // 다른 버튼들 초기화
            toggleButtonState(allButton, ::isAllClicked)
        }
        cardioButton.setOnClickListener {
            resetButtonStates() // 다른 버튼들 초기화
            toggleButtonState(cardioButton, ::isCardioClicked)
        }

        saveButton.setOnClickListener {
            SharedData.routines.add(Routine(routineEditText.text.toString(), exercises))
            finish()
            /*// StatusActivity로 전환
            val intent = Intent(this, IsRoutineActivity::class.java)
            // 데이터 전달
            val selectedCategories = mutableListOf<String>()

            if (isChestClicked) selectedCategories.add("가슴")
            if (isSholderClicked) selectedCategories.add("어깨")
            if (isBackClicked) selectedCategories.add("등")
            if (isAbsClicked) selectedCategories.add("복근")
            if (isArmClicked) selectedCategories.add("팔")
            if (isLegClicked) selectedCategories.add("다리")
            if (isHipClicked) selectedCategories.add("엉덩이")
            if (isCardioClicked) selectedCategories.add("유산소")

            intent.putStringArrayListExtra("categories", ArrayList(selectedCategories))

            // EditText 입력값 저장
            val routineText = routineEditText.text.toString()
            intent.putExtra("routineName", routineText)

            // ListView 아이템(title과 set 값)을 Pair로 저장
            val routineItems = ArrayList<Pair<String, String>>()
            for (item in items) {
                routineItems.add(Pair(item.title, item.set)) // title과 set을 Pair로 저장
            }

            intent.putExtra("routineItems", routineItems)
            setResult(RESULT_OK, intent)
            startActivity(intent)*/
        }

    }
    // 버튼 클릭 상태를 토글하는 함수
    private fun toggleButtonState(button: Button, clickedState: KMutableProperty0<Boolean>) {
        if (clickedState.get()) {
            button.setBackgroundColor(Color.parseColor("#E7E5E5")) // 원래 배경색으로 설정
            button.setTextColor(Color.parseColor("#353232"))
        } else {
            button.setBackgroundColor(Color.parseColor("#2196F3")) // 클릭된 배경색으로 설정
            button.setTextColor(Color.WHITE)

        }
        clickedState.set(!clickedState.get()) // 상태 토글
    }

    // 모든 버튼 상태를 초기화하는 함수
    private fun resetButtonStates() {
        isChestClicked = false
        isSholderClicked = false
        isBackClicked = false
        isAbsClicked = false
        isArmClicked = false
        isLegClicked = false
        isHipClicked = false
        isAllClicked = false
        isCardioClicked = false

        // 버튼 배경색 초기화 (해제 상태)
        chestButton.setBackgroundColor(Color.parseColor("#E7E5E5"))
        chestButton.setTextColor(Color.parseColor("#353232"))

        sholderButton.setBackgroundColor(Color.parseColor("#E7E5E5"))
        sholderButton.setTextColor(Color.parseColor("#353232"))

        backButton.setBackgroundColor(Color.parseColor("#E7E5E5"))
        backButton.setTextColor(Color.parseColor("#353232"))

        absButton.setBackgroundColor(Color.parseColor("#E7E5E5"))
        absButton.setTextColor(Color.parseColor("#353232"))

        armButton.setBackgroundColor(Color.parseColor("#E7E5E5"))
        armButton.setTextColor(Color.parseColor("#353232"))

        legButton.setBackgroundColor(Color.parseColor("#E7E5E5"))
        legButton.setTextColor(Color.parseColor("#353232"))

        hipButton.setBackgroundColor(Color.parseColor("#E7E5E5"))
        hipButton.setTextColor(Color.parseColor("#353232"))

        allButton.setBackgroundColor(Color.parseColor("#E7E5E5"))
        allButton.setTextColor(Color.parseColor("#353232"))

        cardioButton.setBackgroundColor(Color.parseColor("#E7E5E5"))
        cardioButton.setTextColor(Color.parseColor("#353232"))
    }
}