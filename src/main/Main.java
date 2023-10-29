
package main;

import javax.swing.JFrame;



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

    //population decline array
    int[] value = new int[85];

    //regions' names array
    String[] regionName = new String[85];

    //arrays in which data is written for comparison
    int[] sravnit_ubil = new int[3];
    String[] sravnit_imya = new String[3];

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
     //population change array
     value[0] = -12679;
     value[1] = 90630;
     value[2] = 93436;
     value[3] = 20474;
     value[4] = 69568;
     value[5] = 9153;
     value[6] = 36658;
     value[7] = 26833;
     value[8] = 39731;
     value[9] = -604561;
     value[10] = 57843;
     value[11] = 50562;
     value[12] = 57529;
     value[13] = 91410;
     value[14] = 100393;
     value[15] = 96304;
     value[16] = 25061;
     value[17] = -1163064;
     value[18] = 31981;
     value[19] = 84157;
     value[20] = 95833;
     value[21] = -2160;
     value[22] = 46700;
     value[23] = -73695;
     value[24] = -167424;
     value[25] = 58275;
     value[26] = 39650;
     value[27] = 50241;
     value[28] = -511637;
     value[29] = -23132;
     value[30] = 18921;
     value[31] = -453057;
     value[32] = 8293;
     value[33] = 127365;
     value[34] = 88323;
     value[35] = -211831;
     value[36] = -98784;
     value[37] = -8832;
     value[38] = 12416;
     value[39] = 18013;
     value[40] = -219370;
     value[41] = -11903;
     value[42] = 46324;
     value[43] = 19084;
     value[44] = 50174;
     value[45] = -112016;
     value[46] = 24264;
     value[47] = 38772;
     value[48] = 46015;
     value[49] = 85025;
     value[50] = 120848;
     value[51] = 83197;
     value[52] = 87956;
     value[53] = 48684;
     value[54] = 113389;
     value[55] = 68728;
     value[56] = 87939;
     value[57] = -2627;
     value[58] = -371540;
     value[59] = -148922;
     value[60] = -22823;
     value[61] = 21628;
     value[62] = -14400;
     value[63] = -13663;
     value[64] = -20945;
     value[65] = -746;
     value[66] = 113002;
     value[67] = 50515;
     value[68] = -32890;
     value[69] = 45643;
     value[70] = 117485;
     value[71] = -126092;
     value[72] = 62495;
     value[73] = -27411;
     value[74] = -18455;
     value[75] = 9737;
     value[76] = 69641;
     value[77] = 35484;
     value[78] = 44158;
     value[79] = 17404;
     value[80] = 11034;
     value[81] = 19156;
     value[82] = 618;
     value[83] = -27530;
     value[84] = -68255;

     //regions' names array
     regionName[0] = "Белгородская обл.";
     regionName[1] = "Брянская обл.";
     regionName[2] = "Владимирская обл.";
     regionName[3] = "Воронежская обл.";
     regionName[4] = "Ивановская обл.";
     regionName[5] = "Калужская обл.";
     regionName[6] = "Костромская обл.";
     regionName[7] = "Курская обл.";
     regionName[8] = "Липецкая обл.";
     regionName[9] = "Московская обл.";
     regionName[10] = "Орловская обл.";
     regionName[11] = "Рязанская обл.";
     regionName[12] = "Смоленская обл.";
     regionName[13] = "Тамбовская обл.";
     regionName[14] = "Тверская обл.";
     regionName[15] = "Тульская обл.";
     regionName[16] = "Ярославская обл.";
     regionName[17] = "г. Москва";
     regionName[18] = "Респ. Карелия";
     regionName[19] = "Респ. Коми";
     regionName[20] = "Архангельская обл.";
     regionName[21] = "Ненецкий АО";
     regionName[22] = "Вологодская обл.";
     regionName[23] = "Калининградская обл.";
     regionName[24] = "Ленинградская обл.";
     regionName[25] = "Мурманская обл.";
     regionName[26] = "Новгородская обл.";
     regionName[27] = "Псковская обл.";
     regionName[28] = "г.Санкт-Петербург ";
     regionName[29] = "Респ. Адыгея";
     regionName[30] = "Респ. Калмыкия";
     regionName[31] = "Краснодарский край";
     regionName[32] = "Астраханская обл.";
     regionName[33] = "Волгоградская обл.";
     regionName[34] = "Ростовская обл.";
     regionName[35] = "Респ. Дагестан";
     regionName[36] = "Респ. Ингушетия";
     regionName[37] = "Кабардино-Балкария";
     regionName[38] = "Карачаево-Черкессия";
     regionName[39] = "Респ. Северная Осетия";
     regionName[40] = "Чеченская респ.";
     regionName[41] = "Ставропольский край";
     regionName[42] = "Респ. Башкортостан";
     regionName[43] = "Респ. Марий Эл ";
     regionName[44] = "Респ. Мордовия";
     regionName[45] = "Респ. Татарстан";
     regionName[46] = "Удмуртская респ.";
     regionName[47] = "Чувашская респ.";
     regionName[48] = "Пермский край";
     regionName[49] = "Кировская обл.";
     regionName[50] = "Нижегородская обл.";
     regionName[51] = "Оренбургская обл.";
     regionName[52] = "Пензенская обл.";
     regionName[53] = "Самарская обл.";
     regionName[54] = "Саратовская обл.";
     regionName[55] = "Ульяновская обл.";
     regionName[56] = "Курганская обл.";
     regionName[57] = "Свердловская обл.";
     regionName[58] = "Тюменская обл. ";
     regionName[59] = "Ханты-Мансийский АО";
     regionName[60] = "Ямало-Ненецкий АО";
     regionName[61] = "Челябинская обл.";
     regionName[62] = "Респ. Алтай";
     regionName[63] = "Респ. Бурятия";
     regionName[64] = "Респ. Тыва";
     regionName[65] = "Респ. Хакасия";
     regionName[66] = "Алтайский край";
     regionName[67] = "Забайкальский край";
     regionName[68] = "Красноярский край ";
     regionName[69] = "Иркутская обл.";
     regionName[70] = "Кемеровская обл.";
     regionName[71] = "Новосибирская обл.";
     regionName[72] = "Омская обл.";
     regionName[73] = "Томская обл.";
     regionName[74] = "Респ. Саха (Якутия)";
     regionName[75] = "Камчатский край";
     regionName[76] = "Приморский край";
     regionName[77] = "Хабаровский край";
     regionName[78] = "Амурская обл.";
     regionName[79] = "Магаданская обл.";
     regionName[80] = "Сахалинская обл.";
     regionName[81] = "Еврейская автономная обл.";
     regionName[82] = "Чукотский АО";
     regionName[83] = "Респ. Крым";
     regionName[84] = "г. Севастополь";
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
     else if (sravnit_ubil[0] != 0 && sravnit_ubil[1] != 0) {
         status = 7;
         System.out.println("Region chosen, " + sravnit_imya[2]+", 3/3");
         System.out.println("Убыль в регионе: "+ sravnit_ubil[2]);
         System.out.println("Status " +status);
     }
     
 }
}

    
   
    


