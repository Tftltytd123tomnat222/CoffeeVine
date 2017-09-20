package pkgCodeMD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ng1an
 */
public class lgMD5 {

    public lgMD5() {
    }
    
    public static String hashPass(String pass) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] b = md.digest();
        StringBuffer  sb = new StringBuffer();
        for (byte c : b) {
            sb.append(Integer.toHexString(c&0xff));
        }
        return sb.toString();
    }
}
