package com.toprek.stodakuham;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.toprek.stodakuham.databinding.ActivityPetBinding;

import java.util.ArrayList;
import java.util.List;

public class Rezultat5 extends AppCompatActivity
{
    ActivityPetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tri);

        binding = ActivityPetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Recept> receptArrayList = new ArrayList<>();
        receptArrayList.add(Izbornik.recepti[Izbornik.random[0]]);
        receptArrayList.add(Izbornik.recepti[Izbornik.random[1]]);
        receptArrayList.add(Izbornik.recepti[Izbornik.random[2]]);
        receptArrayList.add(Izbornik.recepti[Izbornik.random[3]]);
        receptArrayList.add(Izbornik.recepti[Izbornik.random[4]]);

        ListAdapter listAdapter = new ListAdapter(Rezultat5.this, receptArrayList);

        binding.ListView.setAdapter(listAdapter);
        binding.ListView.setClickable(true);
        binding.ListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(Rezultat5.this,Prikaz.class);
                intent.putExtra("ime",Izbornik.recepti[Izbornik.random[position]].ime);
                intent.putExtra("opis",Izbornik.recepti[Izbornik.random[position]].opis);
                intent.putExtra("slika",Izbornik.recepti[Izbornik.random[position]].slika);
                intent.putExtra("zahtjevnost",Izbornik.recepti[Izbornik.random[position]].zahtjevnost);
                intent.putExtra("recept",Izbornik.recepti[Izbornik.random[position]].recept);

                startActivity(intent);
            }
        });
    }
}