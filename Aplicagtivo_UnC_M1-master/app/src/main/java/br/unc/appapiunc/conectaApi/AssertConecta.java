package br.unc.appapiunc.conectaApi;

import android.app.DownloadManager;
import android.telecom.Call;
import android.util.Log;
import android.view.textclassifier.ConversationActions;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import Data.Resultado;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AssertConecta {

    public static class AdviceDataSource {
        private AdviceDataSource currentAdvice;

        private Resultado result;

        public Resultado<AdviceDataSource> getAdvice() {
            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://api.flutter-community.de/api/v1/advice")
                        .build();
                okhttp3.Call call = client.newCall(request);
                call.enqueue(new Callback() {

                    @Override
                    public void onResponse(@NonNull okhttp3.Call call, @NonNull Response response) throws IOException {
                        if (response.isSuccessful() && response.code() == 200) {
                            String body = response.body().string();


                            try {
                                JSONObject object = new JSONObject(body);
                                conexao conexao = new conexao(object);


                                result = new Resultado.Success<>(conexao);
                            } catch (JSONException e) {
                                Log.i("Error advice => ", e.getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull okhttp3.Call call, @NonNull IOException e) {
                        result = new Resultado.Error(e);

                    }

                });


                while (result == null) {
                }

                return result;
            } catch (Exception e) {
                return new Resultado.Error(new IOException("Error on get advice"));
            }
        }
    }
}
