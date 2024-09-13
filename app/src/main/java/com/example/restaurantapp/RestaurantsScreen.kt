package com.example.restaurantapp

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.restaurantapp.ui.theme.RestaurantAPpTheme

@Composable
fun RestaurantsScreen(){
    Column(){
        Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp)) {
            Text(text = "Nurul Annisa Murnastiti")
            Text(text = "235150209111008")
        }
        LazyColumn(contentPadding = PaddingValues(vertical = 8.dp, horizontal = 8.dp)) {
            items(dummyRestaurants){
                    restaurant -> RestaurantItem(restaurant)
            }
        }
    }

//    Column(Modifier.verticalScroll(rememberScrollState())) {
//        dummyRestaurants.forEach{restaurant -> RestaurantItem(restaurant)}
//    }
}

@Composable
fun RestaurantItem(item: Restaurant) {
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), modifier = Modifier.padding(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            RestaurantIcon(Icons.Filled.Place, Modifier.weight(0.15f))
            RestaurantDetails(item.title,
                item.description,Modifier.weight(0.85f))
        }
    }
}

@Composable
private fun RestaurantIcon(icon: ImageVector, modifier: Modifier) {
    Image(imageVector = icon, contentDescription = "Restaurant Icon", modifier = modifier.padding(8.dp))
}

@Composable
private fun RestaurantDetails(title: String, description: String, modifier: Modifier){
    Column(modifier = modifier){
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onSurfaceVariant) {
            Text(text = description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    RestaurantAPpTheme {
        RestaurantsScreen()
    }
}