package com.g36bk.caipiao.net.protocal;

import org.xmlpull.v1.XmlSerializer;

public class Element {
	private Leaf lotteryid = new Leaf("lotteryid");
	
	private Leaf issues = new Leaf("issues","1");

	public Leaf getLotteryid() {
		return lotteryid;
	}
	
	public void serialiserElement(XmlSerializer serializer){
		try {
			serializer.startTag(null, "element");

			lotteryid.serialiserLeaf(serializer);
			issues.serialiserLeaf(serializer);
			
			serializer.endTag(null, "element");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
