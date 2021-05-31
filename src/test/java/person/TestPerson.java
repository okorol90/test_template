package person;

import org.testng.Assert;
import org.testng.annotations.Test;
import server.Person;

public class TestPerson {

    @Test
    public void setAgeZero(){
        int expectedAge = 15;
        Person p = new Person();
        p.setAge(0);

        int actualAge = p.getAge();

        Assert.assertEquals(actualAge, expectedAge, "Isn't equal");

    }

}