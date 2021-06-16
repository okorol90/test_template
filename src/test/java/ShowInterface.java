public class ShowInterface {
    public static void main(String[] args) {
        Dog d1 = new Dog("d1");
        Dog d2 = new Dog("d2");
        Cat c1 = new Cat("c1");
        Spider s1 = new Spider("s1");
        ImmortalPonny ip1 = new ImmortalPonny("ip1");

//        d1.meet(ip1);

        Cat c2 = new Cat("c2");

        c2.meet(d1);

        ip1.meet(c1);

        s1.meet(c1);
        d1.meet(s1);
        d2.meet(d1);

        ip1.meet(s1);

    }
}