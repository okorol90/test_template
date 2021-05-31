package person;

import org.testng.Assert;
import org.testng.annotations.Test;
import server.Person;

public class TestPerson2 {

    @Test
    public void setAgeZero1(){
        int expectedAge = 10;
        Person p = new Person();
        p.setAge(0);

        int actualAge = p.getAge();

        Assert.assertEquals(actualAge, expectedAge, "Isn't equal");

    }
}
