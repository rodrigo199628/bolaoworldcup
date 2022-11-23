package com.example.bolaoworldcup;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AcessoBancoDados{
    private SQLiteOpenHelper abrirBanco;
    private SQLiteDatabase db;
    private static AcessoBancoDados instance;
    Cursor c = null;

    //Construtor
    private AcessoBancoDados(Context context) {
        this.abrirBanco = new BancoDados(context);
    }

    public static AcessoBancoDados getInstance(Context context) {
        if (instance == null) {
            instance = new AcessoBancoDados(context);
        }
        return instance;
    }

    //Abrir banco de dados

    public void abrir(){
        this.db=abrirBanco.getWritableDatabase();
    }

    //Fechar banco de dados
    public void fechar(){
        if(db!=null){
            this.db.close();
        }
    }

    //Retornar resultados

    public String retornaDados(String selecao_casa, String selecao_fora){
        c=db.rawQuery("SELECT date,home_team,away_team,home_score,away_score from results_worldcup where home_team = '"+selecao_casa+"' AND away_team = '"+selecao_fora+"'",new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String data = c.getString(0);
            String time_casa = c.getString(1);
            String time_fora = c.getString(2);
            String gols_casa = c.getString(3);
            String gols_fora = c.getString(4);
            buffer.append(" ;"+ "  " + data + "     " + time_casa + "      X       " + time_fora + "        " + gols_casa + ":" + gols_fora + " ");
        }
        return buffer.toString();
    }



}



