package com.example.seminar9;

import android.graphics.Bitmap;

public class ImagineDomeniu {
    private Bitmap imagine;
    private String testAfisat;
    private String link;

    public ImagineDomeniu(Bitmap imagine, String testAfisat, String link) {
        this.imagine = imagine;
        this.testAfisat = testAfisat;
        this.link = link;
    }

    public Bitmap getImagine() {
        return imagine;
    }

    public String getTestAfisat() {
        return testAfisat;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "ImagineDomeniu{" +
                "imagine='" + imagine + '\'' +
                ", testAfisat='" + testAfisat + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}

