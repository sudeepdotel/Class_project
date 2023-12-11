package aggregationConcepts;

public class Main {

    public static void main(String[] args) {

        // Aggregation concept !!!
        Address address = new Address("123 main st", "Fort Worth","TX", 75005);
        Student student = new Student(1001,"John",address,"Male",26);

        student.displayDetails();
    }
}
