package com.toprek.stodakuham;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

public class Rezultat1 extends AppCompatActivity
{
    TextView Ime;
    TextView Opis;
    TextView Recept;
    TextView Zahtjevnost;
    ImageView Slika;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jedan);

        Ime = findViewById(R.id.Ime);
        Recept = findViewById(R.id.Recept);
        Slika = findViewById(R.id.Slika);
        Opis = findViewById(R.id.Opis);
        Zahtjevnost = findViewById(R.id.Zahtjevnost);

        Ime.setText(Izbornik.recepti[Izbornik.random[0]].ime);
        Slika.setImageResource(Izbornik.recepti[Izbornik.random[0]].slika);
        Opis.setText(Izbornik.recepti[Izbornik.random[0]].opis);

        if (Izbornik.recepti[Izbornik.random[0]].zahtjevnost == Boolean.TRUE)
        {
            Zahtjevnost.setText("Zahtjevno");
            Zahtjevnost.setTextColor(getResources().getColor(R.color.Red));
            Zahtjevnost.setBackgroundColor(getResources().getColor(R.color.CoolGreen));
        }
        else
        {
            Zahtjevnost.setText("Nezahtjevno");
        }

        Recept.setText(Izbornik.recepti[Izbornik.random[0]].recept);
        Recept.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
