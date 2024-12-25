import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class PersonInformation implements Externalizable, EncryptData, DecryptData {
    private String name;
    private int phoneNumber;
    private String gender;
    private String secretPassword;

    private static final long serialVersionUID = 1L;

    public PersonInformation() { // конструктор класу без параметрів (конструктор за замовчуванням) - обов'язковий при використанні
        // інтерфейсу Externalizable (це одна з відмінностей від Serializable, де використовується Reflection API)
    }

    public PersonInformation(String name, int phoneNumber, String gender, String secretPassword) { // конструктор з параметрами
        this.name = name; // ініціалізація полів класу
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.secretPassword = secretPassword;
    }

    @Override // обов'язковий для реалізації метод інтерфейсу Externalizable (для збереження даних)
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getName()); // записуємо (зберігаємо) ім'я
        out.writeObject(this.getPhoneNumber()); // записуємо (зберігаємо) номер телефону
        out.writeObject(this.getGender()); // записуємо (зберігаємо) гендерну приналежність
        out.writeObject(this.encryptString(this.getSecretPassword())); // записуємо (зберігаємо) пароль, закодувавши його за
        // допомогою методу інтерфейсу EncryptData encryptString()
    }

    @Override // обов'язковий для реалізації метод інтерфейсу Externalizable (для завантаження даних)
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject(); // зчитуємо (завантажуємо) ім'я
        phoneNumber = (int) in.readObject(); // зчитуємо (завантажуємо) номер телефону
        gender = (String) in.readObject(); // зчитуємо (завантажуємо) гендерну приналежність
        secretPassword = this.decryptString((String) in.readObject()); // зчитуємо (завантажуємо) пароль, розшифрувавши його за
        // допомогою методу інтерфейсу EncryptData decryptString()
    }

    @Override // імплементуємо метод інтерфейсу EncryptData для шифрування, залишаючи його без змін у функціоналі
    public String encryptString(String data) {
        return EncryptData.super.encryptString(data);
    }

    @Override // імплементуємо метод інтерфейсу DecryptData для розшифрування, залишаючи його без змін у функціоналі
    public String decryptString(String data) {
        return DecryptData.super.decryptString(data);
    }

    // тільки Геттері для полів класу
    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getSecretPassword() {
        return secretPassword;
    }

    @Override // переозначаємо метод до строкового виду
    public String toString() {
        return "PersonInformation{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", gender='" + gender + '\'' +
                ", secretPassword='" + secretPassword + '\'' +
                '}';
    }
}
