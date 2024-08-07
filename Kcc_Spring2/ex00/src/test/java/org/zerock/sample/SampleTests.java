package org.zerock.sample;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {

	// Restaurant 객체 안에 Chef가 있는지 검사해야 하기 때문에 Restaurant 객체를 가져온다.
	@Autowired
	private Restaurant restaurant;

	@Test
	public void test() {
		assertNotNull(restaurant);
		log.info(restaurant);
		log.info(restaurant.getChef());

	}
}