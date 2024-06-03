package kosa.oop2;

public class MyService {
	private Dao dao;
	
	public MyService() {}

	public MyService(Dao dao) {
		this.dao = dao;
	}
	
	public void insertService() {
		dao.insert();
	}

}
