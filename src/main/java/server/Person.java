package server;

public class Person {

    public Person() {
        this.age = 10;
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age <=100) {
            this.age = age;
        } else {
            System.out.println("Wrong parameter age: "+age);
        }
    }
}
