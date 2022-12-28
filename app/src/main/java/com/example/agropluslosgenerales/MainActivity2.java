package com.example.agropluslosgenerales;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String message = intent.getStringExtra("numero");

        String toroc1 = intent.getStringExtra("toroc1");
        String toroc2 = intent.getStringExtra("toroc2");
        String toroc3 = intent.getStringExtra("toroc3");

        String toron1 = intent.getStringExtra("toron1");
        String toron2 = intent.getStringExtra("toron2");
        String toron3 = intent.getStringExtra("toron3");

        String corral = intent.getStringExtra("CORR");
        String del = intent.getStringExtra("DEL");
        String leche = intent.getStringExtra("LECH");
        String lechp = intent.getStringExtra("LECHP");
        String fcel = intent.getStringExtra("FCEL");
        String vins = intent.getStringExtra("VINS");
        String lact = intent.getStringExtra("LACT");
        String rpro = intent.getStringExtra("RPRO");
        String dcc = intent.getStringExtra("DCC");
        String tecn = intent.getStringExtra("TECN");

        String tipo = intent.getStringExtra("tipo");

//////DATOS///////////////////////////////////////////////////////////
        TextView txtCorr = findViewById(R.id.txtCorr);
        txtCorr.setText(corral);
        TextView txtDel = findViewById(R.id.txtDel);
        txtDel.setText(del);
        TextView txtLech = findViewById(R.id.txtLech);
        txtLech.setText(leche);
        TextView txtLechp = findViewById(R.id.txtLechp);
        txtLechp.setText(lechp);
        TextView txtFcel = findViewById(R.id.txtFcel);
        txtFcel.setText(fcel);
        TextView txtVins = findViewById(R.id.txtVins);
        txtVins.setText(vins);
        TextView txtLact = findViewById(R.id.txtLact);
        txtLact.setText(lact);
        TextView txtRpro = findViewById(R.id.txtRpro);
        txtRpro.setText(rpro);
        TextView txtDcc = findViewById(R.id.txtDcc);
        txtDcc.setText(dcc);
        TextView txtTecn = findViewById(R.id.txtTecn);
        txtTecn.setText(tecn);

//////TORO Y CODIGO///////////////////////////////////////////////////////////
        TextView txtToro1 = findViewById(R.id.txtToro1);
        txtToro1.setText(toroc1);
        TextView txtToro2 = findViewById(R.id.txtToro2);
        txtToro2.setText(toroc2);
        TextView txtToro3 = findViewById(R.id.txtToro3);
        txtToro3.setText(toroc3);

        TextView txtnToro1 = findViewById(R.id.textView8);
        txtnToro1.setText(toron1);
        TextView txtnToro2 = findViewById(R.id.textView9);
        txtnToro2.setText(toron2);
        TextView txtnToro3 = findViewById(R.id.textView11);
        txtnToro3.setText(toron3);

/////numero de vaca///////////////////////////////////////////////////////////
        TextView txtNumVaca = findViewById(R.id.txtNumVaca);
        txtNumVaca.setText(message);

////////////boton volver////////////////////////////////////////////////////////////
        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }

    public void openActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
