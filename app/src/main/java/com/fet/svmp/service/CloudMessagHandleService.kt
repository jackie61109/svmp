package com.fet.svmp.service

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.orhanobut.logger.Logger

/**
 * Created by i_jackiechen1 on 2018/12/5 上午11:34.
 */
class CloudMessagHandleService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        Logger.d("onMessageReceived:  ${remoteMessage?.notification?.title}")
        Logger.d("onMessageReceived:  ${remoteMessage?.notification?.body}")
    }

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    override fun onNewToken(token: String?) {
        Logger.d("Refreshed token: $token")

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        //        sendRegistrationToServer(token);
    }


}
