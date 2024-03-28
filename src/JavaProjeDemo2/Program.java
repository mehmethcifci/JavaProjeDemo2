package JavaProjeDemo2;

import java.util.List;

public class Program {
    public static void main(String[] args) {
    	DosyaOku dosyaOku = new DosyaOku();
    	List<Personel> personelList = dosyaOku.readPersonelFromJSON("C:\\Users\\mehme\\eclipse-workspace\\JavaProjeDemo2\\src\\personel.json");

        MaasBordro maasBordro = new MaasBordro();
        String monthYear = "SUBAT 2020"; // Bordro ay� ve y�l�
        List<Personel> azCalisanlar = maasBordro.generatePayroll(personelList, monthYear);

        System.out.println("Maa� bordrosu olu�turuldu ve kaydedildi.");
        System.out.println("Az �al��anlar:");
        maasBordro.printSummary(azCalisanlar);
    }
}