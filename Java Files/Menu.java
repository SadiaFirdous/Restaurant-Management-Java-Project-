import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Menu extends DataGeneration  {
	int id;
	int price;
	String name;
	int quantity;
	private static Scanner input = new Scanner(System.in);
	Menu(int id,String name, int price){
		this.id=id;
		this.price=price;
		this.name=name;
	}

	public Menu() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String toString() {
		return ("------------------------"
				+ " Id: "+this.getId()+
				" Item: "+ this.getName()+ " Price "+ this.getPrice()
				+"------------------------\n");
	}
	public void ViewMenu(){
		loadmenufile();
	}


	public void additems() {

		Menu m=new Menu();
		System.out.println("Add item details like price,name,id");
		m.setId(input.nextInt());
		m.setName(input.next());
		m.setPrice(input.nextInt());
		if((Search(m.getId())!=-1)) {
			System.out.println("Please enter unique id!");
			additems();
		}
		MenuItem.add(m);
	}



	class SortById implements Comparator<Menu>{

		@Override
		public int compare(Menu o1, Menu o2) {
			return o1.id-o2.id;

		}

	}
	public	void sort() {
		Collections.sort(MenuItem,new SortById());
	}

}
