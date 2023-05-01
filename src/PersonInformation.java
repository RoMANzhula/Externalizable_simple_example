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

    public PersonInformation() { //конструктор класса без параметров (конструктор по-умолчанию) - обязательный при использовании
        //интерфейса Externalizable (это одно из отличий от Serializable, в котором используется Reflection API)
    }

    public PersonInformation(String name, int phoneNumber, String gender, String secretPassword) { //конструктор с параметрами
        this.name = name; //инициализация полей класса
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.secretPassword = secretPassword;
    }

    @Override //обязательный для реализации метод интерфейса Externalizable (для сохранения данных)
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getName()); //записываем(сохраняем) имя
        out.writeObject(this.getPhoneNumber()); //записываем(сохраняем) номер телефона
        out.writeObject(this.getGender()); //записываем(сохраняем) гендерную принадлежность
        out.writeObject(this.encryptString(this.getSecretPassword())); //записываем(сохраняем) пароль, закодировав его с
        //помощью метода интерфейса EncryptData encryptString()
    }

    @Override //обязательный для реализации метод интерфейса Externalizable (для загрузки данных)
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject(); //считываем(загружаем) имя
        phoneNumber = (int) in.readObject(); //считываем(загружаем) номер телефона
        gender = (String) in.readObject(); //считываем(загружаем) гендерную принадлежность
        secretPassword = this.decryptString((String) in.readObject()); //считываем(загружаем) пароль, раскодировав его с
        //помощью метода интерфейса EncryptData decryptString()
    }

    @Override //имплементируем метод интерфейса EncryptData для шифрования, оставив его без изменений в функционале
    public String encryptString(String data) {
        return EncryptData.super.encryptString(data);
    }

    @Override //имплементируем метод интерфейса DecryptData для расшифрования, оставив его без изменений в функционале
    public String decryptString(String data) {
        return DecryptData.super.decryptString(data);
    }

    //только Геттеры для полей класса
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

    @Override //переопределяем метод к строковому виду
    public String toString() {
        return "PersonInformation{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", gender='" + gender + '\'' +
                ", secretPassword='" + secretPassword + '\'' +
                '}';
    }
}
