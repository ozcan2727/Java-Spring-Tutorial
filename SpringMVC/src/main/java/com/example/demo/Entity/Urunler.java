package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Urunler {
	
private int id;
private String ad;
private String marka;
private String uretim_yeri;
private Float fiyat;


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)//otomatik  artış için
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAd() {
	return ad;
}
public void setAd(String ad) {
	this.ad = ad;
}
public String getMarka() {
	return marka;
}
public void setMarka(String marka) {
	this.marka = marka;
}

public String getUretim_yeri() {
	return uretim_yeri;
}
public void setUretim_yeri(String uretim_yeri) {
	this.uretim_yeri = uretim_yeri;
}
public Float getFiyat() {
	return fiyat;
}
public void setFiyat(Float fiyat) {
	this.fiyat = fiyat;
}

}




