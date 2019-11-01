package com.softapi.entrypoint;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softapi.dto.ShopCreat;
import com.softapi.handler.SessionUser;
import com.softapi.models.Endereco;
import com.softapi.models.Product;
import com.softapi.models.Shop;
import com.softapi.service.ShopService;

/**
 * EntryPoint INSERTS MOCKER'S.
 * @author osvaldoairon
 *
 */
@RestController
@RequestMapping("/soft/api/")
public class ClientEntryPoint {
	
	private final ShopService shopService;
	
	@Autowired
	public ClientEntryPoint(ShopService shopService) {
		this.shopService=shopService;
	}
	
	
	
	// POST MOCKERUP
	@PostMapping(value = "keeper", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShopCreat> createShop(HttpServletRequest request,
			@RequestParam String nome_fantasia, 
			@RequestParam String cnpj,
			@RequestParam String telefone,
			@RequestParam String rua,
			@RequestParam String bairro,
			@RequestParam String cidade,
			@RequestParam String cep,
			@RequestBody List<Product> products) {
		
	//	System.err.println(SessionUser.getSessionUser().getUsername());
		
		Endereco end = new Endereco(rua,bairro,cidade,cep);
		
		Shop shop = new Shop(nome_fantasia,cnpj,telefone,end,products);
		
		Shop q =  this.shopService.save(shop);
		
		if(q!=null) {
			ShopCreat result = new ShopCreat(true,"created sucessul");
			return ResponseEntity
					.status(HttpServletResponse.SC_CREATED).body(result);
		}
		else {
			ShopCreat result = new ShopCreat(false,"don't created");
			return ResponseEntity
					.status(HttpServletResponse.SC_BAD_REQUEST).body(result);
		}

	}
	
	
	

}
