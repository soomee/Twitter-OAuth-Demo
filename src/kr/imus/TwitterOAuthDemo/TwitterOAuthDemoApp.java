package kr.imus.TwitterOAuthDemo;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import android.app.Application;
import android.util.Log;

public class TwitterOAuthDemoApp extends Application {
	private final String CONSUMER_KEY = "Z1S4P97AgwbmHAaASPhQ";
	private final String CONSUMER_SECRET= "6k9Y6LI4we8YU13ZC5Tbhde6kWgkutWDi73KKV375Sg";
	
	private Twitter twitter;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(this.CONSUMER_KEY, this.CONSUMER_SECRET);
		this.setTwitter(twitter);
	}
	
	public void storeAccessToken(long useId, AccessToken accessToken) {
		// AccessToken 영속 저장소에 저장하는 루틴을 구현하시오.
		Log.d(getClass().getSimpleName(), String.valueOf(useId));
		Log.d(getClass().getSimpleName(), accessToken.toString());
	}

	public Twitter getTwitter() {
		return twitter;
	}

	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}

}
