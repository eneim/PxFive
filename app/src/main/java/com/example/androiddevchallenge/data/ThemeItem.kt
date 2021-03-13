package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R

data class ThemeItem(
  val title: String,
  val image: Int,
)

data class DesignItem(
  val name: String,
  val description: String = "This is a description",
  val image: Int,
)

object Data {
  val themes = listOf(
    ThemeItem(
      "Desert chic",
      R.raw.desert_chic
    ),
    ThemeItem(
      "Tiny terrariums",
      R.raw.tiny_terrariums
    ),
    ThemeItem(
      "Jungle vibes",
      R.raw.jungle_vibes
    ),
    ThemeItem(
      "Easy care",
      R.raw.easy_care
    ),
    ThemeItem(
      "Statements",
      R.raw.statements
    ),
  )

  val designs = listOf(
    DesignItem(
      name = "Monstera",
      image = R.raw.monstera
    ),
    DesignItem(
      name = "Aglaonema",
      image = R.raw.aglaonema
    ),
    DesignItem(
      name = "Peace lily",
      image = R.raw.peace_lily
    ),
    DesignItem(
      name = "Fiddle leaf tree",
      image = R.raw.fiddle_leaf_tree
    ),
    DesignItem(
      name = "Snake plant",
      image = R.raw.snake_plant
    ),
    DesignItem(
      name = "Pothos",
      image = R.raw.pothos
    ),
  )
}
