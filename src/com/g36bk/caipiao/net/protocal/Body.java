package com.g36bk.caipiao.net.protocal;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.xmlpull.v1.XmlSerializer;

import com.g36bk.caipiao.util.ConstantValue;
import com.g36bk.caipiao.util.DES;

import android.util.Xml;

public class Body {
	private List<Element> elements=new ArrayList<Element>();
	
	/** 序列化请求内容 */
	public void serialiserBody(XmlSerializer serializer){
		try {
			serializer.startTag(null, "body");
			serializer.startTag(null, "elements");

			for(Element element : elements){
				element.serializerElement(serializer);
			}
			
			serializer.endTag(null, "elements");
			serializer.endTag(null, "body");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/** 获取完整的协议body */
	public String getWholeBody(){
		StringWriter writer = new StringWriter();
		
		XmlSerializer serializer = Xml.newSerializer();
		try {
			serializer.setOutput(writer);
			this.serialiserBody(serializer);
			serializer.flush();
			return writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** 获取完整的协议body内部的DES加密数据 */
	public String getBodyDESInfo(){
		String body = getWholeBody();
		
		String desInfo = StringUtils.substringBetween(body,"<body>", "</body>");
		
		DES des = new DES();
		
		return des.authcode(desInfo, "DECODE", ConstantValue.DES_PASSWORD);
	}
	
	
	

	public List<Element> getElements() {
		return elements;
	}
	
	
}
