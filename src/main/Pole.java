//TODO remake names in all files
package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static main.Main.frame;

public class Pole extends JPanel{

    //loading pngs
    ImageIcon chooseFirst = new ImageIcon("lib/choose_0.png");
    ImageIcon chooseSecond = new ImageIcon("lib/choose_1.png");
    ImageIcon chooseThird = new ImageIcon("lib/choose_2.png");
    ImageIcon compare = new ImageIcon("lib/compare.png");
    ImageIcon compareInfo = new ImageIcon("lib/compare_infobox.png");
    ImageIcon exit = new ImageIcon("lib/exit_main.png");
    ImageIcon exitMap = new ImageIcon("lib/exit_map.png");
    ImageIcon map = new ImageIcon("lib/map.png");
    ImageIcon mapBG = new ImageIcon("lib/map_bg.png");
    ImageIcon name = new ImageIcon("lib/name.png");
    ImageIcon regionInfo = new ImageIcon("lib/region_infobox.png");
    ImageIcon start = new ImageIcon("lib/start.png");


    Timer timer1;

    //For offsetting region names in comparison results if the names are too large
    //(the second name moves down, the third one moves to the left)

    //These are standard x,y
    static final int STANDART_REGION_NAME_X2 = 545;
    static final int STANDART_REGION_NAME_Y2 = 470;
    static final int STANDART_REGION_NAME_X3 = 775;
    static final int STANDART_REGION_NAME_Y3 = 470;
    
    //These for offsetting
    static final int BIG_REGION_NAME_X2 = 505;
    static final int BIG_REGION_NAME_Y2 = 527;
    static final int BIG_REGION_NAME_X3 = 749;
    static final int BIG_REGION_NAME_Y3 = 470;
    
    //For determination the length of the columns in comparison
    int maxChange = 0;
    int max_length;
    int length = 0;
    double rounded;

    Font mainFont = new Font("serif", Font.BOLD, 17);
    Font bigFont = new Font("serif", Font.BOLD, 22);
    Font nameFont = new Font("serif", Font.BOLD, 30);
     Pole() {
        //Loading pictures into our window

        timer1 = new Timer(100, ev -> repaint());
        timer1.start();
    }
     //Drawing our elements
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //When status = 7, program should draw background, title, buttons
        if (frame.status == 1){
        g.drawImage(mapBG.getImage(), 120, 50, this);
        g.drawImage(name.getImage(), 200, -10, this);
        g.drawImage(exit.getImage(), 480, 520, this);
        g.drawImage(start.getImage(), 480, 400, this);
        }

        //When status = 2-7, program should draw the exit button from the map, the map itself, the compare button
        if (frame.status > 1){
            g.drawImage(map.getImage(), 0, -80, this);
            g.drawImage(exitMap.getImage(), 995, 595, this);
            g.drawImage(compare.getImage(), 0, 595, this);
        }

        //When status = 4-6, program should draw level of region selection for comparison (status 4 - none selected, 5 - 1 selected, 6 - 2 regions selected)
        if (frame.status == 4){
            g.drawImage(chooseFirst.getImage(), 0, 595, this);
        }
        if (frame.status == 5){
            g.drawImage(chooseSecond.getImage(), 0, 595, this);
        }
        if (frame.status == 6){
            g.drawImage(chooseThird.getImage(), 0, 595, this);
        }

        //When status = 7, program should calculate and show comparison results
        if (frame.status == 7){
            //Drawing the window, titles, the chart itself
            g.drawImage(compareInfo.getImage(), 250, 50, this);
            g.setFont(bigFont);
            g.drawString(frame.compareName[0], 290, 470);
            if (frame.compareChange[0] > 0) {
                g.setFont(mainFont);
                g.drawString("Убыль населения: "+ frame.compareChange[0], 290, 500);
            } else {
                g.setFont(mainFont);
                g.drawString("Рост населения: "+ frame.compareChange[0]*(-1), 290, 500);
            }
            g.setFont(bigFont);

            //If one of the names are big, the grid for names are shifted (name offset, see above)
            if (isBig(frame.compareChange[0]) || isBig(frame.compareChange[1]) || isBig(frame.compareChange[2])) {

                g.drawString(frame.compareName[1], BIG_REGION_NAME_X2, BIG_REGION_NAME_Y2);
                g.drawString(frame.compareName[2], BIG_REGION_NAME_X3, BIG_REGION_NAME_Y3);
                if (frame.compareChange[1] > 0) {
                g.setFont(mainFont);
                g.drawString("Убыль населения: "+ frame.compareChange[1], BIG_REGION_NAME_X2, 557);
                } else {
                    g.setFont(mainFont);
                    g.drawString("Рост населения: "+ frame.compareChange[1]*(-1), BIG_REGION_NAME_X2, 557);
                }
                if (frame.compareChange[2] > 0) {
                g.setFont(mainFont);
                g.drawString("Убыль населения: "+ frame.compareChange[2], BIG_REGION_NAME_X3, 500);
                } else {
                    g.setFont(mainFont);
                    g.drawString("Рост населения: "+ frame.compareChange[2]*(-1), BIG_REGION_NAME_X3, 500);
                }
            } else {
                g.setFont(bigFont);
                g.drawString(frame.compareName[1], STANDART_REGION_NAME_X2, STANDART_REGION_NAME_Y2);
                g.drawString(frame.compareName[2], STANDART_REGION_NAME_X3, STANDART_REGION_NAME_Y3);
                if (frame.compareChange[1] > 0) {
                g.setFont(mainFont);
                g.drawString("Убыль населения: "+ frame.compareChange[1], STANDART_REGION_NAME_X2, STANDART_REGION_NAME_Y2+30);
                } else {
                    g.setFont(mainFont);
                    g.drawString("Рост населения: "+ frame.compareChange[1]*(-1), STANDART_REGION_NAME_X2, STANDART_REGION_NAME_Y2+30);
                }
                if (frame.compareChange[2] > 0) {
                g.setFont(mainFont);
                g.drawString("Убыль населения: "+ frame.compareChange[2], STANDART_REGION_NAME_X3, STANDART_REGION_NAME_Y3+30);
                } else {
                    g.setFont(mainFont);
                    g.drawString("Рост населения: "+ frame.compareChange[2]*(-1), STANDART_REGION_NAME_X3, STANDART_REGION_NAME_Y3+30);
                }
            }


            //determination of the largest population change
            if (frame.compareChange[0] > 0 && frame.compareChange[1] > 0 && frame.compareChange[2] > 0){
                maxChange = Math.max(frame.compareChange[0], frame.compareChange[1]);
                maxChange = Math.max(maxChange, frame.compareChange[2]);

            //Drawing the column for largest population change
                g.drawLine(300, 425, 960, 425);
                g.drawLine(300, 425, 300, 130);
                g.setFont(new Font("serif", Font.BOLD, 12));
                g.drawString("Убыль",285,120);

                max_length = 240;
                BigDecimal coefficient;
                BigDecimal firstValue;
                BigDecimal secondValue;

                //Determination of the length of the columns of other population changes relative to the largest
                //It may be hard to read and understand, sorry, I'll describe all the process later
                firstValue = new BigDecimal(frame.compareChange[0]);
                secondValue = new BigDecimal(maxChange);
                coefficient = firstValue.divide(secondValue, 2, RoundingMode.DOWN);
                rounded = coefficient.doubleValue();
                length = (int) Math.round(rounded*max_length);
                g.setColor(Color.red);
                g.fillRect(330, 425-length, 60, length);

                firstValue = new BigDecimal(frame.compareChange[1]);
                coefficient = firstValue.divide(secondValue, 2, RoundingMode.DOWN);
                rounded = coefficient.doubleValue();
                length = (int) Math.round(rounded*max_length);
                g.setColor(Color.green);
                g.fillRect(600, 425-length, 60, length);

                firstValue = new BigDecimal(frame.compareChange[2]);
                coefficient = firstValue.divide(secondValue, 2, RoundingMode.DOWN);
                rounded = coefficient.doubleValue();
                length = (int) Math.round(rounded*max_length);
                g.setColor(Color.blue);
                g.fillRect(830, 425-(length), 60, length);
            }
            // If there is not only a decrease, but also an increase, everything is the same, but the length
            // of the largest column is less and everything is drawn relative to a different coordinate
            if (frame.compareChange[0] < 0 || frame.compareChange[1] < 0 || frame.compareChange[2] < 0){
                g.drawLine(300, 425, 300, 130);
                g.drawLine(300, 280, 960, 280);
                g.setFont(new Font("serif", Font.BOLD, 12));
                g.drawString("Убыль",285,440);
                g.drawString("Прирост",285,120);

                int[] sravnit_ubil_mod = new int[3];
                sravnit_ubil_mod[0] = Math.abs(frame.compareChange[0]);
                sravnit_ubil_mod[1] = Math.abs(frame.compareChange[1]);
                sravnit_ubil_mod[2] = Math.abs(frame.compareChange[2]);

                maxChange = Math.max(sravnit_ubil_mod[0], sravnit_ubil_mod[1]);
                maxChange = Math.max(maxChange, sravnit_ubil_mod[2]);

                max_length = 120;
                BigDecimal coefficient;
                BigDecimal firstValue;
                BigDecimal secondValue;

                firstValue = new BigDecimal(sravnit_ubil_mod[0]);
                secondValue = new BigDecimal(maxChange);
                coefficient = firstValue.divide(secondValue, 2, RoundingMode.DOWN);
                rounded = coefficient.doubleValue();
                length = (int) Math.round(rounded*max_length);
                g.setColor(Color.red);
                if (frame.compareChange[0] > 0){
                    g.fillRect(330, 280, 60, length);
                } else if (frame.compareChange[0] < 0){
                    g.fillRect(330, 280-length, 60, length);
                }

                firstValue = new BigDecimal(sravnit_ubil_mod[1]);
                secondValue = new BigDecimal(maxChange);
                coefficient = firstValue.divide(secondValue, 2, RoundingMode.DOWN);
                rounded = coefficient.doubleValue();
                length = (int) Math.round(rounded*max_length);
                g.setColor(Color.green);
                if (frame.compareChange[1] > 0){
                    g.fillRect(600, 280, 60, length);
                } else if (frame.compareChange[1] < 0){
                    g.fillRect(600, 280-length, 60, length);
                }

                firstValue = new BigDecimal(sravnit_ubil_mod[2]);
                secondValue = new BigDecimal(maxChange);
                coefficient = firstValue.divide(secondValue, 2, RoundingMode.DOWN);
                rounded = coefficient.doubleValue();
                length = (int) Math.round(rounded*max_length);
                g.setColor(Color.blue);
                if (frame.compareChange[2] > 0){
                    g.fillRect(830, 280, 60, length);
                } else if (frame.compareChange[2] < 0){
                    g.fillRect(830, 280-length, 60, length);
                }
            }
        }
        //Drawing region info window
        if (frame.status == 3 && frame.regionNumber >= 0){
            g.drawImage(regionInfo.getImage(), 505, 100, this);
            g.setFont(nameFont);
            drawString(g, frame.regions[frame.regionNumber].getName(), 535, 170);
            g.setFont(mainFont);
            drawString(g, frame.regions[frame.regionNumber].getComment(),530, 200);
        }
    }

    private void drawString(Graphics g, String text, int x, int y) {
        int lineHeight = g.getFontMetrics().getHeight();
        for (String line : text.split("\n")){
            g.drawString(line, x, y);
            y += lineHeight;
        }
    }

    private Boolean isBig(int change){
         int[] bigChanges = {18013, 12416, -73695, -8832, -148922, 19156};

         for (int bigChange : bigChanges){
             if (change == bigChange){
                 return true;
             }
         }
         return false;
    }
}
