/*
 * Name: Shiyun Lian
 */

import java.util.Iterator;
import java.util.Scanner;

public class Driver {
	private static GraphInterface<Profile> networkMap = new UndirectedGraph<>();

	public static void main(String[] args) {
		ProfileList profileList = new ProfileList();
		
		System.out.println("Creating following profiles in the network:");
		System.out.println("Elsa, Tom, Jack, Mike, Tim, Kevin, John, Jim");	
		System.out.println("******************************************");
		
		// create profiles
		Profile Elsa = new Profile("Elsa", "on");
		Profile Tom = new Profile("Tom", "on");
		Profile Jack = new Profile("Jack", "on");
		Profile Mike = new Profile("Mike", "on");
		Profile Tim = new Profile("Tim", "on");
		Profile Kevin = new Profile("Kevin", "on");
		Profile John = new Profile("John", "on");
		Profile Jim = new Profile("Jim", "on");
		
		// create profile list contain the profiles which were created above
		profileList.addProfile(Elsa);
		profileList.addProfile(Tom);
		profileList.addProfile(Jack);
		profileList.addProfile(Mike);
		profileList.addProfile(Tim);
		profileList.addProfile(Kevin);
		profileList.addProfile(John);
		profileList.addProfile(Jim);
		
		// test to display a profile list
		System.out.println("Test to display a profile list:");
		profileList.printProfileList();
		System.out.println("******************************************");
		
		// create a network map
		networkMap.addVertex(Elsa);
		networkMap.addVertex(Tom);
		networkMap.addVertex(Jack);
		networkMap.addVertex(Mike);
		networkMap.addVertex(Tim);
		networkMap.addVertex(Kevin);
		networkMap.addVertex(John);
		networkMap.addVertex(Jim);
		
		// create connection of Tom, Jack and Mike
		networkMap.addEdge(Tom, Jack);
		networkMap.addEdge(Tom, Mike);
		System.out.println("Test Tom's friend list:");
		testBFS(Tom);
		System.out.println("\n******************************");
		
		// create connection of Jack, Jim, Tim and Mike
		networkMap.addEdge(Jack, Jim);
		networkMap.addEdge(Jack, Tim);
		networkMap.addEdge(Jack, Mike);
		System.out.println("Test Jack's friend list:");
		testBFS(Jack);
		System.out.println("\n******************************");
		
		// create connection of Elsa and other friends
		networkMap.addEdge(Elsa, Tom);
		networkMap.addEdge(Elsa, Jack);
		networkMap.addEdge(Elsa, Mike);
		networkMap.addEdge(Elsa, Tim);
		networkMap.addEdge(Elsa, Kevin);
		networkMap.addEdge(Elsa, John);
		networkMap.addEdge(Elsa, Jim);
		System.out.println("Test Elsa's friend list:");
		testBFS(Elsa); 
		System.out.println("\n******************************");
		
		// test to delete a profile 
		System.out.println("Test to delete a profile of Tom");
		profileList.deleteProfile(Tom);
		System.out.println("******************************************");
		System.out.println("Display a profile list(should be no Tom):");
		profileList.printProfileList();
		System.out.println("******************************************");
		
		// test to modify a profile
		System.out.println("Test to modify a profile of Elsa");
		System.out.println("Change name of Elsa to Grace");
		Elsa.setName("Grace");
		System.out.println("Elsa should be changed to " + Elsa.getName());
		System.out.println("******************************************");
	}
		
	// a method to test a person's friend list
	public static void testBFS(Profile v)
	{
		System.out.println("The friend list of " + v.getName() + ": ");
		QueueInterface<Profile> bfs = networkMap.getBreadthFirstTraversal(v);
		
		printQueue(bfs);
	} // end testBFS
	
	// a method to print a person's friend list
	public static void printQueue(QueueInterface<Profile> q)
	{
		if(!q.isEmpty()) {
			q.dequeue();
		}
		while (!q.isEmpty()) {
			System.out.print(q.getFront().getName() + " ");
			q.dequeue();
		}
	} // end printQueue
	
	
	
	/*
	public static void testDFS(Profile v)
	{
		System.out.println("\nDepth-First Traversal beginning at vertex " + v + ": ");
		QueueInterface<Profile> dfs = networkMap.getDepthFirstTraversal(v);
		
		printQueue(dfs);
	} // end testDFS
	
	public static void printStack(StackInterface<String> s)
	{
		while (!s.isEmpty())
			System.out.print(s.pop() + " ");
		System.out.println();
	} // end printStack
	
	*/
	
}
