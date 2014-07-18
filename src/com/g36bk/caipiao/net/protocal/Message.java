package com.g36bk.caipiao.net.protocal;

import java.io.StringWriter;

import org.xmlpull.v1.XmlSerializer;

import com.g36bk.caipiao.util.ConstantValue;

import android.util.Xml;

public class Message {
	private Header header = new Header();
	private Body body = new Body();
	/**
	 * 序列化协议
	 */
	public void serialiserMessage(XmlSerializer serializer){
		try {
			serializer.startTag(null, "message");
			serializer.attribute(null, "version", "1.0");
			
			header.serialiserHeader(serializer, body.getWholeBody());
			serializer.startTag(null, "body");
			serializer.text(body.getBodyDESInfo());
			serializer.endTag(null, "body");
			
			serializer.endTag(null, "message");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 获取请求的xml文件 */
	public String getXml(Element element){
		if (element == null) {
			throw new IllegalArgumentException("element is null");
		}
		// 请求标示需要设置，请求内容需要设置
		header.getTransactiontype().setTagValue(element.getTransactionType());
		body.getElements().add(element);
		
		XmlSerializer xmlSerializer = Xml.newSerializer();
		StringWriter stringWriter = new StringWriter();
		
		try {
			xmlSerializer.setOutput(stringWriter);
			xmlSerializer.startDocument(ConstantValue.ENCONDING, null);
			this.serialiserMessage(xmlSerializer);
			xmlSerializer.endDocument();
			
			return stringWriter.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
