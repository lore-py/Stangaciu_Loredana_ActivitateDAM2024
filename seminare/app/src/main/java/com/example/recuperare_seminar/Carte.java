package com.example.recuperare_seminar;

import android.os.Parcel;
import android.os.Parcelable;

public class Carte implements Parcelable {
    private String titlu;
    private String autor;
    private int an;

    public Carte(String titlu, String autor, int an) {
        this.titlu = titlu;
        this.autor = autor;
        this.an = an;
    }

    protected Carte(Parcel in) {
        titlu = in.readString();
        autor = in.readString();
        an = in.readInt();
    }

    public static final Creator<Carte> CREATOR = new Creator<Carte>() {
        @Override
        public Carte createFromParcel(Parcel in) {
            return new Carte(in);
        }

        @Override
        public Carte[] newArray(int size) {
            return new Carte[size];
        }
    };

    public String getTitlu() {
        return titlu;
    }

    public String getAutor() {
        return autor;
    }

    public int getAn() {
        return an;
    }

    @Override
    public String toString() {
        return titlu + " - " + autor + " (" + an + ")";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(titlu);
        parcel.writeString(autor);
        parcel.writeInt(an);
    }
}
