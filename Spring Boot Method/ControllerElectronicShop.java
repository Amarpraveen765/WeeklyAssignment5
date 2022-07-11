package com.codingassignment5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerElectronicShop {

	@Autowired
	private ElectronicShopRepository electronic;

	// get all Products
	@GetMapping("/getelectronic")
	public List<ElecShop> getAllElectronicShop() {
		return electronic.findAll();
	}

	// create Product
	@PostMapping("/addelectronic")
    public ElecShop createproducts(@RequestBody ElecShop products) {
        return electronic.save(products);
    }

    // delete customer 
    @DeleteMapping("/deleteelectronic/{id}")
    public void deleteproducts(@PathVariable("id") int id) {
    	electronic.deleteById(id);

    }
}