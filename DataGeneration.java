import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class DataGeneration {

	public static final  ArrayList<Menu>MenuItem=new ArrayList<Menu>();
	public static final  ArrayList<Order>Orders=new ArrayList<Order>();
	public static final List<Employee>Emp=new ArrayList<Employee>();
	public static final ArrayList<Manager> managers = new ArrayList<>();
	public static final ArrayList<Order> OrdersAll= new ArrayList<>();

	void menufile(){
		try {

			BufferedReader reader = new BufferedReader(new FileReader("menuu.txt"));
			String line = reader.readLine();

			while (line != null) {
				String[] record  =line.split(",");

				String id = record[0];
				String name = record[1];
				String price = record[2];
				Menu rMenuItem = new Menu(Integer.parseInt(id), name, 	Integer.parseInt(price));
				MenuItem.add(rMenuItem);

				line = reader.readLine();
			}

			reader.close();
		} catch (Exception ioe) {
		}


	}
	void employeefile(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\DELL\\Desktop\\project\\Employee.txt"));
			String line = reader.readLine();

			while (line != null) {
				String[] record  =line.split(",");

				String id = record[0];
				String name = record[1];
				String salary = record[2];
				String username = record[3];
				String password=record[4];
				Employee emplo= new Employee(Integer.parseInt(id), name, 	Integer.parseInt(salary),username,password);
				Emp.add(emplo);
				line = reader.readLine();

			}
			reader.close();
		} catch (Exception ioe) {
		}

	}

	public void loadmenufile() {
		Iterator<Menu> itr=MenuItem.iterator();  
		while(itr.hasNext()){  
			System.out.println(itr.next());  
		} 
	}	
	public void loadempfile() {
		Iterator<Employee> itr=Emp.iterator();  
		while(itr.hasNext()){  
			System.out.println(itr.next());  
		} 
	}

	int Search(int id)
	{


		for (int i=0;i<MenuItem.size();i++) {

			if(MenuItem.get(i).getId()==id) {
				return i;
			}
		}
		return -1;



	}
	public void updateEmpFile() 
	{
		Writer  writer;       
		String  tempFileName = "datafiles.txt";

		File tempFile = new File(tempFileName);

		try{
			writer = new BufferedWriter(new FileWriter(tempFile));
			Iterator<Employee> iterator = Emp.iterator();

			while (iterator.hasNext())
			{
				Employee emp = (Employee)iterator.next();

				writer.write(emp.getId() + "," + emp.getName() + "," + emp.getSalary()+"," + emp.getUsername()+"," + emp.getPassword()+"\r\n");
			}
			writer.flush();
			writer.close();
		}
		catch(IOException e)
		{


		}

		File deleteFile = new File("Employee.txt");
		deleteFile.delete();

		File newFile = new File("Employee.txt");  
		tempFile.renameTo(newFile);
	}
	public void updateMenuFile() 
	{
		Writer  writer;       
		String  tempFileName = "datafile.txt";

		File tempFile = new File(tempFileName);

		try{
			writer = new BufferedWriter(new FileWriter(tempFile));
			Iterator<Menu> iterator = MenuItem.iterator();

			while (iterator.hasNext())
			{
				Menu food = (Menu)iterator.next();

				writer.write(food.getId() + "," + food.getName() + "," + food.getPrice()+"\r\n");
			}
			writer.flush();
			writer.close();
		}
		catch(IOException e)
		{


		}

		//delete current file
		File deleteFile = new File("menuu.txt");
		deleteFile.delete();

		// renames temporaly file to new file
		File newFile = new File("menuu.txt");  
		tempFile.renameTo(newFile);
	}
	void managersfile(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\DELL\\Desktop\\manager.txt"));
			String line = reader.readLine();

			while (line != null) {
				String[] record  =line.split(",");

				String id = record[0];
				String name = record[1];
				String username = record[2];
				String password = record[3];
				Manager manager = new Manager(Integer.parseInt(id),name, username, password);
				managers.add(manager);

				line = reader.readLine();
			}

			reader.close();
		} catch (Exception ioe) {
		}

	}
	public void orderFile() 
	{
		Writer  writer;       
		String  tempFileName = "order.txt";
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date date = new Date(); 
		File tempFile = new File(tempFileName);

		try{
			writer = new BufferedWriter(new FileWriter(tempFile));
			Iterator<Order> iterator = OrdersAll.iterator();

			while (iterator.hasNext())
			{
				Order order = (Order)iterator.next();

				writer.write("\nId:"+order.getId() + "\tItem Name:" + order.getName() + "\tPrice: " + order.getPrice()+"\tQuantity: " + order.getQuantity()+"\r\n");
				writer.write("***********"+formatter.format(date)+"***********\n");  

			}

			writer.flush();
			writer.close();
		}
		catch(IOException e)
		{


		}

		File deleteFile = new File("C:\\Users\\DELL\\Desktop\\project\\order.txt");
		deleteFile.delete();

		File newFile = new File("C:\\Users\\DELL\\Desktop\\project\\order.txt");  
		tempFile.renameTo(newFile);
	}

}
