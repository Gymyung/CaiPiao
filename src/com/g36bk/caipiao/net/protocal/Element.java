package com.g36bk.caipiao.net.protocal;

import org.xmlpull.v1.XmlSerializer;

public abstract class Element {
	/**
	 * 每个请求都需要序列化自己
	 * @param serializer
	 */
	public abstract void serializerElement(XmlSerializer serializer);
	// ②每个请求都有自己的标示
	/**
	 * 每个请求都有自己的标示
	 * @return
	 */
	public abstract String getTransactionType();
	
}
