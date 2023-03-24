package com.toprek.stodakuham;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;

import androidx.appcompat.app.AppCompatActivity;

import com.toprek.stodakuham.databinding.ActivityPrikazBinding;

import java.io.Serializable;

public class Prikaz extends AppCompatActivity
{
    ActivityPrikazBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityPrikazBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if(intent != null)
        {
            String ime = intent.getStringExtra("ime");
            String opis = intent.getStringExtra("opis");
            int slika = intent.getIntExtra("slika",R.mipmap.logo);
            Boolean zahtjevnost = intent.getBooleanExtra("zahtjevnost",false);
            int recept = intent.getIntExtra("recept",R.string.pica);

            binding.Ime.setText(ime);
            binding.Opis.setText(opis);
            binding.Slika.setImageResource(slika);
            binding.Recept.setText(recept);
            binding.Recept.setMovementMethod(LinkMovementMethod.getInstance());

            if (zahtjevnost == Boolean.TRUE)
            {
                binding.Zahtjevnost.setText("Zahtjevno");
                binding.Zahtjevnost.setTextColor(getResources().getColor(R.color.Red));
                binding.Zahtjevnost.setBackgroundColor(getResources().getColor(R.color.CoolGreen));
            }
            else
            {
                binding.Zahtjevnost.setText("Nezahtjevno");
            }
        }
    }
}
