package phase1project;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

// Class for Main menu 
public class MainMenu {
	Scanner sc = new Scanner(System.in);
	int choice1,choice2; 
	// user interface method defined for the sub Menu Screen Display
	private void subMenu() 
	{	
		System.out.println("\t\t 1: To Add a new File please press 1");
		System.out.println("\t\t 2: To Delete an existing File please press 2");
		System.out.println("\t\t 3: To Search any File from the directory please press 3");
		System.out.println("\t\t 4: To navigate back to the Main menu please press 4");
	}
	// Main menu method defined 
	public void menuMain () 
	{   //.............Display Main Menu....................................
		System.out.println("\n\t.................Main Menu.................\n");
		System.out.println("\n\t1: To Display the existing files in the Directory please press 1");
		System.out.println("\n\t2: To Return any of the user interface operations please press 2:\n\t\t1. Add\n\t\t2. Delete\n\t\t3. Search\n\t\t4. Main Menu.");
		System.out.println("\n\t3: To Close the Application please press 3");
		// Option to choose any of the cases in the menu using switch()
        choice1 = sc.nextInt();
        switch(choice1) 
		{
		case 1: 
				System.out.println("\tYou have opted to Display the existing files in the Directory in the sort ascending order\n");
			try {
				fileDisplay();
			} 
			catch (NullPointerException e) {
				System.out.println("Exception occured"+e);
			} 
				break;
		case 2: 
				System.out.println("\tYou have opted to return any of the user interface Menu \n\tPlease choose any options below from 1 to 4");
			try {
				subMenu();
				choice2 = sc.nextInt();
			}
			catch (InputMismatchException e3) {
				System.out.println("Invallid input choice "+e3);
				
			}
				// inner switch cases to run the sub menu
				switch(choice2) 
				{
					case 1: 
							System.out.println("\tYou have opted to Add a new File in the Directory");
					try {
						createNewFile();
					} 
					catch (IOException e) {
						System.out.println("\tIncorrect Filename"+e);
					}
					catch(NullPointerException e) {
						System.out.println("\tFileName should not be null"+e);
					}
					    break;
		
					case 2: 
							System.out.println("\tYou have opted to Delete an existing File in the Directory");
					try {
						delete();
					} catch (NullPointerException  e1) {
						System.out.println("\tInvallid input"+e1);
					} catch (NoSuchFileException e) {
						
						System.out.println("\tNo file found"+e);
					} catch (DirectoryNotEmptyException e) {
						
						System.out.println("\tEmpty Directory"+e);
					} catch (IOException e) {
						
						System.out.println("\tInvallid"+e.getMessage());
					}
							break;			
					case 3: 
							System.out.println("\tYou have opted to Search any File in the Directory");
							try {
								searchFile();
							} 
							catch (FileNotFoundException | NullPointerException e) {
								System.out.println("\tInvallid input"+e);
							}
							break;
			
					case 4: 
							System.out.println("\tYou have opted to Navigate back to the Main menu");
					try {
						menuMain();
					} catch (InputMismatchException e2) {
						
						System.out.println("\tWrong input entered"+e2);
					}
					break;
					// invoke the sub menu for user interactions	
					default: 
						System.out.println("\tPlease press any of the options(1-4)");
						subMenu();
						choice2 = sc.nextInt();
						//Navigate back to Main menu
						if(choice2 == 4) {
						try {
							menuMain();
						} 
						catch (InputMismatchException e) {
							System.out.println(e.getMessage());
						}	
					    }
					
				    break;
				}
				break;
				//continue Main menu choice
		case 3: 
				System.out.println("\tYou have opted to Close the Application.\n\t\tThank You !");		
				System.exit(0);
				break;

		default: 
				System.out.println("\tSorry! Invalid option. Please press the correct options from 1 to 3");
			try {
				menuMain();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}
		}
             // exit from switch to continue or  not    
			 System.out.println("\tDo you want to continue? please Press digit 4");
			  choice2 = sc.nextInt();
			  if(choice2==4) {
				  menuMain();
			  }
			 else {
				 System.out.println("You choose to Exit!");
			     System.exit(0);
			 }
			 }
        
	// method to Display file names
	public void fileDisplay() throws NullPointerException {
		String[] files;
		File dir1 = new File("C:\\JavaPgm\\src\\phase1project\\Files");
		files = dir1.list();
		// Check the directory is empty or not
		if (files.length == 0) {
			System.out.println("\n\tThe directory is empty");
		} 
		else 
		{   // Add the files into the array list to sort ascending
			List<String> strList = new ArrayList<String>();
			for(int i = 0; i < files.length;i++) {
				strList.add(files[i]);
			}
			Collections.sort(strList);
			//print the files inside the string array list in ascending order
	        for(String string: strList) 
	        	System.out.println("\tFiiles in the sorted order "+string);
	   }
	}
	
	//create a new file
	public void createNewFile() throws IOException, NullPointerException {
		System.out.println("\n\tPlease enter a .txt file");
		sc.nextLine();
		String fileName = sc.nextLine().toLowerCase().trim();
		// to add the file inside the folder
		String path = "C:\\JavaPgm\\src\\phase1project\\Files";
		File fileNew = new File(path+"\\"+fileName);
		System.out.println("\tInside the path\t"+fileNew);
		if(fileNew.createNewFile()) {
			System.out.println("\tAdded a New File");
		}
		else {
			System.out.println("This File already existed");
		}
	}
	
	//Search a file
	public void searchFile() throws FileNotFoundException, NullPointerException{
		fileDisplay();
		int flag = 0;
		String path = "C:\\JavaPgm\\src\\phase1project\\Files";
		String[] fileList;
		File dir = new File(path);
		System.out.println("\n\tPlease Enter the file name you want to search in this folder eg:File1");
		sc.nextLine();
		String file = sc.nextLine().trim();
		fileList = dir.list();
		// Display File found in the list
		for(int i = 0; i < fileList.length; i++) {
			if(fileList[i].matches(file)) {
				System.out.println("\t\nFile is found \n\t"+path +"\\"+fileList[i]);
				flag = 1;
				break;
			}
		}
	    //display FNF
		if(flag == 0) {
			for(int i = 0; i < fileList.length; i++) {
				if(!fileList[i].matches(file)) {
					System.out.println("\n\tFileNotFound inside  \n\t"+path);
					break;
				}
			}
		}
	}
	
	//Permenantly delete a file
	public void delete() throws FileSystemException, NoSuchFileException, IOException, NullPointerException, DirectoryNotEmptyException {
		sc.nextLine();
		String path = "C:\\JavaPgm\\src\\phase1project\\Files\\";
	//	File dir = new File(path);
	   System.out.println("\tPlease enter the file to delete");
		String filePath = path +sc.nextLine();
		//System.out.println("\t"+filePath);
		Path path1 = Paths.get(filePath);
		System.out.println("\tFile Path -"+path1);
		Files.delete(path1);
		System.out.println("\n\tFile Deleted!");
	}
}		













