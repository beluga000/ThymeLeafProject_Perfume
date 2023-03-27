package com.sist.perfume.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.perfume.dao.*;
import com.sist.perfume.entity.*;
@Controller
@RequestMapping("perfume/")
public class PerfumeController {
	@Autowired
	private PerfumeDAO dao;
	
	@GetMapping("perfume_list")
	public String perfume_list(Model model)
	{
		List<PerfumeEntity> list=dao.perfumeListData();
		model.addAttribute("list",list);
		model.addAttribute("main_html","perfume/perfume_list");
		return "main";
	}
	
	   @GetMapping("perfume_detail")
	   public String perfume_detail(int no,Model model)
	   {
		   PerfumeEntity vo=dao.findByNo(no);
		   vo.setHit(vo.getHit()+1);
	    	dao.save(vo);//update
		   List<String> pList=new ArrayList<String>();
		   model.addAttribute("pList", pList);
		   model.addAttribute("vo", vo);
		   model.addAttribute("main_html", "perfume/perfume_detail");
		   return "main";
	   }
	
	   @RequestMapping("perfume_find")
	   public String perfume_find(String name,String page,Model model)
	   {
		   if(name==null)
			   name="바이레도";
		   if(page==null)
			   page="1";
		   int curpage=Integer.parseInt(page);
		   int rowSize=20;
		   int start=(curpage*rowSize)-rowSize;
		   List<PerfumeEntity> list=dao.perfumeFindData(name, start);
		   int totalpage=dao.perfumeFindTotalPage(name);
		   final int BLOCK=10;
		   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		   if(endPage>totalpage)
			   endPage=totalpage;
		   
		   model.addAttribute("curpage", curpage);
		   model.addAttribute("totalpage", totalpage);
		   model.addAttribute("startPage", startPage);
		   model.addAttribute("endPage", endPage);
		   model.addAttribute("list", list);
		   model.addAttribute("main_html", "perfume/perfume_find");
		   return "main";
	   }
}
