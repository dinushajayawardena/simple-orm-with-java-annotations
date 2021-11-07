package lk.ijse.dep7;

import lk.ijse.dep7.annotation.Column;
import lk.ijse.dep7.annotation.Id;
import lk.ijse.dep7.annotation.Table;

@Table("customer")
public class Customer {

    @Id
    @Column("id")
    private String id;
    @Column("name")
    private String name;
    @Column("address")
    private String address;

    public Customer() {
    }

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
