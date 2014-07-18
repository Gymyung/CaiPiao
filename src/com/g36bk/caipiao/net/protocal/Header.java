package com.g36bk.caipiao.net.protocal;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.xmlpull.v1.XmlSerializer;

import android.annotation.SuppressLint;
import com.g36bk.caipiao.util.ConstantValue;

@SuppressLint("SimpleDateFormat")
public class Header {
	private Leaf agentid = new Leaf("agentid",ConstantValue.AGENTERID);
	
	// <source>ivr</source>
	private Leaf source = new Leaf("source",ConstantValue.SOURCE);
		// <compress>DES</compress>
	private Leaf compress = new Leaf("compress",ConstantValue.COMPRESS);
	
	private Leaf messagerid = new Leaf("messagerid");
	
	private Leaf timestamp = new Leaf("timestamp");
	
	private Leaf digest = new Leaf("digest");
	
	private Leaf transactiontype = new Leaf("transactiontype");
	
	private Leaf username = new Leaf("username");
	
	public void serialiserHeader(XmlSerializer serializer,String pwd){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = dateFormat.format(new Date());
		timestamp.setTagValue(date);
		Random random = new Random();
		int number = random.nextInt(999999)+1;
		DecimalFormat decimalFormat = new DecimalFormat("000000");
		messagerid.setTagValue(date+decimalFormat.format(number));
		
		String orderInfo = date+ConstantValue.AGENTER_PASSWORD+pwd;
		String md5Hex = DigestUtils.md5Hex(orderInfo);
		digest.setTagValue(md5Hex);
		
		try {
			serializer.startTag(null, "header");

			agentid.serialiserLeaf(serializer);
			source.serialiserLeaf(serializer);
			compress.serialiserLeaf(serializer);
			
			messagerid.serialiserLeaf(serializer);
			timestamp.serialiserLeaf(serializer);
			
			digest.serialiserLeaf(serializer);
			transactiontype.serialiserLeaf(serializer);
			username.serialiserLeaf(serializer);
			
			serializer.endTag(null, "header");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Leaf getTransactiontype() {
		return transactiontype;
	}

	public Leaf getUsername() {
		return username;
	}
	
	
	
}
