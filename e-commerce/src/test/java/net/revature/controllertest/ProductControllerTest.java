package net.revature.controllertest;


import static org.mockito.Mockito.when;
import net.revature.*;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synergy.ecommerce.ECommerceApplication;
import com.synergy.ecommerce.controllers.ProductController;
import com.synergy.ecommerce.entities.Product;
import com.synergy.ecommerce.repositories.ProductRepository;
import com.synergy.ecommerce.services.ProductService;


@SpringBootTest(classes=ECommerceApplication.class)
public class ProductControllerTest {
	@Autowired
	private ProductService productService;
	@AutoWired
	private ProductRepository productRepository;
	@Autowired
	private ProductController productController;
	@Autowired
	private WebApplicationContext context;
	
	private ObjectMapper jsonMapper = new ObjectMapper();
	

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void registerNewProducts() throws JsonProcessingException {
		Product product = new Product();
		Product mockProduct = new Product();
		
		mockProduct.setId(1L);
		mockProduct.setName("cucumber");
		mockProduct.setPrice(1D);
		mockProduct.setCode("vegetable");
		mockProduct.setProdDate(new Date());
		when(productRepository.save(product)).thenReturn(mockProduct);
		
	}
}
