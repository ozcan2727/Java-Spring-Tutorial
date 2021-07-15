package com.example.demo.Maneger;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dataAccess.UrunlerDal;
import com.example.demo.Entity.Urunler; 
@Service
public class UrunlerService {
	
@Autowired
private UrunlerDal urunlerDal;


public Page<Urunler> listAll(String key,int SayfaNo,String sortA,String sortD){
	Sort sort=Sort.by(sortA);
	sort=sortD.equals("asc") ? sort.ascending() : sort.descending();
	Pageable pageable=PageRequest.of(SayfaNo - 1,5,sort);
	if(key!=null) {
		return this.urunlerDal.findAll(pageable,key);
	}
	
	return this.urunlerDal.findAll(pageable);
}



public void save(Urunler urun ) {

	 this.urunlerDal.save(urun);
}

public Urunler getAll(int id){
	return this.urunlerDal.findById(id).get();
}

public  void Delete(int id) {
	this.urunlerDal.deleteById(id);
}




	
}
