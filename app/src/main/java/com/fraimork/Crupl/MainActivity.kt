package com.fraimork.Crupl

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fraimork.Crupl.ui.theme.AcefelCLOTheme
import com.fraimork.justin.Justin
import kotlinx.coroutines.launch
// hello world
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val scope = rememberCoroutineScope()
            var url1 by remember { mutableStateOf("") }
            var url2 by remember { mutableStateOf("") }
            var url3 by remember { mutableStateOf("") }

            LaunchedEffect(key1 = Unit) {
                url1 = Justin.getFinalUrl("https://fundforge24.ru") ?: "Null url 1"
                url2 = Justin.getFinalUrl("https://nolskin.site/N3MQNV") ?: "Null url 2"
                url3 = Justin.getFinalUrl("https://nolskin.site/N3MQNV") ?: "Null url 3"
            }


            AcefelCLOTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.tertiaryContainer)
                            .fillMaxSize()
                            .padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Redirect: $url1", color = MaterialTheme.colorScheme.primary)
                        Text(text = "Redirect: $url2", color = MaterialTheme.colorScheme.primary)
                        Text(text = "Redirect: $url3", color = MaterialTheme.colorScheme.primary)
                        Spacer(modifier = Modifier.height(20.dp))
                        
                        Text(text = "Timer 2024-07-08: ${Justin.isDateExpired("2024-07-08")}")
                        Text(text = "Timer 2024-07-09: ${Justin.isDateExpired("2024-07-09")}")
                        Text(text = "Timer 2024-07-10: ${Justin.isDateExpired("2024-07-10")}")

                    }
                }
            }
        }
    }
}
