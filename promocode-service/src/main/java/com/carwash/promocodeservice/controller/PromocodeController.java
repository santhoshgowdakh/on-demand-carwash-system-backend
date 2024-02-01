package com.carwash.promocodeservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.promocodeservice.entity.Promocode;
import com.carwash.promocodeservice.entity.ResponseMessage;
import com.carwash.promocodeservice.service.PromocodeService;
import com.carwash.promocodeservice.service.PromocodeServiceImpl;


@CrossOrigin(origins= "*" ,maxAge = 3600)
@RestController
@RequestMapping("/promocode")
public class PromocodeController {

	@Autowired
	PromocodeService promocodeService;
	
	@PostMapping
	public void addPromocode(@RequestBody Promocode promocode){
		promocodeService.addPromocode(promocode);
//		return new ResponseEntity<String>("Promocode added ID: "+promocodeId,HttpStatus.OK);
	}
	
	@PutMapping
	public void updatePromocode(@RequestBody Promocode promocode){
		promocodeService.updatePromocode(promocode);
//		return new ResponseEntity<String>("Promocode updated",HttpStatus.OK);
	}
	
	@GetMapping("/{promocode}")
	public ResponseEntity<Promocode> getByPromocode(@PathVariable String promocode){
		Promocode promocodeDetails=promocodeService.getByPromocode(promocode);
		return new ResponseEntity<Promocode>(promocodeDetails,HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Promocode>> getAllPromocodes(){
		List<Promocode> promocode=promocodeService.getAllPromocodes();
		return new ResponseEntity<List<Promocode>>(promocode,HttpStatus.OK);
	}
	@CrossOrigin(origins= "*" ,maxAge = 3600)
	@DeleteMapping("/{promocode}")
	public ResponseEntity<ResponseMessage> deletePromocode(@PathVariable String promocode){
		promocodeService.deletePromocode(promocode);
		ResponseMessage message=new ResponseMessage();
		message.setMessage("Promocode deleted");
		return new ResponseEntity<ResponseMessage>(message,HttpStatus.OK);
	}
	@GetMapping("/exists/{promocodeId}")
	public ResponseEntity<Boolean> existsById(@PathVariable String promocode){
		boolean exists=promocodeService.existsById(promocode);
		return new ResponseEntity<Boolean>(exists,HttpStatus.OK);
	}
}
