package com.example.seminar9_actual;

public class Situatie {
    private String disciplina;
    private String activitate;
    private float valoare;
    private String data;
    private String descriere;

    public Situatie(String disciplina, String activitate, float valoare, String data, String descriere) {
        this.disciplina = disciplina;
        this.activitate = activitate;
        this.valoare = valoare;
        this.data = data;
        this.descriere = descriere;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getActivitate() {
        return activitate;
    }

    public void setActivitate(String activitate) {
        this.activitate = activitate;
    }

    public float getValoare() {
        return valoare;
    }

    public void setValoare(float valoare) {
        this.valoare = valoare;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        return "Situatie{" +
                "disciplina='" + disciplina + '\'' +
                ", activitate='" + activitate + '\'' +
                ", valoare=" + valoare +
                ", data='" + data + '\'' +
                ", descriere='" + descriere + '\'' +
                '}';
    }
}
