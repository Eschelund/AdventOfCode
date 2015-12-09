package Day4;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4_1 {
	//Done
	
	/*
	 * Santa needs help mining some AdventCoins (very similar to bitcoins) to use as gifts for all the economically forward-thinking little girls and boys.
	 * To do this, he needs to find MD5 hashes which, in hexadecimal, start with at least five zeroes. The input to the MD5 hash is some secret key (your puzzle input, given below) followed by a number in decimal. To mine AdventCoins, you must find Santa the lowest positive number (no leading zeroes: 1, 2, 3, ...) that produces such a hash.
	 * 
	 * For example:
	 * If your secret key is abcdef, the answer is 609043, because the MD5 hash of abcdef609043 starts with five zeroes (000001dbbfa...), and it is the lowest such number to do so.
	 * If your secret key is pqrstuv, the lowest number it combines with to make an MD5 hash starting with five zeroes is 1048970; that is, the MD5 hash of pqrstuv1048970 looks like 000006136ef....
	 */

	public static void main(String[] args) {
		String key = new String("iwrupvqb");
		int baseNumber = 1;
		boolean found = false;
		String md5 = "";
		do {
			try {
				md5 = createMD5(key, baseNumber);
				if (md5.substring(0, 5).equals("00000"))  {
					found = true;
					break;
				}
			} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			System.out.println(baseNumber + " : " + md5);
			baseNumber++;
		}
		while (!found);
		
		System.out.println("The lowest number to make the MD5 hash is: " + baseNumber + " : " + md5);
	}
	
	private static String createMD5(String key, int num) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String md5String = key+num;
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] bytes = md.digest(md5String.getBytes(Charset.forName("UTF-8")));
		
		String result = "";

	   for (int i=0; i < bytes.length; i++) {
	       result += Integer.toString( ( bytes[i] & 0xff ) + 0x100, 16).substring( 1 );
	   }
	   return result;
	}

}
