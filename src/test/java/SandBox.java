import utils.PropertyLoader;

public class SandBox {
    public static void main(String[] args) {
        System.out.println(PropertyLoader.getProperty("baseUrl"));
        System.out.println(PropertyLoader.getProperty("driverUrl"));
    }
}
