package com.mocoplex.rat.sample;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.mocoplex.rat.Tracker;

public class NativeActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.native_main);

		// 트래킹 연동을 위해 필수로 첫페이지에서 호출되어야 합니다. (초기화)
		Tracker.getInstance().init(this);
		
		Button btn;
		
		// view
		btn = (Button)this.findViewById(R.id.view);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				try {
						String eventname = "VIEW";
						String prod_no = "상품번호1";
						
						JSONObject obj = new JSONObject();
						obj.put("p_no", prod_no);
						obj.put("name", "상품 이름 입력");
						obj.put("price", "12300(상품가격 숫자만)");
						obj.put("thumb", "http://상품이미지주소");
						obj.put("account", "로그인 한 경우 사용자의 아이디 또는 이메일주소, 로그인하지 않은 경우 공백");						
						obj.put("cate1", "카테고리 정보 1, 대분류");
						obj.put("cate2", "카테고리 정보 2, 중분류");
						obj.put("cate3", "카테고리 정보 3, 소분류");

						obj.put("platform", "mobile_app");
						
					Tracker.getInstance().customTag(NativeActivity.this, eventname, obj);
					
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}			
		});

		// cart
		btn = (Button)this.findViewById(R.id.cart);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				// 여러 상품의 경우 아래와 같이 반복해서 호출해주세요..
				try {
						String eventname = "CART";
						String prod_no = "상품번호1";
						
						JSONObject obj = new JSONObject();
						obj.put("p_no", prod_no);
						obj.put("name", "상품 이름 입력");
						obj.put("qty", "상품 수량");
						obj.put("price", "12300(상품가격 숫자만)");
						obj.put("thumb", "http://상품이미지주소");
						obj.put("account", "로그인 한 경우 사용자의 아이디 또는 이메일주소, 로그인하지 않은 경우 공백");						
						obj.put("cate1", "카테고리 정보 1, 대분류");
						obj.put("cate2", "카테고리 정보 2, 중분류");
						obj.put("cate3", "카테고리 정보 3, 소분류");
	
						obj.put("platform", "mobile_app");
						
					Tracker.getInstance().customTag(NativeActivity.this, eventname, obj);
					
				} catch (JSONException e) {
					e.printStackTrace();
				}

				
				try {
					String eventname = "CART";
					String prod_no = "상품번호2";
					
					JSONObject obj = new JSONObject();
					obj.put("p_no", prod_no);
					obj.put("name", "상품 이름 입력");
					obj.put("qty", "상품 수량");
					obj.put("price", "12300(상품가격 숫자만)");
					obj.put("thumb", "http://상품이미지주소");
					obj.put("account", "로그인 한 경우 사용자의 아이디 또는 이메일주소, 로그인하지 않은 경우 공백");						
					obj.put("cate1", "카테고리 정보 1, 대분류");
					obj.put("cate2", "카테고리 정보 2, 중분류");
					obj.put("cate3", "카테고리 정보 3, 소분류");

					obj.put("platform", "mobile_app");
					
				Tracker.getInstance().customTag(NativeActivity.this, eventname, obj);
				
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
			}			
		});
		
		// buy
		btn = (Button)this.findViewById(R.id.buy);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {

				// 여러 상품의 경우 아래와 같이 반복해서 호출해주세요..
				try {
						String eventname = "BUY";
						String prod_no = "상품번호1";
						
						JSONObject obj = new JSONObject();
						obj.put("p_no", prod_no);
						obj.put("name", "상품 이름 입력");
						obj.put("qty", "상품 수량");
						obj.put("price", "12300(상품가격 숫자만)");
						obj.put("thumb", "http://상품이미지주소");
						obj.put("account", "로그인 한 경우 사용자의 아이디 또는 이메일주소, 로그인하지 않은 경우 공백");						
						obj.put("cate1", "카테고리 정보 1, 대분류");
						obj.put("cate2", "카테고리 정보 2, 중분류");
						obj.put("cate3", "카테고리 정보 3, 소분류");
	
						obj.put("platform", "mobile_app");
						
					Tracker.getInstance().customTag(NativeActivity.this, eventname, obj);
					
				} catch (JSONException e) {
					e.printStackTrace();
				}

				
				try {
					String eventname = "BUY";
					String prod_no = "상품번호2";
					
					JSONObject obj = new JSONObject();
					obj.put("p_no", prod_no);
					obj.put("name", "상품 이름 입력");
					obj.put("qty", "상품 수량");
					obj.put("price", "12300(상품가격 숫자만)");
					obj.put("thumb", "http://상품이미지주소");
					obj.put("account", "로그인 한 경우 사용자의 아이디 또는 이메일주소, 로그인하지 않은 경우 공백");						
					obj.put("cate1", "카테고리 정보 1, 대분류");
					obj.put("cate2", "카테고리 정보 2, 중분류");
					obj.put("cate3", "카테고리 정보 3, 소분류");

					obj.put("platform", "mobile_app");
					
				Tracker.getInstance().customTag(NativeActivity.this, eventname, obj);
				
				} catch (JSONException e) {
					e.printStackTrace();
				}				
				
			}		
		});
		
		
		
	}


}
