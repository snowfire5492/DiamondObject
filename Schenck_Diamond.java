//*****************************************************************************/
//*****************************************************************************/
//
//		file: Schenck_Diamond
//  	author: E. Schenck
//		class: CS 141 Intro to Programming
//
//		assignment: Program 4
//		date last modified: 2/14/2017
//
//		purpose: write a program that represents the info gathered 
//		(size, clarity , color, and cut style) of a diamond and implements the 
//		comparable interface. 
//		
//		use the following instance variables:
//		- stockNumber - contains identifying string of the diamond.
//		- carot - contains a double for the size of the diamond.
//		- clarity - contains a string with the clarity grade of the diamond.
//		- color – contains a char with the color grade of the diamond.
//		- cut – contains a string with the name of the diamond's cut.
//
//		use the following instance methods:
//	    getStock(), getCarot(), getClarity(), 
//      getColor(), getCut() which will return their corresponding variable.
//
//		- toString() – a descriptive method of the diamond class which generally 
//		covers all the instance variables.
//		- compareTo(Diamond other) – compares two diamonds and returns an int 
//		value so that better diamonds are to the left of poor diamonds when sorted. 
//      This means that goodDiamond.compareTo(poorDiamond)returns a negative value.
//      - A constructor method for the class which takes in a string, double, 
//		string, char, and string as arguments in order to initialize one of each 
//		of the instance variables given above.
//
//		Use the following guidelines for the instance variables and methods above:
//		
//		The size of a diamond is measured in carots, usually less than 5.0. 
//		The clarity grade of a diamond is given as a  two or three letter code, 
//		FL, IF, VVS1, VVS2, VS1, VS2, SI1, SI2, I1, I2, I3. FL (flawless) is the best, 
//		I3 is the worst. The color grade is a one letter code, D through Z. 
//		D is the best, Z is the worst. The cut is the name of the pattern the diamond 
//      has been cut into. The method compareTo() is written so that diamonds are ordered 
//		first by carot, then by clarity OR color, whichever is better for the particular 
//		diamond. Since there are 23 grades of color, but only 11 grades of clarity,
//		regard the first two color grades as equal in grade to the first grade of clarity, 
//		the next two color grades equal in grade to the second grade of clarity, and so on. 
//		In comparing the codes for clarity, you will need a series of if statements.
//
//		Run the diamond program with the driver provided online and capture all interaction 
//		in a file using the script command. (Modify the driver for "YourName_Diamond" to be 
//		used in place of Diamond in the main method)
//
//*****************************************************************************/
//*****************************************************************************/

public class Schenck_Diamond implements Comparable<Schenck_Diamond>
{
	// instance variables
	private String stockNumber; // contains identifying string of diamond
	private double carot; // contains size of the diamond 
	private String clarity; // contains the clarity grade of teh diamond
	private char color; // contains color grade of the diamond
	private String cut; // contains name of the diamonds cut
	
	/**
	* Returns stockNumber of diamond
	*
	* @return 
	*/
	public String getStock()
	{
		return stockNumber; 
	}
	
	
	/**
	* Returns carot size of diamond
	*
	* @return
	*/
	public double getCarot()
	{
		return carot;
	}
	
	
	/**
	* Returns Clarity grade of diamond
	*
	* @return 
	*/
	public String getClarity()
	{
		return clarity;
	}
	
	
	/**
	* Returns color grade of diamond
	*
	* @return
	*/
	public char getColor()
	{
		return color;
	}
	
	
	/**
	* toString() – a descriptive method of the diamond class which generally covers all the instance variables.
	*
	* @return void 
	*/
	public String toString()
	{
		String result = ("Stock Number " + stockNumber + ", carot: " + carot +
							", clarity: " + clarity + ", color: " + color + ", cut: " + cut);
		return result;
	}
	
	public enum ClarityRating { FL, IF, VVS1, VVS2, VS1, VS2, SI1, SI2, I1, I2, I3 }
	
	/**
	* compareTo(Diamond other) - compares 2 diamonds and returns int value 
	* so that better diamonds are to the left of poor diamonds when sorted.
	* goodDiamond.compareTo(poorDiamond) returns a negative value.
	*
	* @param Diamond
	* @return int
	*/
	public int compareTo(Schenck_Diamond d)
	{
		int checkClarityA = 0;
		int checkClarityB = 0;
		int checkColorA = 0;
		int checkColorB = 0;
		int toReturn = 0;
		int savedA = 0;
		int savedB = 0;
		boolean sandwich = false;
		
		if(this.getCarot() > d.getCarot())
		{
			toReturn = -1;
			sandwich = true;
		}else if(this.getCarot() < d.getCarot())
		{
			toReturn = 1;
			sandwich = true;
		}else if(this.getCarot() == d.getCarot())
		{
			ClarityRating crForThis = ClarityRating.valueOf(this.getClarity());
			ClarityRating crForThat = ClarityRating.valueOf(d.getClarity());
			switch (crForThis)
			{
				case FL:
					checkClarityA = 11;
					break;
				case IF: 
					checkClarityA = 10;
					break;
				case VVS1:
					checkClarityA = 9;
					break;					
				case VVS2: 
					checkClarityA = 8;
					break;				
				case VS1: 
					checkClarityA = 7;
					break;				
				case VS2: 
					checkClarityA = 6;
					break;				
				case SI1: 
					checkClarityA = 5;
					break;					
				case SI2:
					checkClarityA = 4;
					break; 				
				case I3:
					checkClarityA = 3;
					break;					
				case I2:
					checkClarityA = 2;
					break;
				case I1:
					checkClarityA = 1;
					break;
				default:
					break;
			}
			switch(this.getColor()) //using fall-through by ommitting break 
			{
				case 'D':
				case 'E':
					checkColorA = 11;
					break;
				case 'F':
				case 'G':
					checkColorA = 10;
					break;
				case 'H':
				case 'I':
					checkColorA = 9;
					break;
				case 'J':
				case 'K':
					checkColorA = 8;
					break;
				case 'L':
				case 'M':
					checkColorA = 7;
					break;
				case 'N':
				case 'O':
					checkColorA = 6;
					break;
				case 'P':
				case 'Q':
					checkColorA = 5;
					break;
				case 'R':
				case 'S':
					checkColorA = 4;
					break;
				case 'T':
				case 'U':
					checkColorA = 3;
					break;
				case 'V':
				case 'W':
					checkColorA = 2;
					break;
				case 'X':
				case 'Y':
				case 'Z': 
					checkColorA = 1;
					break;
				default:
					break;
			}
			switch (crForThat)
			{
				case FL:
					checkClarityB = 11;
					break;
				case IF: 
					checkClarityB = 10;
					break;
				case VVS1:
					checkClarityB = 9;
					break;					
				case VVS2: 
					checkClarityB = 8;
					break;				
				case VS1: 
					checkClarityB = 7;
					break;				
				case VS2: 
					checkClarityB = 6;
					break;				
				case SI1: 
					checkClarityB = 5;
					break;					
				case SI2:
					checkClarityB = 4;
					break; 				
				case I3:
					checkClarityB = 3;
					break;					
				case I2:
					checkClarityB = 2;
					break;
				case I1:
					checkClarityB = 1;
					break;
				default:
					break;
			}
			switch(d.getColor()) //using fall-through by ommitting break 
			{
				case 'D':
				case 'E':
					checkColorB = 11;
					break;
				case 'F':
				case 'G':
					checkColorB = 10;
					break;
				case 'H':
				case 'I':
					checkColorB = 9;
					break;
				case 'J':
				case 'K':
					checkColorB = 8;
					break;
				case 'L':
				case 'M':
					checkColorB = 7;
					break;
				case 'N':
				case 'O':
					checkColorB = 6;
					break;
				case 'P':
				case 'Q':
					checkColorB = 5;
					break;
				case 'R':
				case 'S':
					checkColorB = 4;
					break;
				case 'T':
				case 'U':
					checkColorB = 3;
					break;
				case 'V':
				case 'W':
					checkColorB = 2;
					break;
				case 'X':
				case 'Y':
				case 'Z': 
					checkColorB = 1;
					break;
				default:
					break;
			}
				
		}
		if( checkClarityA >= checkColorA )
		{
			savedA = checkClarityA;
		}else if( checkClarityA < checkColorA )
		{
			savedA = checkColorA;
		}
		if( checkClarityB >= checkColorB )
		{
			savedB = checkClarityB;
		}else if( checkClarityB < checkColorB )
		{
			savedB = checkColorB;
		}
		if( savedA >= savedB && sandwich == false )
		{
			toReturn = -1;
		}else if( savedA < savedB && sandwich == false)
		{
			toReturn = 1;
		}
		return toReturn;
			
	}
	/*
	The size of a diamond is measured in carots, usually less than 5.0. The clarity grade of a diamond is given as a
two or three letter code, FL, IF, VVS1, VVS2, VS1, VS2, SI1, SI2, I1, I2, I3. FL (flawless) is the best, I3 is the
worst. The color grade is a one letter code, D through Z. D is the best, Z is the worst. The cut is the name of the
pattern the diamond has been cut into.
The method compareTo() is written so that diamonds are ordered first by carot, then by clarity OR color,
whichever is better for the particular diamond. Since there are 23 grades of color, but only 11 grades of clarity,
regard the first two color grades as equal in grade to the first grade of clarity, the next two color grades equal in
grade to the second grade of clarity, and so on. In comparing the codes for clarity, you will need a series of if
statements.
	
	*/
	
	
	/**
	* constructor method for the class which takes in 
	* String, double, String, Char, and String in that order
	*
	* @param String stockNumber
	* @param double carot
	* @param String clarity
	* @param char color
	* @param String cut
	*/
	public Schenck_Diamond(String sn , double ct, String cl, char cr, String cu)
	{
		stockNumber = sn;
		carot = ct;
		clarity = cl;
		color = cr;
		cut = cu;
	}
}






