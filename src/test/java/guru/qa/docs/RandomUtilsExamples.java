package guru.qa.docs;

import static utils.RandomUtils.generateRandomEmail;
import static utils.RandomUtils.getRandomString;

public class RandomUtilsExamples {
    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(generateRandomEmail());
    }
}
