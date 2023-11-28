package hr.java.production.enumerator;

public enum Gradovi {
    ZAGREB("Zagreb","10000"),
    SESVETE("Sesvete","10360"),
    IVANIC_GRAD("Ivanic-Grad","1310"), UNKNOWN("?","?" );

    private String ime,postanskiBroj;
    Gradovi(String ime,String postanskiBroj) {
    this.ime = ime;
    this.postanskiBroj = postanskiBroj;
    }

    public String getIme() {
        return ime;
    }

    public String getPostanskiBroj() {
        return postanskiBroj;
    }
}
