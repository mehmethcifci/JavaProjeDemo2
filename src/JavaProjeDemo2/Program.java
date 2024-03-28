package JavaProjeDemo2;

import java.util.List;

public class Program {
    public static void main(String[] args) {
    	DosyaOku dosyaOku = new DosyaOku();
    	List<Personel> personelList = dosyaOku.readPersonelFromJSON("C:\\Users\\mehme\\eclipse-workspace\\JavaProjeDemo2\\src\\personel.json");

        MaasBordro maasBordro = new MaasBordro();
        String monthYear = "SUBAT 2020"; // Bordro ayý ve yýlý
        List<Personel> azCalisanlar = maasBordro.generatePayroll(personelList, monthYear);

        System.out.println("Maaþ bordrosu oluþturuldu ve kaydedildi.");
        System.out.println("Az çalýþanlar:");
        maasBordro.printSummary(azCalisanlar);
    }
}