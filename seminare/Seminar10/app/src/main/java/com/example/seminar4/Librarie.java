package com.example.seminar4;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "librarie")
public class Librarie implements Parcelable {
    @PrimaryKey
    private String isbn; // Cheia primară a tabelului

    private String numeCarte;
    private boolean inStoc;
    private int nrBucati;
    private float pret;

    public Librarie(String isbn, String numeCarte, boolean inStoc, int nrBucati, float pret) {
        this.isbn = isbn;
        this.numeCarte = numeCarte;
        this.inStoc = inStoc;
        this.nrBucati = nrBucati;
        this.pret = pret;
    }

    protected Librarie(Parcel in) {
        isbn = in.readString();
        numeCarte = in.readString();
        inStoc = in.readByte() != 0;
        nrBucati = in.readInt();
        pret = in.readFloat();
    }

    public static final Creator<Librarie> CREATOR = new Creator<Librarie>() {
        @Override
        public Librarie createFromParcel(Parcel in) {
            return new Librarie(in);
        }

        @Override
        public Librarie[] newArray(int size) {
            return new Librarie[size];
        }
    };

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(isbn);
        dest.writeString(numeCarte);
        dest.writeByte((byte) (inStoc ? 1 : 0));
        dest.writeInt(nrBucati);
        dest.writeFloat(pret);
    }

    @Override
    public String toString() {
        return "Librarie{" +
                "isbn='" + isbn + '\'' +
                ", numeCarte='" + numeCarte + '\'' +
                ", inStoc=" + inStoc +
                ", nrBucati=" + nrBucati +
                ", pret=" + pret +
                '}';
    }
}
