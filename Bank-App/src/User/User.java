package User;

public class User {
    private int id;
    private String name;
    private String surname;
    private String tcno;

    public User(int id, String name, String surname, String tcno) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.tcno = tcno;
    }

    public int setId() {
        return id;
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

    public String getTcno() {
        return tcno;
    }

    public void setTcno(String tcno) {
        this.tcno = tcno;
    }
}
