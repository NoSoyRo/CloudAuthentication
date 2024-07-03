package com.rincon.taco_cloud.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rincon.taco_cloud.Models.LineOrder;
import com.rincon.taco_cloud.Models.LineOrderForm;
import com.rincon.taco_cloud.Models.Orders;
import com.rincon.taco_cloud.Models.Products;
import com.rincon.taco_cloud.Repositories.ProductsRepository;

import lombok.Data;

@Data
@Controller
@RequestMapping("/user/createOrder")
public class DesignOrderController {
	
	private LineOrder lineOrderC;
	private ArrayList<LineOrder> lineOrders = new ArrayList<LineOrder>();

	@Autowired
	private ProductsRepository prodRepo;
	
	@ModelAttribute(name = "orders")
	public Orders orders() {
		return new Orders();
	}
	
	@ModelAttribute(name = "lineOrderForm")
	public LineOrderForm lineOrderForm() {
		return new LineOrderForm();
	}
	
	@ModelAttribute(name = "lineOrderCurrent")
	public LineOrder lineOrderCurrent() {
		return new LineOrder();
	}
	
	@ModelAttribute(name = "products")
	public List<Products> products() {
		List<Products> products = prodRepo.findAll();
		return products;
	} 
	
	@GetMapping
	public String createOrder(Model model) {
		model.addAttribute("lineOrders", lineOrders);
	    return "createOrder";
	}
	
	@GetMapping("/addToOrder")
    public String addToOrder(@RequestParam("productId") Long productId, Model model) {
        Products product = prodRepo.getById(productId);
        if (product == null) {
            return "redirect:/user/createOrder"; // Handle product not found
        }
        model.addAttribute("product", product);
        LineOrder lineOrder = (LineOrder)model.getAttribute("lineOrderCurrent");
        lineOrder.setProduct(product);
        lineOrder.setOrder((Orders)model.getAttribute("orders"));
        lineOrderC = lineOrder;
//        model.addAttribute("lineOrderCurrent", lineOrder);
        return "lineOrder";
    }
	
	@PostMapping("/submitLineOrder")
	public String submitLineOrder(LineOrderForm lineOrderForm, Model model) {
		LineOrder lineOrder = lineOrderC;
		lineOrder.setQuantity(lineOrderForm.getQuantity());
		lineOrders.add(lineOrder);
//		System.out.println(lineOrder.getProduct().getProductName());
		return "redirect:/user/createOrder";
	}
	
	
}
