package br.edu.ifpb.cg.info.sinemobile.AsyncTask;

import android.os.AsyncTask;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.cg.info.sinemobile.Entidades.Sine;

/**
 * Created by Diego A. Gama on 28/10/2016.
 */
public class ListaSineAsyncTask extends AsyncTask<String, Void, List<Sine>> {
    @Override
    protected List<Sine> doInBackground(String... strings){
        List<Sine> listaSine = new ArrayList<Sine>();

        try {
            URL url = new URL("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/");
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");
            conexao.setRequestProperty("Content-Type", "application/json");
            conexao.connect();

            InputStream resposta;
            resposta = conexao.getInputStream();
            JsonReader leitor = new JsonReader (new InputStreamReader(resposta, "UTF-8"));

            leitor.beginArray();
            while (leitor.hasNext()){
                listaSine.add(converterSine(leitor));
            }
            leitor.endArray();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return listaSine;
    }

    public Sine converterSine(JsonReader reader) throws IOException {
        String codPosto = "";
        String nome = "";
        String entidadeConveniada = "";
        String municipio = "";
        String uf = "";
        String cep = "";
        String latitude = "";
        String longitude = "";
        String bairro = "";
        String endereco = "";
        String telefone = "";

        Sine sine = new Sine();

        reader.beginObject();
        while(reader.hasNext()){
            String name = reader.nextName();
            if (name.equals("codPosto"))
                sine.setCodPosto(reader.nextString());
            else if (name.equals("nome"))
                sine.setNome(reader.nextString());
            else if (name.equals("entidadeConveniada"))
                sine.setEntidadeConveniada(reader.nextString());
            else if (name.equals("endereco"))
                sine.setEndereco(reader.nextString());
            else if (name.equals("bairro"))
                sine.setBairro(reader.nextString());
            else if (name.equals("cep"))
                sine.setCep(reader.nextString());
            else if (name.equals("telefone"))
                sine.setTelefone(reader.nextString());
            else if (name.equals("municipio"))
                sine.setMunicipio(reader.nextString());
            else if (name.equals("uf"))
                sine.setUf(reader.nextString());
            else if (name.equals("lat"))
                sine.setLatitude(reader.nextString());
            else if (name.equals("long"))
                sine.setLongitude(reader.nextString());
            else
                reader.skipValue();
        }
        reader.endObject();
        return sine;
    }

    public void onPostExecute(List<Sine> result){
        super.onPostExecute(result);
    }

}
