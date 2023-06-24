package project;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ClickListener implements MouseListener {
    public static ClickListener regInfo;       
    private Project nktz;
    static final int SRAVNIT_INFO_COUNT = 0;    
             
 public ClickListener(Project nktz){
     this.nktz = nktz;
 }

   @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("");
    }
    @Override
    public void mousePressed(MouseEvent e) {
      boolean isOneClick = e.getClickCount() == 1;  
    //Yes, I'm an idiot. It was possible to avoid creating a lot of "if" statements but when I started doing this project, I didn't understand it. 
    //Now I dont have enough  to make it right.
    //But then there will be something to update -_-
    
    //method to check if the click (X,Y) was made is inside the field
        
        //exit from the program
        if(isOneClick && e.getX() >  490 && e.getX() < 850 && e.getY() > 555 && e.getY() < 665 && nktz.status == 1){
            System.out.println("Program closed");
            System.out.println("Here I am");
            System.exit(0);
        }
        
        //exit from map to menu
        else if(isOneClick && e.getX() >  1000 && e.getX() < 1265 && e.getY() > 615 && e.getY() < 700 && nktz.status > 1){
            System.out.println("Map closed");
            nktz.sravnit_ubil[0] = 0;
            nktz.sravnit_ubil[1] = 0;
            nktz.sravnit_ubil[2] = 0;
            nktz.sravnit_imya[0] = "NULL";
            nktz.sravnit_imya[1] = "NULL";
            nktz.sravnit_imya[2] = "NULL";
            nktz.status = 1;
        }
        
        //exit from region info window
        else if(isOneClick && e.getX() >  705 && e.getX() < 860 && e.getY() > 585 && e.getY() < 670 && nktz.status == 3){
            System.out.println("Region info closed");
            nktz.status = 2;
        }
        
        //region comarison start
        else if(isOneClick && e.getX() >  14 && e.getX() < 260 && e.getY() > 629 && e.getY() < 698 && nktz.status == 2){
            System.out.println("Comparison mode");
            System.out.println("Region chosen 0/3");
            nktz.sravnenie();
        }
        
        //region comarison exit
        else if(isOneClick && e.getX() >  432 && e.getX() < 524 && e.getY() > 633 && e.getY() < 702 && nktz.status > 3 && nktz.status < 7){
            System.out.println("Comparison mode closed");
            nktz.status = 2;
            nktz.sravnit_ubil[0] = 0;
            nktz.sravnit_ubil[1] = 0;
            nktz.sravnit_ubil[2] = 0;
            nktz.sravnit_imya[0] = "NULL";
            nktz.sravnit_imya[1] = "NULL";
            nktz.sravnit_imya[2] = "NULL";
        }
        
        //exit from comparison results window
        else if(isOneClick && e.getX() >  845 && e.getX() < 997 && e.getY() > 548 && e.getY() < 618&& nktz.status == 7){
            System.out.println("Comparison info closed");
            nktz.status = 2;
            nktz.sravnit_ubil[0] = 0;
            nktz.sravnit_ubil[1] = 0;
            nktz.sravnit_ubil[2] = 0;
            nktz.sravnit_imya[0] = "NULL";
            nktz.sravnit_imya[1] = "NULL";
            nktz.sravnit_imya[2] = "NULL";
            
        }
        
        
        //REGIONS
        //first else if statement is used to open specific region info window
        //Second else if statement is used to choose the region for comparison
        //I know, my code is terrible, sorry
        else if(isOneClick && e.getX() >  78 && e.getX() < 94 && e.getY() > 355 && e.getY() < 364 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 1;
            System.out.println("Belgorodskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  78 && e.getX() < 94 && e.getY() > 355 && e.getY() < 364 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 1;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[0];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[0];
            nktz.sravnenie();
            System.out.println("Belgorodskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        else if(isOneClick && e.getX() >  75 && e.getX() < 92 && e.getY() > 316 && e.getY() < 330 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 2;
            System.out.println("Bryanskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  75 && e.getX() < 92 && e.getY() > 316 && e.getY() < 330 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 2;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[1];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[1];
            nktz.sravnenie();
            System.out.println("Bryanskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        else if(isOneClick && e.getX() >  133 && e.getX() < 148 && e.getY() > 324 && e.getY() < 337 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 3;
            System.out.println("Vladimirskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  133 && e.getX() < 148 && e.getY() > 324 && e.getY() < 337 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 3;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[2];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[2];
            nktz.sravnenie();
            System.out.println("Vladimirskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        else if(isOneClick && e.getX() >  95 && e.getX() < 109 && e.getY() > 364 && e.getY() < 374 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 4;
            System.out.println("Voronezhskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  95 && e.getX() < 109 && e.getY() > 364 && e.getY() < 374 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 4;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[3];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[3];
            nktz.sravnenie();
            System.out.println("Voronezhskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        else if(isOneClick && e.getX() >  149 && e.getX() < 162 && e.getY() > 321 && e.getY() < 332 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 5;
            System.out.println("Ivanovskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  149 && e.getX() < 162 && e.getY() > 321 && e.getY() < 332 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 5;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[4];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[4];
            nktz.sravnenie();
            System.out.println("Ivanovskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        else if(isOneClick && e.getX() >  96 && e.getX() < 114 && e.getY() > 314 && e.getY() < 326 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 6;
            System.out.println("Kaluzhskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  96 && e.getX() < 114 && e.getY() > 314 && e.getY() < 326 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 6;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[5];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[5];
            nktz.sravnenie();
            System.out.println("Kaluzhskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        else if(isOneClick && e.getX() >  166 && e.getX() < 180 && e.getY() > 314 && e.getY() < 327 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 7;
            System.out.println("Kostromskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  166 && e.getX() < 180 && e.getY() > 314 && e.getY() < 327 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 7;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[6];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[6];
            nktz.sravnenie();
            System.out.println("Kostromskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        else if(isOneClick && e.getX() >  76 && e.getX() < 95 && e.getY() > 337 && e.getY() < 348 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 8;
            System.out.println("Kurskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  76 && e.getX() < 95 && e.getY() > 337 && e.getY() < 348 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 8;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[7];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[7];
            nktz.sravnenie();
            System.out.println("Kurskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        else if(isOneClick && e.getX() >  103 && e.getX() < 115 && e.getY() > 345 && e.getY() < 354 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 9;
            System.out.println("Lipetskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  103 && e.getX() < 115 && e.getY() > 345 && e.getY() < 354 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 9;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[8];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[8];
            nktz.sravnenie();
            System.out.println("Lipetskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        else if(isOneClick && e.getX() >  117 && e.getX() < 133 && e.getY() > 322 && e.getY() < 334 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 10;
            System.out.println("Moskowskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  117 && e.getX() < 133 && e.getY() > 322 && e.getY() < 334 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 10;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[9];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[9];
            nktz.sravnenie();
            System.out.println("Moskowskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        else if(isOneClick && e.getX() >  92 && e.getX() < 102 && e.getY() > 330 && e.getY() < 337 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 11;
            System.out.println("Orlovskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  92 && e.getX() < 102 && e.getY() > 330 && e.getY() < 337 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 11;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[10];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[10];
            nktz.sravnenie();
            System.out.println("Orlovskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        else if(isOneClick && e.getX() >  121 && e.getX() < 138 && e.getY() > 338 && e.getY() < 349 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 12;
            System.out.println("Ryazanskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  121 && e.getX() < 138 && e.getY() > 338 && e.getY() < 349 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 12;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[11];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[11];
            nktz.sravnenie();
            System.out.println("Ryazanskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        else if(isOneClick && e.getX() >  88 && e.getX() < 109 && e.getY() > 299 && e.getY() < 312 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 13;
            System.out.println("Smolenskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  88 && e.getX() < 109 && e.getY() > 299 && e.getY() < 312 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 13;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[12];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[12];
            nktz.sravnenie();
            System.out.println("Smolenskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        else if(isOneClick && e.getX() >  117 && e.getX() < 127 && e.getY() > 354 && e.getY() < 369 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 14;
            System.out.println("Tambovskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  117 && e.getX() < 127 && e.getY() > 354 && e.getY() < 369 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 14;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[13];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[13];
            nktz.sravnenie();
            System.out.println("Tambovskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        else if(isOneClick && e.getX() >  115 && e.getX() < 137 && e.getY() > 289 && e.getY() < 302 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 15;
            System.out.println("Tverskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  115 && e.getX() < 137 && e.getY() > 289 && e.getY() < 302 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 15;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[14];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[14];
            nktz.sravnenie();
            System.out.println("Tverskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        else if(isOneClick && e.getX() >  107 && e.getX() < 118 && e.getY() > 330 && e.getY() < 338 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 16;
            System.out.println("Tul'skaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  107 && e.getX() < 118 && e.getY() > 330 && e.getY() < 338 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 16;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[15];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[15];
            nktz.sravnenie();
            System.out.println("Tul'skaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        else if(isOneClick && e.getX() >  143 && e.getX() < 158 && e.getY() > 302 && e.getY() < 314 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 17;
            System.out.println("Yaroslavskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  143 && e.getX() < 158 && e.getY() > 302 && e.getY() < 314 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 17;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[16];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[16];
            nktz.sravnenie();
            System.out.println("Yaroslavskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        else if(isOneClick && e.getX() >  37 && e.getX() < 87 && e.getY() > 285 && e.getY() < 294 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 18;
            System.out.println("g. Moskva opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  37 && e.getX() < 87 && e.getY() > 285 && e.getY() < 294 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 18;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[17];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[17];
            nktz.sravnenie();
            System.out.println("g. Moskva chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  162 && e.getX() < 186 && e.getY() > 227 && e.getY() < 249 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 19;
            System.out.println("Karelia opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  162 && e.getX() < 186 && e.getY() > 227 && e.getY() < 249 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 19;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[18];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[18];
            nktz.sravnenie();
            System.out.println("Karelia chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  232 && e.getX() < 284 && e.getY() > 288 && e.getY() < 318 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 20;
            System.out.println("Resp. Komi opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  232 && e.getX() < 284 && e.getY() > 288 && e.getY() < 318 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 20;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[19];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[19];
            nktz.sravnenie();
            System.out.println("Resp. Komi chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  181 && e.getX() < 222 && e.getY() > 254 && e.getY() < 294 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 21;
            System.out.println("Arkhangelkaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  181 && e.getX() < 222 && e.getY() > 254 && e.getY() < 294 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 21;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[20];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[20];
            nktz.sravnenie();
            System.out.println("Arkhangelkaya obl. chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  282 && e.getX() < 310 && e.getY() > 255 && e.getY() < 280 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 22;
            System.out.println("Nenetzkiy AO opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  282 && e.getX() < 310 && e.getY() > 255 && e.getY() < 280 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 22;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[21];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[21];
            nktz.sravnenie();
            System.out.println("Nenetzkiy AO chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  158 && e.getX() < 173 && e.getY() > 285 && e.getY() < 308 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 23;
            System.out.println("Vologodskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  158 && e.getX() < 173 && e.getY() > 285 && e.getY() < 308 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 23;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[22];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[22];
            nktz.sravnenie();
            System.out.println("Vologodskaya obl. chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  32 && e.getX() < 58 && e.getY() > 236 && e.getY() < 258 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 24;
            System.out.println("Kaliningradskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  32 && e.getX() < 58 && e.getY() > 236 && e.getY() < 258 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 24;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[23];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[23];
            nktz.sravnenie();
            System.out.println("Kaliningradskaya obl. chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  138 && e.getX() < 153 && e.getY() > 262 && e.getY() < 274 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 25;
            System.out.println("Leningradskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  138 && e.getX() < 153 && e.getY() > 262 && e.getY() < 274 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 25;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[24];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[24];
            nktz.sravnenie();
            System.out.println("Leningradskaya obl. chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  198 && e.getX() < 232 && e.getY() > 182 && e.getY() < 236 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 26;
            System.out.println("Murmanskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  198 && e.getX() < 232 && e.getY() > 182 && e.getY() < 236 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 26;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[25];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[25];
            nktz.sravnenie();
            System.out.println("Murmanskaya obl. chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  114 && e.getX() < 134 && e.getY() > 266 && e.getY() < 284 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 27;
            System.out.println("Novgorodskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  114 && e.getX() < 134 && e.getY() > 266 && e.getY() < 284 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 27;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[26];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[26];
            nktz.sravnenie();
            System.out.println("Novgorodskaya obl. chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  95 && e.getX() < 108 && e.getY() > 264 && e.getY() < 278 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 28;
            System.out.println("Pskovskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  95 && e.getX() < 108 && e.getY() > 264 && e.getY() < 278 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 28;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[27];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[27];
            nktz.sravnenie();
            System.out.println("Pskovskaya obl. chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  52 && e.getX() < 157 && e.getY() > 217 && e.getY() < 230 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 29;
            System.out.println("Saint-Petersburg opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  52 && e.getX() < 157 && e.getY() > 217 && e.getY() < 230 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 29;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[28];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[28];
            nktz.sravnenie();
            System.out.println("Saint-Petersburg chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  32 && e.getX() < 42 && e.getY() > 410 && e.getY() < 418 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 30;
            System.out.println("Resp. Adigeya opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  32 && e.getX() < 42 && e.getY() > 410 && e.getY() < 418 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 30;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[29];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[29];
            nktz.sravnenie();
            System.out.println("Resp. Adigeya chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  92 && e.getX() < 104 && e.getY() > 422 && e.getY() < 443 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 31;
            System.out.println("Resp. Kalmikiya opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  92 && e.getX() < 104 && e.getY() > 422 && e.getY() < 443 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 31;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[30];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[30];
            nktz.sravnenie();
            System.out.println("Resp. Kalmikiya chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  53 && e.getX() < 69 && e.getY() > 398 && e.getY() < 412 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 32;
            System.out.println("krasnodarskiy kray opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  53 && e.getX() < 69 && e.getY() > 398 && e.getY() < 412 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 32;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[31];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[31];
            nktz.sravnenie();
            System.out.println("krasnodarskiy kray chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  112 && e.getX() < 121 && e.getY() > 429 && e.getY() < 446 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 33;
            System.out.println("astrakhanskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  112 && e.getX() < 121 && e.getY() > 429 && e.getY() < 446 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 33;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[32];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[32];
            nktz.sravnenie();
            System.out.println("astrakhanskaya obl. chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  102 && e.getX() < 125 && e.getY() > 385 && e.getY() < 413 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 34;
            System.out.println("volgogradskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  102 && e.getX() < 125 && e.getY() > 385 && e.getY() < 413 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 34;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[33];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[33];
            nktz.sravnenie();
            System.out.println("volgogradskaya obl. chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  71 && e.getX() < 93 && e.getY() > 389 && e.getY() < 412 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 35;
            System.out.println("rostovskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  71 && e.getX() < 93 && e.getY() > 389 && e.getY() < 412 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 35;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[34];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[34];
            nktz.sravnenie();
            System.out.println("rostovskaya obl. chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  76 && e.getX() < 90 && e.getY() > 470 && e.getY() < 486 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 36;
            System.out.println("dagestan opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  76 && e.getX() < 90 && e.getY() > 470 && e.getY() < 486 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 36;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[35];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[35];
            nktz.sravnenie();
            System.out.println("dagestan chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  62 && e.getX() < 67 && e.getY() > 458 && e.getY() < 466 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 37;
            System.out.println("ingushetia opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  62 && e.getX() < 67 && e.getY() > 458 && e.getY() < 466 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 37;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[36];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[36];
            nktz.sravnenie();
            System.out.println("ingushetia chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  50 && e.getX() < 54 && e.getY() > 441 && e.getY() < 447 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 38;
            System.out.println("kabardino_balkaria opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  50 && e.getX() < 54 && e.getY() > 441 && e.getY() < 447 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 38;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[37];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[37];
            nktz.sravnenie();
            System.out.println("kabardino_balkaria chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  42 && e.getX() < 48 && e.getY() > 430 && e.getY() < 438 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 39;
            System.out.println("karachaevo_cherkessia opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  42 && e.getX() < 48 && e.getY() > 430 && e.getY() < 438 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 39;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[38];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[38];
            nktz.sravnenie();
            System.out.println("karachaevo_cherkessia chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  52 && e.getX() < 59 && e.getY() > 449 && e.getY() < 457 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 40;
            System.out.println("severnaya osetia opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  52 && e.getX() < 59 && e.getY() > 449 && e.getY() < 457 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 40;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[39];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[39];
            nktz.sravnenie();
            System.out.println("severnaya osetia chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  61 && e.getX() < 69 && e.getY() > 469 && e.getY() < 479 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 41;
            System.out.println("chechenskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  61 && e.getX() < 69 && e.getY() > 469 && e.getY() < 479 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 41;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[40];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[40];
            nktz.sravnenie();
            System.out.println("chechenskaya obl. chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  67 && e.getX() < 88 && e.getY() > 423 && e.getY() < 441 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 42;
            System.out.println("stavropolskiy kray opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  67 && e.getX() < 88 && e.getY() > 423 && e.getY() < 441 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 42;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[41];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[41];
            nktz.sravnenie();
            System.out.println("stavropolskiy kray chosen, region number "+nktz.regionNumber);
        }
         else if(isOneClick && e.getX() >  198 && e.getX() < 218 && e.getY() > 398 && e.getY() < 422 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 43;
            System.out.println("bashkortostan opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  198 && e.getX() < 218 && e.getY() > 398 && e.getY() < 422 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 43;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[42];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[42];
            nktz.sravnenie();
            System.out.println("bashkortostan chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  177 && e.getX() < 187 && e.getY() > 349 && e.getY() < 359 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 44;
            System.out.println("resp. mariy_el opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  177 && e.getX() < 187 && e.getY() > 349 && e.getY() < 359 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 44;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[43];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[43];
            nktz.sravnenie();
            System.out.println("resp. mariy_el chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  141 && e.getX() < 149 && e.getY() > 355 && e.getY() < 365 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 45;
            System.out.println("resp. mordovia opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  141 && e.getX() < 149 && e.getY() > 355 && e.getY() < 365 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 45;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[44];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[44];
            nktz.sravnenie();
            System.out.println("resp. mordovia  chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  179 && e.getX() < 192 && e.getY() > 368 && e.getY() < 384 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 46;
            System.out.println("resp. tatarstan opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  179 && e.getX() < 192 && e.getY() > 368 && e.getY() < 384 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 46;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[45];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[45];
            nktz.sravnenie();
            System.out.println("resp. tatarstan  chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  204 && e.getX() < 215 && e.getY() > 361 && e.getY() < 372 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 47;
            System.out.println("resp. udmurtskaya opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  204 && e.getX() < 215 && e.getY() > 361 && e.getY() < 372 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 47;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[46];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[46];
            nktz.sravnenie();
            System.out.println("resp. udmurtskaya  chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  167 && e.getX() < 175 && e.getY() > 354 && e.getY() < 362 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 48;
            System.out.println("resp. chuvashskaya opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  167 && e.getX() < 175 && e.getY() > 354 && e.getY() < 362 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 48;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[47];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[47];
            nktz.sravnenie();
            System.out.println("resp. chuvashskaya  chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  228 && e.getX() < 243 && e.getY() > 347 && e.getY() < 374 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 49;
            System.out.println("permskiy kray opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  228 && e.getX() < 243 && e.getY() > 347 && e.getY() < 374 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 49;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[48];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[48];
            nktz.sravnenie();
            System.out.println("permskiy kray  chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  189 && e.getX() < 209 && e.getY() > 335 && e.getY() < 354 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 50;
            System.out.println("kirovskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  189 && e.getX() < 209 && e.getY() > 335 && e.getY() < 354 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 50;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[49];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[49];
            nktz.sravnenie();
            System.out.println("kirovskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  152 && e.getX() < 166 && e.getY() > 339 && e.getY() < 352&& nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 51;
            System.out.println("nizhegorodskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  152 && e.getX() < 166 && e.getY() > 339 && e.getY() < 352&& nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 51;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[50];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[50];
            nktz.sravnenie();
            System.out.println("nizhegorodskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  174 && e.getX() < 195 && e.getY() > 412 && e.getY() < 438&& nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 52;
            System.out.println("orenburgskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  174 && e.getX() < 195 && e.getY() > 412 && e.getY() < 438&& nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 52;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[51];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[51];
            nktz.sravnenie();
            System.out.println("orenburgskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  136 && e.getX() < 151 && e.getY() > 367 && e.getY() < 381 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 53;
            System.out.println("penzenskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  136 && e.getX() < 151 && e.getY() > 367 && e.getY() < 381 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 53;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[52];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[52];
            nktz.sravnenie();
            System.out.println("penzenskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  164 && e.getX() < 179 && e.getY() > 384 && e.getY() < 399 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 54;
            System.out.println("samarskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  164 && e.getX() < 179 && e.getY() > 384 && e.getY() < 399 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 54;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[53];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[53];
            nktz.sravnenie();
            System.out.println("samarskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  134 && e.getX() < 156 && e.getY() > 388 && e.getY() < 407 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 55;
            System.out.println("saratovskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  134 && e.getX() < 156 && e.getY() > 388 && e.getY() < 407 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 55;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[54];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[54];
            nktz.sravnenie();
            System.out.println("saratovskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  155 && e.getX() < 170 && e.getY() > 370 && e.getY() < 382 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 56;
            System.out.println("ulyanovskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  155 && e.getX() < 170 && e.getY() > 370 && e.getY() < 382 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 56;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[55];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[55];
            nktz.sravnenie();
            System.out.println("ulyanovskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  252 && e.getX() < 273 && e.getY() > 414 && e.getY() < 431 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 57;
            System.out.println("kurganskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  252 && e.getX() < 273 && e.getY() > 414 && e.getY() < 431 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 57;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[56];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[56];
            nktz.sravnenie();
            System.out.println("kurganskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  252 && e.getX() < 274 && e.getY() > 362 && e.getY() < 396 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 58;
            System.out.println("sverdlovskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  252 && e.getX() < 274 && e.getY() > 362 && e.getY() < 396 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 58;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[57];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[57];
            nktz.sravnenie();
            System.out.println("sverdlovskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  281 && e.getX() < 303 && e.getY() > 399 && e.getY() < 423 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 59;
            System.out.println("tymenskaya obl. opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  281 && e.getX() < 303 && e.getY() > 399 && e.getY() < 423 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 59;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[58];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[58];
            nktz.sravnenie();
            System.out.println("tymenskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  281 && e.getX() < 368 && e.getY() > 365 && e.getY() < 389 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 60;
            System.out.println("khanti_mansiyskiy okrug opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  281 && e.getX() < 368 && e.getY() > 365 && e.getY() < 389 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 60;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[59];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[59];
            nktz.sravnenie();
            System.out.println("khanti_mansiyskiy okrug  chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  327 && e.getX() < 401 && e.getY() > 315 && e.getY() < 359 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 61;
            System.out.println("yamalo_nenetzkiy okrug opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  327 && e.getX() < 401 && e.getY() > 315 && e.getY() < 359 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 61;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[60];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[60];
            nktz.sravnenie();
            System.out.println("yamalo_nenetzkiy okrug  chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  236 && e.getX() < 249 && e.getY() > 400 && e.getY() < 414 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 62;
            System.out.println("chelyabinskaya opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  236 && e.getX() < 249 && e.getY() > 400 && e.getY() < 414 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 62;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[61];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[61];
            nktz.sravnenie();
            System.out.println("chelyabinskaya chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  367 && e.getX() < 400 && e.getY() > 509 && e.getY() < 528 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 63;
            System.out.println("altay opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  367 && e.getX() < 400 && e.getY() > 509 && e.getY() < 528 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 63;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[62];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[62];
            nktz.sravnenie();
            System.out.println("altay chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  538 && e.getX() < 566 && e.getY() > 466 && e.getY() < 503 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 64;
            System.out.println("buryatia opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  538 && e.getX() < 566 && e.getY() > 466 && e.getY() < 503 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 64;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[63];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[63];
            nktz.sravnenie();
            System.out.println("buryatia chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  411 && e.getX() < 464 && e.getY() > 508 && e.getY() < 528 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 65;
            System.out.println("tiva opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  411 && e.getX() < 464 && e.getY() > 508 && e.getY() < 528 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 65;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[64];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[64];
            nktz.sravnenie();
            System.out.println("tiva chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  407 && e.getX() < 418 && e.getY() > 477 && e.getY() < 501 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 66;
            System.out.println("hakasia opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  407 && e.getX() < 418 && e.getY() > 477 && e.getY() < 501 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 66;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[65];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[65];
            nktz.sravnenie();
            System.out.println("hakasia chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  335 && e.getX() < 380 && e.getY() > 476 && e.getY() < 501 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 67;
            System.out.println("altayskiy opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  335 && e.getX() < 380 && e.getY() > 476 && e.getY() < 501 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 67;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[66];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[66];
            nktz.sravnenie();
            System.out.println("altayskiy chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  573 && e.getX() < 601 && e.getY() > 492 && e.getY() < 534 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 68;
            System.out.println("zabaykalskiy opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  573 && e.getX() < 601 && e.getY() > 492 && e.getY() < 534 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 68;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[67];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[67];
            nktz.sravnenie();
            System.out.println("zabaykalskiy chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  411 && e.getX() < 500 && e.getY() > 259 && e.getY() < 429 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 69;
            System.out.println("krasnoyarskiy opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  411 && e.getX() < 500 && e.getY() > 259 && e.getY() < 429 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 69;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[68];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[68];
            nktz.sravnenie();
            System.out.println("krasnoyarskiy chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  459 && e.getX() < 528 && e.getY() > 470 && e.getY() < 493 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 70;
            System.out.println("irkutskaya opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  459 && e.getX() < 528 && e.getY() > 470 && e.getY() < 493 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 70;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[69];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[69];
            nktz.sravnenie();
            System.out.println("irkutskaya chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  385 && e.getX() < 401 && e.getY() > 458 && e.getY() < 478 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 71;
            System.out.println("kemerovskaya opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  385 && e.getX() < 401 && e.getY() > 458 && e.getY() < 478 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 71;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[70];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[70];
            nktz.sravnenie();
            System.out.println("kemerovskaya chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  332 && e.getX() < 357 && e.getY() > 441 && e.getY() < 463 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 72;
            System.out.println("novosibirskaya opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  332 && e.getX() < 357 && e.getY() > 441 && e.getY() < 463 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 72;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[71];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[71];
            nktz.sravnenie();
            System.out.println("novosibirskaya chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  306 && e.getX() < 321 && e.getY() > 417 && e.getY() < 453 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 73;
            System.out.println("omskaya opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  306 && e.getX() < 321 && e.getY() > 417 && e.getY() < 453 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 73;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[72];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[72];
            nktz.sravnenie();
            System.out.println("omskaya chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  342 && e.getX() < 404 && e.getY() > 415 && e.getY() < 438 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 74;
            System.out.println("tomskaya opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  342 && e.getX() < 404 && e.getY() > 415 && e.getY() < 438 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 74;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[73];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[73];
            nktz.sravnenie();
            System.out.println("tomskaya chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  541 && e.getX() < 684 && e.getY() > 270 && e.getY() < 399 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 75;
            System.out.println("saha_yakutia opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  541 && e.getX() < 684 && e.getY() > 270 && e.getY() < 399 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 75;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[74];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[74];
            nktz.sravnenie();
            System.out.println("saha_yakutia chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  803 && e.getX() < 850 && e.getY() > 284 && e.getY() < 444 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 76;
            System.out.println("kamchatskiy opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  803 && e.getX() < 850 && e.getY() > 284 && e.getY() < 444 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 76;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[75];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[75];
            nktz.sravnenie();
            System.out.println("kamchatskiy chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  719 && e.getX() < 738 && e.getY() > 540 && e.getY() < 580 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 77;
            System.out.println("primorskiy opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  719 && e.getX() < 738 && e.getY() > 540 && e.getY() < 580 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 77;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[76];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[76];
            nktz.sravnenie();
            System.out.println("primorskiy chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  706 && e.getX() < 740 && e.getY() > 467 && e.getY() < 511 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 78;
            System.out.println("habarovskiy opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  706 && e.getX() < 740 && e.getY() > 467 && e.getY() < 511 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 78;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[77];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[77];
            nktz.sravnenie();
            System.out.println("habarovskiy chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  621 && e.getX() < 687 && e.getY() > 466 && e.getY() < 495 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 79;
            System.out.println("amurskaya opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  621 && e.getX() < 687 && e.getY() > 466 && e.getY() < 495 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 79;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[78];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[78];
            nktz.sravnenie();
            System.out.println("amurskaya chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  739 && e.getX() < 779 && e.getY() > 292 && e.getY() < 361 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 80;
            System.out.println("magadanskaya opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  739 && e.getX() < 779 && e.getY() > 292 && e.getY() < 361 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 80;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[79];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[79];
            nktz.sravnenie();
            System.out.println("magadanskaya chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  753 && e.getX() < 831 && e.getY() > 441 && e.getY() < 551 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 81;
            System.out.println("sakhalinskaya opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  753 && e.getX() < 831 && e.getY() > 441 && e.getY() < 551 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 81;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[80];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[80];
            nktz.sravnenie();
            System.out.println("sakhalinskaya chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  692 && e.getX() < 709 && e.getY() > 514 && e.getY() < 528 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 82;
            System.out.println("evreyskaya_aobl opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  692 && e.getX() < 709 && e.getY() > 514 && e.getY() < 528 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 82;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[81];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[81];
            nktz.sravnenie();
            System.out.println("evreyskaya_aobl chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  744 && e.getX() < 856 && e.getY() > 159 && e.getY() < 268 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 83;
            System.out.println("chukotskiy opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  744 && e.getX() < 856 && e.getY() > 159 && e.getY() < 268 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 83;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[82];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[82];
            nktz.sravnenie();
            System.out.println("chukotskiy chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  23 && e.getX() < 72 && e.getY() > 335 && e.getY() < 385 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 84;
            System.out.println("krim opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  23 && e.getX() < 72 && e.getY() > 335 && e.getY() < 385 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 84;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[83];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[83];
            nktz.sravnenie();
            System.out.println("krim chosen, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  12 && e.getX() < 24 && e.getY() > 390 && e.getY() < 402 && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 85;
            System.out.println("sevastopol opened, region number "+nktz.regionNumber);
        }
        else if(isOneClick && e.getX() >  12 && e.getX() < 24 && e.getY() > 390 && e.getY() < 402 && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 85;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[84];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[84];
            nktz.sravnenie();
            System.out.println("sevastopol chosen, region number "+nktz.regionNumber);
        }
        
        
        //map opening
        else if(e.getX() > 490 && e.getX() < 850 && e.getY() > 440 && e.getY() < 545 && nktz.status == 1){
            System.out.println("Map opened");
            nktz.start();
        }
    }
}
