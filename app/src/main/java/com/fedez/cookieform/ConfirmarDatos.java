package com.fedez.cookieform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import static com.fedez.cookieform.R.string.btn_editar;

public class ConfirmarDatos extends AppCompatActivity {

    TextView tv_Nombrec;
    TextView tv_Telc;
    TextView tv_Emailc;
    TextView tv_Descripcionc;
    TextView tv_FechaNacc;
    int dia;
    int mes;
    int anio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        tv_Nombrec=(TextView) findViewById(R.id.tvNombrec);
        tv_Telc=(TextView) findViewById(R.id.tvTelc);
        tv_Emailc=(TextView) findViewById(R.id.tvEmailc);
        tv_Descripcionc=(TextView) findViewById(R.id.tvDescripcionc);
        tv_FechaNacc=(TextView) findViewById(R.id.tvFechaNacc);
        Button btn_editar=(Button) findViewById(R.id.btn_editar);

        Intent intent=getIntent();
        Bundle extras=intent.getExtras();

        if (extras != null){
            String filledNombre=(String)extras.get("nombre");
            String filledTel=(String)extras.get("tel");
            String filledEmail=(String)extras.get("email");
            String filledDesc=(String)extras.get("des");
            dia=intent.getIntExtra("Day",0);
            mes=intent.getIntExtra("Month",0);
            anio=intent.getIntExtra("Year",0);
            String filledNac=dia+"/"+mes+"/"+anio;


            tv_Nombrec.setText(filledNombre);
            tv_Telc.setText(filledTel);
            tv_Emailc.setText(filledEmail);
            tv_Descripcionc.setText(filledDesc);
            tv_FechaNacc.setText(filledNac);


        }

        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
