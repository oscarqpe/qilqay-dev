package com.os.foro.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 
 * @author OscarEdmit
 *
 */
public class OsUtil {
	private static final String saltoPassword = "PASSWORD";
	public static String getSecurePassword(String passwordToHash) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(saltoPassword.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
	public static Boolean isNullOrEmpty(String email) {
		if (email != null) {
			if (email.equals(""))
				return true;
			else 
				return false;
		} else {
			return true;
		}
	}
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
