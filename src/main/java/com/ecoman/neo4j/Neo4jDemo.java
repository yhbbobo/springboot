package com.ecoman.neo4j;

import java.util.List;
import java.util.Map;

public interface Neo4jDemo {
	List  shortestPath(Map<String,Object> fromRoute, Map<String,Object> toRoute);
}
