/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author aripa
 */
// JAVA program to print all
// paths from a source to
// destination.
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

// A directed graph using
// adjacency list representation
public class Graph {

	// No. of vertices in graph
	private int v;

	// adjacency list
	private ArrayList<Integer>[] adjList;

	// Constructor
	public Graph(int vertices)
	{

		// initialise vertex count
		this.v = vertices;

		// initialise adjacency list
		initAdjList();
	}

	// utility method to initialise
	// adjacency list
	@SuppressWarnings("unchecked")
	private void initAdjList()
	{
		adjList = new ArrayList[v];

		for (int i = 0; i < v; i++) {
			adjList[i] = new ArrayList<>();
		}
	}

	// add edge from u to v
	public void addEdge(int u, int v)
	{
		// Add v to u's list.
		adjList[u].add(v);
	}

	// Prints all paths from
	// 's' to 'd'
	public void printAllPaths(int s, int d)
	{
		boolean[] isVisited = new boolean[v];
		ArrayList<Integer> pathList = new ArrayList<>();

		// add source to path[]
		pathList.add(s);

		// Call recursive utility
		printAllPathsUtil(s, d, isVisited, pathList);
	}

	// A recursive function to print
	// all paths from 'u' to 'd'.
	// isVisited[] keeps track of
	// vertices in current path.
	// localPathList<> stores actual
	// vertices in the current path
	private void printAllPathsUtil(Integer u, Integer d,
								boolean[] isVisited,
								List<Integer> localPathList)
	{

		if (u.equals(d)) {
			System.out.println(localPathList);
			// if match found then no need to traverse more till depth
			return;
		}

		// Mark the current node
		isVisited[u] = true;

		// Recur for all the vertices
		// adjacent to current vertex
		for (Integer i : adjList[u]) {
			if (!isVisited[i]) {
				// store current node
				// in path[]
				localPathList.add(i);
				printAllPathsUtil(i, d, isVisited, localPathList);

				// remove current node
				// in path[]
				localPathList.remove(i);
			}
		}

		// Mark the current node
		isVisited[u] = false;
	}

	// Driver program
	public static void main(String[] args)
	{
		// Create a sample graph
		Graph g = new Graph(15);
                /*g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);
 */
                int src, des, dist;
                try{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","manoj","manoj");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from demo");
			while(rs.next())  {
				src = rs.getInt(1);
                                des = rs.getInt(2);
                                g.addEdge(src, des);
                            //    dist = rs.getInt(3);
                        }
                    //    stmt.executeUpdate("INSERT INTO AIRPORTS VALUES(17.2405,78.4294,'Rajiv Gandhi International Airport','India','RGIA')");
                        con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		

		// arbitrary source
		int s = 1;

		// arbitrary destination
		int d = 8;

		System.out.println(
			"Following are all different paths from "
			+ s + " to " + d);
		g.printAllPaths(s, d);
	}
}

// This code is contributed by Himanshu Shekhar.
