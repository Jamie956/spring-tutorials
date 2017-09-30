package com.example.demo.mongo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class HelloMongo2 {
	public static void main(String[] args) {
//		addDocument();
		getDocument();
	}

	public static final String USER = "admin";
	public static final String DB = "admin";
	public static final String PASSWORD = "123456";
	public static final String DBNAME = "mydb";
	
	private static MongoClient ConnToCli() {
		MongoClient client = null;
	    try{
		    MongoCredential credential = MongoCredential.createCredential(USER, DB, PASSWORD.toCharArray());
		    ServerAddress addr = new ServerAddress("localhost", 27017);
		    client = new MongoClient(addr,Arrays.asList(credential));  
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return client;
	}
	
	private static void cliClose(MongoClient client) {  
        if (client != null) {  
            client.close();
        }  
	} 
	
	public static void addDocument() {
		MongoClient client = ConnToCli();
		MongoDatabase database = client.getDatabase("mydb");
		MongoCollection<Document> collection = database.getCollection("myc2");
		
		List<Document> docs = new ArrayList<Document>();
		for(int i=1; i < 11; i++) {
		    Document doc = new Document().append("name", "tomcat"+i).append("pwd", "xxxx"+i).append("age", 10+i);
		    docs.add(doc);
		}
		collection.insertMany(docs);
		
		cliClose(client);
		
	}
	
	public static void getDocument() {
		MongoClient client = ConnToCli();
		MongoDatabase database = client.getDatabase(DBNAME);
		MongoCollection<Document> collection = database.getCollection("myc2");
		
		Document match = new Document("$match", new Document("age", 20));
		Document project = new Document("$project",new Document("_id", 0).append("name", 1).append("age", 1));
		Document sort = new Document("$sort", new Document("name", -1));
		Document skip = new Document("$skip", 1);
		Document limit = new Document("$limit", 2);
		List<Document> pipeline = Arrays.asList(match, project, sort, skip, limit);
		AggregateIterable<Document> output = collection.aggregate(pipeline);
		
	    Iterator<Document> it = output.iterator(); 
	    while (it.hasNext()) {  
	       System.out.println(it.next());  
	    }
		
		cliClose(client);
	}
	
}


