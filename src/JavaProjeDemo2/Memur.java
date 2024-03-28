package JavaProjeDemo2;

class Memur extends Personel {
    private int derece;

    public Memur(String name, String surname, int derece) {
        super(name, surname);
        this.derece = derece;
    }

    @Override
    public double maasHesapla(double calismaSaati) {
        double saatlikUcret = 500;
        double maas = saatlikUcret * calismaSaati;
        if (calismaSaati > 180) {
            maas += (calismaSaati - 180) * 1.5 * saatlikUcret;
        }
        return maas;
    }
}
