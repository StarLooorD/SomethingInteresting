import java.io.*;
import java.util.List;

public class Save {

    public static void saving(List<String> Container) throws Exception {
        FileOutputStream FileOutputStream = new FileOutputStream("tempFile");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(FileOutputStream);
        objectOutputStream.writeObject(Container);
        objectOutputStream.close();

    }
}