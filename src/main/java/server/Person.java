package server;

public class Person {

    public Person() {
        this.age = 10;

    }

    private int age;
    private String status;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age <=10) {
            this.age = age;
            this.status = "child";
        }
        if (age > 11 && age <=21) {
            this.status = "teen";
            this.age = age;
        }
        if (age > 22 && age <=25) {
            this.status = "student";
            this.age = age;
        }else {
            System.out.println("Wrong parameter age: "+age);
        }
    }
}
