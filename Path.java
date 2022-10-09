package flightPlanAlgo;

import java.util.Stack;

public class Path implements Comparable<Path>
{
	Stack<String> cities;
	double cost;
	int time;
	double weight;
	public Path(String source)
	{
		cities = new Stack<String>();
		cities.add(source);
		this.cost = 0;
		this.time = 0;
		this.weight = 0;
	}
	public Path(Path init)
	{
		cities = (Stack<String>)init.cities.clone();
		cost = init.cost;
		time = init.time;
		weight = init.weight;
	}
	public String lastCity()
	{
		return cities.peek();
	}
	public boolean contains(String city)
	{
		return cities.contains(city);
	}
	public Path addCity(Edge e, String type)
	{
		Path newPath = new Path(this);
		newPath.cities.add(e.destination);
		newPath.cost += e.cost;
		newPath.time += e.time;
		if(type.equals("C")) newPath.weight += e.cost;
		else newPath.weight += e.time;
		return newPath;
	}
	public String toString()
	{
		Stack<String> clone = (Stack<String>)cities.clone();
		String[] path = new String[cities.size()];
		for(int i = path.length-1; i >= 0; i--) path[i] = clone.pop();
		String ret = path[0];
		for(int i = 1; i < path.length; i++) ret += " -> " + path[i];
		ret += ". Time: " + time + " Cost: " + String.format("%.2f",cost);
		return ret;
	}
	public int compareTo(Path other)
	{
		return Double.compare(weight,other.weight);
	}
}
