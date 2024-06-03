import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable, Comparable<Student>, Cloneable {
	private double gpa;
	private String name;
	
	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}
	public Student(Student s) {
		this.name = s.name;
		this.gpa = s.gpa;
	}

	public double getGpa() {
		return gpa;
	}
	public String getName() {
		return name;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Student o) {
		int nameCompare = this.name.compareTo(o.name);
		int gpaCompare = (Double.valueOf(this.gpa)).compareTo(Double.valueOf(o.gpa));

		if (gpaCompare == 0) {
			return nameCompare;
		}
		return gpaCompare;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Student(this);
	}
}
