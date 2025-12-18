package com.example.invitationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    // State for editable text
    var text by remember { mutableStateOf("Приглашение!") }
    
    // State for selected background color
    var selectedColor by remember { mutableStateOf(Color.White) }
    
    // Pre-defined color choices
    val colorOptions = listOf(
        Color.White,
        Color(0xFFFFEBEE), // Light Red
        Color(0xFFE3F2FD), // Light Blue
        Color(0xFFE8F5E9), // Light Green
        Color(0xFFFFF3E0), // Light Orange
        Color(0xFFF3E5F5), // Light Purple
        Color(0xFFFFFDE7)  // Light Yellow
    )
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(selectedColor)
            .padding(16.dp)
    ) {
        // Main content area with text editor
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            BasicTextField(
                value = text,
                onValueChange = { text = it },
                textStyle = TextStyle(
                    fontSize = 24.sp,
                    color = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            )
        }
        
        // Background color selection area at the bottom
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = "Выберите фон:",
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                colorOptions.forEach { color ->
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .background(color, RoundedCornerShape(8.dp))
                            .border(
                                width = if (color == selectedColor) 3.dp else 1.dp,
                                color = if (color == selectedColor) Color.Black else Color.Gray,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clickable { selectedColor = color }
                    )
                }
            }
        }
    }
}

// Также полезно добавить предварительный просмотр
@Preview(showBackground = true)
@Composable
fun InvitationScreenPreview() {
    InvitationAppTheme {
        InvitationScreen()
    }
}

