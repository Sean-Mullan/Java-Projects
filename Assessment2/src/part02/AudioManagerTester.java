package part02;

import java.util.ArrayList;

import audio.AudioPlayer;

public class AudioManagerTester 
{
	static AudioPlayer play = new AudioPlayer();
	static AudioManager Kieth = new AudioManager(play);
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//managerTestCase1();//Test to see if this loadAudio will add an audioFile to an arrayList of audioFiles
		managerTestCase2();//Test to see if this loadAudio will deny  an audioFile to an arrayList of audioFiles if it is null
		//managerTestCase3();//Test to see if the arraylist will allow a value that does not have the same data source as another file
		//managerTestCase4();//Test to see if the arraylist will deny a value that is does have the same data source as another file
		//managerTestCase5();//Test to see if the arraylist can remove a file using a code input
		//managerTestCase6();//Test to see if the arraylist will not delete a file if the code input does not match any file
		//managerTestCase7();//Test to see if the arraylist will deny a code input that isn't an int
		//managerTestCase8();//Test to see if the arraylist will deny a code input that doesn't have any data
		//managerTestCase9();//Test to see if a string array of audiofile references will be returned
		//managerTestCase10();//Test to see if the manager will play a file, chosen by a code, and increment the playcount from an arraylist
		//managerTestCase11();//Test to see if the manager will play a file, chosen by an invalid int code, and increment the playcount from an arraylist
		//managerTestCase12();//Test to see if the manager will play a file, chosen by an invalid data type, and increment the playcount from an arraylist
		//managerTestCase13();//Test to see if the manager will play a file, chosen by a null value, and increment the playcount from an arraylist
		//managerTestCase14();//Test to see if the manager will play a file that has been directly called, and increment the playcount
		//managerTestCase15();//Test to see if the manager will not play an invalid file that has been directly called, and not increment the playcount
		//managerTestCase16();//Test to see if the manager will not play an empty file that has been directly called, and not increment the playcount
		//managerTestCase17();//Test to see if the method will list the ten files with the greatest playcounts, in descending order
		//managerTestCase18();//Test to see if the method will list the files with the greatest playcounts, in descending order, of an array smaller than 10
		//managerTestCase19();//Test to see if the method will list the files with the greatest playcounts, in descending order, of an array larger than 10
		//managerTestCase20();//Test to see if the method will list the files with the greatest playcounts, in descending order, of an empty array
		//managerTestCase21();//Test to see if the method will assign a valid audioPlayer
		//managerTestCase22();//Test to see if the method will assign a null audioPlayer

	}
	
	private static void display()
	{
		String[] list = {};
		String[] newList = Kieth.getAllData(list);
		if(newList.length <= 0)
		{
			System.out.println("There are no files present");
		}
		else
		{
			for (int i = 0; i < newList.length; i++)
			{
				System.out.println(newList[i]);
			}
		}
		System.out.println();
	}
	
	private static void managerTestCase1() 
	{
		System.out.println("+++ Test Case 1: Add valid audiofile to arraylist. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		Kieth.loadAudio(temp1);
		System.out.println("File should now be printed in manager");
		display();
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase2() 
	{
		System.out.println("+++ Test Case 2: Add null audiofile to arraylist. +++++++");
		AudioFile temp1 = new AudioFile("",0,"");
		System.out.println(temp1);
		Kieth.loadAudio(temp1);
		System.out.println("File should not have been added");
		display();
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase3() 
	{
		System.out.println("+++ Test Case 3: Check for duplicates, find none. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"sert");
		AudioFile temp2 = new AudioFile("bert",24,"bert");
		AudioFile temp3 = new AudioFile("curt",46,"curt");
		System.out.println(temp1);
		System.out.println(temp2);
		System.out.println(temp3);
		Kieth.loadAudio(temp1);
		Kieth.loadAudio(temp2);
		Kieth.loadAudio(temp3);
		System.out.println("All files should be added to the manager");
		display();
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase4() 
	{
		System.out.println("+++ Test Case 4: Check for duplicates, find one. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		AudioFile temp2 = new AudioFile("wert",23,"wert");
		System.out.println(temp1);
		System.out.println(temp2);
		Kieth.loadAudio(temp1);
		Kieth.loadAudio(temp2);
		System.out.println("The 2nd file should not be added to the manager");
		display();
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase5() 
	{
		System.out.println("+++ Test Case 5: Delete a valid file. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		AudioFile temp2 = new AudioFile("bert",24,"bert");
		Kieth.loadAudio(temp1);
		Kieth.loadAudio(temp2);
		display();
		System.out.println("Now deleting bert");
		Kieth.deleteAudio(temp2.getCode()-1);
		display();
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase6() 
	{
		System.out.println("+++ Test Case 6: Delete a file with an invalid code. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		AudioFile temp2 = new AudioFile("bert",24,"bert");
		Kieth.loadAudio(temp1);
		Kieth.loadAudio(temp2);
		System.out.println("Trying to delete file of code 34, it should delete nothing");
		Kieth.deleteAudio(34);
		display();
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase7() 
	{
		System.out.println("+++ Test Case 7: Delete a file with an invalid data type. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		AudioFile temp2 = new AudioFile("bert",24,"bert");
		Kieth.loadAudio(temp1);
		Kieth.loadAudio(temp2);
		System.out.println("Trying to delete file of code wert, it should delete nothing");
		Kieth.deleteAudio(34);//wert cannot be entered
		display();
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase8() 
	{
		System.out.println("+++ Test Case 8: Delete a file with a null code. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		AudioFile temp2 = new AudioFile("bert",24,"bert");
		Kieth.loadAudio(temp1);
		Kieth.loadAudio(temp2);
		System.out.println("Trying to delete file of code 0, it should delete nothing");
		Kieth.deleteAudio(0-1);
		display();
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase9() 
	{
		System.out.println("+++ Test Case 9: Display all in a Manager. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		AudioFile temp2 = new AudioFile("bert",24,"bert");
		Kieth.loadAudio(temp1);
		Kieth.loadAudio(temp2);
		System.out.println("Should be able to list all files");
		display();
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase10() 
	{
		System.out.println("+++ Test Case 10: Play a file using a valid code. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"Sound\\TestingTesting123.wav");
		Kieth.loadAudio(temp1);
		display();
		System.out.println("Trying to play wert, using code 1, and incrementing play count");
		Kieth.play(temp1.getCode());
		display();
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase11() 
	{
		System.out.println("+++ Test Case 11: Play a file using an invalid code. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"Sound\\TestingTesting123.wav");
		Kieth.loadAudio(temp1);
		System.out.println("Trying to play file of code 27, it should increment nothing");
		Kieth.play(27);
		display();
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase12() 
	{
		System.out.println("+++ Test Case 12: Play a file using an invalid data type. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		AudioFile temp2 = new AudioFile("bert",24,"bert");
		Kieth.loadAudio(temp1);
		Kieth.loadAudio(temp2);
		System.out.println("Trying to play file of code wert, it should increment nothing");
		Kieth.play(34);//wert cannot be entered
		display();
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase13() 
	{
		System.out.println("+++ Test Case 13: Play a file using a null code. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"wert");
		AudioFile temp2 = new AudioFile("bert",24,"bert");
		Kieth.loadAudio(temp1);
		Kieth.loadAudio(temp2);
		System.out.println("Trying to delete file of code 0, it should increment nothing");
		Kieth.deleteAudio(0-1);
		display();
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase14() 
	{
		System.out.println("+++ Test Case 14: Play a file by referencing it directly. +++++++");
		AudioFile temp1 = new AudioFile("wert",23,"Sound\\TestingTesting123.wav");
		Kieth.loadAudio(temp1);
		System.out.println("Trying to play wert's file, it should increment");
		Kieth.play(temp1);
		display();
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase15() 
	{
		System.out.println("+++ Test Case 15: Play a file using an invalid file. +++++++");
		AudioFile temp1 = new AudioFile("wert",-1,"wert");
		System.out.println(temp1);
		Kieth.loadAudio(temp1);
		System.out.println("Trying to play wert's file, it should not increment");
		Kieth.play(temp1);
		display();
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase16() 
	{
		System.out.println("+++ Test Case 16: Play a file using a null file. +++++++");
		AudioFile temp1 = new AudioFile(null,0,null);
		Kieth.loadAudio(temp1); //the null file cannot be added
		System.out.println("Trying to play null's file, it should not increment");
		Kieth.play(temp1);
		display();
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase17() 
	{
		System.out.println("+++ Test Case 17: Test topTen with a valid array. +++++++");
		loadData();
		System.out.println("Before:");
		display();
		System.out.println("After");
		String topTen = Kieth.topTen();
		System.out.println(topTen);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase18() 
	{
		System.out.println("+++ Test Case 18: Test topTen with an array smaller than 10. +++++++");
		lesserloadData();
		System.out.println("Before:");
		display();
		System.out.println("After");
		String topTen = Kieth.topTen();
		System.out.println(topTen);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase19() 
	{
		System.out.println("+++ Test Case 19: Test topTen with an array greater than 10. +++++++");
		greaterloadData();
		System.out.println("Before:");
		display();
		System.out.println("After");
		String topTen = Kieth.topTen();
		System.out.println(topTen);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase20() 
	{
		System.out.println("+++ Test Case 20: Test topTen with an empty array. +++++++");
		System.out.println("Before:");
		display();
		System.out.println("After");
		String topTen = Kieth.topTen();
		System.out.println(topTen);
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase21() 
	{
		System.out.println("+++ Test Case 21: Set a valid AudioPlayer to Manager. +++++++");
		AudioPlayer temp = new AudioPlayer();
		Kieth.setPlayer(temp);
		System.out.println("If this message is printed, the player was successfully set");
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void managerTestCase22() 
	{
		System.out.println("+++ Test Case 22: Set a null AudioPlayer to Manager. +++++++");
		Kieth.setPlayer(null);
		System.out.println("An invalid message should be above");
		System.out.println("+++ End Test Case ++++++++++++++++++++++++\n");
	}
	
	private static void loadData()
	{
		AudioFile temp1 = new AudioFile("wert",23,"Sound\\TestingTesting123.wav");
		AudioFile temp2 = new AudioFile("bert",23,"Sound\\NotEssential.wav");
		AudioFile temp3 = new AudioFile("curt", 23,"Sound\\AddYourOwn.wav");
		AudioFile temp4 = new AudioFile("curt", 23,"ound\\AddYourOwn.wav");
		AudioFile temp5 = new AudioFile("curt", 23,"Sund\\AddYourOwn.wav");
		AudioFile temp6 = new AudioFile("curt", 23,"Sond\\AddYourOwn.wav");
		AudioFile temp7 = new AudioFile("curt", 23,"Soud\\AddYourOwn.wav");
		AudioFile temp8 = new AudioFile("curt", 23,"Soun\\AddYourOwn.wav");
		AudioFile temp9 = new AudioFile("curt", 23,"Sound\\ddYourOwn.wav");
		AudioFile temp10 = new AudioFile("curt", 23,"Sound\\AdYourOwn.wav");
		Kieth.play(temp1);
		Kieth.play(temp1);
		Kieth.play(temp1);
		Kieth.play(temp3);
		Kieth.loadAudio(temp1);
		Kieth.loadAudio(temp2);
		Kieth.loadAudio(temp3);
		Kieth.loadAudio(temp4);
		Kieth.loadAudio(temp5);
		Kieth.loadAudio(temp6);
		Kieth.loadAudio(temp7);
		Kieth.loadAudio(temp8);
		Kieth.loadAudio(temp9);
		Kieth.loadAudio(temp10);
	}
	
	private static void lesserloadData()
	{
		AudioFile temp1 = new AudioFile("wert",23,"Sound\\TestingTesting123.wav");
		AudioFile temp2 = new AudioFile("bert",23,"Sound\\NotEssential.wav");
		AudioFile temp3 = new AudioFile("curt", 23,"Sound\\AddYourOwn.wav");
		Kieth.play(temp1);
		Kieth.play(temp1);
		Kieth.play(temp1);
		Kieth.play(temp3);
		Kieth.loadAudio(temp1);
		Kieth.loadAudio(temp2);
		Kieth.loadAudio(temp3);
	}
	
	private static void greaterloadData()
	{
		AudioFile temp1 = new AudioFile("wert",23,"Sound\\TestingTesting123.wav");
		AudioFile temp2 = new AudioFile("bert",23,"Sound\\NotEssential.wav");
		AudioFile temp3 = new AudioFile("curt", 23,"Sound\\AddYourOwn.wav");
		AudioFile temp4 = new AudioFile("curt", 23,"ound\\AddYourOwn.wav");
		AudioFile temp5 = new AudioFile("curt", 23,"Sund\\AddYourOwn.wav");
		AudioFile temp6 = new AudioFile("curt", 23,"Sond\\AddYourOwn.wav");
		AudioFile temp7 = new AudioFile("curt", 23,"Soud\\AddYourOwn.wav");
		AudioFile temp8 = new AudioFile("curt", 23,"Soun\\AddYourOwn.wav");
		AudioFile temp9 = new AudioFile("curt", 23,"Sound\\ddYourOwn.wav");
		AudioFile temp10 = new AudioFile("curt", 23,"Sound\\AdYourOwn.wav");
		AudioFile temp11 = new AudioFile("curt", 23,"Sound\\AddourOwn.wav");
		Kieth.play(temp1);
		Kieth.play(temp1);
		Kieth.play(temp1);
		Kieth.play(temp3);
		Kieth.loadAudio(temp1);
		Kieth.loadAudio(temp2);
		Kieth.loadAudio(temp3);
		Kieth.loadAudio(temp4);
		Kieth.loadAudio(temp5);
		Kieth.loadAudio(temp6);
		Kieth.loadAudio(temp7);
		Kieth.loadAudio(temp8);
		Kieth.loadAudio(temp9);
		Kieth.loadAudio(temp10);
		Kieth.loadAudio(temp11);
	}
}
