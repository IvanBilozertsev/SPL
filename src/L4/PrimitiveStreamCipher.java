package L4;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ivan on 17.12.2016.
 */
public class PrimitiveStreamCipher implements StreamEncryptionInterface{

    public byte[] encrypt(byte[] message, byte[] key){
        byte gamma = 0;
        byte[] ciphertext = message.clone();
        for(int i = 0; i < key.length; i++)
            gamma ^= key[i];
        for(int i = 0; i < message.length; i++)
            ciphertext[i] ^= gamma;
        return ciphertext;
    }

    public byte[] decrypt(byte[] cipherText, byte[] key){
        byte gamma = 0;
        byte[] message = cipherText.clone();
        for(int i = 0; i < key.length; i++)
            gamma ^= key[i];
        for(int i = 0; i < cipherText.length; i++)
            message[i] ^= gamma;
        return message;
    }

}
