package shop.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.shopping.domain.Product;
import shop.shopping.domain.ShoppingCart;
import shop.shopping.integration.OrderServiceProxy;
import shop.shopping.integration.ProductCatalogServiceProxy;
import shop.shopping.repository.ShoppingCartRepository;

import java.util.Optional;

@Service
public class ShoppingService {
	@Autowired
	ProductCatalogServiceProxy productCatalogService;
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	@Autowired
	OrderServiceProxy orderService;

	public void addToCart(String cartId, String productnumber, int quantity) {
		ProductDTO productsproduct = productCatalogService.getProduct(productnumber);
		//create a shopping product from a products product
		Product product = new Product(productsproduct.getProductnumber(),productsproduct.getDescription(),productsproduct.getPrice());
		Optional<ShoppingCart> cartOptional = shoppingCartRepository.findById(cartId);
		if (cartOptional.isPresent() && product != null) {
			ShoppingCart cart = cartOptional.get();
			cart.addToCart(product, quantity);
			shoppingCartRepository.save(cart);
		}
		else if (product != null) {
			ShoppingCart cart = new ShoppingCart();
			cart.setCartid(cartId);
			cart.addToCart(product, quantity);
			shoppingCartRepository.save(cart);
		}		
	}
	
	public ShoppingCartDTO getCart(String cartId) {
		Optional<ShoppingCart> cart = shoppingCartRepository.findById(cartId);
		if (cart.isPresent())
		  return ShoppingCartAdapter.getShoppingCartDTO(cart.get());
		else
			return null;
	}

	public void checkout(String cartId) {
		Optional<ShoppingCart> cart = shoppingCartRepository.findById(cartId);
		if (cart.isPresent()) {
			orderService.createOrder(ShoppingCartAdapter.getShoppingCartDTO(cart.get()));
		}		
	}
}
