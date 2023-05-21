//TODO update this file
package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Image;
import java.math.BigDecimal;
import java.math.RoundingMode;
import static project.Project.nktz;

public class Pole extends JPanel{

    public static Pole regionInfoSelect;
    

    //для загрузки картинок
    static final String VIHOD = "/vihod.png";
    static final String REGION_INFO = "/region_info.png";
    static final String NACHAT = "/nachat.png";
    static final String MAP_VOID = "/map_void.png";
    static final String MAP_FON = "/map_fon.png";
    static final String FLAG = "/flag_hule.png";
    static final String NAZV = "/nazv.png";
    static final String VIHOD_MAP = "/vihod_map.png";
    static final String SRAVNIT = "/sravnit.png";
    static final String VIBOR_0 = "/vibor_0.png";
    static final String VIBOR_1 = "/vibor_1.png";
    static final String VIBOR_2 = "/vibor_2.png";
    static final String SRAVNIT_INFO = "/sravnit_info.png";

    Image vihod, vihod_map, region_info, nachat, map_void, flag_hule, map_fon, nazv, sravnit, vibor_0, vibor_1, vibor_2, sravnit_info;
    Timer timer1;

    //для оффсета названий регионов в сравнении (второе название сдвигается вниз, третье влево)
    static final int STANDART_REGION_NAME_X2 = 545;
    static final int STANDART_REGION_NAME_Y2 = 470;
    static final int STANDART_REGION_NAME_X3 = 775;
    static final int STANDART_REGION_NAME_Y3 = 470;
    
    static final int BIG_REGION_NAME_X2 = 505;
    static final int BIG_REGION_NAME_Y2 = 527;
    static final int BIG_REGION_NAME_X3 = 749;
    static final int BIG_REGION_NAME_Y3 = 470;
    
    //Для определения длины столбиков в сравнении
    int naibol = 0;
    int max_length;
    int length = 0;
    double okruglenie_2;
    
     Pole() {

        //для загрузки картинок
        vihod = kartinki.loadResourceImage(VIHOD);
        region_info = kartinki.loadResourceImage(REGION_INFO);
        nachat = kartinki.loadResourceImage(NACHAT);
        map_void = kartinki.loadResourceImage(MAP_VOID);
        map_fon = kartinki.loadResourceImage(MAP_FON);
        flag_hule = kartinki.loadResourceImage(FLAG);
        nazv = kartinki.loadResourceImage(NAZV);
        vihod_map = kartinki.loadResourceImage(VIHOD_MAP);
        sravnit = kartinki.loadResourceImage(SRAVNIT);
        vibor_0 = kartinki.loadResourceImage(VIBOR_0);
        vibor_1 = kartinki.loadResourceImage(VIBOR_1);
        vibor_2 = kartinki.loadResourceImage(VIBOR_2);
        sravnit_info = kartinki.loadResourceImage(SRAVNIT_INFO);

        timer1 = new Timer(100, ev -> repaint());
        timer1.start();

    }
     //Отрисовывание всякого на экране
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //статус = 1, отрисовывается фон, название, кнопки
        if (nktz.status == 1){
        g.drawImage(map_fon, 120, 50, this);
        g.drawImage(nazv, 200, -10, this);
        //g.drawImage(flag_hule, 970, 430, this);  - решил флаг не делать, какой-то кринж получается
        g.drawImage(vihod, 480, 520, this);
        g.drawImage(nachat, 480, 400, this);
        }
        
        //статусы 2-7, отрисовывание выхода с карты, самой карты, кнопки сравнения
        if (nktz.status > 1){
            g.drawImage(map_void, 0, -80, this);
            g.drawImage(vihod_map, 995, 595, this);
            g.drawImage(sravnit, 0, 595, this);
        }
        
        //статусы 4-6, выбор региона для сравнения (статус 4 - ни один не выбран, 5 - 1 выбран, 6 - выбраны 2 региона)
        if (nktz.status == 4){
            g.drawImage(vibor_0, 0, 595, this);
        }
        if (nktz.status == 5){
            g.drawImage(vibor_1, 0, 595, this);
        }
        if (nktz.status == 6){
            g.drawImage(vibor_2, 0, 595, this);
        }
        
        //статус 7, окно сравнения
        if (nktz.status == 7){
            //отрисовка окна, названий, самой диаграммы
            g.drawImage(sravnit_info, 250, 50, this);
            g.setFont(new Font("serif", 1, 22));
            g.drawString(nktz.sravnit_imya[0], 290, 470);
            if (nktz.sravnit_ubil[0] > 0) {
                g.setFont(new Font("serif", 1, 17));
                g.drawString("Убыль населения: "+ nktz.sravnit_ubil[0], 290, 500);
            } else {
                g.setFont(new Font("serif", 1, 17));
                g.drawString("Рост населения: "+ nktz.sravnit_ubil[0]*(-1), 290, 500);
            }
            g.setFont(new Font("serif", 1, 22));
            
            //если 1 из заявленных в сравнение убылей равна вот этим числам, названия сдвигаются(оффсет названий, смотри выше)
            if (nktz.sravnit_ubil[0] == 18013 || nktz.sravnit_ubil[1] == 18013 || nktz.sravnit_ubil[2] == 18013 || nktz.sravnit_ubil[0] == 12416 || nktz.sravnit_ubil[1] == 12416 || nktz.sravnit_ubil[2] == 12416 || nktz.sravnit_ubil[0] == -73695 || nktz.sravnit_ubil[1] == -73695 || nktz.sravnit_ubil[2] == -73695 || nktz.sravnit_ubil[0] == -8832 || nktz.sravnit_ubil[1] == -8832 || nktz.sravnit_ubil[2] == -8832 || nktz.sravnit_ubil[0] == -148922 || nktz.sravnit_ubil[1] == -148922 || nktz.sravnit_ubil[2] == -148922 || nktz.sravnit_ubil[0] == 19156 || nktz.sravnit_ubil[1] == 19156 || nktz.sravnit_ubil[2] == 19156){
                
                g.drawString(nktz.sravnit_imya[1], BIG_REGION_NAME_X2, BIG_REGION_NAME_Y2);
                g.drawString(nktz.sravnit_imya[2], BIG_REGION_NAME_X3, BIG_REGION_NAME_Y3);
                if (nktz.sravnit_ubil[1] > 0) {
                g.setFont(new Font("serif", 1, 17));
                g.drawString("Убыль населения: "+ nktz.sravnit_ubil[1], BIG_REGION_NAME_X2, 557);
                } else {
                    g.setFont(new Font("serif", 1, 17));
                    g.drawString("Рост населения: "+ nktz.sravnit_ubil[1]*(-1), BIG_REGION_NAME_X2, 557);
                }
                if (nktz.sravnit_ubil[2] > 0) {
                g.setFont(new Font("serif", 1, 17));
                g.drawString("Убыль населения: "+ nktz.sravnit_ubil[2], BIG_REGION_NAME_X3, 500);
                } else {
                    g.setFont(new Font("serif", 1, 17));
                    g.drawString("Рост населения: "+ nktz.sravnit_ubil[2]*(-1), BIG_REGION_NAME_X3, 500);
                }
            } else {
                g.setFont(new Font("serif", 1, 22));
                g.drawString(nktz.sravnit_imya[1], STANDART_REGION_NAME_X2, STANDART_REGION_NAME_Y2);
                g.drawString(nktz.sravnit_imya[2], STANDART_REGION_NAME_X3, STANDART_REGION_NAME_Y3);
                if (nktz.sravnit_ubil[1] > 0) {
                g.setFont(new Font("serif", 1, 17));
                g.drawString("Убыль населения: "+ nktz.sravnit_ubil[1], STANDART_REGION_NAME_X2, STANDART_REGION_NAME_Y2+30);
                } else {
                    g.setFont(new Font("serif", 1, 17));
                    g.drawString("Рост населения: "+ nktz.sravnit_ubil[1]*(-1), STANDART_REGION_NAME_X2, STANDART_REGION_NAME_Y2+30);
                }
                if (nktz.sravnit_ubil[2] > 0) {
                g.setFont(new Font("serif", 1, 17));
                g.drawString("Убыль населения: "+ nktz.sravnit_ubil[2], STANDART_REGION_NAME_X3, STANDART_REGION_NAME_Y3+30);
                } else {
                    g.setFont(new Font("serif", 1, 17));
                    g.drawString("Рост населения: "+ nktz.sravnit_ubil[2]*(-1), STANDART_REGION_NAME_X3, STANDART_REGION_NAME_Y3+30);
                }
            }
            
            
            //определение наибольшей убыли
            if (nktz.sravnit_ubil[0] > 0 && nktz.sravnit_ubil[1] > 0 &&nktz.sravnit_ubil[2] > 0){
                if (nktz.sravnit_ubil[0]>nktz.sravnit_ubil[1]){
                    naibol = nktz.sravnit_ubil[0];
                }else {
                    naibol = nktz.sravnit_ubil[1];
                }
            if (naibol < nktz.sravnit_ubil[2]){
                    naibol = nktz.sravnit_ubil[2];
                }
            //отрисовка столбика наибольшей убыли
                g.drawLine(300, 425, 960, 425);
                g.drawLine(300, 425, 300, 130);
                g.setFont(new Font("serif", 1, 12));
                g.drawString("Убыль",285,120);
                
                max_length = 240;
                BigDecimal otnoshenie;
                BigDecimal firstValue;
                BigDecimal secondValue;
                
                //определение длины столбиков других убылей относительно наибольшей
                firstValue = new BigDecimal(nktz.sravnit_ubil[0]);
                secondValue = new BigDecimal(naibol);
                otnoshenie = firstValue.divide(secondValue, 2, RoundingMode.DOWN);
                okruglenie_2 = otnoshenie.doubleValue();
                length = (int) Math.round(okruglenie_2*max_length);
                g.setColor(Color.red);
                g.fillRect(330, 425-length, 60, length);
                
                firstValue = new BigDecimal(nktz.sravnit_ubil[1]);
                secondValue = new BigDecimal(naibol);
                otnoshenie = firstValue.divide(secondValue, 2, RoundingMode.DOWN);
                okruglenie_2 = otnoshenie.doubleValue();
                length = (int) Math.round(okruglenie_2*max_length);
                g.setColor(Color.green);
                g.fillRect(600, 425-length, 60, length);
                
                firstValue = new BigDecimal(nktz.sravnit_ubil[2]);
                secondValue = new BigDecimal(naibol);
                otnoshenie = firstValue.divide(secondValue, 2, RoundingMode.DOWN);
                okruglenie_2 = otnoshenie.doubleValue();
                length = (int) Math.round(okruglenie_2*max_length);
                g.setColor(Color.blue);
                g.fillRect(830, 425-(length), 60, length);
            }
            //если есть не только убыль, но и прирост, всё тоже самое, но длина наибольшего столбика меньше и всё отрисовывается относительно другой координаты
            if (nktz.sravnit_ubil[0] < 0 || nktz.sravnit_ubil[1] < 0 || nktz.sravnit_ubil[2] < 0){
                g.drawLine(300, 425, 300, 130);
                g.drawLine(300, 280, 960, 280);
                g.setFont(new Font("serif", 1, 12));
                g.drawString("Убыль",285,440);
                g.drawString("Прирост",285,120);
                
                int[] sravnit_ubil_mod = new int[3];
                sravnit_ubil_mod[0] = Math.abs(nktz.sravnit_ubil[0]);
                sravnit_ubil_mod[1] = Math.abs(nktz.sravnit_ubil[1]); 
                sravnit_ubil_mod[2] = Math.abs(nktz.sravnit_ubil[2]);
                
                if (sravnit_ubil_mod[0]>sravnit_ubil_mod[1]){
                    naibol = sravnit_ubil_mod[0];
                }else {
                    naibol = sravnit_ubil_mod[1];
                }
            if (naibol < sravnit_ubil_mod[2]){
                    naibol = sravnit_ubil_mod[2];
                }
                
                max_length = 120; 
                BigDecimal otnoshenie;
                BigDecimal firstValue;
                BigDecimal secondValue;
                
                firstValue = new BigDecimal(sravnit_ubil_mod[0]);
                secondValue = new BigDecimal(naibol);
                otnoshenie = firstValue.divide(secondValue, 2, RoundingMode.DOWN);
                okruglenie_2 = otnoshenie.doubleValue();
                length = (int) Math.round(okruglenie_2*max_length);
                g.setColor(Color.red);
                if (nktz.sravnit_ubil[0] > 0){
                    g.fillRect(330, 280, 60, length);
                } else if (nktz.sravnit_ubil[0] < 0){
                    g.fillRect(330, 280-length, 60, length);
                }
                
                
                firstValue = new BigDecimal(sravnit_ubil_mod[1]);
                secondValue = new BigDecimal(naibol);
                otnoshenie = firstValue.divide(secondValue, 2, RoundingMode.DOWN);
                okruglenie_2 = otnoshenie.doubleValue();
                length = (int) Math.round(okruglenie_2*max_length);
                g.setColor(Color.green);
                if (nktz.sravnit_ubil[1] > 0){
                    g.fillRect(600, 280, 60, length);
                } else if (nktz.sravnit_ubil[1] < 0){
                    g.fillRect(600, 280-length, 60, length);
                }
                
                firstValue = new BigDecimal(sravnit_ubil_mod[2]);
                secondValue = new BigDecimal(naibol);
                otnoshenie = firstValue.divide(secondValue, 2, RoundingMode.DOWN);
                okruglenie_2 = otnoshenie.doubleValue();
                length = (int) Math.round(okruglenie_2*max_length);
                g.setColor(Color.blue);
                if (nktz.sravnit_ubil[2] > 0){
                    g.fillRect(830, 280, 60, length);
                } else if (nktz.sravnit_ubil[2] < 0){
                    g.fillRect(830, 280-length, 60, length);
                }
            }
 
            
            
        }
        //оотрисовка окна информации о регионе
        if (nktz.status == 3 && nktz.regionNumber > 0){
            g.drawImage(region_info, 505, 100, this);

        }
        //РЕГИОНЫ
        //тут описание и убыль 85 регионов, население которых было в документах переписей 2010 и 2020
        if (nktz.status == 3 && nktz.regionNumber == 1){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Белгородская область", 535, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Белгоро́дская о́бласть — субъект",530, 200);
            g.drawString("Российской Федерации, расположен ",530, 215);
            g.drawString("в юго-западной части России в ", 530, 230);
            g.drawString("500—700 км к югу от Москвы, на ", 530, 245);
            g.drawString("границе с Украиной. Крупнейшие ", 530, 260);
            g.drawString("города: Белгород — 391 804 чел., ", 530, 275);
            g.drawString("Старый Оскол — 223 921 чел., ", 530, 290);
            g.drawString("Губкин — 86 229 человек." , 530, 305);
            g.drawString("Белгородская область образована ", 530, 320);
            g.drawString("6 января 1954 года. С этого момента", 530, 335);
            g.drawString("её границы не изменялись.", 530, 350);
            g.drawString("Население в 2010 г. : 1532526 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 1545205 чел.", 530, 415);
            g.drawString("Прирост населения: 12679 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 2){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Брянская область", 555, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Бря́нская о́бласть — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Центрального федерального округа, ", 530, 230);
            g.drawString("расположенный к юго-западу от Москвы, ", 530, 245);
            g.drawString("на границе с Украиной, Бедоруссией", 530, 260);
            g.drawString("Областной центр — город Брянск.", 530, 275);
            g.drawString("Население в 2010 г. : 1278217 чел.", 530, 315);
            g.drawString("Население в 2020 г. : 1187587 чел.", 530, 340);
            g.drawString("Убыль населения: 90630 чел.", 530, 365);
        }
        if (nktz.status == 3 && nktz.regionNumber == 3){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Владимирская область", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Владимирская о́бласть — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Центрального федерального округа.", 530, 230);
            g.drawString("Граничит с Московской, Ярославской,", 530, 245);
            g.drawString("Ивановской, Рязанской, Нижегородской", 530, 260);
            g.drawString("областями. Областной центр —", 530, 275);
            g.drawString("город Владимир, расстояние от ", 530, 290);
            g.drawString("Владимира до Москвы — 178 км." , 530, 305);
            g.drawString("Образована 14 августа 1944г. указом", 530, 320);
            g.drawString("Президиума Верховного Совета СССР.", 530, 335);
            g.drawString("Население в 2010 г. : 1443693 чел.", 530, 375);
            g.drawString("Население в 2020 г. : 1342099 чел.", 530, 400);
            g.drawString("Убыль населения: 101594 чел.", 530, 425);
        }
        if (nktz.status == 3 && nktz.regionNumber == 4){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Воронежская область", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Воро́нежская о́бласть — субъект",530, 200);
            g.drawString("Российской Федерации, область в  ",530, 215);
            g.drawString("европейской части России. Входит в", 530, 230);
            g.drawString("состав Центрального федерального", 530, 245);
            g.drawString("округа. Образована 13 июня 1934 года. ", 530, 260);
            g.drawString("Административный центр области - ", 530, 275);
            g.drawString("город Воронеж, расстояние от", 530, 290);
            g.drawString("Воронежа до Москвы - около 515 км.", 530, 305);
            g.drawString("Население в 2010 г. : 2335380 чел.", 530, 345);
            g.drawString("Население в 2020 г. : 2305608 чел.", 530, 370);
            g.drawString("Убыль населения: 29772 чел.", 530, 395);
        }
        if (nktz.status == 3 && nktz.regionNumber == 5){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Ивановская область", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Ива́новская о́бласть — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Центрального федерального округа.", 530, 230);
            g.drawString("Граничит с Ярославской, Костромской", 530, 245);
            g.drawString("Владимирской, Нижегородской обл.", 530, 260);
            g.drawString("Площадь — 21 437 км². Областной", 530, 275);
            g.drawString("центр - город Иваново, расстояние от ", 530, 290);
            g.drawString("Иванова до Москвы — 178 км." , 530, 305);
            g.drawString("Население в 2010 г. : 1061651 чел.", 530, 345);
            g.drawString("Население в 2020 г. : 992083 чел.", 530, 370);
            g.drawString("Убыль населения: 69568 чел.", 530, 395);
        }
        if (nktz.status == 3 && nktz.regionNumber == 6){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Калужская область", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Калужская о́бласть — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Центрального федерального округа.", 530, 230);
            g.drawString("Расположена в центре Европейской ", 530, 245);
            g.drawString("части России. Образована в 1944 году.", 530, 260);
            g.drawString("Граничит с Московской, Тульской, ", 530, 275);
            g.drawString("Брянской, Смоленской, Орловской ", 530, 290);
            g.drawString("областями. Площадь — 29 777 км²." , 530, 305);
            g.drawString("Областной центр — город Калуга,", 530, 320);
            g.drawString("расположенный в 143 км от МКАД.", 530, 335);
            g.drawString("Население в 2010 г. : 1010930 чел.", 530, 375);
            g.drawString("Население в 2020 г. : 1001777 чел.", 530, 400);
            g.drawString("Убыль населения: 9153 чел.", 530, 425);
        }
        if (nktz.status == 3 && nktz.regionNumber == 7){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Костромская область", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Костромска́я о́бласть — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Центрального федерального округа.", 530, 230);
            g.drawString("Административный центр — Кострома.", 530, 245);
            g.drawString("Другие крупнейшие города области -", 530, 260);
            g.drawString("Буй, Шарья, Нерехта.", 530, 275);
            g.drawString("Территория области - 60'211 км².", 530, 290);
            g.drawString("Наименьший по численности регион", 530, 305);
            g.drawString("в своём федеральном округе.", 530, 320);
            g.drawString("Население в 2010 г. : 667562 чел.", 530, 360);
            g.drawString("Население в 2020 г. : 630904 чел.", 530, 385);
            g.drawString("Убыль населения: 36658 чел.", 530, 410);
        }
        if (nktz.status == 3 && nktz.regionNumber == 8){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Курская область", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Курская о́бласть — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Центрального федерального округа.", 530, 230);
            g.drawString("Административный центр — г. Курск.", 530, 245);
            g.drawString("Курская область граничит с Брянской,", 530, 260);
            g.drawString("Орловской, Липецкой, Воронежской", 530, 275);
            g.drawString("и Белгородской областями.", 530, 290);
            g.drawString("Образована 13 июня 1934 года." , 530, 305);
            g.drawString("Население в 2010 г. : 1127081 чел.", 530, 345);
            g.drawString("Население в 2020 г. : 1100248 чел.", 530, 370);
            g.drawString("Убыль населения: 26833 чел.", 530, 395);
        }
        if (nktz.status == 3 && nktz.regionNumber == 9){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Ли́пецкая область", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Ли́пецкая о́бласть — субъект",530, 200);
            g.drawString("Российской Федерации. Областн. центр -",530, 215);
            g.drawString("город Липецк. Площадь — 24 047 км².", 530, 230);
            g.drawString("Выделена и создана 6 января 1954 г. из", 530, 245);
            g.drawString("смежных районов Курской, Воронежской,", 530, 260);
            g.drawString("Рязанской и Орловской областей.", 530, 275);
            g.drawString("Область граничит с Курской, Орловской,", 530, 290);
            g.drawString("Тульской, Рязанской, Тамбовской " , 530, 305);
            g.drawString("и Воронежской областями.", 530, 320);
            g.drawString("Население в 2010 г. : 1173513 чел.", 530, 360);
            g.drawString("Население в 2020 г. : 1133782 чел.", 530, 385);
            g.drawString("Убыль населения: 39731 чел.", 530, 410);
        }
        if (nktz.status == 3 && nktz.regionNumber == 10){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Моско́вская о́бласть", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Моско́вская о́бласть — субъект",530, 200);
            g.drawString("Российской Федерации, входящий в",530, 215);
            g.drawString("состав Центрального фед. округа.",530, 230);
            g.drawString("Административный центр - город", 530, 245);
            g.drawString("Москва (не входит в состав области).", 530, 260);
            g.drawString("Область находится в центральной части", 530, 275);
            g.drawString("Восточно-Европейской равнины.", 530, 290);
            g.drawString("Граничит с Тверской, Владимирской," , 530, 305);
            g.drawString("Рязанской, Тульской, Калужской,", 530, 320);
            g.drawString("Смоленской, Ярославской областями.", 530, 335);
            g.drawString("Образована 14 января 1929 года.", 530, 350);
            g.drawString("Население в 2010 г. : 7095120 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 7699681 чел.", 530, 415);
            g.drawString("Прирост населения: 604 561 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 11){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Орло́вская область", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Орло́вская область — субъект",530, 200);
            g.drawString("Российской Федерации. Областн. центр -",530, 215);
            g.drawString("город Орёл. Площадь — 24 652 км².", 530, 230);
            g.drawString("Образована — 27 сентября 1937 года.", 530, 245);
            g.drawString("Граничит с областями: на севере с ", 530, 260);
            g.drawString("Тульской, на востоке с Липецкой,", 530, 275);
            g.drawString("на юге с Курской, на западе с Брянской,", 530, 290);
            g.drawString("на северо-западе с Калужской." , 530, 305);
            g.drawString("Население в 2010 г. : 786935 чел.", 530, 345);
            g.drawString("Население в 2020 г. : 729092 чел.", 530, 370);
            g.drawString("Убыль населения: 57 843 чел.", 530, 395);
        }
        if (nktz.status == 3 && nktz.regionNumber == 12){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Ряза́нская о́бласть", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Ряза́нская о́бласть — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Центрального федерального округа.", 530, 230);
            g.drawString("Административный центр - город Рязань.", 530, 245);
            g.drawString("Образована 26 сентября 1937 года.", 530, 260);
            g.drawString("Граничит с Владимирской, Тамбовской,", 530, 275);
            g.drawString("Пензенской, Нижегородской, Липецкой,", 530, 290);
            g.drawString("Тульской, Московской областями." , 530, 305);
            g.drawString("Население в 2010 г. : 1154114 чел.", 530, 360);
            g.drawString("Население в 2020 г. : 1103552 чел.", 530, 385);
            g.drawString("Убыль населения: 50 562 чел.", 530, 410);
        }
        if (nktz.status == 3 && nktz.regionNumber == 13){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Cмоленская о́бласть", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Смоле́нская о́бласть — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Центрального федерального округа.", 530, 230);
            g.drawString("Административный центр - г. Смоленск.", 530, 245);
            g.drawString("Образована 27 сентября 1937 года.", 530, 260);
            g.drawString("Граничит с Псковской, Тверской,", 530, 275);
            g.drawString("Московской, Калужской, Брянской,", 530, 290);
            g.drawString("областями, а также Белоруссией." , 530, 305);
            g.drawString("Население в 2010 г. : 985537 чел.", 530, 360);
            g.drawString("Население в 2020 г. : 928008 чел.", 530, 385);
            g.drawString("Убыль населения: 57 529 чел.", 530, 410);
        }
        if (nktz.status == 3 && nktz.regionNumber == 14){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Тамбовская о́бласть", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Тамбовская о́бласть — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Центрального федерального округа.", 530, 230);
            g.drawString("Административный центр - город Тамбов.", 530, 245);
            g.drawString("Образована 26 сентября 1937 года.", 530, 260);
            g.drawString("Граничит с Рязанской, Пензенской,", 530, 275);
            g.drawString("Саратовской, Воронежской и Липецкой", 530, 290);
            g.drawString("областями." , 530, 305);
            g.drawString("Население в 2010 г. : 1091994 чел.", 530, 360);
            g.drawString("Население в 2020 г. : 1000584 чел.", 530, 385);
            g.drawString("Убыль населения: 91 410 чел.", 530, 410);
        }
        if (nktz.status == 3 && nktz.regionNumber == 15){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Тверская о́бласть", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Тверская о́бласть — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Центрального федерального округа.", 530, 230);
            g.drawString("Административный центр - город Тверь.", 530, 245);
            g.drawString("Образована в 1990 г. на территории", 530, 260);
            g.drawString("бывшей Калининской области.", 530, 275);
            g.drawString("Граничит с Московской, Ярославской,", 530, 290);
            g.drawString("Вологодской, Новгородской, Смоленской," , 530, 305);
            g.drawString("Псковской областями." , 530, 320);
            g.drawString("Население в 2010 г. : 1353392 чел.", 530, 475);
            g.drawString("Население в 2020 г. : 1252999 чел.", 530, 500);
            g.drawString("Убыль населения: 100393 чел.", 530, 525);
        }
        if (nktz.status == 3 && nktz.regionNumber == 16){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Тульская о́бласть", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Тульская о́бласть — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Центрального федерального округа.", 530, 230);
            g.drawString("Административный центр - город Тула.", 530, 245);
            g.drawString("Занимает площадь 25,7 тыс. кв. км.", 530, 260);
            g.drawString("Граничит с Московской, Рязанской,", 530, 275);
            g.drawString("Орловской, Калужской, Липецкой,", 530, 290);
            g.drawString("областями. Образована 26.09.1937." , 530, 305);
            g.drawString("Население в 2010 г. : 1553925 чел.", 530, 360);
            g.drawString("Население в 2020 г. : 1457621 чел.", 530, 385);
            g.drawString("Убыль населения: 96304 чел.", 530, 410);
        }
        if (nktz.status == 3 && nktz.regionNumber == 17){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Ярославская о́бласть", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Ярославская о́бласть — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Центрального федерального округа.", 530, 230);
            g.drawString("Административный центр - город ", 530, 245);
            g.drawString("Ярославль. Образована 11 марта 1936 г.", 530, 260);
            g.drawString("Граничит с Владимирской, Вологодской,", 530, 275);
            g.drawString("Ивановской, Костромской, Тверской,", 530, 290);
            g.drawString("и Московской областями." , 530, 305);
            g.drawString("Площадь области - 36,2 тыс. км²" , 530, 320);
            g.drawString("Население в 2010 г. : 1272468 чел.", 530, 375);
            g.drawString("Население в 2020 г. : 1247407 чел.", 530, 400);
            g.drawString("Убыль населения: 25061 чел.", 530, 435);
        }
        if (nktz.status == 3 && nktz.regionNumber == 18){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("г. Москва", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Москва - столица РФ, город ",530, 200);
            g.drawString("Федерального значения. ",530, 215);
            g.drawString("Административный центр Центрального", 530, 230);
            g.drawString("федерального округа. Крупнейший по", 530, 245);
            g.drawString("численности населения город РФ.", 530, 260);
            g.drawString("Первое письменное упоминание о ", 530, 275);
            g.drawString("Москве относится к 1147 году.", 530, 290);
            g.drawString("Расположена на западе России, на " , 530, 305);
            g.drawString("реке Москве в центре Восточно-" , 530, 320);
            g.drawString("Европейской равнины. Москва -  " , 530, 335);
            g.drawString("популярный туристический центр РФ." , 530, 350);
            g.drawString("Население в 2010 г. : 11503501 чел.", 530, 405);
            g.drawString("Население в 2020 г. : 12666565 чел.", 530, 430);
            g.drawString("Прирост населения: 1163064 чел.", 530, 455);
        }
        if (nktz.status == 3 && nktz.regionNumber == 19){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Респ. Карелия", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Республика Карелия — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Северо-Западного федерального округа.", 530, 230);
            g.drawString("Карелия образована 25 июля 1923 г.", 530, 245);
            g.drawString("Республика граничит с Архангельской,", 530, 260);
            g.drawString("Вологодской, Ленинградской и", 530, 275);
            g.drawString("Мурманской областями. Площадь", 530, 290);
            g.drawString("территории Карелии - 172,4 тыс. км²." , 530, 305);
            g.drawString("Население в 2010 г. : 643548 чел.", 530, 360);
            g.drawString("Население в 2020 г. : 611567 чел.", 530, 385);
            g.drawString("Убыль населения: 31981 чел.", 530, 410);
        }
        if (nktz.status == 3 && nktz.regionNumber == 20){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Республика Коми", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Респ. Карелия — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Северо-Западного федерального округа.", 530, 230);
            g.drawString("Расположена на северо-востоке ", 530, 245);
            g.drawString("европейской части России. Столица — ", 530, 260);
            g.drawString("город Сыктывкар. Образована в 1936 г. ", 530, 275);
            g.drawString("Граничит с Тюменской, Свердловской,", 530, 290);
            g.drawString("Кировской и Архангельской областью," , 530, 305);
            g.drawString("Пермским краем. Площадь респ. Коми -" , 530, 320);
            g.drawString("415,9 тыс. кв. км." , 530, 335);
            g.drawString("Население в 2010 г. : 901189 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 817032 чел.", 530, 415);
            g.drawString("Убыль населения: 84157 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 21){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Архангельская область", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Архангельская область — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Северо-Западного федерального округа.", 530, 230);
            g.drawString("Общая площадь региона — 589,9 тыс. ", 530, 245);
            g.drawString("км². Административный центр области - ", 530, 260);
            g.drawString("город Архангельск. Образована 23 ", 530, 275);
            g.drawString("сентября 1937 г. Архангельская область ", 530, 290);
            g.drawString("является 8-м по территории субъектом " , 530, 305);
            g.drawString("Российской Федерации." , 530, 320);
            g.drawString("Население в 2010 г. : 1227626 чел.", 530, 375);
            g.drawString("Население в 2020 г. : 1131793 чел.", 530, 400);
            g.drawString("Убыль населения: 95833 чел.", 530, 425);
        }
        if (nktz.status == 3 && nktz.regionNumber == 22){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Ненецкий АО", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Ненецкий АО — субъект Российской",530, 200);
            g.drawString("Федерации, административный центр -",530, 215);
            g.drawString("город Нарьян-Мар. Площадь ", 530, 230);
            g.drawString("региона - 176,7 тыс. кв. км. ", 530, 245);
            g.drawString("Округ был образован 15 июля 1929 г.", 530, 260);
            g.drawString("Граничит с Архангельской областью,", 530, 275);
            g.drawString("с Респ. Коми и Ямало-Ненецким ", 530, 290);
            g.drawString("автономным округом. Вся территория " , 530, 305);
            g.drawString("округа входит в состав сухопутных " , 530, 320);
            g.drawString("территорий Арктической зоны РФ." , 530, 335);
            g.drawString("Население в 2010 г. : 42090 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 44250 чел.", 530, 415);
            g.drawString("Прирост населения: 2160 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 23){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Волого́дская о́бласть", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Волого́дская о́бласть — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Северо-Западного федерального округа.", 530, 230);
            g.drawString("Площадь области составляет 144 527 км².", 530, 245);
            g.drawString("Административный центр — г. Вологда.", 530, 260);
            g.drawString("Субъект образован 23 сентября 1937 г.", 530, 275);
            g.drawString("Граничит с Архангельской, Кировской, ", 530, 290);
            g.drawString("Ленинградской, Ярославской, Тверской, " , 530, 305);
            g.drawString("Новгородской, Костромской областями" , 530, 320);
            g.drawString("и Республикой Карелия." , 530, 335);
            g.drawString("Население в 2010 г. : 1202444 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 1155744 чел.", 530, 415);
            g.drawString("Убыль населения: 46700 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 24){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Калининградская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Калининградская область — субъект",530, 200);
            g.drawString("Российской Федерации, самый западный ",530, 215);
            g.drawString("регион страны. Расположена в Центр.", 530, 230);
            g.drawString("Европе. Площадь — 15,125 тыс. км². ", 530, 245);
            g.drawString("Граничит с Польшей, Литвой. На западе ", 530, 260);
            g.drawString("омывается Балтийским морем. Входит в ", 530, 275);
            g.drawString("Северо-Западный федеральный округ.", 530, 290);
            g.drawString("Адм. центр — г. Калининград." , 530, 305);
            g.drawString("Отделёна от РФ территорией других" , 530, 320);
            g.drawString("государств, но соединёна морем." , 530, 335);
            g.drawString("Население в 2010 г. : 941873 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 1015568 чел.", 530, 415);
            g.drawString("Прирост населения: 73695 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 25){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Ленинградская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Ленинградская область — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Северо-Западного федерального округа.", 530, 230);
            g.drawString("Территория — 83 908 км², образована", 530, 245);
            g.drawString("1 августа 1927 г. Граничит с Респ. ", 530, 260);
            g.drawString("Карелия, Вологодской, Новгородской", 530, 275);
            g.drawString("и Псковской областями, а также", 530, 290);
            g.drawString("Эстонией и Финляндией. Администр." , 530, 305);
            g.drawString("центр — город Санкт-Петербург." , 530, 320);
            g.drawString("Население в 2010 г. : 1716868 чел.", 530, 375);
            g.drawString("Население в 2020 г. : 1884292 чел.", 530, 400);
            g.drawString("Прирост населения: 167424 чел.", 530, 425);
        }
        if (nktz.status == 3 && nktz.regionNumber == 26){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Мурманская область", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Мурманская область — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Северо-Западного федерального округа.", 530, 230);
            g.drawString("Образована 28 мая 1938 г. Площадь", 530, 245);
            g.drawString("региона - 144,9 тыс. кв. км.", 530, 260);
            g.drawString("Администр. центр — г. Мурманск.", 530, 275);
            g.drawString("Большая часть области занимает террит. " , 530, 290);
            g.drawString("Кольского п-ова и расположена" , 530, 305);
            g.drawString("за Северным полярным кругом." , 530, 320);
            g.drawString("Население в 2010 г. : 795409 чел.", 530, 375);
            g.drawString("Население в 2020 г. : 737134 чел.", 530, 400);
            g.drawString("Убыль населения: 58275 чел.", 530, 425);
        }
        if (nktz.status == 3 && nktz.regionNumber == 27){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Новгородская область", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Новгородская область — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Северо-Западного федерального округа.", 530, 230);
            g.drawString("Площадь составляет 54,5 тыс. км².", 530, 245);
            g.drawString("Регион образован 5 июля 1944 г.", 530, 260);
            g.drawString("Область граничит с Вологодской,", 530, 275);
            g.drawString("Тверской, Ленинградской и Псковской ", 530, 290);
            g.drawString("областями. Административный центр — " , 530, 305);
            g.drawString("г. Великий Новгород." , 530, 320);
            g.drawString("Население в 2010 г. : 634111 чел.", 530, 375);
            g.drawString("Население в 2020 г. : 594461 чел.", 530, 400);
            g.drawString("Убыль населения: 39650 чел.", 530, 425);
        }
        if (nktz.status == 3 && nktz.regionNumber == 28){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Псковская область", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Псковская область — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Северо-Западного федерального округа.", 530, 230);
            g.drawString("Образована 23 августа 1944 г.", 530, 245);
            g.drawString("Площадь составляет 54,3 тыс. км²", 530, 260);
            g.drawString("Псковская область граничит с  ", 530, 275);
            g.drawString("Ленинградской, Новгородской, Тверской", 530, 290);
            g.drawString("и Смоленской областями, а также с " , 530, 305);
            g.drawString("Белоруссией, Эстонией и Латвией." , 530, 320);
            g.drawString("Администр. центр — г. Псков." , 530, 335);
            g.drawString("Население в 2010 г. : 673423 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 623182 чел.", 530, 415);
            g.drawString("Убыль населения: 50241 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 29){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Санкт-Петербург", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("г. Санкт-Петербург — субъект",530, 200);
            g.drawString("Российской Федерации,администр. ",530, 215);
            g.drawString("центр Северо-Западного федерального ", 530, 230);
            g.drawString("округа. Санкт-Петербург — важный ", 530, 245);
            g.drawString("экономический, научный и культурный ", 530, 260);
            g.drawString("центр России, крупный транспортный ", 530, 275);
            g.drawString("узел. Основан 16 мая 1703 года царём ", 530, 290);
            g.drawString("Петром I. Площадь города ~1440 км²." , 530, 305);
            g.drawString("Граничит с Ленинградской областью, " , 530, 320);
            g.drawString("а также  с Финляндией и Эстонией." , 530, 335);
            g.drawString("Население в 2010 г. : 4879566 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 5391203 чел.", 530, 415);
            g.drawString("Прирост населения: 511637 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 30){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Респ. Адыгея", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Республика Адыгея — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Южного федерального округа. Столица - ", 530, 230);
            g.drawString("г. Майкоп. Образована 27 июля 1922 г.", 530, 245);
            g.drawString("Республика находится на юго-западе РФ.", 530, 260);
            g.drawString("Площадь Адыгеи 7790 км². Граничит с", 530, 275);
            g.drawString("Краснодарским краем, г. Сочи и городом", 530, 290);
            g.drawString("Горячий Ключ. Является частью Северо-" , 530, 305);
            g.drawString("Кавказского экономического района." , 530, 320);
            g.drawString("Население в 2010 г. : 439996 чел.", 530, 375);
            g.drawString("Население в 2020 г. : 463128 чел.", 530, 400);
            g.drawString("Прирост населения: 23132 чел.", 530, 425);
        }
        if (nktz.status == 3 && nktz.regionNumber == 31){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Респ. Калмыкия", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Республика Калмыкия — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Южного федерального округа. Столица -", 530, 230);
            g.drawString("г. Элиста. Граничит с Респ. Дагестан, ", 530, 245);
            g.drawString("со Ставропольским краем, Астраханской, ", 530, 260);
            g.drawString("Волгоградской и Ростовской областями.", 530, 275);
            g.drawString("Площадь Калмыкии - 76,1 тыс км².", 530, 290);
            g.drawString("Является частью Поволжского экономич. " , 530, 305);
            g.drawString("района. Республика Калмыкия образована" , 530, 320);
            g.drawString("в 1920 г. как Калмыцкая Аобл." , 530, 335);
            g.drawString("Население в 2010 г. : 289481 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 270560 чел.", 530, 415);
            g.drawString("Убыль населения: 18921 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 32){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Краснодарский край", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Краснодарский край — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Южного федерального округа. Столица -", 530, 230);
            g.drawString("г. Краснодар. Образован 13 сентября ", 530, 245);
            g.drawString("1937 из Азово-Черноморского края.", 530, 260);
            g.drawString("Граничит с Ростовской областью,", 530, 275);
            g.drawString("Ставропольским краем, Карачаево-", 530, 290);
            g.drawString("Черкесской Республикой, Республикой " , 530, 305);
            g.drawString("Адыгея и Крымом, а также с Абхазией." , 530, 320);
            g.drawString("Площадь региона - ~75,5 тыс. км²." , 530, 335);
            g.drawString("Население в 2010 г. : 5226647 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 5679704 чел.", 530, 415);
            g.drawString("Прирост населения: 453057 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 33){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Астраханская область", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Астраханская область — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Южного федерального округа. Столица -", 530, 230);
            g.drawString("г. Астрахань. Область образована 27 ", 530, 245);
            g.drawString("декабря 1943 года. Площадь региона - ", 530, 260);
            g.drawString("~49 тыс. км². Граничит с Волгоградской", 530, 275);
            g.drawString("областью, с республикой Калмыкия, ", 530, 290);
            g.drawString("с Казахстаном, на юге омывается" , 530, 305);
            g.drawString("Каспийским морем." , 530, 320);
            g.drawString("Население в 2010 г. : 1010073 чел.", 530, 375);
            g.drawString("Население в 2020 г. : 1001780 чел.", 530, 400);
            g.drawString("Убыль населения: 8293 чел.", 530, 425);
        }
        if (nktz.status == 3 && nktz.regionNumber == 34){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Волгоградская область", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Волгоградская область — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Южного федерального округа, является ", 530, 230);
            g.drawString("частью Поволжского экономич. района.", 530, 245);
            g.drawString("Столица региона — г. Волгоград.", 530, 260);
            g.drawString("Область расположена на юго-востоке ", 530, 275);
            g.drawString("Восточно-Европейской равнины.", 530, 290);
            g.drawString("Площадь региона - 112,9 тыс. км²." , 530, 305);
            g.drawString("Область граничит с Астраханской," , 530, 320);
            g.drawString("Воронежской, Ростовской, Саратовской" , 530, 335);
            g.drawString("областями, с Республикой Калмыкия, ", 530, 350);
            g.drawString("а также с Казахстаном.", 530, 365);
            g.drawString("Население в 2010 г. : 2610161 чел.", 530, 420);
            g.drawString("Население в 2020 г. : 2482796 чел.", 530, 445);
            g.drawString("Убыль населения: 127365 чел.", 530, 470);
        }
        if (nktz.status == 3 && nktz.regionNumber == 35){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Ростовская область", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Ростовская область — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Южного федерального округа. Столица -", 530, 230);
            g.drawString("г. Ростов-на-Дону. Образована 13", 530, 245);
            g.drawString("сентября 1937 г. Ростовская область ", 530, 260);
            g.drawString("граничит с Волгоградской, Воронежской, ", 530, 275);
            g.drawString("Донецкой и Луганской областями, с ", 530, 290);
            g.drawString("Краснодарским и Ставропольским " , 530, 305);
            g.drawString("краями и с Республикой Калмыкия." , 530, 320);
            g.drawString("Население в 2010 г. : 4277976 чел.", 530, 375);
            g.drawString("Население в 2020 г. : 4189653 чел.", 530, 400);
            g.drawString("Убыль населения: 88323 чел.", 530, 425);
        }
        if (nktz.status == 3 && nktz.regionNumber == 36){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Республика Дагестан", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Республика Дагестан — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Северо-Кавказского федеральн. округа.", 530, 230);
            g.drawString("Столица республики — г. Махачкала.", 530, 245);
            g.drawString("Образована 19 января 1921 г.", 530, 260);
            g.drawString("Площадь региона - 50,3 тыс. км².", 530, 275);
            g.drawString("Граничит с Чеченской Республикой, ", 530, 290);
            g.drawString("со Ставропольским краем, с Респуб- " , 530, 305);
            g.drawString("ликой Калмыкия, а также с Грузией и" , 530, 320);
            g.drawString("Азербайджаном." , 530, 335);
            g.drawString("Население в 2010 г. : 2910249 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 3122080 чел.", 530, 415);
            g.drawString("Прирост населения: 211831 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 37){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Республика Ингушетия", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Республика Ингушетия — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Северо-Кавказского федеральн. округа.", 530, 230);
            g.drawString("Является частью Северо-Кавказского ", 530, 245);
            g.drawString("экономического района. Столица — ", 530, 260);
            g.drawString("г. Магас. Образована 4 июня 1992 г.", 530, 275);
            g.drawString("Самый малый по площади регион РФ, ", 530, 290);
            g.drawString("не считая городов федерального " , 530, 305);
            g.drawString("значения - 3 685 км². Ингушетия — " , 530, 320);
            g.drawString("аграрно-индустриальная республика." , 530, 335);
            g.drawString("Население в 2010 г. : 412529 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 511313 чел.", 530, 415);
            g.drawString("Прирост населения: 98784 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 38){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Кабардино-Балкария", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Кабардино-Балкарская Респ. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Северо-Кавказского федеральн. округа.", 530, 230);
            g.drawString("Является частью Северо-Кавказского", 530, 245);
            g.drawString("экономического района. Столица — г.", 530, 260);
            g.drawString("Нальчик. Образована как Кабардинская", 530, 275);
            g.drawString("автономная область 1 сентября 1921 г.", 530, 290);
            g.drawString("Площадь региона - 12,5 тыс. км²." , 530, 305);
            g.drawString("На территории региона находится гора" , 530, 320);
            g.drawString("Эльбрус— самая высокая точка Европы." , 530, 335);
            g.drawString("Население в 2010 г. : 859939 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 868771 чел.", 530, 415);
            g.drawString("Прирост населения: 8832 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 39){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Карачаево-Черкессия", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Карачаево-Черкесская Респ. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Северо-Кавказского федеральн. округа.", 530, 230);
            g.drawString("Является частью Северо-Кавказского", 530, 245);
            g.drawString("экономического района. Столица — г.", 530, 260);
            g.drawString("Черкесск. Образована 12 января 1922 г.", 530, 275);
            g.drawString("как Карачаево-Черкесская автономная ", 530, 290);
            g.drawString("область, в 1992 году преобразована " , 530, 305);
            g.drawString("в республику. Площадь региона - 12,5 " , 530, 320);
            g.drawString("тыс. км²." , 530, 335);
            g.drawString("Население в 2010 г. : 477859 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 465443 чел.", 530, 415);
            g.drawString("Убыль населения: 12416 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 40){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Респ. Северная Осетия", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Республика Северная Осетия — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Северо-Кавказского федеральн. округа.", 530, 230);
            g.drawString("Является частью Северо-Кавказского", 530, 245);
            g.drawString("экономического района. Столица — г.", 530, 260);
            g.drawString("Владикавказ. Образована 7 июля 1924 г. ", 530, 275);
            g.drawString("Площадь региона - ~8 тыс. км².", 530, 290);
            g.drawString("Граничит с Кабардино-Балкарией, " , 530, 305);
            g.drawString("Ставропольским краем, Ингушетией " , 530, 320);
            g.drawString("и Чеченской Республикой, а также " , 530, 335);
            g.drawString("с Грузией и  Южной Осетией." , 530, 350);
            g.drawString("Население в 2010 г. : 712980 чел.", 530, 405);
            g.drawString("Население в 2020 г. : 694967 чел.", 530, 430);
            g.drawString("Убыль населения: 18013 чел.", 530, 455);
        }
        if (nktz.status == 3 && nktz.regionNumber == 41){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Чеченская республика", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Чеченская республика — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Северо-Кавказского федеральн. округа.", 530, 230);
            g.drawString("Является частью Северо-Кавказского", 530, 245);
            g.drawString("экономического района. Столица — г.", 530, 260);
            g.drawString("Грозный. Образована 9 января 1993 г.", 530, 275);
            g.drawString("Площадь региона - ~16,2 тыс. км².", 530, 290);
            g.drawString("Граничит с Ингушетией, Сев. Осетией," , 530, 305);
            g.drawString("Ставропольским краем, Дагестаном," , 530, 320);
            g.drawString("а также с Грузией." , 530, 335);
            g.drawString("Население в 2010 г. : 1268989 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 1488359 чел.", 530, 415);
            g.drawString("Прирост населения: 219370 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 42){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Ставропольский край", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Ставропольский край — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Северо-Кавказского федеральн. округа.", 530, 230);
            g.drawString("Является частью Северо-Кавказского", 530, 245);
            g.drawString("экономического района. Столица — г.", 530, 260);
            g.drawString("Ставрополь. Образован в феврале 1924 г.", 530, 275);
            g.drawString("Площадь региона - ~66,2 тыс. км².", 530, 290);
            g.drawString("Граничит с Краснодарским краем, " , 530, 305);
            g.drawString("Ростовской областью, Калмыкией, " , 530, 320);
            g.drawString("Дагестаном и другими республиками РФ." , 530, 335);
            g.drawString("Население в 2010 г. : 2786281 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 2798184 чел.", 530, 415);
            g.drawString("Прирост населения: 11903 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 43){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Респ. Башкортостан", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Респ. Башкортостан — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Приволжского федерального округа.", 530, 230);
            g.drawString("Является частью Уральского экономич. ", 530, 245);
            g.drawString("района. Столица — город Уфа.", 530, 260);
            g.drawString("Площадь региона - ~142,9 тыс. км².", 530, 275);
            g.drawString("Образована 15 ноября 1917 г, с 25 ", 530, 290);
            g.drawString("февраля 1992 г. носит современное" , 530, 305);
            g.drawString("название. Башкортостан расположен на" , 530, 320);
            g.drawString("склонах Южного Урала, в Предуралье." , 530, 335);
            g.drawString("Население в 2010 г. : 4072292 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 4025968 чел.", 530, 415);
            g.drawString("Убыль населения: 46324 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 44){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Респ. Марий Эл", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Респ. Марий Эл — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Приволжского федерального округа.", 530, 230);
            g.drawString("Является частью Волго-Вятского экон.", 530, 245);
            g.drawString("района. Столица — город Йошкар-Ола.", 530, 260);
            g.drawString("Площадь региона - ~23,2 тыс. км².", 530, 275);
            g.drawString("Образована 4 ноября 1920 года как ", 530, 290);
            g.drawString("Марийская автономная область. Имеет" , 530, 305);
            g.drawString("границы с Кировской, Нижегородской" , 530, 320);
            g.drawString("областями, с респ. Татарстан и " , 530, 335);
            g.drawString("Чувашской Республикой.", 530, 350);
            g.drawString("Население в 2010 г. : 696459 чел.", 530, 405);
            g.drawString("Население в 2020 г. : 677375 чел.", 530, 430);
            g.drawString("Убыль населения: 19084 чел.", 530, 455);
        }
        if (nktz.status == 3 && nktz.regionNumber == 45){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Респ. Мордовия", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Респ. Мордовия — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Приволжского федерального округа.", 530, 230);
            g.drawString("Площадь региона - ~26,1 тыс. км².", 530, 245);
            g.drawString("Столица — город Саранск. Образована ", 530, 260);
            g.drawString("16 июля 1928 г. как Мордовский округ.", 530, 275);
            g.drawString("Республика граничит с Нижегородской,", 530, 290);
            g.drawString("Пензенской, Рязанской и Ульяновской" , 530, 305);
            g.drawString("областями, а так же с республикой" , 530, 320);
            g.drawString("Чувашия." , 530, 335);
            g.drawString("Население в 2010 г. : 834755 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 784581 чел.", 530, 415);
            g.drawString("Убыль населения: 50174 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 46){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Респ. Татарстан", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Респ. Татарстан — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Приволжского федерального округа.", 530, 230);
            g.drawString("Площадь региона - ~68 тыс. км².", 530, 245);
            g.drawString("Столица — город Казань. Образована", 530, 260);
            g.drawString("27 мая 1920 г. как Автономная Татарская", 530, 275);
            g.drawString("ССР. Граничит с Кировской, Самарской,", 530, 290);
            g.drawString("Ульяновской и Оренбургской областями," , 530, 305);
            g.drawString("республиками Башкортостан, Марий Эл," , 530, 320);
            g.drawString("Удмуртской и Чувашской." , 530, 335);
            g.drawString("Население в 2010 г. : 3786488 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 3898504 чел.", 530, 415);
            g.drawString("Прирост населения: 112016 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 47){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Удмуртская респ.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Удмуртская респ. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Приволжского федерального округа.", 530, 230);
            g.drawString("Площадь региона - ~42,1 тыс. км².", 530, 245);
            g.drawString("Столица — город Ижевск. Образована", 530, 260);
            g.drawString("28 декабря 1934 г. как Удмуртская АССР.", 530, 275);
            g.drawString("Граничит с Кировской областью, с ", 530, 290);
            g.drawString("Пермским краем, с Татарстаном и " , 530, 305);
            g.drawString("Башкортостаном." , 530, 320);
            g.drawString("Население в 2010 г. : 1521420 чел.", 530, 375);
            g.drawString("Население в 2020 г. : 1497156 чел.", 530, 400);
            g.drawString("Убыль населения: 24264 чел.", 530, 425);
        }
        if (nktz.status == 3 && nktz.regionNumber == 48){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Чувашская респ.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Чувашская респ. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Приволжского федерального округа и", 530, 230);
            g.drawString("Волго-Вятского экономического района.", 530, 245);
            g.drawString("Площадь региона - ~18,3 тыс. км².", 530, 260);
            g.drawString("Столица — г. Чебоксары. Образована", 530, 275);
            g.drawString("24 июня 1920 г. как Чувашская АОбл. ", 530, 290);
            g.drawString("Граничит с Нижегородской и " , 530, 305);
            g.drawString("Ульяновской областями, с Республикой  " , 530, 320);
            g.drawString("Марий Эл, с Татарстаном и  Мордовией." , 530, 335);
            g.drawString("Население в 2010 г. : 1251619 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 1212847 чел.", 530, 415);
            g.drawString("Убыль населения: 38772 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 49){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Пермский край", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Пермский край — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Приволжского федерального округа и", 530, 230);
            g.drawString("Уральского экономического района.", 530, 245);
            g.drawString("Площадь региона - ~160 тыс. км².", 530, 260);
            g.drawString("Столица — г. Пермь. Образована", 530, 275);
            g.drawString("1 декабря 2005 г. из Пермской гу-", 530, 290);
            g.drawString("бернии.  Граничит с Респ. Коми, " , 530, 305);
            g.drawString("с Свердловской и Кировской областями," , 530, 320);
            g.drawString("с Башкортостаном и Удмуртией." , 530, 335);
            g.drawString("Население в 2010 г. : 2635276 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 2589261 чел.", 530, 415);
            g.drawString("Убыль населения: 46015 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 50){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Кировская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Кировская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Приволжского федерального округа и", 530, 230);
            g.drawString("Волго-Вятского экономического района.", 530, 245);
            g.drawString("Площадь региона - ~120 тыс. км².", 530, 260);
            g.drawString("Столица — г. Киров. Образована", 530, 275);
            g.drawString("5 декабря 1936 г. из Кировского края.", 530, 290);
            g.drawString("Граничит с Пермским краем, Удмуртией," , 530, 305);
            g.drawString("Республикой Коми, Архангельской,  " , 530, 320);
            g.drawString("Вологодской, Костромской и Нижего- " , 530, 335);
            g.drawString("родской областями, с республикой ", 530, 350);
            g.drawString("Марий Эл и Татарстаном.", 530, 365);
            g.drawString("Население в 2010 г. : 1341312 чел.", 530, 420);
            g.drawString("Население в 2020 г. : 1256287 чел.", 530, 445);
            g.drawString("Убыль населения: 85025 чел.", 530, 470);
        }
        if (nktz.status == 3 && nktz.regionNumber == 51){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Нижегородская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Нижегородская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Приволжского федерального округа и", 530, 230);
            g.drawString("Волго-Вятского экономического района.", 530, 245);
            g.drawString("Площадь региона - ~76,5 тыс. км².", 530, 260);
            g.drawString("Столица — г. Нижний Новгород Обра-.", 530, 275);
            g.drawString("зована 22.10.1990 г. из Горьковской", 530, 290);
            g.drawString("области. Граничит с Владимирской," , 530, 305);
            g.drawString("Костромской, Рязанской, Ивановской и" , 530, 320);
            g.drawString("Кировской областями, республиками " , 530, 335);
            g.drawString("Марий Эл, Чувашией, Мордовия." , 530, 350);
            g.drawString("Население в 2010 г. : 3310597 чел.", 530, 405);
            g.drawString("Население в 2020 г. : 3189749 чел.", 530, 430);
            g.drawString("Убыль населения: 120848 чел.", 530, 455);
        }
        if (nktz.status == 3 && nktz.regionNumber == 52){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Оренбургская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Оренбургская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Приволжского федерального округа и", 530, 230);
            g.drawString("Уральского экономического района.", 530, 245);
            g.drawString("Площадь региона - ~124,5 тыс. км².", 530, 260);
            g.drawString("Столица — город Оренбург. ", 530, 275);
            g.drawString("Образована 7 декабря 1934 года путём ", 530, 290);
            g.drawString("выделения её из Средневолжского края." , 530, 305);
            g.drawString("Граничит с Самарской областью," , 530, 320);
            g.drawString("Татарстаном и Башкортостаном." , 530, 335);
            g.drawString("Население в 2010 г. : 2033072 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 1949875 чел.", 530, 415);
            g.drawString("Убыль населения: 83197 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 53){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Пензенская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Пензенская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Приволжского федерального округа и", 530, 230);
            g.drawString("Поволжского экономического района.", 530, 245);
            g.drawString("Площадь региона - ~43,4 тыс. км².", 530, 260);
            g.drawString("Административный центр — г. Пенза.", 530, 275);
            g.drawString("Область образована 4 февраля 1939 г.", 530, 290);
            g.drawString("Граничит с Саратовской, Рязанской" , 530, 305);
            g.drawString("Тамбовской, Ульяновской областями и " , 530, 320);
            g.drawString("Республикой Мордовия." , 530, 335);
            g.drawString("Население в 2010 г. : 1386186 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 1298230 чел.", 530, 415);
            g.drawString("Убыль населения: 87956 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 54){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Самарская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Самарская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Приволжского федерального округа и", 530, 230);
            g.drawString("Поволжского экономического района.", 530, 245);
            g.drawString("Площадь региона - ~53,6 тыс. км².", 530, 260);
            g.drawString("Административный центр — г. Самара.", 530, 275);
            g.drawString("Область образована 14 мая 1928 г. ", 530, 290);
            g.drawString("как Средневолжская область." , 530, 305);
            g.drawString("Граничит с Саратовской, Ульяновской," , 530, 320);
            g.drawString("Оренбургской областями и Татарстаном." , 530, 335);
            g.drawString("Население в 2010 г. : 3215532 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 3166848 чел.", 530, 415);
            g.drawString("Убыль населения: 48684 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 55){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Саратовская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Саратовская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Приволжского федерального округа и", 530, 230);
            g.drawString("Поволжского экономического района.", 530, 245);
            g.drawString("Площадь региона - ~100 тыс. км².", 530, 260);
            g.drawString("Административный центр — г. Саратов.", 530, 275);
            g.drawString("Образована 10 января 1934 года как ", 530, 290);
            g.drawString("Саратовский край. Граничит с Волго-" , 530, 305);
            g.drawString("градской, Воронежской, Тамбовской," , 530, 320);
            g.drawString("Пензенской, Самарской и Ульяновской " , 530, 335);
            g.drawString("областями, а также с Казахстаном.", 530, 350);
            g.drawString("Население в 2010 г. : 2521892 чел.", 530, 405);
            g.drawString("Население в 2020 г. : 2408503 чел.", 530, 430);
            g.drawString("Убыль населения: 113389 чел.", 530, 455);
        }
        if (nktz.status == 3 && nktz.regionNumber == 56){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Ульяновская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Ульяновская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Приволжского федерального округа и", 530, 230);
            g.drawString("Поволжского экономического района.", 530, 245);
            g.drawString("Площадь региона - ~37,2 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Ульяновск.", 530, 275);
            g.drawString("Образована 19 января 1943 г. из", 530, 290);
            g.drawString("предшествующей Симбирской губернии." , 530, 305);
            g.drawString("Граничит с Самарской, Саратовской и " , 530, 320);
            g.drawString("Пензенской областями, Чувашской респ.," , 530, 335);
            g.drawString("республиками Мордовия и Татарстан.", 530, 350);
            g.drawString("Население в 2010 г. : 1292799 чел.", 530, 405);
            g.drawString("Население в 2020 г. : 1224071 чел.", 530, 430);
            g.drawString("Убыль населения: 68728 чел.", 530, 455);
        }
        if (nktz.status == 3 && nktz.regionNumber == 57){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Курганская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Курганская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Уральского федерального округа и", 530, 230);
            g.drawString("Уральского экономического района.", 530, 245);
            g.drawString("Площадь региона - ~71 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Курган.", 530, 275);
            g.drawString("Курганская область образована", 530, 290);
            g.drawString("6 февраля 1943 года. Граничит с " , 530, 305);
            g.drawString("Челябинской, Тюменской и Свердлов-" , 530, 320);
            g.drawString("ской областями." , 530, 335);
            g.drawString("Население в 2010 г. : 910807 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 822868 чел.", 530, 415);
            g.drawString("Убыль населения: 87939 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 58){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Свердловская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Свердловская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Уральского федерального округа и", 530, 230);
            g.drawString("Уральского экономического района.", 530, 245);
            g.drawString("Площадь региона - ~194 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Екатеринбург.", 530, 275);
            g.drawString("Свердловская область образована 17 ", 530, 290);
            g.drawString("января 1934 г. из Уральской области." , 530, 305);
            g.drawString("Граничит с Пермским краем, респ." , 530, 320);
            g.drawString("Коми, Башкирией, Ханты-Мансийским   " , 530, 335);
            g.drawString("АО, Курганской, Челябинской и Тюмен-" , 530, 350);
            g.drawString("ской областями." , 530, 365);
            g.drawString("Население в 2010 г. : 4297747 чел.", 530, 420);
            g.drawString("Население в 2020 г. : 4300374 чел.", 530, 445);
            g.drawString("Прирост населения: 2627 чел.", 530, 470);
        }
        if (nktz.status == 3 && nktz.regionNumber == 59){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Тюменская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Тюменская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Уральского федерального округа и", 530, 230);
            g.drawString("Западно-Сибирского экон. района.", 530, 245);
            g.drawString("Площадь региона - ~160 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Тюмень.", 530, 275);
            g.drawString("Тюменская область образована 14 ", 530, 290);
            g.drawString("августа 1944 г. путём выделения " , 530, 305);
            g.drawString("из Омской и Курганской областей." , 530, 320);
            g.drawString("Граничит с Омской, Свердловской," , 530, 335);
            g.drawString("и Курганской областями, а также" , 530, 350);
            g.drawString("с Ханты-Мансийским АО." , 530, 365);
            g.drawString("Население в 2010 г. : 3395755 чел.", 530, 420);
            g.drawString("Население в 2020 г. : 3767295 чел.", 530, 445);
            g.drawString("Прирост населения: 371540 чел.", 530, 470);
        }
        if (nktz.status == 3 && nktz.regionNumber == 60){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Ханты-Мансийский АО ", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Ханты-Мансийский АО — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Уральского федерального округа и", 530, 230);
            g.drawString("Западно-Сибирского экон. района.", 530, 245);
            g.drawString("Площадь региона - ~535 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Ханты-Мансийск.", 530, 275);
            g.drawString("Регион образован в 1993 г. путём выде", 530, 290);
            g.drawString("ления из Тюменской области. Граничит" , 530, 305);
            g.drawString("с Свердловской, Тюменской, Омской," , 530, 320);
            g.drawString("Томской областями, Респ. Коми, Крас-" , 530, 335);
            g.drawString("ноярским краем и Ямало-Ненецким АО." , 530, 350);
            g.drawString("Население в 2010 г. : 1532243 чел.", 530, 405);
            g.drawString("Население в 2020 г. : 1681165 чел.", 530, 430);
            g.drawString("Прирост населения: 148922 чел.", 530, 455);
        }
        if (nktz.status == 3 && nktz.regionNumber == 61){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Ямало-Ненецкий АО", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Ямало-Ненецкий АО — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Уральского федерального округа и", 530, 230);
            g.drawString("Западно-Сибирского экон. района.", 530, 245);
            g.drawString("Площадь региона - ~769 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Салехард.", 530, 275);
            g.drawString("Регион образован 10 декабря 1930 г.", 530, 290);
            g.drawString("Граничит с Красноярским краем, " , 530, 305);
            g.drawString("Ненецким автономным округом,  " , 530, 320);
            g.drawString("Респ. Коми, Ханты-Мансийским АО." , 530, 335);
            g.drawString("Население в 2010 г. : 522904 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 545727 чел.", 530, 415);
            g.drawString("Прирост населения: 22823 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 62){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Челябинская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Челябинская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Уральского федерального округа и", 530, 230);
            g.drawString("Уральского экономического района", 530, 245);
            g.drawString("Площадь региона - ~88 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Челябинск.", 530, 275);
            g.drawString("Область образована 17 января 1934 г. ", 530, 290);
            g.drawString("из районов Уральской области." , 530, 305);
            g.drawString("Граничит с Свердловской, Курганской, " , 530, 320);
            g.drawString("Оренбургской обл., Респ. Башкортостан." , 530, 335);
            g.drawString("Население в 2010 г. : 3476217 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 3454589 чел.", 530, 415);
            g.drawString("Убыль населения: 21628 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 63){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Респ. Алтай", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Респ. Алтай — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Сибирского федерального округа и", 530, 230);
            g.drawString("Западно-Сибирского экон. района.", 530, 245);
            g.drawString("Площадь региона - ~93 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Горно-Алтайск.", 530, 275);
            g.drawString("Образована 1 июня 1922 г. как Ойрат-", 530, 290);
            g.drawString("ская автономная область. Граничит" , 530, 305);
            g.drawString("с Алтайским краем, Кемеровской обл.," , 530, 320);
            g.drawString("республиками Хакассия и Тыва." , 530, 335);
            g.drawString("Население в 2010 г. : 206168 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 220568 чел.", 530, 415);
            g.drawString("Прирост населения: 14400 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 64){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Респ. Бурятия", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Респ. Бурятия — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Дальневосточного федеральн. округа и", 530, 230);
            g.drawString("Дальневосточного экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~351 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Улан-Удэ.", 530, 275);
            g.drawString("Образована 30 мая 1923 года как", 530, 290);
            g.drawString("Бурятская АССР. Граничит с республи-" , 530, 305);
            g.drawString("кой Тыва и Иркутской областью, а" , 530, 320);
            g.drawString("также с Монголией." , 530, 335);
            g.drawString("Население в 2010 г. : 972021 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 985684 чел.", 530, 415);
            g.drawString("Прирост населения: 13663 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 65){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Респ. Тыва", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Респ. Тыва — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Сибирского федерального округа и", 530, 230);
            g.drawString("Восточно-Сибирского экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~170 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Кызыл.", 530, 275);
            g.drawString("Обоазована 24 мая 1991 года.", 530, 290);
            g.drawString("Граничит с Респ. Алтай, Хакасия, Буря-" , 530, 305);
            g.drawString("тия, с Красноярским краем и Иркутской " , 530, 320);
            g.drawString("областью, а также с Монголией." , 530, 335);
            g.drawString("Население в 2010 г. : 307930 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 328875 чел.", 530, 415);
            g.drawString("Прирост населения: 20945 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 66){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Респ. Хакасия", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Респ. Хакасия — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Сибирского федерального округа и ", 530, 230);
            g.drawString("Восточно-Сибирского экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~62 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Абакан.", 530, 275);
            g.drawString("Образована 14 ноября 1923 г. как ", 530, 290);
            g.drawString("Хакасский уезд Енисейской губернии." , 530, 305);
            g.drawString("Граничит с Красноярским краем, респ." , 530, 320);
            g.drawString("Тувой и Алтаем и Кемеровской областью." , 530, 335);
            g.drawString("Население в 2010 г. : 532403 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 533149 чел.", 530, 415);
            g.drawString("Прирост населения: 746 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 67){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Алтайский край", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Алтайский край — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Сибирского федерального округа и ", 530, 230);
            g.drawString("Западно-Сибирского экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~170 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Барнаул.", 530, 275);
            g.drawString("Образован 28 сентября 1937 года.", 530, 290);
            g.drawString("Граничит с Республикой Алтай, " , 530, 305);
            g.drawString("Новосибирской, Кемеровской областями" , 530, 320);
            g.drawString("а также с Казахстаном." , 530, 335);
            g.drawString("Население в 2010 г. : 2419755 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 2306753 чел.", 530, 415);
            g.drawString("Убыль населения: 113002 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 68){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Забайкальский край", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Забайкальский край — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Дальневосточного федеральн. округа и", 530, 230);
            g.drawString("Дальневосточного экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~432 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Чита.", 530, 275);
            g.drawString("Образован 1 марта 2008 г. Граничит", 530, 290);
            g.drawString("с Амурской и Иркутской областями,   " , 530, 305);
            g.drawString("Республиками Бурятия и Саха (Якутия)," , 530, 320);
            g.drawString("а также с Монголией и КНР." , 530, 335);
            g.drawString("Население в 2010 г. : 1107107 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 1056592 чел.", 530, 415);
            g.drawString("Убыль населения: 50515 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 69){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Красноярский край", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Красноярский край — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Сибирского федерального округа и ", 530, 230);
            g.drawString("Восточно-Сибирского экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~2366,8 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Красноярск.", 530, 275);
            g.drawString("Образован 7 декабря 1934 года.", 530, 290);
            g.drawString("Граничит с Иркутской, Кемеровской," , 530, 305);
            g.drawString("Томской и Архангельской областями," , 530, 320);
            g.drawString("с Тувой, Хакасией, Якутией, Ханты-" , 530, 335);
            g.drawString("-Мансийским и Ямало-Ненецким АО." , 530, 350);
            g.drawString("Население в 2010 г. : 2828187 чел.", 530, 405);
            g.drawString("Население в 2020 г. : 2861077 чел.", 530, 430);
            g.drawString("Прирост населения: 32890 чел.", 530, 455);
        }
        if (nktz.status == 3 && nktz.regionNumber == 70){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Иркутская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Иркутская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Сибирского федерального округа и", 530, 230);
            g.drawString("Восточно-Сибирского экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~767,9 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Иркутск.", 530, 275);
            g.drawString("Область образована 26 сентября 1937 г.", 530, 290);
            g.drawString("Граничит с Красноярским краем, Тувой, " , 530, 305);
            g.drawString("Забайкальским краем, Бурятией, " , 530, 320);
            g.drawString("а также с Якутией." , 530, 335);
            g.drawString("Население в 2010 г. : 2428750 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 2383107 чел.", 530, 415);
            g.drawString("Убыль населения: 45643 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 71){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Кемеровская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Кемеровская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Сибирского федерального округа и", 530, 230);
            g.drawString("Западно-Сибирского экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~96 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Кемерово.", 530, 275);
            g.drawString("Область образована 26 января 1943 г.", 530, 290);
            g.drawString("Граничит с Томской, Новосибирской " , 530, 305);
            g.drawString("областями, Красноярским, Алтайским" , 530, 320);
            g.drawString("краями, респ. Хакасия и Алтай." , 530, 335);
            g.drawString("Население в 2010 г. : 2763135 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 2645650 чел.", 530, 415);
            g.drawString("Убыль населения: 117485 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 72){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Новосибирская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Новосибирская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Сибирского федерального округа и", 530, 230);
            g.drawString("Западно-Сибирского экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~178 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Новосибирск.", 530, 275);
            g.drawString("Область образована 28 сентября 1937 г.", 530, 290);
            g.drawString("Граничит с Томской, Омской, Кемеров-" , 530, 305);
            g.drawString("ской областями, Алтайским краем, а" , 530, 320);
            g.drawString("также с Казахстаном." , 530, 335);
            g.drawString("Население в 2010 г. : 2665911 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 2792003 чел.", 530, 415);
            g.drawString("Прирост населения: 126092 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 73){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Омская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Омская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Сибирского федерального округа и", 530, 230);
            g.drawString("Западно-Сибирского экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~140 тыс. км².", 530, 260);
            g.drawString("Городское население — 74%.", 530, 275);
            g.drawString("Столица области — г. Омск.", 530, 290);
            g.drawString("Область образована 7 декабря 1934 г." , 530, 305);
            g.drawString("Граничит с Тюменской, Новосибирской," , 530, 320);
            g.drawString("и Томской областями и Казахстаном." , 530, 335); 
            g.drawString("Население в 2010 г. : 1977665 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 1915170 чел.", 530, 415);
            g.drawString("Убыль населения: 62495 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 74){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Томская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Томская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Сибирского федерального округа и", 530, 230);
            g.drawString("Западно-Сибирского экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~315 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Томск.", 530, 275);
            g.drawString("Область образована 13 августа 1944 г.", 530, 290);
            g.drawString("Граничит с Тюменской, Новосибирской," , 530, 305);
            g.drawString("Омской, Кемеровской областями, Ханты-" , 530, 320);
            g.drawString("Мансийским АО и Красноярским краем." , 530, 335);
            g.drawString("Население в 2010 г. : 1047394 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 1074805 чел.", 530, 415);
            g.drawString("Прирост населения: 27411 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 75){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Респ. Саха (Якутия)", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Респ. Саха (Якутия) — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Дальневосточного федеральн. округа и", 530, 230);
            g.drawString("Дальневосточного экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~3083 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Якутск.", 530, 275);
            g.drawString("Образована 27 апреля 1922 г. Граничит с", 530, 290);
            g.drawString("Красноярским, Хабаровским, Забайкаль- " , 530, 305);
            g.drawString("ским краями, Амурской, Иркутской, Ма-" , 530, 320);
            g.drawString("гаданской областями и Чукотским АО." , 530, 335);
            g.drawString("Население в 2010 г. : 958528 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 976983 чел.", 530, 415);
            g.drawString("Прирост населения: 18455 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 76){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Камчатский край", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Камчатский край — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Дальневосточного федеральн. округа и", 530, 230);
            g.drawString("Дальневосточного экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~464 тыс. км².", 530, 260);
            g.drawString("Столица области — г. Петропавловск-", 530, 275);
            g.drawString("Камчатский. Образована 1 июля 2007 г.", 530, 290);
            g.drawString("Граничит с Магаданской, Сахалинской ." , 530, 305);
            g.drawString("областями и Чукотским АО." , 530, 320);
            g.drawString("Население в 2010 г. : 322079 чел.", 530, 375);
            g.drawString("Население в 2020 г. : 312342 чел.", 530, 400);
            g.drawString("Убыль населения: 9737 чел.", 530, 425);
        }
        if (nktz.status == 3 && nktz.regionNumber == 77){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Приморский край", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Приморский край — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Дальневосточного федеральн. округа и", 530, 230);
            g.drawString("Дальневосточного экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~165 тыс. км².", 530, 260);
            g.drawString("Столица региона — г. Владивосток.", 530, 275);
            g.drawString("Образован 20 октября 1938 г.", 530, 290);
            g.drawString("Граничит на западе с КНР, на юго-" , 530, 305);
            g.drawString("-западе — с КНДР, на севере — с " , 530, 320);
            g.drawString("Хабаровским краем." , 530, 335);
            g.drawString("Население в 2010 г. : 1956497 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 1886856 чел.", 530, 415);
            g.drawString("Убыль населения: 69641 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 78){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Хабаровский край", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Хабаровский край — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Дальневосточного федеральн. округа и", 530, 230);
            g.drawString("Дальневосточного экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~789 тыс. км².", 530, 260);
            g.drawString("Столица региона — г. Владивосток.", 530, 275);
            g.drawString("Образован 20 октября 1938 г.", 530, 290);
            g.drawString("Граничит с Магаданской, Амурской " , 530, 305);
            g.drawString("областями, Республикой Саха, Еврей- " , 530, 320);
            g.drawString("ской АОбл, Приморским краем и КНР." , 530, 335);
            g.drawString("Население в 2010 г. : 1343869 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 1308385 чел.", 530, 415);
            g.drawString("Убыль населения: 35484 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 79){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Амурская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Амурская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Дальневосточного федеральн. округа и", 530, 230);
            g.drawString("Дальневосточного экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~362 тыс. км².", 530, 260);
            g.drawString("Столица региона — г. Благовещенск.", 530, 275);
            g.drawString("Образована 20 октября 1932 года.", 530, 290);
            g.drawString("Граничит с Якутией, Хабаровским краем" , 530, 305);
            g.drawString("Еврейской автономной областью и" , 530, 320);
            g.drawString("Забайкальским краем, а также КНР." , 530, 335);
            g.drawString("Население в 2010 г. : 830103 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 785945 чел.", 530, 415);
            g.drawString("Убыль населения: 44158 чел.", 530, 440);
        }
        if (nktz.status == 3 && nktz.regionNumber == 80){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Магаданская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Магаданская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Дальневосточного федеральн. округа и", 530, 230);
            g.drawString("Дальневосточного экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~462 тыс. км².", 530, 260);
            g.drawString("Столица региона — г. Магадан.", 530, 275);
            g.drawString("Образована 3 декабря 1953 года.", 530, 290);
            g.drawString("Граничит с Чукотским АО, Камчатским " , 530, 305);
            g.drawString("краем, Якутией и Хабаровским краем." , 530, 320);
            g.drawString("Население в 2010 г. : 156996 чел.", 530, 375);
            g.drawString("Население в 2020 г. : 139592 чел.", 530, 400);
            g.drawString("Убыль населения: 17404 чел.", 530, 425);
        }
        if (nktz.status == 3 && nktz.regionNumber == 81){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Сахалинская обл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Сахалинская обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Дальневосточного федеральн. округа и", 530, 230);
            g.drawString("Дальневосточного экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~87 тыс. км².", 530, 260);
            g.drawString("Столица региона — г. Южно-Сахалинск.", 530, 275);
            g.drawString("Область впервые образована в 1909 г.", 530, 290);
            g.drawString("Граничит по морю с Камчатским краем, " , 530, 305);
            g.drawString("Хабаровским краем, а также Японией." , 530, 320);
            g.drawString("Население в 2010 г. : 497973 чел.", 530, 375);
            g.drawString("Население в 2020 г. : 486939 чел.", 530, 400);
            g.drawString("Убыль населения: 11034 чел.", 530, 425);
        }
        if (nktz.status == 3 && nktz.regionNumber == 82){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Еврейская АОбл.", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Еврейская автономная обл. — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Дальневосточного федеральн. округа и", 530, 230);
            g.drawString("Дальневосточного экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~36 тыс. км².", 530, 260);
            g.drawString("Столица региона — г. Биробиджан.", 530, 275);
            g.drawString("Область образована 7 мая 1934 г.", 530, 290);
            g.drawString("Граничит с Амурской областью," , 530, 305);
            g.drawString("Хабаровским краем, а также Китаем." , 530, 320);
            g.drawString("Население в 2010 г. : 176558 чел.", 530, 375);
            g.drawString("Население в 2020 г. : 157402 чел.", 530, 400);
            g.drawString("Убыль населения: 19156 чел.", 530, 425);
        }
        if (nktz.status == 3 && nktz.regionNumber == 83){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Чукотский АО", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Чукотский АО — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Дальневосточного федеральн. округа и", 530, 230);
            g.drawString("Дальневосточного экономич. района.", 530, 245);
            g.drawString("Площадь региона - ~721,5 тыс. км².", 530, 260);
            g.drawString("Столица региона — г. Анадырь.", 530, 275);
            g.drawString("Регион образован 17 июня 1992 г.", 530, 290);
            g.drawString("Граничит с Якутией, Магаданской " , 530, 305);
            g.drawString("областью и Камчатским краем. На " , 530, 320);
            g.drawString("востоке имеет морскую границу с США." , 530, 335);
            g.drawString("Население в 2010 г. : 50526 чел.", 530, 390);
            g.drawString("Население в 2020 г. : 49908 чел.", 530, 415);
            g.drawString("Убыль населения: 618 чел.", 530, 440);
        }
        //население крыма, севастополя в 2010 с трудом откопал с впн на каком-то украинском сайте
        if (nktz.status == 3 && nktz.regionNumber == 84){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("Респ. Крым", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("Респ. Крым — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Южного федерального округа и Северо-", 530, 230);
            g.drawString("Кавказского экономического района.", 530, 245);
            g.drawString("Площадь региона - ~26 тыс. км².", 530, 260);
            g.drawString("Столица региона — г. Симферополь.", 530, 275);
            g.drawString("Регион образован 12 февраля 1991 г.", 530, 290);
            g.drawString("Граничит с Краснодарским краем, Се-" , 530, 305);
            g.drawString("вастополем, а также c Херсонской" , 530, 320);
            g.drawString("областью, присоединённой к РФ 30 " , 530, 335);
            g.drawString("сентября 2022 г.", 530, 350);
            g.drawString("Население в 2010 г. : 1907100 чел.", 530, 405);
            g.drawString("Население в 2020 г. : 1934630 чел.", 530, 430);
            g.drawString("Прирост населения: 27530 чел.", 530, 455);
        }
        if (nktz.status == 3 && nktz.regionNumber == 85){
            g.setFont(new Font("serif", 1, 30));
            g.drawString("г. Севастополь", 530, 170);
            g.setFont(new Font("serif", 1, 17));
            g.drawString("г. Севастополь — субъект",530, 200);
            g.drawString("Российской Федерации, входит в состав ",530, 215);
            g.drawString("Южного федерального округа и Северо-", 530, 230);
            g.drawString("Кавказского экономического района.", 530, 245);
            g.drawString("Площадь региона - ~1080 км². Образован ", 530, 260);
            g.drawString("3 июня 1783 г. В Севастополе располо- ", 530, 275);
            g.drawString("жена главная военно-морская база  ", 530, 290);
            g.drawString("Черноморского флота РФ. Носит звание" , 530, 305);
            g.drawString("«Город-Герой». Граничит с республикой" , 530, 320);
            g.drawString("Крым, находится на территории одно-" , 530, 335);
            g.drawString("имённого полуострова.", 530, 350);
            g.drawString("Население в 2010 г. : 479565 чел.", 530, 405);
            g.drawString("Население в 2020 г. : 547820 чел.", 530, 430);
            g.drawString("Прирост населения: 68255 чел.", 530, 455);
        }
        
        
    }

}

