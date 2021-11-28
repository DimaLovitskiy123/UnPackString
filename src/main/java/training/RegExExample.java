package training;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExExample {
    public List<String> findEmails(String text) {

        List<String> list = new ArrayList<>();

        String emailRegEx = "\\w+@(gmail|yandex|mail|rambler)\\.(ru|com|ua|by|kz)";
        Pattern pattern = Pattern.compile(emailRegEx);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    public void devide(int a, int b) {
        System.out.println("Перед делением.");
        try {
            System.out.println(a/b);
        }catch (ArithmeticException e){
            System.out.println("На 0 нельзя.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("После деления.");

    }
}
