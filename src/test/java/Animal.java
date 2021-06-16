public abstract class Animal {

    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void sleep();
    public abstract void eat();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
