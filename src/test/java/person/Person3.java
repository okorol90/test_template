package person;

import org.testng.Assert;
import org.testng.annotations.Test;
import server.Person;

import javax.sound.midi.Soundbank;

public class Person3 {
    @Test
    public void setAgeZero3(){
        int expectedAge = 10;
        Person p = new Person();
        p.setAge(0);

        int actualAge = p.getAge();

        Assert.assertEquals(actualAge, expectedAge, "Isn't equal");

        System.out.println("In person 3");

    }
}
