package springcrud;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import springcrud.dao.ProductDao;
import springcrud.model.Product;

@Controller
public class MainController {
@Autowired
	ProductDao pd;
	@RequestMapping("/home")
	public String home(Model m)
	{
		List<Product> products=pd.getProducts();
		m.addAttribute("product",products);
		return "index";
	}
	
	//show add product form
	@RequestMapping("/add")
	public String addProduct() {
		
		return "add_product1";
	}
	//handle add product form
	@RequestMapping(path="/process_product",method =RequestMethod.POST )
	public String handleproduct(@ModelAttribute Product product) {
		System.out.println(product);
	
		pd.createProduct(product);
		return "redirect:/home";
		}
	//handler for delete
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id")int pid) {
		
		this.pd.deleteProduct(pid);
		
		return "redirect:/home";
		
		
		
	}
	
	//update product
	
	@RequestMapping("/update/{id}")
	public String updateProduct(@PathVariable("id")int pid,Model m){
		
		Product product=this.pd.getProduct(pid);
		m.addAttribute("pro",product);
		return "update_form";
		
		
	}
}
