package com.mocoplex.rat.sample.criteo;

import com.mocoplex.rat.sample.*;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.mocoplex.rat.ADLIBrHybridInterface;
import com.mocoplex.rat.Tracker;

public class HybridActivity extends Activity {

	// 웹뷰
	private WebView m_webView = null; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// 트래킹 연동을 위해 필수로 첫페이지에서 호출되어야 합니다. (초기화)
		Tracker.getInstance().init(this);

		// 메인페이지를 웹뷰에서 로드합니다.
		m_webView = (WebView)findViewById(R.id.webView);
		m_webView.loadUrl("http://mkt.adlibr.com/rat_sample/hybrid/criteo/");		
		m_webView.setWebChromeClient(new WebChromeClient() {
			  public void onConsoleMessage(String message, int lineNumber, String sourceID) {
			    Log.d("MyApplication", message + " -- From line "
			                         + lineNumber + " of "
			                         + sourceID);
			  }
			});
		
		// SDK 와의 연동을 위해 꼭 선언해주어야 합니다.
		ADLIBrHybridInterface.enableBridgeScript(m_webView, this);
	}
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		if(m_webView != null){
			if (keyCode == KeyEvent.KEYCODE_BACK) {
				if(m_webView.canGoBack()){
					m_webView.goBack();
					return true;
				}
			}
		}
		
		return super.onKeyDown(keyCode, event);
	}
}
