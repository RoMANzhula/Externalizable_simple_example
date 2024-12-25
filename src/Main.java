import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String pathToFile = "C:\\Users\\Admin\\Desktop\\Новий текстовий документ.txt"; //шлях до файлу ініціалізуємо в змінну

        ////код для збереження даних

        FileOutputStream fileOutputStream = new FileOutputStream(pathToFile); //відкриваємо потік для запису даних у файл
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); //підклас класу OutputStream, в
        //арсеналі якого є метод для запису даних (примітивних та об'єктів)

        PersonInformation person1 = new PersonInformation("Mykola Bond",
                007, "Man in black", "Mother's Maiden Name"); //створюємо новий об'єкт і ініціалізуємо
        //його, відповідно до конструктора його класу

        objectOutputStream.writeObject(person1); //пишемо в потік дані про об'єкт
        objectOutputStream.close(); //очищуємо ресурси (можна скористатись try-with-resource)

        ////код для завантаження даних

        FileInputStream fileInputStream = new FileInputStream(pathToFile); //відкриваємо потік для читання даних з файлу
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream); //підклас класу InputStream, в
        //арсеналі якого є метод для читання (витягування) даних (примітивних та об'єктів)

        PersonInformation clonePerson1 = (PersonInformation) objectInputStream.readObject(); //створюємо посилальну змінну
        //типу класу PersonInformation і ініціалізуємо її вчитаними даними з вказаного файлу, приведеними до типу класу
        //PersonInformation (обробляємо виключення ClassNotFoundException)

        System.out.println("Результат woo a la... : " + clonePerson1); //виводимо на консоль інформацію

        objectInputStream.close(); //очищуємо ресурси

    }
}
