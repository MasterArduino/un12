import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class JsonParser {
    public static void main(String[] args) {
        try {
            // Чтение JSON из файла в виде массива байт
            byte[] jsonData = Files.readAllBytes(Paths.get("D:\\JavaProgram\\untitled12\\src\\academy.json"));


            ObjectMapper objectMapper = new ObjectMapper();


            UserData userData = objectMapper.readValue(jsonData, UserData.class);


            System.out.println(userData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class UserData {
    private int id;
    private String name;
    private boolean permanent;
    private Address address;
    private int[] phoneNumbers;
    private String role;
    private String[] cities;
    private String street;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(int[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", permanent=" + permanent +
                ", address=" + address +
                ", phoneNumbers=" + Arrays.toString(phoneNumbers) +
                ", role='" + role + '\'' +
                ", cities=" + Arrays.toString(cities) +
                ", street='" + (address != null ? address.getStreet() : null) + '\'' +
                '}';
    }
}

class Address {
    private String street;
    private String city;
    private int zipcode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}
