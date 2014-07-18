package com.g36bk.caipiao.net.protocal;

import java.io.StringWriter;

import org.xmlpull.v1.XmlSerializer;

import com.g36bk.caipiao.util.ConstantValue;

import android.util.Xml;

public class Message {
	private Header header = new Header();
	private Body body = new Body();
	
	public void serialiserMessage(XmlSerializer serializer){
		try {
			serializer.startTag(null, "message");
			serializer.attribute(null, "version", "1.0");
			
			header.serialiserHeader(serializer, "");
			body.serialiserBody(serializer);
			
			serializer.endTag(null, "message");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String getXml(){
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
