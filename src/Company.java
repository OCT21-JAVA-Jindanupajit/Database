public class Company{
    private static long autoIdValue = 0;
    private long id;
    private String name;

    public Company() {
        this.id = 0;
        this.name = "";
    }


    public Company(String name) {
        this.id = Company.getAutoIdValue();
        this.name = name;
    }

    public Company(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public static long getAutoIdValue() {
        return Company.autoIdValue;
    }


    public static void setAutoIdValue(long autoIdValue) {
        Company.autoIdValue = autoIdValue;
    }

    public long getAutoId() {
        this.setId(this.getId()+1);
        return this.id;
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
