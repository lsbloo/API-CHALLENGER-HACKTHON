package com.softapi.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softapi.dto.ProductDTO;
import com.softapi.service.ShopService;

@RestController
@RequestMapping("/soft/api/")
public class ClientEndPoint {
	
	
	private final ShopService shopService;
	
	@Autowired
	public ClientEndPoint(ShopService shopService) {
		this.shopService=shopService;
	}
	
	@PostMapping(value="products",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> getProductsByCategorys(@RequestParam String tags){
		
		ProductDTO dto = this.shopService.getShopping(tags);
		if(dto != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
	}
	

}
