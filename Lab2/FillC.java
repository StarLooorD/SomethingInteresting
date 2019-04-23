import java.util.List;
import java.util.Scanner;

public class FillC {
    public void filling (List<String> Container){

        Scanner listf = new Scanner(System.in);

        System.out.print("Input number of elements of container: ");
        
        int number = listf.nextInt();
        
        System.out.println("Input elements of container: ");
        
        for (int i = 0; i <= number; i++) {
            String l = listf.nextLine();
            Container.add(l);
        }
        
        Container.remove(0);
        
        System.out.println(Container);

    }

}