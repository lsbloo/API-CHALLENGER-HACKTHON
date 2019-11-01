package com.softapi.entrypoint;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.softapi.dto.ConsumerCreate;
import com.softapi.dto.KeeperCreate;
import com.softapi.dto.ShopCreat;
import com.softapi.models.Consumer;
import com.softapi.models.Endereco;
import com.softapi.models.Shopkeeper;
import com.softapi.models.User;
import com.softapi.service.ShopService;
import com.softapi.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/creat/")
public class CredentialsEntryPoint {
	
	private final UserService userService;
	
	
	@Autowired
	public CredentialsEntryPoint(UserService userService) {
		this.userService=userService;
		
	}
	
	@PostMapping(value="consumer", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConsumerCreate> createConsumer(@RequestParam String email,
			@RequestParam String password,
			@RequestParam String rua,
			@RequestParam String bairro,
			@RequestParam String cidade,
			@RequestParam String cep){
		
		User user = new User(email,password,true);
		Endereco end = new Endereco(rua,bairro,cidade,cep);
		Consumer consumer = new Consumer(email,end);
		consumer.setUser(user);
		boolean result = this.userService.createConsumer(consumer);
		if (result) {
			ConsumerCreate consumerC = new ConsumerCreate();
			consumerC.setDescription("Cliente final criado com sucesso!");
			consumerC.setStatus(true);
			consumerC.setConsumer(consumer);
			
			return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(consumerC);
		}else {
			ConsumerCreate consumerC = new ConsumerCreate();
			consumerC.setDescription("Cliente final não criado com sucesso!");
			consumerC.setStatus(false);
			consumerC.setConsumer(null);
			return ResponseEntity.status(HttpServletResponse.SC_BAD_REQUEST).body(consumerC);
		}
		
	}
	
	@PostMapping(value = "shop", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KeeperCreate> createShopKeeper(@RequestParam String email,
			@RequestParam String password){
		
		Shopkeeper shop = new Shopkeeper();
		User user = new User(email,password,true);
		shop.setUser(user);
		
		boolean result = this.userService.createShopKeeper(shop);
		if (result) {
			KeeperCreate created = new KeeperCreate();
			created.setDescription("lojista criado com sucesso");
			created.setStatus(true);
			created.user=user;
			return ResponseEntity
					.status(HttpServletResponse.SC_CREATED).body(created);
		}else {
			KeeperCreate created = new KeeperCreate();
			created.setDescription("lojista não foi criado com sucesso");
			created.setStatus(false);
			created.user=null;
			return ResponseEntity
					.status(HttpServletResponse.SC_BAD_REQUEST).body(created);
		}
		
	}
	
	

}
