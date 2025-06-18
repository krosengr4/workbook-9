import java.util.HashMap;

@Component
public class SimpleProductDao implements ProductDao{

   private HashMap<Long, Product> productMap;

   public SimpleProductDao() {
	  this.productMap.put(10L, new Product(10, "Chocolate Chip Cookies", "Food", 11.99));
	  this.productMap.put(11L, new Product(11, "Shampoo", "Bathroom", 8.99));
	  this.productMap.put(12L, new Product(12, "Kev's Kolaches", "Food", 8.99));
	  this.productMap.put(13L, new Product(13, "Madden 13", "Video Games", 8.99));
   }

}
