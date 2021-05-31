package person;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import server.Person;

public class TestPerson {
    Person p;

//    @BeforeClass
//    public void setUp() {
//        p = new Person();
//        System.out.println("SetUp");
//    }

//    @AfterMethod
//    public void Up() {
//        p.setAge(38);
//        System.out.println("down");
//    }


    @Test
    public void setAgeZero() {
        int expectedAge = 15;
        p.setAge(0);
        int actualAge = p.getAge();
        Assert.assertEquals(actualAge, expectedAge, "Isn't equal");
    }

    @Test
    public void setAgePositive() {
        int expectedAge = 10;
        p.setAge(0);
        int actualAge = p.getAge();
        Assert.assertEquals(actualAge, expectedAge, "Isn't equal");

    }

    @Test
    public void setAgeNegative() {
        int expectedAge = 18;
        p.setAge(18);
        int actualAge = p.getAge();
        Assert.assertEquals(actualAge, expectedAge, "Isn't equal");

    }

    @Test
    public void setAgeOld() {
        int expectedAge = 27;
        p.setAge(27);
        int actualAge = p.getAge();
        Assert.assertEquals(actualAge, expectedAge, "Isn't equal");

    }

}