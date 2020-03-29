package cs310Lab2;

public class Driver extends Decoder
{
    public static void main (String[] args)
	{
        if (args.length < 2)
        {
            System.out.println("Error: Inatequate arguments passed to program");
            System.exit(1);
        }
		String testFile = args[0];
		String patternFile = args[1];
		System.out.println(testFile);
		System.out.println(patternFile);
		inputReader(queue, testFile);
		milesReader(milesPatterns, milesCodes, patternFile);
		fileWriter(dataDecoder(queue, milesCodes, output));
	}
}