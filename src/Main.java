public class Main {

    public static void main(String[] args) {

        Person mom = Person.builder()
                .name("Анна")
                .surname("Вольф")
                .age(31)
                .city("Сидней")
                .build();

        Person son = mom.newChildBuilder()
                .name("Антошка")
                .build();
        System.out.println("У " + mom + ", есть сын: " + son);

        try {
            new Person.PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new Person.PersonBuilder().age(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }
}
