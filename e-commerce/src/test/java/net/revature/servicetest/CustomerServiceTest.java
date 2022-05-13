package net.revature.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.synergy.ecommerce.ECommerceApplication;
import com.synergy.ecommerce.entities.Customer;
import com.synergy.ecommerce.entities.Product;
import com.synergy.ecommerce.repositories.CartRepository;
import com.synergy.ecommerce.repositories.CategoryRepository;
import com.synergy.ecommerce.repositories.CustomerRepository;
import com.synergy.ecommerce.repositories.OrderRepository;
import com.synergy.ecommerce.repositories.ProductRepository;
import com.synergy.ecommerce.services.CustomerService;
import com.synergy.ecommerce.services.ProductService;

import exceptions.IncorrectCredentialsException;

@SpringBootTest(classes=ECommerceApplication.class)
public class CustomerServiceTest {
	@MockBean
	private ProductRepository productRepository;
	@MockBean
	private CategoryRepository categoryRepository;
	@MockBean
	private CartRepository cartRepository;
	@MockBean
	private OrderRepository orderRepository;
	@MockBean
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;

	@Test
	public void logIn() throws IncorrectCredentialsException {
		// setup (arguments, expected result, etc.)
		String username = "snicholes";
		String password = "pass";
		
		// mocking: we need to mock userDao.getByUsername(username)
		// we're expecting a user with matching username & password
		Customer mockCustomer = new Customer();
		mockCustomer.setUsername(username);
		mockCustomer.setPassword(password);
		when(customerRepository.findCustomerByUsername(mockCustomer.getUsername())).thenReturn(Optional.of(mockCustomer));
		
		// call the method we're testing
		Customer result = customerService.login(username, password);
		
		// assertion
		assertEquals(username, result.getUsername());
	}
		
	@Test
	public void addNewCustomer() {
		Customer newCustomer = new Customer();
		
		// mock userDao.create(newUser)
		Customer mockCustomer = new Customer();
		mockCustomer.setId(1L);
		when(customerRepository.save(newCustomer)).thenReturn(mockCustomer);
		
		Customer result = customerService.addNewCustomer(newCustomer);
		
		// the behavior that i'm looking for is that the
		// method returns the User with their newly generated ID,
		// so i want to make sure the ID was generated (not the default)
		assertNotEquals(0, result.getId());
	}
	
	@Test
	public void updateCustomer() {
		Customer newCustomer = new Customer();
		Customer mockCustomer = new Customer();
		// mock userDao.create(newUser)
		when(customerRepository.save(newCustomer)).thenReturn(newCustomer);
		Customer result = customerService.updateCustomer(mockCustomer.getId(),"","","","","",1L,"");
		
		assertNotEquals(0, result.getId()); 
	}
	
	@Test
	public void getCustomers() {
		// mock petDao.getByStatus("Available");
		when(customerRepository.findAll()).thenReturn(Collections.emptyList());
		
		List<Customer> customers = customerService.getCustomers();
		
		// i just want to make sure that the pets are returned -
		// i don't need to check that the pets are all available
		// because that filtering happens in the database. i just
		// need to check that the pets list isn't null
		assertNotNull(customers);
	}
	@Test
	public void getCustomerById() {

		Customer mockCustomer = new Customer();
		
		mockCustomer.setId(1L);
		mockCustomer.setFirstName("cucumber");
		mockCustomer.setLastName("man");
		mockCustomer.setEmail("vegetable@gmail.com");
		mockCustomer.setAddress("123 veggie");
		mockCustomer.setPassword("veggie");
		mockCustomer.setPhoneNumber(1L);
		mockCustomer.setUsername("veggieman");
		// call the method we are testing
		when(customerRepository.getById(1L)).thenReturn(mockCustomer);

		Customer customer = customerService.getCustomerById(mockCustomer.getId());
		// the assertion
		assertEquals(mockCustomer.getId(), mockCustomer.getId());
		System.out.println(mockCustomer.getId());
	}
	@Test
	public void deleteProduct() {
		
	}
}
