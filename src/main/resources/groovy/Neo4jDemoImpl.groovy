import java.util.List
import java.util.Map
import groovyx.net.http.RESTClient

import com.ecoman.neo4j.Neo4jDemo

class Neo4jDemoImpl implements Neo4jDemo {
	String restBaseUrl
	
	List  shortestPath(Map<String,Object> fromRoute, Map<String,Object> toRoute){
		def params = [:]
		def fromParams = fromRoute.inject([]) { r, k, v ->
			params["from_$k"] = v
			r << "$k:{from_$k}"
		}.join(',')
		def toParams = toRoute.inject([]) { r, k, v ->
			params["to_$k"] = v
			r << "$k:{to_$k}"
		}.join(',')
		
		def q = """
			MATCH (n:Route{$fromParams}),(m:Route{$toParams}), p=allShortestPaths((n)-[*]->(m)) 
			return  [r in relationships(p) | [startnode(r), r, endnode(r)]] as paths
		""".toString()
		
	   def client = new RESTClient(restBaseUrl)
	   def resp = client.post( path :'/3/db/data/cypher',
		   					   requestContentType:'application/json',
		   					   body: [query:q, params:params])
	   
	   assert resp.status == 200
	   resp.data.data.collect { row ->
		   def rels = row[0]
		   rels.inject([]) { p, rel ->
			   def d = rel.data
               if(!p) p += d
               else p += d[1..2]
		   }
	   }
	}
}
