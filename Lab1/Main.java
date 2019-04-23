package Lab1;

import java.util.Scanner;

public class Main {

	public static void report(boolean helper,boolean debugger,int sent,String temp,StringBuffer temp2) {
		System.out.println();
		System.out.println("Debugger menu: ");
		System.out.println("Helper: " + helper);
		System.out.println("Debugger " + debugger);
		System.out.println("Sentences: " + sent);
		System.out.println("Temp string: " + temp);
		System.out.println("Temp string buffer: " + temp2);
		System.out.println();
	}
	
	public static void main(String[] args) {
		boolean helper = false;
		boolean debugger = false;
		int sent = 0;
		
		if (args != null) {
			for (String x: args) {
				if (x.equals ("-help") || x.equals ("-h") ) {
				 helper = true;
				}
				if(x.equals ("-debugger") || x.equals ("-d") ) {
				 debugger = true; 
				}
			}
		}
		
		if (helper == true) {
			System.out.println("Lab 1 OOP || CS-109 || T.Hrechukh || VAR - 2");
			System.out.println("Program by Giant Marshmello!");
			System.out.println("Main task:");
			System.out.println("Enter some lines of text");
			System.out.println("Sort them by alphabet and string lenght.");
		}
		
		if (debugger == true) {
			
			System.out.println("\nDebuggering!");
		}
		
		Scanner mySc = new Scanner(System.in);
	    
	    StringBuffer sb[] = new StringBuffer[50];
	    StringBuffer temp2 =  new StringBuffer(100);
	    
	    for (int i = 0; i < 50; i++) {
	    	sb[i] = new StringBuffer(100);
	    }
		
	    String temp = null;
		
	int command;
	
	while (true) {
	      System.out.println();
	      System.out.println("1- input");
	      System.out.println("2- show the input");
	      System.out.println("3- calculate");
	      System.out.println("4- show the result");
	      System.out.println("5- exit");
	      System.out.print("Command: ");
	      
	      command = mySc.nextInt();
	      mySc.nextLine();
	      
	      switch (command) {
	      
	        case 1:
	          if (debugger) {
	            report(helper, debugger, sent, temp, temp2);
	          }
	          System.out.println("Please input number of sentences you want to use:");
	  		
	  		  sent = mySc.nextInt();
	  		
	  	      System.out.println("Please input your sentences, by ENTER:");
	  	
	  	      mySc.nextLine();
	  	      
	          for (int i = 0; i < sent; i++) {
	  			temp = mySc.nextLine();
	  			sb[i].append(temp);
	  		  }
	          break;
	          
	        case 2:
	          if (debugger) {
	            report(helper, debugger, sent, temp, temp2);
	          }
	          for (int i = 0; i < sent; i++) {
	  			System.out.println(sb[i]);
	  		  }
	          break;
	          
	        case 3:
	          if (debugger) {
	            report(helper, debugger, sent, temp, temp2);
	          }
	          for (int i = 0; i < sent; i++) {
	  			for (int j = 0; j < sent - i - 1; j++) {
	  				if (sb[j].charAt(0) > sb[j + 1].charAt(0)) {
	  					temp2 = sb[j];
	  					sb[j] = sb[j + 1];
	  					sb[j + 1] = temp2;
	  				}
	  				else if (sb[j].charAt(0) == sb[j + 1].charAt(0)) {
	  					if (sb[j].length() > sb[j + 1].length()) {
	  						temp2 = sb[j];
	  						sb[j] = sb[j + 1];
	  						sb[j + 1] = temp2;
	  					}
	  				}
	  			}
	  		 }
	          if (debugger) {
		            report(helper, debugger, sent, temp, temp2);
		          }
	          break;
	          
	        case 4:
	          if (debugger) {
	            report(helper, debugger, sent, temp, temp2);
	          }
	          for (int i = 0; i < sent; i++) {
	  			System.out.println(sb[i]);
	  		  }
	          break;
	          
	        case 5:
	          mySc.close();
	          System.out.println();
	          System.out.println("Exiting program");
	          System.exit(0);
	        default:
	          System.out.println("Wrong command");
	          break;
	      }
	  }
	}
}
