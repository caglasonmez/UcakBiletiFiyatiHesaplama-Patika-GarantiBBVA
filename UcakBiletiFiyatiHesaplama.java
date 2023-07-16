package CaglaSonmez;

import java.util.Scanner;

public class UcakBiletiFiyatiHesaplama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int distance, age, tripType;

        System.out.print("Gideceğiniz mesafeyi kilometre cinsinden giriniz: ");
        distance = input.nextInt();

        System.out.print("Yaşınızı giriniz: ");
        age = input.nextInt();

        System.out.print("Yolculuk tipini giriniz (1 = Tek Yön, 2 = Gidiş-Dönüş): ");
        tripType = input.nextInt();

        double kmBasiUcret = 0.10;
        double normalFiyat = distance * kmBasiUcret;
        double indirimliFiyat = normalFiyat;
        double yasIndirimi = 0;
        double yolculukIndirimi = 0;
        double toplamTutar = 0;

        if (distance <= 0 || age < 0 || (tripType != 1 && tripType != 2) ) {
            System.out.print("Hatalı Veri Girdiniz!");
        } else {
            if (age < 12) {
                yasIndirimi = normalFiyat * 0.50; // %50 İndirimli.
            } else if ( age >= 12 || age <= 24) {
                yasIndirimi = normalFiyat * 0.10; // %10 İndirimli.
            } else if (age >= 65) {
                yasIndirimi = normalFiyat * 0.30; // %30 İndirimli.
            }
        }

        indirimliFiyat = normalFiyat - yasIndirimi;

        if (tripType == 2) {
            yolculukIndirimi = indirimliFiyat * 0.20;
            indirimliFiyat -= yolculukIndirimi;
        }

        toplamTutar = tripType == 1 ? indirimliFiyat : indirimliFiyat * 2;

        System.out.println("Toplam Tutar = " + toplamTutar + " TL");
    }
}
