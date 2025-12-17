package com.example.invitationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
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

@Composable
fun InvitationScreen() {
    // State for editable text
    var text by remember { mutableStateOf("Приглашение!") }
    
    // State for selected background
    var selectedBackground by remember { mutableStateOf(Color.White) }
    
    // Available background colors
    val backgroundColors = listOf(
        Color.White,
        Color(0xFFFFE4E1),  // Misty Rose
        Color(0xFFE0F7FA),  // Light Cyan
        Color(0xFFFFF9C4),  // Light Yellow
        Color(0xFFE8F5E9),  // Light Green
        Color(0xFFF3E5F5)   // Light Purple
    )
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(selectedBackground)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Title
        Text(
            text = "Invitation Editor",
            style = MaterialTheme.typography.headlineMedium
        )
        
        // Editable text area
        BasicTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.White.copy(alpha = 0.8f))
                .border(2.dp, Color.Gray)
                .padding(16.dp),
            textStyle = TextStyle(
                fontSize = 24.sp,
                color = Color.Black
            ),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopStart
                ) {
                    if (text.isEmpty()) {
                        Text(
                            text = "Enter your invitation text here...",
                            style = TextStyle(
                                fontSize = 24.sp,
                                color = Color.Gray
                            )
                        )
                    }
                    innerTextField()
                }
            }
        )
        
        // Background selection title
        Text(
            text = "Select Background:",
            style = MaterialTheme.typography.titleMedium
        )
        
        // Background color selection row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            backgroundColors.forEachIndexed { index, color ->
                val colorName = when (index) {
                    0 -> "White"
                    1 -> "Misty Rose"
                    2 -> "Light Cyan"
                    3 -> "Light Yellow"
                    4 -> "Light Green"
                    5 -> "Light Purple"
                    else -> "Color $index"
                }
                val isSelected = color == selectedBackground
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .semantics {
                            contentDescription = if (isSelected) {
                                "$colorName, selected"
                            } else {
                                "$colorName, not selected. Tap to select."
                            }
                        }
                        .background(color)
                        .border(
                            width = if (isSelected) 4.dp else 2.dp,
                            color = if (isSelected) Color.Blue else Color.Black
                        )
                        .clickable { selectedBackground = color }
                )
            }
        }
    }
}

// Preview for the invitation screen
@Preview(showBackground = true)
@Composable
fun InvitationScreenPreview() {
    InvitationAppTheme {
        InvitationScreen()
    }
}

