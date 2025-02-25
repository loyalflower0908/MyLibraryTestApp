package com.loyalflower.mylibrary

import android.content.Context
import android.util.Log
import android.widget.Toast

/**
 *  실제 SDK라면 내부적으로 네트워킹, DB, 복잡한 비즈니스 로직 등이 들어갈 수 있겠지만,
 *  여기서는 “라이브러리에서 기능을 호출해 동작한다”는 것을 학습하기 위해 간단한 함수만 구성했습니다.
 */

object MyLibraryManager {

    private const val TAG = "MyLibraryManager"

    // 예시로 로그만 간단히 찍어주는 함수
    fun printLog(message: String) {
        Log.d(TAG, "Message from MyLibrary: $message")
    }

    // Toast를 화면에 보여주는 함수
    fun showToast(context: Context, message: String) {
        Toast.makeText(context, "MyLibrary says: $message", Toast.LENGTH_SHORT).show()
    }
}
