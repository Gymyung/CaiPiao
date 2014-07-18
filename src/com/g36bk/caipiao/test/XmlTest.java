/**
 * 
 */
package com.g36bk.caipiao.test;

import com.g36bk.caipiao.net.protocal.Message;
import com.g36bk.caipiao.net.protocal.element.CurrentIssueElement;

import android.test.AndroidTestCase;
import android.util.Log;

/**
 * =========================================================
 * @author Administrator
 * @description Xml测试类
 * @since 2014-7-18 下午10:20:05
 * =========================================================
 */
public class XmlTest extends AndroidTestCase {
	private static final String TAG = "XmlTest";

	public void createXMl() {
		Message message = new Message();
		CurrentIssueElement element = new CurrentIssueElement();
		element.getLotteryid().setTagValue("118");
		String xml = message.getXml(element);
		System.out.println(xml);
		Log.i(TAG, xml);
	}
}
