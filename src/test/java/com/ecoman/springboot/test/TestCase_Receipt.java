package com.ecoman.springboot.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ecoman.jpa.Receipt;
import com.ecoman.jpa.ReceiptLine;
import com.ecoman.jpa.ReceiptRepo;
import com.ecoman.neo4j.Neo4jDemo;

public class TestCase_Receipt extends BaseTestCase {
	@Resource
	ReceiptRepo receiptRepo;
	
	@Resource
	Neo4jDemo neo4jDemo;
	
	@Before
	public void setUp() throws Exception {
	}
	
	//@Test
	public void test_crud(){
		Receipt receipt = new Receipt();
		//只填入必填字段做测试
		receipt.setCompanyId("W12");
		receipt = receiptRepo.save(receipt);
		
		Long rid = receipt.getId();
		assertTrue(rid > 0 && receiptRepo.findOne(rid) !=null);
		System.out.println("updated on: "+receipt.getDateUpdated().getTime());
		
		
		//Update
		//添加2个ReceiptLine实体
		ReceiptLine receiptLine = new ReceiptLine();
		receiptLine.setReceipt(receipt);
		receipt.getLines().add(receiptLine);
		receiptLine = new ReceiptLine();
		receiptLine.setReceipt(receipt);
		receipt.getLines().add(receiptLine);
		receiptRepo.save(receipt);
		
		receipt = receiptRepo.findOne(rid);
		Set<ReceiptLine> lines = receipt.getLines();
		assertTrue(lines.size() == 2);
		for(ReceiptLine line: lines){
			assertTrue(line.getId() > 0);
		}
		System.out.println("updated on: "+receipt.getDateUpdated().getTime());
		
		
		
		receiptRepo.delete(receipt);
		
		assertTrue(receiptRepo.findOne(rid) == null);
	}
	
	@Test
	public void test_neo4jDemo() throws Exception { 
		Map<String,Object> fromRoute =new HashMap<String, Object>();
		fromRoute.put("r_id", 1006883);
		Map<String,Object> toRoute =new HashMap<String, Object>();
		toRoute.put("r_id", 102091359);
		List data = neo4jDemo.shortestPath(fromRoute, toRoute);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(new File("test_neo4jDemo.json"), data);
	}
}
