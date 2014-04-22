package com.mocoplex.rat.sample;

import org.json.JSONException;
import org.json.JSONObject;

import com.mocoplex.rat.Tracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CustomView extends Activity {

	String pid = "pidname";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.custom_view);
		
		// parameter 초기화
		String _pid = getIntent().getStringExtra("pid");
		if(_pid != null) {
			EditText e = (EditText)this.findViewById(R.id.prodnum);
			e.setText(_pid);				
			pid = ((EditText)findViewById(R.id.prodnum)).getText().toString();

			// parameter 로 전달받은 값을 저장합니다.
			pid = _pid;
		}
		// parameter 초기화

		final Context ctx = this;
		
		
		// predefined tag : VIEW
		// 사용자의 [ VIEW ] Activity 를 저장합니다. (option) // 태그별 트래픽 리포트 제공 
		// 트래커로 트래킹 기록
		Tracker.view(ctx, pid);

		
		
		
		
		// predefined tag : CART
		// 사용자의 [ CART ] Activity 를 저장합니다. (option) // 태그별 트래픽 리포트 제공 
		Button btn;
		btn = (Button)this.findViewById(R.id.add_to_cart);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				pid = ((EditText)findViewById(R.id.prodnum)).getText().toString();

				// 트래커로 트래킹 기록
				Tracker.cart(ctx, pid);
				
			}
			
		});
		
		
				
		// predefined tag : BUY
		// 사용자의 [ BUY ] Activity 를 저장합니다. (option) // 태그별 트래픽 리포트 제공
		btn = (Button)this.findViewById(R.id.buy);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				pid = ((EditText)findViewById(R.id.prodnum)).getText().toString();
				
				// 트래커로 트래킹 기록
				Tracker.buy(ctx, pid);
				
			}
			
		});
		
		
		
		// predefined tag : 사용자태
		// 사용자의 [ 사용자태 ] Activity 를 저장합니다. (option) // 태그별 트래픽 리포트 제공
		btn = (Button)this.findViewById(R.id.customtag);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				// 트래커로 트래킹 기록
				JSONObject v = new JSONObject();
				
				try {

					// 사용자 정의 추가 변수 저장
					v.put("category", "cloth");
					v.put("price", "1000000");
					v.put("qty", "10");
					v.put("name", "청바지");

				} catch (JSONException e) {
					e.printStackTrace();
				}
				
				// 태그 이름 : MY_DETAILED
				// 추가 parameter : v (json)
				Tracker.tag(ctx, "MY_DETAILED", v);
			}
			
		});		
		
	}	
}