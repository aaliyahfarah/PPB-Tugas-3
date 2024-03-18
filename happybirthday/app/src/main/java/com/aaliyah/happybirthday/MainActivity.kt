package com.aaliyah.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aaliyah.happybirthday.ui.theme.HappybirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappybirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Column(
                        Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Column(
                            modifier = Modifier
                                .verticalScroll(rememberScrollState())
                                .weight(1f, false)
                        ) {
                            GreetingText(
                                message = "Happy Birthday Emma!",
                            )
                            ShowImage()
                        }
                        DialogSimple(
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ShowImage(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(40.dp)
    ) {
        Image(
            modifier = Modifier
                .size(350.dp)
                .padding(top = 10.dp),
            painter = painterResource(R.drawable.cake),
            contentDescription = stringResource(R.string.gambar_kue),
        )
    }
}

@Composable
fun GreetingText(
    message: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(10.dp)
    ) {
        Text(
            text = message,
            fontSize = 45.sp,
            lineHeight = 56.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
        )
    }
}
//7469B6

@Composable
fun DialogSimple() {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val buttonColor = ButtonDefaults.buttonColors(
            Color(216, 60, 152, 255)
        )
        Button(
            onClick = { showDialog = true },
            colors = buttonColor ,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text("Open Me!")
        }

        if (showDialog) {
            AlertDialogExample(
                onDismissRequest = { showDialog = false },
                dialogText = stringResource(R.string.Pesan)
            )
        }
    }
}

@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    dialogText: String,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        text = {
            Text(text = dialogText)
        },
        confirmButton = {
            val buttonColor = ButtonDefaults.buttonColors(
                Color(216, 60, 152, 255)
            )
            Button(
                onClick = onDismissRequest,
                colors = buttonColor ,
            ) {
                Text("Close")
            }
        }
    )
}



@Preview(showBackground = true)
@Composable
fun BirthdayPreview() {
    HappybirthdayTheme {
        ShowImage()
        GreetingText(message = "Happy Birthday Emma!")

    }
}

@Preview(showBackground = true)
@Composable
fun DialogPreview() {
    HappybirthdayTheme {
        DialogSimple(
        )
    }
}
