package com.sist.perfume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.perfume.dao.PerfumeDAO;
import com.sist.perfume.entity.PerfumeEntity;

@Controller
public class MainController {
	@Autowired
	private PerfumeDAO dao;
	

	
	
	@GetMapping("/")
	public String main_page(Model model)
	{
		List<PerfumeEntity> list=dao.perfumeTop8ListData();
		model.addAttribute("list",list);
		model.addAttribute("main_html","main/home");
		return "main";
	}
}
