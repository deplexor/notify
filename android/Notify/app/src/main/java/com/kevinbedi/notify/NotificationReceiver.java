package com.kevinbedi.notify;

import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by michaelbahl on 30.10.17.
 */

package com.kevinbedi.notify;

import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by michaelbahl on 30.10.17.
 */

public class NotificationReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        playNotificationSound(context);
    }

    public void playNotificationSound(Context context) {
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
            final Ringtone r = RingtoneManager.getRingtone(context, notification);
            r.play();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    r.stop();
                }
            }, 30000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
