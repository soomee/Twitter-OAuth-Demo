package kr.imus.TwitterOAuthDemo;

import twitter4j.Twitter;
import android.app.Activity;

public class TwitterUtil {
	public static TwitterOAuthDemoApp getApplication(Activity activity) {
		return (TwitterOAuthDemoApp) activity.getApplication();
	}
	
	public static Twitter getTwitter(Activity activity) {
		return TwitterUtil.getApplication(activity).getTwitter();
	}

}
