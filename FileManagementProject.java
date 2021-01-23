package phase1project;
import java.util.Scanner;

public class FileManagementProject {
	   
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		//..............Welcome Screen Display.......................
		System.out.println("...............Welcome to File Management Project....................");
		System.out.println("\nApplication name:\tLockedMe.com");
		System.out.println("\nDeveloper name :\tSwapna Anna Samuel");
		System.out.println("Please enter your name");
		// Read the name of the user
		String user = sc.nextLine();
		System.out.println("\n\tWelcome "+ user+"!"+" Please press any of the options listed inside the Main Menu");
		// invoke the Main menu method
		MainMenu menu1 = new MainMenu();
		try {
				 menu1.menuMain();
			} 
			catch (Exception e) {
				System.out.println("Invalid input "+e.getMessage());
				System.out.println("Closing App");
				sc.close();
			}
	}
}

