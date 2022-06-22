package mv20220622;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.MyProduct;
import model.ProductDAO;

@Path("/")
public class ProductService {
	
	@POST
	@Path("/addProduct")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String   addProduct(MyProduct p) {	
		System.out.println(p);
		boolean b=ProductDAO.insertMyProduct(p);
		if(b)
		  return "<h2>ok</h2>";
		else
			return "<h2>Failed</h2>";
	}
	
	@POST
	@Path("/searchProduct")	
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String searchProduct(@FormParam("sname") String sname) {
		String temp=ProductDAO.searchProduct(sname);
        return "<h1>"+temp+"</h1>";
    }
}
