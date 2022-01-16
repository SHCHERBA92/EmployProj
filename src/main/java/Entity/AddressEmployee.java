package Entity;

import java.util.Objects;

public class AddressEmployee {
    private Long id;
    private String city;
    private String street;
    private String numberOfHouse;
    private int numberOfApartment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberOfHouse() {
        return numberOfHouse;
    }

    public void setNumberOfHouse(String numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }

    public int getNumberOfApartment() {
        return numberOfApartment;
    }

    public void setNumberOfApartment(int numberOfApartment) {
        this.numberOfApartment = numberOfApartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEmployee that = (AddressEmployee) o;
        return numberOfApartment == that.numberOfApartment && Objects.equals(id, that.id) && Objects.equals(city, that.city) && Objects.equals(street, that.street) && Objects.equals(numberOfHouse, that.numberOfHouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, street, numberOfHouse, numberOfApartment);
    }
}
