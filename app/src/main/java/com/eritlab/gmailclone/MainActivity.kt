package com.eritlab.gmailclone

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eritlab.gmailclone.component.BottomMenu
import com.eritlab.gmailclone.component.GmailDrawerMenu
import com.eritlab.gmailclone.ui.theme.GmailCloneTheme
import com.eritlab.gmailclone.utils.BottomItem
import com.eritlab.gmailclone.utils.NavDrawerItem
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar

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
    val lazyListState = rememberLazyListState()
    val context = LocalContext.current

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            NavigationBar(scaffoldState = scaffoldState, scope = coroutineScope)
        },
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
    ) { padding ->


        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            items(50) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sender_image),
                        contentDescription = "Sender Image",
                        modifier = Modifier
                            .clip(CircleShape)
                            .weight(0.15f)
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp),

                        ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Dummy Sender")
                            Text(text = getDate())
                        }

                        Row {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = "Dummy Subject")
                                Text(
                                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    //modifier = Modifier.weight(1f)
                                )
                            }
                            IconButton(
                                modifier = Modifier
                                    .weight(0.1f)
                                    .fillMaxWidth(),
                                onClick = {
                                    Toast.makeText(context, "Added", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.StarOutline,
                                    contentDescription = "Favourite Button"
                                )
                            }
                        }

                    }
                }
            }

        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun ShowPreview() {
    GmailCloneTheme {
        GmailApp()
    }
}


//get current time

private fun getDate(): String {
    val time = Calendar.getInstance().time
    val dateFormat = SimpleDateFormat("dd/MM/yyyy")
    return dateFormat.format(time)
}