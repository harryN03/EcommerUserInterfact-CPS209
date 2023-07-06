//Name: Hoai Minh Nguyen
//Student Id: 501136627
public class CartItem {
	Product product;
	String productOptions;
	public CartItem(Product product)
	{
		this.product = product;
		this.productOptions = "";
	}
	public CartItem(Product product, String productOptions)
	{
		this.product = product;
		this.productOptions = productOptions;
	}
	public void print()
	{
		if (product.getCategory() == Product.Category.BOOKS)
		{ 
			product = (Book) product;
			System.out.println("Product id: "+ product.getId()+ " Options: "+ productOptions);
		}
		else System.out.println("Product id: " + product.getId());
	}
	public Product getProduct()
	{
		return product;
	}
	public String getProductOption()
	{
		return productOptions;
	}
}
