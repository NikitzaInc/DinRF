
package project;

import java.io.IOException;
import javax.swing.JFrame;


public class Project extends JFrame {
    public static Project nktz;
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
    
    //population decline array
    int[] ubil = new int[85];
    
    //regions' names array
    String[] imya = new String[85];
    
    //arrays in which data is written for comparison
    int[] sravnit_ubil = new int[3];
    String[] sravnit_imya = new String[3];
    
 public static void main(String[] args) throws IOException {
        System.out.println("Start");
        System.out.println("Created by Nikitza Inc");
        System.out.println("");
        nktz = new Project();
        nktz.setTitle("Демонстратор изменения населения РФ");
        nktz.setSize(1280, 720);     
        nktz.getContentPane();
        nktz.setResizable(false);        
        nktz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Pole pole = new Pole();
        nktz.addMouseListener(new ClickListener(nktz));
        nktz.add(pole);
        nktz.setVisible(true);
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
 public void sravnenie(){
            //population change array
            ubil[0] = -12679;
            ubil[1] = 90630;
            ubil[2] = 93436;
            ubil[3] = 20474;
            ubil[4] = 69568;
            ubil[5] = 9153;
            ubil[6] = 36658;
            ubil[7] = 26833;
            ubil[8] = 39731;
            ubil[9] = -604561;
            ubil[10] = 57843;
            ubil[11] = 50562;
            ubil[12] = 57529;
            ubil[13] = 91410;
            ubil[14] = 100393;
            ubil[15] = 96304;
            ubil[16] = 25061;
            ubil[17] = -1163064;
            ubil[18] = 31981;
            ubil[19] = 84157;
            ubil[20] = 95833;
            ubil[21] = -2160;
            ubil[22] = 46700;
            ubil[23] = -73695;
            ubil[24] = -167424;
            ubil[25] = 58275;
            ubil[26] = 39650;
            ubil[27] = 50241;
            ubil[28] = -511637;
            ubil[29] = -23132;
            ubil[30] = 18921;
            ubil[31] = -453057;
            ubil[32] = 8293;
            ubil[33] = 127365;
            ubil[34] = 88323;
            ubil[35] = -211831;
            ubil[36] = -98784;
            ubil[37] = -8832;
            ubil[38] = 12416;
            ubil[39] = 18013;
            ubil[40] = -219370;
            ubil[41] = -11903;
            ubil[42] = 46324;
            ubil[43] = 19084;
            ubil[44] = 50174;
            ubil[45] = -112016;
            ubil[46] = 24264;
            ubil[47] = 38772;
            ubil[48] = 46015;
            ubil[49] = 85025;
            ubil[50] = 120848;
            ubil[51] = 83197;
            ubil[52] = 87956;
            ubil[53] = 48684;
            ubil[54] = 113389;
            ubil[55] = 68728;
            ubil[56] = 87939;
            ubil[57] = -2627;
            ubil[58] = -371540;
            ubil[59] = -148922;
            ubil[60] = -22823;
            ubil[61] = 21628;
            ubil[62] = -14400;
            ubil[63] = -13663;
            ubil[64] = -20945;
            ubil[65] = -746;
            ubil[66] = 113002;
            ubil[67] = 50515;
            ubil[68] = -32890;
            ubil[69] = 45643;
            ubil[70] = 117485;
            ubil[71] = -126092;
            ubil[72] = 62495;
            ubil[73] = -27411;
            ubil[74] = -18455;
            ubil[75] = 9737;
            ubil[76] = 69641;
            ubil[77] = 35484;
            ubil[78] = 44158;
            ubil[79] = 17404;
            ubil[80] = 11034;
            ubil[81] = 19156;
            ubil[82] = 618;
            ubil[83] = -27530;
            ubil[84] = -68255;



            //regions' names array
            imya[0] = "Белгородская обл.";
            imya[1] = "Брянская обл.";
            imya[2] = "Владимирская обл.";
            imya[3] = "Воронежская обл.";
            imya[4] = "Ивановская обл.";
            imya[5] = "Калужская обл.";
            imya[6] = "Костромская обл.";
            imya[7] = "Курская обл.";
            imya[8] = "Липецкая обл.";
            imya[9] = "Московская обл.";
            imya[10] = "Орловская обл.";
            imya[11] = "Рязанская обл.";
            imya[12] = "Смоленская обл.";
            imya[13] = "Тамбовская обл.";
            imya[14] = "Тверская обл.";
            imya[15] = "Тульская обл.";
            imya[16] = "Ярославская обл.";
            imya[17] = "г. Москва";
            imya[18] = "Респ. Карелия";
            imya[19] = "Респ. Коми";
            imya[20] = "Архангельская обл.";
            imya[21] = "Ненецкий АО";
            imya[22] = "Вологодская обл.";
            imya[23] = "Калининградская обл.";
            imya[24] = "Ленинградская обл.";
            imya[25] = "Мурманская обл.";
            imya[26] = "Новгородская обл.";
            imya[27] = "Псковская обл.";
            imya[28] = "г.Санкт-Петербург ";
            imya[29] = "Респ. Адыгея";
            imya[30] = "Респ. Калмыкия";
            imya[31] = "Краснодарский край";
            imya[32] = "Астраханская обл.";
            imya[33] = "Волгоградская обл.";
            imya[34] = "Ростовская обл.";
            imya[35] = "Респ. Дагестан";
            imya[36] = "Респ. Ингушетия";
            imya[37] = "Кабардино-Балкария";
            imya[38] = "Карачаево-Черкессия";
            imya[39] = "Респ. Северная Осетия";
            imya[40] = "Чеченская респ.";
            imya[41] = "Ставропольский край";
            imya[42] = "Респ. Башкортостан";
            imya[43] = "Респ. Марий Эл ";
            imya[44] = "Респ. Мордовия";
            imya[45] = "Респ. Татарстан";
            imya[46] = "Удмуртская респ.";
            imya[47] = "Чувашская респ.";
            imya[48] = "Пермский край";
            imya[49] = "Кировская обл.";
            imya[50] = "Нижегородская обл.";
            imya[51] = "Оренбургская обл.";
            imya[52] = "Пензенская обл.";
            imya[53] = "Самарская обл.";
            imya[54] = "Саратовская обл.";
            imya[55] = "Ульяновская обл.";
            imya[56] = "Курганская обл.";
            imya[57] = "Свердловская обл.";
            imya[58] = "Тюменская обл. ";
            imya[59] = "Ханты-Мансийский АО";
            imya[60] = "Ямало-Ненецкий АО";
            imya[61] = "Челябинская обл.";
            imya[62] = "Респ. Алтай";
            imya[63] = "Респ. Бурятия";
            imya[64] = "Респ. Тыва";
            imya[65] = "Респ. Хакасия";
            imya[66] = "Алтайский край";
            imya[67] = "Забайкальский край";
            imya[68] = "Красноярский край ";
            imya[69] = "Иркутская обл.";
            imya[70] = "Кемеровская обл.";
            imya[71] = "Новосибирская обл.";
            imya[72] = "Омская обл.";
            imya[73] = "Томская обл.";
            imya[74] = "Респ. Саха (Якутия)";
            imya[75] = "Камчатский край";
            imya[76] = "Приморский край";
            imya[77] = "Хабаровский край";
            imya[78] = "Амурская обл.";
            imya[79] = "Магаданская обл.";
            imya[80] = "Сахалинская обл.";
            imya[81] = "Еврейская автономная обл.";
            imya[82] = "Чукотский АО";
            imya[83] = "Респ. Крым";
            imya[84] = "г. Севастополь";
     
     status = 4;
     
     //Selection procedure for comparison (statuses 4-6) and comparison totals (status 7)
     if (sravnit_ubil[0] != 0 && sravnit_ubil[1] == 0 && sravnit_ubil[2] == 0) {
         status = 5;
         System.out.println("Region chosen, " + sravnit_imya[0]+", 1/3");
         System.out.println("Убыль в регионе: "+ sravnit_ubil[0]);
         System.out.println("Status " +status);
     }
     else if (sravnit_ubil[0] != 0 && sravnit_ubil[1] != 0 && sravnit_ubil[2] == 0) {
         status = 6;
         System.out.println("Region chosen, " + sravnit_imya[1]+", 2/3");
         System.out.println("Убыль в регионе: "+ sravnit_ubil[1]);
         System.out.println("Status " +status);
     }
     else if (sravnit_ubil[0] != 0 && sravnit_ubil[1] != 0 && sravnit_ubil[2] != 0) {
         status = 7;
         System.out.println("Region chosen, " + sravnit_imya[2]+", 3/3");
         System.out.println("Убыль в регионе: "+ sravnit_ubil[2]);
         System.out.println("Status " +status);
     }
     
 }
}

    
   
    


