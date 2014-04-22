package com.mocoplex.rat.sample;

import com.mocoplex.rat.Tracker;
import com.mocoplex.rat.sample.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	protected void parseCustomScheme()
	{
		// option.
		// custom scheme
		Uri data = getIntent().getData();
        if(data != null) {

        	// EX) rat://view?pid=123;        	
            String pid = data.getQueryParameter("pid");
            // param pid

			Bundle extras = new Bundle();
			extras.putString("pid", pid);

			Intent intent = new Intent(this, CustomView.class);
			intent.putExtras(extras);
			startActivity(intent);
        }
        		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		// RAT 사용을 위해 꼭 필요한 구현부 입니다. - 초기페이지에서 꼭 호출이 되어야 합니다.
		Tracker.init(this);
		// RAT 사용을 위해 꼭 필요한 구현부 입니다.


		
		// customScheme 을 사용하는 경우 URI 를 분석합니다. (option)
		parseCustomScheme();
		
		
		
		// when the button is clicked.
		Button btn;
		btn = (Button)this.findViewById(R.id.goto_custom_scheme);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				// customScheme 을 사용하여 새로운 Activity 로 이동합니다.
				String url = "rat://view?pid=myproductid";
				Intent i = new Intent();
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
				
			}
			
		});
	}


}
