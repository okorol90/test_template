public class ImmortalPonny extends Animal{

    public ImmortalPonny(String name) {
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

    public void meet(Animal animal) {
        System.out.printf("ImmortalPony %s meet with %s \n", name, animal.getClass().getName());
    }
}
