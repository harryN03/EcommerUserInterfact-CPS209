//Name: Hoai Minh Nguyen
//Student Id: 501136627
import java.util.*;

public class Shoes extends Product{
	ShoesStock stock;
	public Shoes(String name, String id, double price, ShoesStock stock) {
		super(name,id,price, 00, Category.SHOES);
		this.stock = stock;
	}
	@Override
	public boolean validOptions(String productOptions) {
		int size = 0 ;
		String colour = "";
		Scanner scanner = new Scanner(productOptions);
		if (scanner.hasNextInt())
			size = scanner.nextInt();
		if (scanner.hasNext())
			colour = scanner.next();
		boolean sizeAccepted = size<=10 && size>=6;
		boolean colourAccepted = colour.equalsIgnoreCase("BROWN") || colour.equalsIgnoreCase("BLACK");
		if (sizeAccepted && colourAccepted ) return true;
		return false;
	}
	@Override
	public void print() 
	{
		System.out.printf("\nId: %-5s Category: %-9s Name: %-20s Price: %7.1f", id, category, name, price);
	}
	@Override
	public int getStockCount(String productOptions)
	{
		return stock.getStockCount(productOptions);
	}
	@Override
	public void reduceStockCount(String productOptions)
	{
		stock.reduceStockCount(productOptions);
	}
}
