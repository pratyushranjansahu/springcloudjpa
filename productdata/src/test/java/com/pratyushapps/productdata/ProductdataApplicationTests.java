package com.pratyushapps.productdata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.pratyushapps.productdata.entity.Product;
import com.pratyushapps.productdata.repos.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductdataApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("Iphone");
		product.setDesc("Awesome");
		product.setPrice(1000d);

		productRepository.save(product);
	}

	@Test
	public void testRead() {
		Product product = productRepository.findById(1).get();
		assertNotNull(product);
		assertEquals("Iphone", product.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + product.getDesc());
	}

	@Test
	public void testDelete() {
		if (productRepository.existsById(1)) {
			System.out.println("Deleting a product");
			productRepository.deleteById(1);
		}
	}

	@Test
	public void testCount() {
		System.out.println("Total Records===============>>>>>>>>>>>>>>>" + productRepository.count());

	}

	@Test
	public void testFindByName() {
		List<Product> products = productRepository.findByName("I Watch");
		products.forEach(p -> System.out.println(p.getPrice()));

		List<Product> products1 = productRepository.findByName("I Watch");
		products1.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByNameAndDesc() {
		List<Product> products = productRepository.findByNameAndDesc("TV", "From Samsung Inc");
		products.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> products = productRepository.findByPriceGreaterThan(1000d);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByDescContains() {
		List<Product> products = productRepository.findByDescContains("Apple");
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByPriceBetween() {
		List<Product> products = productRepository.findByPriceBetween(500d, 2500d);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByDescLike() {
		List<Product> products = productRepository.findByDescLike("%LG%");
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByIdsIn() {
		Pageable pageable = PageRequest.of(1, 2);
		List<Product> products = productRepository.findByIdIn(Arrays.asList(1, 2, 3,4),pageable);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllPaging() {
		Pageable pageable = PageRequest.of(0, 2);
		Iterable<Product> results = productRepository.findAll(pageable);
		results.forEach(p -> System.out.println(p.getName()));

	}

	@Test
	public void testFindAllSorting() {		

		productRepository.findAll(Sort.by(new Sort.Order(Direction.DESC, "name"), new Sort.Order(null, "price")))
				.forEach(p -> System.out.println(p.getName()));
		

		//productRepository.findAll(Sort.by("name", "price")).forEach(p ->
		// System.out.println(p.getName()));

	}
	
	@Test
	public void testFindAllPagingAndSorting() {
		Pageable pageable = PageRequest.of(0, 2, Direction.DESC, "name");
		productRepository.findAll(pageable).forEach(p -> System.out.println(p.getName()));

	}


}
