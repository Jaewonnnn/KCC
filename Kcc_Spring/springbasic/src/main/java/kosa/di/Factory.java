package kosa.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// ApplicationContext.xml을 대신하는 용도로 사용한다.
// @Configuration // 설정 파일 등록
public class Factory {
	@Bean
	public Dao oracleDao() {
		return new OracleDao();
	} // 스프링 컨테이너에서 id="oracleDao"라는 이름으로 사용됨.
	
	@Bean
	public Service writeService2() {
		return new WriteService();
	} // 스프링 컨테이너에서 id="writeService2"라는 이름으로 사용됨
}
