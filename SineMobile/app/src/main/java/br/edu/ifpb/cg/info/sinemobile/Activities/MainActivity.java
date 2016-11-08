package br.edu.ifpb.cg.info.sinemobile.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.ifpb.cg.info.sinemobile.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void listarSines(View view){
        Intent intent = new Intent(MainActivity.this, ListaSineActivity.class);
        String chave = "";
        intent.putExtra(chave, "");
        startActivity(intent);
    }

    public void sinesRegiao(View view){
        Intent intent = new Intent (MainActivity.this, MapsActivity.class);
        String chave = "";
        intent.putExtra(chave, "");
        startActivity(intent);
    }

}
