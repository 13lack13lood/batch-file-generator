import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("(Enter changeBatchName (not case senstive) to change the name of the batch file)\nEnter java file name (include .java):");
		String name = scanner.next();
		String batch = "run " + name.replace(".java", "").replaceAll(".", "") + ".bat";
		
		if(name.toLowerCase().contentEquals("changebatchname")) {
			System.out.println("Enter new batch file name (you can include spaces and don't include .bat):");
			
			scanner.nextLine();
			batch = scanner.nextLine() + ".bat";
			
			System.out.println("Enter name of java file (include .java)");
			name = scanner.next();
		}
		
		try {
			while(true) {
				File file = new File(batch);
				
				if (file.createNewFile()) {
			        	System.out.println("File created: " + file.getName());
			        	break;
			    	} else {
			    		System.out.print("File already exists. Re-run the program.");
			    		System.exit(0);
			   	}
			}
		} catch (Exception e) {
			System.out.print("\nSomething broke\nHere is the error:\n");
			e.printStackTrace();
			System.exit(0);
		}
		
		try {
			System.out.println("Attempting to write file...");
			
			FileWriter writer = new FileWriter(batch);
			writer.write("@echo off"
					+ "\njavac " + name
					+ "\njava " + name.substring(0, name.indexOf(".java"))
					+ "\npause");
			writer.close();
		} catch (Exception e) {
			System.out.print("You probably didn't put .java at the end\nHere is the error:"
					+ "\n(if any of this is cut off that means that more stuff probably broke)\n\n");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.println("Done!");
		
		scanner.close();
	}
	
}
