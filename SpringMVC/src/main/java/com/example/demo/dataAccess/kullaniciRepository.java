package com.example.demo.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.demo.Entity.kullanici;

public interface kullaniciRepository extends JpaRepository<kullanici, Long> {
 
	@Query("SELECT  u FROM kullanici u WHERE  u.username= :username")
	public kullanici getKullaniciByUsername(@Param("username") String username); 
		
	
}
