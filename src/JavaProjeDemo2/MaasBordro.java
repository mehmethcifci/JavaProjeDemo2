package JavaProjeDemo2;

import java.io.*;
import java.util.*;

class MaasBordro {
    public List<Personel> generatePayroll(List<Personel> personelList, String monthYear) {
        List<Personel> azCalisanlar = new ArrayList<>();
        for (Personel personel : personelList) {
            double calismaSaati = 200; // Assuming default working hours for all employees
            double maas = personel.maasHesapla(calismaSaati);
            String fileName = personel.name + "_" + personel.surname + "_maas_" + monthYear + ".json";
            try {
                FileWriter fileWriter = new FileWriter(fileName);
                BufferedWriter writer = new BufferedWriter(fileWriter);
                writer.write("{\n");
                writer.write("  \"bordro\": \"" + monthYear + "\",\n");
                writer.write("  \"personel\": {\n");
                writer.write("    \"ismi\": \"" + personel.name + " " + personel.surname + "\",\n");
                writer.write("    \"calismaSaati\": " + calismaSaati + ",\n");
                writer.write("    \"odemeDetaylari\": {\n");
                writer.write("      \"anaOdeme\": \"₺" + String.format("%.2f", maas) + "\",\n");
                writer.write("      \"toplamOdeme\": \"₺" + String.format("%.2f", maas) + "\"\n");
                writer.write("    }\n");
                writer.write("  }\n");
                writer.write("}\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (calismaSaati < 150) {
                azCalisanlar.add(personel);
            }
        }
        return azCalisanlar;
    }

    public void printSummary(List<Personel> azCalisanlar) {
        for (Personel personel : azCalisanlar) {
            System.out.println(personel.name + " " + personel.surname + " az çalıştı.");
        }
    }
}
