package entities;

public class Employee {

	private int id;
	private String name;
	private double salary;
	
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	public void increaseSalary(double percent) {
		this.salary += (this.salary * percent/100);
	}
	
	@Override
	public String toString() {
		return this.getId() + ", " + this.getName() + ", " + this.getSalary();
	}	
}
