package JavaProjeDemo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

class DosyaOku {
    public List<Personel> readPersonelFromJSON(String dosyaYolu) {
        List<Personel> personelList = new ArrayList<>();
        try {
            File dosya = new File(dosyaYolu);
            FileInputStream fileInputStream = new FileInputStream(dosya);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String json = "";
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                json += line;
            }
            bufferedReader.close();

            // JSON parsing and creating Personel objects
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String name = obj.getString("name");
                String surname = obj.getString("surname");
                String role = obj.getString("role");
                if (role.equals("Yonetici")) {
                    personelList.add(new Yonetici(name, surname, 1000)); // Assuming bonus is 1000 for all managers
                } else if (role.equals("Memur")) {
                    personelList.add(new Memur(name, surname, 1)); // Assuming default degree is 1 for all clerks
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personelList;
    }
}