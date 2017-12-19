package com.stylefeng.guns.core.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

/**
 * @author wangwei
 * @date 2017/12/17
 */
public class AesUtils {
    private static final Logger log = LoggerFactory.getLogger(AesUtils.class);

    public AesUtils() {
    }

    public static byte[] encrypt(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes("UTF-8"));
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, key);
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception var9) {
            log.error("使用AES加密发生错误", var9);
            return null;
        }
    }

    public static String encrypt(String plaintext, String password, String encoding) throws UnsupportedEncodingException {
        byte[] input = Base64.encodeBase64(plaintext.getBytes(encoding));
        byte[] results = encrypt(input, password);
        byte[] base64bytes = Base64.encodeBase64(results);
        String ciphertext = new String(base64bytes);
        log.debug("plaintext:{} ciphertext:{}", plaintext, ciphertext);
        return ciphertext;
    }

    public static byte[] decrypt(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes("UTF-8"));
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, key);
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception var9) {
            log.error("使用AES解密发生错误", var9);
            return null;
        }
    }

    public static String decrypt(String ciphertext, String password, String encoding) throws UnsupportedEncodingException {
        byte[] input = Base64.decodeBase64(ciphertext.getBytes(encoding));
        byte[] results = decrypt(input, password);
        byte[] base64bytes = Base64.decodeBase64(results);
        if(base64bytes == null) {
            throw new RuntimeException("解密数据失败");
        } else {
            String plaintext = new String(base64bytes);
            log.debug("ciphertext:{} plaintext:{}", ciphertext, plaintext);
            return plaintext;
        }
    }
}
