package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow.Ellipsis
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Data
import com.example.androiddevchallenge.ui.utils.firstBaselineToTop
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.systemBarsPadding

@Composable
fun HomeScreen() {
  val horizontalPadding = Modifier.padding(horizontal = 16.dp)
  Scaffold(
    modifier = Modifier
      .systemBarsPadding(enabled = false)
      .navigationBarsPadding()
      .fillMaxSize(),
    bottomBar = {
      BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 16.dp
      ) {
        NavItem.values().forEachIndexed { index, item ->
          BottomNavigationItem(
            icon = {
              Icon(
                imageVector = item.icon,
                contentDescription = item.title
              )
            },
            label = {
              Text(
                text = item.title,
                style = MaterialTheme.typography.caption
              )
            },
            // There is no actual navigation in this challenge.
            selected = index == 0,
            onClick = {}
          )
        }
      }
    }
  ) { padding ->
    LazyColumn(
      contentPadding = PaddingValues(
        horizontal = 0.dp,
        vertical = 0.dp
      ),
      modifier = Modifier
        .padding(padding)
        .fillMaxSize(),
    ) {
      item {
        var keyword: String by rememberSaveable { mutableStateOf("") }
        OutlinedTextField(
          value = keyword,
          onValueChange = { keyword = it },
          modifier = horizontalPadding
            .padding(top = (40.dp - padding.calculateTopPadding()).coerceAtLeast(0.dp))
            .fillMaxWidth()
            .height(56.dp),
          textStyle = MaterialTheme.typography.body1,
          placeholder = {
            Text(
              text = "Search",
              style = MaterialTheme.typography.body1
            )
          },
          leadingIcon = {
            Icon(
              Filled.Search,
              contentDescription = null,
              modifier = Modifier.size(18.dp)
            )
          },
          singleLine = true
        )
      }

      item {
        Text(
          text = "Browse themes",
          style = MaterialTheme.typography.h1,
          modifier = Modifier
            .fillMaxWidth()
            .firstBaselineToTop(32.dp)
            .then(horizontalPadding),
        )
      }

      // Themes
      item {
        LazyRow(
          contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 16.dp),
          horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          items(Data.themes) {
            val item = it
            Column(
              modifier = Modifier
                .padding(bottom = 8.dp) // The next text will have 32dp top padding to baseline.
            ) {
              val isLight = MaterialTheme.colors.isLight
              Card(
                shape = MaterialTheme.shapes.small,
                elevation = 4.dp
              ) {
                Column(modifier = Modifier.size(136.dp)) {
                  Image(
                    painter = painterResource(item.image),
                    contentDescription = item.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                      .aspectRatio(17f / 12f)
                  )
                  Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                      .background(
                        color = if (isLight) {
                          MaterialTheme.colors.background
                        } else {
                          // MaterialTheme.colors.background.copy(alpha = 0.65f)
                          Color(0xFF393939) // Use manual pick.
                        }
                      )
                      .fillMaxSize()
                      .padding(horizontal = 16.dp)
                  ) {
                    Text(
                      text = item.title,
                      style = MaterialTheme.typography.h2,
                    )
                  }
                }
              }
            }
          }
        }
      }

      // Design your home garden
      item {
        Layout(
          content = {
            Text(
              text = "Design your home garden",
              overflow = Ellipsis,
              style = MaterialTheme.typography.h1
            )
            Icon(
              Filled.FilterList,
              contentDescription = "Filter",
              modifier = Modifier.size(24.dp)
            )
          }
        ) { measurables, constraints ->
          val paddingInPx = 16.dp.roundToPx()
          val contentWidth = constraints.maxWidth - paddingInPx * 2
          val icon = measurables[1].measure(constraints)
          val text = measurables[0].measure(
            constraints.copy(
              maxWidth = contentWidth - icon.width - 8.dp.roundToPx()
            )
          )
          val firstBaseline = text[FirstBaseline]
          val top = 32.dp.roundToPx() - firstBaseline
          layout(width = constraints.maxWidth, height = 44.dp.roundToPx()) {
            text.place(paddingInPx, top)
            icon.place(
              constraints.maxWidth - icon.width - paddingInPx,
              top + (text.height - icon.height) / 2
            )
          }
        }
      }

      // Designs
      items(Data.designs) {
        val item = it
        Row(
          modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .fillMaxWidth()
            .height(64.dp)
        ) {
          Surface(shape = MaterialTheme.shapes.small) {
            Image(
              painter = painterResource(item.image),
              contentDescription = item.name,
              contentScale = ContentScale.Crop,
              modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .background(MaterialTheme.colors.primary)
            )
          }

          Column {
            Row(modifier = Modifier.weight(1f)) {
              Column(
                modifier = horizontalPadding
                  .fillMaxHeight()
                  .weight(1f)
              ) {
                Text(
                  text = item.name,
                  style = MaterialTheme.typography.h2,
                  modifier = Modifier.firstBaselineToTop(24.dp)
                )
                Text(
                  text = item.description,
                  style = MaterialTheme.typography.body1,
                  modifier = Modifier.firstBaselineToTop(16.dp)
                )
              }

              var checked: Boolean by rememberSaveable { mutableStateOf(false) }
              Checkbox(
                checked = checked,
                onCheckedChange = { state -> checked = state },
                colors = CheckboxDefaults.colors(
                  checkmarkColor = MaterialTheme.colors.background
                ),
                modifier = Modifier
                  .padding(top = 16.dp)
                  .size(24.dp)
              )
            }

            Divider(
              color = Color(0xFF9E9E9E),
              startIndent = 8.dp
            )
          }
        }
      }

      item {
        Spacer(modifier = Modifier.height(16.dp))
      }
    }
  }
}

enum class NavItem(val title: String, val icon: ImageVector) {
  Home("Home", Filled.Home),
  Favorites("Favourites", Filled.FavoriteBorder),
  Profile("Profile", Filled.AccountCircle),
  Cart("Card", Filled.ShoppingCart)
}
