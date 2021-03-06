import java.util.Objects;
import java.util.OptionalInt;

public class Person   {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name=name;
        this.surname=surname;
    }

    public Person(String name, String surname, int age) {
        this.name=name;
        this.surname=surname;
        this.age=age;
    }

    public boolean hasAge() { return !(age<1);}
    public boolean hasAddress() {  return address!=null;}

    public String getName() { return name;}
    public String getSurname() { return surname; }
    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }
    public String getAddress() {return address; }

    public String setAddress(String address) { return this.address=address;}
    public void happyBirthday() {
        if (hasAge()){
            this.age++;
        }
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    public PersonBuilder newChildBuilder() {

        PersonBuilder personBuilder=new PersonBuilder().setSurname(surname).setAddress(address);
        return  personBuilder;
    }
}