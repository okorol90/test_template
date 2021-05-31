package person;

import org.testng.Assert;
import org.testng.annotations.*;
import server.Person;

public class TestPerson {
    Person p;

    @BeforeMethod
    public void setUp() {
        p = new Person();
        System.out.println("SetUp");
    }

//    @AfterMethod
//    public void Up() {
//        p.setAge(38);
//        System.out.println("down");
//    }

    @Test()
    @Parameters({"age"})
    public void verifySetAge(@Optional("15") String setAge) {
        System.out.println("Parameter "+setAge );
        int expectedAge = 15;
        p.setAge(Integer.parseInt(setAge));
        int actualAge = p.getAge();
        Assert.assertEquals(actualAge, expectedAge, "Isn't equal");
    }


//    @Test(dataProvider = "ages")
//    public void verifySetAge(int expected, int setAge) {
//        int expectedAge = expected;
//        p.setAge(setAge);
//        int actualAge = p.getAge();
//        Assert.assertEquals(actualAge, expectedAge, "Isn't equal");
//    }
//
//    @DataProvider(name = "ages")
//    public Object[][] dataProvider(){
//        Object[][] arr = {{10,0},{12,12},{10, -18},{100,100},{10, 105}};
//        return arr;
//    }
}