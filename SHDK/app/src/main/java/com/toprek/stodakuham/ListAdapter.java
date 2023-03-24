package com.toprek.stodakuham;

import android.content.Context;
import android.media.Image;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Recept>
{
    public ListAdapter(Context context, ArrayList<Recept> receptArrayList)
    {
        super(context,R.layout.list_item,receptArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Recept recept = getItem(position);

        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        ImageView slika = convertView.findViewById(R.id.slika);
        TextView ime_jela = convertView.findViewById(R.id.ime_jela);
        TextView opis = convertView.findViewById(R.id.opis);

        slika.setImageResource(recept.slika);
        ime_jela.setText(recept.ime);
        opis.setText(recept.opis);

        return convertView;
    }
}
