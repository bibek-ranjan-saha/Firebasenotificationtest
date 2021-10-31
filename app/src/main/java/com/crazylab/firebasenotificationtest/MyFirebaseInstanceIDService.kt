package com.crazylab.firebasenotificationtest

import android.app.*
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseInstanceIDService:FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val title = remoteMessage.notification?.title
        val msg = remoteMessage.notification?.body
        val url=remoteMessage.notification?.imageUrl
        val channelid="HEAD_UP_NOTIFICATION"
        val notificationChannel= NotificationChannel(channelid,"HEAD_UP_NOTIFICATION", NotificationManager.IMPORTANCE_HIGH)
        getSystemService(NotificationManager::class.java).createNotificationChannel(notificationChannel)



        val resultIntent = Intent(this, MainActivity2::class.java)
        resultIntent.putExtra("data",msg)
        val resultPendingIntent: PendingIntent? = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(resultIntent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }



        val notification: Notification.Builder= Notification.Builder(this,channelid)
            .setContentTitle(title)
            .setContentText(msg)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setAutoCancel(false)
            .addAction(R.drawable.ic_launcher_foreground,"OPEN",resultPendingIntent)
        NotificationManagerCompat.from(this).notify(1,notification.build())

        super.onMessageReceived(remoteMessage)
    }



}