package flightPlanAlgo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;

public class Graph
{
	HashMap<String,LinkedList<Edge>> map;
	public Graph()
	{
		map = new HashMap<String,LinkedList<Edge>>();
	}
	public void addEdge(String source, String destination, double cost, int time)
	{
		if(!map.containsKey(source)) map.put(source, new LinkedList<Edge>());
		if(!map.containsKey(destination)) map.put(destination, new LinkedList<Edge>());
		map.get(source).add(new Edge(destination,cost,time));
		map.get(destination).add(new Edge(source,cost,time));
	}
	public String findPaths(String source, String destination, String type)
	{
		ArrayList<Path> allValidPaths = new ArrayList<Path>();
		Stack<Path> allPaths = new Stack<Path>();
		allPaths.add(new Path(source));
		while(!allPaths.isEmpty())
		{
			Path currentPath = allPaths.pop();
			if(currentPath.lastCity().equals(destination))
			{
				allValidPaths.add(currentPath);
				continue;
			}
			for(Edge e : map.get(currentPath.lastCity())) if(!currentPath.contains(e.destination)) allPaths.add(currentPath.addCity(e,type));
		}
		Collections.sort(allValidPaths);
		if(allValidPaths.size()==0) return "No Paths Found!\n";
		String ret = "";
		for(int i = 0; i < Math.min(3,allValidPaths.size()); i++) ret += "Path " + (i+1) + ": " + allValidPaths.get(i) + "\n";
		return ret;
	}
}