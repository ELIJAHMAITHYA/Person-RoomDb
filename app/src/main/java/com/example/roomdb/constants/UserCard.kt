package com.example.roomdb.constants

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.roomdb.Data.Person
import com.example.roomdb.ui.theme.RoomDbTheme


@Composable
fun User_card(
    person: Person,
    modifier: Modifier = Modifier
) {
    val colorStops = arrayOf(
        0.0f to Color.Red,
        0.33f to Color.Yellow,
        0.4f to Color.Black,
        0.5f to Color.Green,
        0.66f to Color.Blue,
    )

    Card(

        elevation = CardDefaults.cardElevation(10.dp),
        border = BorderStroke(
            1.dp, Brush.linearGradient(colorStops = colorStops)
        ),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,

            )
        {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "User: ${person.uid} ",
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Rounded.Person,
                    contentDescription = "User Icon",
                    modifier = Modifier.size(36.dp)
                )
            }
            Divider(modifier = Modifier.padding(top = 10.dp), thickness = 2.dp, color = Color.Blue)
            Spacer(modifier = Modifier.height(12.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    DetailItem(
                        icon = Icons.Rounded.AccountBox,
                        label = "Name : ${person.Name}"
                    )
                }
                item { DetailItem(icon = Icons.Default.Cake, label = "Age: ${person.Age}") }
                item { DetailItem(icon = Icons.Default.School, label = "Course: ${person.Course}") }
                item { DetailItem(icon = Icons.Default.Email, label = "Email: ${person.Email}") }
                item { DetailItem(icon = Icons.Default.Phone, label = "Phone: ${person.Phone_number}") }
                item {
                    Button(
                        onClick = {
                        },
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.wrapContentWidth()

                    ) {
                        Text(
                            text = "Delete User",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun DetailItem(icon: ImageVector, label: String) {
    Row(
        modifier = Modifier.padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label, style = MaterialTheme.typography.bodySmall)
    }
}

@Preview(showSystemUi = true)
@Composable
fun cardtest() {
    RoomDbTheme {
        User_card(
            person = Person(
                uid = 123,
                Name = "John Doe",
                Age = "25",
                Course = "Computer Science",
                Email = "john.doe@example.com",
                Phone_number = 797968545 ,
                Password = null
            )
        )
    }
}