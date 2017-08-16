package by.epam.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ResourceBundle;

public class Statics {
    public static final int LOGIN_ID = 1;
    public static final int PASSWORD_ID = 2;

    public static final int TITLE_ID = 1;
    public static final int AUTHOR_ID = 2;
    public static final int GENRE_ID = 3;
    public static final int YEAR_ID = 4;
    public static final int QUANTITY_ID = 5;
    public static final int BOOK_ID = 6;

    public static final String REGEX = " ";

    public static final ResourceBundle bundle = ResourceBundle.getBundle("database");
    public static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml");
}
