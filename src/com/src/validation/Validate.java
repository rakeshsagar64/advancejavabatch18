package com.src.validation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Validate {
	
	private Validate(){
		
	}
	
	
	public static String encryptPassword(String original) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("sha-256");
		byte[] digest = md.digest(original.getBytes());
		StringBuffer sb=new StringBuffer();
		for(byte b:digest){
				sb.append(Integer.toHexString(0xff & b));
			
		}
		return sb.toString();
		
	}
	
	

}
