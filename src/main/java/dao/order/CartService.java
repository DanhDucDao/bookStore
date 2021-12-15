package dao.order;

import javax.persistence.EntityManager;

import dao.DBUtil;
import model.book.Book;
import model.order.Cart;
import model.order.LineItem;

public class CartService implements CartDAO{
	private EntityManager en;

	public CartService() {
		en = DBUtil.getEntityManager();
	}
	
	@Override
	public Cart addToCart(LineItem lineItem, Cart cart) {
		try {
			LineItem existLineItem = getLineItemIfExist(lineItem, cart);
			if(existLineItem != null) 
				updateLineItem(existLineItem, cart, lineItem);
			else 
				createLineItem(lineItem, cart);
			Cart resultCart = en.find(Cart.class, cart.getId());
			return resultCart;
		} finally {
			en.clear();
		}
	}
	
	private void createLineItem(LineItem lineItem, Cart cart) {
		en.getTransaction().begin();
		Book book = en.find(Book.class, lineItem.getBook().getId());
		Cart owncart = en.find(Cart.class, cart.getId());
		lineItem.setBook(book);
		lineItem.setAssociationCart(owncart);
		en.merge(lineItem);
		// prevent wrong price!
		lineItem.setPrice(book.getPrice());
		owncart.getLineitems().add(lineItem);
		en.getTransaction().commit();
	}
	
	private void updateLineItem(LineItem existLineItem, Cart cart, LineItem lineItem) {
		en.getTransaction().begin();
		existLineItem.setQuantity(existLineItem.getQuantity() + lineItem.getQuantity());
		en.getTransaction().commit();
	}

	private LineItem getLineItemIfExist(LineItem lineItem, Cart cart) {
		Cart owncart = en.find(Cart.class, cart.getId());
		int idBook = lineItem.getBook().getId();
		for(LineItem item : owncart.getLineitems()) {
			if(item.getBook().getId() == idBook)
				return item;
		} 
		return null;
			
	}

	
	public static void main(String[] args) {
		CartDAO cartd = new CartService();
		Book b = new Book();
		b.setId(2);
		LineItem lineItem = new LineItem();
		lineItem.setId(2);
		lineItem.setQuantity(30);
		lineItem.setPrice(10000);
		lineItem.setDiscount(0);
		lineItem.setBook(b);
		Cart cart = new Cart();
		cart.setId(2);
		
		cartd.addToCart(lineItem, cart);
		
	}

	@Override
	public void endSession() {
		if(en != null && en.isOpen()) {
			en.close();
		}
		
	}
}
