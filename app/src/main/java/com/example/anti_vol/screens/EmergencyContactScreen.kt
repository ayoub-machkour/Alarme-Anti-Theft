package com.example.anti_vol.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.anti_vol.ui.theme.AppColors

@Composable
fun EmergencyContactScreen(navController: NavController) {
    var phoneNumber by remember { mutableStateOf("+33") }
    var contactName by remember { mutableStateOf("") }
    var selectedMethod by remember { mutableStateOf("SMS") }
    var showPhoneError by remember { mutableStateOf(false) }
    var showNameError by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.DarkBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Contact d'urgence",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = AppColors.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "If a theft is detected, we will immediately send a photo alert to this contact",
                fontSize = 16.sp,
                color = AppColors.White.copy(alpha = 0.8f),
                textAlign = TextAlign.Center,
                lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Phone number section
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "phone number",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = AppColors.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .background(
                            color = Color(0xFFB8A9E8),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "🇫🇷",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(end = 8.dp)
                    )

                    BasicTextField(
                        value = phoneNumber,
                        onValueChange = { newValue ->
                            if (newValue.startsWith("+33") && newValue.length <= 12) {
                                val afterPrefix = newValue.substring(3)
                                if (afterPrefix.all { it.isDigit() }) {
                                    phoneNumber = newValue
                                    showPhoneError = false
                                }
                            }
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            color = Color.Black
                        ),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                if (showPhoneError) {
                    Text(
                        text = "Phone number must be exactly 9 digits after +33",
                        fontSize = 12.sp,
                        color = AppColors.NoteRed,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Contact name section
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "contact name",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = AppColors.White
                    )
                    Text(
                        text = "${contactName.length}/18",
                        fontSize = 12.sp,
                        color = AppColors.White.copy(alpha = 0.6f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                BasicTextField(
                    value = contactName,
                    onValueChange = { newValue ->
                        if (newValue.length <= 18 && !newValue.contains('\n')) {
                            contactName = newValue
                            showNameError = false
                        }
                    },
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Black
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .background(
                            color = Color(0xFFB8A9E8),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                )

                if (showNameError) {
                    Text(
                        text = "Contact name must be 2-18 characters",
                        fontSize = 12.sp,
                        color = AppColors.NoteRed,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Sending method",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = AppColors.White,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    SendingMethodButton(
                        text = "SMS",
                        isSelected = selectedMethod == "SMS",
                        onClick = { selectedMethod = "SMS" }
                    )

                    SendingMethodButton(
                        text = "WhatsApp",
                        isSelected = selectedMethod == "WhatsApp",
                        onClick = { selectedMethod = "WhatsApp" }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Next button
            Button(
                onClick = {
                    val phoneValid = phoneNumber.length == 12 && phoneNumber.startsWith("+33")
                    val nameValid = contactName.trim().length >= 2 && contactName.length <= 18

                    showPhoneError = !phoneValid
                    showNameError = !nameValid

                    if (phoneValid && nameValid) {
                        // Navigate to next screen
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppColors.White
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Next",
                    color = AppColors.DarkBackground,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun SendingMethodButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = when {
        isSelected && text == "WhatsApp" -> Color(0xFF25D366)
        isSelected && text == "SMS" -> Color(0xFF007AFF)
        else -> Color(0xFF6A6A6A)
    }

    Box(
        modifier = Modifier
            .width(140.dp)
            .height(56.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(color = backgroundColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = if (text == "WhatsApp") "📱" else "💬",
                fontSize = 16.sp
            )
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = AppColors.White
            )
        }
    }
}