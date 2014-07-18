package com.g36bk.caipiao.net.protocal;

import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlSerializer;

public class Body {
	private List<Element> elements=new ArrayList<Element>();
	
	public void serialiserBody(XmlSerializer serializer){
		try {
			serializer.startTag(null, "body");
			serializer.startTag(null, "elements");

			for(Element element : elements){
				element.serialiserElement(serializer);
			}
			
			serializer.endTag(null, "elements");
			serializer.endTag(null, "body");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
