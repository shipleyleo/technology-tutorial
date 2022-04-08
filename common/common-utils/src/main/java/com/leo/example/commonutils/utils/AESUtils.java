package com.leo.example.commonutils.utils;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.Security;

/**
 * <p>
 * AES/ECB/PKCS7Padding算法工具
 * </p>
 * <p>
 * Copyright: 2022 . All rights reserved.
 * </p>
 */
public abstract class AESUtils {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public AESUtils() {
    }

    private static final Logger LOG = LoggerFactory.getLogger(AESUtils.class);
    private static final String ALGORITHM = "AES/ECB/PKCS7Padding";
    private static final String ALGORITHM_NAME = "AES";

    private static Key getKey(String key) {
        return new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM_NAME);
    }

    /**
     * 加密
     *
     * @param key   加密key
     * @param value 明文
     * @return 返回加密后的串
     */
    public static String encrypt(String key, String value) {
        if (StringUtils.length(key) != 16) {
            throw new IllegalArgumentException("加密Key必须长度16位。");
        }

        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, getKey(key));
            return Hex.encodeHexString(cipher.doFinal(value.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            LOG.error("aes加密出现异常。", e);
        }
        return null;
    }

    /**
     * 解密
     *
     * @param key   加密key
     * @param value 密文
     * @return 返回解密后的串
     */
    public static String decrypt(String key, String value) {
        if (StringUtils.length(key) != 16) {
            throw new IllegalArgumentException("加密Key必须长度16位。");
        }
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, getKey(key));
            return new String(cipher.doFinal(Hex.decodeHex(value.toCharArray())), StandardCharsets.UTF_8);
        } catch (Exception e) {
            LOG.error("aes解密出现异常。", e);
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        final String key = "e3XxEhkWSKcA7App";
        String a = encrypt(key, "testData4demo");
        System.out.println(a);
        System.out.println(decrypt(key, a));

        System.out.println(a);
        System.out.println(decrypt(key, a));
    }
}
