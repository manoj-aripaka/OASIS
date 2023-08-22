/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

// JAVA program to print all
// paths from a source to
// destination.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Graph_2 {

	private int v;
	private ArrayList<Integer>[] adjList;

	public Graph_2(int vertices) {
		this.v = vertices;
		initAdjList();
	}

	private void initAdjList() {
		adjList = new ArrayList[v];

		for (int i = 0; i < v; i++) {
			adjList[i] = new ArrayList<>();
		}
	}

	public void addEdge(int u, int v) {
		adjList[u].add(v);
	}

	public void printAllPaths(int s, int d, int slider) {
		boolean[] isVisited = new boolean[v];
		ArrayList<Integer> pathList = new ArrayList<>();
		pathList.add(s);
		printAllPathsUtil(s, d, isVisited, pathList, slider);
	}

	private void printAllPathsUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList, int slider) {
		if (u.equals(d)) {
			if (localPathList.size() <= slider)
				System.out.println(localPathList);
			return;
		}

		isVisited[u] = true;

		for (Integer i : adjList[u]) {
			if (!isVisited[i]) {
				localPathList.add(i);
				printAllPathsUtil(i, d, isVisited, localPathList, slider);
				localPathList.remove(i);
			}
		}

		isVisited[u] = false;
	}

	public static void main(String[] args) {
		Graph_2 g = new Graph_2(14);
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
		int d = 12;
		int slider = 2;
		g.printAllPaths(s, d, slider);
	}
}