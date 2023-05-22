package br.unc.appapiunc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import javax.xml.transform.Result;

import Data.Resultado;
import Data.repository.repository;
import br.unc.appapiunc.conectaApi.AssertConecta;
import br.unc.appapiunc.conectaApi.conexao;

public class MainActivity extends AppCompatActivity {


    private conexao currentAdvice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_mensagem = this.findViewById(R.id.btn_mensagem);

        btn_mensagem.setOnClickListener(v -> {
            getAdvice();
        });
    }

    public void getAdvice(){
        repository Repository = repository.getInstance(new AssertConecta());
        Resultado<conexao> resultOrFail = Repository.getAdvice();

        if(resultOrFail instanceof Resultado.Success){
            setCurrentAdvice(((Resultado.Success<conexao>) resultOrFail).getData());
        }else{
            Log.i("Error getting one advice => ", resultOrFail.toString());
        }

        TextView textView1 = this.findViewById(R.id.textView1);


        //setar os valores
        textView1.setText(this.currentAdvice.getBody());
    }


    public void setCurrentAdvice(conexao currentAdvice) {
        this.currentAdvice = currentAdvice;
    }
}