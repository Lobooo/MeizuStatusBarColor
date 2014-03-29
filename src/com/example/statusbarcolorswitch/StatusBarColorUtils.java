package com.example.statusbarcolorswitch;

import java.lang.reflect.Field;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class StatusBarColorUtils {

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	public static void changeStatusBarColor(Context context, Window window,
			View statusBarView, WindowManager wm, int color) {
		int statusBarHeight = (int) Math.ceil(25 * context.getResources()
				.getDisplayMetrics().density);
		WindowManager.LayoutParams params = new WindowManager.LayoutParams();
		// reflect Meizu API
		Class<?> mzLpClass = params.getClass();
		try {
			Field meizuFlagsField = mzLpClass.getField("meizuFlags");
			int meizuFlags = (Integer) meizuFlagsField.get(params);
			meizuFlags |= 0x40; // this makes statusbar transparent
			meizuFlagsField.set(params, meizuFlags);
		} catch (NoSuchFieldException e) {
		} catch (IllegalAccessException e) {
		} catch (IllegalArgumentException e) {
		}
		window.setAttributes(params);
		window.getDecorView().setPadding(0, statusBarHeight, 0, 0);
		statusBarView.setBackgroundColor(color);
		params.width = WindowManager.LayoutParams.MATCH_PARENT;
		params.height = statusBarHeight;
		params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
		params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
				| WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
				| WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
		params.format = PixelFormat.TRANSLUCENT;
		params.gravity = Gravity.RIGHT | Gravity.TOP;
		statusBarView.setEnabled(false);
		statusBarView.setFocusable(false);
		wm.addView(statusBarView, params);
	}
}
