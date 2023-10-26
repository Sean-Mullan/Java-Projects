package part02;

public class AudioFileTester 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//fileTestCase1(); //Test to see if every code for audiofile will increment from the last
		//fileTestCase2(); //Test to see if toString will return a list of formatted audioFiles
		//fileTestCase3(); //Test to see if playcount will be incremented
		//fileTestCase4(); //Test to see if the title of an audiofile can be shown
		//fileTestCase5(); //Test to see if the duration of an audiofile can be shown
		//fileTestCase6(); //Test to see if the data source of an audiofile can be shown
		//fileTestCase7(); //Test to see if the playcount of an audiofile can be shown
		//fileTestCase8(); //Test to see if the code of an audiofile can be shown
		//fileTestCase9(); //Test to see if the title of an audiofile can be set to a value
		//fileTestCase10(); //Test to see if the duration of an audiofile can be set to a value
		//fileTestCase11(); //Test to see if the data source of an audiofile can be set to a value
		//fileTestCase12(); //Test to see if the play count of an audiofile can be set to a value
		//fileTestCase13(); //Test to see if strings input to audiofile that are not empty will be accepted
		//fileTestCase14(); //Test to see if strings input to audiofile that are empty will be denied
		//fileTestCase15(); //Test to see if strings input to audiofile that are null will be denied
		//fileTestCase16(); //Test to see if the duration will allow its maximum time as a value
		//fileTestCase17(); //Test to see if the duration will allow over its maximum time as a value
		//fileTestCase18(); //Test to see if the duration will allow under its minimum time as a value
		//fileTestCase19(); //Test to see if the playcount will allow under its minimum time as a value
	}
	
	private static void fileTestCase1() 
	{
		System.out.println("+++ Test Case 1: Increment code automatically. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		AudioFile temp2 = new AudioFile("bert",24,"wert");
		AudioFile temp3 = new AudioFile("curt",46,"wert");
		System.out.println(temp1);
		System.out.println(temp2);
		System.out.println(temp3);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase2() 
	{
		System.out.println("+++ Test Case 2: Format using toString. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println("Print should be [ID: 1, Title: wert, Duration: 23, Data Source: wert, Times Played: 0]");
		System.out.println(temp1);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase3() 
	{
		System.out.println("+++ Test Case 3: registerPlay to increment playCount. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println("Should now have a play count of 1");
		temp1.registerPlay();
		System.out.println(temp1);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase4() 
	{
		System.out.println("+++ Test Case 4: Fetch title of file. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println("Should fetch [wert]");
		String title = temp1.getTitle();
		System.out.println(title);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase5() 
	{
		System.out.println("+++ Test Case 5: Fetch duration of File. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println("Should fetch [23]");
		int dur = temp1.getDuration();
		System.out.println(dur);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase6() 
	{
		System.out.println("+++ Test Case 6: Fetch data source of File. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println("Should fetch [wert]");
		String ds = temp1.getDataSource();
		System.out.println(ds);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase7() 
	{
		System.out.println("+++ Test Case 7: Fetch playcount of File. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println("Should fetch [0]");
		int pc = temp1.getPlayCount();
		System.out.println(pc);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase8() 
	{
		System.out.println("+++ Test Case 8: Fetch code of File. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println("Should fetch [1]");
		int code = temp1.getCode();
		System.out.println(code);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase9() 
	{
		System.out.println("+++ Test Case 9: Set title of File. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println("Should then be [bert]");
		temp1.setTitle("bert");
		System.out.println(temp1);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase10() 
	{
		System.out.println("+++ Test Case 10: Set duration of File. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println("Should then be [46]");
		temp1.setDuration(46);
		System.out.println(temp1);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase11() 
	{
		System.out.println("+++ Test Case 11: Set data source of File. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println("Should then be [bert]");
		temp1.setDataSource("bert");
		System.out.println(temp1);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase12() 
	{
		System.out.println("+++ Test Case 12: Set play count of File [valid input]. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println("Should then be [4]");
		temp1.setPlayCount(4);
		System.out.println(temp1);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase13() 
	{
		System.out.println("+++ Test Case 13: using checkString with a valid input. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println("[bert] should be valid");
		temp1.setTitle("bert");
		System.out.println(temp1);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase14() 
	{
		System.out.println("+++ Test Case 14: using checkString with an invalid input. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println("[] should not be valid");
		temp1.setTitle("");
		System.out.println(temp1);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase15() 
	{
		System.out.println("+++ Test Case 15: using checkString with a null input. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println("[null] should not be valid");
		temp1.setTitle(null);
		System.out.println(temp1);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase16() 
	{
		System.out.println("+++ Test Case 16: Set a duration at the maximum time. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println("[999] should be valid");
		temp1.setDuration(999);
		System.out.println(temp1);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase17() 
	{
		System.out.println("+++ Test Case 17: Set a duration at above the maximum time. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println("[1000] should not be valid");
		temp1.setDuration(1000);
		System.out.println(temp1);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase18() 
	{
		System.out.println("+++ Test Case 18: Set a duration below the minimum time. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println("[-1] should not be valid");
		temp1.setDuration(-1);
		System.out.println(temp1);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void fileTestCase19() 
	{
		System.out.println("+++ Test Case 21: Set a play count below the minimum time. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println("[-1] should not be valid");
		temp1.setPlayCount(-1);
		System.out.println(temp1);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
}
