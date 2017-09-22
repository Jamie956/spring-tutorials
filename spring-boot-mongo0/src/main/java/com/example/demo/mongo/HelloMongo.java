package com.example.demo.mongo;


import java.util.Arrays;
import java.util.Iterator;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class HelloMongo {
	public static void main(String[] args) {
//		addCollection("myc2");
//		removeCollection("myc2");
//		addDocument("myc2");
//		getDocument("myc2");
//		updateDocument("myc2");
		removeDocument("myc2");
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
	
	public static void addCollection(String cname) {
		MongoClient client = ConnToCli();
		MongoDatabase database = client.getDatabase(DBNAME);
		database.createCollection(cname);
		cliClose(client);
	}
	
	public static void removeCollection(String cname) {
		MongoClient client = ConnToCli();
		MongoDatabase database = client.getDatabase(DBNAME);
		MongoCollection<Document> collection = database.getCollection(cname);
		collection.drop();
		cliClose(client);
	}
	
	public static void addDocument(String cname) {
	    Document document = new Document() 
	    	    .append("name", "tomcat")
	    	    .append("pwd", "123456") 
	    	    .append("age", 18);  
	    
		MongoClient client = ConnToCli();
		MongoDatabase database = client.getDatabase(DBNAME);
		MongoCollection<Document> collection = database.getCollection(cname);
	    collection.insertOne(document);
	    cliClose(client);
	}
 
	public static void getDocument(String cname) {
		MongoClient client = ConnToCli();
		MongoDatabase database = client.getDatabase(DBNAME);
		MongoCollection<Document> collection = database.getCollection(cname);
		FindIterable<Document> iterDoc = collection.find(); 
		
		Iterator<Document> it = iterDoc.iterator(); 
	    while (it.hasNext()) {  
	       System.out.println(it.next());  
	    }
		cliClose(client);
	}

	public static void updateDocument(String cname) {
		MongoClient client = ConnToCli();
		MongoDatabase database = client.getDatabase(DBNAME);
		MongoCollection<Document> collection = database.getCollection(cname);
		collection.updateOne(Filters.eq("name", "tomcat"), Updates.set("age", 20));
		cliClose(client);
		
	}

	public static void removeDocument(String cname) {
		MongoClient client = ConnToCli();
		MongoDatabase database = client.getDatabase(DBNAME);
		MongoCollection<Document> collection = database.getCollection(cname);
		collection.deleteOne(Filters.eq("name", "tomcat"));
		cliClose(client);
	}
	
}


