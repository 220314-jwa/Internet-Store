package net.revature.controllertest;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synergy.ecommerce.ECommerceApplication;
import com.synergy.ecommerce.controllers.ProductController;
import com.synergy.ecommerce.entities.Product;
import com.synergy.ecommerce.services.ProductService;


@SpringBootTest(classes=ECommerceApplication.class)
public class ProductControllerTest {
	@MockBean
	private ProductService productService;
	@Autowired
	private ProductController productController;
	@Autowired
	private WebApplicationContext context;
	
	// to have more thorough testing, i'm going to have
	// a Jackson objectmapper to map objects to JSON
	private ObjectMapper jsonMapper = new ObjectMapper();
	
	// sets up a mock of the spring mvc infrastructure
	// and allows us to mock http requests
	private MockMvc mockMvc;
	
	//getter and setter for product controller
	public ProductController getProductController() {
		return productController;
	}

	public void setProductController(ProductController productController) {
		this.productController = productController;
	}

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void getProductSuccessfully() throws JsonProcessingException, Exception {
		List<Product> mockProductsList = Collections.emptyList();
		when(productService.getProducts()).thenReturn(mockProductsList);
		
		// perform sets up the HTTP request
		// and the expect methods expect things from the HTTP response
		mockMvc.perform(get("/products"))
			.andExpect(status().isOk())
			.andExpect(content().json(jsonMapper.writeValueAsString(mockProductsList)));
		// this sends a mock GET request to /pets
		// and expects a 200 (OK) status code and the body to be
		// the JSON of the mockPetsList
	}
}
