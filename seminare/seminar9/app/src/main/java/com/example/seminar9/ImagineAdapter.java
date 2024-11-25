package com.example.seminar9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImagineDomeniuAdapter extends BaseAdapter {

    private final Context context;
    private final List<ImagineDomeniu> listaImagini;
    private final int layoutResursa;

    public ImagineDomeniuAdapter(Context context, int layoutResursa, List<ImagineDomeniu> listaImagini) {
        this.context = context;
        this.listaImagini = listaImagini;
        this.layoutResursa = layoutResursa;
    }

    @Override
    public int getCount() {
        return listaImagini.size();
    }

    @Override
    public Object getItem(int position) {
        return listaImagini.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(layoutResursa, parent, false);
        }

        ImagineDomeniu imagine = listaImagini.get(position);

        ImageView imageView = convertView.findViewById(R.id.imagine);
        TextView textView = convertView.findViewById(R.id.descriere);

        Glide.with(context).load(imagine.getImagine()).into(imageView);
        textView.setText(imagine.getTestAfisat());

        return convertView;
    }
}
