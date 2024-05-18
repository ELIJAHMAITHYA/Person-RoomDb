package com.example.roomdb.Presentation.Insert_Screen

import android.widget.Toast
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.LibraryBooks
import androidx.compose.material.icons.rounded.LockPerson
import androidx.compose.material.icons.rounded.ManageAccounts
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.PhoneInTalk
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomdb.Data.Person
import com.example.roomdb.Data.Person_Repository
import com.example.roomdb.R
import com.example.roomdb.constants.Insert_user_textFields
import com.example.roomdb.constants.details_textFields
import com.example.roomdb.ui.theme.AppViewModelProvider
import com.example.roomdb.ui.theme.RoomDbTheme


@Composable
fun Insert_User_Screen(
    modifier: Modifier = Modifier,
    viewModel: Insert_Users_Screen_textfield_ViewModel= viewModel(factory = AppViewModelProvider.Factory)
) {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val colorStops = arrayOf(
        0.0f to Color.Red,
        0.33f to Color.Yellow,
        0.4f to Color.Black,
        0.5f to Color.Green,
        0.66f to Color.Blue,
    )
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable._04_error),
            contentDescription = "Image ",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(200.dp)
                .border(
                    BorderStroke(
                        width = 3.dp,
                        Brush.linearGradient(colorStops = colorStops)
                    )
                )
                .padding(10.dp)

        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "User Insert Screen ",
            style = TextStyle(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp,
                brush = Brush.horizontalGradient(colorStops = colorStops)
            )
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            details_textFields(
                value = viewModel.name,
                placeholder = " Enter name e.g Sila",
                onValueChange = viewModel::updateName,
                icon = Icons.Rounded.Person,
                keyboardType = KeyboardType.Email,

                )

            details_textFields(
                value = viewModel.Age,
                placeholder = " Enter age e.g 24 ",
                onValueChange = viewModel::updateAge,
                icon = Icons.Rounded.ManageAccounts,
                keyboardType = KeyboardType.Number,
//            modifier = modifier.padding(horizontal = 24.dp)
            )

            details_textFields(
                value = viewModel.Phone_number,
                placeholder = " e.g 0797968532 ",
                onValueChange = viewModel::updatePhone,
                icon = Icons.Rounded.PhoneInTalk,
                keyboardType = KeyboardType.Number,
//            modifier = modifier.padding(horizontal = 24.dp)
            )

            details_textFields(
                value = viewModel.course,
                placeholder = " e.g Computer Science",
                onValueChange = viewModel::updateCourse,
                icon = Icons.Rounded.LibraryBooks,
                keyboardType = KeyboardType.Text,
//            modifier = modifier.padding(horizontal = 24.dp)
            )


            Insert_user_textFields(
                value = viewModel.email,
                placeholder = " Enter email @gmail.com",
                onValueChange = viewModel::updateEmail,
                isError = viewModel.email_error.isNotEmpty(),
                icon = Icons.Rounded.Email,
                errorMessage = viewModel.email_error,
                keyboardType = KeyboardType.Email,
//            modifier = modifier.padding(horizontal = 24.dp)
            )

            Insert_user_textFields(
                value = viewModel.password,
                placeholder = " ******** ",
                onValueChange = viewModel::updatePassword,
                isError = viewModel.password_error.isNotEmpty(),
                icon = Icons.Rounded.LockPerson,
                isPassword = true,
                errorMessage = viewModel.password_error,
                keyboardType = KeyboardType.Password,
//            modifier = modifier.padding(horizontal = 24.dp)
            )

            Button(
                onClick = {
                    focusManager.clearFocus()
                    if (viewModel.submitInfo()) {
                        Toast.makeText(
                            context,
                            "Information Added Successfully",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        Toast.makeText(
                            context,
                            "Please fix the errors",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = modifier.padding(horizontal = 2.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Submit ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = White
                )
            }
        }
    }
}

