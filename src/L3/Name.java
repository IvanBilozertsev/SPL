package L3;

/**
 * Created by Ivan on 16.12.2016.
 */
public class Name {
    public String name;
    private String surname;

    public Name(){
        name = "Unknown";
        surname = "Unknown";
    }

    public Name(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public Name(Name SomeName){
        this.name = SomeName.getName();
        this.surname = SomeName.getSurname();
    }

    public String getName(){return name;}
    public String getSurname(){return surname;}
    public void setName(String name){this.name = name;}
    public void setSurname(String surname){this.surname = surname;}
    public String toString(){
        String result = "name: " + name + "\nsurname: " + surname;
        return result;
    }
}
