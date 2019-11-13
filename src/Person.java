public class Person {

    private static long autoIdValue = 0;
    private long id;
    private String name;

    public Person() {
        this.id =  0;
        this.name = "";
    }

    public Person(String name) {
        this.id = Person.getAutoIdValue();
        this.name = name;
    }

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public static long getAutoIdValue() {
        return Person.autoIdValue;
    }


    public static void setAutoIdValue(long autoIdValue) {
        Person.autoIdValue = autoIdValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
