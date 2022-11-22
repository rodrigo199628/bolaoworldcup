package com.example.bolaoworldcup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
        public void telaPrincipal(View view)
        {
            Intent telaprincipal = new Intent(this, Tela_Principal.class);
            startActivity(telaprincipal);
        }

    public void telaCadastro(View view)
    {
        Intent telacadastro = new Intent(this, Cadastro.class);
        startActivity(telacadastro);
    }
}