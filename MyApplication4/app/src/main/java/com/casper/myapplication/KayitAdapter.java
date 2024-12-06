package com.casper.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KayitAdapter extends RecyclerView.Adapter<KayitAdapter.KayitTutucu> {
    private Context context;
    private ArrayList<OrnekKayit> ornekList;

    public KayitAdapter(Context context, ArrayList<OrnekKayit> ornekList) {
        this.context = context;
        this.ornekList = ornekList;
    }

    @NonNull
    @Override
    public KayitTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rv_satir_gorunumu,parent,false);
        return  new KayitTutucu(view);

    }

    @Override
    public void onBindViewHolder(@NonNull KayitTutucu holder, int position) {
         OrnekKayit ornekKayit=ornekList.get(position);

         String id=ornekKayit.getId();
        String ad=ornekKayit.getAd();
        String soyad=ornekKayit.getSoyad();
        String telefon=ornekKayit.getTelefon();
        String mail=ornekKayit.getMail();
        String cinsiyet=ornekKayit.getCinsiyet();
        String parola=ornekKayit.getParola();

        holder.tv_ad.setText(ad);
        holder.tv_Soyad.setText(ad);
        holder.tv_Telefon.setText(ad);
        holder.tv_Email.setText(ad);
        holder.tv_Cinsiyet.setText(ad);
        holder.tv_Parola.setText(ad);







    }

    @Override
    public int getItemCount() {
        return ornekList.size();
    }

    public class KayitTutucu extends RecyclerView.ViewHolder {
        TextView tv_ad,tv_Soyad,tv_Telefon,tv_Email,tv_Cinsiyet,tv_Parola;

        public KayitTutucu(@NonNull View itemView) {
            super(itemView);

            tv_ad=itemView.findViewById(R.id.tv_ad);
            tv_ad=itemView.findViewById(R.id.tv_Soyad);
            tv_ad=itemView.findViewById(R.id.tv_Telefon);
            tv_ad=itemView.findViewById(R.id.tv_Email);
            tv_ad=itemView.findViewById(R.id.tv_Cinsiyet);
            tv_ad=itemView.findViewById(R.id.tv_Parola);





        }
    }
}
