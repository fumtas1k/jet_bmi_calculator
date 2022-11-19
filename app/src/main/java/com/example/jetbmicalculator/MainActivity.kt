package com.example.jetbmicalculator


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbmicalculator.components.PinkLabelTextField
import com.example.jetbmicalculator.ui.theme.JetBMICalculatorTheme
import com.example.jetbmicalculator.ui.theme.Kaido

class MainActivity : ComponentActivity() {
  private val viewModel by viewModels<MainViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      JetBMICalculatorTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
          Column(
              horizontalAlignment = Alignment.Start,
              modifier = Modifier
                  .padding(20.dp)
                  .verticalScroll(rememberScrollState())
          ) {

            // タイトル
            Text(
                text = "BMI計算アプリ",
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(30.dp))

            // 身長
            PinkLabelTextField(
                label = "身長(cm)",
                value = viewModel.height,
                placeholder = "170",
                onValueChange = { viewModel.height = it }
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 体重
            PinkLabelTextField(
                label = "体重(kg)",
                value = viewModel.weight,
                placeholder = "65",
                onValueChange = { viewModel.weight = it }
            )

            Spacer(modifier = Modifier.height(30.dp))

            // 計算
            Button(
                onClick = { viewModel.calculateBmi() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Kaido
                )
            ) {
              Text(
                  text = "計算する",
                  color = Color.White,
                  fontSize = 18.sp,
                  fontWeight = FontWeight.Bold
              )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // 結果表示
            Text(
                text = "あなたのBMIは ${viewModel.bmi} です。",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.Gray,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold
            )
          }
        }
      }
    }
  }
}