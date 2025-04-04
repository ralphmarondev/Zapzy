package com.ralphmarondev.zapzy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ralphmarondev.zapzy.ui.theme.ZapzyTheme
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: MainViewModel = koinViewModel()
            val ledStatus = viewModel.ledStatus.collectAsState().value

            var darkTheme by remember { mutableStateOf(false) }

            ZapzyTheme(
                darkTheme = darkTheme
            ) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = stringResource(R.string.app_name)
                                )
                            },
                            actions = {
                                IconButton(
                                    onClick = { darkTheme = !darkTheme }) {
                                    val imageVector = if (darkTheme) {
                                        Icons.Outlined.LightMode
                                    } else {
                                        Icons.Outlined.DarkMode
                                    }

                                    Icon(
                                        imageVector = imageVector, contentDescription = "Settings"
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                                actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                            )
                        )
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        val status = if (ledStatus) {
                            "ON"
                        } else {
                            "OFF"
                        }
                        Text(
                            text = "LED status: $status",
                            fontSize = MaterialTheme.typography.titleLarge.fontSize,
                            fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                            color = MaterialTheme.colorScheme.secondary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(16.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = viewModel::toggleLed) {
                            Text(
                                text = "Toggle LED",
                                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                                fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}