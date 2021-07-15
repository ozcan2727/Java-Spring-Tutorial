package com.example.demo.Maneger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Config.KullaniciDetaylar;
import com.example.demo.Entity.kullanici;
import com.example.demo.dataAccess.kullaniciRepository;

public class KullaniciDetaylarService implements UserDetailsService{
   @Autowired
	private kullaniciRepository repo;
   
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		kullanici user=repo.getKullaniciByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("kullanıcı bulunamadı");
		}
		return new KullaniciDetaylar(user);
	}

}
