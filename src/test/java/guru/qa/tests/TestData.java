package guru.qa.tests;

import com.github.javafaker.Faker;

import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

import static utils.RandomUtils.*;

public class TestData {

    static Faker faker = new Faker();
    static Faker fakerRu = new Faker(new Locale("ru", "RU"));

    public static String generateRussianAddress() {

        return String.format("%s, %s, %s, %s, %s",
                fakerRu.address().zipCode(),
                "г. " + fakerRu.address().city(),
                fakerRu.address().streetName(),
                fakerRu.address().buildingNumber(),
                "кв. " + fakerRu.number().numberBetween(1, 300)
        );
        }

    static Date birthDate = faker.date().birthday();
    static LocalDate localDate = birthDate.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();

    static String month = localDate.getMonth().getDisplayName(
            TextStyle.FULL_STANDALONE,
            new Locale("en")
    );

    static String day = Integer.toString(localDate.getDayOfMonth());
    static String year = Integer.toString(localDate.getYear());

   public final static String FIRST_NAME = fakerRu.address().firstName(),
            LAST_NAME = fakerRu.address().lastName(),
            E_MAIL = faker.internet().emailAddress(),
            GENDER = generateRandomGender(),  // Male || Female || Other
            MOBILE_NUMBER = faker.phoneNumber().subscriberNumber(10),
            DAY_OF_BIRTH = day,
            MONTH_OF_BIRTH = month,
            YEAR_OF_BIRTH = year,
            SUBJECT_1 = "Arts",
            SUBJECT_2 = "Maths",
            HOBBY_1 = "Sports",
            HOBBY_2 = "Music",
            CURRENT_ADDRESS = generateRussianAddress(),
            STATE = "Rajasthan",
            CITY = "Jaipur",
            RESULT_TABLE_TITLE = "Thanks for submitting the form";

    public final static File FILE = new File("src/test/resources/picture1.jpg");

}
