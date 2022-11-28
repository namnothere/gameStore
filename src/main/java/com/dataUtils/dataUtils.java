package com.dataUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import java.util.logging.Level;
import java.util.logging.Logger;

public class dataUtils {

    final protected static char[] hexArray = "0123456789ABCDEF"
    .toCharArray();
    
    public static MongoClient client = null;
    private static final Logger LOGGER = Logger.getLogger(dataUtils.class
    .getClass().getName());


    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0; j < bytes.length; j++) {
          v = bytes[j] & 0xFF;
          hexChars[j * 2] = hexArray[v >>> 4];
          hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
      }
      


    private static String SALT = "123456";

    public static String hashPassword(String in) {
        try {
          MessageDigest md = MessageDigest
              .getInstance("SHA-256");
          md.update(SALT.getBytes());        // <-- Prepend SALT.
          md.update(in.getBytes());
          // md.update(SALT.getBytes());     // <-- Or, append SALT.
      
          byte[] out = md.digest();
          return bytesToHex(out);            // <-- Return the Hex Hash.
        } catch (NoSuchAlgorithmException e) {
          e.printStackTrace();
        }
        return "";
    }

    public static boolean validatePassword(String password) {
      // Password should follows these rules:
      // 1. At least 8 characters long
      // 2. At least 1 digit
      // 3. At least 1 upper case letter
      // 4. At least 1 special character
      // 5. No white space (space, tab, newline)

      if (password.length() < 8) {
        return false;
      }
      
      boolean hasDigit = false;
      boolean hasUpperCase = false;
      boolean hasSpecialChar = false;
      boolean hasWhiteSpace = false;

      for (int i = 0; i < password.length(); i++) {
        char c = password.charAt(i);
        if (Character.isDigit(c)) {
          hasDigit = true;
        } else if (Character.isUpperCase(c)) {
          hasUpperCase = true;
        } else if (!Character.isLetterOrDigit(c)) {
          hasSpecialChar = true;
        } else if (Character.isWhitespace(c)) {
          hasWhiteSpace = true;
        }
      }

      return hasDigit && hasUpperCase && hasSpecialChar && !hasWhiteSpace;
    }

    public static Date epochToDate(long epoch) {
      // convert epoch to date
      Date date = new Date(epoch);
      return date;
    }

    private static MongoClient getMongoClient() {
      String uri = "mongodb+srv://aegis:aegis@baekettle.lkh9f.mongodb.net/?retryWrites=true&w=majority";
      MongoClient mongoClient = MongoClients.create(uri);
      dataUtils.client = mongoClient;
      // System.out.println("Connected to MongoDB");
      return mongoClient;
    }

    public static MongoClient getMongoClientInstance() {
      if (dataUtils.client == null) {
        return getMongoClient();
      } else {
        return dataUtils.client;
      }
    }

    public static void disconnect() {
      try {
        if (dataUtils.client != null) {
          dataUtils.client.close();
          LOGGER.log(Level.INFO, "Disconnected from MongoDB");
        }
      } catch (Exception e) {
        // e.printStackTrace();
        LOGGER.log(Level.SEVERE, "[disconnect] " + e);
      }
    }

    public static void main(String[] args) {
        String password = "123456";
        String hashedPassword = hashPassword(password);
        System.out.println("hashedPassword: " + hashedPassword);

        boolean isValid = validatePassword(password);
        System.out.println("isValid: " + isValid);

        long epoch = 1667594672;
        Date date = epochToDate(epoch);
        System.out.println("Date: " + date);

    }
}
