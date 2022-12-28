package com.eritlab.gmailclone.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector


sealed class NavDrawerItem(
    val icon: ImageVector? = null,
    val title: String? = null,
    val isDivider: Boolean = false,
    val isHeader: Boolean = false,
    val customItem: Boolean = false

) {
    object AddStatus : NavDrawerItem(Icons.Outlined.Edit, "Add a status")
    object AllInboxes : NavDrawerItem(Icons.Outlined.AllInbox, "All Inboxes")
    object Inbox : NavDrawerItem(Icons.Outlined.Inbox, "Inbox")
    object Primary : NavDrawerItem(Icons.Default.Inbox, "Primary")
    object Promotions : NavDrawerItem(Icons.Outlined.Sell, "Promotions")
    object Social : NavDrawerItem(Icons.Outlined.Group, "Social")
    object Starred : NavDrawerItem(Icons.Outlined.Star, "Starred")
    object Snoozed : NavDrawerItem(Icons.Outlined.Schedule, "Snoozed")
    object Important : NavDrawerItem(Icons.Outlined.LabelImportant, "Important")
    object Sent : NavDrawerItem(Icons.Outlined.Send, "Sent")
    object Scheduled : NavDrawerItem(Icons.Outlined.ScheduleSend, "Scheduled")
    object OutBox : NavDrawerItem(Icons.Outlined.Outbox, "Outbox")
    object Drafts : NavDrawerItem(Icons.Outlined.Drafts, "Drafts")
    object AllMail : NavDrawerItem(Icons.Outlined.Forum, "Drafts")
    object Spam : NavDrawerItem(Icons.Outlined.Report, "Report")
    object Trash : NavDrawerItem(Icons.Outlined.Delete, "Trash")
    object Calendar : NavDrawerItem(Icons.Outlined.CalendarToday, "Calendar")
    object Contacts : NavDrawerItem(Icons.Outlined.AccountCircle, "Contacts")
    object Settings : NavDrawerItem(Icons.Outlined.Settings, "Settings")
    object Help : NavDrawerItem(Icons.Default.Help, "Help & Feedback")


    //divider
    object Divider : NavDrawerItem(isDivider = true)

    //header
    object HeaderOne : NavDrawerItem(title = "All labels", isHeader = true)
    object HeaderTwo : NavDrawerItem(title = "Google Apps", isHeader = true)
    object CustomItem : NavDrawerItem(customItem = true)
}