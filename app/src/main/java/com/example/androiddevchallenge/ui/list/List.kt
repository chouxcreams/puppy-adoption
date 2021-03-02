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
package com.example.androiddevchallenge.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.repository.puppies
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun List(onClick: (String) -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                navigationIcon = {
                    val iconPadding = 10.dp
                    Icon(
                        modifier = Modifier.padding(iconPadding),
                        painter = painterResource(id = R.drawable.pawprint_white),
                        contentDescription = "nothing"
                    )
                }
            )
        }
        ) {
            LazyColumn {
                puppies.forEach { puppy ->
                    item{ PuppyCard(puppy, onClick) }
                    item{ Divider() }
                }
            }
        }
    }
}

@Composable
fun PuppyCard(puppy: Puppy, onClick: (String) -> Unit) {
    val padding = 13.dp
    Row(
        Modifier
            .clickable { onClick("detail/${puppy.id}") }
            .padding(padding)) {
        Thumbnail(puppy)
        Column {
            val horizontalPadding = 6.dp
            val verticalPadding = 3.dp
            Text(
                text = "${puppy.name} (${puppy.age})",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(horizontalPadding, verticalPadding)
            )
            Text(
                text = "${puppy.description.take(60)}...",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(horizontalPadding, verticalPadding)
            )
        }
    }
}

@Composable
fun Thumbnail(puppy: Puppy) {
    Image(
        painter = painterResource(id = puppy.thumbnailId),
        contentDescription = puppy.name,
        modifier = Modifier
            .size(90.dp, 90.dp)
            .padding(6.dp)
            .clip(RoundedCornerShape(percent = 30))
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        List{}
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        List{}
    }
}