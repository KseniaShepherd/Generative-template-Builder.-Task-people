import java.util.Objects;

public class Person {
    private String name;
    private String surname;
    private Integer age;
    private String city;

    public boolean hasAge() {
        return this.age > 0;
    }

    public boolean hasCity() {
        return this.city != null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void happyBirthday() {
        this.age++;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name) &&
                surname.equals(person.surname) &&
                city.equals(person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public static class PersonBuilder {
        private String name;
        private String surname;
        private Integer age;
        private String city;

        public PersonBuilder name(String name) {
            this.name = name;

            return this;
        }

        public PersonBuilder surname(String surname) {
            this.surname = surname;

            return this;
        }

        public PersonBuilder age(Integer age) {
            this.age = age;
            if (age < 0) {
                throw new IllegalArgumentException("Negative age");
            }
            return this;
        }

        public PersonBuilder city(String city) {
            this.city = city;
            return this;
        }

        public PersonBuilder() {
        }

        public static PersonBuilder builder() {
            return new PersonBuilder();
        }

        public Person build() {
            if (name == null && surname == null){
                throw new
                        IllegalStateException("Required fields missing: name, surname ");
            }
            if (name == null) {
                throw new IllegalStateException("Required field missing: name ");
            }
            if (surname == null) {
                throw new IllegalStateException("Required field missing: surname");
            }

            Person person = new Person();
            person.setName(this.name);
            person.setSurname(this.surname);
            person.setAge(this.age);
            person.setCity(this.city);

            return person;
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = PersonBuilder.builder();
        childBuilder.surname(this.surname)
                .city(this.city);
        return childBuilder;
    }
}
