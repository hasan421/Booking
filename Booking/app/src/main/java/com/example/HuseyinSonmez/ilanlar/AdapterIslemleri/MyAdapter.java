package com.example.HuseyinSonmez.ilanlar.AdapterIslemleri;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.HuseyinSonmez.R;
import com.example.HuseyinSonmez.ilanlar.Ilanlar;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private ArrayList<Ilanlar> ilanList;
    private Activity context;
    private int layout;


    public MyAdapter(Activity context, int layout, ArrayList<Ilanlar> ilanList) {
        this.layout = layout;
        this.context = context;
        this.ilanList = ilanList;
    }

    @Override
    public int getCount() {
        return ilanList.size();
    }

    @Override
    public Ilanlar getItem(int position) {
        return ilanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    myAdapterViews views = new myAdapterViews();

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View layout;
        layout = inflater.inflate(this.layout, null);

        views.baslik = layout.findViewById(R.id.baslikTv);
        views.il = layout.findViewById(R.id.sehirTv);
        views.kira = layout.findViewById(R.id.ucretTv);
        views.img = layout.findViewById(R.id.ResimImg);
        views.tip = layout.findViewById(R.id.tipTv);
        views.kat = layout.findViewById(R.id.katTv);
        views.ilce = layout.findViewById(R.id.ilceTv);
        layout.setTag(views);

        views = (myAdapterViews) layout.getTag();

        setDataViev(position);
        return layout;

    }


    public void setDataViev(int position) {
        views.baslik.setText(ilanList.get(position).getBaslik());
        views.il.setText(ilanList.get(position).getIl());
        setImageResource(views, ilanList.get(position));
        views.tip.setText(ilanList.get(position).getTip());
        views.kira.setText(ilanList.get(position).getKira());
        views.kat.setText(ilanList.get(position).getKat());
        views.ilce.setText(ilanList.get(position).getIlce());
    }

    private void setImageResource(myAdapterViews views, Ilanlar ilan) {
        byte[] byteResource = ilan.getResim();
        Bitmap imgBitmap = BitmapFactory.decodeByteArray(byteResource, 0, byteResource.length);
        views.img.setImageBitmap(imgBitmap);

    }

}
