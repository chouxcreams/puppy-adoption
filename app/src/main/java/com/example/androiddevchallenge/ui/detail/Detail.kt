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
package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.repository.puppies
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Detail() {
    val puppy = puppies[0]
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(topBar = {
            TopAppBar(
                title = { Text(text = "Detail") },
                navigationIcon = {
                    val iconPadding = 10.dp
                    Icon(
                        modifier = Modifier
                            .clickable { }
                            .padding(iconPadding),
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            )
        }) {
            Column() {
                Image(
                    painter = painterResource(id = puppy.thumbnailId),
                    contentDescription = puppy.name
                )
                Text(
                    text = "${puppy.name} (${puppy.age})",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(20.dp)
                )
                Text(text = puppy.description, style = MaterialTheme.typography.body2, modifier = Modifier.padding(20.dp, 0.dp))
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Detail()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Detail()
    }
}