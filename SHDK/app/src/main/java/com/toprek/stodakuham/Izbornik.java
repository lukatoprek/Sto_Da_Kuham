package com.toprek.stodakuham;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import java.util.Random;
import java.util.RandomAccess;

public class Izbornik extends AppCompatActivity
{
    RadioButton rb1,rb3,rb5,sva,nezaht,zaht;

    Spinner spinner_kategorija;
    Button stokuham;
    public static int[] random = new int[5];
    public static Recept[] recepti= new Recept[30];

    public void widgetInit()
    {
        sva = findViewById(R.id.rb_Obje);
        nezaht = findViewById(R.id.rb_Nezahtjevno);
        zaht = findViewById(R.id.rb_Zahtjevno);
        rb1 = findViewById(R.id.rb_1);
        rb3 = findViewById(R.id.rb_3);
        rb5 = findViewById(R.id.rb_5);
        spinner_kategorija = (Spinner) findViewById(R.id._kategorija);
    }
    public void brojrecepatachecker()
    {
            if (rb1.isChecked()) {
                Intent intent1 = new Intent(this, Rezultat1.class);
                startActivity(intent1);
            } else if (rb3.isChecked()) {
                Intent intent2 = new Intent(this, Rezultat3.class);
                startActivity(intent2);
            } else if (rb5.isChecked()) {
                Intent intent3 = new Intent(this, Rezultat5.class);
                startActivity(intent3);
            }
    }

    public void KuhatCu()
    {
        widgetInit();

        if(rb1.isChecked()==false && rb3.isChecked()==false && rb5.isChecked()==false)
        {
            Toast.makeText(getApplicationContext(),"Označite broj recepata",Toast.LENGTH_SHORT).show();
        }
        if(zaht.isChecked()==false &&nezaht.isChecked()==false && sva.isChecked()==false)
        {
            Toast.makeText(getApplicationContext(),"Označite zahtjevnost recepata",Toast.LENGTH_SHORT).show();
        }

        if(sva.isChecked())
        {
            random = RandomNumberGenerator.generirajsva(spinner_kategorija.getSelectedItem().toString());
            brojrecepatachecker();
        }
        else if(nezaht.isChecked())
        {
            random = RandomNumberGenerator.generirajnezaht(spinner_kategorija.getSelectedItem().toString());
            brojrecepatachecker();
        }
        else if(zaht.isChecked())
        {
            random = RandomNumberGenerator.generirajzaht(spinner_kategorija.getSelectedItem().toString());
            brojrecepatachecker();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izbornik);

        Recept pica = new Recept("Pica","Talijansko jelo koje se sastoji od tankog tijesta premazanog kečapom/umakom od rajčice povrh kojeg idu razni dodatci (salama, sir, gljive)...",false,R.string.pica,R.mipmap.pica,"Tjestenina");
        recepti[0] = pica;

        Recept sarma = new Recept("Sarma","Sarma je jelo od miješanog mljevenog ili sjeckanog mesa i najčešće riže umotanih u list ukiseljena kupusa ili vinove loze, porijeklom iz Turske...",true,R.string.sarma,R.mipmap.sarma,"Varivo");
        recepti[1] = sarma;

        Recept sataras = new Recept( "Sataraš","Sataraš je kuhano jelo od povrća, najčešće paprike, rajčice i luka te riže. Porijeklom je iz Baranje.",false,R.string.sataras,R.mipmap.sataras,"Varivo");
        recepti[2] = sataras;

        Recept cobanovapita = new Recept("Čobanova Pita","Čobanova Pita je slano jelo pečeno u pećnici a načinjeno od mljevenog mesa prelivenog pire krumpirom, porijeklom iz Engleske...",false,R.string.cobanovapita,R.mipmap.cobanovapita,"Meso");
        recepti[3] = cobanovapita;

        Recept pesto = new Recept("Tjestenina u pesto umaku","Pesto je talijanski umak od orašastih plodova (tradicionalno pinjoli), češnjaka, maslinovog ulja, bosiljka i sira. Pesto se najčešće konzumira uz tjesteninu..",true,R.string.pesto,R.mipmap.pesto,"Tjestenina");
        recepti[4] = pesto;

        Recept tortilje = new Recept("Meksičke tortilje","Meksičke tortilje prepržene na tavi s nadjevom od piletine, paprike, graha, luka i pelata rajčice te bijelim umakom...",false,R.string.tortilje,R.mipmap.tortilje,"Meso");
        recepti[5] = tortilje;

        Recept kiflicescokoladom = new Recept("Kiflice s čokoladom","Kiflice od lisnatog tijesta punjene čokoladnim namazom, porijeklom iz centralne Europe...",false,R.string.kiflicescokoladom,R.mipmap.kiflicescokoladom,"Deserti");
        recepti[6] = kiflicescokoladom;

        Recept krembrule = new Recept("Crema catalana","Crema catalana (Cremee brulee) katalonska je kremasta slastica koja se sastoji od kreme (žumanjak, vrhnje, šećer) i karamelizirane korice na vrhu...",true,R.string.krembrule,R.mipmap.krembrule,"Deserti");
        recepti[7] = krembrule;

        Recept cezarsalata = new Recept("Cezar salata","Cezar salata je salata od zelene salate, bijelog mesa i krutona s dresingom od senfa majoneze, maslinova ulja i limuna. Ova hladna salata porijeklom je iz Meksika...",false,R.string.cezarsalata,R.mipmap.cezarsalata,"Salate");
        recepti[8] = cezarsalata;

        Recept losossalata = new Recept("Salata s lososom","Svježe kuhani odresci lososa pomiješani sa zelenom salatom, krastavcima i kuhanim jajima te preliveni umakom od slatkog vrhnja uz dodatak kopra...",true,R.string.losossalata,R.mipmap.losossalata,"Salate");
        recepti[9] = losossalata;

        Recept burek = new Recept("Burek","Burek je jelo od razvučenog tijesta s mesom porijeklom iz Turske, a rašireno je na području nekadašnjeg Osmanskog Carstva...",true,R.string.burek,R.mipmap.burek,"Tjestenina");
        recepti[10] = burek;

        Recept fis = new Recept("Fiš","Fiš je tradicionalni panonski paprikaš od riječne ribe (najčešće šaran, som ili štuka), porijeklom iz Baranje...",true,R.string.fis,R.mipmap.fis,"Ostalo");
        recepti[11] = fis;

        Recept rizoto = new Recept("Rižoto od piletine","Rižoto je talijansko jelo načinjeno od riže i priloga, najčešće graška, mrkve i piletine. Porijeklom je iz Sjeverne Italije...",false,R.string.rizoto,R.mipmap.rizoto,"Ostalo");
        recepti[12] = rizoto;

        Recept becki = new Recept("Bečki odrezak","Bečki odrezak (Wienerschnitzel) je pohani teleći odrezak, najčešće poslužen uz pire krumpir ili pomfrit. Porijeklom je iz Austrije (Beča)...",true,R.string.becki,R.mipmap.becki,"Meso");
        recepti[13] = becki;

        Recept punjenepaprike = new Recept("Punjena paprika","Punjena paprika jelo je od paprike, punjeno mješavinom mesa i riže u umaku od rajčice, tradicionalno je jelo mnogih kuhinja Jugoistočne Europe...",true,R.string.punjenepaprike,R.mipmap.punjenepaprike,"Varivo");
        recepti[14] = punjenepaprike;

        Recept sutlijas = new Recept("Sutlijaš","Sutlijaš je kremasto slatko jelo od riže i mlijeka, najrasprostranjenije na području Balkana i Turske.",true,R.string.sutlijas,R.mipmap.sutlijas,"Deserti");
        recepti[15] = sutlijas;

        Recept krempita = new Recept("Krempita","Krempita (njem. Cremeschnitte) je vrsta prhkog kolača od lisnatog tijesta s filom od jaja i vanilije. Porijeklom je iz Njemačke.",true,R.string.krempita,R.mipmap.krempita,"Deserti");
        recepti[16] = krempita;

        Recept knedlesasljivama = new Recept("Knedle sa šljivama","Knedle sa šljivama su slatko jelo porijeklom iz Njemačke, a prave se od otkoštenih šljiva umotanih tijesto od pire krumpira. ",true,R.string.knedlesasljivama,R.mipmap.knedlesasljivama,"Deserti");
        recepti[17] = knedlesasljivama;

        Recept kelj = new Recept("Kelj s faširkama","Kelj je hranjivo varivo najrasprostranjenije u kuhinjama Zapadnog Balkana. Uz kelj gotovo uvijek dolaze mesni zalogajčići: faširke.",true,R.string.kelj,R.mipmap.keljifasirke,"Varivo");
        recepti[18] = kelj;

        Recept grah = new Recept("Grah na varivo","Grah je popularno varivo balkanskih kuhinja, često pripremano u hladne zimske dane. U grah se često stavljaju proteini kao što su slanina i jeger (kobasica).",true,R.string.grah,R.mipmap.grah,"Varivo");
        recepti[19] = grah;

        Recept krmenadleuvinu = new Recept("Krmenadle u vinu","Sočne krmenadle iz pećnice, prekrivene kajmakom i pripremljene u vinu.",false,R.string.krmenadleuvinu,R.mipmap.krmenadleuvinu,"Meso");
        recepti[20] = krmenadleuvinu;

        Recept mesnarolada = new Recept("Mesna rolada","Mesna rolada mesna je štruca od mljevenog mesa i prekrivena punjenjem po želji. Ime dobija po karakterističnom rolanju čiji je rezultat prekrasna u ukusna mesna rolada.",false,R.string.mesnarolada,R.mipmap.mesnarolada,"Meso");
        recepti[21] = mesnarolada;

        Recept carbonara = new Recept("Carbonara","Carbonara je talijansko jelo od jaja, tvrdog sira, slanine, bibera te špageta ili špagetona. Porijeklom je iz regije Lazio.",true,R.string.carbonara,R.mipmap.carbonara,"Tjestenina");
        recepti[22] = carbonara;

        Recept bolognese = new Recept("Bolognese","Bolognese je talijansko jelo od tjestenine (špageta ili špagetona) te umaka od mesa po kojem je jelo i dobilo naziv: 'bolognese'. Iako je umak iz Bologne (Sjeverna Italija), ova varijacija jela nastala je u inozemstvu od strane doseljenika iz Južne Italije.",true,R.string.bolognese,R.mipmap.bolognese,"Tjestenina");
        recepti[23] = bolognese;

        Recept musaka = new Recept("Musaka","Musaka (grč. moussakas) je tradicionalno grčko jelo napravljeno od krumpira, mljevenog mesa i jaja. Pretežito se priprema na Balkanu i na Bliskom istoku.",false,R.string.musaka,R.mipmap.musaka,"Ostalo");
        recepti[24] = musaka;

        Recept proja = new Recept("Proja","Proja je tradicionalno srpsko predjelo, kukuruzni kruh koji se pravi od krupno mljevenog kukuruznog brašna, soli i vode, a najčešće se pravi punjena sirom ili jogurtom.",false,R.string.proja,R.mipmap.proja,"Ostalo");
        recepti[25] = proja;

        Recept popara = new Recept("Popara","Popara je seljačko jelo od starog kruha natopljenog u mlijeku ili vodi koji se nakon toga kuha u loncu dok ne dobije kremastu, no idalje grizivu teksturu. Popularno je u zemljama Zapadnog Balkana te Turskoj.",false,R.string.popara,R.mipmap.popara,"Ostalo");
        recepti[26] = popara;

        Recept tunasalata = new Recept("Salata od tunjevine","Salata od tunjevine je hranjiva i lagana, hladna salata koja može služiti kao doručak, ručak ili večera. Postoji nekoliko skupova sastojaka i načina pripreme.",false,R.string.tunasalata,R.mipmap.tunasalata,"Salate");
        recepti[27] = tunasalata;

        Recept piletinasalata = new Recept("Salata s piletinom","Hranjiva salata od piletine, luka, tikvice i grčkog jogurta. Puna je proteina te se može poslužiti i kao glavno jelo.",false,R.string.piletinasalata,R.mipmap.piletinasalata,"Salate");
        recepti[28] = piletinasalata;

        Recept sopska = new Recept("Šopska salata","Šopska salata je tradicionalna bugarska miješana salata na temelju rajčice, luka, krastavca, paprike i feta sira. Porijeklom je iz okolice Sofije te se najčešće poslužuje uz mesnata glavna jela.",false,R.string.sopska,R.mipmap.sopska,"Salate");
        recepti[29] = sopska;

        spinner_kategorija = (Spinner) findViewById(R.id._kategorija);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.kategorije, R.layout.selected_item_kategorije);
        adapter.setDropDownViewResource(R.layout.dropdown_item_kategorije);
        spinner_kategorija.setAdapter(adapter);

        stokuham = findViewById(R.id.stokuhambutton);
        stokuham.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                KuhatCu();
            }
        });
    }
    //TODO Poboljšati UI dizajn
}

