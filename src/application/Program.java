package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("How many employees will be registred? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.print("\nEmployee #" + i + ":\n");
			
			System.out.print("ID: ");
			int id = sc.nextInt();
			
			if (Program.hasId(id, list)) {
				while (Program.hasId(id, list)) {
					System.out.print("This id already exists!\nEnter another id: ");
					id = sc.nextInt();
				}
			}
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("\nSalary: ");
			double salary = sc.nextDouble();
			
			list.add(new Employee(id, name, salary));
		}
		
		System.out.print("\nEnter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		
		Integer j = Program.idPosition(id, list);
		
		sc.nextLine();
		
		if (j != null) {
			System.out.print("Enter the percentage that will have increase in the salary: ");
			double percent = sc.nextDouble();		
			list.get(j).increaseSalary(percent);
		} else {
			while (j == null) {
				System.out.print("This id does not exists!\nEnter the existing employee id that will have increase the salary: ");
				id = sc.nextInt();
				j = Program.idPosition(id, list);
			}
			
			System.out.print("Enter the percentage that will have increase in the salaray: ");
			double percent = sc.nextDouble();
			list.get(j).increaseSalary(percent);
		}
		
		System.out.print("\nList of employee:\n");
		for (Employee x : list) {
			System.out.println(x);
		}
		
		sc.close();
	}
	
	public static boolean hasId (int id, List<Employee> list) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);	
		if (emp != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Integer idPosition(int id, List<Employee> list) {
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).getId() == id) {
				return j;
			}
		}
		return null;
	}

}