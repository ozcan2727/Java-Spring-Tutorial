package com.example.demo.dataAccess;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.Entity.Urunler;

public interface UrunlerDal extends PagingAndSortingRepository<Urunler,Integer> {
	
	@Query("SELECT u FROM Urunler u WHERE "
			+ "CONCAT(u.id, u.ad, u.marka, u.uretim_yeri, u.fiyat)"
			+ "LIKE %?1%")
	   public Page<Urunler> findAll(Pageable pageable,String key);
	
	
	
}
