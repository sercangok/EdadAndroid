package com.salyangoz.edad.model;

import com.salyangoz.edad.util.KongreInfo;

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
        programlar17EkimCuma.add(new Program(calS, calF, "Kayıt", ""));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 9, 30);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 10, 30);
<<<<<<< Updated upstream:app/src/main/java/com/example/sercangok/edad/model/Programlar.java
        programlar17EkimCuma.add(new Program(calS, calF, "Dr. Hrvoje Juric ", "Dental Travmanın Tedavisinde Güncel Olanaklar"));
=======
        programlar17EkimCuma.add(new Program(calS, calF, "Dr. Paulo Monteiro", "Estetik dişhekimliginde direkt ve indirekt uygulamalar: Kazanan tarifler"));
>>>>>>> Stashed changes:app/src/main/java/com/salyangoz/edad/model/Programlar.java
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 10, 30);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 11, 15);
        programlar17EkimCuma.add(new Program(calS, calF, "Kahve Molası", ""));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 11, 15);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 12, 15);
        programlar17EkimCuma.add(new Program(calS, calF, "Dr. Marius Steigman", "İmplantolojide Kompleks Estetik Vakalarda Yumuşak Doku Başarısızlığının Önlenmesi ve Tedavisi"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 12, 15);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 13, 45);
        programlar17EkimCuma.add(new Program(calS, calF, "Öğle Yemeği", ""));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 13, 45);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 14, 45);
        programlar17EkimCuma.add(new Program(calS, calF, "Dr. Vincent Arnetzl",
                "Cad/Cam  Kullanımında Materyal Seçimi ve Yapılabilecekler"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 14, 45);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 15, 30);
        programlar17EkimCuma.add(new Program(calS, calF, "Kahve Molası", ""));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 15, 30);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 16, 0);
        programlar17EkimCuma.add(new Program(calS, calF, "Açılış Seremonisi/Dr. Selim Pamuk-Dt. Serdar Sıralar", ""));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 16, 0);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 18, 0);
        programlar17EkimCuma.add(new Program(calS, calF, "Serbest Bildiriler", ""));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 16, 0);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 16, 30);
        programlar17EkimCuma.add(new Program(calS, calF, "Dt. Serhat Köken ", "İzolasyon"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 16, 30);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 17, 0);
        programlar17EkimCuma.add(new Program(calS, calF, "Dr. Yüksel Yazıcıoğlu ", "Preparasyon, Retraksiyon ve Ölçü Stratejilerinin Pratik Uygulamalar İçindeki Önemi"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 17, 0);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 17, 30);
        programlar17EkimCuma.add(new Program(calS, calF, "Dt. Onur Öztürk", "Estetik Dişhekimliği Uygulamalarında Materyal Seçimi"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 17, 30);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 18, 0);
        programlar17EkimCuma.add(new Program(calS, calF, "Dt. Osman Er", "CAD CAM Destekli Gülüş Tasarımı, Estetikte Mükemmeli Arama"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 18, 15);
        calF.set(KongreInfo.ilkGun.kongreYil, KongreInfo.ilkGun.kongreAy, KongreInfo.ilkGun.kongreGun, 19, 0);
        programlar17EkimCuma.add(new Program(calS, calF, "Açılış Kokteyli", ""));
        sosyalProgramKokteyl = new Program(calS, calF, "Açılış Kokteyli", "Grand Cevahir Otel Sergi Alanı", true);


        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 9, 30);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 10, 30);
        programlar18EkimCtesi.add(new Program(calS, calF, "Dr. Jan Hajto",
                "Full Seramik Restorasyon  Materyalleri-Seçime Dayanan  Bir  Endikasyon"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 10, 30);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 11, 15);
        programlar18EkimCtesi.add(new Program(calS, calF, "Kahve Molası", ""));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 11, 15);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 12, 15);
        programlar18EkimCtesi.add(new Program(calS, calF, "Dr. Hrvoje Starcevic ",
                "Bir Hastada Farklı Tiplerde Seramik Uygulamak Mümkün Müdür ?"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 12, 15);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 13, 15);
        programlar18EkimCtesi.add(new Program(calS, calF, "Dr. Gianfranco Politano",
                "Direkt Adeziv Posterior Restorasyonlar Hakkında Değerlendirmeler"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 13, 15);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 14, 45);
        programlar18EkimCtesi.add(new Program(calS, calF, "Poster Tartışmaları / Öğle Yemeği", ""));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 14, 45);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 15, 45);
        programlar18EkimCtesi.add(new Program(calS, calF, "Dr. Selim Pamuk & Dt. Cansın Özgür ", "Dijital Gülüş Tasarı mı ? Mit mi ? Gerçek mi ?"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 15, 45);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 16, 30);
        programlar18EkimCtesi.add(new Program(calS, calF, "Kahve Molası", ""));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 16, 30);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 17, 30);
        programlar18EkimCtesi.add(new Program(calS, calF, "Dr. Giancarlo Pongione",
                "Anterior Dişlerin Restorasyonunda “Biyomimetik” Yaklaşım"));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 20, 0);
        calF.set(KongreInfo.ikinciGun.kongreYil, KongreInfo.ikinciGun.kongreAy, KongreInfo.ikinciGun.kongreGun, 2, 0);
        programlar18EkimCtesi.add(new Program(calS, calF, "Gala Yemeği", ""));
        sosyalProgramGala = new Program(calS, calF, "Gala Yemeği", "Su Ada", true);


        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 10, 0);
        calF.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 11, 0);
        programlar19EkimPazar.add((new Program(calS, calF, "Dr. Igor Ristic",
                "İmplantasyondaki Başarıyı Restorasyonlarla Nasıl Devam Ettirebiliriz?")));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 11, 0);
        calF.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 11, 45);
        programlar19EkimPazar.add((new Program(calS, calF, "Kahve Molası", "")));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 11, 45);
        calF.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 12, 45);
        programlar19EkimPazar.add((new Program(calS, calF, "Dr. Juergen Manhart",
                "Seramik ve Kompozit Restorasyonlarla Gülüş Tasarımı")));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 12, 45);
        calF.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 14, 0);
        programlar19EkimPazar.add((new Program(calS, calF, "Öğle Yemeği", "")));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 14, 0);
        calF.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 15, 0);
        programlar19EkimPazar.add((new Program(calS, calF, "Cdt Rob Lynock",
                "Full Seramik Restorasyonlarda Estetik Değerlendirmeler ve Bilimsel Gelişmeler")));
        calS = Calendar.getInstance();
        calF = Calendar.getInstance();
        calS.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 15, 0);
        calF.set(KongreInfo.sonGUn.kongreYil, KongreInfo.sonGUn.kongreAy, KongreInfo.sonGUn.kongreGun, 15, 30);
        programlar19EkimPazar.add((new Program(calS, calF, "Çekiliş/Kapanış", "")));
    }
}
