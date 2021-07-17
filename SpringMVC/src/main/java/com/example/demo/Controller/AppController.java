package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Entity.Urunler;
import com.example.demo.Maneger.UrunlerService;




@Controller
public class AppController {
	
@Autowired
	private UrunlerService urunlerService;

    
@RequestMapping("/")
public String AnaSayfaGoruntuleme(Model model,String key){
	
	
	return sayfaListe(model,1,"ad","asc",key);
}

@GetMapping("/page/{SayfaNo}")
public String sayfaListe(Model model,@PathVariable("SayfaNo")int gecerliSayfa,@Param("sortA") String sortA,@Param("sortD")String sortD,@Param("key")String key) {
	Page<Urunler> page=this.urunlerService.listAll(key,gecerliSayfa,sortA,sortD);
	long toplamOgeler=page.getTotalElements();
	int toplamPage=page.getTotalPages();
	List<Urunler> urunler=page.getContent();
	model.addAttribute("gecerliSayfa",gecerliSayfa);
	model.addAttribute("ToplamOgeler",toplamOgeler);
	model.addAttribute("toplamPage",toplamPage);
	model.addAttribute("urunler", urunler);
	model.addAttribute("sortA", sortA);
	model.addAttribute("sortD", sortD);
	model.addAttribute("key",key);
	
	String TersSortD=sortD.equals("asc") ? "desc" : "asc";
	model.addAttribute("TersSortD", TersSortD);
	

	return "index";
}

@RequestMapping("/yeni")
public String CreatenewGoruntuleme(Model model) {
	Urunler yeni_urun=new Urunler();
	model.addAttribute("yeni_urun", yeni_urun);
	
	return "Yeni_urun";
}

@RequestMapping(value = "/save",method=RequestMethod.POST) 
 public String  Kaydet_Urun(@ModelAttribute("yeni_urun")  Urunler urunler){
	 urunlerService.save(urunler);
	
	 return "redirect:/";
 }
@RequestMapping("/edit/{id}")
public ModelAndView DuzenlemeSayfaGoruntuleme(@PathVariable(name="id") int id) {
	ModelAndView mav =new ModelAndView("düzenle");
	
	Urunler urunler=urunlerService.getAll(id);
	mav.addObject("urunler",urunler);
	
	return mav;
}
@RequestMapping("/delete/{id}")
public String Sil(@PathVariable(name="id")int id) {
	urunlerService.Delete(id);
	return "redirect:/";
}
}

