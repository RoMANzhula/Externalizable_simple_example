import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String pathToFile = "C:\\Users\\Admin\\Desktop\\Новий текстовий документ.txt"; //путь к файлу инициализируем в переменную

        ////код для сохранения данных

        FileOutputStream fileOutputStream = new FileOutputStream(pathToFile); //открываем поток для записи данных в файл
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); //подкласс класса OutputStream, в
        //арсенале которого есть метод для записи данных (примитивных и обьектов)

        PersonInformation person1 = new PersonInformation("Mykola Bond",
                007, "Man in black", "Mother's Maiden Name"); //создаем новый обьект и инициализируем
        //его, согласно конструктора его класса

        objectOutputStream.writeObject(person1); //пишем в поток данные о обьекте
        objectOutputStream.close(); //очищаем ресурсы (можно воспользоваться try-with-resource)

        ////код для загрузки данных

        FileInputStream fileInputStream = new FileInputStream(pathToFile); //открываем поток для чтения данных из файла
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream); //подкласс класса InputStream, в
        //арсенале которого есть метод для чтения(извлечения) данных (примитивных и обьектов)

        PersonInformation clonePerson1 = (PersonInformation) objectInputStream.readObject(); //создаем ссылочную переменную
        //типа класса PersonInformation и инициализируем ее считанными данными из указанного файла, приведенными к типу класса
        //PersonInformation (обрабатываем исключение ClassNotFoundException)

        System.out.println("Result woo a la... : " + clonePerson1); //выводим на консоль информацию

        objectInputStream.close(); //очищаем ресурсы

    }
}