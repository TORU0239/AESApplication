package sg.toru.aesapplication

import android.util.Log
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey


fun encrypt(password:String,
            key:SecretKey):ByteArray{
    val cipher = Cipher.getInstance(BuildConfig.KEY_ENCRYPTION)
    cipher.init(Cipher.ENCRYPT_MODE, key)
    return cipher.doFinal(password.toByteArray())
}

fun decrypt(password:ByteArray,
            key:SecretKey):String{
    val cipher = Cipher.getInstance(BuildConfig.KEY_ENCRYPTION)
    cipher.init(Cipher.DECRYPT_MODE, key)
    val output = cipher.doFinal(password)
    return String(output, Charsets.UTF_8)
}

fun generateKey():SecretKey{
    val keyGen = KeyGenerator.getInstance(BuildConfig.KEY_ENCRYPTION)
    keyGen.init(256)
    return keyGen.generateKey()
}

/*
* Aes256Class aes256 = new Aes256Class();

    String targetString = "Hello";

    byte[] encryptedString = makeAes(targetString.getBytes(), Cipher.ENCRYPT_MODE);
    Log.d("Encoded string: ", new String(encryptedString));
    byte[] decodedString = makeAes(encryptedString, Cipher.DECRYPT_MODE);
    Log.d("Decoded string: ", new String(decryptedString));
*
*
* */

/*
* public class Aes256Class {

    private SecretKey secretKey;

    public Aes256Class() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);

            secretKey = keyGenerator.generateKey();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public byte[] makeAes(byte[] rawMessage, int cipherMode) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, this.secretKey);
            byte[] output = cipher.doFinal(rawMessage);
            return output;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
*
*
* */