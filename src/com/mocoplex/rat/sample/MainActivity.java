package com.mocoplex.rat.sample;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.mocoplex.rat.Tracker;

public class MainActivity extends Activity {

	// 웹뷰
	private WebView m_webView = null; 
	
	// Back Key 관련 핸들러
	private Handler m_handler = null;
	// Back Key 관련 플래그
	private boolean mFlag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// 트래킹 연동을 위해 필수로 호출되어야 합니다. (인스톨 트래킹)
		Tracker.getInstance().init(this);
		
		// 트래킹 연동을 위해 필수로 호출되어야 합니다. (태그 전환 트래킹)
		Tracker.getInstance().init_tag(this, getIntent().getData());
		
		// 커스텀 스키마에 대해 처리를 합니다. (옵션)
		parseCustomScheme();
		
		m_handler = new Handler() {
			public void handleMessage(android.os.Message msg) {
				if(msg.what == 0){
					mFlag = false;
				}
			};
		};
		
	}
	
	protected void parseCustomScheme() {
		Uri data = getIntent().getData();
       if(data != null) { // custom schema 통해 들어온 경우           
           // EX) rat://view?pid=123;
           String pid = data.getQueryParameter("pid");          

           if(pid != null && !pid.equals("")){
        	   // 상세 페이지로 이동
        	   showDetail(pid);
           }else{
        	   // 메인 페이지로 이동
        	   showMain();
           }
       }else{
    	   // 메인 페이지로 이동
    	   showMain();
       }
       		
	}
	
	// 메인 웹 페이지로 이동
	protected void showMain() {
		m_webView = (WebView)findViewById(R.id.webView);
		m_webView.getSettings().setJavaScriptEnabled(true);
		m_webView.addJavascriptInterface(new JavaScriptInterface(getApplicationContext()), "android");
		m_webView.setWebViewClient(new MyWebViewClient());
		m_webView.loadUrl("http://demo.mocoplex.com/rat/index.html");
	}
	
	// 상세 웹 페이지로 이동
	protected void showDetail(String pid) {
		m_webView = (WebView)findViewById(R.id.webView);
		m_webView.getSettings().setJavaScriptEnabled(true);
		m_webView.addJavascriptInterface(new JavaScriptInterface(getApplicationContext()), "android");
		m_webView.setWebViewClient(new MyWebViewClient());
		m_webView.loadUrl("http://demo.mocoplex.com/rat/detail.html?item=" + pid);
		
		Tracker.getInstance().view(this, pid);
	}
	 
	class MyWebViewClient extends WebViewClient {
		 @Override
		 public boolean shouldOverrideUrlLoading(WebView view, String url){
		     view.loadUrl(url);
		    return true;  
		 }
	}
	
	
	// 웹 페이지의 자바스크립트 연동
	class JavaScriptInterface {
		
		Context context;
		
		JavaScriptInterface(Context ctx) {
			context = ctx;
		}
		
		// 상세 페이지 로깅
		public void view(String pid) {
			// RAT SDK 호출 (view)
			Tracker.getInstance().view(context, pid);
		}
		
		// 카트 로깅
		public void cart(String pid) {
			Toast.makeText(context, "Item added to Cart.", Toast.LENGTH_SHORT).show();
			
			// RAT SDK 호출 (cart)
			Tracker.getInstance().cart(context, pid);
		}
		
		// 구매 로깅
		public void buy(String pid) {
			Toast.makeText(context, "Thank you.", Toast.LENGTH_SHORT).show();
			
			// RAT SDK 호출 (buy)
			Tracker.getInstance().buy(context, pid);
		}
		
		// 사용자정의 태그 로깅
		public void customTag(String pid) {
			
			JSONObject v = new JSONObject();
			
			try {
				// 사용자 정의 추가 변수 저장
				v.put("pid", pid);
				v.put("category", "cloth");
				v.put("price", "1000000");
				v.put("qty", "10");
				v.put("name", "청바지");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			// RAT SDK 호출 (custom tag)
			// 태그 이름 : TAG_NAME
			// 추가 parameter : v (json)
			Tracker.getInstance().tag(context, "TAG_NAME", v);
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		if(m_webView != null){
			if (keyCode == KeyEvent.KEYCODE_BACK) {
				
				if(m_webView.canGoBack()){
					m_webView.goBack();
					return true;
				}else{
					if(!mFlag){
						Toast.makeText(this, "'뒤로' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
						mFlag = true;
						m_handler.sendEmptyMessageDelayed(0, 2000);
						return true;
					}else{
						finish();
					}
				}
				
			}
		}
		
		return super.onKeyDown(keyCode, event);
	}
}
