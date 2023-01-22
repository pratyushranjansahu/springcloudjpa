package com.pratyushapps.productdata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

}
