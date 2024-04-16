package dataprovider;

import com.github.javafaker.Faker;

public class LogowanieDP {

    Faker faker = new Faker();

    public String getValidPassword() {
        return faker.internet().password(8, 15);
    }

    public String getInvalidPassword() {
        return faker.internet().password(1, 7);
    }

    public String getOneCharPassword() {
        return faker.number().digits(1);
    }

    public String getSevenCharPassword() {
        return faker.number().digits(7);
    }

    public String getLowerCasePassword() {
        return faker.internet().password(8, 15).toLowerCase();
    }

    public String getUpperCasePassword() {
        return faker.internet().password(8, 15).toUpperCase();
    }

    public String getOneHundredCharPassword() {
        return faker.internet().password(100, 101, true, true, true);
    }

    public String getPasswordWithoutNumbers() {
        return faker.internet().password(8, 20, false, false, false);
    }

    public String getPasswordWithOnlyNumbers() {
        return faker.number().digits(8);
    }

    public String getBlankFied() {
        return "";
    }

    public String getUnregisteredEmail() {
        return faker.internet().safeEmailAddress();
    }

    public String getEmailWithoutAt() {
        return faker.internet().safeEmailAddress().replace("@", ".");
    }

    public String getEmailWithoutDomain() {
        return faker.internet().emailAddress().split("@")[0];
    }

    public String getEmailWithoutName() {
        return "@" + faker.internet().domainName();
    }

    public String getOneCharEmail() {
        return faker.letterify("?@ex.com");
    }

    public String getOnHundredCharEmail() {
        return faker.internet().password(100, 101) + "@";
    }

    public String getInvalidFistName() {
        return "!@#";
    }

    public String getInvalidLastName() {
        return ")(*&^";
    }

    public String getShortName() {
        return "Ac";
    }
}
