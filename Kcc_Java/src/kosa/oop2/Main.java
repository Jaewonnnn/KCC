package kosa.oop2;

public class Main {

	public static void main(String[] args) {
//		Dao dao = new OracleDao();
//		Dao dao = new MySQLDao();

		MyService service = new MyService(new Dao() {

			@Override
			public void insert() {
				System.out.println("zz");
			}
		});

		service.insertService();
	}

}