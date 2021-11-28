package training;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadingFile {
    public static void main(String[] args) {

        URLConnection connection = null;

        try {
            URL url = new URL("https://4lapki.com/wp-content/uploads/2019/03/https-img3-goodfon-ru-original-2048x1365-9-4b-ko.jpeg");
            connection = url.openConnection();
        } catch (MalformedURLException e) {
            System.out.println("Адрес URL не найден.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Не могу получить соединение с сервером.");
            e.printStackTrace();
        }

        try (InputStream is = connection.getInputStream();
             FileOutputStream os = new FileOutputStream("picture.jpg")) {
            System.out.println("Загрузка началась.");
            int result;
            while (true) {
                result = is.read();
                if (result == -1) {
                    break;
                }
                os.write(result);
            }
            System.out.println("Загрузка закончена.");
        } catch (IOException e) {
            System.out.println("Исключение в is");
            e.printStackTrace();
        }
    }
}
