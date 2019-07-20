package Graphs;
import java.util.*;
import java.io.*;
import java.lang.*;
public class DetectCycleUndirectedGraph {
  public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      
      while(t-- > 0)
      {
          ArrayList<ArrayList<Integer>> list = new ArrayList<>();
          int nov = sc.nextInt();
          int edg = sc.nextInt();
          
          for(int i = 0; i < nov+1; i++)
              list.add(i, new ArrayList<Integer>());
              
          for(int i = 1; i <= edg; i++)
          {
              int u = sc.nextInt();
              int v = sc.nextInt();
              list.get(u).add(v);
              list.get(v).add(u);
          }
          if(isCyclic(list, nov) == true)
              System.out.println("1");
          else System.out.println("0");
      }
  }
  static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V){
      int parent[] = new int[V + 1];
      Arrays.fill(parent, -1);
      //int src = find(list, parent);
      //parent[0] = 0;
      boolean b = false;
      for(int i = 0; i < list.size() - 1; i++){
          if(parent[i] == -1){
              b = find(list, parent, i);
              if(b) return b;
          }
      }
      return b;
      
  }
  static boolean find(ArrayList<ArrayList<Integer>> list, int parent[], int src){
      Queue<Integer> q = new LinkedList<>();
      q.add(src);
      parent[src] = -2;
      while(!q.isEmpty()){
          int c = q.poll();
          for(int i = 0; i < list.get(c).size(); i++){
              if(parent[list.get(c).get(i)] == -1){
                  q.add(list.get(c).get(i));
                  parent[list.get(c).get(i)] = c;
              }
              else if(parent[c] != list.get(c).get(i)){
                  return true;
              }
          }
      }
      return false;
  }
}
/*
Input:
3
2 2
0 1 0 0
4 3
0 1 1 2 2 3
5 4
0 1 2 3 3 4 4 2

Output:
1
0
1
*/