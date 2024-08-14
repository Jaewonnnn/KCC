package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//스프링 컨테이너 생성
@Log4j
public class SampleServiceTests {

	@Autowired
	private SampleService service;
	
	@Test
	public void test() {
		try {
			log.info(service);
			log.info(service.doAdd("10", "20"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}