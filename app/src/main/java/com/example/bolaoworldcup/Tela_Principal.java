package com.example.bolaoworldcup;

import static com.example.bolaoworldcup.NomePaises.atualizaTimea;
import static com.example.bolaoworldcup.NomePaises.atualizaTimeb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Tela_Principal extends AppCompatActivity {
    private SQLiteDatabase bancoDados;
    public ListView listViewDados;

    private Spinner spinner;
    private Spinner spinner2;
    private ImageView image_1;
    private ImageView image_2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        listViewDados = (ListView) findViewById(R.id.listViewDados);

        criarBancoDeDados();
        limpaDados();
        inserirDados();
        listarDados();


        spinner=findViewById(R.id.spinner);
        spinner2=findViewById(R.id.spinner2);
        image_1=findViewById(R.id.image1);
        image_2=findViewById(R.id.image2);


        String[] bandeiras = {"Alemanha","Arábia Saudita","Argentina","Austrália","Bélgica","Brasil","Camarões","Canadá","Catar","Coreia do Sul","Costa Rica","Croácia","Dinamarca","Equador","Espanha",
                "Estados Unidos","França","Gana","Holanda","Inglaterra","Irã","Japão","Marrocos","México","País de Gales","Polônia","Portugal","Senegal","Sérvia","Suíça","Tunísia","Uruguai"};

        ArrayAdapter<String>adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,bandeiras);


        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        spinner.post(new Runnable() {
            @Override
            public void run() {
                spinner.setSelection(5);
            }
        });

        spinner2.post(new Runnable() {
            @Override
            public void run() {
                spinner2.setSelection(16);
            }
        });


        final TextView casa = super.findViewById(R.id.id_casa);
        final TextView empate = super.findViewById(R.id.id_empate);
        final TextView fora = super.findViewById(R.id.id_fora);

        final Spinner text_spinner = (Spinner)findViewById(R.id.spinner);
        final Spinner text_spinner2 = (Spinner)findViewById(R.id.spinner2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        image_1.setImageResource(R.drawable.flag_alemanha);
                        break;
                    case 1:
                        image_1.setImageResource(R.drawable.flag_arabia_saudita);
                        break;
                    case 2:
                        image_1.setImageResource(R.drawable.flag_argentina);
                        break;
                    case 3:
                        image_1.setImageResource(R.drawable.flag_australia);
                        break;
                    case 4:
                        image_1.setImageResource(R.drawable.flag_belgica);
                        break;
                    case 5:
                        image_1.setImageResource(R.drawable.flag_brasil);
                        break;
                    case 6:
                        image_1.setImageResource(R.drawable.flag_camaroes);
                        break;
                    case 7:
                        image_1.setImageResource(R.drawable.flag_canada);
                        break;
                    case 8:
                        image_1.setImageResource(R.drawable.flag_catar);
                        break;
                    case 9:
                        image_1.setImageResource(R.drawable.flag_coreia_do_sul);
                        break;
                    case 10:
                        image_1.setImageResource(R.drawable.flag_costa_rica);
                        break;
                    case 11:
                        image_1.setImageResource(R.drawable.flag_croacia);
                        break;
                    case 12:
                        image_1.setImageResource(R.drawable.flag_dinamarca);
                        break;
                    case 13:
                        image_1.setImageResource(R.drawable.flag_equador);
                        break;
                    case 14:
                        image_1.setImageResource(R.drawable.flag_espanha);
                        break;
                    case 15:
                        image_1.setImageResource(R.drawable.flag_estados_unidos);
                        break;
                    case 16:
                        image_1.setImageResource(R.drawable.flag_franca);
                        break;
                    case 17:
                        image_1.setImageResource(R.drawable.flag_gana);
                        break;
                    case 18:
                        image_1.setImageResource(R.drawable.flag_holanda);
                        break;
                    case 19:
                        image_1.setImageResource(R.drawable.flag_inglaterra);
                        break;
                    case 20:
                        image_1.setImageResource(R.drawable.flag_ira);
                        break;
                    case 21:
                        image_1.setImageResource(R.drawable.flag_japao);
                        break;
                    case 22:
                        image_1.setImageResource(R.drawable.flag_marrocos);
                        break;
                    case 23:
                        image_1.setImageResource(R.drawable.flag_mexico);
                        break;
                    case 24:
                        image_1.setImageResource(R.drawable.flag_pais_de_gales);
                        break;
                    case 25:
                        image_1.setImageResource(R.drawable.flag_polonia);
                        break;
                    case 26:
                        image_1.setImageResource(R.drawable.flag_portugal);
                        break;
                    case 27:
                        image_1.setImageResource(R.drawable.flag_senegal);
                        break;
                    case 28:
                        image_1.setImageResource(R.drawable.flag_servia);
                        break;
                    case 29:
                        image_1.setImageResource(R.drawable.flag_suica);
                        break;
                    case 30:
                        image_1.setImageResource(R.drawable.flag_tunisia);
                        break;
                    case 31:
                        image_1.setImageResource(R.drawable.flag_uruguai);
                        break;
                }

                String timea = text_spinner.getSelectedItem().toString();
                String timeb = text_spinner2.getSelectedItem().toString();

                timea = atualizaTimea(timea);
                timeb = atualizaTimeb(timeb);

                TaskAPI taskAPI = new TaskAPI(Tela_Principal.this, timea, timeb,
                        new TaskAPI.AsyncResponse() {
                            @Override
                            public void processFinish(GameResult gameResult) {
                                fora.setText(String.format("%.0f",gameResult.getLoose()*100)+"%");
                                casa.setText(String.format("%.0f",gameResult.getWin()*100)+"%");
                                empate.setText(String.format("%.0f",gameResult.getDraw()*100)+"%");
                            }
                        });

                taskAPI.execute();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        image_2.setImageResource(R.drawable.flag_alemanha);
                        break;
                    case 1:
                        image_2.setImageResource(R.drawable.flag_arabia_saudita);
                        break;
                    case 2:
                        image_2.setImageResource(R.drawable.flag_argentina);
                        break;
                    case 3:
                        image_2.setImageResource(R.drawable.flag_australia);
                        break;
                    case 4:
                        image_2.setImageResource(R.drawable.flag_belgica);
                        break;
                    case 5:
                        image_2.setImageResource(R.drawable.flag_brasil);
                        break;
                    case 6:
                        image_2.setImageResource(R.drawable.flag_camaroes);
                        break;
                    case 7:
                        image_2.setImageResource(R.drawable.flag_canada);
                        break;
                    case 8:
                        image_2.setImageResource(R.drawable.flag_catar);
                        break;
                    case 9:
                        image_2.setImageResource(R.drawable.flag_coreia_do_sul);
                        break;
                    case 10:
                        image_2.setImageResource(R.drawable.flag_costa_rica);
                        break;
                    case 11:
                        image_2.setImageResource(R.drawable.flag_croacia);
                        break;
                    case 12:
                        image_2.setImageResource(R.drawable.flag_dinamarca);
                        break;
                    case 13:
                        image_2.setImageResource(R.drawable.flag_equador);
                        break;
                    case 14:
                        image_2.setImageResource(R.drawable.flag_espanha);
                        break;
                    case 15:
                        image_2.setImageResource(R.drawable.flag_estados_unidos);
                        break;
                    case 16:
                        image_2.setImageResource(R.drawable.flag_franca);
                        break;
                    case 17:
                        image_2.setImageResource(R.drawable.flag_gana);
                        break;
                    case 18:
                        image_2.setImageResource(R.drawable.flag_holanda);
                        break;
                    case 19:
                        image_2.setImageResource(R.drawable.flag_inglaterra);
                        break;
                    case 20:
                        image_2.setImageResource(R.drawable.flag_ira);
                        break;
                    case 21:
                        image_2.setImageResource(R.drawable.flag_japao);
                        break;
                    case 22:
                        image_2.setImageResource(R.drawable.flag_marrocos);
                        break;
                    case 23:
                        image_2.setImageResource(R.drawable.flag_mexico);
                        break;
                    case 24:
                        image_2.setImageResource(R.drawable.flag_pais_de_gales);
                        break;
                    case 25:
                        image_2.setImageResource(R.drawable.flag_polonia);
                        break;
                    case 26:
                        image_2.setImageResource(R.drawable.flag_portugal);
                        break;
                    case 27:
                        image_2.setImageResource(R.drawable.flag_senegal);
                        break;
                    case 28:
                        image_2.setImageResource(R.drawable.flag_servia);
                        break;
                    case 29:
                        image_2.setImageResource(R.drawable.flag_suica);
                        break;
                    case 30:
                        image_2.setImageResource(R.drawable.flag_tunisia);
                        break;
                    case 31:
                        image_2.setImageResource(R.drawable.flag_uruguai);
                        break;
                }


                String timea = text_spinner.getSelectedItem().toString();
                String timeb = text_spinner2.getSelectedItem().toString();

                timea = atualizaTimea(timea);
                timeb = atualizaTimeb(timeb);

                TaskAPI taskAPI = new TaskAPI(Tela_Principal.this, timea, timeb,
                        new TaskAPI.AsyncResponse() {
                            @Override
                            public void processFinish(GameResult gameResult) {
                                fora.setText(String.format("%.0f",gameResult.getLoose()*100)+"%");
                                casa.setText(String.format("%.0f",gameResult.getWin()*100)+"%");
                                empate.setText(String.format("%.0f",gameResult.getDraw()*100)+"%");
                            }
                        });

                taskAPI.execute();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

    }

    public void criarBancoDeDados(){
        try {
            bancoDados = openOrCreateDatabase("bolaofmu", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS historico(" + " id INTEGER PRIMARY KEY AUTOINCREMENT " + ", " +
                    "data VARCHAR " + ",time_casa VARCHAR " + ",time_fora VARCHAR " + ",casa_gols VARCHAR " + ",fora_gols VARCHAR)");
            bancoDados.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void listarDados(){
        try {
            bancoDados = openOrCreateDatabase("bolaofmu", MODE_PRIVATE, null);
            Cursor meuCursor = bancoDados.rawQuery("SELECT id,data,time_casa,time_fora,casa_gols,fora_gols FROM historico",null);
            ArrayList<String> linhas = new ArrayList<>();

            ArrayAdapter meuAdapter = new ArrayAdapter<String>(
                    this, android.R.layout.simple_list_item_1,android.R.id.text1,linhas
            );
            listViewDados.setAdapter(meuAdapter);
            meuCursor.moveToFirst();
            while(meuCursor!=null){
                linhas.add(meuCursor.getString(1));
                meuCursor.moveToNext();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void inserirDados() {
        try {
            bancoDados = openOrCreateDatabase("bolaofmu", MODE_PRIVATE, null);
            String sql = "INSERT INTO historico (data,time_casa,time_fora,casa_gols,fora_gols) VALUES (?,?,?,?,?)";
            SQLiteStatement stmt = bancoDados.compileStatement(sql);

            String[] other = {"Alemanha","Arábia Saudita","Argentina","Austrália","Bélgica"};

            String original = "29/03/1897\n29/03/1886";

            stmt.bindString(1, other[0]);
            stmt.executeInsert();
            stmt.bindString(2, other[1]);
            stmt.executeInsert();
            stmt.bindString(3, other[2]);
            stmt.executeInsert();
            stmt.bindString(4, other[3]);
            stmt.executeInsert();
            stmt.bindString(5, other[4]);
            stmt.executeInsert();

            stmt.bindString(1, other[0]);
            stmt.executeInsert();
            stmt.bindString(2, other[1]);
            stmt.executeInsert();
            stmt.bindString(3, other[2]);
            stmt.executeInsert();
            stmt.bindString(4, other[3]);
            stmt.executeInsert();
            stmt.bindString(5, "teste");
            stmt.executeInsert();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void limpaDados() {
        try {
            bancoDados = openOrCreateDatabase("bolaofmu", MODE_PRIVATE, null);
            bancoDados.execSQL("DELETE FROM historico");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}