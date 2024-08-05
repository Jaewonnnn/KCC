package kosa.dao;

import kosa.model.Membership;

public class MembershipDao {
	private static MembershipDao dao = new MembershipDao();
	
	public static MembershipDao getInstance() {
		return dao;
	}
	

	
	public void insert(Membership membership) {
		System.out.println(membership);
		
		
//		return membership;
	}
}
