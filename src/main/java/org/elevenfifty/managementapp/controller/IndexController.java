package org.elevenfifty.managementapp.controller;

import javax.validation.Valid;

import org.elevenfifty.managementapp.beans.Products;
import org.elevenfifty.managementapp.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private ProductRepository productRepo;

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

	@GetMapping("/order")
	public String order(Model model) {
		return "order";
	}

	@GetMapping("/employee")
	public String employee(Model model) {
		return "employee";
	}

	@GetMapping("/customer")
	public String customer(Model model) {
		return "customer";
	}

}
