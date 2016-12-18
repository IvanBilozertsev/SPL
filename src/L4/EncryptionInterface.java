package L4;

/**
 * Created by Ivan on 17.12.2016.
 */
public interface EncryptionInterface {
    byte[] encrypt(byte[] in, byte[] key);
    byte[] decrypt(byte[] in, byte[] key);
}
