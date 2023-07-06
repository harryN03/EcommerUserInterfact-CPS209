//Name: Hoai Minh Nguyen
//Student Id: 501136627
class Book extends Product {
	String title;
	String author;
	int hardCoverStock;
	int paperBackStock;
	String year;
	public Book(String name, String id, double price, int paperBackStock, int hardCoverStock, String title, String author, String year) {
		super(name,id,price,1000000,Category.BOOKS);
		this.paperBackStock = paperBackStock ;
		this.title = title;
		this.author = author;
		this.year = year;
	}
	public String toString()
	{
		System.out.printf("\nId: %-5s Category: %-9s Name: %-20s Price: %7.1f Book Title: %s Author: %s Published Year: %s", id, category, name, price, title, author,year);
		return "";
	}
	@Override
	public void print()
	{
		System.out.printf("\nId: %-5s Category: %-9s Name: %-20s Price: %7.1f Book Title: %s Author: %s Published Year: %s", id, category, name, price, title, author,year);
	}
	@Override
	public boolean validOptions(String productOptions) {
		if (productOptions.equalsIgnoreCase("EBOOK") || productOptions.equalsIgnoreCase("HARDCOVER") ||productOptions.equalsIgnoreCase("PAPERBACK")) {
			return true;
		}
		return false;
	}
	@Override
	public int getStockCount(String productOptions)
	{
		if (productOptions.equalsIgnoreCase("HARDCOVER")) {
			return hardCoverStock;
		}
		else if (productOptions.equalsIgnoreCase("PAPERBACK")) {
			return paperBackStock;
		}
		return 0;
	}
	@Override
	public void setStockCount(int stockCount, String productOptions)
	{
		if (productOptions.equalsIgnoreCase("HARDCOVER")) {
			this.hardCoverStock = stockCount;
		}
		else if (productOptions.equalsIgnoreCase("PAPERBACK")) {
			this.paperBackStock = stockCount;
		}
	}
	@Override
	public void reduceStockCount(String productOptions)
	{
		if (productOptions.equalsIgnoreCase("HARDCOVER")) {
			hardCoverStock--;
		}
		else if (productOptions.equalsIgnoreCase("PAPERBACK")) {
			paperBackStock--;
		}
	}
	public String getAuthor() {
		return author;
	}
	public String getTitle() {
		return title;
	}
	public String getYear() {
		return year;
	}
}