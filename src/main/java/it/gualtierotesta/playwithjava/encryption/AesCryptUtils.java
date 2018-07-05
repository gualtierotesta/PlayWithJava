package it.gualtierotesta.playwithjava.encryption;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Objects;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES encryption utils
 */
public class AesCryptUtils {

    private final byte[] passPhrase;  // 16 chars
    private final Provider provider;

    public AesCryptUtils(final String pPassPhrase, final Provider pProvider) {
        passPhrase = Objects.requireNonNull(pPassPhrase).getBytes(StandardCharsets.UTF_8);
        provider = pProvider;
    }

    public byte[] encrypt(final byte[] pClearText) throws AesCryptException {
        try {
            byte[] text = Objects.requireNonNull(pClearText);
            SecretKeySpec key = new SecretKeySpec(passPhrase, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding", provider);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(text);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            throw new AesCryptException("Failed encryption", ex);
        }
    }

    public String encrypt(final String pClearText) throws AesCryptException {
        return new String(encrypt(pClearText.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }

    public byte[] decrypt(final byte[] pEncryptedText) throws AesCryptException {
        try {
            SecretKeySpec key = new SecretKeySpec(passPhrase, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding", provider);
            cipher.init(Cipher.DECRYPT_MODE, key);
            return cipher.doFinal(pEncryptedText);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            throw new AesCryptException("Failed decryption", ex);
        }
    }

    public String decrypt(final String pEncryptedText) throws AesCryptException {
        return new String(decrypt(pEncryptedText.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }

}
