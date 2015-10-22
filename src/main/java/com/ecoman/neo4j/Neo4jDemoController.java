package com.ecoman.neo4j;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Neo4jDemoController {
	@Autowired
	private Neo4jDemo neo4jDemo;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/neo4jdemo",produces="application/json; charset=UTF-8", method = RequestMethod.POST)
	List shortestPath(@RequestBody Map<String,Map<String,Object>> q) throws Exception {
		return neo4jDemo.shortestPath(q.get("from"), q.get("to"));
	}
}
