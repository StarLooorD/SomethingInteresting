import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.util.List;

public class Main implements Serializable{
	
	 static final long serialVersionUID = 1L;

	private static void printMenu (){
        System.out.println("<<<<<<<<<<<<  Menu  >>>>>>>>>>>>>>");
        System.out.println("<                                >");
        System.out.println("< 1 - Fill my container          >");
        System.out.println("< 2 - Container methods          >");
        System.out.println("< 3 - Show my container          >");
        System.out.println("< 4 - Save my container          >");
        System.out.println("< 5 - Output my saved container  >");
        System.out.println("< 6 - Iterate                    >");
        System.out.println("< 7 - Exit                       >");
        System.out.println("<                                >");
        System.out.println("<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>");
    }
	
	
    public static void main(String[] args) {

        printMenu();
        Scanner scan = new Scanner(System.in);
        //ArrayList<FillC> ContainerList = new ArrayList<>();
        byte command;

        List<String> Contain = new ArrayList<>();
        Scanner list = new Scanner(System.in);
        Scanner serv = new Scanner(System.in);

        while (true) {
            command = scan.nextByte();
            switch (command) {
            
                case 1:
                    FillC fill = new FillC();
                    fill.filling(Contain);

                    printMenu();
                    break;
                    
                case 2:
                    System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" +
                            "\n<           Methods:           >" +
                            "\n< 1 - toString                 >" +
                            "\n< 2 - add                      >" +
                            "\n< 3 - clear                    >" +
                            "\n< 4 - remove                   >" +
                            "\n< 5 - toArray                  >" +
                            "\n< 6 - size                     >" +
                            "\n< 7 - contains                 >" +
                            "\n< 8 - sort                     >" +
                            "\n< 9 - search                   >" +
                            "\n< 10 - go back                 >" +
                            "\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
                    
                    int ch1 = list.nextInt();
                    
                    if (ch1 == 1) {              
                        String result = String.join("; ", Contain);
                        System.out.println(result);
                    }
                    
                    if (ch1 == 2) {
                        System.out.print("Srting to add: ");
                        String adds = serv.nextLine();
                        Contain.add(adds);
                    }
                    
                    if (ch1 == 3) {
                        Contain.clear();
                    }
                    
                    if (ch1 == 4) {
                        System.out.println("What to remove?" +
                                "\n 1 - index \t 2 - item");
                        int rem = list.nextInt();
                        if (rem == 1) {
                            int index = serv.nextInt();
                            Contain.remove(rem);
                        } else if (rem == 2) {
                            String item = serv.nextLine();
                            Contain.remove(item);
                        }
                    }
                    
                    if (ch1 == 5) {
                        Object[] array = Contain.toArray();
                        System.out.println(Arrays.toString(array));
                    }
                    
                    if (ch1 == 6) {
                        System.out.println(Contain.size());
                    }
                    
                    if (ch1 == 7) {
                        System.out.println("What item to chach? ");
                        String chack = serv.nextLine();
                        System.out.println(Contain.contains(chack));
                    }
                    
                    if (ch1 == 8) {
                        Collections.sort(Contain);
                    }
                    
                    if (ch1 == 9) {
                        System.out.print("What to search? ");
                        String toFind = serv.nextLine();
                        Object[] array = Contain.toArray();
                        String arr = Arrays.toString(array);
                        System.out.println(Arrays.binarySearch(array, toFind));
                    }
                    
                    if (ch1 == 10) {
                        printMenu();
                    }

                    printMenu();
                    break;
                    
                case 3:
                    System.out.println(Contain);
                    
                    printMenu();
                    break;
                    
                case 4:
                 
                    System.out.println("Saving...");	
                	
				    FileOutputStream fileOutputStream = null;
				    try {
					    fileOutputStream = new FileOutputStream("MyFile");
				    } catch (FileNotFoundException e1) {
					    e1.printStackTrace();
				    }
				    ObjectOutputStream objectOutputStream = null;
				    try {
					    objectOutputStream = new ObjectOutputStream(fileOutputStream);
				    } catch (IOException e1) {
					    e1.printStackTrace();
				    }
				    try {
					    objectOutputStream.writeObject(Contain);
				    } catch (IOException e) {
					    e.printStackTrace();
				    }
				    try {
					    objectOutputStream.close();
				    } catch (IOException e) {					
					    e.printStackTrace();
				    }
                	
                    printMenu();
                    break;

                case 5:
                     
                	FileInputStream fileInputStream = null;
                	ObjectInputStream objectInputStream = null;
                	
                	try {
                		  fileInputStream = new FileInputStream("MyFile");
                          objectInputStream = new ObjectInputStream(fileInputStream);
                		      
                 	      ArrayList temp = (ArrayList) objectInputStream.readObject();
                 	      objectInputStream.close();
                		      
               		      Contain = temp;
                		     
                		  } catch (Exception e) {
                	      System.out.println("Error");    
                    }
                	
                    printMenu();
                    break;
                    
                case 6:
                	
                    for(String x: Contain)	
                    	System.out.println(x);
                    
                    Iterator<String> iterator = Contain.iterator();
                    while (iterator.hasNext()){
                           System.out.println(iterator.next());
                    }

                    printMenu();
                    break;
                    
                case 7:
                    System.out.println("See you soon!!!");
                    System.exit(0);
                    
                default:
                    System.err.println("Wrong input!");

            }


        }
    }
}