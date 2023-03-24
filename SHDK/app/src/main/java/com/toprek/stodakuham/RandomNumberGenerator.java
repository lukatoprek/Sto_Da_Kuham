package com.toprek.stodakuham;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator
{
    public static int[] RANDOM = new int[5];
    public static int[] generirajsva(String kategorija)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(kategorija.compareTo("Sve")==0)
        {
            for (int i=0; i<Izbornik.recepti.length; i++)
            {
                list.add(i);
            }
        }
        else
        {
        for (int i=0; i<Izbornik.recepti.length; i++)
            {
                if(Izbornik.recepti[i].kategorija.compareTo(kategorija)==0)
                {
                list.add(i);
                }
            }
        }
        Collections.shuffle(list);
        for(int i=0;i<RANDOM.length;i++)
        {
            if(list.size() < 5)
            {
                RANDOM[i] = list.get(0);
            }
            else
            {
                RANDOM[i] = list.get(i);
            }
        }
        return RANDOM;
    }

    public static int[] generirajnezaht(String kategorija)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(kategorija.compareTo("Sve")==0)
        {
            for(int i=0;i<Izbornik.recepti.length;i++)
            {
                if(Izbornik.recepti[i].zahtjevnost==false)
                {
                    list.add(i);
                }
            }
        }
        else
        {
            for(int i=0;i<Izbornik.recepti.length;i++)
            {
                if(Izbornik.recepti[i].zahtjevnost==false)
                {
                    if(Izbornik.recepti[i].kategorija.compareTo(kategorija)==0)
                    {
                        list.add(i);
                    }
                }
            }
        }
        Collections.shuffle(list);
        for(int i=0;i<RANDOM.length;i++)
        {
            if(list.size() < 5)
            {
                RANDOM[i] = list.get(0);
            }else
            {
                RANDOM[i] = list.get(i);
            }

        }
        return RANDOM;
    }

    public static int[] generirajzaht(String kategorija)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(kategorija.compareTo("Sve")==0)
        {
            for(int i=0;i<Izbornik.recepti.length;i++)
            {
                if(Izbornik.recepti[i].zahtjevnost==true)
                {
                    list.add(i);
                }
            }
        }
        else
        {
            for(int i=0;i<Izbornik.recepti.length;i++)
            {
                if(Izbornik.recepti[i].zahtjevnost==true)
                {
                    if(Izbornik.recepti[i].kategorija.compareTo(kategorija)==0)
                    {
                        list.add(i);
                    }
                }
            }
        }
        Collections.shuffle(list);
        for(int i=0;i<RANDOM.length;i++)
        {
            if(list.size() < 5)
            {
                RANDOM[i] = list.get(0);
            }else
            {
                RANDOM[i] = list.get(i);
            }
        }
        return RANDOM;
    }


}
