package com.sist.perfume.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.perfume.dao.*;
import com.sist.perfume.entity.*;
@RestController
@RequestMapping("perfume/")
@CrossOrigin("http://localhost:3000")
public class PerfumeRestController {
	
	@Autowired
	private PerfumeDAO dao;
	
	@GetMapping("perfume_list_react")
	public List<PerfumeEntity> perfume_list()
	{
		List<PerfumeEntity> list=dao.perfumeListData();
		return list;
	}
	
	@GetMapping("perfume_detail_react")
	public PerfumeEntity perfume_detail(int no)
	{
		PerfumeEntity vo=dao.findByNo(no);
		return vo;
	}
}
