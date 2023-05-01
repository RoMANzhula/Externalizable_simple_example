import java.util.Base64;

public interface DecryptData {
    public default String decryptString(String data) { //метод для раскодирования данных
        String bufferForDecryptedData = new String(Base64.getDecoder().decode(data));
        return bufferForDecryptedData;
    }
}
