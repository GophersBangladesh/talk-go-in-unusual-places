package dev.gophersbd.unusualgo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.gophersbd.unusualgo.ui.theme.UnusualGoTheme
import unusualgoandroid.Unusualgoandroid

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnusualGoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AlertButtonDemo(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AlertButtonDemo(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(false) }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center // Center the button within the Box
    ) {
//        // Button to show the dialog
//        Button(
//            onClick = { showDialog = true }
//        ) {
//            Text("Show Greeting")
//        }

        Button(
            onClick = {
                Thread {
                    Unusualgoandroid.serve()
                }.start()
            }
        ) {
            Text("Start Server")
        }
    }

    if (showDialog) {
        AlertDialog (
            onDismissRequest = {
                showDialog = false
            },
            title = {
                Text(text = "Hello World")
            },
            text = {
                Text(text = "It's nice to see you all here.")
            },
            confirmButton = {
                TextButton (onClick = { showDialog = false }) {
                    Text("OK")
                }
            }
        )
    }
}