package com.example.workoutdiary

enum class Exercise(val part: String, val machine: String, val count: Int) {
    CHEST("가슴", "벤치", 5),
    SHOULDER("어깨", "벤치", 5),
    BACK("등", "벤치", 5),
    ABS("복근", "벤치", 5),
    ARM("팔", "벤치", 5),
    LEG("다리", "벤치", 5),
    HIP("엉덩이", "벤치", 5),
    ALL("전체", "벤치", 5),
    CARDIO("유산소", "벤치", 5);
}