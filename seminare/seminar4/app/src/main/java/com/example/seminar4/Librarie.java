package com.example.seminar4;

public class Librarie {
    private String numeCarte;
    private boolean inStoc;
    private String isbn;
    private int nrBucati;
    private float pret;

    public Librarie(String numeCarte, boolean inStoc, String isbn, int nrBucati, float pret) {
        this.numeCarte = numeCarte;
        this.inStoc = inStoc;
        this.isbn = isbn;
        this.nrBucati = nrBucati;
        this.pret = pret;
    }

    public String getNumeCarte() {
        return numeCarte;
    }

    public void setNumeCarte(String numeCarte) {
        this.numeCarte = numeCarte;
    }

    public boolean isInStoc() {
        return inStoc;
    }

    public void setInStoc(boolean inStoc) {
        this.inStoc = inStoc;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNrBucati() {
        return nrBucati;
    }

    public void setNrBucati(int nrBucati) {
        this.nrBucati = nrBucati;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Librarie{");
        sb.append("numeCarte='").append(numeCarte).append('\'');
        sb.append(", inStoc=").append(inStoc);
        sb.append(", isbn='").append(isbn).append('\'');
        sb.append(", nrBucati=").append(nrBucati);
        sb.append(", pret=").append(pret);
        sb.append('}');
        return sb.toString();
    }
}
