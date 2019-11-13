public class LinkCompanyPerson {
    private static long autoIdValue = 0;
    private long id;
    private long companyId;
    private long peopleId;

    public LinkCompanyPerson() {
        this.id = 0;
        this.companyId = 0;
        this.peopleId = 0;
    }

    public LinkCompanyPerson(long companyId, long peopleId) {
        this.id = LinkCompanyPerson.getAutoIdValue();
        this.companyId = companyId;
        this.peopleId = peopleId;
    }

    public LinkCompanyPerson(long id, long companyId, long peopleId) {
        this.id = id;
        this.companyId = companyId;
        this.peopleId = peopleId;
    }


    public static long getAutoIdValue() {
        return LinkCompanyPerson.autoIdValue;
    }


    public static void setAutoIdValue(long autoIdValue) {
        LinkCompanyPerson.autoIdValue = autoIdValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(long peopleId) {
        this.peopleId = peopleId;
    }
}
