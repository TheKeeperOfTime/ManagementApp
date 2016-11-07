package org.elevenfifty.managementapp.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.elevenfifty.managementapp.beans.Customer;
import org.elevenfifty.managementapp.beans.Products;
import org.elevenfifty.managementapp.beans.Transaction;
import org.elevenfifty.managementapp.repository.CustomerRepository;
import org.elevenfifty.managementapp.repository.ProductRepository;
import org.elevenfifty.managementapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private TransactionRepository transactionRepo;

	@GetMapping(path = { "/home", " ", "/" })
	public String home(Model model) {
		return "home";
	}

	@GetMapping("/product")
	public String product(Model model) {
		model.addAttribute("products", productRepo.findAll());
		return "product";
	}

	@GetMapping("/product/{id}")
	public String product(Model model, @PathVariable(name = "id") Integer id) {
		model.addAttribute("id", id);

		Products u = productRepo.findOne(id);

		model.addAttribute("products", u);
		return "product_detail";
	}

	@GetMapping("/product/{id}/edit")
	public String productEdit(Model model, @PathVariable(name = "id") Integer id) {
		model.addAttribute("id", id);

		Products u = productRepo.findOne(id);

		model.addAttribute("products", u);
		return "product_edit";
	}

	@PostMapping("/product/{id}/edit")
	public String productEditSave(@PathVariable(name = "id") Integer id, @ModelAttribute @Valid Products product,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("Products", product);
			return "product_edit";
		}

		productRepo.save(product);
		return "redirect:/product/" + product.getId();
	}

	@GetMapping("/product/create")
	public String productCreate(Model model) {
		model.addAttribute(new Products());
		return "product_create";
	}

	@PostMapping("/product/create")
	public String productCreate(@ModelAttribute @Valid Products product, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("product", product);
			return "product";
		} else {
			productRepo.save(product);
			return "redirect:/product";
		}

	}

	@GetMapping("/product/{id}/delete")
	public String productDelete(Model model, @PathVariable(name = "id") Integer id) {
		model.addAttribute("id", id);
		Products u = productRepo.findOne(id);
		model.addAttribute("products", u);
		return "product_delete";
	}

	@PostMapping("/product/{id}/delete")
	public String productDeleteSave(@PathVariable(name = "id") Integer id, @ModelAttribute @Valid Products product,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("products", product);
			return "products/product";
		} else {
			productRepo.delete(id);
			return "redirect:/product";
		}
	}

	@GetMapping("/customer")
	public String getCustomers(Model model) {
		model.addAttribute("customers", customerRepo.findAll());
		return "customers";
	}

	@GetMapping("/customer/{id}")
	public String customer(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Customer c = customerRepo.findOne(id);
		model.addAttribute("customer", c);
		return "customer_detail";
	}

	@GetMapping("/customer/{id}/edit")
	public String customerEdit(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Customer c = customerRepo.findOne(id);
		model.addAttribute("customer", c);
		return "customer_edit";
	}

	@PostMapping("/customer/{id}/edit")
	public String customerEditSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid Customer customer,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("customer", customer);
			return "customer_edit";
		} else {
			customerRepo.save(customer);
			return "redirect:/customer/" + customer.getId();
		}
	}

	@GetMapping("/customer/{id}/delete")
	public String customerDelete(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Customer c = customerRepo.findOne(id);
		model.addAttribute("customer", c);
		return "customer_delete";
	}

	@PostMapping("/customer/{id}/delete")
	public String customerDeleteSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid Customer customer,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("customer", customer);
			return "customers";
		} else {
			customerRepo.delete(customer);
			return "redirect:/customer";
		}
	}

	@GetMapping("/customer/create")
	public String customerCreate(Model model) {
		model.addAttribute(new Customer());
		return "customer_create";
	}

	@PostMapping("/customer/create")
	public String customerCreate(@ModelAttribute @Valid Customer customer, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("customer", customer);
			return "customer_create";
		} else {
			customerRepo.save(customer);
			return "redirect:/customer";
		}

	}

	@GetMapping("/transaction")
	public String findAllTransactions(Model model) throws SQLException {
		model.addAttribute("transactions", transactionRepo.findAll());
		return "transaction";
	}

	@GetMapping("/transaction/{id}")
	public String transactionDetail(Model model, @PathVariable(name = "id") Long id) {
		model.addAttribute("id", id);
		Transaction t = transactionRepo.findOne(id);
		model.addAttribute("transaction", t);
		model.addAttribute("customers", customerRepo.findAll());
		model.addAttribute("product", productRepo.findAll());
		return "transaction_detail";
	}
	
	@GetMapping("/transaction/{id}/edit")
	public String transactionEdit(Model model, @PathVariable(name = "id") Long id) {
		model.addAttribute("id", id);
		Transaction t = transactionRepo.findOne(id);
		model.addAttribute("transaction", t);
		model.addAttribute("customers", customerRepo.findAll());
		model.addAttribute("product", productRepo.findAll());
		return "transaction_edit";
	}
	
	

	@GetMapping("/employee")
	public String employee(Model model) {
		return "employee";
	}

}
