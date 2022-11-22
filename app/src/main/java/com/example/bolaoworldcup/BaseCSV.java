package com.example.bolaoworldcup;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStream;
import java.io.InputStreamReader;

public class BaseCSV {

    public static void lerCSV(Context mainScreen){

        try{
            InputStream dados = mainScreen.getAssets().open("results_worldcup.csv");

            Iterable<CSVRecord> colunas = CSVFormat.EXCEL.withHeader().parse(new InputStreamReader(dados));

            for (CSVRecord rec: colunas){
                String date = rec.get(0);
                String home_team = rec.get(1);
                String away_team = rec.get(2);
                String home_score = rec.get(3);
                String away_score = rec.get(4);

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}