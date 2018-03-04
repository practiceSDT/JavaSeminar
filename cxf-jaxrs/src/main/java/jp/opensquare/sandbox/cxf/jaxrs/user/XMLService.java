package jp.opensquare.sandbox.cxf.jaxrs.user;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/user")
public interface XMLService {

	@GET
	@Path("/get")
	@Produces("application/xml")
	public User getUserInXML();

}