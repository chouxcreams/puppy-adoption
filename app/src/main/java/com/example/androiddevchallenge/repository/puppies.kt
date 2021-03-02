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
package com.example.androiddevchallenge.repository

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.Sex

val puppies: List<Puppy> = listOf(
    Puppy(
        "Pochi",
        3,
        Sex.Male,
        "Make it so, procedure! None of these galaxies will be lost in plasmas like procedures in flights",
        R.drawable.puppy1_thumbnaill
    ),
    Puppy(
        "Tama",
        1,
        Sex.Female,
        "The proton is more alien now than tribble. interstellar and revolutionary brave.Where is the clear ship?",
        R.drawable.puppy2_thumbnail
    ),
    Puppy(
        "Taro",
        0,
        Sex.Male,
        "Dry spinach fully, then mix with oyster sauce and serve freshly in bucket. Chicken breasts can be jumbled with smooth mackerel, also try blending the porridge with sweet chili sauce.",
        R.drawable.puppy3_thubnail
    )
)