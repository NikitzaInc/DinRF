package main;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.JFrame;
import java.io.IOException;
import java.nio.file.Paths;

public class Main extends JFrame {
    public static Main frame;
    int status = 1;
    //STATUSES:
    //1 - menu
    //2 - map
    //3 - information about the region
    //4 - select region for comparison 0/3
    //5 - select region for comparison 1/3
    //6 - select region for comparison 2/3
    //7 - comparison results

    //region number, used to display information about the region
    int regionNumber;

    //arrays in which data is written for comparison
    int[] compareChange = new int[3];
    String[] compareName = new String[3];

    private static final ObjectMapper mapper = new ObjectMapper();
    RegionsData[] regions;

    {
        try {
            regions = mapper.readValue(Paths.get("regions.JSON").toFile(),  RegionsData[].class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

 public static void main(String[] args) {
     System.out.println("Start");
     System.out.println("Created by Nikitza Inc");
     System.out.println();
     frame = new Main();
     frame.setTitle("Демонстратор изменения населения РФ");
     frame.setSize(1280, 720);
     frame.getContentPane();
     frame.setResizable(false);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     Pole pole = new Pole();
     frame.addMouseListener(new ClickListener(frame));
     frame.add(pole);
     frame.setVisible(true);
     pole.setLayout(null);
 }

 public void start () {
     //displaying a window with a map
    status = 2;
}
public void info(){
     //displaying a window with information about the region (see Pole.java, line 275)
    status = 3;
 }
 public void comparison(){
     status = 4;
     
     //Selection procedure for comparison (statuses 4-6) and comparison totals (status 7)
     if (compareChange[0] != 0 && compareChange[1] == 0 && compareChange[2] == 0) {
         status = 5;
         System.out.println("Region chosen, " + compareName[0]+", 1/3");
         System.out.println("Убыль в регионе: "+ compareChange[0]);
         System.out.println("Status " +status);
     }
     else if (compareChange[0] != 0 && compareChange[1] != 0 && compareChange[2] == 0) {
         status = 6;
         System.out.println("Region chosen, " + compareName[1]+", 2/3");
         System.out.println("Убыль в регионе: "+ compareChange[1]);
         System.out.println("Status " +status);
     }
     else if (compareChange[0] != 0 && compareChange[1] != 0) {
         status = 7;
         System.out.println("Region chosen, " + compareName[2]+", 3/3");
         System.out.println("Убыль в регионе: "+ compareChange[2]);
         System.out.println("Status " +status);
     }
     
 }
}
