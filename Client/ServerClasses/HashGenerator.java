package ServerClasses;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//https://www.geeksforgeeks.org/md5-hash-in-java/

public class HashGenerator {
           public static String getHash(String val)
           {
               try {
                   MessageDigest mg = MessageDigest.getInstance("MD5");
                   byte[] msg = mg.digest(val.getBytes());
                   BigInteger hash = new BigInteger(1,msg); //1 is for signed magnitude represenation
                   //Encoding in HexaDecimal
                   String encodedHash = hash.toString(16);
                   while(encodedHash.length()<32)
                       encodedHash = "0"+encodedHash;
                   return encodedHash;
               } catch (NoSuchAlgorithmException e) {
                   e.printStackTrace();
               }
               return null;
           }
}
