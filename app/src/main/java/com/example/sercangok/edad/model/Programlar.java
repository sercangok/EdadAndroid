package com.example.sercangok.edad.model;

import com.example.sercangok.edad.util.KongreInfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by sercangok on 27/08/14.
 */
public class Programlar {
    public static List<Program> programlar17EkimCuma;
    public static List<Program> programlar18EkimCtesi;
    public static List<Program> programlar19EkimPazar;
    public static Program sosyalProgramKokteyl;
    public static Program sosyalProgramGala;

    public Programlar() {
        programlar17EkimCuma = new ArrayList<Program>();
        programlar18EkimCtesi = new ArrayList<Program>();
        programlar19EkimPazar = new ArrayList<Program>();
        fillLists();
    }

    private void fillLists() {
        new KongreInfo();
        Calendar calS = Calendar.getInstance();
        Calendar calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 8, 0);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 9, 30);
        programlar17EkimCuma.add(new Program(calS, calF, "Kayıt"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 9, 30);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 10, 30);
        programlar17EkimCuma.add(new Program(calS, calF, "Dr. Paulo Monteir \n Estetik dişhekimliginde direkt ve indirekt uygulamalar: Kazanan tarifler"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 10, 30);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 11, 15);
        programlar17EkimCuma.add(new Program(calS, calF, "Kahve Molası"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 11, 15);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 12, 15);
        programlar17EkimCuma.add(new Program(calS, calF, "Dr. Daniel Edelhoff \n Karmaşık vakaların estetik ve fonksiyonel rehabilitasyonunda yenilikçi tedavi kavramları"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 12, 15);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 13, 45);
        programlar17EkimCuma.add(new Program(calS, calF, "Öğle Yemeği"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 13, 45);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 14, 45);
        programlar17EkimCuma.add(new Program(calS, calF, "Prof.Dr. Selim Pamuk  \n Dijital estetiğin neresindeyiz?"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 14, 45);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 15, 30);
        programlar17EkimCuma.add(new Program(calS, calF, "Kahve Molası"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 15, 30);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 16, 0);
        programlar17EkimCuma.add(new Program(calS, calF, "Açılış Seremonisi"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 16, 0);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 17, 0);
        programlar17EkimCuma.add(new Program(calS, calF, "Dr. Marco Degidi \n İmmediat yükleme ve estetik başarı: Güçlü bir sinerji"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 17, 0);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 18, 0);
        programlar17EkimCuma.add(new Program(calS, calF, "Dr. Joseph Sabbagh / Dr. Arne Lund \n Adheziv diş hekimliğinde hatalardan ögrendiklerimiz; \n" +
                "Başarısızlıkların tanımlanmaları ve giderilmesi"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 18, 15);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 19, 0);
        programlar17EkimCuma.add(new Program(calS, calF, "Hoşgeldiniz Kokteyli"));
        sosyalProgramKokteyl = new Program(calS, calF, "Hoşgeldiniz Kokteyli");


        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 9, 30);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 10, 30);
        programlar18EkimCtesi.add(new Program(calS, calF, "Dr. Wael Att \n" +
                "İmplant dişhekimliğinin son durumu ve geleceği"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 10, 30);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 11, 0);
        programlar18EkimCtesi.add(new Program(calS, calF, "Kahve Molası"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 11, 0);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 12, 0);
        programlar18EkimCtesi.add(new Program(calS, calF, "Dr. Nicole Arweiler\n" +
                "İmplant'ların bakımı ve Periimplantitis'in önlenmesi "));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 12, 0);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 13, 0);
        programlar18EkimCtesi.add(new Program(calS, calF, "Dr. Ilja Mihatovic\n" +
                "Yönlendirilmiş kemik rejenerasyonunda güncellemeler"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 13, 30);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 14, 30);
        programlar18EkimCtesi.add(new Program(calS, calF, "Öğle Yemeği"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 14, 30);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 15, 30);
        programlar18EkimCtesi.add(new Program(calS, calF, "Dr. Axel Mory\n" +
                "Kortikotomi - Hızlandırılmış osteojenik ortodonti: Ortodontide yeni olanaklar "));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 15, 30);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 16, 0);
        programlar18EkimCtesi.add(new Program(calS, calF, "Kahve Molası"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 16, 0);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 17, 0);
        programlar18EkimCtesi.add(new Program(calS, calF, "Dr. Gerhard Iglhaut\n" +
                "Yumuşak ve sert doku yönetiminde yenilikler"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 20, 0);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 2, 0);
        programlar18EkimCtesi.add(new Program(calS, calF, "Gala Yemeği"));
        sosyalProgramGala = new Program(calS, calF, "Gala Yemeği");


        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 10, 0);
        calF.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 11, 0);
        programlar19EkimPazar.add((new Program(calS, calF, "Dr. Michael Müller\n" +
                "Periodontal plastik cerrahide yenilikler ve gereklilikler")));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 11, 0);
        calF.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 11, 45);
        programlar19EkimPazar.add((new Program(calS, calF, "Kahve Molası")));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 11, 45);
        calF.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 12, 45);
        programlar19EkimPazar.add((new Program(calS, calF, "Dr. Stephane Browet\n" +
                "Matris'in  yeniden keşfi")));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 12, 45);
        calF.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 14, 0);
        programlar19EkimPazar.add((new Program(calS, calF, "Öğle Yemeği")));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 14, 0);
        calF.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 15, 0);
        programlar19EkimPazar.add((new Program(calS, calF, "Cdt. Florin Stoboran\n" +
                "Doğal estetik bir görüntü için doğru seçimi yapmanın basitleştirilmiş ve kolay yolları")));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 15, 0);
        calF.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 15, 30);
        programlar19EkimPazar.add((new Program(calS, calF, "Hediye Çekilişi ve Kapanış Seremonisi")));
    }
}
