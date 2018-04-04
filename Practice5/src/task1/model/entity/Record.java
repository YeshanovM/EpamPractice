package task1.model.entity;

import java.util.Date;
import java.util.Objects;

public class Record {
    private String surname;
    private String name;
    private String birthday;
    private String phone;
    private String address;

    public Record(String surname, String name, String birthday, String phone, String address) {
        this.surname = surname;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record)) return false;
        Record record = (Record) o;
        return Objects.equals(surname, record.surname) &&
                Objects.equals(name, record.name) &&
                Objects.equals(birthday, record.birthday) &&
                Objects.equals(phone, record.phone) &&
                Objects.equals(address, record.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(surname, name, birthday, phone, address);
    }

    @Override
    public String toString() {
        return "Record{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
