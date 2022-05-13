package net.revature.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import net.revature.servicetest.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.synergy.ecommerce.ECommerceApplication;
import com.synergy.ecommerce.entities.Category;
import com.synergy.ecommerce.repositories.CategoryRepository;
import com.synergy.ecommerce.services.CategoryService;
@SpringBootTest(classes=ECommerceApplication.class)
public class CategoryServiceTest {
	@MockBean // says that we want Mockito to create a mock version of this object
	private CategoryRepository categoryRepo;
	@Autowired
	private CategoryService categoryServ;
		
		// test methods always have no parameters and return void
		@Test
		public void exampleTest() {
			assertTrue(true);
			}
		
		@Test
		public void getCategoryById() {
			Category mockCategory = new Category();
			mockCategory.setName("Phone");
			mockCategory.setId(1L);
			mockCategory.setDescription("Hardware");
			when(categoryRepo.getById(1L)).thenReturn(mockCategory);
			Category category = categoryServ.getCategoryById(mockCategory.getId());
			assertEquals(mockCategory.getId(), category.getId());
			System.out.println(category.getId());
		}
		
		@Test
		public void getCategoryByName() {
			Category mockCategory = new Category();
			mockCategory.setName("Phone");
			mockCategory.setId(1L);
			mockCategory.setDescription("Hardware");
			when(categoryRepo.findCategoryByName("Phone")).thenReturn(mockCategory);
			Category category = categoryServ.getCategoryByName("Phone");
			assertEquals(mockCategory.getName(), category.getName());
			System.out.println(category.getName());
		}
		
		@Test
		public void getCategoryByDesc() {
			Category mockCategory = new Category();
			mockCategory.setName("Phone");
			mockCategory.setId(1L);
			mockCategory.setDescription("Hardware");
			when(categoryRepo.findCategoryByDesc("Hardware")).thenReturn(mockCategory);
			Category category = categoryServ.getCategoryByDesc("Hardware");
			assertEquals(mockCategory.getDescription(), category.getDescription());
			System.out.println(category.getDescription());
		}
		
//		@Test
//		public void getCategoryByName() {
//			Category mockCategory = new Category();
//			mockCategory.setName("Phone");
//			mockCategory.setId(1L);
//			mockCategory.setDescription("Hardware");
//			when(categoryRepo.findCategoryByName(mockCategory)).thenReturn(mockCategory);
//			Category category = categoryServ.getCategoryByName(mockCategory.getName());
//			assertEquals(mockCategory.getName(), category.getName());
//			System.out.println(category.getName());
//		}
//		
//		@Test
//		public void getCategoryByDesc() {
//			Category mockCategory = new Category();
//			mockCategory.setName("Phone");
//			mockCategory.setId(1L);
//			mockCategory.setDescription("Hardware");
//			when(categoryRepo.findCategoryByDesc(mockCategory)).thenReturn(mockCategory);
//			Category category = categoryServ.getCategoryByDesc(mockCategory.getDescription());
//			assertEquals(mockCategory.getDescription(), category.getDescription());
//			System.out.println(category.getDescription());
//		}
}
