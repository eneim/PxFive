/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.utils.firstBaselineToTop
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .navigationBarsPadding()
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Log in with email",
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .firstBaselineToTop(184.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        var email: String by rememberSaveable { mutableStateOf("") }
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            textStyle = MaterialTheme.typography.body1,
            label = {
                Text(
                    text = "Email address",
                    style = MaterialTheme.typography.body1,
                )
            },
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colors.secondary,
                focusedLabelColor = MaterialTheme.colors.secondary
            ),
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        var password: String by rememberSaveable { mutableStateOf("") }
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            textStyle = MaterialTheme.typography.body1,
            label = {
                Text(
                    text = "Password (8+ characters)",
                    style = MaterialTheme.typography.body1,
                )
            },
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colors.secondary,
                focusedLabelColor = MaterialTheme.colors.secondary
            ),
            visualTransformation = PasswordVisualTransformation(mask = '\u2022'),
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
        )

        val agreementPart1 = "By clicking below, you agree to our "
        val terms = "Terms of Use"
        val agreementPart2 = " and consent to our "
        val policy = "Privacy Policy"
        val agreementPart3 = "."

        val agreement = buildAnnotatedString {
            val underline = SpanStyle(textDecoration = TextDecoration.Underline)
            append(agreementPart1)
            pushStyle(underline)
            append(terms)
            pop()
            append(agreementPart2)
            pushStyle(underline)
            append(policy)
            pop()
            append(agreementPart3)
        }

        Text(
            text = agreement,
            modifier = Modifier
                .firstBaselineToTop(24.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("home") },
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp
            ),
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .height(48.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Log in")
        }
    }
}
