package com.g36bk.caipiao.net.protocal;

import org.xmlpull.v1.XmlSerializer;

public class Leaf {
	private String tagName;
	private String tagValue;
	
	
	public Leaf(String tagName) {
		super();
		this.tagName = tagName;
	}



	public Leaf(String tagName, String tagValue) {
		super();
		this.tagName = tagName;
		this.tagValue = tagValue;
	}


	public void serialiserLeaf(XmlSerializer serializer){
		try {
			serializer.startTag(null, tagName);
			serializer.text(tagValue);
			serializer.endTag(null, tagName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public String getTagName() {
		return tagName;
	}



	public void setTagName(String tagName) {
		this.tagName = tagName;
	}



	public String getTagValue() {
		return tagValue;
	}



	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}
	
	
	
}
