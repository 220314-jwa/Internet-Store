
package net.revature.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.synergy.ecommerce.ECommerceApplication;
import com.synergy.ecommerce.entities.Category;
import com.synergy.ecommerce.entities.Product;
import com.synergy.ecommerce.repositories.CartRepository;
import com.synergy.ecommerce.repositories.CategoryRepository;
import com.synergy.ecommerce.repositories.CustomerRepository;
import com.synergy.ecommerce.repositories.OrderRepository;
import com.synergy.ecommerce.repositories.ProductRepository;
import com.synergy.ecommerce.services.ProductService;

@SpringBootTest(classes=ECommerceApplication.class)
public class ProductServiceTest {
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
	private ProductService productService;

	@Test
	public void exampleTest() {
		assertTrue(true);
	}
	@Test
	public void getProducts() {

		List<Product> products = new ArrayList<>();
		Product mockProduct1 = new Product();
		products.add(mockProduct1);
		Product mockProduct2 = new Product();
		products.add(mockProduct2);
	
		when(productRepository.findAll()).thenReturn(products);

		List<Product> productsService = productService.getProducts();

		assertEquals(productsService.size(),products.size());
		System.out.println(products.get(0));
	}

	@Test
	public void getProductById() {

		Product mockProduct = new Product();
		mockProduct.setId(1L);
		mockProduct.setName("cucumber");
		mockProduct.setPrice(1D);
		mockProduct.setCode("vegetable");
		mockProduct.setProdDate(new Date());
		// call the method we are testing
		when(productRepository.getById(1L)).thenReturn(mockProduct);

		Product product = productService.getProductById(mockProduct.getId());
		// the assertion
		assertEquals(mockProduct.getName(), product.getName());
		System.out.println(product.getName());

	}

	@Test
	public void getProductsByCategoryId() {

		List<Product> products = new ArrayList<>();
		Product mockProduct1 = new Product();
		products.add(mockProduct1);
		Product mockProduct2 = new Product();
		products.add(mockProduct2);
		Category category = new Category();
		category.setName("Phone");
		category.setId(1L);
		mockProduct1.setCategory(category);
		when(productRepository.findProductsByCategory(mockProduct1.getCategory().getId())).thenReturn(products);

		List<Product> productsService = productService.getProductsByCategoryId(mockProduct1.getCategory().getId());

		assertEquals(productsService.size(),products.size());
		System.out.println(category.getName());
	}

	@Test
	public void getProductByCode() {

		Product mockProduct = new Product();
		mockProduct.setId(1L);
		mockProduct.setName("cucumber");
		mockProduct.setPrice(1D);
		mockProduct.setCode("vegetable");
		mockProduct.setProdDate(new Date());
		when(productRepository.findProductByCode(mockProduct.getCode())).thenReturn(mockProduct);

		Product product = productService.getProductByCode(mockProduct.getCode());

		assertEquals(mockProduct.getCode(), product.getCode());
		System.out.println(product.getCode());
	}

	@Test
	public void getProductByPrice() {

		Product mockProduct = new Product();
		mockProduct.setId(1L);
		mockProduct.setName("cucumber");
		mockProduct.setPrice(1D);
		mockProduct.setCode("vegetable");
		mockProduct.setProdDate(new Date());
		when(productRepository.findProductByPrice(mockProduct.getPrice())).thenReturn(mockProduct);

		Product product = productService.getProductByPrice(mockProduct.getPrice());

		assertEquals(mockProduct.getPrice(), product.getPrice());
		System.out.println(product.getPrice());
	}
	@Test
	public void updateProduct() {
		Product product = new Product();
		Product mockProduct = new Product();
		mockProduct.setId(1L);
		mockProduct.setName("cucumber");
		mockProduct.setPrice(1D);
		mockProduct.setCode("vegetable");
		mockProduct.setProdDate(new Date());
		when(productRepository.save(mockProduct)).thenReturn(mockProduct);
		Product result = productService.updateProduct(1L,"cucumber",120.0,"vegetable",new Date(),new Category());
		
		assertEquals(mockProduct.getId(), product.getId());
		System.out.println(product.getId());
		}
	@Test
	public void addNewProduct() {
		Product newProduct = new Product();
		Product mockProduct = new Product();
		mockProduct.setId(1L);
		mockProduct.setName("cucumber");
		mockProduct.setPrice(1D);
		mockProduct.setCode("vegetable");
		mockProduct.setProdDate(new Date());
		when(productRepository.save(newProduct)).thenReturn(mockProduct);
		Product result = productService.addNewProduct(newProduct);
		
		assertNotEquals(0, result.getId());
		}
	@Test
	public void deleteProduct() {
		
	}
	

}



