import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Employee extends DataGeneration {
	private  Scanner input =new Scanner(System.in);
	int id;
	String name;
	int salary;
	String username,password;

	public Employee() {
	}
	Employee(int id,String name, int salary,String username,String password){
		this.name=name;
		this.id=id;
		this.salary=salary;
		this.username=username;
		this.password=password;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void getdata() {


		loadempfile();

	}
	public String toString() {
		return ("------------------------"
				+ " Id: "+this.getId()+
				" Name: "+ this.getName()+ " Salary "+ this.getSalary()
				+"------------------------\n");
	}
	public void changesalary(int salary,int idsearch) {

		for (int i=0;i<Emp.size();i++) {

			if(Emp.get(i).getId()==idsearch) {
				Emp.get(i).setSalary(salary);
			}
		}
	}
	public void changename(String name,int idsearch) {
		for (int i=0;i<Emp.size();i++) {

			if(Emp.get(i).getId()==idsearch) {
				Emp.get(i).setName(name);
			}
		}
	} 





	public	void sort() {
		Collections.sort(Emp,new SortBySalary());
	}


	class SortBySalary implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.salary-o2.salary;

		}
	}
	public int login() {
		int flag=0;
		String usernames,passwords;
		while(flag!=2) {
			System.out.println("Enter your username to login  ");	 
			usernames=input.next();
			System.out.println("Enter your password to login");	 
			passwords=input.next();
			boolean log=isValidEmployee(usernames,passwords);

			if(log) {
				flag=2;
			}

		}
		return flag;
	}

	public boolean isValidEmployee(String usernamecheck,String passwordcheck){
		boolean check = false;
		for (Employee emp:Emp){

			if (emp.username.contains(usernamecheck)) {

				if(emp.password.contains(passwordcheck)){
					check=true;
					return check;
				}
			}
		}
		return check; //Validating credentials through list
	}
	public void addemp() {
		System.out.println("Enter id");
		int id=input.nextInt();
		System.out.println("Enter name");
		String name=input.next();
		System.out.println("Enter salary");
		int salary=input.nextInt();
		System.out.println("Enter username");
		String username=input.next();
		System.out.println("Enter password");
		String password=input.next();
		Employee e=new Employee(id,name,salary,username,password);
		Emp.add(e);
		System.out.println("Employee added succesfully");
	}

}



