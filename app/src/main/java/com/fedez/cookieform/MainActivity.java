package com.fedez.cookieform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.R.attr.button;
import static com.fedez.cookieform.R.id.btn_sig;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_sig;
    private EditText et_nombre;
    private EditText et_tel;
    private EditText et_email;
    private EditText et_des;
    private int dia;
    private int mes;
    private int anio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sig=(Button)findViewById(R.id.btn_sig);
        et_nombre=(EditText)findViewById(R.id.et_nombre);
        et_tel=(EditText)findViewById(R.id.et_tel);
        et_email=(EditText)findViewById(R.id.et_email);
        et_des=(EditText)findViewById(R.id.et_des);

        btn_sig.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View v) {

        DatePicker dp_fechac=(DatePicker) findViewById(R.id.dp_fechanac);
        dia=dp_fechac.getDayOfMonth();
        mes=dp_fechac.getMonth()+1;
        anio=dp_fechac.getYear();

        Intent intent= new Intent(this,ConfirmarDatos.class);
        String tmp_et_nombre=et_nombre.getText().toString();
        String tmp_et_tel=et_tel.getText().toString();
        String tmp_et_email=et_email.getText().toString();
        String tmp_et_des=et_des.getText().toString();

        intent.putExtra("nombre",tmp_et_nombre);
        intent.putExtra("tel",tmp_et_tel);
        intent.putExtra("email",tmp_et_email);
        intent.putExtra("des",tmp_et_des);

        intent.putExtra("Day", dia);
        intent.putExtra("Month", mes);
        intent.putExtra("Year", anio);


        startActivity(intent);

    }

}
