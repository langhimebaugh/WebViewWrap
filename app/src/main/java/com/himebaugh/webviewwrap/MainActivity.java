package com.himebaugh.webviewwrap;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		WebView browser = (WebView) findViewById(R.id.webView1);

		browser.getSettings().setJavaScriptEnabled(true);
		browser.getSettings().setGeolocationEnabled(true);
		browser.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		browser.getSettings().setBuiltInZoomControls(true);
		browser.getSettings().setDomStorageEnabled(true);

		browser.setWebChromeClient(new WebChromeClient() {
			public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
				callback.invoke(origin, true, false);
			}
		});

		browser.loadUrl("http://captmarkschmidt.com/");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
