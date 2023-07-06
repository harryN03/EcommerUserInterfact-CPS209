//Name: Hoai Minh Nguyen
//Student Id: 501136627
import java.util.ArrayList;
import java.util.List;

public class Cart {
	private String customerId;
	public ArrayList<CartItem> items = new ArrayList<CartItem>();
	public Cart(String customerId)
	{
		this.customerId = customerId;
	}
	public String getCustomerId()
	{
		return customerId;
	}
	public void addCartItem(CartItem i)
	{
		items.add(i);
	}
	public void removeCartItem(int a)
	{
		items.remove(a);
	}
	public void setAllItems(ArrayList<CartItem> newitems)
	{
		items = newitems;
	}
	public ArrayList<CartItem> getAllItem()
	{
		return items;
	}
	public void printAllItems()
	{
		for (CartItem i:items)
		{
			i.print();
		}
	}
}
