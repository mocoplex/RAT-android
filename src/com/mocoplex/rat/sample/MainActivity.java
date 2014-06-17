package com.mocoplex.rat.sample;

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

	private WebView m_webView = null;  
	 private Handler m_handler = null;
	 private boolean mFlag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// 트래킹 연동을 위해 필수로 호출
		Tracker.getInstance().init(this);
		// 트래킹 연동을 위해 필수로 호출
		
		//커스텀 스키마로 들어온 경우 파라미터 확인 
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
       	
           // 태그 전환 확인을 위해서는 아래 내용이 꼭 먼저 호출되어야 합니다.
           String ratparam = data.getQueryParameter("adlib_ratparam");
           if(ratparam != null && !ratparam.equals(""))
           {
           	Tracker.getInstance().init_tag(this, ratparam);
           }
           // 구현 끝.
           
           // EX) rat://view?pid=123;
           String pid = data.getQueryParameter("pid");          

           if(pid != null && !pid.equals("")){
           		// 상세 웹 페이지로 이동
        	   showDetail(pid);
           }else{
           		// 메인 웹 페이지로 이동
        	   showMain();
           }
       } else {
       		// 메인 웹 페이지로 이동
    	   showMain();
       }
       		
	}
	
	/* 메인 웹 페이지로 이동 */
	protected void showMain() {
		m_webView = (WebView)findViewById(R.id.webView);
		m_webView.getSettings().setJavaScriptEnabled(true);
		m_webView.addJavascriptInterface(new JavaScriptInterface(getApplicationContext()), "android");
		m_webView.setWebViewClient(new MyWebViewClient());
		m_webView.loadUrl("http://demo.mocoplex.com/rat/index.html");
	}
	
	/* 상세 웹 페이지로 이동 */
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
		
		Context mContext;
		
		JavaScriptInterface(Context c) {
			mContext = c;
		}
		
		// 상세 페이지 로깅
		public void view(String id) {
			Tracker.getInstance().view(mContext, id);
		}
		
		// 카트 로깅
		public void cart(String id) {
			Toast.makeText(mContext, "Item added to Cart.", Toast.LENGTH_SHORT).show();
			Tracker.getInstance().cart(mContext, id);
		}
		
		// 구매 로깅
		public void buy(String id) {
			Toast.makeText(mContext, "Thank you.", Toast.LENGTH_SHORT).show();
			Tracker.getInstance().buy(mContext, id);
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
