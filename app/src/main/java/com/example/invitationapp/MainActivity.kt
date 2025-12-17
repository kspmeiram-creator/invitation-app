package com.example.invitationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.invitationapp.ui.theme.InvitationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InvitationAppTheme {
                InvitationScreen()
            }
        }
    }
}

// Аннотацию @InvitationScreen нужно заменить на Composable функцию
@Composable
fun InvitationScreen() {
    // Здесь будет ваш код для экрана приглашения
    Text(text = "Приглашение!")
}

// Также полезно добавить предварительный просмотр
@Preview(showBackground = true)
@Composable
fun InvitationScreenPreview() {
    InvitationAppTheme {
        InvitationScreen()
    }
}

