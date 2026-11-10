package com.Vcube.ExpanceTrackerAPI.module.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Vcube.ExpanceTrackerAPI.Repo.ExpanceRepo;
import com.Vcube.ExpanceTrackerAPI.module.Expance;

@RestController
@RequestMapping("/Expances")

public class ExpanceController {
	@Autowired
	ExpanceRepo er;

	@GetMapping("/FindAll")
	List<Expance> getAllExpances() {
		return er.findAll();

	}

	@PostMapping("/create")
	Expance CreateExpance(@RequestBody Expance e) {
		return er.save(e);
	}

	@GetMapping("/getExpance/{id}")
	Expance getExpanceById(@PathVariable Integer id) {
		return er.findById(id).get();
	}

	@DeleteMapping("/deleteExpance/{id}")
	String deleteExpanceById(@PathVariable Integer id) {
		er.deleteById(id);
		return "deleted id";
	}

	@PutMapping("/update/{id}")
	Expance Updatebyid(@RequestBody Expance e, @PathVariable Integer id) {
		Expance Efdb = er.findById(id).get();

		Efdb.setTitle(e.getTitle());

		Efdb.setDescription(e.getDescription());

		Efdb.setAmount(e.getAmount());

		Efdb.setCategory(e.getCategory());

		Efdb.setPaymentMode(e.getPaymentMode());
		Efdb.setExpenseDate(e.getExpenseDate());

		Efdb.setMerchantName(e.getMerchantName());

		Efdb.setCity(e.getCity());

		Efdb.setCreatedAt(e.getCreatedAt());

		return er.save(e);
	}
}
