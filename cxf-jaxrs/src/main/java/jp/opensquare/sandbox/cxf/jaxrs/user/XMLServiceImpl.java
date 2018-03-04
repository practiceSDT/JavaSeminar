package jp.opensquare.sandbox.cxf.jaxrs.user;

public class XMLServiceImpl implements XMLService {

	@Override
	public User getUserInXML() {

			User user = new User();
			user.setUsername("mkyong");
			user.setPassword("password");
			user.setPin(123456);
			
			return user; 
	}

}
