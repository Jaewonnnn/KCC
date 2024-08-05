package kosa.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
		// 주문서
//		Resource resource = new ClassPathResource("applicationContext.xml");
		// 주방(스프링 컨테이너)
//		BeanFactory factory = new GenericXmlApplicationContext(resource);

		// 스프링 컨테이너 생성
//		ApplicationContext factory = new AnnotationConfigApplicationContext(Factory.class);

		String configuration[] = {
			"applicationContext.xml",
			"commonConcern.xml"
		};
		
//		설정 파일을 모두 스프링 컨테이너에 등록
		ApplicationContext factory = new ClassPathXmlApplicationContext(configuration);
		
//		Service service = (Service) factory.getBean("writeService");
//		service.insertService();
		
		Kosa kosa = (Kosa)factory.getBean("kosaService");
		kosa.insertService();
//		kosa.list();
	}
}