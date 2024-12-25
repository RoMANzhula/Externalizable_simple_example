import java.util.Base64;

public interface DecryptData {
    public default String decryptString(String data) { //метод для розкодування даних
        String bufferForDecryptedData = new String(Base64.getDecoder().decode(data));
        return bufferForDecryptedData;
    }
}
