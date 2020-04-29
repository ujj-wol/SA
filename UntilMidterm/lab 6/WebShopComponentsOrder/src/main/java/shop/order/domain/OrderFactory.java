package shop.order.domain;

import shop.order.service.CartLineDTO;
import shop.order.service.ShoppingCartDTO;

import java.util.Date;


public class OrderFactory {
	
	public static Order createOrder(ShoppingCartDTO cartDTO) {
		Order order = new Order(cartDTO.getCartid(), new Date(),"placed");
		for (CartLineDTO cline : cartDTO.getCartlineList()) {
			OrderLine oline = new OrderLine();
			//create an order product from a shopping product
			Product product = new Product(cline.getProduct().getProductnumber(), cline.getProduct().getDescription(), cline.getProduct().getPrice());
			oline.setProduct(product);
			oline.setQuantity(cline.getQuantity());
			order.addOrderLine(oline);
		}
		return order;
	}
}
