package com.eritlab.gmailclone.component

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import com.eritlab.gmailclone.utils.BottomItem

@Composable
fun BottomMenu(bottomList: List<BottomItem>, bottomBarSelectedItem: MutableState<BottomItem>) {


    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.surface
    ) {
        bottomList.forEach { item ->
            BottomNavigationItem(
                // label = { Text(text = item.title) },
                // alwaysShowLabel = false,
                selected = bottomBarSelectedItem.value == item,
                onClick = {
                    bottomBarSelectedItem.value = item

                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) })
        }
    }
}