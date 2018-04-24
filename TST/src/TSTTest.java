import static org.junit.Assert.*;

import org.junit.Test;
import org.json.simple.parser.*;
import org.json.simple.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TSTTest {

	  @Test
	  public void testEmpty(){
	    TST<Long> trie = new TST<>();
	    assertEquals("size of an empty trie should be 0",0, trie.size());
	    assertFalse("searching an empty trie should return false",trie.contains(""));
	    assertNull("getting from an empty trie should return null",trie.get(""));
	    assertNull("testing getting null key", trie.get(null));
	    
	  }
	  
	  
	  @Test
	  public void testPut() {
		  
		  TST<Integer> trie = new TST<Integer>();
		  trie.put("Hello", 1);
		  trie.put("Friend", 2);
		  assertEquals("Size of trie with two keys", 2, trie.size());
		  assertFalse("search for key that isn't present", trie.contains("Wow"));
		  assertTrue("search for key that is present", trie.contains("Hello"));
		  assertEquals("Getting value from specified key", (Integer) 2, trie.get("Friend"));
		  trie.put("Helium", 3);
		  LinkedList<String> l = trie.keysWithPrefix("Hel");
		  assertEquals("Test prefixes", 2, l.size());
		  
	  }
	  
	  
	  
	  
	  
	  /*public static void main(String[] args) throws Exception {
		  
		  TST<Integer> trie = new TST<Integer>();
		  
		  Object o = new JSONParser().parse(new FileReader("BUSES_SERVICE_0.json"));
		  JSONArray arr = (JSONArray) o;
		  Iterator itr = arr.iterator();
		  
		  while(itr.hasNext()) {
			  JSONObject obj = (JSONObject) itr.next();
			  String dest = (String) obj.get("Destination");
			  if(!trie.contains(dest)) {
				  trie.put(dest, 1);
			  }
			  else {
				  int count = trie.get(dest);
				  trie.put(dest, count+1);
			  }
		  }
		  
		  System.out.println("Number of unique destinations = " + trie.size());
		  System.out.println(trie.contains("SOUTHSIDE"));
		  LinkedList<String> l = trie.keysWithPrefix("DOWN");
		  
		  int count = 0; 
		  for(int i=0; i<l.size(); i++) {  
			  int no = trie.get(l.get(i));
			  count += no;  
		  }
		  System.out.println(count);
		  
		  List<String> list = new ArrayList<String>();
		  
		  
		  TST<Long> trie2 = new TST<Long>();
		  
		  In in = new In("google-books-common-words.txt");
		  String[] s = in.readAllStrings();
		  //System.out.println(s[0]);
		  for(int i=0; i<s.length; i+=2) {
			  
			  trie2.put(s[i], Long.valueOf(s[i+1]).longValue());
			 
			  
		  }
		  
		  System.out.println("Number of words = " + trie2.size());
		  System.out.println("ALGORITHM appears " + trie2.get("ALGORITHM") + " times");
		  System.out.println(trie2.contains("EMOJI"));
		  System.out.println(trie2.contains("BLAH"));
		  LinkedList<String> l2 = trie2.keysWithPrefix("TEST");
		  System.out.println(l2.size());
		  
		  
		  
		  
		  
		  
	  }*/
	  
  
  
  
  
}
