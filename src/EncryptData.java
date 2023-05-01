import java.util.Base64;

public interface EncryptData {
    public default String encryptString(String data) { //метод для кодирования данных (стандарт кодирования двоичных
        // данных при помощи только 64 символов ASCII. Алфавит кодирования содержит латинские символы A-Z, a-z, цифры 0-9)
        String bufferForEncryptedData = Base64.getEncoder().encodeToString(data.getBytes());
        return bufferForEncryptedData;
    }
}
