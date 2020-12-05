import java.util.*;
import java.io.*;
import java.lang.*;

// This will lead in an Infinite Loop
class Employee1 {
	int id;
	String name;

	public Employee1() {
		Employee1 employee = new Employee1();
	}
}

class Employee {
	int id;
	String name;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Employee)) {
			return false;
		}
		Employee employee = (Employee) o;
		return id == employee.id && Objects.equals(name, employee.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + id + "'" +
			", name='" + name + "'" +
			"}";
	}
}

class Runner {

	public static void main(String[] args) {
		Map<Employee, Integer> map = new HashMap<>();
		Employee e1 = new Employee(1, "swargam");
		Employee e2 = new Employee(1, "swargam");
		List<Integer> list = Arrays.asList(1,2,3,4,5);

		map.put(e1, 1);
		map.put(e2, 1);
		System.out.println(map);
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());

		e1.name = "heaven"; // You should never change the values of the Key in hashmap.
		System.out.println(map.containsKey(e2));

		// First a Hash Bucket will be created and key value is stored in that bucket..
		// containsKey -> check if hash is equal if equal then runs the equal funtion.. too.

		// What you missed is if we change the key object value outside it will change in the 
		// HashMap too..

		String s1 = new String("avinash");
		String s2 = "avinash"; 
		// Any Operation on Dynamic String gen if equal string then
		// Same memory
		System.out.println(s1 == s2);

		// StringBuilders have different kind of comparisions so false.
		StringBuilder sb1 = new StringBuilder("avinash");
		StringBuilder sb2 = new StringBuilder("avinash");
		System.out.println(sb1 == sb2); // Okay two string builderss are not equall...

		// Employee1 e4 = new Employee1();

		System.out.println(list);
		list.add(2);
		list.add(3);
		System.out.println(list);
	}
}