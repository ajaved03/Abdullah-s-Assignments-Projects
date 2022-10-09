package flightPlanAlgo;

public class Edge
{
	String destination;
	double cost;
	int time;
	public Edge(String destination, double cost, int time)
	{
		this.destination = destination;
		this.cost = cost;
		this.time = time;
	}
}
