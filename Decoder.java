package cs310Lab2;
import cs310Lab2.Queue;
import java.util.*;
import java.io.*;

public class Decoder extends ReadFile
{
	public static Queue dataDecoder(Queue queue, ArrayList<Integer[]> milesCodes, 
			Queue output)
	{
		int[] peekValues;
		boolean dequeue = false;
		while (queue.size() > 5)
		{
			if (queue.size() == 6)
				peekValues = queue.peek(6);
			else
				peekValues = queue.peek(7);
			int valToSubtract = peekValues[0];
			int subtractedVal = 0;
			for(int i = 0; i < peekValues.length; i++)
			{
				subtractedVal = peekValues[i] - valToSubtract;
				peekValues[i] = subtractedVal;
			}
			for(Integer[] milesCode : milesCodes)
			{
				dequeue = false;
				boolean noise = false;
				int counter = 0;
				int milesIndex = 0;
				for (int index = 0; index < peekValues.length; index++)
				{
					if(peekValues[index] == milesCode[milesIndex])
					{
						counter++;
						milesIndex++;
					}
					else
					{
						if (noise == true)
							continue;
						else if ((milesCode[index] - milesCode[index-1]) < 0)
						{
							noise = false;
							break;
						}	
						noise = true;
					}			
				}
				if(counter == 6 && noise == false)
				{
					output.loadValue(milesCode[6]);
					for (int i = 0; i < peekValues.length-1; i++)
					{
						queue.nextValue();
					}
					dequeue = true;
					break;
				}
				else if (counter == 6 && noise == true)
				{
					output.loadValue(milesCode[6]);
					for (int i = 0; i < peekValues.length; i++)
					{
						queue.nextValue();
					}
					dequeue = true;
					break;
				}
			}
			if(dequeue == false)
				queue.nextValue();
		}
		output.print();
		return output;
	}
	public static void fileWriter(Queue output)
	{
		try
		{
			PrintWriter file = new PrintWriter("output.csv");
			int counter = output.size();
			for (int i = 0; i < counter; i++)
			{
				if (i == (counter - 1))
					file.print(iterate(output));
				else
					file.print(iterate(output) + ",");
			}
			file.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	private static int iterate(Queue output)
	{
		return output.nextValue();
	}
}