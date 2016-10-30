package br.edu.ifpb.cg.info.sinemobile.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;
import java.util.concurrent.ExecutionException;

import br.edu.ifpb.cg.info.sinemobile.AsyncTask.SineAsyncTask;
import br.edu.ifpb.cg.info.sinemobile.Entidades.Sine;
import br.edu.ifpb.cg.info.sinemobile.R;

public class ListaSineActivity extends AppCompatActivity {

    ListView lvSines;
    List<Sine> listaSine;
    ArrayAdapter<Sine> adaptador;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sine);

        lvSines = (ListView) findViewById(R.id.listViewSine);
        SineAsyncTask processo = new SineAsyncTask();

        try {
            listaSine = processo.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        adaptador = new ArrayAdapter<Sine> (this, android.R.layout.simple_list_item_1, listaSine);
        lvSines.setAdapter(adaptador);
    }

}
