package com.example.meizustatusbarcolor;

import com.example.statusbarcolorswitch.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class SecondActivity extends Activity{

	private View statusBarView;
	private WindowManager wm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		statusBarView = new View(getApplicationContext());
		wm = (WindowManager) getSystemService(WINDOW_SERVICE);
		StatusBarColorUtils.changeStatusBarColor(getApplicationContext(),
				getWindow(),statusBarView,wm,Color.parseColor("#ff3f3f"));
		setContentView(R.layout.activity_main);
	}
	@Override
	protected void onDestroy() {
		wm.removeView(statusBarView);
		super.onDestroy();
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
  		overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
	}
    
}
