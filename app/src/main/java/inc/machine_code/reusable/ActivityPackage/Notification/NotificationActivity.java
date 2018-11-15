package inc.machine_code.reusable.ActivityPackage.Notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

import inc.machine_code.reusable.MainActivity;
import inc.machine_code.reusable.R;

public class NotificationActivity extends AppCompatActivity {

    Button buttonN1;
    PendingIntent contentIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        buttonN1 = findViewById(R.id.btn_Notification);

        buttonN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext());
                mBuilder.setSmallIcon(R.drawable.ic_action_name);
                mBuilder.setContentTitle("Hi i am Notification");
                mBuilder.setContentText("Wow");
                mBuilder.setPriority(NotificationCompat.PRIORITY_HIGH).setAutoCancel(true);

                Intent resultIntent = new Intent(getApplicationContext(), MainActivity.class);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
                    stackBuilder.addParentStack(MainActivity.class);

                    stackBuilder.addNextIntent(resultIntent);
                    PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                    mBuilder.setContentIntent(pendingIntent);
                }

                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                if (mNotificationManager != null) {
                    mNotificationManager.notify(0, mBuilder.build());
                }

//                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//                // notificationManager.notify();
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                    mBuilder.getNotification().flags |= Notification.FLAG_AUTO_CANCEL;
//                    Objects.requireNonNull(notificationManager).notify(0, mBuilder.build());
//
//                    Notification notification = new Notification();
//                }
            }
        });
    }
}