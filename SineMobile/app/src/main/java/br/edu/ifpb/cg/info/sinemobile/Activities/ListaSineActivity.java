package br.edu.ifpb.cg.info.sinemobile.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.edu.ifpb.cg.info.sinemobile.AsyncTask.ListaSineAsyncTask;
import br.edu.ifpb.cg.info.sinemobile.Entidades.Sine;
import br.edu.ifpb.cg.info.sinemobile.R;

public class ListaSineActivity extends AppCompatActivity {

    ListView lvSines;
    Button btVoltar;
    List<Sine> listaSine;
    ArrayAdapter<Sine> adaptador;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sine);

        lvSines = (ListView) findViewById(R.id.listViewSine);
        btVoltar = (Button) findViewById(R.id.btVoltar);
        ListaSineAsyncTask processo = new ListaSineAsyncTask();

        try {
            listaSine = processo.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        adaptador = new ArrayAdapter<Sine> (this, android.R.layout.simple_list_item_1, listaSine);
        lvSines.setAdapter(adaptador);
    }

    public void voltar(View view){
        Intent intent = new Intent();
        String chave = "";
        intent.putExtra(chave, "");
        startActivity(intent);
    }

}
