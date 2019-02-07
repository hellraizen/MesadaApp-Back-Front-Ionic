package com.dleite;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dleite.domain.Cash;
import com.dleite.domain.Kid;
import com.dleite.domain.OrderItem;
import com.dleite.domain.Payment;
import com.dleite.domain.Product;
import com.dleite.domain.RequestPay;
import com.dleite.domain.UserMaster;
import com.dleite.domain.enumaration.StatusPay;
import com.dleite.repositories.KidRepository;
import com.dleite.repositories.OrderItemRepository;
import com.dleite.repositories.PaymentRepository;
import com.dleite.repositories.ProductRepository;
import com.dleite.repositories.RequestPayRepository;
import com.dleite.repositories.UserMasterRepository;

@SpringBootApplication
public class AppNewApplication implements CommandLineRunner {
	
	@Autowired
	private UserMasterRepository userRepository;
	@Autowired
	private KidRepository kidRepository;
	@Autowired
	private RequestPayRepository requestPayRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AppNewApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		UserMaster user1 = new UserMaster(null,"Danilo");
		UserMaster user2 = new UserMaster(null,"Fernando1");
		UserMaster user3 = new UserMaster(null,"Fernando2");
		UserMaster user4 = new UserMaster(null,"Fernando3");
		UserMaster user5 = new UserMaster(null,"Fernando4");
		UserMaster user6 = new UserMaster(null,"Fernando5");
		UserMaster user7 = new UserMaster(null,"Fernando6");
		UserMaster user8 = new UserMaster(null,"Fernando7");
		UserMaster user9 = new UserMaster(null,"Fernando8");
		UserMaster user10 = new UserMaster(null,"Fernando9");
		UserMaster user11= new UserMaster(null,"Fernando10");
		UserMaster user12 = new UserMaster(null,"Fernando11");
		
		
		Kid kid1 = new Kid(null,"Fulano",12,0.0);
		Kid kid2 = new Kid(null,"Sicrano",13,0.0);
		Kid kid3 = new Kid(null,"Pof",12,0.0);
		
		user1.getKids().addAll(Arrays.asList(kid1,kid2));
		user2.getKids().addAll(Arrays.asList(kid3));
		
		kid1.setUserMaster(user1);
		kid2.setUserMaster(user1);
		kid3.setUserMaster(user2);
		
		userRepository.saveAll(Arrays.asList(user1,user2, user3,user4,user5,user6,user7,user8,user9,user10,user11,user12));
		kidRepository.saveAll(Arrays.asList(kid1,kid2,kid3));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		RequestPay rPay1 =  new RequestPay(null,sdf.parse("12/02/2018 12:00"),kid1);
		RequestPay rPay2 =  new RequestPay(null,sdf.parse("13/02/2018 12:00"),kid1);
		
		Payment pay1 = new Cash(null, StatusPay.QUITADO, rPay1, sdf.parse("12/02/2018 12:02"));
		rPay1.setPayment(pay1);
		Payment pay2 = new Cash(null, StatusPay.PENDENTE, rPay2, sdf.parse("13/02/2018 12:02"));
		rPay2.setPayment(pay2);
		
		kid1.getRequestPays().addAll(Arrays.asList(rPay1,rPay2));
		
		requestPayRepository.saveAll(Arrays.asList(rPay1,rPay2));
		paymentRepository.saveAll(Arrays.asList(pay1,pay2));
		
		Product pro1 = new Product(null, "Horas na TV", 10.00);
		Product pro2 = new Product(null, "Cel 10", 2.00);
		
		
		
		OrderItem it1 = new OrderItem(rPay2, pro1, 0.00, 2, 20.00);
		
		pro1.getItens().addAll(Arrays.asList(it1));
		
		productRepository.saveAll(Arrays.asList(pro1,pro2));
		orderItemRepository.saveAll(Arrays.asList(it1));
	}

}

