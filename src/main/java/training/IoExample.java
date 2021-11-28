package training;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IoExample {
    public static void main(String[] args) {

        String string = "";
        StringBuilder stringBuilder = new StringBuilder();

        try (FileInputStream input = new FileInputStream
                ("C:/Users/ДИМА/IdeaProjects/UnPackString/src/main/resources/Emails.txt");
             InputStreamReader reader = new InputStreamReader(input)) {

            int ch;
            while (true) {
                ch = reader.read();
                if (ch == -1) {
                    break;
                }
                stringBuilder.append((char) ch);
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            System.out.println("Скорее всего не найден файл.");
            e.printStackTrace();
        }
    }
}
