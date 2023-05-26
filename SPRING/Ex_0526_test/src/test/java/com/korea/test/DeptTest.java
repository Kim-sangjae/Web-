package com.korea.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import context.Context_1_dataSource;
import context.Context_2_mybatis;
import context.Context_3_dao;
import dao.DeptDAO;
import lombok.extern.log4j.Log4j;
import vo.DeptVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Context_1_dataSource.class , Context_2_mybatis.class , Context_3_dao.class})
@Log4j
public class DeptTest {
	
	@Autowired
	private DeptDAO dept_dao;

	
	@Test
	public void getListTest() {
		dept_dao.selectList().forEach(log::info);
		
//		for(DeptVO vo : list) {
//			System.out.printf("%d / %s / %s \n",vo.getDeptno(),vo.getDname(),vo.getLoc());
//		}
		
		
		
		
	}
	
	
	
	

}
