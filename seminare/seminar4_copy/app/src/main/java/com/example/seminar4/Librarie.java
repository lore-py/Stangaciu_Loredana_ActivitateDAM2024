package com.example.seminar4;

import android.os.Parcel;
import android.os.Parcelable;

public class Librarie implements Parcelable {
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
    protected Librarie(Parcel in) {
        numeCarte = in.readString();
        inStoc = in.readByte() != 0;
        isbn = in.readString();
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

    public String getNumeCarte() {
        return numeCarte;
    }

    public boolean isInStoc() {
        return inStoc;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNrBucati() {
        return nrBucati;
    }

    public float getPret() {
        return pret;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(numeCarte);
        dest.writeByte((byte) (inStoc ? 1 : 0));
        dest.writeString(isbn);
        dest.writeInt(nrBucati);
        dest.writeFloat(pret);
    }

    @Override
    public String toString() {
        return "Librarie{" +
                "numeCarte='" + numeCarte + '\'' +
                ", inStoc=" + inStoc +
                ", isbn='" + isbn + '\'' +
                ", nrBucati=" + nrBucati +
                ", pret=" + pret +
                '}';
    }
}
