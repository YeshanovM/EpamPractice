package task6;

public class Person {
    private String name;
    private int age;
    private Sex sex;

    private final static int AGE_FROM = 21;
    private final static int AGE_TO = 30;
    private final static int MAX_AGE = 128;
    private static int id = 0;

    public Person() {
        id++;
    }

    public Person(String name, int age, Sex sex) {
        this();
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public boolean isMilitaryLiable() {
        return age >= AGE_FROM &&
                age <= AGE_TO &&
                sex == Sex.MALE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public static Person createPerson() {
        Person person = new Person();
        person.setAge((int) (Math.random() * MAX_AGE));
        person.setSex(Math.random() < 0.5 ? Sex.FEMALE : Sex.MALE);
        person.setName("Person" + id);
        return person;
    }
}
