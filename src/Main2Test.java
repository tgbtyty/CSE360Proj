import java.io.*;
import java.math.*;
import java.util.*;

public class Main2Test {

    public static void main(String [ ] args)
    {
        String name = "";
        int age = 0;
        int lock = 0;
        boolean Cont = true;


        System.out.println("Welcome to the Data Entry Form!");
        ArrayList<Entry> entries = new ArrayList<Entry>();
        Scanner entryScan = new Scanner(System.in);


        while(Cont) {
            entryScan.nextLine();
            System.out.println("Please Enter the Name of your Entry:");
            name = entryScan.nextLine();
            System.out.println("Please Enter the Age of your Entry:");
            System.out.println("THIS MUST BE AN INTEGER");
            age = entryScan.nextInt();
            Entry temp = new Entry(name, age);
            entries.add(temp);
            System.out.println("Do you wish to add another entry? 0 for yes 1 for no");
            lock = entryScan.nextInt();
            if (lock == 1){
                Cont = false;
            }

        }

        try {
            FileOutputStream fileout = new FileOutputStream("entrydata.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(fileout);
            for (int i = 0; i < entries.size(); i++){
                Entry tempob = entries.get(i);
                writeStream.writeObject(tempob);
                writeStream.flush();
            }
            writeStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("These are your Entries:\n\n");
        for (int i = 0; i < entries.size(); i++){
            System.out.println(entries.get(i).name + "\n");
            System.out.println(entries.get(i).age + "\n\n");
        }


    }

}
class Entry implements Serializable {
    public String name;
    public int age;
    public Entry(String a, int b){
        name = a;
        age = b;
    }

}
