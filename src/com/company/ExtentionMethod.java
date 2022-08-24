package com.company;

import java.util.Base64;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;


public class ExtentionMethod {
    public static byte[] encodeByte(String password) throws UnsupportedEncodingException {
        byte[] result = password.getBytes(StandardCharsets.UTF_8);
        return result;
    }

    public static String encodeString(String password) throws UnsupportedEncodingException {
        byte[] result = password.getBytes(StandardCharsets.UTF_8);
        String encodeString = Base64.getEncoder().encodeToString(result);

        return encodeString;
    }

    public static String decodeString(String password) throws UnsupportedEncodingException {
        byte[] result2 = Base64.getDecoder().decode(password);
        String originalData = new String(result2, StandardCharsets.UTF_8);

        return originalData;

    }

    public static String decodeByte(String password) throws UnsupportedEncodingException {

        byte[] result = password.getBytes(StandardCharsets.UTF_8);
        String originalData2 = new String(result, StandardCharsets.UTF_8);
        return originalData2;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String pw = "thonguyenhuu";
        System.out.println("Password: " + pw);
        System.out.print("EncodeByte: ");
        byte[] result = encodeByte(pw);
        for (byte b : result) {
            System.out.print(String.format("%s \t", b));

        }
        String encodeString = encodeString(pw);
        System.out.println("\nEncodeString: " + encodeString);
        String decodeString = decodeString(encodeString);
        System.out.println("DecodeString: " + decodeString);
        String decodeByte = decodeByte(pw);
        System.out.println("DecodeByte: " + decodeByte);
    }
}