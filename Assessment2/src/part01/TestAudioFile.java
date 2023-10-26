package part01;

import audio.AudioPlayer;
import menu.Menu;

public class TestAudioFile {

	public static void main(String[] args) {
		AudioPlayer player = new AudioPlayer();
		String options[] = { "The audio player is working if you hear this message.", "Add your own audio.",
				"Use of the audio player is not essential", "Quit" };
		Menu audioMenu = new Menu("Audio Player Demo", options);
		

		int choice = audioMenu.getUserChoice();
		while (choice != 4) {
			
				switch (choice) {
				case 1:
					System.out.println(player.playFile("Sound\\TestingTesting123.wav")+"\n\n");
					break;
				case 2:
					System.out.println(player.playFile("Sound\\AddYourOwn.wav") + "\n\n");
					break;
				case 3:
					System.out.println(player.playFile("Sound\\NotEssential.wav") + "\n\n");
					break;
				default:
					System.out.println("Invalid option: " + choice);
				}
			
			choice = audioMenu.getUserChoice();
		}
		System.out.println("Good bye!");

	}

}
