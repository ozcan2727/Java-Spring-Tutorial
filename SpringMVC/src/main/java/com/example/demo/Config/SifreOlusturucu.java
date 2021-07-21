package com.example.demo.Config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SifreOlusturucu {
 
	
 public static void main(String[] arg){
	 BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	 String password="456789";
	 String encoderP=encoder.encode(password);
	 
	 System.out.println(encoderP);
	 
 }
	
	
}
