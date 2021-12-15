package dao.order;

import model.order.Cart;
import model.order.LineItem;

public interface CartDAO {
	/**
	 * add a line item to cart, if already exist, update the quantity
	 * @param lineItem lineItem instance adding to cart, must not exist in database (not have an id)
	 * @param cart the target cart instance (the current cart)
	 * @return updated cart
	 */
	Cart addToCart(LineItem lineItem, Cart cart);
	
	/**
	 * end session and clear resoure 
	 */
	void endSession();
}
