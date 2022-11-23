package com.example.bolaoworldcup;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class BancoDados extends SQLiteAssetHelper {
    private static final String NOME_BANCO ="results_worldcup.db";
    private static final int BANCO_VERSAO=1;

    //Construtor
    public BancoDados(Context context){
        super(context, NOME_BANCO,null,BANCO_VERSAO);
    }
}
