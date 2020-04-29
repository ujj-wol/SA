package shop;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import shop.dto.*;

import java.net.URI;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {
	@Autowired
	private RestOperations  restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(WebShopApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		return restTemplate;
	}

	@Override
	public void run(String... args) throws Exception {

		String baseUrl = "http://localhost:80";
		ObjectMapper mapper = new ObjectMapper();

		//create customer
		CustomerDTO customerDto = new CustomerDTO("101","Frank","Brown","fBrown@Hotmail.com","123456");
		AddressDTO addressDTO = new AddressDTO("1000 N main Street", "Fairfield","52557","USA");
		customerDto.setAddress(addressDTO);
		//todo: call the customer component to add the customer
		URI response = restTemplate.postForLocation(baseUrl + "80/customer", customerDto);

		// get customer
		//todo: call the customer component to get the customer with id 101 and print the result
		CustomerDTO customerResponse = restTemplate.getForObject(baseUrl + "80/customer/101", CustomerDTO.class);
		System.out.println(customerResponse.toString());

		//create products

		//todo: call the product component to create the first product
		restTemplate.postForLocation(baseUrl + "81/product/Prod1/FirstProduct/12", ProductDTO.class);
		//todo: call the product component to create the second product
		restTemplate.postForLocation(baseUrl + "81/product/Prod2/SecondProduct/2.5678", ProductDTO.class);

		//set stock
		//todo: call the product component to set the stock for the first product
		restTemplate.postForLocation(baseUrl + "81/product/stock/Prod1/4/A179", ProductDTO.class);

		//get a product
		//todo: call the product component to get the the first product and print the result
		ResponseEntity<String> product1
				= restTemplate.getForEntity(baseUrl + "81/product/Prod1", String.class);
		JsonNode root = mapper.readTree(product1.getBody());
		System.out.println(root);
		ProductDTO productDTO1 = mapper.readValue(product1.getBody(), ProductDTO.class);
		productDTO1.print();

		// add products to the shoppingcart
		//todo: call the shopping component to add the first product to the cart
		restTemplate.postForLocation(baseUrl + "82/cart/Cart1/Prod1/2", null);
		//todo: call the shopping component to add the second product to the cart
		restTemplate.postForLocation(baseUrl + "82/cart/Cart1/Prod2/5", null);

		//get the shoppingcart
		//todo: call the shopping component to get the cart and print the result
		restTemplate.getForObject(baseUrl + "82/cart/Cart1", ShoppingCartDTO.class).print();

		//checkout the cart
		//todo: call the shopping component to checkout the cart
		restTemplate.postForLocation(baseUrl + "82/cart/checkout/Cart1", null);

		//get the order
		//todo: call the order component to get the order and print the result
		restTemplate.getForObject(baseUrl + "83/order/Cart1", OrderDTO.class).print();

		//add customer to order
		//todo: call the order component to add a customer to the order
		restTemplate.postForLocation(baseUrl + "83/order/setCustomer/Cart1/101", null);

		//confirm the order
		//todo: call the order component to confirm the order
		restTemplate.postForLocation(baseUrl + "83/order/Cart1", null);

		//get the order
		//todo: call the order component to get the order and print the result
		restTemplate.getForObject(baseUrl + "83/order/Cart1", OrderDTO.class).print();
		
	}


}
