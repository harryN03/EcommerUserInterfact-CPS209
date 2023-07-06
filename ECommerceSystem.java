//Name: Hoai Minh Nguyen
//Student Id: 501136627
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;
/*
 * Models a simple ECommerce system. Keeps track of products for sale, registered customers, product orders and
 * orders that have been shipped to a customer
 */
public class ECommerceSystem
{
	private ArrayList<Product> products = new ArrayList<Product>();
	private int[][] rates = new int[100][5];
	private ArrayList<Cart> carts = new ArrayList<Cart>();
	private HashMap<String,Integer> orderCount = new HashMap<>();
    private HashMap<String, Product> map = new HashMap<>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();	
    private ArrayList<Book>  books = new ArrayList<Book>();
    private ArrayList<ProductOrder> orders   = new ArrayList<ProductOrder>();
    private ArrayList<ProductOrder> shippedOrders   = new ArrayList<ProductOrder>();
    
    // These variables are used to generate order numbers, customer id's, product id's 
    private int orderNumber = 500;
    private int customerId = 900;
    private int productId = 700;
    // General variable used to store an error message when something is invalid (e.g. customer id does not exist)  
    
    // Random number generator
    //Random random = new Random();
    
    
    public ECommerceSystem()
    {
    	// NOTE: do not modify or add to these objects!! - the TAs will use for testing
    	// If you do the class Shoes bonus, you may add shoe products
    	// Create some products. Notice how generateProductId() method is used
    	try {
        	File inputFile = new File("products.txt");
        	Scanner in = new Scanner(inputFile);
        	
        	while (in.hasNext())
        	{
        		String productId = generateProductId();
        		String productCategory = in.nextLine();
        		Product.Category cate = Product.Category.valueOf(productCategory);
        		String productName = in.nextLine();
        		double price = Double.valueOf(in.nextLine());
        		if (productCategory.equalsIgnoreCase("BOOKS"))
        		{
        			int paperbackStock = in.nextInt();
        			int hardcoverStock = in.nextInt();
        			String nextLine1 = in.nextLine();
        			String nextLine = in.nextLine();
        			int a = nextLine.indexOf(":");
        			int b= nextLine.lastIndexOf(":");
        			String title = nextLine.substring(a);
        			String author = nextLine.substring(a,b);
        			String year = nextLine.substring(b,nextLine.length());
        			map.put(productId, new Book("Book", productId, price, paperbackStock, hardcoverStock, title, author, year));
        		}
        		else
        		{
        			int stockCount = Integer.valueOf(in.nextLine());
        			String option = in.nextLine();
        			map.put(productId, new Product(productName, productId, price, stockCount, cate));
        		}
        	}
        	}
        catch (FileNotFoundException e)
        {
        	System.out.println("File Not Found");
        	// exit if File Not Found
        	System.exit(1);                      
        }
    	for (String st : map.keySet())
    	{
    		products.add(map.get(st));
    	}
    	// Create some customers. Notice how generateCustomerId() method is used
    	customers.add(new Customer(generateCustomerId(),"Inigo Montoya", "1 SwordMaker Lane, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Prince Humperdinck", "The Castle, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Andy Dufresne", "Shawshank Prison, Maine"));
    	customers.add(new Customer(generateCustomerId(),"Ferris Bueller", "4160 Country Club Drive, Long Beach"));
    	 for (Customer cust: customers)
    	    {
    	    	carts.add(new Cart(cust.getId()));
    	    }
    }
   
    private String generateOrderNumber()
    {
    	return "" + orderNumber++;
    }

    private String generateCustomerId()
    {
    	return "" + customerId++;
    }
    
    private String generateProductId()
    {
    	return "" + productId++;
    }
    
    public void printAllProducts()
    {
    	for (Product prod: products)
    	{
    		prod.print();
    	}
    }
    
    // Print all products that are books. See getCategory() method in class Product
    public void printAllBooks()
    {
    	for (String i : map.keySet()) {
    		Product p = map.get(i);
    		if (p.getCategory() == Product.Category.BOOKS) {
    			p.print();
    		}
    	}
    	
    }
    
    // Print all current orders
    public void printAllOrders()
    {	
    	for (ProductOrder p : orders) {
    		p.print();
    	}
    	
    }
    // Print all shipped orders
    public void printAllShippedOrders()
    {
    	for (ProductOrder p : shippedOrders) {
    		p.print();
    	}
    }
    
    // Print all customers
    public void printCustomers()
    {
    	for (Customer cust : customers) cust.print();
    }
    public boolean custIdExist(String CusId) // check if a customerID exists
    {
    	for (Customer cust : customers) {
    		if (cust.getId().equals(CusId)) {
    			return true;
    		}
    	}
    	return false;
    }
    public Customer getCust(String CusId) //get Customer given id
    {
    	for (Customer cust : customers) {
    		if (cust.getId().equals(CusId)) {
    			return cust;
    		}
    	}
    	return null;
    }
    public boolean prodIdExist(String prodId) //check if a productId exists
    {
    	for (String i : map.keySet()) {
    		Product p = map.get(i);
    		if (p.getId().equals(prodId)) {
    			return true;
    		}
    	}
    	return false;
    }
    public Product getProd(String prodId) //get product given its ID
    {
    	for (String i : map.keySet()) {
    		Product p = map.get(i);
    		if (p.getId().equals(prodId)) {
    			return p;
    		}
    	}
    	return null;
    }
    /*
     * Given a customer id, print all the current orders and shipped orders for them (if any)
     */
    public void printOrderHistory(String customerId)
    {
      // Make sure customer exists - check using customerId
    	// If customer does not exist, set errMsg String and return false
    	// see video for an appropriate error message string
    	// ... code here
    	if (!custIdExist(customerId)) {
    		throw new UnknownCustomerException("Customer " + customerId + " Not Found");
    	}
    	// Print current orders of this customer 
    	else
    	{
    		System.out.println("Current Orders of Customer " + customerId);
    		// enter code here
    		for (ProductOrder p : orders) {
    			if (p.getCustomer().getId().equals(customerId)) {
    				p.print();
    			}
    		}
    		// Print shipped orders of this customer 
    		System.out.println("\nShipped Orders of Customer " + customerId);
    	//enter code here
    		for (ProductOrder p : shippedOrders) {
    			if (p.getCustomer().getId().equals(customerId)) {
    				p.print();
    			}
    		}
    	}
    }
    
    public String orderProduct(String productId, String customerId, String productOptions)
    {
    	// First check to see if customer object with customerId exists in array list customers
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Customer object
    	if (!custIdExist(customerId)) {
    		throw new UnknownCustomerException("Customer " + customerId + " Not Found");
    	}
    	// Check to see if product object with productId exists in array list of products
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Product object 
    	else if (!prodIdExist(productId)) {
    		throw new UnknownProductException("Product " + productId + " Not Found");
    	}
    	//when both productId and customerId exist
    	Product pro = getProd(productId);
    	Customer cus = getCust(customerId);
    	// Check if the options are valid for this product (e.g. Paperback or Hardcover or EBook for Book product)
    	// See class Product and class Book for the method vaidOptions()
    	// If options are not valid, set errMsg string and return null;
    	if (!pro.validOptions(productOptions)) {
    		throw new InvalidProductOptionsException("Product " + pro.getName() + " ProductId " + pro.getId() + " Invalid Options: " + productOptions);
    	}
    	// Check if the product has stock available (i.e. not 0)
    	// See class Product and class Book for the method getStockCount()
    	// If no stock available, set errMsg string and return null
    	else if (pro.getStockCount(productOptions) == 0) {
    		if ((pro.getCategory() == Product.Category.BOOKS) || pro.getCategory() == Product.Category.SHOES)
    		{
    			throw new ProductOutOfStockException("Sorry. The productID " + productId + " with your options has been sold out");
    		}
    		else throw new ProductOutOfStockException("Sorry. The productID " + productId + " with your options has been sold out");
    	}
      // Create a ProductOrder, (make use of generateOrderNumber() method above)
    	// reduce stock count of product by 1 (see class Product and class Book)
    	// Add to orders list and return order number string
    	else 
    	{
    		if (productOptions.equalsIgnoreCase("EBOOK") || productOptions.equalsIgnoreCase("HARDCOVER") ||productOptions.equalsIgnoreCase("PAPERBACK"))
    		{
    			if (pro.getCategory() == Product.Category.BOOKS)
    			{ 
    				pro = (Book) pro;
    			}
    			else 
    			{
    				System.out.println("Please check again. Your entered ProductId does not correspond to a book");
    				return "";
    			}
    		}
    		else if (!(productOptions.equals(""))) 
    		{
    			if (pro.getCategory() == Product.Category.SHOES) 
    			{
    				pro = (Shoes) pro;
    			}
    			else 
    			{
    				System.out.println("Please check again. Your entered ProductId does not correspond to shoes.");
    				return "";
    			}
    		}
    		pro.reduceStockCount(productOptions);
    		orderCountIncrement(productId);
    		orders.add(new ProductOrder(generateOrderNumber(), pro, cus, productOptions));
    		return "Order #" + (orderNumber-1); //I called generateOrderNumber above, meaning that orderNumber have incremented by 1. So I minus orderNumber by 1.
    	}
    }
    
    /*
     * Create a new Customer object and add it to the list of customers
     */
    
    public void createCustomer(String name, String address)
    {
    	// Check name parameter to make sure it is not null or ""
    	// If it is not a valid name, set errMsg (see video) and return false
    	if (name == null || name.equals("")) {
    		throw new InvalidCustomerNameException("Invalid Customer Name");
    	}
    	// Repeat this check for address parameter
    	else if (address == null || address.equals("")) {
    		throw new InvalidCustomerAddressException("Invalid Customer Adress");
    	}
    	// Create a Customer object and add to array list
    	else {
    		customers.add(new Customer(generateCustomerId(),name,address));
    	}
    }
    
    public void shipOrder(String orderNumber)
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false
    	// Retrieve the order from the orders array list, remove it, then add it to the shippedOrders array list
    	// return a reference to the order
    	boolean flag = false; // to check if order number exists
    	ProductOrder pro = null;
    	int i = -1;
    	for (ProductOrder proor : orders) {
    		if (proor.getOrderNumber().equals(orderNumber)) {
    			flag = true;
    			pro = proor;
    		}
    		i++;
    		if (flag) break;
    	}
    	/* flag == true: order number exists
    	 * flag == false: order number does not exist
    	*/
    	if (flag) {        //if orderNumber exists
    		shippedOrders.add(pro);     //add ProductOrder to shippedOrders
    		orders.remove(i); 			//remove ProductOrder from orders
    		pro.print();				//print out the information of shipped order
    	}
    	else throw new InvalidOrderNumberException("Order " + orderNumber + " Not Found");	//print this line if orderNumber does not exist
    }
    
    /*
     * Cancel a specific order based on order number
     */
    public void cancelOrder(String orderNumber)
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false
    	boolean flag = false; // to check if order number exists
    	ProductOrder pro=null;
    	int i = -1;
    	for (ProductOrder proor : orders) {
    		if (proor.getOrderNumber().equals(orderNumber)) {
    			flag = true;
    			pro = proor;
    		}
    		i++;
    		if (flag) break;
    	}
    	if (!flag) {
    		throw new InvalidOrderNumberException("Order " + orderNumber + " Not Found"); //print out this line if orderNumber does not exist
    	}
    	else {
    		orders.remove(i);	//if orderNumber exists, cancel that order
			String option = pro.getProductOptionString();
			pro.getProduct().setStockCount(pro.getProduct().getStockCount(option) +1, option);
    	}
    }
    
    public void addTocart(String productId, String customerId, String productOptions)
    {
    	if (!custIdExist(customerId)) {
    		throw new UnknownCustomerException("Customer " + customerId + " Not Found");
    	}
    	// Check to see if product object with productId exists in array list of products
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Product object 
    	else if (!prodIdExist(productId)) {
    		throw new UnknownProductException("Product " + productId + " Not Found");
    	}
    	//when both productId and customerId exist
    	Product pro = getProd(productId);
    	Customer cus = getCust(customerId);
    	// Check if the options are valid for this product (e.g. Paperback or Hardcover or EBook for Book product)
    	// See class Product and class Book for the method vaidOptions()
    	// If options are not valid, set errMsg string and return null;
    	if (!pro.validOptions(productOptions)) {
    		throw new InvalidProductOptionsException("Product " + pro.getName() + " ProductId " + pro.getId() + " Invalid Options: " + productOptions);
    	}
    	for (Cart cart: carts)
    	{
    		if (cart.getCustomerId().equals(customerId))
    		{
    			cart.addCartItem(new CartItem(getProd(productId), productOptions));
    		}
    	}
    	
    }
    
    // remove a item from cart
    public void remCartItem(String customerId, String productId)
    {
    	if (!custIdExist(customerId)) {
    		throw new UnknownCustomerException("Customer " + customerId + " Not Found");
    	}
    	// Check to see if product object with productId exists in array list of products
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Product object 
    	else if (!prodIdExist(productId)) {
    		throw new UnknownProductException("Product " + productId + " Not Found");
    	}
    	for (Cart cart:carts)
    	{
    		if (cart.getCustomerId().equals(customerId))
    		{
    			ArrayList<CartItem> items = cart.getAllItem();
    			for (CartItem x: cart.getAllItem())
    			{
    				if (x.getProduct().getId().equals(productId))
    				{
    					items.remove(x);
    					break;
    				}
    			}
    			cart.setAllItems(items);
    		}
    	}
    	
    }
    
    public void printCart(String customerId)
    {
    	if (!custIdExist(customerId)) {
    		throw new UnknownCustomerException("Customer " + customerId + " Not Found");
    	}
    	for (Cart cart: carts)
    	{
    		if (cart.getCustomerId().equals(customerId))
    		{
    			cart.printAllItems();
    		}
    }}
    public void orderItems(String customerId)
    {
    	if (!custIdExist(customerId)) {
    		throw new UnknownCustomerException("Customer " + customerId + " Not Found");
    	}
    	for (Cart cart: carts)
    	{
    		if (cart.getCustomerId().equals(customerId))
    		{
    			for (CartItem x : cart.getAllItem())
    			{
    				orderProduct(x.getProduct().getId(), customerId, x.getProductOption());
    			}
    			cart.setAllItems(new ArrayList<CartItem>());
    		}
    	}
    }
    int a = 0;
    public void productRating(String productId, int rate)
    {	
    	if (!prodIdExist(productId)) 
    	{
    		throw new UnknownProductException("Product " + productId + " Not Found");
    	}
    	if (rate>5 || rate<1)
    	{
    		throw new RateException("Invalid rating");
    	}
    	int id = Integer.valueOf(productId);
    	int a = rates[id-700][rate-1]+1;
    	rates[id-700][rate-1]=a;
    }
    
    public void ratingAboveThreshold(int a, String category)
    {
    	if (a>5 || a<1) throw new RateException("Invalid rating");
    	Product.Category cate = Product.Category.valueOf(category);
    	System.out.println("Product with rating above " + a + " in catergory " + category +": ");
    	for (Product prod:products)
    	{
    		if ((averageRating(prod.getId()) >= a) && (prod.getCategory()==cate))
    		{
    			prod.print();
    		}
    		
    	}
    	
    }
    public double averageRating(String productId)
    {
    	int id = Integer.valueOf(productId);
    	int sum = 0;
    	int count =0;
    	for (int i =0; i<5;i++)
    	{
    		count += rates[id-700][i];
    		sum += rates[id-700][i]*(i+1);
    	}
    	if (!(count==0))
    	{
    	return sum/count;
    	}
    	else return 0;
    }
    public void orderCountIncrement(String productId)
    {
    	if (!orderCount.containsKey(productId)) 
    	{
    		orderCount.put(productId, 1);
    	}
    	else 
    	{
    		orderCount.put(productId, orderCount.get(productId)+1);
    	}
    }
    
    
    public void printOrderTimes()
    {
    	Set<Entry<String, Integer>> set = orderCount.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        for(Map.Entry<String, Integer> entry:list){
        	Product prod = getProd(entry.getKey());
        	System.out.println(prod.getName() +" Product ID: " +entry.getKey()+"      Times: "+entry.getValue());
        }
    }
    
    // Sort products by increasing price
    public void sortByPrice()
    {
    	Collections.sort(products, new SortByPrice());
    	printAllProducts();
    }
    
    
    // Sort products alphabetically by product name
    public void sortByName()
    {
  	  Collections.sort(products, new SortByName());
  	  printAllProducts();
    }
    
        
    // Sort products alphabetically by product name
    public void sortCustomersByName()
    {
  	  Collections.sort(customers, new SortCustomerByName());
    }
    
}
class SortByName implements Comparator<Product> {
		public int compare (Product a, Product b) {
			String aName = a.getName();
			String bName = b.getName();
			return aName.compareTo(bName);
		}
}
class SortCustomerByName implements Comparator<Customer> {
	public int compare (Customer a, Customer b) {
		String aName = a.getName();
		String bName = b.getName();
		return aName.compareTo(bName);
	}
}
class SortByPrice implements Comparator<Product> {
	public int compare (Product a, Product b) {
		double aPrice = a.getPrice();
		double bPrice = b.getPrice();
		return Double.compare(aPrice, bPrice);
	}
}

class UnknownCustomerException extends RuntimeException
{
	public UnknownCustomerException(String message)
	{
		super(message);
	}
}

class UnknownProductException extends RuntimeException
{
	public UnknownProductException(String message)
	{
		super(message);
	}
}

class InvalidProductOptionsException extends RuntimeException
{
	public InvalidProductOptionsException(String message)
	{
		super(message);
	}
}

class ProductOutOfStockException extends RuntimeException
{
	public ProductOutOfStockException(String message)
	{
		super(message);
	}
}

class InvalidCustomerNameException extends RuntimeException
{
	public InvalidCustomerNameException(String message)
	{
		super(message);
	}
}

class InvalidCustomerAddressException extends RuntimeException
{
	public InvalidCustomerAddressException(String message)
	{
		super(message);
	}
}

class InvalidOrderNumberException extends RuntimeException
{
	public InvalidOrderNumberException(String message)
	{
		super(message);
	}
}

class RateException extends RuntimeException
{
	public RateException(String message)
	{
		super(message);
	}
}