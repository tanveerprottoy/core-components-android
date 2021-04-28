package com.tanveershafeeprottoy.corecomponents.utils;

import android.util.Base64;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CryptographyUtils {
    private static final String RSA_ECB_PKCS1_PADDING = "RSA/ECB/PKCS1Padding";
    private static final String CRYPTO_METHOD = "RSA";
    private static byte[] keyBytes;
    private static KeyFactory keyFactory;
    private static Cipher cipher;

    @NonNull
    public static String getCleanPublicKey(@NonNull String publicKeyString) {
        // clean the key
        return publicKeyString.replaceAll("\\n", "")
                              .replace("-----BEGIN PUBLIC KEY-----", "")
                              .replace("-----END PUBLIC KEY-----", "")
                              .replace(" ", "");
    }

    @NonNull
    public static String getCleanPrivateKey(@NonNull String privateKeyString) {
        // clean the key
        return privateKeyString.replaceAll("\\n", "")
                               .replace("-----BEGIN PRIVATE KEY-----", "")
                               .replace("-----END PRIVATE KEY-----", "")
                               .replace(" ", "");
    }

    @Nullable
    public static PublicKey stringToPublicKey(@NonNull String publicKeyString) {
        try {
            keyBytes = Base64.decode(publicKeyString, Base64.DEFAULT);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            keyFactory = KeyFactory.getInstance(CRYPTO_METHOD);
            return keyFactory.generatePublic(spec);
        }
        catch(InvalidKeySpecException | NoSuchAlgorithmException e) {
            return null;
        }
    }

    @Nullable
    public static PrivateKey stringToPrivateKey(@NonNull String privateKeyString) {
        try {
            keyBytes = Base64.decode(privateKeyString, Base64.DEFAULT);
            PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
            keyFactory = KeyFactory.getInstance(CRYPTO_METHOD);
            return keyFactory.generatePrivate(pKCS8EncodedKeySpec);
        }
        catch(InvalidKeySpecException | NoSuchAlgorithmException e) {
            return null;
        }
    }

    @Nullable
    public static byte[] encryptRSA(Key publicKey, String textData) {
        try {
            cipher = Cipher.getInstance(RSA_ECB_PKCS1_PADDING);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return cipher.doFinal(textData.getBytes(StandardCharsets.UTF_8));
        }
        catch(Exception e) {
            return null;
        }
    }

    @Nullable
    public static byte[] decryptRSA(Key privateKey, byte[] data) {
        try {
            cipher = Cipher.getInstance(RSA_ECB_PKCS1_PADDING);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return cipher.doFinal(data);
        }
        catch(Exception e) {
            return null;
        }
    }

    public static String encodeToString(byte[] encryptedData) {
        try {
            return Base64.encodeToString(encryptedData, Base64.DEFAULT);
        }
        catch(Exception e) {
            return "";
        }
    }

    @NonNull
    public static String decodeToString(byte[] decryptedData) {
        try {
            return new String(decryptedData);
        }
        catch(Exception e) {
            return "";
        }
    }
}
