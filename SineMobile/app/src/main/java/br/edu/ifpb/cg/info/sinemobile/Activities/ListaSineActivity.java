package br.edu.ifpb.cg.info.sinemobile.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import br.edu.ifpb.cg.info.sinemobile.AsyncTask.ListaSineAsyncTask;
import br.edu.ifpb.cg.info.sinemobile.Entidades.Sine;
import br.edu.ifpb.cg.info.sinemobile.R;

public class ListaSineActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listViewSine = (ListView) findViewById(R.id.listViewSine);
        ListaSineAsyncTask processo = new ListaSineAsyncTask();
        ArrayList<Sine> listaSine = new ArrayList<Sine>();
        try {
            listaSine = processo.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ArrayAdapter<Sine> adaptador = new ArrayAdapter<Sine> (this, android.R.layout.simple_list_item_1, listaSine);
        listViewSine.setAdapter(adaptador);
    }

    public void voltar1(View view){
        Intent intent = new Intent();
        String chave = "";
        intent.putExtra(chave, "");
        startActivity(intent);
    }

}
