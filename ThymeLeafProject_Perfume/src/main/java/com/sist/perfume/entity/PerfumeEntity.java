package com.sist.perfume.entity;
/*
 * no
int AI PK
name
varchar(1000)
poster
varchar(1000)
price
varchar(1000)
brand
varchar(1000)
info1
varchar(1000)
info2
varchar(1000)
info3
varchar(1000)
hit
int
bno
int
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="Perfume")
public class PerfumeEntity {
	
	@Id
	private int no;
	
	private String name;
	
	private String poster;
	
	private String price;
	
	private String info1;
	
	private String info2;
	
	private String info3;
	
	private String brand;
	
	private int bno;
	
	private int hit;
	
}
