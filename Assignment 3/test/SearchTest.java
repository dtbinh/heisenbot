package test;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import search.*;

@Test
public class SearchTest {
	static Node<String, String> root;
	static Node<String, String> firstNode; 
	static Node<String, String> secondNode; 
	
  @BeforeMethod
  public void setUp() {
		root = new Node<String, String>("State1");
		firstNode = new Node<String, String>("Action1", "State2", root);
		secondNode = new Node<String, String>("Action2", "State3", firstNode);
  }
  
  public static void TestNodeGetAction() {
	  assertEquals(null, root.getAction());
	  assertEquals("Action1", firstNode.getAction());
	  assertEquals("Action2", secondNode.getAction());
	}
  
  public static void TestNodeGetState() {
	  assertEquals("State1", root.getState());
	  assertEquals("State2", firstNode.getState());
	  assertEquals("State3", secondNode.getState());
	}

  public static void TestNodeGetPrevious() {
	  assertEquals(null, root.getPrevious());
	  assertEquals("Action: null, State: State1", firstNode.getPrevious().toString());
	  assertEquals("Action: Action1, State: State2", secondNode.getPrevious().toString());
	  
	  assertEquals(root, firstNode.getPrevious());
	  assertEquals(firstNode, secondNode.getPrevious());
	}

  public static void TestNodeGetRoute() {
	  assertEquals("[Action1, Action2]", secondNode.getRoute().toString());
	  assertEquals("[Action1]", firstNode.getRoute().toString());
	  assertEquals("[]", root.getRoute().toString());
	}
  
  public static void TestNodeRouteToString() {
	  assertEquals("Action: Action2, State: State3, Previous Node: Action: Action1, State: State2, Previous Node: State: State1", secondNode.routeToString());
	  assertEquals("Action: Action1, State: State2, Previous Node: State: State1", firstNode.routeToString());
	  assertEquals("State: State1", root.routeToString());
 	}
  
  public static void TestNodeToString() {
	  assertEquals("Action: null, State: State1", root.toString());
	  assertEquals("Action: Action1, State: State2", firstNode.toString());
	  assertEquals("Action: Action2, State: State3", secondNode.toString());
  }
  
 }
  

