package com.embuh.webapptokobuku.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import com.embuh.webapptokobuku.entity.data_buku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.embuh.webapptokobuku.repo.BukuRepo;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author user
 */
@Controller
public class AppController {
    
    @Autowired
    private BukuRepo bkRepo;
    
    @RequestMapping("/home")
    public void index() {}
    
    @RequestMapping("/data_buku")
    public void getDataBuku(Model model) {
        model.addAttribute("dataBuku",bkRepo.findAll());
    }

    @RequestMapping(value = "/tambah-data" , method = RequestMethod.GET)
    public void getFormTambahData(
    	@ModelAttribute("bk") data_buku bk, 
    	BindingResult result ) {}

    @RequestMapping(value = "/tambah-data" , method = RequestMethod.POST)
    public String simpanData(
    	@ModelAttribute("bk") data_buku bk, BindingResult result) {

    	System.out.println("id : " + bk.getId());
    	System.out.println("judul_buku : " + bk.getJudul_buku());
    	System.out.println("harga : " + bk.getHarga());
    	bkRepo.save(bk);
    	return "redirect:data_buku";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public void getEditData(@RequestParam(name = "id", required =
    false) String id,
        @ModelAttribute("bk") data_buku buku, BindingResult
        binding) {
        data_buku bk = bkRepo.findOne(id);
        buku.setId(bk.getId());
        buku.setJudul_buku(bk.getJudul_buku());
        buku.setHarga(bk.getHarga());
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditData(
        @ModelAttribute("bk") data_buku bk,
        BindingResult binding) {
        bkRepo.save(bk);
        return "redirect:/data_buku";
    }
    
    @RequestMapping("/delete")
    public String deleteData(
        @RequestParam(name = "id", required = true) String id) {
        bkRepo.delete(id);
        return "redirect:/data_buku";
    }
    
}