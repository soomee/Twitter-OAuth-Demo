package kr.imus.TwitterOAuthDemo;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
	private RequestToken requestToken;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    this.setContentView(R.layout.login);
	    
	    Twitter twitter = TwitterUtil.getTwitter(this);
	    
	    // 인증 시작
	    try {
	    	this.setRequestToken(twitter.getOAuthRequestToken());
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	    
	    WebView webView = (WebView) this.findViewById(R.id.loginOAuthWebView);
	    webView.loadUrl(this.getRequestToken().getAuthenticationURL());
	    
	    Button button = (Button) this.findViewById(R.id.loginOKButton);
	    button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			    Twitter twitter = TwitterUtil.getTwitter(LoginActivity.this);
			    
				AccessToken accessToken = null;
				
				EditText loginPINText = (EditText) LoginActivity.this.findViewById(R.id.loginPINText);
				String pin = loginPINText.getText().toString();
				try {
					if (pin.length() > 0) {
						RequestToken requestToken = LoginActivity.this.getRequestToken();
						accessToken = twitter.getOAuthAccessToken(requestToken, pin); 
					} else {
						accessToken = twitter.getOAuthAccessToken();
					}
					
					TwitterOAuthDemoApp app = TwitterUtil.getApplication(LoginActivity.this);
					app.storeAccessToken(twitter.verifyCredentials().getId(), accessToken);
				} catch (TwitterException e) {
					e.printStackTrace();
				}
				
				LoginActivity.this.finish();
			}
		});
	}

	public RequestToken getRequestToken() {
		return requestToken;
	}

	public void setRequestToken(RequestToken requestToken) {
		this.requestToken = requestToken;
	}

}
