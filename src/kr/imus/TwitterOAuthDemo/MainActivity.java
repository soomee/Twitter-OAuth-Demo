package kr.imus.TwitterOAuthDemo;

import twitter4j.Twitter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);

        // Login Button
        Button loginButton = (Button) this.findViewById(R.id.mainLoginButton);
        loginButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Twitter twitter = TwitterUtil.getTwitter(MainActivity.this);
				if (!twitter.getAuthorization().isEnabled()) {
					Intent intent = new Intent(MainActivity.this, LoginActivity.class);
					MainActivity.this.startActivity(intent);
				} else {
					Toast.makeText(MainActivity.this, "인증되었습니다", Toast.LENGTH_SHORT).show();
				}
			}
		});
        
        // User Timeline Button
        Button homeTimelineButton = (Button) this.findViewById(R.id.mainHomeTimelineButton);
        homeTimelineButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Twitter twitter = TwitterUtil.getTwitter(MainActivity.this);
				if (twitter.getAuthorization().isEnabled()) {
					Intent intent = new Intent(MainActivity.this, HomeTimelineActivity.class);
					MainActivity.this.startActivity(intent);
				} else {
					Toast.makeText(MainActivity.this, "인증되지 않았습니다", Toast.LENGTH_SHORT).show();
				}
			}
		});
        
        // Direct Message Button
        Button directMessageButton = (Button) this.findViewById(R.id.mainDirectMessageButton);
        directMessageButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Twitter twitter = TwitterUtil.getTwitter(MainActivity.this);
				if (twitter.getAuthorization().isEnabled()) {
					Intent intent = new Intent(MainActivity.this, DirectMessageActivity.class);
					MainActivity.this.startActivity(intent);
				} else {
					Toast.makeText(MainActivity.this, "인증되지 않았습니다", Toast.LENGTH_SHORT).show();
				}
			}
		});
    }
}