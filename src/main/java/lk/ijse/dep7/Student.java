package lk.ijse.dep7;

import lk.ijse.dep7.annotation.Column;
import lk.ijse.dep7.annotation.Id;
import lk.ijse.dep7.annotation.Table;

@Table("student")
public class Student {

    @Id
    @Column("id")
    private int id;
    @Column("name")
    private String name;
    @Column("contact-number")
    private String contactNumbers;

    public Student() {
    }

    public Student(int id, String name, String contactNumbers) {
        this.id = id;
        this.name = name;
        this.contactNumbers = contactNumbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(String contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNumbers='" + contactNumbers + '\'' +
                '}';
    }
}