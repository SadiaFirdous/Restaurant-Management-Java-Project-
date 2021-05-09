import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Random;
public class Bill extends DataGeneration {
	private static Scanner input = new Scanner(System.in);
	User user=new User();
	Writer  writer;       
	Random rand=new Random();
	String  tempFileName = "C:\\Users\\DELL\\Desktop\\project\\receipt.txt";
	String  tempFileOrder = "orderday.txt";
	double random=(rand.nextDouble())*1000;
	int total=0;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	Date date = new Date();  
	public void receipt(int id){
		System.out.println("Your name please ");
		user.setName(input.next());
		System.out.println("Your phone number ");

		long phone=input.nextLong();

		user.setPhoneno(phone);
		System.out.println("Your address number ");

		user.setAddress(input.next());


		File tempFile = new File(tempFileName);
		

		try{
			writer = new BufferedWriter(new FileWriter(tempFile));
			Iterator<Order> iterator = Orders.iterator();
			writer.write("\n---------RECEIPT-----------\n");
			writer.write("\nName :"+user.getName()+"\tPhone Number :"+user.getPhoneno()+"\tAddress :"+user.getAddress());
			writer.write("\n***********YOUR ORDERS***********\n");
			writer.write("***********OUR STAFF ID :"+id+"***********");
			
			writer.write("***********ORDER ID :"+random+"***********");

			while (iterator.hasNext())
			{
				Order order = (Order)iterator.next();
				total=order.getPrice()*order.getQuantity()+total;
				writer.write("\nItemID ---"+order.getId() + "\tItem Name--" + order.getName() + "\tItem Price--" + order.getPrice()+"\tItem Quantity---" + order.getQuantity()+"\r\n");
			}
			Order o=new Order();
			writer.write("\nYOUR TOTAL IS:------------"+total+"\n");

			
			writer.write("***********"+formatter.format(date)+"***********\n");  

			writer.write("\n************DO VISIT AGAIN!!!!************\n");
			writer.flush();
			writer.close();
		}
		catch(IOException e)
		{


		}


	}

}
