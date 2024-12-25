import java.util.Base64;

public interface EncryptData {
    public default String encryptString(String data) { // mетод для кодування даних (стандарт кодування двійкових
        // даних за допомогою лише 64 символів ASCII. Алфавіт кодування містить латинські символи A-Z, a-z, цифри 0-9)
        String bufferForEncryptedData = Base64.getEncoder().encodeToString(data.getBytes());
        return bufferForEncryptedData;
    }
}
