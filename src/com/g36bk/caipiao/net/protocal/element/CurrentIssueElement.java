/**
 * 
 */
package com.g36bk.caipiao.net.protocal.element;

import org.xmlpull.v1.XmlSerializer;

import com.g36bk.caipiao.net.protocal.Element;
import com.g36bk.caipiao.net.protocal.Leaf;

/**
 * =========================================================
 * @author Administrator
 * @description 获取当前销售期的请求
 * @since 2014-7-18 下午10:13:21
 * =========================================================
 */
public class CurrentIssueElement extends Element {
	private Leaf lotteryid = new Leaf("lotteryid");
	private Leaf issues = new Leaf("issues", "1");

	/* (non-Javadoc)
	 * @see com.g36bk.caipiao.net.protocal.Element#serializerElement(org.xmlpull.v1.XmlSerializer)
	 */
	@Override
	public void serializerElement(XmlSerializer serializer) {
		try {
			serializer.startTag(null, "element");
			lotteryid.serialiserLeaf(serializer);
			issues.serialiserLeaf(serializer);
			serializer.endTag(null, "element");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.g36bk.caipiao.net.protocal.Element#getTransactionType()
	 */
	@Override
	public String getTransactionType() {
		return "12002";
	}

	public Leaf getLotteryid() {
		return lotteryid;
	}
	
	

}
