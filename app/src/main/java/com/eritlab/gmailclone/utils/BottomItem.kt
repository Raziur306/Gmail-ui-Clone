package com.eritlab.gmailclone.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomItem(val icon: ImageVector, val title: String) {
    object MailNotification : BottomItem(Icons.Filled.Mail, "Notification Mail")
    object Chat : BottomItem(Icons.Outlined.ChatBubbleOutline, "Chat")
    object Spaces : BottomItem(Icons.Outlined.Groups, "Spaces")
    object Meet : BottomItem(Icons.Outlined.Videocam, "Meet")
}
