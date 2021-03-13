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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.utils.firstBaselineToTop
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@Composable
fun WelcomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colors.primary)
            .navigationBarsPadding()
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.image_welcome_bg),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 72.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.image_welcome_illos),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .offset(x = 88.dp)
            )

            Spacer(modifier = Modifier.height(48.dp))

            Image(
                painter = painterResource(R.drawable.image_logo),
                contentDescription = "Bloom",
                modifier = Modifier
                    .height(32.dp)
                    .wrapContentSize()
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = "Beautiful home garden solutions",
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .firstBaselineToTop(24.dp) // it is 32 in spec, but only 3 rows of 8dp which is 24dp
                    .fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { /* no-op */ },
                shape = MaterialTheme.shapes.medium,
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary
                ),
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(text = "Create account")
            }

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(
                onClick = { navController.navigate("login") },
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = MaterialTheme.colors.secondary
                ),
                modifier = Modifier
                    .firstBaselineToTop(32.dp)
                    .fillMaxWidth(),
            ) {
                Text(text = "Log in")
            }
        }
    }
}
