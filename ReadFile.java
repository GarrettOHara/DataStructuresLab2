package cs310Lab2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;

public class ReadFile 
{
	public static Queue queue = new Queue();
	public static Queue output = new Queue();
	public static ArrayList<String[]> milesPatterns = new ArrayList<String[]>();
	public static ArrayList<Integer[]> milesCodes = new ArrayList<Integer[]>();
	public Queue queue()
	{
		return this.queue();
	}
	public Queue output()
	{
		return this.output();
	}
	public ArrayList<String[]> milesPatterns()
	{
		return this.milesPatterns();
	}
	public ArrayList<Integer[]> milesCodes()
	{
		return this.milesCodes();
	}
	public static Queue inputReader(Queue queue, String testFile)
	{
		String line = "";		
		try
		{
			FileReader file = new FileReader(testFile);
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(file);
			
			while((line = reader.readLine()) != null)
			{
				String [] values = line.split(",");
				for (int i = 0; i < values.length; i++)
					queue.loadValue(Integer.parseInt(values[i]));
			}
			int counter = 0;
			for (int index = 0; index < queue.size(); index++)
			{
				counter++;
			}
			if (counter < 6)
				throw new IllegalArgumentException("Input to decode is not large enough");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			System.exit(2);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.exit(3);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(4);
		}
		return queue;
	}
	public static ArrayList<Integer[]> milesReader(ArrayList<String[]> milesPatterns, 
			ArrayList<Integer[]> milesCodes, String patternFile)
	{
		String line = "";
		try
		{
			FileReader file = new FileReader(patternFile);
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(file);
			while((line = reader.readLine()) != null)
			{		
				String[] valuesFromFile = line.split(",");
				milesPatterns.add(valuesFromFile);
			}
			for(String[] array: milesPatterns)
			{	
				Integer[] integersToAdd = new Integer[array.length];
				for (int i = 0; i < array.length; i++)
				{
					integersToAdd[i] = Integer.parseInt(array[i]);
				}
				milesCodes.add(integersToAdd);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.exit(3);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(4);
		}
		return milesCodes;
	}
}