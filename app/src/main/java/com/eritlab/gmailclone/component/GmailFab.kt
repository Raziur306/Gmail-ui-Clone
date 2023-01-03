package com.eritlab.gmailclone.component


import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun GmailFab(scrollState: ScrollState) {
    if (scrollState.value > 1) {
        FloatingActionButton(onClick = {
        }, modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "Floating Button")
        }
    } else {
        ExtendedFloatingActionButton(
            text = {
                Text(text = "Compose", fontSize = 15.sp)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Floating Button"
                )
            },
            onClick = { /*TODO*/ })
    }
}