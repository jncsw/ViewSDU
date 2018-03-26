package Jsoup;

import java.sql.Timestamp;
import java.util.ArrayList;

public class message {
	String signature;
	String timestamp;
	ArrayList<Article> list ;
	public message(String signature, String timestamp, ArrayList<Article> list) {
		super();
		this.signature = signature;
		this.timestamp = timestamp;
		this.list = list;
	}
	
	
	
}
