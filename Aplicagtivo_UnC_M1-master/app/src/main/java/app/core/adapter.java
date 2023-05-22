package app.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



import androidx.annotation.NonNull;

import br.unc.appapiunc.R;
import br.unc.appapiunc.conectaApi.conexao;

public class adapter extends BaseAdapter {

        private final conexao currentAdvice;
        private final Context context;

        public adapter (@NonNull Context context, @NonNull conexao advice) {

            this.currentAdvice = advice;
            this.context = context;
        }

        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public Object getItem(int position) {
            return currentAdvice;
        }

        @Override
        public long getItemId(int position) {
            return currentAdvice.getId();
        }

        @NonNull
        @Override
        public View getView(int position, @NonNull View view, ViewGroup group) {
            View view1 = null;

            if(currentAdvice != null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                //montagem da tela
                view1 = inflater.inflate(R.layout.activity_main, group, false);

                //buscar elementos
                TextView txvAdviceText = view1.findViewById(R.id.textView1);

                //setar os valores
                txvAdviceText.setText(currentAdvice.getBody());

            }

            return view1;
        }
    }
