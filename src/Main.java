import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    private static ArrayList<Company> companyDatabase = new ArrayList<>();
    private static ArrayList<Person> personDatabase = new ArrayList<>();
    private static ArrayList<LinkCompanyPerson> linkCompanyPeopleDatabase = new ArrayList<>();

    public static void main(String[] args) {

        populateDatabase();

        listAll();

        cli();

    }

    public static void cmdCompany(String[] args) {
        if (args.length < 2) {
            System.out.println("company list|add|edit\n");
            return;
        }

        switch(args[1]) {
            case "list": cmdCompanyList(args);
                break;
            case "add": cmdCompanyAdd(args);
                break;
            case "edit": cmdCompanyEdit(args);
                break;
            default:
                System.out.println("No such command");
        }

    }
    public static void cmdCompanyList(String[] args) {
        for (Company company : companyDatabase) {
            System.out.printf(" - %3d %s\n", company.getId(), company.getName());
        }
    }
    public static void cmdCompanyAdd(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: company add <name>\n");
            return;
        }
        String name = String.join(" ",Arrays.copyOfRange(args,2,args.length));
        addCompany(new Company(Company.getAutoIdValue()+1, name));

        System.out.printf("Company %s added.\n", name);
    }

    public static void cmdCompanyEdit(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: company edit <person-id> <name>\n");
            return;
        }
        Company company = getCompanyById(Long.parseLong(args[2]));

        if (company == null)
            System.out.println("No such 'id' in 'company' database\n");

        String name = String.join(" ",Arrays.copyOfRange(args,3,args.length));

        company.setName(name);

        System.out.printf("Company #%d change name to %s.\n", company.getId(), name);
    }
    public static void cmdPerson(String[] args) {
        if (args.length < 2) {
            System.out.println("person list|add|edit\n");
            return;
        }

        switch(args[1]) {
            case "list" : cmdPersonList(args);
                break;
            case "add": cmdPersonAdd(args);
                break;
            case "edit": cmdPersonEdit(args);
                break;
            default:
                System.out.println("No such command");
        }

    }

    public static void cmdPersonList(String[] args) {
        for (Person person : personDatabase) {
            System.out.printf(" - %3d %s\n", person.getId(), person.getName());
        }
    }

    public static void cmdPersonAdd(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: person add <name>\n");
            return;
        }
        String name = String.join(" ",Arrays.copyOfRange(args,2,args.length));
        addPeople(new Person(Person.getAutoIdValue()+1, name));

        System.out.printf("Person %s added.\n", name);
    }

    public static void cmdPersonEdit(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: person edit <person-id> <name>\n");
            return;
        }
        Person person = getPersonById(Long.parseLong(args[2]));

        if (person == null)
            System.out.println("No such 'id' in 'person' database\n");

        String name = String.join(" ",Arrays.copyOfRange(args,3,args.length));

        person.setName(name);

        System.out.printf("Person #%d change name to %s.\n", person.getId(), name);

    }
    public static void cmdLink(String[] args) {
        if (args.length < 2) {
            System.out.println("link list|add|edit\n");
            return;
        }

        switch(args[1]) {
            case "list" : cmdLinkList(args);
                break;
            case "add": cmdLinkAdd(args);
                break;
            case "edit": cmdLinkEdit(args);
                break;
            default:
                System.out.println("No such command");
        }

    }
    public static void cmdLinkList(String[] args) {
        for (LinkCompanyPerson linkCompanyPerson : linkCompanyPeopleDatabase) {
            Company company = getCompanyById(linkCompanyPerson.getCompanyId());
            Person person = getPersonById(linkCompanyPerson.getPeopleId());

            System.out.printf("- %3d %-30s %-30s\n", linkCompanyPerson.getId(), String.format("%3d %s",company.getId(),company), String.format("%3d %s", person.getId(), person));
        }
    }

    public static void cmdLinkAdd(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: link add <company-id> <people-id>\n");
            return;
        }

        long companyId = Long.parseLong(args[2]);
        long personId = Long.parseLong(args[3]);

        Company company = getCompanyById(companyId);
        Person person = getPersonById(personId);

        if (company == null)
            System.out.println("No such 'id' in 'company' database\n");

        if (person == null)
            System.out.println("No such 'id' in 'people' database\n");

        if ((company ==  null)||(person ==  null))
            return;

        addLinkCompanyPerson(new LinkCompanyPerson(LinkCompanyPerson.getAutoIdValue()+1, companyId, personId));

        System.out.printf("Link added.\n");
    }

    public static void cmdLinkEdit(String[] args) {

    }


    public static void populateDatabase() {

        Collections.addAll(companyDatabase,
                new Company(1, "Abc, Inc."),
                new Company(2, "Def, Inc."),
                new Company(3, "Ghi, Inc."),
                new Company(4, "Jkl, Inc."),
                new Company(5, "Mno, Inc."),
                new Company(6, "Pqr, Inc."),
                new Company(7, "Stu, Inc.")
                );
        Company.setAutoIdValue(7);

        Collections.addAll(personDatabase,
                new Person(1, "John Doe"),
                new Person(2, "Jane Doe"),
                new Person(3, "Jack Doe"),
                new Person(4, "Alice Doe"),
                new Person(5, "Lisa Doe"),
                new Person(6, "Carol Doe"),
                new Person(7, "Victor Doe"),
                new Person(8, "Bella Doe"),
                new Person(9, "Anna Doe")
                );
        Person.setAutoIdValue(9);

        Collections.addAll(linkCompanyPeopleDatabase,
                new LinkCompanyPerson(1, 1,1),
                new LinkCompanyPerson(2, 1,2),

                new LinkCompanyPerson(3, 2,3),

                new LinkCompanyPerson(4, 3,4),
                new LinkCompanyPerson(5, 3,5),
                new LinkCompanyPerson(6, 3,6),

                new LinkCompanyPerson(7, 4,7),
                new LinkCompanyPerson(8, 4,8),

                new LinkCompanyPerson(9, 5,9)
                );
        LinkCompanyPerson.setAutoIdValue(9);
    }

    public static void listAll() {
        for (LinkCompanyPerson linkCompanyPerson : linkCompanyPeopleDatabase) {
            Company company = getCompanyById(linkCompanyPerson.getCompanyId());
            Person person = getPersonById(linkCompanyPerson.getPeopleId());

            System.out.printf("%s -> %s\n", company, person);
        }
    }
    public static Company getCompanyById(long id) {
        for (Company company : companyDatabase) {
            if (id == company.getId())
                return company;
        }

        return null;
    }

    public static Company getCompanyByPerson(Person personToFind) {
        for (LinkCompanyPerson linkCompanyPerson : linkCompanyPeopleDatabase) {
            Company company = getCompanyById(linkCompanyPerson.getCompanyId());
            Person person = getPersonById(linkCompanyPerson.getPeopleId());

            System.out.printf("%s -> %s\n", company, person);
        }
        return null;
    }

    public static void addCompany(Company company) {
        companyDatabase.add(company);
    }

    public static Person getPersonById(long id) {
        for (Person person : personDatabase) {
            if (id == person.getId())
                return person;
        }

        return null;
    }

    public static void addPeople(Person person) {
        personDatabase.add(person);
    }

    public static LinkCompanyPerson getLinkCompanyPeopleById(long id) {
        for (LinkCompanyPerson linkCompanyPerson : linkCompanyPeopleDatabase) {
            if (id == linkCompanyPerson.getId())
                return linkCompanyPerson;
        }

        return null;
    }

    public static void addLinkCompanyPerson(LinkCompanyPerson linkCompanyPerson) {
        linkCompanyPeopleDatabase.add(linkCompanyPerson);
    }

    public static void cli() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("% ");
            String[] args = scanner.nextLine().split(" ");
            if (args.length == 0)
                continue;
            switch(args[0]) {
                case "exit" : System.exit(1);

                case "person": cmdPerson(args);
                                break;

                case "company": cmdCompany(args);
                                break;

                case "link": cmdLink(args);
                               break;

                default:
                    System.out.println("No such command\n");

            }

        }
    }

}
