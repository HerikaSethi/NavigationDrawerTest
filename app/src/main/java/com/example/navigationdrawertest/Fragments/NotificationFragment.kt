package com.example.navigationdrawertest.Fragments

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.navigationdrawertest.R
import kotlinx.android.synthetic.main.fragment_notification.*


class NotificationFragment : Fragment() {

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder:Notification.Builder

    private val channelId = "com.example.navigationdrawertest.Fragments"

    //this description shall be visible to user
    private val description = "Test notification"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //initializing notification manager
         //notiicationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager = this.context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            btn_notify.setOnClickListener {
                //on click of btn we need to launch our application hence creating an intent pointing to our activity
                val intent = Intent(activity,LauncherActivity::class.java)

                //since we cannot pass intent directly to the notification hence pending intent created
                val pendingIntent = PendingIntent.getActivity(requireContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT)

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    //creating a notification channel
                    notificationChannel = NotificationChannel(
                        channelId,
                        description,
                        NotificationManager.IMPORTANCE_HIGH
                    )
                    notificationChannel.enableLights(true)
                    notificationChannel.lightColor = Color.BLUE
                    notificationChannel.enableVibration(false)
                    notificationManager.createNotificationChannel(notificationChannel)


                    builder = Notification.Builder(requireContext(), channelId)
                        .setContentTitle("Hello")
                        .setContentText("Test Notification")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setLargeIcon(
                            BitmapFactory.decodeResource(
                                this.resources,
                                R.drawable.ic_launcher_background
                            )
                        )
                        .setContentIntent(pendingIntent)
                }else{
                    //if sdk level is less than 26
                    builder = Notification.Builder(requireContext())
                        .setContentTitle("Hello")
                        .setContentText("Test Notification")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setLargeIcon(
                            BitmapFactory.decodeResource(
                                this.resources,
                                R.drawable.ic_launcher_background
                            )
                        )
                        .setContentIntent(pendingIntent)
                }

                notificationManager.notify(1234, builder.build())
            }
    }


}