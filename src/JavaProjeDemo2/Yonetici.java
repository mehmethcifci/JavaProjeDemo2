package JavaProjeDemo2;

class Yonetici extends Personel {
    private double bonus;

    public Yonetici(String name, String surname, double bonus) {
        super(name, surname);
        this.bonus = bonus;
    }

    @Override
    public double maasHesapla(double calismaSaati) {
        double saatlikUcret = 500;
        double maas = Math.max(saatlikUcret * calismaSaati, 500 * calismaSaati + bonus);
        return maas;
    }
}
