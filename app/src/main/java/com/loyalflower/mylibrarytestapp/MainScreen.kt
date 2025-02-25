package com.loyalflower.mylibrarytestapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.loyalflower.mylibrary.MyLibraryManager

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(modifier = modifier) {
        Button(
            onClick = {
                // 라이브러리에서 제공하는 로그 출력 함수
                MyLibraryManager.printLog("안녕하세요! (from MainScreen)")
            }
        ) {
            Text(text = "Log 출력")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // 라이브러리에서 제공하는 Toast 함수
                MyLibraryManager.showToast(context, "반갑습니다! (from MainScreen)")
            }
        ) {
            Text(text = "Toast 띄우기")
        }
    }
}