package com.eritlab.gmailclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eritlab.gmailclone.ui.theme.GmailCloneTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigationbar(drawerState: DrawerState, coroutine: CoroutineScope) {
    Box(modifier = Modifier.padding(10.dp))
    {
        Card(
            modifier = Modifier.requiredHeight(50.dp),
            shape = RoundedCornerShape(25.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .clip(CircleShape),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    coroutine.launch {
                        drawerState.open()
                    }

                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }

                Text("Search in mail", modifier = Modifier.weight(2.0f))
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
            }
        }
    }
}


