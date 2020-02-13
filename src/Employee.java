import java.io.IOException;

/**
 * Created by MR on 5/10/2018.
 */
public class Employee implements java.io.Serializable {

    private static final long serialVersionUID = 1073375138184344057L;

    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public static void main(String[] args) {

        Employee employee = new Employee("Mohammadreza Khatami", 23, 2000);
        String filename = "data.ser";

        //Serialization starts here.
        try{
            //Saving object in a file
            java.io.FileOutputStream file = new java.io.FileOutputStream(filename);
            java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(employee);

            out.close();
            file.close();

            System.out.println("Serialization Complete!");

        }

        catch(IOException e){
            System.out.println(e.getMessage());
        }
        //Serialization ends here.

        //Deserialization starts here.
        Employee employee2;
        try{
            // Reading the object from a file
            java.io.FileInputStream file = new java.io.FileInputStream(filename);
            java.io.ObjectInputStream in = new java.io.ObjectInputStream(file);

            // Method for deserialization of object
            employee2 = (Employee)in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("Employee name : " + employee2.name);
            System.out.println("Employee Age = " + employee2.age);
            System.out.println("Employee Salary = " + employee2.salary);
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        // Deserialization ends here.
    }
}
