package dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public Object[][] smoke(){
        return new Object[][] {
                {"iPhone", 19},
                {"Samsung", 15}
        };
    }

    @DataProvider
    public Object[][] regression(){
        return new Object[][] {
                {"iPhone", 20},
                {"Samsung", 15},
                {"Xiaomi", 10},
                {"Nokia", 5}
        };
    }
}
