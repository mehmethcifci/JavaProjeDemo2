package JavaProjeDemo2;

public abstract class Personel {
	protected String name;
    protected String surname;

    public Personel(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public abstract double maasHesapla(double calismaSaati);
	
}
