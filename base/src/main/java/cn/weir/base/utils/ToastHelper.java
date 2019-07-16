package cn.weir.base.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class ToastHelper {
    public static Toast mToast;
    public static Toast mCustomToast;

    public static void ShowToast(int resId, Context con) {
        if (con == null) {
            return;
        }
        Context context = con.getApplicationContext();
        String text = context.getString(resId);
        if (mToast == null) {
            mToast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void ShowToast(String text, Context con) {
        if (con == null || text == null || "".equals(text)) {
            return;
        }
        Context context = con.getApplicationContext();
        if (mToast == null) {
            mToast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void ShowToastLong(String text, Context con) {
        if (con == null || text == null) {
            return;
        }
        Context context = con.getApplicationContext();
        if (mToast == null) {
            mToast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_LONG);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }

    public static void ShowToast(View view, Context con) {
        if (con == null || view == null) {
            return;
        }
        Context context = con.getApplicationContext();
        if (mCustomToast == null) {
            mCustomToast = new Toast(context);
        }
        mCustomToast.setGravity(Gravity.CENTER, 0, 0);
        mCustomToast.setDuration(Toast.LENGTH_SHORT);
        mCustomToast.setView(view);
        mCustomToast.show();
    }

}
