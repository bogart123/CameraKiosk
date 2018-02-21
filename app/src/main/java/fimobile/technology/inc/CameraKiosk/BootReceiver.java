package fimobile.technology.inc.CameraKiosk;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by CTI-OBD-RA on 2/9/2018.
 */

public class BootReceiver extends BroadcastReceiver {

    Context context;
    private static final int REQUEST_CAMERA = 0;
    private static final int REQUEST_CAMERA_PERMISSION = 1;

    @Override
    public void onReceive(Context context, Intent intent) {
//        Intent myIntent = new Intent(context, CameraActivity.class);
//        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(myIntent);
        context = context;

        final String permission = Manifest.permission.CAMERA;
        if (ContextCompat.checkSelfPermission(context, permission)
                != PackageManager.PERMISSION_GRANTED) {
//            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, permission)) {
////                showPermissionRationaleDialog("Test", permission);
//            } else {
            requestForPermission(permission);
//            }
        }
    }

    private void requestForPermission(final String permission) {
        ActivityCompat.requestPermissions((Activity) context, new String[]{permission}, REQUEST_CAMERA_PERMISSION);
    }
}
