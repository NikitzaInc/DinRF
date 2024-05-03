package main;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static main.Main.frame;

public class ClickListener implements MouseListener {

    public ClickListener(Main frame){
    }

   @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        boolean isOneClick = e.getClickCount() == 1;
    //Yes, I'm an idiot. It was possible to avoid creating a lot of "if" statements but when I started doing this project, I didn't understand it.
    //Now I don't have enough to make it right.
    //But then there will be something to update -_-

    //method to check if the click (X,Y) was made is inside the field

        //exit from the program
        if(isOneClick && e.getX() >  490 && e.getX() < 850 && e.getY() > 555 && e.getY() < 665 && frame.status == 1){
            System.out.println("Program closed");
            System.out.println("Here I am");
            System.exit(0);
        }

        //exit from map to menu
        else if(isOneClick && e.getX() >  1000 && e.getX() < 1265 && e.getY() > 615 && e.getY() < 700 && frame.status > 1){
            System.out.println("Map closed");
            frame.compareChange[0] = 0;
            frame.compareChange[1] = 0;
            frame.compareChange[2] = 0;
            frame.compareName[0] = "NULL";
            frame.compareName[1] = "NULL";
            frame.compareName[2] = "NULL";
            frame.status = 1;
        }

        //exit from region info window
        else if(isOneClick && e.getX() >  705 && e.getX() < 860 && e.getY() > 585 && e.getY() < 670 && frame.status == 3){
            System.out.println("Region info closed");
            frame.status = 2;
        }

        //region comparison start
        else if(isOneClick && e.getX() >  14 && e.getX() < 260 && e.getY() > 629 && e.getY() < 698 && frame.status == 2){
            System.out.println("Comparison mode");
            System.out.println("Region chosen 0/3");
            frame.comparison();
        }

        //region comparison exit
        else if(isOneClick && e.getX() >  432 && e.getX() < 524 && e.getY() > 633 && e.getY() < 702 && frame.status > 3 && frame.status < 7){
            System.out.println("Comparison mode closed");
            frame.status = 2;
            frame.compareChange[0] = 0;
            frame.compareChange[1] = 0;
            frame.compareChange[2] = 0;
            frame.compareName[0] = "NULL";
            frame.compareName[1] = "NULL";
            frame.compareName[2] = "NULL";
        }

        //exit from comparison results window
        else if(isOneClick && e.getX() >  845 && e.getX() < 997 && e.getY() > 548 && e.getY() < 618&& frame.status == 7){
            System.out.println("Comparison info closed");
            frame.status = 2;
            frame.compareChange[0] = 0;
            frame.compareChange[1] = 0;
            frame.compareChange[2] = 0;
            frame.compareName[0] = "NULL";
            frame.compareName[1] = "NULL";
            frame.compareName[2] = "NULL";

        }

        //REGIONS
        //first else if statement is used to open specific region info window
        //Second else if statement is used to choose the region for comparison
        //I know, my code is terrible, sorry
        else if(isOneClick && e.getX() >  78 && e.getX() < 94 && e.getY() > 355 && e.getY() < 364 && frame.status == 2){
            frame.info();
            frame.regionNumber = 0;
            System.out.println("Belgorodskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  78 && e.getX() < 94 && e.getY() > 355 && e.getY() < 364 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 0;
            frame.compareChange[frame.status - 4] = frame.regions[0].getChange();
            frame.compareName[frame.status - 4] = frame.regions[0].getName();
            frame.comparison();
            System.out.println("Belgorodskaya obl. chosen, region number "+frame.regionNumber);
        }

        else if(isOneClick && e.getX() >  75 && e.getX() < 92 && e.getY() > 316 && e.getY() < 330 && frame.status == 2){
            frame.info();
            frame.regionNumber = 2-1;
            System.out.println("Bryanskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  75 && e.getX() < 92 && e.getY() > 316 && e.getY() < 330 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 2-1;
            frame.compareChange[frame.status - 4] = frame.regions[1].getChange();
            frame.compareName[frame.status - 4] = frame.regions[1].getName();
            frame.comparison();
            System.out.println("Bryanskaya obl. chosen, region number "+frame.regionNumber);
        }

        else if(isOneClick && e.getX() >  133 && e.getX() < 148 && e.getY() > 324 && e.getY() < 337 && frame.status == 2){
            frame.info();
            frame.regionNumber = 3-1;
            System.out.println("Vladimirskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  133 && e.getX() < 148 && e.getY() > 324 && e.getY() < 337 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 3-1;
            frame.compareChange[frame.status - 4] = frame.regions[2].getChange();
            frame.compareName[frame.status - 4] = frame.regions[2].getName();
            frame.comparison();
            System.out.println("Vladimirskaya obl. chosen, region number "+frame.regionNumber);
        }

        else if(isOneClick && e.getX() >  95 && e.getX() < 109 && e.getY() > 364 && e.getY() < 374 && frame.status == 2){
            frame.info();
            frame.regionNumber = 4-1;
            System.out.println("Voronezhskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  95 && e.getX() < 109 && e.getY() > 364 && e.getY() < 374 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 4-1;
            frame.compareChange[frame.status - 4] = frame.regions[3].getChange();
            frame.compareName[frame.status - 4] = frame.regions[3].getName();
            frame.comparison();
            System.out.println("Voronezhskaya obl. chosen, region number "+frame.regionNumber);
        }

        else if(isOneClick && e.getX() >  149 && e.getX() < 162 && e.getY() > 321 && e.getY() < 332 && frame.status == 2){
            frame.info();
            frame.regionNumber = 5-1;
            System.out.println("Ivanovskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  149 && e.getX() < 162 && e.getY() > 321 && e.getY() < 332 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 5-1;
            frame.compareChange[frame.status - 4] = frame.regions[4].getChange();
            frame.compareName[frame.status - 4] = frame.regions[4].getName();
            frame.comparison();
            System.out.println("Ivanovskaya obl. chosen, region number "+frame.regionNumber);
        }

        else if(isOneClick && e.getX() >  96 && e.getX() < 114 && e.getY() > 314 && e.getY() < 326 && frame.status == 2){
            frame.info();
            frame.regionNumber = 6-1;
            System.out.println("Kaluzhskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  96 && e.getX() < 114 && e.getY() > 314 && e.getY() < 326 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 6-1;
            frame.compareChange[frame.status - 4] = frame.regions[5].getChange();
            frame.compareName[frame.status - 4] = frame.regions[5].getName();
            frame.comparison();
            System.out.println("Kaluzhskaya obl. chosen, region number "+frame.regionNumber);
        }

        else if(isOneClick && e.getX() >  166 && e.getX() < 180 && e.getY() > 314 && e.getY() < 327 && frame.status == 2){
            frame.info();
            frame.regionNumber = 7-1;
            System.out.println("Kostromskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  166 && e.getX() < 180 && e.getY() > 314 && e.getY() < 327 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 7-1;
            frame.compareChange[frame.status - 4] = frame.regions[6].getChange();
            frame.compareName[frame.status - 4] = frame.regions[6].getName();
            frame.comparison();
            System.out.println("Kostromskaya obl. chosen, region number "+frame.regionNumber);
        }

        else if(isOneClick && e.getX() >  76 && e.getX() < 95 && e.getY() > 337 && e.getY() < 348 && frame.status == 2){
            frame.info();
            frame.regionNumber = 8-1;
            System.out.println("Kurskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  76 && e.getX() < 95 && e.getY() > 337 && e.getY() < 348 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 8-1;
            frame.compareChange[frame.status - 4] = frame.regions[7].getChange();
            frame.compareName[frame.status - 4] = frame.regions[7].getName();
            frame.comparison();
            System.out.println("Kurskaya obl. chosen, region number "+frame.regionNumber);
        }

        else if(isOneClick && e.getX() >  103 && e.getX() < 115 && e.getY() > 345 && e.getY() < 354 && frame.status == 2){
            frame.info();
            frame.regionNumber = 9-1;
            System.out.println("Lipetskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  103 && e.getX() < 115 && e.getY() > 345 && e.getY() < 354 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 9-1;
            frame.compareChange[frame.status - 4] = frame.regions[8].getChange();
            frame.compareName[frame.status - 4] = frame.regions[8].getName();
            frame.comparison();
            System.out.println("Lipetskaya obl. chosen, region number "+frame.regionNumber);
        }

        else if(isOneClick && e.getX() >  117 && e.getX() < 133 && e.getY() > 322 && e.getY() < 334 && frame.status == 2){
            frame.info();
            frame.regionNumber = 10-1;
            System.out.println("Moskowskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  117 && e.getX() < 133 && e.getY() > 322 && e.getY() < 334 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 10-1;
            frame.compareChange[frame.status - 4] = frame.regions[9].getChange();
            frame.compareName[frame.status - 4] = frame.regions[9].getName();
            frame.comparison();
            System.out.println("Moskowskaya obl. chosen, region number "+frame.regionNumber);
        }

        else if(isOneClick && e.getX() >  92 && e.getX() < 102 && e.getY() > 330 && e.getY() < 337 && frame.status == 2){
            frame.info();
            frame.regionNumber = 11-1;
            System.out.println("Orlovskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  92 && e.getX() < 102 && e.getY() > 330 && e.getY() < 337 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 11-1;
            frame.compareChange[frame.status - 4] = frame.regions[10].getChange();
            frame.compareName[frame.status - 4] = frame.regions[10].getName();
            frame.comparison();
            System.out.println("Orlovskaya obl. chosen, region number "+frame.regionNumber);
        }

        else if(isOneClick && e.getX() >  121 && e.getX() < 138 && e.getY() > 338 && e.getY() < 349 && frame.status == 2){
            frame.info();
            frame.regionNumber = 12-1;
            System.out.println("Ryazanskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  121 && e.getX() < 138 && e.getY() > 338 && e.getY() < 349 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 12-1;
            frame.compareChange[frame.status - 4] = frame.regions[11].getChange();
            frame.compareName[frame.status - 4] = frame.regions[11].getName();
            frame.comparison();
            System.out.println("Ryazanskaya obl. chosen, region number "+frame.regionNumber);
        }

        else if(isOneClick && e.getX() >  88 && e.getX() < 109 && e.getY() > 299 && e.getY() < 312 && frame.status == 2){
            frame.info();
            frame.regionNumber = 13-1;
            System.out.println("Smolenskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  88 && e.getX() < 109 && e.getY() > 299 && e.getY() < 312 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 13-1;
            frame.compareChange[frame.status - 4] = frame.regions[12].getChange();
            frame.compareName[frame.status - 4] = frame.regions[12].getName();
            frame.comparison();
            System.out.println("Smolenskaya obl. chosen, region number "+frame.regionNumber);
        }

        else if(isOneClick && e.getX() >  117 && e.getX() < 127 && e.getY() > 354 && e.getY() < 369 && frame.status == 2){
            frame.info();
            frame.regionNumber = 14-1;
            System.out.println("Tambovskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  117 && e.getX() < 127 && e.getY() > 354 && e.getY() < 369 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 14-1;
            frame.compareChange[frame.status - 4] = frame.regions[13].getChange();
            frame.compareName[frame.status - 4] = frame.regions[13].getName();
            frame.comparison();
            System.out.println("Tambovskaya obl. chosen, region number "+frame.regionNumber);
        }

        else if(isOneClick && e.getX() >  115 && e.getX() < 137 && e.getY() > 289 && e.getY() < 302 && frame.status == 2){
            frame.info();
            frame.regionNumber = 15-1;
            System.out.println("Tverskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  115 && e.getX() < 137 && e.getY() > 289 && e.getY() < 302 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 15-1;
            frame.compareChange[frame.status - 4] = frame.regions[14].getChange();
            frame.compareName[frame.status - 4] = frame.regions[14].getName();
            frame.comparison();
            System.out.println("Tverskaya obl. chosen, region number "+frame.regionNumber);
        }

        else if(isOneClick && e.getX() >  107 && e.getX() < 118 && e.getY() > 330 && e.getY() < 338 && frame.status == 2){
            frame.info();
            frame.regionNumber = 16-1;
            System.out.println("Tul'skaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  107 && e.getX() < 118 && e.getY() > 330 && e.getY() < 338 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 16-1;
            frame.compareChange[frame.status - 4] = frame.regions[15].getChange();
            frame.compareName[frame.status - 4] = frame.regions[15].getName();
            frame.comparison();
            System.out.println("Tul'skaya obl. chosen, region number "+frame.regionNumber);
        }

        else if(isOneClick && e.getX() >  143 && e.getX() < 158 && e.getY() > 302 && e.getY() < 314 && frame.status == 2){
            frame.info();
            frame.regionNumber = 17-1;
            System.out.println("Yaroslavskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  143 && e.getX() < 158 && e.getY() > 302 && e.getY() < 314 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 17-1;
            frame.compareChange[frame.status - 4] = frame.regions[16].getChange();
            frame.compareName[frame.status - 4] = frame.regions[16].getName();
            frame.comparison();
            System.out.println("Yaroslavskaya obl. chosen, region number "+frame.regionNumber);
        }

        else if(isOneClick && e.getX() >  37 && e.getX() < 87 && e.getY() > 285 && e.getY() < 294 && frame.status == 2){
            frame.info();
            frame.regionNumber = 18-1;
            System.out.println("g. Moskva opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  37 && e.getX() < 87 && e.getY() > 285 && e.getY() < 294 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 18-1;
            frame.compareChange[frame.status - 4] = frame.regions[17].getChange();
            frame.compareName[frame.status - 4] = frame.regions[17].getName();
            frame.comparison();
            System.out.println("g. Moskva chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  162 && e.getX() < 186 && e.getY() > 227 && e.getY() < 249 && frame.status == 2){
            frame.info();
            frame.regionNumber = 19-1;
            System.out.println("Karelia opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  162 && e.getX() < 186 && e.getY() > 227 && e.getY() < 249 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 19-1;
            frame.compareChange[frame.status - 4] = frame.regions[18].getChange();
            frame.compareName[frame.status - 4] = frame.regions[18].getName();
            frame.comparison();
            System.out.println("Karelia chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  232 && e.getX() < 284 && e.getY() > 288 && e.getY() < 318 && frame.status == 2){
            frame.info();
            frame.regionNumber = 20-1;
            System.out.println("Resp. Komi opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  232 && e.getX() < 284 && e.getY() > 288 && e.getY() < 318 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 20-1;
            frame.compareChange[frame.status - 4] = frame.regions[19].getChange();
            frame.compareName[frame.status - 4] = frame.regions[19].getName();
            frame.comparison();
            System.out.println("Resp. Komi chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  181 && e.getX() < 222 && e.getY() > 254 && e.getY() < 294 && frame.status == 2){
            frame.info();
            frame.regionNumber = 21-1;
            System.out.println("Arkhangelkaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  181 && e.getX() < 222 && e.getY() > 254 && e.getY() < 294 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 21-1;
            frame.compareChange[frame.status - 4] = frame.regions[20].getChange();
            frame.compareName[frame.status - 4] = frame.regions[20].getName();
            frame.comparison();
            System.out.println("Arkhangelkaya obl. chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  282 && e.getX() < 310 && e.getY() > 255 && e.getY() < 280 && frame.status == 2){
            frame.info();
            frame.regionNumber = 22-1;
            System.out.println("Nenetzkiy AO opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  282 && e.getX() < 310 && e.getY() > 255 && e.getY() < 280 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 22-1;
            frame.compareChange[frame.status - 4] = frame.regions[21].getChange();
            frame.compareName[frame.status - 4] = frame.regions[21].getName();
            frame.comparison();
            System.out.println("Nenetzkiy AO chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  158 && e.getX() < 173 && e.getY() > 285 && e.getY() < 308 && frame.status == 2){
            frame.info();
            frame.regionNumber = 23-1;
            System.out.println("Vologodskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  158 && e.getX() < 173 && e.getY() > 285 && e.getY() < 308 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 23-1;
            frame.compareChange[frame.status - 4] = frame.regions[22].getChange();
            frame.compareName[frame.status - 4] = frame.regions[22].getName();
            frame.comparison();
            System.out.println("Vologodskaya obl. chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  32 && e.getX() < 58 && e.getY() > 236 && e.getY() < 258 && frame.status == 2){
            frame.info();
            frame.regionNumber = 24-1;
            System.out.println("Kaliningradskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  32 && e.getX() < 58 && e.getY() > 236 && e.getY() < 258 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 24-1;
            frame.compareChange[frame.status - 4] = frame.regions[23].getChange();
            frame.compareName[frame.status - 4] = frame.regions[23].getName();
            frame.comparison();
            System.out.println("Kaliningradskaya obl. chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  138 && e.getX() < 153 && e.getY() > 262 && e.getY() < 274 && frame.status == 2){
            frame.info();
            frame.regionNumber = 25-1;
            System.out.println("Leningradskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  138 && e.getX() < 153 && e.getY() > 262 && e.getY() < 274 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 25-1;
            frame.compareChange[frame.status - 4] = frame.regions[24].getChange();
            frame.compareName[frame.status - 4] = frame.regions[24].getName();
            frame.comparison();
            System.out.println("Leningradskaya obl. chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  198 && e.getX() < 232 && e.getY() > 182 && e.getY() < 236 && frame.status == 2){
            frame.info();
            frame.regionNumber = 26-1;
            System.out.println("Murmanskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  198 && e.getX() < 232 && e.getY() > 182 && e.getY() < 236 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 26-1;
            frame.compareChange[frame.status - 4] = frame.regions[25].getChange();
            frame.compareName[frame.status - 4] = frame.regions[25].getName();
            frame.comparison();
            System.out.println("Murmanskaya obl. chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  114 && e.getX() < 134 && e.getY() > 266 && e.getY() < 284 && frame.status == 2){
            frame.info();
            frame.regionNumber = 27-1;
            System.out.println("Novgorodskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  114 && e.getX() < 134 && e.getY() > 266 && e.getY() < 284 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 27-1;
            frame.compareChange[frame.status - 4] = frame.regions[26].getChange();
            frame.compareName[frame.status - 4] = frame.regions[26].getName();
            frame.comparison();
            System.out.println("Novgorodskaya obl. chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  95 && e.getX() < 108 && e.getY() > 264 && e.getY() < 278 && frame.status == 2){
            frame.info();
            frame.regionNumber = 28-1;
            System.out.println("Pskovskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  95 && e.getX() < 108 && e.getY() > 264 && e.getY() < 278 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 28-1;
            frame.compareChange[frame.status - 4] = frame.regions[27].getChange();
            frame.compareName[frame.status - 4] = frame.regions[27].getName();
            frame.comparison();
            System.out.println("Pskovskaya obl. chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  52 && e.getX() < 157 && e.getY() > 217 && e.getY() < 230 && frame.status == 2){
            frame.info();
            frame.regionNumber = 29-1;
            System.out.println("Saint-Petersburg opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  52 && e.getX() < 157 && e.getY() > 217 && e.getY() < 230 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 29-1;
            frame.compareChange[frame.status - 4] = frame.regions[28].getChange();
            frame.compareName[frame.status - 4] = frame.regions[28].getName();
            frame.comparison();
            System.out.println("Saint-Petersburg chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  32 && e.getX() < 42 && e.getY() > 410 && e.getY() < 418 && frame.status == 2){
            frame.info();
            frame.regionNumber = 30-1;
            System.out.println("Resp. Adigeya opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  32 && e.getX() < 42 && e.getY() > 410 && e.getY() < 418 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 30-1;
            frame.compareChange[frame.status - 4] = frame.regions[29].getChange();
            frame.compareName[frame.status - 4] = frame.regions[29].getName();
            frame.comparison();
            System.out.println("Resp. Adigeya chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  92 && e.getX() < 104 && e.getY() > 422 && e.getY() < 443 && frame.status == 2){
            frame.info();
            frame.regionNumber = 31-1;
            System.out.println("Resp. Kalmikiya opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  92 && e.getX() < 104 && e.getY() > 422 && e.getY() < 443 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 31-1;
            frame.compareChange[frame.status - 4] = frame.regions[30].getChange();
            frame.compareName[frame.status - 4] = frame.regions[30].getName();
            frame.comparison();
            System.out.println("Resp. Kalmikiya chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  53 && e.getX() < 69 && e.getY() > 398 && e.getY() < 412 && frame.status == 2){
            frame.info();
            frame.regionNumber = 32-1;
            System.out.println("krasnodarskiy kray opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  53 && e.getX() < 69 && e.getY() > 398 && e.getY() < 412 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 32-1;
            frame.compareChange[frame.status - 4] = frame.regions[31].getChange();
            frame.compareName[frame.status - 4] = frame.regions[31].getName();
            frame.comparison();
            System.out.println("krasnodarskiy kray chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  112 && e.getX() < 121 && e.getY() > 429 && e.getY() < 446 && frame.status == 2){
            frame.info();
            frame.regionNumber = 33-1;
            System.out.println("astrakhanskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  112 && e.getX() < 121 && e.getY() > 429 && e.getY() < 446 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 33-1;
            frame.compareChange[frame.status - 4] = frame.regions[32].getChange();
            frame.compareName[frame.status - 4] = frame.regions[32].getName();
            frame.comparison();
            System.out.println("astrakhanskaya obl. chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  102 && e.getX() < 125 && e.getY() > 385 && e.getY() < 413 && frame.status == 2){
            frame.info();
            frame.regionNumber = 34-1;
            System.out.println("volgogradskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  102 && e.getX() < 125 && e.getY() > 385 && e.getY() < 413 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 34-1;
            frame.compareChange[frame.status - 4] = frame.regions[33].getChange();
            frame.compareName[frame.status - 4] = frame.regions[33].getName();
            frame.comparison();
            System.out.println("volgogradskaya obl. chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  71 && e.getX() < 93 && e.getY() > 389 && e.getY() < 412 && frame.status == 2){
            frame.info();
            frame.regionNumber = 35-1;
            System.out.println("rostovskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  71 && e.getX() < 93 && e.getY() > 389 && e.getY() < 412 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 35-1;
            frame.compareChange[frame.status - 4] = frame.regions[34].getChange();
            frame.compareName[frame.status - 4] = frame.regions[34].getName();
            frame.comparison();
            System.out.println("rostovskaya obl. chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  76 && e.getX() < 90 && e.getY() > 470 && e.getY() < 486 && frame.status == 2){
            frame.info();
            frame.regionNumber = 36-1;
            System.out.println("dagestan opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  76 && e.getX() < 90 && e.getY() > 470 && e.getY() < 486 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 36-1;
            frame.compareChange[frame.status - 4] = frame.regions[35].getChange();
            frame.compareName[frame.status - 4] = frame.regions[35].getName();
            frame.comparison();
            System.out.println("dagestan chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  62 && e.getX() < 67 && e.getY() > 458 && e.getY() < 466 && frame.status == 2){
            frame.info();
            frame.regionNumber = 37-1;
            System.out.println("ingushetia opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  62 && e.getX() < 67 && e.getY() > 458 && e.getY() < 466 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 37-1;
            frame.compareChange[frame.status - 4] = frame.regions[36].getChange();
            frame.compareName[frame.status - 4] = frame.regions[36].getName();
            frame.comparison();
            System.out.println("ingushetia chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  50 && e.getX() < 54 && e.getY() > 441 && e.getY() < 447 && frame.status == 2){
            frame.info();
            frame.regionNumber = 38-1;
            System.out.println("kabardino_balkaria opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  50 && e.getX() < 54 && e.getY() > 441 && e.getY() < 447 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 38-1;
            frame.compareChange[frame.status - 4] = frame.regions[37].getChange();
            frame.compareName[frame.status - 4] = frame.regions[37].getName();
            frame.comparison();
            System.out.println("kabardino_balkaria chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  42 && e.getX() < 48 && e.getY() > 430 && e.getY() < 438 && frame.status == 2){
            frame.info();
            frame.regionNumber = 39-1;
            System.out.println("karachaevo_cherkessia opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  42 && e.getX() < 48 && e.getY() > 430 && e.getY() < 438 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 39-1;
            frame.compareChange[frame.status - 4] = frame.regions[38].getChange();
            frame.compareName[frame.status - 4] = frame.regions[38].getName();
            frame.comparison();
            System.out.println("karachaevo_cherkessia chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  52 && e.getX() < 59 && e.getY() > 449 && e.getY() < 457 && frame.status == 2){
            frame.info();
            frame.regionNumber = 40-1;
            System.out.println("severnaya osetia opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  52 && e.getX() < 59 && e.getY() > 449 && e.getY() < 457 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 40-1;
            frame.compareChange[frame.status - 4] = frame.regions[39].getChange();
            frame.compareName[frame.status - 4] = frame.regions[39].getName();
            frame.comparison();
            System.out.println("severnaya osetia chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  61 && e.getX() < 69 && e.getY() > 469 && e.getY() < 479 && frame.status == 2){
            frame.info();
            frame.regionNumber = 41-1;
            System.out.println("chechenskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  61 && e.getX() < 69 && e.getY() > 469 && e.getY() < 479 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 41-1;
            frame.compareChange[frame.status - 4] = frame.regions[40].getChange();
            frame.compareName[frame.status - 4] = frame.regions[40].getName();
            frame.comparison();
            System.out.println("chechenskaya obl. chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  67 && e.getX() < 88 && e.getY() > 423 && e.getY() < 441 && frame.status == 2){
            frame.info();
            frame.regionNumber = 42-1;
            System.out.println("stavropolskiy kray opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  67 && e.getX() < 88 && e.getY() > 423 && e.getY() < 441 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 42-1;
            frame.compareChange[frame.status - 4] = frame.regions[41].getChange();
            frame.compareName[frame.status - 4] = frame.regions[41].getName();
            frame.comparison();
            System.out.println("stavropolskiy kray chosen, region number "+frame.regionNumber);
        }
         else if(isOneClick && e.getX() >  198 && e.getX() < 218 && e.getY() > 398 && e.getY() < 422 && frame.status == 2){
            frame.info();
            frame.regionNumber = 43-1;
            System.out.println("bashkortostan opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  198 && e.getX() < 218 && e.getY() > 398 && e.getY() < 422 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 43-1;
            frame.compareChange[frame.status - 4] = frame.regions[42].getChange();
            frame.compareName[frame.status - 4] = frame.regions[42].getName();
            frame.comparison();
            System.out.println("bashkortostan chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  177 && e.getX() < 187 && e.getY() > 349 && e.getY() < 359 && frame.status == 2){
            frame.info();
            frame.regionNumber = 44-1;
            System.out.println("resp. mariy_el opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  177 && e.getX() < 187 && e.getY() > 349 && e.getY() < 359 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 44-1;
            frame.compareChange[frame.status - 4] = frame.regions[43].getChange();
            frame.compareName[frame.status - 4] = frame.regions[43].getName();
            frame.comparison();
            System.out.println("resp. mariy_el chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  141 && e.getX() < 149 && e.getY() > 355 && e.getY() < 365 && frame.status == 2){
            frame.info();
            frame.regionNumber = 45-1;
            System.out.println("resp. mordovia opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  141 && e.getX() < 149 && e.getY() > 355 && e.getY() < 365 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 45-1;
            frame.compareChange[frame.status - 4] = frame.regions[44].getChange();
            frame.compareName[frame.status - 4] = frame.regions[44].getName();
            frame.comparison();
            System.out.println("resp. mordovia  chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  179 && e.getX() < 192 && e.getY() > 368 && e.getY() < 384 && frame.status == 2){
            frame.info();
            frame.regionNumber = 46-1;
            System.out.println("resp. tatarstan opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  179 && e.getX() < 192 && e.getY() > 368 && e.getY() < 384 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 46-1;
            frame.compareChange[frame.status - 4] = frame.regions[45].getChange();
            frame.compareName[frame.status - 4] = frame.regions[45].getName();
            frame.comparison();
            System.out.println("resp. tatarstan  chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  204 && e.getX() < 215 && e.getY() > 361 && e.getY() < 372 && frame.status == 2){
            frame.info();
            frame.regionNumber = 47-1;
            System.out.println("resp. udmurtskaya opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  204 && e.getX() < 215 && e.getY() > 361 && e.getY() < 372 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 47-1;
            frame.compareChange[frame.status - 4] = frame.regions[46].getChange();
            frame.compareName[frame.status - 4] = frame.regions[46].getName();
            frame.comparison();
            System.out.println("resp. udmurtskaya  chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  167 && e.getX() < 175 && e.getY() > 354 && e.getY() < 362 && frame.status == 2){
            frame.info();
            frame.regionNumber = 48-1;
            System.out.println("resp. chuvashskaya opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  167 && e.getX() < 175 && e.getY() > 354 && e.getY() < 362 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 48-1;
            frame.compareChange[frame.status - 4] = frame.regions[47].getChange();
            frame.compareName[frame.status - 4] = frame.regions[47].getName();
            frame.comparison();
            System.out.println("resp. chuvashskaya  chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  228 && e.getX() < 243 && e.getY() > 347 && e.getY() < 374 && frame.status == 2){
            frame.info();
            frame.regionNumber = 49-1;
            System.out.println("permskiy kray opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  228 && e.getX() < 243 && e.getY() > 347 && e.getY() < 374 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 49-1;
            frame.compareChange[frame.status - 4] = frame.regions[48].getChange();
            frame.compareName[frame.status - 4] = frame.regions[48].getName();
            frame.comparison();
            System.out.println("permskiy kray  chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  189 && e.getX() < 209 && e.getY() > 335 && e.getY() < 354 && frame.status == 2){
            frame.info();
            frame.regionNumber = 50-1;
            System.out.println("kirovskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  189 && e.getX() < 209 && e.getY() > 335 && e.getY() < 354 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 50-1;
            frame.compareChange[frame.status - 4] = frame.regions[49].getChange();
            frame.compareName[frame.status - 4] = frame.regions[49].getName();
            frame.comparison();
            System.out.println("kirovskaya obl.  chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  152 && e.getX() < 166 && e.getY() > 339 && e.getY() < 352&& frame.status == 2){
            frame.info();
            frame.regionNumber = 51-1;
            System.out.println("nizhegorodskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  152 && e.getX() < 166 && e.getY() > 339 && e.getY() < 352&& frame.status > 3 && frame.status < 7){
            frame.regionNumber = 51-1;
            frame.compareChange[frame.status - 4] = frame.regions[50].getChange();
            frame.compareName[frame.status - 4] = frame.regions[50].getName();
            frame.comparison();
            System.out.println("nizhegorodskaya obl.  chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  174 && e.getX() < 195 && e.getY() > 412 && e.getY() < 438&& frame.status == 2){
            frame.info();
            frame.regionNumber = 52-1;
            System.out.println("orenburgskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  174 && e.getX() < 195 && e.getY() > 412 && e.getY() < 438&& frame.status > 3 && frame.status < 7){
            frame.regionNumber = 52-1;
            frame.compareChange[frame.status - 4] = frame.regions[51].getChange();
            frame.compareName[frame.status - 4] = frame.regions[51].getName();
            frame.comparison();
            System.out.println("orenburgskaya obl.  chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  136 && e.getX() < 151 && e.getY() > 367 && e.getY() < 381 && frame.status == 2){
            frame.info();
            frame.regionNumber = 53-1;
            System.out.println("penzenskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  136 && e.getX() < 151 && e.getY() > 367 && e.getY() < 381 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 53-1;
            frame.compareChange[frame.status - 4] = frame.regions[52].getChange();
            frame.compareName[frame.status - 4] = frame.regions[52].getName();
            frame.comparison();
            System.out.println("penzenskaya obl.  chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  164 && e.getX() < 179 && e.getY() > 384 && e.getY() < 399 && frame.status == 2){
            frame.info();
            frame.regionNumber = 54-1;
            System.out.println("samarskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  164 && e.getX() < 179 && e.getY() > 384 && e.getY() < 399 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 54-1;
            frame.compareChange[frame.status - 4] = frame.regions[53].getChange();
            frame.compareName[frame.status - 4] = frame.regions[53].getName();
            frame.comparison();
            System.out.println("samarskaya obl.  chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  134 && e.getX() < 156 && e.getY() > 388 && e.getY() < 407 && frame.status == 2){
            frame.info();
            frame.regionNumber = 55-1;
            System.out.println("saratovskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  134 && e.getX() < 156 && e.getY() > 388 && e.getY() < 407 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 55-1;
            frame.compareChange[frame.status - 4] = frame.regions[54].getChange();
            frame.compareName[frame.status - 4] = frame.regions[54].getName();
            frame.comparison();
            System.out.println("saratovskaya obl.  chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  155 && e.getX() < 170 && e.getY() > 370 && e.getY() < 382 && frame.status == 2){
            frame.info();
            frame.regionNumber = 56-1;
            System.out.println("ulyanovskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  155 && e.getX() < 170 && e.getY() > 370 && e.getY() < 382 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 56-1;
            frame.compareChange[frame.status - 4] = frame.regions[55].getChange();
            frame.compareName[frame.status - 4] = frame.regions[55].getName();
            frame.comparison();
            System.out.println("ulyanovskaya obl.  chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  252 && e.getX() < 273 && e.getY() > 414 && e.getY() < 431 && frame.status == 2){
            frame.info();
            frame.regionNumber = 57-1;
            System.out.println("kurganskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  252 && e.getX() < 273 && e.getY() > 414 && e.getY() < 431 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 57-1;
            frame.compareChange[frame.status - 4] = frame.regions[56].getChange();
            frame.compareName[frame.status - 4] = frame.regions[56].getName();
            frame.comparison();
            System.out.println("kurganskaya obl.  chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  252 && e.getX() < 274 && e.getY() > 362 && e.getY() < 396 && frame.status == 2){
            frame.info();
            frame.regionNumber = 58-1;
            System.out.println("sverdlovskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  252 && e.getX() < 274 && e.getY() > 362 && e.getY() < 396 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 58-1;
            frame.compareChange[frame.status - 4] = frame.regions[57].getChange();
            frame.compareName[frame.status - 4] = frame.regions[57].getName();
            frame.comparison();
            System.out.println("sverdlovskaya obl.  chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  281 && e.getX() < 303 && e.getY() > 399 && e.getY() < 423 && frame.status == 2){
            frame.info();
            frame.regionNumber = 59-1;
            System.out.println("tymenskaya obl. opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  281 && e.getX() < 303 && e.getY() > 399 && e.getY() < 423 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 59-1;
            frame.compareChange[frame.status - 4] = frame.regions[58].getChange();
            frame.compareName[frame.status - 4] = frame.regions[58].getName();
            frame.comparison();
            System.out.println("tymenskaya obl.  chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  281 && e.getX() < 368 && e.getY() > 365 && e.getY() < 389 && frame.status == 2){
            frame.info();
            frame.regionNumber = 60-1;
            System.out.println("khanti_mansiyskiy okrug opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  281 && e.getX() < 368 && e.getY() > 365 && e.getY() < 389 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 60-1;
            frame.compareChange[frame.status - 4] = frame.regions[59].getChange();
            frame.compareName[frame.status - 4] = frame.regions[59].getName();
            frame.comparison();
            System.out.println("khanti_mansiyskiy okrug  chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  327 && e.getX() < 401 && e.getY() > 315 && e.getY() < 359 && frame.status == 2){
            frame.info();
            frame.regionNumber = 61-1;
            System.out.println("yamalo_nenetzkiy okrug opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  327 && e.getX() < 401 && e.getY() > 315 && e.getY() < 359 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 61-1;
            frame.compareChange[frame.status - 4] = frame.regions[60].getChange();
            frame.compareName[frame.status - 4] = frame.regions[60].getName();
            frame.comparison();
            System.out.println("yamalo_nenetzkiy okrug  chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  236 && e.getX() < 249 && e.getY() > 400 && e.getY() < 414 && frame.status == 2){
            frame.info();
            frame.regionNumber = 62-1;
            System.out.println("chelyabinskaya opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  236 && e.getX() < 249 && e.getY() > 400 && e.getY() < 414 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 62-1;
            frame.compareChange[frame.status - 4] = frame.regions[61].getChange();
            frame.compareName[frame.status - 4] = frame.regions[61].getName();
            frame.comparison();
            System.out.println("chelyabinskaya chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  367 && e.getX() < 400 && e.getY() > 509 && e.getY() < 528 && frame.status == 2){
            frame.info();
            frame.regionNumber = 63-1;
            System.out.println("altay opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  367 && e.getX() < 400 && e.getY() > 509 && e.getY() < 528 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 63-1;
            frame.compareChange[frame.status - 4] = frame.regions[62].getChange();
            frame.compareName[frame.status - 4] = frame.regions[62].getName();
            frame.comparison();
            System.out.println("altay chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  538 && e.getX() < 566 && e.getY() > 466 && e.getY() < 503 && frame.status == 2){
            frame.info();
            frame.regionNumber = 64-1;
            System.out.println("buryatia opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  538 && e.getX() < 566 && e.getY() > 466 && e.getY() < 503 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 64-1;
            frame.compareChange[frame.status - 4] = frame.regions[63].getChange();
            frame.compareName[frame.status - 4] = frame.regions[63].getName();
            frame.comparison();
            System.out.println("buryatia chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  411 && e.getX() < 464 && e.getY() > 508 && e.getY() < 528 && frame.status == 2){
            frame.info();
            frame.regionNumber = 65-1;
            System.out.println("tiva opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  411 && e.getX() < 464 && e.getY() > 508 && e.getY() < 528 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 65-1;
            frame.compareChange[frame.status - 4] = frame.regions[64].getChange();
            frame.compareName[frame.status - 4] = frame.regions[64].getName();
            frame.comparison();
            System.out.println("tiva chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  407 && e.getX() < 418 && e.getY() > 477 && e.getY() < 501 && frame.status == 2){
            frame.info();
            frame.regionNumber = 66-1;
            System.out.println("hakasia opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  407 && e.getX() < 418 && e.getY() > 477 && e.getY() < 501 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 66-1;
            frame.compareChange[frame.status - 4] = frame.regions[65].getChange();
            frame.compareName[frame.status - 4] = frame.regions[65].getName();
            frame.comparison();
            System.out.println("hakasia chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  335 && e.getX() < 380 && e.getY() > 476 && e.getY() < 501 && frame.status == 2){
            frame.info();
            frame.regionNumber = 67-1;
            System.out.println("altayskiy opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  335 && e.getX() < 380 && e.getY() > 476 && e.getY() < 501 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 67-1;
            frame.compareChange[frame.status - 4] = frame.regions[66].getChange();
            frame.compareName[frame.status - 4] = frame.regions[66].getName();
            frame.comparison();
            System.out.println("altayskiy chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  573 && e.getX() < 601 && e.getY() > 492 && e.getY() < 534 && frame.status == 2){
            frame.info();
            frame.regionNumber = 68-1;
            System.out.println("zabaykalskiy opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  573 && e.getX() < 601 && e.getY() > 492 && e.getY() < 534 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 68-1;
            frame.compareChange[frame.status - 4] = frame.regions[67].getChange();
            frame.compareName[frame.status - 4] = frame.regions[67].getName();
            frame.comparison();
            System.out.println("zabaykalskiy chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  411 && e.getX() < 500 && e.getY() > 259 && e.getY() < 429 && frame.status == 2){
            frame.info();
            frame.regionNumber = 69-1;
            System.out.println("krasnoyarskiy opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  411 && e.getX() < 500 && e.getY() > 259 && e.getY() < 429 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 69-1;
            frame.compareChange[frame.status - 4] = frame.regions[68].getChange();
            frame.compareName[frame.status - 4] = frame.regions[68].getName();
            frame.comparison();
            System.out.println("krasnoyarskiy chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  459 && e.getX() < 528 && e.getY() > 470 && e.getY() < 493 && frame.status == 2){
            frame.info();
            frame.regionNumber = 70-1;
            System.out.println("irkutskaya opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  459 && e.getX() < 528 && e.getY() > 470 && e.getY() < 493 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 70-1;
            frame.compareChange[frame.status - 4] = frame.regions[69].getChange();
            frame.compareName[frame.status - 4] = frame.regions[69].getName();
            frame.comparison();
            System.out.println("irkutskaya chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  385 && e.getX() < 401 && e.getY() > 458 && e.getY() < 478 && frame.status == 2){
            frame.info();
            frame.regionNumber = 71-1;
            System.out.println("kemerovskaya opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  385 && e.getX() < 401 && e.getY() > 458 && e.getY() < 478 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 71-1;
            frame.compareChange[frame.status - 4] = frame.regions[70].getChange();
            frame.compareName[frame.status - 4] = frame.regions[70].getName();
            frame.comparison();
            System.out.println("kemerovskaya chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  332 && e.getX() < 357 && e.getY() > 441 && e.getY() < 463 && frame.status == 2){
            frame.info();
            frame.regionNumber = 72-1;
            System.out.println("novosibirskaya opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  332 && e.getX() < 357 && e.getY() > 441 && e.getY() < 463 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 72-1;
            frame.compareChange[frame.status - 4] = frame.regions[71].getChange();
            frame.compareName[frame.status - 4] = frame.regions[71].getName();
            frame.comparison();
            System.out.println("novosibirskaya chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  306 && e.getX() < 321 && e.getY() > 417 && e.getY() < 453 && frame.status == 2){
            frame.info();
            frame.regionNumber = 73-1;
            System.out.println("omskaya opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  306 && e.getX() < 321 && e.getY() > 417 && e.getY() < 453 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 73-1;
            frame.compareChange[frame.status - 4] = frame.regions[72].getChange();
            frame.compareName[frame.status - 4] = frame.regions[72].getName();
            frame.comparison();
            System.out.println("omskaya chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  342 && e.getX() < 404 && e.getY() > 415 && e.getY() < 438 && frame.status == 2){
            frame.info();
            frame.regionNumber = 74-1;
            System.out.println("tomskaya opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  342 && e.getX() < 404 && e.getY() > 415 && e.getY() < 438 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 74-1;
            frame.compareChange[frame.status - 4] = frame.regions[73].getChange();
            frame.compareName[frame.status - 4] = frame.regions[73].getName();
            frame.comparison();
            System.out.println("tomskaya chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  541 && e.getX() < 684 && e.getY() > 270 && e.getY() < 399 && frame.status == 2){
            frame.info();
            frame.regionNumber = 75-1;
            System.out.println("saha_yakutia opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  541 && e.getX() < 684 && e.getY() > 270 && e.getY() < 399 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 75-1;
            frame.compareChange[frame.status - 4] = frame.regions[74].getChange();
            frame.compareName[frame.status - 4] = frame.regions[74].getName();
            frame.comparison();
            System.out.println("saha_yakutia chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  803 && e.getX() < 850 && e.getY() > 284 && e.getY() < 444 && frame.status == 2){
            frame.info();
            frame.regionNumber = 76-1;
            System.out.println("kamchatskiy opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  803 && e.getX() < 850 && e.getY() > 284 && e.getY() < 444 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 76-1;
            frame.compareChange[frame.status - 4] = frame.regions[75].getChange();
            frame.compareName[frame.status - 4] = frame.regions[75].getName();
            frame.comparison();
            System.out.println("kamchatskiy chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  719 && e.getX() < 738 && e.getY() > 540 && e.getY() < 580 && frame.status == 2){
            frame.info();
            frame.regionNumber = 77-1;
            System.out.println("primorskiy opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  719 && e.getX() < 738 && e.getY() > 540 && e.getY() < 580 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 77-1;
            frame.compareChange[frame.status - 4] = frame.regions[76].getChange();
            frame.compareName[frame.status - 4] = frame.regions[76].getName();
            frame.comparison();
            System.out.println("primorskiy chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  706 && e.getX() < 740 && e.getY() > 467 && e.getY() < 511 && frame.status == 2){
            frame.info();
            frame.regionNumber = 78-1;
            System.out.println("habarovskiy opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  706 && e.getX() < 740 && e.getY() > 467 && e.getY() < 511 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 78-1;
            frame.compareChange[frame.status - 4] = frame.regions[77].getChange();
            frame.compareName[frame.status - 4] = frame.regions[77].getName();
            frame.comparison();
            System.out.println("habarovskiy chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  621 && e.getX() < 687 && e.getY() > 466 && e.getY() < 495 && frame.status == 2){
            frame.info();
            frame.regionNumber = 79-1;
            System.out.println("amurskaya opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  621 && e.getX() < 687 && e.getY() > 466 && e.getY() < 495 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 79-1;
            frame.compareChange[frame.status - 4] = frame.regions[78].getChange();
            frame.compareName[frame.status - 4] = frame.regions[78].getName();
            frame.comparison();
            System.out.println("amurskaya chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  739 && e.getX() < 779 && e.getY() > 292 && e.getY() < 361 && frame.status == 2){
            frame.info();
            frame.regionNumber = 80-1;
            System.out.println("magadanskaya opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  739 && e.getX() < 779 && e.getY() > 292 && e.getY() < 361 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 80-1;
            frame.compareChange[frame.status - 4] = frame.regions[79].getChange();
            frame.compareName[frame.status - 4] = frame.regions[79].getName();
            frame.comparison();
            System.out.println("magadanskaya chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  753 && e.getX() < 831 && e.getY() > 441 && e.getY() < 551 && frame.status == 2){
            frame.info();
            frame.regionNumber = 81-1;
            System.out.println("sakhalinskaya opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  753 && e.getX() < 831 && e.getY() > 441 && e.getY() < 551 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 81-1;
            frame.compareChange[frame.status - 4] = frame.regions[80].getChange();
            frame.compareName[frame.status - 4] = frame.regions[80].getName();
            frame.comparison();
            System.out.println("sakhalinskaya chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  692 && e.getX() < 709 && e.getY() > 514 && e.getY() < 528 && frame.status == 2){
            frame.info();
            frame.regionNumber = 82-1;
            System.out.println("evreyskaya_aobl opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  692 && e.getX() < 709 && e.getY() > 514 && e.getY() < 528 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 82-1;
            frame.compareChange[frame.status - 4] = frame.regions[81].getChange();
            frame.compareName[frame.status - 4] = frame.regions[81].getName();
            frame.comparison();
            System.out.println("evreyskaya_aobl chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  744 && e.getX() < 856 && e.getY() > 159 && e.getY() < 268 && frame.status == 2){
            frame.info();
            frame.regionNumber = 83-1;
            System.out.println("chukotskiy opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  744 && e.getX() < 856 && e.getY() > 159 && e.getY() < 268 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 83-1;
            frame.compareChange[frame.status - 4] = frame.regions[82].getChange();
            frame.compareName[frame.status - 4] = frame.regions[82].getName();
            frame.comparison();
            System.out.println("chukotskiy chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  23 && e.getX() < 72 && e.getY() > 335 && e.getY() < 385 && frame.status == 2){
            frame.info();
            frame.regionNumber = 84-1;
            System.out.println("krim opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  23 && e.getX() < 72 && e.getY() > 335 && e.getY() < 385 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 84-1;
            frame.compareChange[frame.status - 4] = frame.regions[83].getChange();
            frame.compareName[frame.status - 4] = frame.regions[83].getName();
            frame.comparison();
            System.out.println("krim chosen, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  12 && e.getX() < 24 && e.getY() > 390 && e.getY() < 402 && frame.status == 2){
            frame.info();
            frame.regionNumber = 85-1;
            System.out.println("sevastopol opened, region number "+frame.regionNumber);
        }
        else if(isOneClick && e.getX() >  12 && e.getX() < 24 && e.getY() > 390 && e.getY() < 402 && frame.status > 3 && frame.status < 7){
            frame.regionNumber = 85-1;
            frame.compareChange[frame.status - 4] = frame.regions[84].getChange();
            frame.compareName[frame.status - 4] = frame.regions[84].getName();
            frame.comparison();
            System.out.println("sevastopol chosen, region number "+frame.regionNumber);
        }


        //map opening
        else if(e.getX() > 490 && e.getX() < 850 && e.getY() > 440 && e.getY() < 545 && frame.status == 1){
            System.out.println("Map opened");
            frame.start();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
