//Name: Hoai Minh Nguyen
//Student Id: 501136627
public class ShoesStock {
	private int bl6;
	private int br6;
	private int bl7;
	private int br7;
	private int bl8;
	private int br8;
	private int bl9;
	private int br9;
	private int bl10;
	private int br10;
	
	public ShoesStock(int bl6, int br6, int bl7, int br7, int bl8, int br8, int bl9, int br9, int bl10, int br10) 
	{
		this.bl6 = bl6;
		this.br6 = br6;
		this.bl7 = bl7;
		this.br7 = br7;
		this.bl8 = bl8;
		this.br8 = br8;
		this.bl9 = bl9;
		this.br9 = br9;
		this.bl10 = bl10;
		this.br10 = br10;
	}
	public int getStockCount(String productOptions)
	{
		if (productOptions.equalsIgnoreCase("6 Black")) return bl6;
		else if (productOptions.equalsIgnoreCase("6 Brown")) return br6;
		else if (productOptions.equalsIgnoreCase("7 Black")) return bl7;
		else if (productOptions.equalsIgnoreCase("7 Brown")) return br7;
		else if (productOptions.equalsIgnoreCase("8 Black")) return bl8;
		else if (productOptions.equalsIgnoreCase("8 Brown")) return br8;
		else if (productOptions.equalsIgnoreCase("9 Black")) return bl9;
		else if (productOptions.equalsIgnoreCase("9 Brown")) return bl9;
		else if (productOptions.equalsIgnoreCase("10 Black")) return bl10;
		else if (productOptions.equalsIgnoreCase("10 Brown")) return br10;
		else return 0;
	}
	public void setStockCount(int stockCount, String productOptions) 
	{
		if (productOptions.equalsIgnoreCase("6 Black")) this.bl6 = stockCount;
		else if (productOptions.equalsIgnoreCase("6 Brown")) this.br6 = stockCount;
		else if (productOptions.equalsIgnoreCase("7 Black")) this.bl7 = stockCount;
		else if (productOptions.equalsIgnoreCase("7 Brown")) this.br7 = stockCount;
		else if (productOptions.equalsIgnoreCase("8 Black")) this.bl8 = stockCount;
		else if (productOptions.equalsIgnoreCase("8 Brown")) this.br8 = stockCount;
		else if (productOptions.equalsIgnoreCase("9 Black")) this.bl9 = stockCount;
		else if (productOptions.equalsIgnoreCase("9 Brown")) this.bl9 = stockCount;
		else if (productOptions.equalsIgnoreCase("10 Black")) this.bl10 = stockCount;
		else if (productOptions.equalsIgnoreCase("10 Brown")) this.br10 = stockCount;
	}
	public void reduceStockCount(String productOptions)
	{
		if (productOptions.equalsIgnoreCase("6 Black")) bl6--;
		else if (productOptions.equalsIgnoreCase("6 Brown")) br6--;
		else if (productOptions.equalsIgnoreCase("7 Black")) bl7--;
		else if (productOptions.equalsIgnoreCase("7 Brown")) br7--;
		else if (productOptions.equalsIgnoreCase("8 Black")) bl8--;
		else if (productOptions.equalsIgnoreCase("8 Brown")) br8--;
		else if (productOptions.equalsIgnoreCase("9 Black")) bl9--;
		else if (productOptions.equalsIgnoreCase("9 Brown")) bl9--;
		else if (productOptions.equalsIgnoreCase("10 Black")) bl10--;
		else if (productOptions.equalsIgnoreCase("10 Brown")) br10--;
	}
}
