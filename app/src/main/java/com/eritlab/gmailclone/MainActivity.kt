package com.eritlab.gmailclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eritlab.gmailclone.component.BottomMenu
import com.eritlab.gmailclone.component.GmailDrawerMenu
import com.eritlab.gmailclone.ui.theme.GmailCloneTheme
import com.eritlab.gmailclone.utils.BottomItem
import com.eritlab.gmailclone.utils.NavDrawerItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GmailCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    GmailApp()
                }
            }
        }
    }
}


@Composable
fun GmailApp() {
    //top bar menu list
    val menuItems = listOf(
        NavDrawerItem.Divider,
        NavDrawerItem.CustomItem,
        NavDrawerItem.AddStatus,
        NavDrawerItem.Divider,
        NavDrawerItem.AllInboxes,
        NavDrawerItem.Divider,
        NavDrawerItem.Inbox,
        NavDrawerItem.HeaderOne,
        NavDrawerItem.Starred,
        NavDrawerItem.Snoozed,
        NavDrawerItem.Important,
        NavDrawerItem.Sent,
        NavDrawerItem.Scheduled,
        NavDrawerItem.OutBox,
        NavDrawerItem.Drafts,
        NavDrawerItem.AllMail,
        NavDrawerItem.Spam,
        NavDrawerItem.Trash,
        NavDrawerItem.HeaderTwo,
        NavDrawerItem.Calendar,
        NavDrawerItem.Contacts,
        NavDrawerItem.Divider,
        NavDrawerItem.Settings,
        NavDrawerItem.Help
    )
    //bottom menu list
    val bottomList = listOf(
        BottomItem.MailNotification,
        BottomItem.Chat,
        BottomItem.Spaces,
        BottomItem.Meet
    )


    val selectedItem = remember { mutableStateOf(menuItems[6]) }
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val bottomBarSelectedItem = remember { mutableStateOf(bottomList[0]) }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { NavigationBar(scaffoldState = scaffoldState, scope = coroutineScope) },
        drawerContent = {
            GmailDrawerMenu(
                menuItems = menuItems,
                scrollState = scrollState,
                scaffoldState = scaffoldState,
                scope = coroutineScope,
                selectedItem = selectedItem
            )
        },
        bottomBar = {
            BottomMenu(bottomList, bottomBarSelectedItem)
        },
        modifier = Modifier.background(androidx.compose.material3.MaterialTheme.colorScheme.background)
    ) {

    }
}


@Preview(showSystemUi = true)
@Composable
private fun ShowPreview() {
    GmailCloneTheme {
        GmailApp()
    }
}