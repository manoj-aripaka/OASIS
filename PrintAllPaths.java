/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author aripa
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class PrintAllPaths{

  private final int vertex;
  private ArrayList<Integer>[] adjList;

  public PrintAllPaths(int vertices) {
      vertex = vertices;
      initAdjList();
  }

  @SuppressWarnings(value = "unchecked")
  private void initAdjList()
  {
      adjList = new ArrayList[vertex];
      for (int i = 0; i < vertex; i++) {
          adjList[i] = new ArrayList<>();
      }
  }
  public void addEdge(int verA, int verB)
  {
      adjList[verA].add(verB);
  }

  public void printAllPathsHelper(int start, int end, boolean[] isVisited, List<Integer> tempPathList)
  {
      if ((start == end) && (tempPathList.size()<10)) {
          System.out.println(tempPathList);
          return;
      }

      isVisited[start] = true;

      for (Integer i : adjList[start]) {
          if (!isVisited[i]) {
              tempPathList.add(i);
              printAllPathsHelper(i, end, isVisited, tempPathList);
              tempPathList.remove(i);//backtracking
          }
      }
      isVisited[start] = false;
  }

  public void printAllPaths(int source, int dest)
  {
      boolean[] isVisited = new boolean[vertex];
      ArrayList<Integer> pathList = new ArrayList<>();
      pathList.add(source);
      printAllPathsHelper(source, dest, isVisited, pathList);
  }

  public static void main(String[] args)
  {
      PrintAllPaths graph = new PrintAllPaths(13);
      int src, des, dist;
                try{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","manoj","manoj");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from demo");
			while(rs.next())  {
				src = rs.getInt(1);
                                des = rs.getInt(2);
                                graph.addEdge(src, des);
                            
                        }

                        con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		

		// arbitrary source
		int s = 1;

		// arbitrary destination
		int d = 10;

      System.out.println("All possible paths from " + s + " to " + d + " are:");
      graph.printAllPaths(s, d);
  }
}