package br.edu.ifpb.cg.info.sinemobile.Activities;

import android.app.Activity;
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

import br.edu.ifpb.cg.info.sinemobile.AsyncTask.SinesRegiaoAsyncTask;
import br.edu.ifpb.cg.info.sinemobile.AsyncTask.SinesRegiaoAsyncTask;
import br.edu.ifpb.cg.info.sinemobile.Entidades.Sine;
import br.edu.ifpb.cg.info.sinemobile.R;

public class SineRegiaoActivity extends Activity {

    ListView lvSinesProximos;
    Button btVoltar;
    List<Sine> sineRegiao;
    ArrayAdapter<Sine> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sine_regiao);

        lvSinesProximos = (ListView) findViewById(R.id.lvSinesProximos);
        btVoltar = (Button) findViewById(R.id.btVoltar);
        SinesRegiaoAsyncTask processo = new SinesRegiaoAsyncTask();

        try {
            sineRegiao = processo.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        adaptador = new ArrayAdapter<Sine> (this, android.R.layout.simple_list_item_1, sineRegiao);
        lvSinesProximos.setAdapter(adaptador);
    }
}
