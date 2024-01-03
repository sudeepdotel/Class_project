package aggregationConcepts;

public class Student {
    int id;
    String name;
    Address address;
    String gender;
    int age;

    public Student(int id, String name, Address address, String gender, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.age = age;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayDetails(){
        System.out.println("oopsConcept.Address " + address.street + " " + address.zipCode);
    }
}
