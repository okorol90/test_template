public class Cat extends Animal implements Existable{
    public Cat(String name) {
        super(name);
    }

    @Override
    public void sleep() {
        System.out.println("sleep");
    }

    @Override
    public void eat() {
        System.out.println("eat");
    }

    @Override
    public void meet(Existable animal) {
        System.out.printf("Cat %s meet with %s \n", name, animal.getClass().getName());
    }
}
