package com.example.statusbarcolorswitch;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private View statusBarView;
	private WindowManager wm;
	private Button mButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		statusBarView = new View(getApplicationContext());
		wm = (WindowManager) getSystemService(WINDOW_SERVICE);
		StatusBarColorUtils.changeStatusBarColor(getApplicationContext(),
				getWindow(),statusBarView,wm,Color.parseColor("#ff3f3f"));
		setContentView(R.layout.activity_main);
		mButton = (Button) findViewById(R.id.button);
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.slide_right_in,R.anim.slide_left_out);
			}
		});
	}

	@Override
	protected void onDestroy() {
		wm.removeView(statusBarView);
		super.onDestroy();
	}

}
