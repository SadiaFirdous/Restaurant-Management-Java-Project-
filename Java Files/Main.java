import java.util.*;
public class Main  {
	private static Scanner input;
	static DataGeneration data=new DataGeneration();


	static void files() {

		data.menufile();
		data.employeefile();
		data.managersfile();
	}

	public static void main(String args[]) {
		int load=1;
		Bill bill=new Bill();

		Order order=new Order();
		Menu menu=new Menu();
		Employee emp=new Employee();
		int flag=0;
		int flagemp=0;
		input = new Scanner(System.in);
		System.out.print("Enter Restaurant Name: ");
		String shopName = input.nextLine();
		Manager.setShopName(shopName);
		Manager manager= new Manager();

		if(load==1) {
			load=0;

			files();

		}
		System.out.println("Enter if you are existing manager or employee IF manager press 1 Else 2");

		System.out.println("Enter if you are a new manager  press 3 ");
		int choice=input.nextInt();



		switch(choice) {
		case 1:
			flag=manager.login();
			break;

		case 2:flagemp=emp.login();
		break;
		}
		if(flag==2||flagemp==2) {
			System.out.println("Succesful login!!");

		}
		while(flag==2 ||flagemp==2) {

			System.out.println("Enter your choice please");
			System.out.println("To View Menu  press 1");
			System.out.println("To View Order press 2");
			System.out.println("To check out for receipt press 4");
			if(flagemp!=2) {
				System.out.println("To View Employee press 3");

			}



			int option = 0;
			option = input.nextInt();
			switch(option) {
			case 1:System.out.println("Press 1 for Menu");
			if(flagemp!=2) {
				System.out.println("Press 2 to change Menu or add items");
			}
			System.out.println("Press 3 to view Menu in sorted manner");

			int menuopt=input.nextInt();
			switch(menuopt) {
			case 1:menu.ViewMenu();
			break;
			case 2:menu.additems();
			data.updateMenuFile();
			break;
			case 3:menu.sort();
			menu.ViewMenu();
			break;
			}
			break;



			case 2:
				System.out.println("To place order details Press 1");
				System.out.println("To get order details Press 2");
				System.out.println("To modify order details Press 3");

				int orderopt=input.nextInt();
				switch(orderopt) {
				case 1: order.PlaceOrder();
				data.orderFile();
				break;
				case 2:order.getorder();
				break;
				case 3: order.Modify(); 
				data.orderFile();
				break;
				}
				break;
			case 3: System.out.println("Enter your choice please");
			System.out.println("To Change Employee Name Press 1");
			System.out.println("To Change Employee Salary Press 2");
			System.out.println("To see Employee Data Press 3");
			System.out.println("To see Employee Data in Sorted Manner Press 4");
			System.out.println("To add Employee Press 5");
			int opt=input.nextInt();

			switch(opt) {
			case 1:System.out.println("Enter employee name");
			String name=input.next();
			System.out.println("Enter employee id");
			int id=input.nextInt();
			emp.changename(name,id);
			data.updateEmpFile();

			break;
			case 2: System.out.println("Enter employee salary");
			int sal=input.nextInt();
			System.out.println("Enter employee id");
			int ide=input.nextInt();
			emp.changesalary(sal,ide);
			data.updateEmpFile();

			break;	
			case 3:emp.getdata();

			break;
			case 4:emp.sort();
			data.loadempfile();
			break;
			case 5:emp.addemp();
			data.updateEmpFile();
			break;
			}
			break;
			case 4:System.out.println("Enter employee id");
			int idget=input.nextInt();
			bill.receipt(idget);
			DataGeneration.OrdersAll.addAll(DataGeneration.Orders);
			data.orderFile();
			DataGeneration.Orders.removeAll(DataGeneration.Orders);
			break;
			}




		}
	}

}
