package kr.imus.TwitterOAuthDemo;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeTimelineActivity extends Activity {
	private List<String> status;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    this.setContentView(R.layout.home_timeline);
	    
	    Twitter twitter = TwitterUtil.getTwitter(this);
	    
	    this.setStatus(new ArrayList<String>());
	    try {
			for (Status status : twitter.getHomeTimeline()) {
				this.getStatus().add("@" + status.getUser().getScreenName() + "\n" + status.getText());
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	    
	    ListView listView = (ListView) this.findViewById(R.id.homeTimelineListView);
	    listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, HomeTimelineActivity.this.getStatus()));
	}

	public List<String> getStatus() {
		return status;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}

}
