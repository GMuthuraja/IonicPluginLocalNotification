package cordova.plugin.estaff.localnotification;

import android.app.Application;
import android.content.Context;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocalNotification extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Context context = cordova.getActivity().getApplicationContext();
        if (action.equals("showNotification")) {

            JSONObject arg_object = args.getJSONObject(0);

            Application app=cordova.getActivity().getApplication();
            String package_name = app.getPackageName();
            Resources resources = app.getResources();
            int icon = resources.getIdentifier("notification", "mipmap", package_name);

            NotificationChannel nChannel;
            NotificationManager nManager = (NotificationManager) this.cordova.getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                nChannel = new NotificationChannel("channelID", "myChannel", NotificationManager.IMPORTANCE_DEFAULT);
                nManager.createNotificationChannel(nChannel);
            }

            int nID = (int)(Math.random()* 5000+1);
            Intent showIntent = new Intent(context, MainActivity.class);
            showIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            showIntent.putExtra("notification_id", nID);
            showIntent.putExtra("title", arg_object.getString("title"));
            showIntent.putExtra("message", arg_object.getString("message"));
            PendingIntent showPIntent = PendingIntent.getActivity(context, nID ,showIntent,0);

            NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(context, "channelID");
            nBuilder.setSmallIcon(icon);
            nBuilder.setAutoCancel(true);
            nBuilder.setContentTitle(arg_object.getString("title"));
            nBuilder.setContentText(arg_object.getString("message"));
            nBuilder.setContentIntent(showPIntent);

            nManager.notify(nID, nBuilder.build());
            callbackContext.success("<<<<<<<Local Notifcation success>>>>>");
            return true;
        }
        callbackContext.error("<<<<<<<Expected one non-empty string argument>>>>>");
        return false;
    }
}
