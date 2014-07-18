package com.g36bk.caipiao.view;

import com.g36bk.caipiao.R;
import com.g36bk.caipiao.net.protocal.Message;
import com.g36bk.caipiao.net.protocal.element.CurrentIssueElement;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		createXMl();
		
	}
	
	public void createXMl() {
		Message message = new Message();
		CurrentIssueElement element = new CurrentIssueElement();
		element.getLotteryid().setTagValue("118");
		String xml = message.getXml(element);
//		System.out.println(xml);
		Log.i("xml", xml);
	}

}
