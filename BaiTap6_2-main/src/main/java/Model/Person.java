package Model;

import java.sql.Date;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String bietDenThongQua;
    private List<String> nhanThongBao;
    private List<String> lienHe;

    public Person() {}

    public Person(String firstName, String lastName, String email, Date dateOfBirth, String bietDenThongQua, List<String> nhanThongBao, List<String> lienHe) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.bietDenThongQua = bietDenThongQua;
        this.nhanThongBao = nhanThongBao;
        this.lienHe = lienHe;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBietDenThongQua() {
        return bietDenThongQua;
    }

    public void setBietDenThongQua(String bietDenThongQua) {
        this.bietDenThongQua = bietDenThongQua;
    }

    public List<String> getNhanThongBao() {
        return nhanThongBao;
    }

    public void setNhanThongBao(List<String> nhanThongBao) {
        this.nhanThongBao = nhanThongBao;
    }

    public List<String> getLienHe() {
        return lienHe;
    }

    public void setLienHe(List<String> lienHe) {
        this.lienHe = lienHe;
    }
}
