package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.customer.CustomerDAO;
import dao.customer.CustomerService;
import model.customer.Customer;
import model.order.Cart;

@WebServlet("/cart")
public class CartServlet extends HttpServlet{
	private static final long serialVersionUID = -2117144651004442878L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		CustomerDAO cus = new CustomerService();
		try {
			HttpSession session = request.getSession();
			Customer customer = (Customer) session.getAttribute("user");
			
			Cart cart = cus.getCurrentCart(customer);
			request.setAttribute("cart", cart);
			getServletContext().getRequestDispatcher("/customer/cart.jsp").forward(request, response);
		} finally {
			cus.endSession();
		}
	}
	
}
