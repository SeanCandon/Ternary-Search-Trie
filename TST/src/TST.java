
import java.util.LinkedList;


public class TST<Value> {

  /*
   * Bus Service Questions:
   * 1. How many unique destinations is there in the file?
   *    171
   * 2. Is there a bus going to the destination "SOUTHSIDE"?
   *    No
   * 3. How many records is there about the buses going to the destination beginning with "DOWN"?
   *    70
   *
   * Google Books Common Words Questions:
   * 4. How many words is there in the file?
   *    97565
   * 5. What is the frequency of the word "ALGORITHM"?
   *    14433021
   * 6. Is the word "EMOJI" present?
   *   	No
   * 7. IS the word "BLAH" present?
   *   	Yes
   * 8. How many words are there that start with "TEST"?
   *    39
   */
  /* A Node in your trie containing a Value val and a pointer to its children */
  private static class Node<Value> {
		private char c;                        // character
        private Node<Value> left, mid, right;  // left, middle, and right subtries
        private Value val;                     // value associated with string
  }

  /* a pointer to the start of your trie */
  private Node<Value> root = new Node<Value>();
  private int size;

  /*
   * Returns the number of words in the trie
   */
  public int size() {

    return size;
  }

  /*
   * returns true if the word is in the trie, false otherwise
   */
  public boolean contains(String key) {
    if(get(key) != null)
    	return true;
    return false;
  }

  /*
   * return the value stored in a node with a given key, returns null if word is not in trie
   */
  public Value get(String key) {
	  
	  //if(size > 0) {
	  if(key != null && key.length()>0) {
		  Node<Value> n = get(root, key, 0);
		  if(n == null)
			  return null;
		  return n.val;
	  }
	  //}
	  
	  return null;
  }
  
  private Node<Value> get(Node<Value> n, String key, int i){
	  
	  if(n==null) return null;
	  
	  char c = key.charAt(i);
	  if(c < n.c) {
		  return get(n.left, key, i);
	  }
	  else if(c > n.c) {
		  return get(n.right, key, i);
	  }
	  else if(i < key.length()-1) {
		  return get(n.mid, key, i+1);
	  }
	  else {
		  return n;
	  }
	  
  }

  /*
   * stores the Value val in the node with the given key
   */
  public void put(String key, Value val) {
	  
	  if(key != null) {
		  
		  if(!contains(key))
			  size++;
		  root = put(root, key, val, 0);
		  
	  }
	  
  }
  
  private Node<Value> put(Node<Value> n, String key, Value v, int i) {
	  
	  char c = key.charAt(i);
	  if(n==null) {
		  n = new Node<Value>();
		  n.c = c;
	  }
	  
	  if(c < n.c) {
		  n.left = put(n.left, key, v, i);
	  }
	  else if(c > n.c) {
		  n.right = put(n.right, key, v, i);
	  }
	  else if(i < key.length()-1) {
		  n.mid = put(n.mid, key, v, i+1);
	  }
	  else {
		  n.val = v;
	  }
	  return n;	  
	  
  }

  /*
   * returns the linked list containing all the keys present in the trie
   * that start with the prefix passes as a parameter, sorted in alphabetical order
   */
  public LinkedList<String> keysWithPrefix(String prefix) {
	  
	  if(prefix != null) {
    
		  LinkedList<String> list = new LinkedList<String>();
		  Node<Value> n = get(root, prefix, 0);
		  if(n==null) return list;
		  if(n.val != null) list.add(prefix);
		  keysWithPrefix(n.mid, new StringBuilder(prefix), list);
		  return list;
		  
	  }
	  
	  return null;
  }
  
  private void keysWithPrefix(Node<Value> node, StringBuilder prefix, LinkedList<String> list) {
	  
	  if(node != null) {
		  
		  keysWithPrefix(node.left, prefix, list);
		  if(node.val != null) {
			  list.add(prefix.toString() + node.c);
		  }
		  keysWithPrefix(node.mid, prefix.append(node.c), list);
		  keysWithPrefix(node.right, prefix, list);	  
		  
	  }
	  
  }
  
  
  
}