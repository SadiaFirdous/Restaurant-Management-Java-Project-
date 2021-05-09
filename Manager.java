import java.util.Scanner;

public class Manager extends DataGeneration {
	private static Scanner input=	new Scanner(System.in);

	static String shopsname;
	String password,username,name;
	int id;
	//	public Manager(){
	//		this("", "", "");
	//	}


	//	public Manager(String username, String password){
	//		this("", username, password);
	//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Manager( int id,String name,String username, String password){

		this.username = username;
		this.password = password;
		this.id=id;
		this.name=name;
	}



	public Manager() {

	}


	static void setShopName(String shopName) {
		Manager.shopsname=shopName;		
	}

	public static String getShopsname() {
		return shopsname;

	}
	public void setName(String name) {
		this.name = name;
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

	public void createNewManager(){

		receiveCredentials(); //Receive input for new manager credentials

		boolean isManagerExist = false;
		for(Manager manager: managers){
			if (manager.name.equals(name)){
				isManagerExist = true;
				System.out.println("\nManager Name Already Exists!\n");
				createNewManager();
				break;
			}
		} //Checking whether new manager credentials match with existing manager
		if (!isManagerExist){
			managers.add(this);
			System.out.println("New Manager Account Successfully Created.");
			displayManager();
		} //Create new manager and add to managers list if the manager does not exist
	}


	public void receiveCredentials(){
		//Receiving all manager credentials and double checking password entry
		input = new Scanner(System.in);
		System.out.println("\nCreate New Manager Account");
		System.out.println("Enter manager id: ");
		id = input.nextInt();

		System.out.println("Enter manager name: ");
		name = input.next();
		System.out.println("Enter new username: ");
		username = input.next();
		System.out.println("Enter new password: ");
		String passwordFirstTyped = input.next();
		System.out.println("Retype new password: ");
		String passwordRetyped = input.next();
		while(!passwordFirstTyped.equals(passwordRetyped)){
			System.out.println("Retyped password does not match! Try again.");
			System.out.println("Enter new password: ");
			passwordFirstTyped = input.next();
			System.out.println("Retype new password: ");
			passwordRetyped = input.next();
		}
		password = passwordFirstTyped;

	}

	public boolean isValidManager(String usernamecheck,String passwordcheck){
		boolean ch = false;
		for (Manager manager:managers){

			if (manager.username.contains(usernamecheck)) {

				if(manager.password.contains(passwordcheck)){
					ch=true;
					return ch;
				}
			}
		}
		return ch; 
	}

	public void displayManager(){
		System.out.println("\nManagers List\n-------------");
		int count = 1;
		for (Manager manager: managers){
			System.out.print(count + ". Manager Name: ");
			System.out.println(manager.name);
			System.out.print("   Manager Username: ");
			System.out.println(manager.username);
			count++;
		} //Displaying all managers in the list
	}

	public void deleteManager(){
		//Checking whether specified manager exist and deleting the manager from managers list if exist
		boolean isExist = false;
		Manager manager = null;
		if (managers.size() > 1){
			System.out.print("\nEnter manager name: ");
			String name = input.nextLine();
			for (Manager managerL: managers){
				if (managerL.name.equals(name)){
					isExist = true;
					manager = managerL;
					break;
				}
			}
		}
		else{
			System.out.println("Manager Account Deletion aborted! Only one manager account exist.");
			return;
		} 
		if (isExist){
			managers.remove(manager);
			System.out.println("Specified Manager Account Successfully Deleted.");
		}
		else
			System.out.println("Specified Manager Account Does Not Exist!");
	}
	public int login() {
		int flag=0;
		String usernames,passwords;
		while(flag!=2) {
			System.out.println("Enter your username to login  ");	 
			usernames=input.next();
			System.out.println("Enter your password to login");	 
			passwords=input.next();
			boolean log=isValidManager(usernames,passwords);

			if(log) {
				flag=2;
			}

		}
		return flag;
	}



}


