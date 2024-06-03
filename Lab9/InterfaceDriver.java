import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFrame;

//  InterfaceDriver
//  CSSSKL 143
//  By Rob Nash
//

public class InterfaceDriver {
    // comment and uncomment the demo functions in main to test
    public static void main(String[] args) throws CloneNotSupportedException {
        //comparableDemo();
        //cloneableDemo();
        serializableDemo();
        //actionListenerDemo();
    }

    public static void comparableDemo() {
        Student a = new Student("Rob", 3.0);
        Student b = new Student("Bill", 4.0);
        Student c = new Student("Mary", 4.0);


        System.out.println( " a compareTo b :" + a.compareTo(b));
        System.out.println( " b compareTo a :" + b.compareTo(a));
        System.out.println( " b compareTo c :" + b.compareTo(c));
    }


    public static void cloneableDemo() throws CloneNotSupportedException {
        Student a = new Student("Evan", 3.0);
        Student c = (Student)a.clone();

        System.out.println(a);
        System.out.println(c);

        System.out.println("Changing object a");
        a.setName("Boo");
        a.setGpa(3.5);

        System.out.println(" new name: " + a.getName());
        System.out.println(" new GPA: " + a.getGpa());
        System.out.println(" The object a: " + a);
        System.out.println(" The object c: " + c);
    }

    public static void actionListenerDemo() {
        new Application();
    }

    public static void serializableDemo() {
        writeObjectsToFile();
        readObjectsFromFile();
    }

    private static void readObjectsFromFile() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("data.obj"));

            Student a = (Student)is.readObject();  //cast is required since object is returned
            Student b = (Student)is.readObject();

            System.out.println("From file : " + a);
            System.out.println("From file : " + b);

            is.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Bad OOS");
        }
    }

    /*
     * 6.3. It output a memory location for both objects.
     * 6.4. We output both Student Pbjects to a memory location, like an .obj or a .dat file that if it doesn't exist, is created, we are then able to grab the values from, I think?
     */
    private static void writeObjectsToFile() {
        try {
            //ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream("object.dat"));
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("data.obj"));
            Student a = new Student("FileIO1", 3.0);
            Student b = new Student("FileIO2", 4.0);

            os.writeObject(a);
            os.writeObject(b);
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Bad OOS");
        }
    }
}
