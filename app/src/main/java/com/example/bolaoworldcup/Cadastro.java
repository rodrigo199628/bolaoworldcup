package com.example.bolaoworldcup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {

    Button botaocadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        botaocadastro = (Button) findViewById(R.id.CriarConta_cadastro);
        botaocadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Cadastro.this, "Cadastro registrado!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void telaLogin(View view)
    {
        Intent telalogin = new Intent(this, Login.class);
        startActivity(telalogin);
    }

}