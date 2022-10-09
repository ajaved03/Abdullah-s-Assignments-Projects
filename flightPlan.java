package flightPlanAlgo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class flightPlan
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader input1 = new BufferedReader(new FileReader(new File(args[0])));
		BufferedReader input2 = new BufferedReader(new FileReader(new File(args[1])));
		PrintWriter output = new PrintWriter(args[2]);
		Graph graph = new Graph();
		int edges = Integer.parseInt(input1.readLine());
		while(edges-->0)
		{
			String[] data = input1.readLine().split("\\|");
			graph.addEdge(data[0],data[1],Double.parseDouble(data[2]),Integer.parseInt(data[3]));
		}
		int queries = Integer.parseInt(input2.readLine());
		for(int q = 1; q <= queries; q++)
		{
			String[] data = input2.readLine().split("\\|");
			if(data[2].equals("C")) output.println("Flight " + q + ": " + data[0] + ", " + data[1] + " (Cost)");
			else output.println("Flight " + q + ": " + data[0] + ", " + data[1] + " (Time)");
			output.println(graph.findPaths(data[0],data[1],data[2]));
		}
		output.flush();
		output.close();
	}
}