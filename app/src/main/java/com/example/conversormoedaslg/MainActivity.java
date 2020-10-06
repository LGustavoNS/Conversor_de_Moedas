package com.example.conversormoedaslg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.edt_valor = findViewById(R.id.edt_valor);
        this.mViewHolder.txt_dolar = findViewById(R.id.txt_dolar);
        this.mViewHolder.txt_euro = findViewById(R.id.txt_euro);
        this.mViewHolder.btn_calculate = findViewById(R.id.btn_calculate);
        this.mViewHolder.btn_calculate.setOnClickListener(this);
        this.clearValue();
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            String value = this.mViewHolder.edt_valor.getText().toString();
            if ("".equals(value)) {
                Toast.makeText(this, this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
            } else {
                Double real = Double.valueOf(value);

                this.mViewHolder.txt_dolar.setText(String.format("%.2f", (real / 5.66)));
                this.mViewHolder.txt_euro.setText(String.format("%.2f", (real / 6.46)));
            }
            }
        }
        private void  clearValue() {
            this.mViewHolder.txt_dolar.setText("");
            this.mViewHolder.txt_euro.setText("");
        }
    private  static  class ViewHolder {
        EditText edt_valor;
        TextView txt_dolar;
        TextView txt_euro;
        Button btn_calculate;
    }
}