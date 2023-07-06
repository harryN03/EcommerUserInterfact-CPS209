My program can do:

Cart and CartItem functionality:

   -ADDTOCART:enter productId, customerId, productoptions
     + if the  CustomerId does not exists, an errMsg "Customer ... Not Found" will be printed
     + Similarly, if the ProductId does not exists, an errMsg "Product ... Not Found" will be printed
     + if productId imply books or shoes, and raise Exception if the option is not valid
     + otherwise, the program will add product to the customer's cart

   -REMCARTITEM: enter customerId and productId
     + if the  CustomerId does not exists, an errMsg "Customer ... Not Found" will be printed
     + Similarly, if the ProductId does not exists, an errMsg "Product ... Not Found" will be printed
     + if both of them are valid, the program will remove the product from the cart

   -PRINTCART: enter customerId
     + if customerid is invalid, an exception will be raised
     + else, it will print out the products in the customer's cart

   -ORDERITEM: enter CustomerId
     + if customerId is not valid, an exception will be raised
     + else, all products in the customer's cart will be ordered


File I/O and exception handling for reading the products.txt file and creating Product objects and storing in a Hashmap named "map"
  - raise exception if the filename does not exist
  - I call the Hashmap "map" instead of "products" in order to not misunderstand to arraylist "products" in Assignment1. 
The "map" match a String productId key to Product object (value).
  - I use ArrayList "products" to hold all products object (value) in map

Customized all errMsg variable:
   - I replace all errMsg variable by throwing Exception
   - I also change the "return type" for each method appropriately
   - List of exceptions : UnknownCustomerException, UnknownProductException, InvalidProductOptionsException, ProductOutOfStockException, 
InvalidCustomerNameException, InvalidCustomerAddressException, InvalidOrderNumberException.


Able to print product table statistics in order of descending number of times  

PRINTBYNAME, PRINTBYPRICE

BONUS:
   -Action "RATING" allows us to rate the product from 1 to 5, entering productId
     + if productId does not exist, catch exception
     + if rate over 5 or less then 1, catch exception
   -Action "PRODUCTRATING" allows us to list products of a certain specified category with ratings above a specified threshold, given category and threshold
     + throw exception when entered category is invalid
     + throw exception when entered rate is over 5 or less then 1 


----end----
