
package project;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ClickListener implements MouseListener {
    public static ClickListener regInfo;
    
    
    
            
    private Project nktz;
    //Yes, I'm an idiot. It was possible to avoid creating a lot of constants, but when I started doing this project, I didn't understand it, but now I'm too lazy to redo it.
    //But then there will be something to update -_-
    static final int START_X1 = 490;
    static final int START_X2 = 850;
    static final int START_Y1 = 440;
    static final int START_Y2 = 545;
    
    static final int EXIT_X1 = 490;
    static final int EXIT_X2 = 850;
    static final int EXIT_Y1 = 555;
    static final int EXIT_Y2 = 665;
    
    static final int EXIT_MAP_X1 = 1000;
    static final int EXIT_MAP_X2 = 1265;
    static final int EXIT_MAP_Y1 = 615;
    static final int EXIT_MAP_Y2 = 700;
    
    static int REGION_INFO_EXIT_X1 = 705;
    static int REGION_INFO_EXIT_X2 = 860;
    static int REGION_INFO_EXIT_Y1 = 585;
    static int REGION_INFO_EXIT_Y2 = 670;
    
    static final int SRAVNIT_X1 = 14;
    static final int SRAVNIT_X2 = 260;
    static final int SRAVNIT_Y1 = 629;
    static final int SRAVNIT_Y2 = 698;
   
    static final int SRAVNIT_EXIT_X1 = 432;
    static final int SRAVNIT_EXIT_X2 = 524;
    static final int SRAVNIT_EXIT_Y1 = 633;
    static final int SRAVNIT_EXIT_Y2 = 702;
    
    static final int SRAVNIT_INFO_EXIT_X1 = 845;
    static final int SRAVNIT_INFO_EXIT_X2 = 997;
    static final int SRAVNIT_INFO_EXIT_Y1 = 548;
    static final int SRAVNIT_INFO_EXIT_Y2 = 618;
    
    static final int SRAVNIT_INFO_COUNT = 0;    
             
    //regions
    static final int BELGOROD_X1 = 78;
    static final int BELGOROD_X2 = 94;
    static final int BELGOROD_Y1 = 355;
    static final int BELGOROD_Y2 = 364;
    
    static final int BRYANSK_X1 = 75;
    static final int BRYANSK_Y1 = 316;
    static final int BRYANSK_X2 = 92;
    static final int BRYANSK_Y2 = 330;
    
    static final int VLAD_X1 = 133;
    static final int VLAD_Y1 = 324;
    static final int VLAD_X2 = 148;
    static final int VLAD_Y2 = 337;
    
    static final int VORONEZH_X1 = 95;
    static final int VORONEZH_Y1 = 364;
    static final int VORONEZH_X2 = 109;
    static final int VORONEZH_Y2 = 374;
    
    static final int IVAN_X1 = 149;
    static final int IVAN_Y1 = 321;
    static final int IVAN_X2 = 162;
    static final int IVAN_Y2 = 332;
    
    static final int KALUGA_X1 = 96;
    static final int KALUGA_Y1 = 314;
    static final int KALUGA_X2 = 114;
    static final int KALUGA_Y2 = 326;
    
    static final int KOSTROMA_X1 = 166;
    static final int KOSTROMA_Y1 = 314;
    static final int KOSTROMA_X2 = 180;
    static final int KOSTROMA_Y2 = 327;
    
    static final int KURSK_X1 = 76;
    static final int KURSK_Y1 = 337;
    static final int KURSK_X2 = 95;
    static final int KURSK_Y2 = 348;
    
    static final int LIPETSK_X1 = 103;
    static final int LIPETSK_Y1 = 345;
    static final int LIPETSK_X2 = 115;
    static final int LIPETSK_Y2 = 354;
    
    static final int MOSQUA_X1 = 117;
    static final int MOSQUA_Y1 = 322;
    static final int MOSQUA_X2 = 133;
    static final int MOSQUA_Y2 = 334;
    
    static final int ORLOVSK_X1 = 92;
    static final int ORLOVSK_Y1 = 330;
    static final int ORLOVSK_X2 = 102;
    static final int ORLOVSK_Y2 = 337;
    
    static final int RYAZ_X1 = 121;
    static final int RYAZ_Y1 = 338;
    static final int RYAZ_X2 = 138;
    static final int RYAZ_Y2 = 349;
    
    static final int SMOL_X1 = 88;
    static final int SMOL_Y1 = 299;
    static final int SMOL_X2 = 109;
    static final int SMOL_Y2 = 312;
    
    static final int TAMBI_X1 =117;
    static final int TAMBI_Y1 =354;
    static final int TAMBI_X2 =127;
    static final int TAMBI_Y2 =369;
    
    static final int TVER_X1 =115;
    static final int TVER_Y1 =289;
    static final int TVER_X2 =137;
    static final int TVER_Y2 =302;
    
    static final int TULA_X1 =107;
    static final int TULA_Y1 =330;
    static final int TULA_X2 =118;
    static final int TULA_Y2 =338;
    
    static final int YARIK_X1 =143;
    static final int YARIK_Y1 =302;
    static final int YARIK_X2 =158;
    static final int YARIK_Y2 =314;
    
    static final int MSK_X1 =37;
    static final int MSK_Y1 =285;
    static final int MSK_X2 =87;
    static final int MSK_Y2 =294;
    
    
 public ClickListener(Project nktz){
     this.nktz = nktz;
 }

   @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("Click registered: "+e.getX()+" "+ e.getY());
        System.out.println("");
    }
    // метод для проверки того что точка (x,y) находится внутри  поля 
    public static boolean insideStart(int x, int y) {
       
        return (x > START_X1 && x < START_X2 && y > START_Y1 && y < START_Y2);
    }
    public static boolean insideExit(int x, int y) {
       
        return (x >  EXIT_X1 && x < EXIT_X2 && y > EXIT_Y1 && y < EXIT_Y2);
    }
    public static boolean insideExitMap(int x, int y) {
       
        return (x >  EXIT_MAP_X1 && x < EXIT_MAP_X2 && y > EXIT_MAP_Y1 && y < EXIT_MAP_Y2);
    }
    public static boolean insideRegionInfoExit(int x, int y) {
       
        return (x >  REGION_INFO_EXIT_X1 && x < REGION_INFO_EXIT_X2 && y > REGION_INFO_EXIT_Y1 && y < REGION_INFO_EXIT_Y2);
    }
    public static boolean insideSravnit(int x, int y) {
       
        return (x >  SRAVNIT_X1 && x < SRAVNIT_X2 && y > SRAVNIT_Y1 && y < SRAVNIT_Y2);
    }
    public static boolean insideSravnitExit(int x, int y) {
       
        return (x >  SRAVNIT_EXIT_X1 && x < SRAVNIT_EXIT_X2 && y > SRAVNIT_EXIT_Y1 && y < SRAVNIT_EXIT_Y2);
    }
    public static boolean insideSravnitInfoExit(int x, int y) {
       
        return (x >  SRAVNIT_INFO_EXIT_X1 && x < SRAVNIT_INFO_EXIT_X2 && y > SRAVNIT_INFO_EXIT_Y1 && y < SRAVNIT_INFO_EXIT_Y2);
    }
    
    // для регионов
    
    public static boolean belgorod(int x, int y) {
       
        return (x >  BELGOROD_X1 && x < BELGOROD_X2 && y > BELGOROD_Y1 && y < BELGOROD_Y2);
    }
    public static boolean bryansk(int x, int y) {
       
        return (x >  BRYANSK_X1 && x < BRYANSK_X2 && y > BRYANSK_Y1 && y < BRYANSK_Y2);
    }
    public static boolean vlad(int x, int y) {
       
        return (x >  VLAD_X1 && x < VLAD_X2 && y > VLAD_Y1 && y < VLAD_Y2);
    }
    public static boolean voronezh(int x, int y) {
       
        return (x >  VORONEZH_X1 && x < VORONEZH_X2 && y > VORONEZH_Y1 && y < VORONEZH_Y2);
    }
    public static boolean ivan(int x, int y) {
       
        return (x >  IVAN_X1 && x < IVAN_X2 && y > IVAN_Y1 && y < IVAN_Y2);
    }
    public static boolean kaluga(int x, int y) {
       
        return (x >  KALUGA_X1 && x < KALUGA_X2 && y > KALUGA_Y1 && y < KALUGA_Y2);
    }
    public static boolean kostroma(int x, int y) {
       
        return (x >  KOSTROMA_X1 && x < KOSTROMA_X2 && y > KOSTROMA_Y1 && y < KOSTROMA_Y2);
    }
    public static boolean kursk(int x, int y) {
       
        return (x >  KURSK_X1 && x < KURSK_X2 && y > KURSK_Y1 && y < KURSK_Y2);
    }
    public static boolean lipetsk(int x, int y) {
       
        return (x >  LIPETSK_X1 && x < LIPETSK_X2 && y > LIPETSK_Y1 && y < LIPETSK_Y2);
    }
    public static boolean mosqua(int x, int y) {
       
        return (x >  MOSQUA_X1 && x < MOSQUA_X2 && y > MOSQUA_Y1 && y < MOSQUA_Y2);
    }
    public static boolean orel(int x, int y) {
       
        return (x >  ORLOVSK_X1 && x < ORLOVSK_X2 && y > ORLOVSK_Y1 && y < ORLOVSK_Y2);
    }
    public static boolean ryaz(int x, int y) {
       
        return (x >  RYAZ_X1 && x < RYAZ_X2 && y > RYAZ_Y1 && y < RYAZ_Y2);
    }
    public static boolean smol(int x, int y) {
       
        return (x >  SMOL_X1 && x < SMOL_X2 && y > SMOL_Y1 && y < SMOL_Y2);
    }
    public static boolean tambi(int x, int y) {
       
        return (x >  TAMBI_X1 && x < TAMBI_X2 && y > TAMBI_Y1 && y < TAMBI_Y2);
    }
    public static boolean tver(int x, int y) {
       
        return (x >  TVER_X1 && x < TVER_X2 && y > TVER_Y1 && y < TVER_Y2);
    }
    public static boolean tula(int x, int y) {
       
        return (x >  TULA_X1 && x < TULA_X2 && y > TULA_Y1 && y < TULA_Y2);
    }
    public static boolean yarik(int x, int y) {
       
        return (x >  YARIK_X1 && x < YARIK_X2 && y > YARIK_Y1 && y < YARIK_Y2);
    }
    public static boolean msk(int x, int y) {
       
        return (x >  MSK_X1 && x < MSK_X2 && y > MSK_Y1 && y < MSK_Y2);
    }
    public static boolean karelia(int x, int y) {
       
        return (x >  162 && x < 186 && y > 227 && y < 249);
    }
    public static boolean komi(int x, int y) {
       
        return (x >  232 && x < 284 && y > 288 && y < 318);
    }
    public static boolean arkhangelkaya(int x, int y) {
       
        return (x >  181 && x < 222 && y > 254 && y < 294);
    }
    public static boolean nenetzkiy(int x, int y) {
       
        return (x >  282 && x < 310 && y > 255 && y < 280);
    }
    public static boolean vologodskaya(int x, int y) {
       
        return (x >  158 && x < 173 && y > 285 && y < 308);
    }
    public static boolean kaliningradskaya(int x, int y) {
       
        return (x >  32 && x < 58 && y > 236 && y < 258);
    }
    public static boolean leningradskaya(int x, int y) {
       
        return (x >  138 && x < 153 && y > 262 && y < 274);
    }
    public static boolean murmanskaya(int x, int y) {
       
        return (x >  198 && x < 232 && y > 182 && y < 236);
    }
    public static boolean novgorodskaya(int x, int y) {
       
        return (x >  114 && x < 134 && y > 266 && y < 284);
    }
    public static boolean pskovskaya(int x, int y) {
       
        return (x >  95 && x < 108 && y > 264 && y < 278);
    }
    public static boolean peterburg(int x, int y) {
       
        return (x >  52 && x < 157 && y > 217 && y < 230);
    }
    public static boolean adigeya(int x, int y) {
       
        return (x >  32 && x < 42 && y > 410 && y < 418);
    }
    public static boolean kalmikiya(int x, int y) {
       
        return (x >  92 && x < 104 && y > 422 && y < 443);
    }
    public static boolean krasnodarskiy(int x, int y) {
       
        return (x >  53 && x < 69 && y > 398 && y < 412);
    }
    public static boolean asstrakhanskaya(int x, int y) {
       
        return (x >  112 && x < 121 && y > 429 && y < 446);
    }
    public static boolean volgogradskaya(int x, int y) {
       
        return (x >  102 && x < 125 && y > 385 && y < 413);
    }
    public static boolean rostovskaya(int x, int y) {
       
        return (x >  71 && x < 93 && y > 389 && y < 412);
    }
    public static boolean dagestan(int x, int y) {
       
        return (x >  76 && x < 90 && y > 470 && y < 486);
    }
    public static boolean ingushetia(int x, int y) {
       
        return (x >  62 && x < 67 && y > 458 && y < 466);
    }
    public static boolean kabardino_bal(int x, int y) {
       
        return (x >  50 && x < 54 && y > 441 && y < 447);
    }
    public static boolean karachaevo_cher(int x, int y) {
       
        return (x >  42 && x < 48 && y > 430 && y < 438);
    }
    public static boolean sev_osetia(int x, int y) {
       
        return (x >  52 && x < 59 && y > 449 && y < 457);
    }
    public static boolean chechenskaya(int x, int y) {
       
        return (x >  61 && x < 69 && y > 469 && y < 479);
    }
    public static boolean stavropolskiy(int x, int y) {
       
        return (x >  67 && x < 88 && y > 423 && y < 441);
    }
    public static boolean bashkortostan(int x, int y) {
       
        return (x >  198 && x < 218 && y > 398 && y < 422);
    }
    public static boolean mariy_el(int x, int y) {
       
        return (x >  177 && x < 187 && y > 349 && y < 359);
    }
    public static boolean mordovia(int x, int y) {
       
        return (x >  141 && x < 149 && y > 355 && y < 365);
    }
    public static boolean tatarstan(int x, int y) {
       
        return (x >  179 && x < 192 && y > 368 && y < 384);
    }
    public static boolean udmurtskaya(int x, int y) {
       
        return (x >  204 && x < 215 && y > 361 && y < 372);
    }
    public static boolean chuvashskaya(int x, int y) {
       
        return (x >  167 && x < 175 && y > 354 && y < 362);
    }
    public static boolean spermskiy(int x, int y) {
       
        return (x >  228 && x < 243 && y > 347 && y < 374);
    }
    public static boolean kirovskaya(int x, int y) {
       
        return (x >  189 && x < 209 && y > 335 && y < 354);
    }
    public static boolean nizhegorodskaya(int x, int y) {
       
        return (x >  152 && x < 166 && y > 339 && y < 352);
    }
    public static boolean orenburgskaya(int x, int y) {
       
        return (x >  174 && x < 195 && y > 412 && y < 438);
    }
    public static boolean penzenskaya(int x, int y) {
       
        return (x >  136 && x < 151 && y > 367 && y < 381);
    }
    public static boolean samarskaya(int x, int y) {
       
        return (x >  164 && x < 179 && y > 384 && y < 399);
    }
    public static boolean saratovskaya(int x, int y) {
       
        return (x >  134 && x < 156 && y > 388 && y < 407);
    }
    public static boolean ulyanovskaya(int x, int y) {
       
        return (x >  155 && x < 170 && y > 370 && y < 382);
    }
    public static boolean kurganskaya(int x, int y) {
       
        return (x >  252 && x < 273 && y > 414 && y < 431);
    }
    public static boolean sverdlovskaya(int x, int y) {
       
        return (x >  252 && x < 274 && y > 362 && y < 396);
    }
    public static boolean tymenskaya(int x, int y) {
       
        return (x >  281 && x < 303 && y > 399 && y < 423);
    }
    public static boolean khanti_mansiyskiy(int x, int y) {
       
        return (x >  281 && x < 368 && y > 365 && y < 389);
    }
    public static boolean yamalo_nenetzkiy(int x, int y) {
       
        return (x >  327 && x < 401 && y > 315 && y < 359);
    }
    public static boolean chelyabinskaya(int x, int y) {
       
        return (x >  236 && x < 249 && y > 400 && y < 414);
    }
    public static boolean altay(int x, int y) {
       
        return (x >  367 && x < 400 && y > 509 && y < 528);
    }
    public static boolean buryatia(int x, int y) {
       
        return (x >  538 && x < 566 && y > 466 && y < 503);
    }
    public static boolean tiva(int x, int y) {
       
        return (x >  411 && x < 464 && y > 508 && y < 528);
    }
    public static boolean hakasia(int x, int y) {
       
        return (x >  407 && x < 418 && y > 477 && y < 501);
    }
    public static boolean altayskiy(int x, int y) {
       
        return (x >  335 && x < 380 && y > 476 && y < 501);
    }
    public static boolean zabaykalskiy(int x, int y) {
       
        return (x >  573 && x < 601 && y > 492 && y < 534);
    }
    public static boolean krasnoyarskiy(int x, int y) {
       
        return (x >  411 && x < 500 && y > 259 && y < 429);
    }
    public static boolean irkutskaya(int x, int y) {
       
        return (x >  459 && x < 528 && y > 470 && y < 493);
    }
    public static boolean kemerovskaya(int x, int y) {
       
        return (x >  385 && x < 401 && y > 458 && y < 478);
    }
    public static boolean novosibirskaya(int x, int y) {
       
        return (x >  332 && x < 357 && y > 441 && y < 463);
    }
    public static boolean omskaya(int x, int y) {
       
        return (x >  306 && x < 321 && y > 417 && y < 453);
    }
    public static boolean tomskaya(int x, int y) {
       
        return (x >  342 && x < 404 && y > 415 && y < 438);
    }
    public static boolean saha_yakutia(int x, int y) {
       
        return (x >  541 && x < 684 && y > 270 && y < 399);
    }
    public static boolean cumchatskiy(int x, int y) {
       
        return (x >  803 && x < 850 && y > 284 && y < 444);
    }
    public static boolean primorskiy(int x, int y) {
       
        return (x >  719 && x < 738 && y > 540 && y < 580);
    }
    public static boolean habarovskiy(int x, int y) {
       
        return (x >  706 && x < 740 && y > 467 && y < 511);
    }
    public static boolean amurskaya(int x, int y) {
       
        return (x >  621 && x < 687 && y > 466 && y < 495);
    }
    public static boolean magadanskaya(int x, int y) {
       
        return (x >  739 && x < 779 && y > 292 && y < 361);
    }
    public static boolean sakhalinskaya(int x, int y) {
       
        return (x >  753 && x < 831 && y > 441 && y < 551);
    }
    public static boolean evreyskaya_aobl(int x, int y) {
       
        return (x >  692 && x < 709 && y > 514 && y < 528);
    }
    public static boolean chukotskiy(int x, int y) {
       
        return (x >  744 && x < 856 && y > 159 && y < 268);
    }
    public static boolean krim(int x, int y) {
       
        return (x >  23 && x < 72 && y > 335 && y < 385);
    }
    public static boolean sevastopol(int x, int y) {
       
        return (x >  12 && x < 24 && y > 390 && y < 402);
    }
   


    @Override
    public void mousePressed(MouseEvent e) {
      boolean isOneClick = e.getClickCount() == 1;  
        
        
        //выход
        if(isOneClick && insideExit(e.getX(), e.getY()) && nktz.status == 1){
            System.out.println("Program closed");
            System.out.println("Here I am");
            System.exit(0);
        }
        
        //выход с карты в меню
        if(isOneClick && insideExitMap(e.getX(), e.getY())&& nktz.status > 1){
            System.out.println("Map closed");
            nktz.sravnit_ubil[0] = 0;
            nktz.sravnit_ubil[1] = 0;
            nktz.sravnit_ubil[2] = 0;
            nktz.sravnit_imya[0] = "NULL";
            nktz.sravnit_imya[1] = "NULL";
            nktz.sravnit_imya[2] = "NULL";
            nktz.status = 1;
        }
        
        //выход с окна информации о регионе
        if(isOneClick && insideRegionInfoExit(e.getX(), e.getY())&& nktz.status == 3){
            System.out.println("Region info closed");
            nktz.status = 2;
        }
        
        //сравнение регионов
        if(isOneClick && insideSravnit(e.getX(), e.getY())&& nktz.status == 2){
            System.out.println("Comparison mode");
            System.out.println("Region chosen 0/3");
            nktz.sravnenie();
        }
        
        //выход из процедуры сравнения
        if(isOneClick && insideSravnitExit(e.getX(), e.getY())&& nktz.status > 3 && nktz.status < 7){
            System.out.println("Comparison mode closed");
            nktz.status = 2;
            nktz.sravnit_ubil[0] = 0;
            nktz.sravnit_ubil[1] = 0;
            nktz.sravnit_ubil[2] = 0;
            nktz.sravnit_imya[0] = "NULL";
            nktz.sravnit_imya[1] = "NULL";
            nktz.sravnit_imya[2] = "NULL";
        }
        
        //выход из окна (итогов сравнения)
        if(isOneClick && insideSravnitInfoExit(e.getX(), e.getY())&& nktz.status == 7){
            System.out.println("Comparison info closed");
            nktz.status = 2;
            nktz.sravnit_ubil[0] = 0;
            nktz.sravnit_ubil[1] = 0;
            nktz.sravnit_ubil[2] = 0;
            nktz.sravnit_imya[0] = "NULL";
            nktz.sravnit_imya[1] = "NULL";
            nktz.sravnit_imya[2] = "NULL";
            
        }
        
        
        //РЕГИОНЫ
        //Первый if для открытия окна информации о регионе
        //Второй if для выбора региона для сравнения
        if(isOneClick && belgorod(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 1;
            System.out.println("Belgorodskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && belgorod(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 1;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[0];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[0];
            nktz.sravnenie();
            System.out.println("Belgorodskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        if(isOneClick && bryansk(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 2;
            System.out.println("Bryanskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && bryansk(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 2;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[1];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[1];
            nktz.sravnenie();
            System.out.println("Bryanskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        if(isOneClick && vlad(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 3;
            System.out.println("Vladimirskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && vlad(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 3;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[2];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[2];
            nktz.sravnenie();
            System.out.println("Vladimirskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        if(isOneClick && voronezh(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 4;
            System.out.println("Voronezhskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && voronezh(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 4;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[3];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[3];
            nktz.sravnenie();
            System.out.println("Voronezhskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        if(isOneClick && ivan(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 5;
            System.out.println("Ivanovskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && ivan(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 5;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[4];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[4];
            nktz.sravnenie();
            System.out.println("Ivanovskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        if(isOneClick && kaluga(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 6;
            System.out.println("Kaluzhskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && kaluga(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 6;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[5];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[5];
            nktz.sravnenie();
            System.out.println("Kaluzhskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        if(isOneClick && kostroma(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 7;
            System.out.println("Kostromskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && kostroma(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 7;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[6];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[6];
            nktz.sravnenie();
            System.out.println("Kostromskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        if(isOneClick && kursk(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 8;
            System.out.println("Kurskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && kursk(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 8;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[7];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[7];
            nktz.sravnenie();
            System.out.println("Kurskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        if(isOneClick && lipetsk(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 9;
            System.out.println("Lipetskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && lipetsk(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 9;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[8];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[8];
            nktz.sravnenie();
            System.out.println("Lipetskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        if(isOneClick && mosqua(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 10;
            System.out.println("Moskowskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && mosqua(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 10;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[9];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[9];
            nktz.sravnenie();
            System.out.println("Moskowskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        if(isOneClick && orel(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 11;
            System.out.println("Orlovskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && orel(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 11;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[10];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[10];
            nktz.sravnenie();
            System.out.println("Orlovskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        if(isOneClick && ryaz(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 12;
            System.out.println("Ryazanskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && ryaz(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 12;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[11];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[11];
            nktz.sravnenie();
            System.out.println("Ryazanskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        if(isOneClick && smol(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 13;
            System.out.println("Smolenskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && smol(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 13;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[12];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[12];
            nktz.sravnenie();
            System.out.println("Smolenskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        if(isOneClick && tambi(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 14;
            System.out.println("Tambovskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && tambi(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 14;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[13];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[13];
            nktz.sravnenie();
            System.out.println("Tambovskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        if(isOneClick && tver(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 15;
            System.out.println("Tverskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && tver(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 15;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[14];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[14];
            nktz.sravnenie();
            System.out.println("Tverskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        if(isOneClick && tula(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 16;
            System.out.println("Tul'skaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && tula(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 16;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[15];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[15];
            nktz.sravnenie();
            System.out.println("Tul'skaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        if(isOneClick && yarik(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 17;
            System.out.println("Yaroslavskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && yarik(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 17;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[16];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[16];
            nktz.sravnenie();
            System.out.println("Yaroslavskaya obl. chosen, region number "+nktz.regionNumber);
        }
        
        if(isOneClick && msk(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 18;
            System.out.println("g. Moskva opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && msk(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 18;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[17];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[17];
            nktz.sravnenie();
            System.out.println("g. Moskva chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && karelia(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 19;
            System.out.println("Karelia opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && karelia(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 19;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[18];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[18];
            nktz.sravnenie();
            System.out.println("Karelia chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && komi(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 20;
            System.out.println("Resp. Komi opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && komi(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 20;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[19];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[19];
            nktz.sravnenie();
            System.out.println("Resp. Komi chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && arkhangelkaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 21;
            System.out.println("Arkhangelkaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && arkhangelkaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 21;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[20];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[20];
            nktz.sravnenie();
            System.out.println("Arkhangelkaya obl. chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && nenetzkiy(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 22;
            System.out.println("Nenetzkiy AO opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && nenetzkiy(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 22;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[21];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[21];
            nktz.sravnenie();
            System.out.println("Nenetzkiy AO chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && vologodskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 23;
            System.out.println("Vologodskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && vologodskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 23;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[22];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[22];
            nktz.sravnenie();
            System.out.println("Vologodskaya obl. chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && kaliningradskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 24;
            System.out.println("Kaliningradskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && kaliningradskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 24;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[23];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[23];
            nktz.sravnenie();
            System.out.println("Kaliningradskaya obl. chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && leningradskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 25;
            System.out.println("Leningradskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && leningradskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 25;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[24];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[24];
            nktz.sravnenie();
            System.out.println("Leningradskaya obl. chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && murmanskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 26;
            System.out.println("Murmanskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && murmanskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 26;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[25];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[25];
            nktz.sravnenie();
            System.out.println("Murmanskaya obl. chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && novgorodskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 27;
            System.out.println("Novgorodskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && novgorodskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 27;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[26];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[26];
            nktz.sravnenie();
            System.out.println("Novgorodskaya obl. chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && pskovskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 28;
            System.out.println("Pskovskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && pskovskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 28;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[27];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[27];
            nktz.sravnenie();
            System.out.println("Pskovskaya obl. chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && peterburg(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 29;
            System.out.println("Saint-Petersburg opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && peterburg(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 29;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[28];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[28];
            nktz.sravnenie();
            System.out.println("Saint-Petersburg chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && adigeya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 30;
            System.out.println("Resp. Adigeya opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && adigeya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 30;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[29];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[29];
            nktz.sravnenie();
            System.out.println("Resp. Adigeya chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && kalmikiya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 31;
            System.out.println("Resp. Kalmikiya opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && kalmikiya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 31;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[30];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[30];
            nktz.sravnenie();
            System.out.println("Resp. Kalmikiya chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && krasnodarskiy(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 32;
            System.out.println("krasnodarskiy kray opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && krasnodarskiy(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 32;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[31];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[31];
            nktz.sravnenie();
            System.out.println("krasnodarskiy kray chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && asstrakhanskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 33;
            System.out.println("astrakhanskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && asstrakhanskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 33;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[32];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[32];
            nktz.sravnenie();
            System.out.println("astrakhanskaya obl. chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && volgogradskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 34;
            System.out.println("volgogradskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && volgogradskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 34;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[33];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[33];
            nktz.sravnenie();
            System.out.println("volgogradskaya obl. chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && rostovskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 35;
            System.out.println("rostovskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && rostovskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 35;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[34];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[34];
            nktz.sravnenie();
            System.out.println("rostovskaya obl. chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && dagestan(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 36;
            System.out.println("dagestan opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && dagestan(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 36;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[35];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[35];
            nktz.sravnenie();
            System.out.println("dagestan chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && ingushetia(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 37;
            System.out.println("ingushetia opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && ingushetia(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 37;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[36];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[36];
            nktz.sravnenie();
            System.out.println("ingushetia chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && kabardino_bal(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 38;
            System.out.println("kabardino_balkaria opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && kabardino_bal(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 38;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[37];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[37];
            nktz.sravnenie();
            System.out.println("kabardino_balkaria chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && karachaevo_cher(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 39;
            System.out.println("karachaevo_cherkessia opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && karachaevo_cher(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 39;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[38];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[38];
            nktz.sravnenie();
            System.out.println("karachaevo_cherkessia chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && sev_osetia(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 40;
            System.out.println("severnaya osetia opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && sev_osetia(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 40;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[39];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[39];
            nktz.sravnenie();
            System.out.println("severnaya osetia chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && chechenskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 41;
            System.out.println("chechenskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && chechenskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 41;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[40];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[40];
            nktz.sravnenie();
            System.out.println("chechenskaya obl. chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && stavropolskiy(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 42;
            System.out.println("stavropolskiy kray opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && stavropolskiy(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 42;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[41];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[41];
            nktz.sravnenie();
            System.out.println("stavropolskiy kray chosen, region number "+nktz.regionNumber);
        }
         if(isOneClick && bashkortostan(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 43;
            System.out.println("bashkortostan opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && bashkortostan(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 43;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[42];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[42];
            nktz.sravnenie();
            System.out.println("bashkortostan chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && mariy_el(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 44;
            System.out.println("resp. mariy_el opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && mariy_el(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 44;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[43];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[43];
            nktz.sravnenie();
            System.out.println("resp. mariy_el chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && mordovia(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 45;
            System.out.println("resp. mordovia opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && mordovia(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 45;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[44];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[44];
            nktz.sravnenie();
            System.out.println("resp. mordovia  chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && tatarstan(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 46;
            System.out.println("resp. tatarstan opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && tatarstan(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 46;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[45];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[45];
            nktz.sravnenie();
            System.out.println("resp. tatarstan  chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && udmurtskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 47;
            System.out.println("resp. udmurtskaya opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && udmurtskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 47;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[46];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[46];
            nktz.sravnenie();
            System.out.println("resp. udmurtskaya  chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && chuvashskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 48;
            System.out.println("resp. chuvashskaya opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && chuvashskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 48;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[47];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[47];
            nktz.sravnenie();
            System.out.println("resp. chuvashskaya  chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && spermskiy(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 49;
            System.out.println("permskiy kray opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && spermskiy(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 49;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[48];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[48];
            nktz.sravnenie();
            System.out.println("permskiy kray  chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && kirovskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 50;
            System.out.println("kirovskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && kirovskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 50;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[49];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[49];
            nktz.sravnenie();
            System.out.println("kirovskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && nizhegorodskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 51;
            System.out.println("nizhegorodskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && nizhegorodskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 51;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[50];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[50];
            nktz.sravnenie();
            System.out.println("nizhegorodskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && orenburgskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 52;
            System.out.println("orenburgskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && orenburgskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 52;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[51];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[51];
            nktz.sravnenie();
            System.out.println("orenburgskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && penzenskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 53;
            System.out.println("penzenskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && penzenskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 53;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[52];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[52];
            nktz.sravnenie();
            System.out.println("penzenskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && samarskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 54;
            System.out.println("samarskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && samarskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 54;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[53];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[53];
            nktz.sravnenie();
            System.out.println("samarskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && saratovskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 55;
            System.out.println("saratovskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && saratovskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 55;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[54];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[54];
            nktz.sravnenie();
            System.out.println("saratovskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && ulyanovskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 56;
            System.out.println("ulyanovskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && ulyanovskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 56;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[55];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[55];
            nktz.sravnenie();
            System.out.println("ulyanovskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && kurganskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 57;
            System.out.println("kurganskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && kurganskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 57;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[56];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[56];
            nktz.sravnenie();
            System.out.println("kurganskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && sverdlovskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 58;
            System.out.println("sverdlovskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && sverdlovskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 58;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[57];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[57];
            nktz.sravnenie();
            System.out.println("sverdlovskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && tymenskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 59;
            System.out.println("tymenskaya obl. opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && tymenskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 59;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[58];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[58];
            nktz.sravnenie();
            System.out.println("tymenskaya obl.  chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && khanti_mansiyskiy(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 60;
            System.out.println("khanti_mansiyskiy okrug opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && khanti_mansiyskiy(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 60;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[59];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[59];
            nktz.sravnenie();
            System.out.println("khanti_mansiyskiy okrug  chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && yamalo_nenetzkiy(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 61;
            System.out.println("yamalo_nenetzkiy okrug opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && yamalo_nenetzkiy(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 61;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[60];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[60];
            nktz.sravnenie();
            System.out.println("yamalo_nenetzkiy okrug  chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && chelyabinskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 62;
            System.out.println("chelyabinskaya opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && chelyabinskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 62;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[61];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[61];
            nktz.sravnenie();
            System.out.println("chelyabinskaya chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && altay(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 63;
            System.out.println("altay opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && altay(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 63;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[62];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[62];
            nktz.sravnenie();
            System.out.println("altay chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && buryatia(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 64;
            System.out.println("buryatia opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && buryatia(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 64;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[63];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[63];
            nktz.sravnenie();
            System.out.println("buryatia chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && tiva(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 65;
            System.out.println("tiva opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && tiva(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 65;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[64];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[64];
            nktz.sravnenie();
            System.out.println("tiva chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && hakasia(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 66;
            System.out.println("hakasia opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && hakasia(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 66;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[65];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[65];
            nktz.sravnenie();
            System.out.println("hakasia chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && altayskiy(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 67;
            System.out.println("altayskiy opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && altayskiy(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 67;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[66];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[66];
            nktz.sravnenie();
            System.out.println("altayskiy chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && zabaykalskiy(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 68;
            System.out.println("zabaykalskiy opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && zabaykalskiy(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 68;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[67];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[67];
            nktz.sravnenie();
            System.out.println("zabaykalskiy chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && krasnoyarskiy(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 69;
            System.out.println("krasnoyarskiy opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && krasnoyarskiy(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 69;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[68];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[68];
            nktz.sravnenie();
            System.out.println("krasnoyarskiy chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && irkutskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 70;
            System.out.println("irkutskaya opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && irkutskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 70;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[69];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[69];
            nktz.sravnenie();
            System.out.println("irkutskaya chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && kemerovskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 71;
            System.out.println("kemerovskaya opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && kemerovskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 71;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[70];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[70];
            nktz.sravnenie();
            System.out.println("kemerovskaya chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && novosibirskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 72;
            System.out.println("novosibirskaya opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && novosibirskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 72;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[71];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[71];
            nktz.sravnenie();
            System.out.println("novosibirskaya chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && omskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 73;
            System.out.println("omskaya opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && omskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 73;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[72];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[72];
            nktz.sravnenie();
            System.out.println("omskaya chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && tomskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 74;
            System.out.println("tomskaya opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && tomskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 74;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[73];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[73];
            nktz.sravnenie();
            System.out.println("tomskaya chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && saha_yakutia(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 75;
            System.out.println("saha_yakutia opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && saha_yakutia(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 75;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[74];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[74];
            nktz.sravnenie();
            System.out.println("saha_yakutia chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && cumchatskiy(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 76;
            System.out.println("kamchatskiy opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && cumchatskiy(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 76;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[75];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[75];
            nktz.sravnenie();
            System.out.println("kamchatskiy chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && primorskiy(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 77;
            System.out.println("primorskiy opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && primorskiy(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 77;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[76];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[76];
            nktz.sravnenie();
            System.out.println("primorskiy chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && habarovskiy(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 78;
            System.out.println("habarovskiy opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && habarovskiy(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 78;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[77];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[77];
            nktz.sravnenie();
            System.out.println("habarovskiy chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && amurskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 79;
            System.out.println("amurskaya opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && amurskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 79;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[78];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[78];
            nktz.sravnenie();
            System.out.println("amurskaya chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && magadanskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 80;
            System.out.println("magadanskaya opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && magadanskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 80;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[79];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[79];
            nktz.sravnenie();
            System.out.println("magadanskaya chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && sakhalinskaya(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 81;
            System.out.println("sakhalinskaya opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && sakhalinskaya(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 81;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[80];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[80];
            nktz.sravnenie();
            System.out.println("sakhalinskaya chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && evreyskaya_aobl(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 82;
            System.out.println("evreyskaya_aobl opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && evreyskaya_aobl(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 82;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[81];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[81];
            nktz.sravnenie();
            System.out.println("evreyskaya_aobl chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && chukotskiy(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 83;
            System.out.println("chukotskiy opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && chukotskiy(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 83;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[82];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[82];
            nktz.sravnenie();
            System.out.println("chukotskiy chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && krim(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 84;
            System.out.println("krim opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && krim(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 84;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[83];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[83];
            nktz.sravnenie();
            System.out.println("krim chosen, region number "+nktz.regionNumber);
        }
        if(isOneClick && sevastopol(e.getX(), e.getY()) && nktz.status == 2){
            nktz.info();
            nktz.regionNumber = 85;
            System.out.println("sevastopol opened, region number "+nktz.regionNumber);
        }
        if(isOneClick && sevastopol(e.getX(), e.getY()) && nktz.status > 3 && nktz.status < 7){
            nktz.regionNumber = 85;
            nktz.sravnit_ubil[nktz.status - 4] = nktz.ubil[84];
            nktz.sravnit_imya[nktz.status - 4] = nktz.imya[84];
            nktz.sravnenie();
            System.out.println("sevastopol chosen, region number "+nktz.regionNumber);
        }
        
        
        //открытие карты
        if(insideStart(e.getX(), e.getY()) && nktz.status == 1){
            System.out.println("Map opened");
            nktz.start();
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
