package giter.jackalope.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

  static MessageDigest md;

  static {
    try {
      md = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  public static String md5(String val) {

    synchronized (md) {

      StringBuilder sb = new StringBuilder();

      md.reset();

      for (byte b : md.digest(val.getBytes())) {
        sb.append("0123456789abcdef".charAt((b & 0xf0) >> 4));
        sb.append("0123456789abcdef".charAt(b & 0x0f));
      }

      return sb.toString();

    }

  }
}
