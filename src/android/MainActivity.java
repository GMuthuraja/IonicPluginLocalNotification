package cordova.plugin.estaff.localnotification;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import org.apache.cordova.CordovaActivity;

public class MainActivity extends CordovaActivity {

    String notificaitonID;
    String title;
    String message;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html");

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            notificaitonID = bundle.getString("notification_id");
            title = bundle.getString("title");
            message = bundle.getString("message");
        }

        AlertDialog alert = new AlertDialog.Builder(this, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).create();
        alert.setTitle(title);
        alert.setCancelable(false);
        alert.setMessage(message);

        alert.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alert.show();
    }
}
