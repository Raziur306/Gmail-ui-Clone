package com.eritlab.gmailclone.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScaffoldState
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eritlab.gmailclone.utils.NavDrawerItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.selects.select

@Composable
fun GmailDrawerMenu(
    menuItems: List<NavDrawerItem>,
    scrollState: ScrollState,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    selectedItem: MutableState<NavDrawerItem>,
) {

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Text(
            text = "Gmail", fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(15.dp)
        )
        menuItems.forEach { item ->
            when {
                item.isDivider -> {
                    Divider(modifier = Modifier.padding(top = 15.dp, bottom = 15.dp))
                }
                item.customItem -> {

                }
                item.isHeader -> {
                    Text(
                        text = item.title!!,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .padding(start = 20.dp, bottom = 20.dp, top = 20.dp)
                    )
                }
                else -> {
                    DrawerItem(
                        item = item,
                        scaffoldState = scaffoldState,
                        scope = scope,
                        selectedItem = selectedItem
                    )
                }
            }
        }
    }
}


@Composable
fun DrawerItem(
    item: NavDrawerItem,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    selectedItem: MutableState<NavDrawerItem>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp, bottom = 2.dp, end = 8.dp)
            .height(50.dp)
            .clip(
                RoundedCornerShape(
                    topStartPercent = 0,
                    topEndPercent = 50,
                    bottomStartPercent = 0,
                    bottomEndPercent = 50
                )
            )
            .background(
                if (selectedItem.value == item) MaterialTheme.colorScheme.secondaryContainer else Color.Transparent
            )
            .clickable {
                selectedItem.value = item
                scope.launch {
                    delay(250)
                    scaffoldState.drawerState.close()
                }
            },
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            imageVector = item.icon!!, contentDescription = item.title,
            modifier = Modifier.weight(0.5f)
        )
        Text(
            text = item.title!!, modifier = Modifier.weight(2.0f),
            // color = if (selectedItem.value == item) MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.onSurfaceVariant
        )
    }

}


