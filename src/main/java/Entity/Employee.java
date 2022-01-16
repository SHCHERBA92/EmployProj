package Entity;

import java.sql.Date;
import java.time.LocalDate;

import java.util.Objects;

public class Employee {
    private Long id;
    private String firstName;
    private String lastNama;
    private Date birthday;
    private Long AddressId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNama() {
        return lastNama;
    }

    public void setLastNama(String lastNama) {
        this.lastNama = lastNama;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getAddressId() {
        return AddressId;
    }

    public void setAddressId(Long addressId) {
        AddressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastNama, employee.lastNama) && Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastNama, birthday);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastNama='" + lastNama + '\'' +
                ", birthday=" + birthday +
                ", AddressId=" + AddressId +
                '}';
    }
}
