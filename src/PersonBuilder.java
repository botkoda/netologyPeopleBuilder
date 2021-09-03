public class PersonBuilder {
    String name;
    String surname;
    int age=-1;
    String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age)throws IllegalArgumentException  {

        if (age < 0) throw new IllegalArgumentException("Возраст не может быть отрицательным");
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException,IllegalArgumentException {
        Person person;

        if (name == null || surname == null)
            throw new IllegalStateException("Не указанны обязателные параметры имя и фамилия");
        if (age <0) {
            person = new Person(name, surname);
        } else {
            person = new Person(name, surname, age);
        }


        person.setAddress(address);
        return person;

    }

}
