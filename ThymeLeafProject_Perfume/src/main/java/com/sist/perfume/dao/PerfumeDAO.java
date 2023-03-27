package com.sist.perfume.dao;
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
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.perfume.entity.*;
@Repository
public interface PerfumeDAO extends JpaRepository<PerfumeEntity,Integer>{
	@Query(value="SELECT no,bno,name,poster,price,brand,info1,info2,info3,hit FROM perfume",nativeQuery = true)
	public List<PerfumeEntity> perfumeListData();
	
	/*
	 * 	@Select("SELECT ino,name,price,poster,rownum "
				  +"FROM (SELECT ino,name,price,poster "
				  +"FROM sul_item_2_2 ORDER BY hit DESC) "
				  +"WHERE rownum<=5")
	 */
	
	@Query(value="SELECT no,bno,name,poster,price,brand,info1,info2,info3,hit FROM perfume ORDER BY hit LIMIT 0,8",nativeQuery = true)
	public List<PerfumeEntity> perfumeTop8ListData();
	
	public PerfumeEntity findByNo(int no);
	
	
	@Query(value="SELECT * FROM perfume "
			+ "WHERE name LIKE CONCAT('%',:name,'%') ORDER BY no LIMIT :start,20",nativeQuery = true)
	public List<PerfumeEntity> perfumeFindData(@Param("name") String name,@Param("start") Integer start);
	
	@Query(value="SELECT CEIL(COUNT(*)/20.0) FROM perfume "
			+ "WHERE name LIKE CONCAT('%',:name,'%')",nativeQuery = true)
	public int perfumeFindTotalPage(@Param("name") String name);
	
	public PerfumeEntity findByNo(@Param("no") Integer no);
	
}
