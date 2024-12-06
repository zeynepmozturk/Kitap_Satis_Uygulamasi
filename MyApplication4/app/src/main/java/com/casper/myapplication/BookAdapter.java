package com.casper.myapplication;

import static android.widget.Toast.*;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<Book> {
    private Context context;
    private ArrayList<Book> books;

    public BookAdapter(Context context, ArrayList<Book> books) {
        super(context, 0, books);
        this.context = context;
        this.books = books;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Book book = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
        }

        TextView kitapAdiTextView = convertView.findViewById(R.id.kitapAdi);
        TextView kitapFiyatiTextView = convertView.findViewById(R.id.kitapFiyati);
        Button silButton = convertView.findViewById(R.id.silButton);
        ImageView favButton = convertView.findViewById(R.id.favButton);

        kitapAdiTextView.setText(book.getKitapAdi());
        kitapFiyatiTextView.setText(book.getFiyat() + " TL");

        // Sil butonuna tıklama işlemi
        silButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                books.remove(position);
                notifyDataSetChanged();
                makeText(context, "Seçilen ürün silindi", LENGTH_SHORT).show();
                // Burada toplam fiyatı güncelleyebiliriz
                ((sepetSayfasi) context).guncelleToplamFiyat();
            }
        });

        // Favori butonuna tıklama işlemi
        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                book.setFavori(!book.isFavori());
                favButton.setImageResource(book.isFavori() ? R.drawable.kalp : R.drawable.kalp);
                makeText(context,"ürün favorilere eklendi",LENGTH_SHORT).show();


            }
        });

        favButton.setImageResource(book.isFavori() ? R.drawable.kalp : R.drawable.kalp);

        return convertView;
    }

}
