package springcrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import springcrud.model.Product;

@Component
public class ProductDao {
	@Autowired
		private HibernateTemplate hibernateTemplate;

	@Transactional
	public void createProduct(Product product) {
		
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	
	public List<Product> getProducts(){
		
		List<Product> products=this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	@Transactional
	public void deleteProduct(int id) {
		
		Product p =this.hibernateTemplate.load(Product.class,id);
		this.hibernateTemplate.delete(p);
	}
	
	public Product getProduct(int id) {
		
		return this.hibernateTemplate.get(Product.class,id);
	}
	
	@Transactional
	public void update(int id) {
		
		this.hibernateTemplate.update(id);
		
		
		
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}
