package br.unc.appapiunc.conectaApi;

import org.json.JSONException;
import org.json.JSONObject;

public class conexao {
    int id;
    String body;

    public conexao(JSONObject json) throws JSONException {
        setId(json.getInt("advice_id"));
        setBody(json.getString("advice"));
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}
