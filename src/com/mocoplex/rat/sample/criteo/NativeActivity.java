package com.mocoplex.rat.sample.criteo;

import com.mocoplex.rat.sample.*;

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
		setContentView(R.layout.native_main_criteo);

		// 트래킹 연동을 위해 필수로 첫페이지에서 호출되어야 합니다. (초기화)
		Tracker.getInstance().init(this);
		
		Button btn;

		// home
		btn = (Button)this.findViewById(R.id.home);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				try {
					JSONArray jlist = new JSONArray();
								
						String eventname = "viewHome";				
						JSONObject obj = new JSONObject();
	
						obj.put("event", eventname);
						
					jlist.put(obj);
					
					Tracker.getInstance().criteo_event(NativeActivity.this, jlist);
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
			}			
		});
		
		// view
		btn = (Button)this.findViewById(R.id.view);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				try {
					JSONArray jlist = new JSONArray();
								
						String eventname = "viewProduct";
						String prod_no = "상품번호";
						
						JSONObject obj = new JSONObject();
	
						obj.put("event", eventname);
						obj.put("product", prod_no);
						
					jlist.put(obj);
					
					Tracker.getInstance().criteo_event(NativeActivity.this, jlist);
					
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}			
		});
		
		// listing
		btn = (Button)this.findViewById(R.id.listing);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {

				try {
					JSONArray jlist = new JSONArray();
								
						String eventname = "viewListing";
						
						JSONArray productArray = new JSONArray();
						productArray.put("상품번호1");
						productArray.put("상품번호2");
						
						JSONObject obj = new JSONObject();
	
						obj.put("event", eventname);
						obj.put("product", productArray);
						
					jlist.put(obj);
					
					Tracker.getInstance().criteo_event(NativeActivity.this, jlist);
					
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
				
				try {
					JSONArray jlist = new JSONArray();
								
						String eventname = "viewBasket";
						
						JSONArray productArray = new JSONArray();
						
						{
							JSONObject prod = new JSONObject();
							
							prod.put("id","상품번호1");
							prod.put("price",2300);
							prod.put("quantity",2);
							productArray.put(prod);							
						}
						
						{
							JSONObject prod = new JSONObject();
							
							prod.put("id","상품번호2");
							prod.put("price",4300);
							prod.put("quantity",3);
							productArray.put(prod);							
						}
						
						JSONObject obj = new JSONObject();
	
						obj.put("event", eventname);
						obj.put("product", productArray);
						
					jlist.put(obj);
					
					Tracker.getInstance().criteo_event(NativeActivity.this, jlist);
					
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
				
				try {
					JSONArray jlist = new JSONArray();

						String eventname = "trackTransaction";
						String transactionID = "transactionID";
						
						JSONArray productArray = new JSONArray();
						
						{
							JSONObject prod = new JSONObject();
							
							prod.put("id","상품번호1");
							prod.put("price",2300);
							prod.put("quantity",2);
							productArray.put(prod);							
						}
						
						{
							JSONObject prod = new JSONObject();
							
							prod.put("id","상품번호2");
							prod.put("price",4300);
							prod.put("quantity",3);
							productArray.put(prod);							
						}
						
						JSONObject obj = new JSONObject();
	
						obj.put("event", eventname);
						obj.put("id", transactionID);
						obj.put("product", productArray);
						
					jlist.put(obj);
					
					Tracker.getInstance().criteo_event(NativeActivity.this, jlist);
					
				} catch (JSONException e) {
					e.printStackTrace();
				}				
			}		
		});
		
		
		
	}


}
