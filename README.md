MeizuStatusBarColor
==========================

Usage
=====

*Only for Meizu Flyme3.0.*

  1. In your `onCreate` method ,use StatusBarColorUtils.changeStatusBarColor()
        before `setContentView()`
        
  2. Need permission of android.permission.SYSTEM_ALERT_WINDOW.
    
  3. Conflict with the swipebacklib by @碎星iKe because of windowIsTranslucent is true.

  4. You must make overridePendingTransition so that the animation between activity switching be normal.
	 *  OK:overridePendingTransition(R.anim.slide_right_in,R.anim.slide_left_out) 
	 *  NG: overridePendingTransition(0,R.anim.slide_left_out)


Developed By
============
 * Original:lob0 - <(http://weibo.com/lob0)> <Lobo.zhao@gmail.com>
 * Modify:朱雪松dream - <(http://weibo.com/u/2052202067)>