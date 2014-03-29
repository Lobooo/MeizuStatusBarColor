MeizuStatusBarColor
==========================

Usage
=====

*Only for Meizu Flyme3.0.*

  1. In your `onCreate` method ,use StatusBarColorUtils.changeStatusBarColor()
        before setContentView()
        
  2. uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW"
    
  3. when android:windowIsTranslucent is true, which would lead to conflicts

  4. throw overridePendingTransition(),the actionbar can not be splited.
		yes:
        overridePendingTransition(R.anim.slide_right_in,R.anim.slide_left_out)
        no:
        overridePendingTransition(0,R.anim.slide_left_out)


Developed By
============

 * Lobo - <Lobo.zhao@gmail.com>