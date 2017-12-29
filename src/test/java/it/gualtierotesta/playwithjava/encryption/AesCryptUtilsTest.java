package it.gualtierotesta.playwithjava.encryption;

import java.nio.charset.Charset;
import java.security.Provider;
import java.security.Security;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test
 */
public class AesCryptUtilsTest {

    private static String passPhrase = "1234567890123456";  // 16 char

    @Test
    public void testBouncyCastle() throws Exception {
        for (int i = 0; i < 10; i++) {
            String text = RandomStringUtils.random(RandomUtils.nextInt(1, 5000));
            Assert.assertEquals(text, run(text, new BouncyCastleProvider()));
        }
    }

    @Test
    public void testDefault() throws Exception {
        for (int i = 0; i < 10; i++) {
            String text = RandomStringUtils.random(RandomUtils.nextInt(1, 5000));
            Assert.assertEquals(text, run(text, Security.getProvider("SunJCE")));
        }

    }

    private static String run(String pText, final Provider pProvider) throws Exception {
        AesCryptUtils aesCryptUtils = new AesCryptUtils(passPhrase, pProvider);
        byte[] encrypted = aesCryptUtils.encrypt(pText.getBytes(Charset.forName("UTF-8")));
        byte[] decrypted = aesCryptUtils.decrypt(encrypted);
        return new String(decrypted, Charset.forName("UTF-8"));
    }

}
