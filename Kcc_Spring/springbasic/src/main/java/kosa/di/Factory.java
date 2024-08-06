package kosa.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// ApplicationContext.xml�� ����ϴ� �뵵�� ����Ѵ�.
// @Configuration // ���� ���� ���
public class Factory {
	@Bean
	public Dao oracleDao() {
		return new OracleDao();
	} // ������ �����̳ʿ��� id="oracleDao"��� �̸����� ����.
	
	@Bean
	public Service writeService2() {
		return new WriteService();
	} // ������ �����̳ʿ��� id="writeService2"��� �̸����� ����
}
