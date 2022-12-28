package com.example.agropluslosgenerales;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        commonDocumentDirPath();
        verifyStoragePermissions(this);
    }

    //ABRIR REGUNDA PANTALLA ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void openActivity2() throws IOException {

        Intent intent = new Intent(this, MainActivity2.class);

        EditText txtNumVaca = findViewById(R.id.editTxtNum);
        String numero = String.valueOf(txtNumVaca.getText());

        TextView txtToros = findViewById(R.id.txtToros);
        String toro = String.valueOf(txtToros.getText());

        TextView txtToro1 = findViewById(R.id.txtC1);
        String t1 = String.valueOf(txtToro1.getText());

        TextView txtToro2 = findViewById(R.id.txtC2);
        String t2 = String.valueOf(txtToro2.getText());

        TextView txtToro3 = findViewById(R.id.txtC3);
        String t3 = String.valueOf(txtToro3.getText());

        intent.putExtra("numero", numero);
        intent.putExtra("toro", toro);

        intent.putExtra("toroc1", t1);
        intent.putExtra("toroc2", t2);
        intent.putExtra("toroc3", t3);

        //vaca o vaquilla
        TextView txtDatos = findViewById(R.id.txtDatos);
        String tipo = String.valueOf(txtDatos.getText());

        TextView textView7 = findViewById(R.id.textView7);
        String mensaje = String.valueOf(textView7.getText());

        intent.putExtra("vaca", tipo);

        TextView txtTn1 = findViewById(R.id.txtTn1);
        String tn1 = String.valueOf(txtTn1.getText());
        TextView txtTn2 = findViewById(R.id.txtTn2);
        String tn2 = String.valueOf(txtTn2.getText());
        TextView txtTn3 = findViewById(R.id.txtTn3);
        String tn3 = String.valueOf(txtTn3.getText());

        intent.putExtra("toron1", tn1);
        intent.putExtra("toron2", tn2);
        intent.putExtra("toron3", tn3);


        TextView editTxtNum = findViewById(R.id.editTxtNum);

        String cvsSplitBy2 = ",";
        String line2 = "";
        File dir2 = commonDocumentDirPath();

        System.out.println(tipo);
        if (tipo.toString() == "VACAS" && mensaje.toString() == "OK") {
            try {

                String csvFile2 = dir2 + "/vacas.csv";
                BufferedReader br2 = null;
                br2 = new BufferedReader(new FileReader(csvFile2));
                String[] toro2 = new String[0];
                while ((line2 = br2.readLine()) != null) {// read line by line
                    toro2 = line2.split(cvsSplitBy2);
                    if (toro2[0].equals(editTxtNum.getText().toString())) {
                        intent.putExtra("CORR", toro2[1]);
                        intent.putExtra("DEL", toro2[2]);
                        intent.putExtra("LECH", toro2[3]);
                        intent.putExtra("LECHP", toro2[4]);
                        intent.putExtra("FCEL", toro2[6]);
                        intent.putExtra("VINS", toro2[7]);
                        intent.putExtra("LACT", toro2[8]);
                        intent.putExtra("RPRO", toro2[9]);
                        intent.putExtra("DCC", toro2[10]);
                        intent.putExtra("TECN", toro2[11]);
                        intent.putExtra("toro2", toro2[12]);
                        intent.putExtra("toro3", toro2[13]);
                        intent.putExtra("toro4", toro2[14]);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            startActivity(intent);

        }else if(tipo == "VAQUILLAS" && mensaje.toString() == "OK") {
            try {
                String csvFile3 = dir2 + "/vaquillas.csv";
                BufferedReader br3 = null;
                br3 = new BufferedReader(new FileReader(csvFile3));
                String[] toro2 = new String[0];
                while ((line2 = br3.readLine()) != null) {// read line by line
                    toro2 = line2.split(cvsSplitBy2);
                    if (toro2[0].equals(editTxtNum.getText().toString())) {
                        intent.putExtra("CORR", toro2[1]);
                        intent.putExtra("DEL", toro2[2]);
                        intent.putExtra("LECH", toro2[3]);
                        intent.putExtra("LECHP", toro2[4]);
                        intent.putExtra("FCEL", toro2[6]);
                        intent.putExtra("VINS", toro2[7]);
                        intent.putExtra("LACT", toro2[8]);
                        intent.putExtra("RPRO", toro2[9]);
                        intent.putExtra("DCC", toro2[10]);
                        intent.putExtra("TECN", toro2[11]);
                        intent.putExtra("toro2", toro2[12]);
                        intent.putExtra("toro3", toro2[13]);
                        intent.putExtra("toro4", toro2[14]);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            startActivity(intent);
        }
//        FirebaseDatabase db = FirebaseDatabase.getInstance().getReference("vacas").getDatabase();
//
//        EditText txtNumVaca = findViewById(R.id.editTxtNum);
//        String numero = String.valueOf(txtNumVaca.getText());

//        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
//                .setCacheSizeBytes(FirebaseFirestoreSettings.CACHE_SIZE_UNLIMITED)
//                .setPersistenceEnabled(true)
//                .build();
//        vaca.setNumero(numero);
//
//        db.getReference().child("vacas").child(numero).child("corral").get().addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        DataSnapshot document = task.getResult();
//                        if (document.exists()) {
//                            String numeroT = document.getValue().toString();
//                            corral = numeroT;
//                            vaca.setCorr(corral);
//                        } else {
//                            Toast.makeText(MainActivity.this, "No such document", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }
//        );
//        db.getReference().child("vacas").child(numero).child("dcc").get().addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                DataSnapshot document = task.getResult();
//                if (document.exists()) {
//                     dcc = document.getValue().toString();
//                        vaca.setDcc(dcc);
//                }
//            }
//            });
//        db.getReference().child("vacas").child(numero).child("del").get().addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                DataSnapshot document = task.getResult();
//                if (document.exists()) {
//                    del = document.getValue().toString();
//                    vaca.setDel(del);
//                }
//            }
//        });
//        db.getReference().child("vacas").child(numero).child("fcel").get().addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                DataSnapshot document = task.getResult();
//                if (document.exists()) {
//                    fcel = document.getValue().toString();
//                    vaca.setFcel(fcel);
//                }
//            }
//        });
//        db.getReference().child("vacas").child(numero).child("lact").get().addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                DataSnapshot document = task.getResult();
//                if (document.exists()) {
//                    lact = document.getValue().toString();
//                    vaca.setLact(lact);
//                }
//            }
//        });
//        db.getReference().child("vacas").child(numero).child("lech").get().addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                DataSnapshot document = task.getResult();
//                if (document.exists()) {
//                    lech = document.getValue().toString();
//                    vaca.setLech(lech);
//                }
//            }
//        });
//        db.getReference().child("vacas").child(numero).child("lechp").get().addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                DataSnapshot document = task.getResult();
//                if (document.exists()) {
//                    lechp = document.getValue().toString();
//                    vaca.setLechp(lechp);
//                }
//            }
//        });
//        db.getReference().child("vacas").child(numero).child("rpro").get().addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                DataSnapshot document = task.getResult();
//                if (document.exists()) {
//                    rpro = document.getValue().toString();
//                    vaca.setRpro(rpro);
//                }
//            }
//        });
//        db.getReference().child("vacas").child(numero).child("tecn").get().addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                DataSnapshot document = task.getResult();
//                if (document.exists()) {
//                    tecn = document.getValue().toString();
//                    vaca.setTecn(tecn);
//                }
//            }
//        });
//        db.getReference().child("vacas").child(numero).child("vins").get().addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                DataSnapshot document = task.getResult();
//                if (document.exists()) {
//                    vins = document.getValue().toString();
//                    vaca.setVins(vins);
//                }
//            }
//        });
//        db.getReference().child("vacas").child(numero).child("toro1").get().addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                DataSnapshot document = task.getResult();
//                if (document.exists()) {
//                    toro1 = document.getValue().toString();
//                    vaca.setToro1(toro1);
//                }
//            }
//        });
//        db.getReference().child("vacas").child(numero).child("toro2").get().addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                DataSnapshot document = task.getResult();
//                if (document.exists()) {
//                    toro2 = document.getValue().toString();
//                    vaca.setToro2(toro2);
//                }
//            }
//        });
//        db.getReference().child("vacas").child(numero).child("toro3").get().addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                DataSnapshot document = task.getResult();
//                if (document.exists()) {
//                    toro3 = document.getValue().toString();
//                    vaca.setToro3(toro3);
//                    Intent intent = new Intent(this, MainActivity2.class);
//                    startActivity(intent);
//                }
//            }
//        });
    }


    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    /**
     * Checks if the app has permission to write to device storage
     *
     * If the app does not has permission then the user will be prompted to grant permissions
     *
     * @param activity
     */
    public static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    public   File commonDocumentDirPath(){
        File dir = null ;
        String folder_main = "/com.example.agroplus";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            dir = new File (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+ folder_main );
            dir.mkdir();
        } else {
            dir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + folder_main);
            dir.mkdir();
        }
        return  dir ;
    }

    public void createFolder(){
        String folder_main = "com.example.agroplus";

        File folder = new File(Environment.getExternalStorageDirectory() + "/Android/data/"+folder_main);
        String ruta = Environment.getExternalStorageDirectory() + "/Android/data/com.example.agroplus";
        boolean success = true;
        if (!folder.exists()) {
            success = folder.mkdirs();
        }
        if (success) {
            Toast.makeText(this, "Carpeta creada", Toast.LENGTH_SHORT).show();
        } else  {
            Toast.makeText(this, "Carpeta no creada " + ruta, Toast.LENGTH_SHORT).show();
        }
    }

    public void saveData(View view){
        try {
            FirebaseDatabase db = FirebaseDatabase.getInstance().getReference("vacas").getDatabase();
            //vacas list
            List vacas = new ArrayList<>();

            db.getReference().child("vacas").get().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    DataSnapshot document = task.getResult();
                    if (document.exists()) {
                        for (DataSnapshot snapshot : document.getChildren()) {
                            String numero = snapshot.getKey().toString();
                            String corral = snapshot.child("corral").getValue().toString();
                            String dcc = snapshot.child("dcc").getValue().toString();
                            String del = snapshot.child("del").getValue().toString();
                            String fcel = snapshot.child("fcel").getValue().toString();

                            String lact = snapshot.child("lact").getValue().toString();
                            String lech = snapshot.child("lech").getValue().toString();
                            String lechp = snapshot.child("lechp").getValue().toString();
                            String rpro = snapshot.child("rpro").getValue().toString();
                            String tecn = snapshot.child("tecn").getValue().toString();
                            String vins = snapshot.child("vins").getValue().toString();
                            String toro1 = snapshot.child("toro1").getValue().toString();
                            String toro2 = snapshot.child("toro2").getValue().toString();
                            String toro3 = snapshot.child("toro3").getValue().toString();

                            String toro1n = snapshot.child("toro1n").getValue().toString();
                            String toro2n = snapshot.child("toro2n").getValue().toString();
                            String toro3n = snapshot.child("toro3n").getValue().toString();

                            String linea = numero+","+corral +"," + del + "," + lech + "," + lechp +
                                    ","+""+"," + fcel +"," + vins + ","+ lact + ","  + rpro +
                                    ","  +dcc + ","  + tecn + "," + toro1 + "," + toro2 + "," + toro3
                                    +
                                    "," + toro1n + "," + toro2n + "," + toro3n;
                            vacas.add(linea);
                        }
                        try {
                            //System.out.println( vacas.size());
                            File file = new File(commonDocumentDirPath(), "vacas.csv");
                            FileWriter fw = new FileWriter(file);
                            BufferedWriter bw = new BufferedWriter(fw);
                            for (int i = 0; i < vacas.size(); i++) {
                                bw.write(vacas.get(i).toString());
                                bw.newLine();
                            }
                            bw.close();
                            fw.close();
                            TextView mensaje = findViewById(R.id.textView7);
                            mensaje.setText("Datos Actualizados");
                            MediaPlayer mediaPlayer2 = MediaPlayer.create(this, R.raw.datos);
                            mediaPlayer2.start();
                        } catch (IOException e) {
                            e.printStackTrace();
                            TextView mensaje = findViewById(R.id.textView7);
                            mensaje.setText("Error al actualizar datos");
                        }
                    }
                }

            });

        } catch ( Exception e) {
            TextView mensaje = findViewById(R.id.textView7);
            mensaje.setText("Sin conexión a internet");
        }
        try {
            FirebaseDatabase db = FirebaseDatabase.getInstance().getReference("vaquillas").getDatabase();
            //vacas list
            List vacas = new ArrayList<>();

            db.getReference().child("vaquillas").get().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    DataSnapshot document = task.getResult();
                    if (document.exists()) {

                        for (DataSnapshot snapshot : document.getChildren()) {
                            String numero = snapshot.getKey().toString();
                            String corral = snapshot.child("corral").getValue().toString();
                            String dcc = snapshot.child("dcc").getValue().toString();
                            String del = snapshot.child("del").getValue().toString();
                            String fcel = snapshot.child("fcel").getValue().toString();
                            String lact = snapshot.child("lact").getValue().toString();
                            String lech = snapshot.child("lech").getValue().toString();
                            String lechp = snapshot.child("lechp").getValue().toString();
                            String rpro = snapshot.child("rpro").getValue().toString();
                            String tecn = snapshot.child("tecn").getValue().toString();
                            String vins = snapshot.child("vins").getValue().toString();
                            String toro1 = snapshot.child("toro1").getValue().toString();
                            String toro2 = snapshot.child("toro2").getValue().toString();
                            String toro3 = snapshot.child("toro3").getValue().toString();
                            String toro1n = snapshot.child("toro1n").getValue().toString();
                            String toro2n = snapshot.child("toro2n").getValue().toString();
                            String toro3n = snapshot.child("toro3n").getValue().toString();
                            String linea = numero+","+corral +"," + del + "," + lech + "," + lechp
                                    +","+""+"," + fcel +"," + vins + ","+ lact + ","  + rpro + ","
                                    +dcc + ","  + tecn + "," + toro1 + "," + toro2 + "," + toro3 + "," + toro1n + "," + toro2n + "," + toro3n;
                            vacas.add(linea);
                        }
                        try {
                            File file = new File(commonDocumentDirPath(), "vaquillas.csv");
                            FileWriter fw = new FileWriter(file);
                            BufferedWriter bw = new BufferedWriter(fw);
                            for (int i = 0; i < vacas.size(); i++) {
                                bw.write(vacas.get(i).toString());
                                bw.newLine();
                            }
                            bw.close();
                            fw.close();
                            //Toast.makeText(this, "Datos Actualizados", Toast.LENGTH_LONG).show();
                            TextView mensaje = findViewById(R.id.textView7);
                            mensaje.setText("Datos Actualizados");

                        } catch (IOException e) {
                            e.printStackTrace();
                            TextView mensaje = findViewById(R.id.textView7);
                            mensaje.setText("Error al actualizar datos");
                        }
                    }
                }
            });

        } catch ( Exception e) {
            TextView mensaje = findViewById(R.id.textView7);
            mensaje.setText("Sin conexión a internet");
        }


    }


    public void createCSVFile(String sFileName, String sBody){
        try
        {
            File root = new File(Environment.getExternalStorageDirectory(), "AgroPlus");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
            Toast.makeText(this, "Archivo creado", Toast.LENGTH_SHORT).show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void onClick1(View view) {
        Button btn1 = findViewById(R.id.btn1);
        TextView editTxtNum = findViewById(R.id.editTxtNum);
        if (editTxtNum.getText().length() == 1 && editTxtNum.getText().toString().equals("0")) {
            editTxtNum.setText("1");
        } else {
            editTxtNum.setText(editTxtNum.getText() + "1");
        }
        if (editTxtNum.getText().length() > 5) {
            editTxtNum.setText("0");
        }
    }

    public void onClick2(View view) {
        Button btn2 = findViewById(R.id.btn2);
        TextView editTxtNum = findViewById(R.id.editTxtNum);
        if (editTxtNum.getText().length() == 1 && editTxtNum.getText().toString().equals("0")) {
            editTxtNum.setText("2");
        } else {
            editTxtNum.setText(editTxtNum.getText() + "2");
        }
        if (editTxtNum.getText().length() > 5) {
            editTxtNum.setText("0");
        }
    }

    public void onClick3(View view) {
        Button btn3 = findViewById(R.id.btn3);
        TextView editTxtNum = findViewById(R.id.editTxtNum);
        if (editTxtNum.getText().length() == 1 && editTxtNum.getText().toString().equals("0")) {
            editTxtNum.setText("3");
        } else {
            editTxtNum.setText(editTxtNum.getText() + "3");
        }
        if (editTxtNum.getText().length() > 5) {
            editTxtNum.setText("0");
        }
    }

    public void onClick4(View view) {
        Button btn4 = findViewById(R.id.btn4);
        TextView editTxtNum = findViewById(R.id.editTxtNum);
        if (editTxtNum.getText().length() == 1 && editTxtNum.getText().toString().equals("0")) {
            editTxtNum.setText("4");
        } else {
            editTxtNum.setText(editTxtNum.getText() + "4");
        }
        if (editTxtNum.getText().length() > 5) {
            editTxtNum.setText("0");
        }
    }

    public void onClick5(View view) {
        Button btn5 = findViewById(R.id.btn5);
        TextView editTxtNum = findViewById(R.id.editTxtNum);
        if (editTxtNum.getText().length() == 1 && editTxtNum.getText().toString().equals("0")) {
            editTxtNum.setText("5");
        } else {
            editTxtNum.setText(editTxtNum.getText() + "5");
        }
        if (editTxtNum.getText().length() > 5) {
            editTxtNum.setText("0");
        }
    }

    public void onClick6(View view) {
        Button btn6 = findViewById(R.id.btn6);
        TextView editTxtNum = findViewById(R.id.editTxtNum);
        if (editTxtNum.getText().length() == 1 && editTxtNum.getText().toString().equals("0")) {
            editTxtNum.setText("6");
        } else {
            editTxtNum.setText(editTxtNum.getText() + "6");
        }
        if (editTxtNum.getText().length() > 5) {
            editTxtNum.setText("0");
        }
    }

    public void onClick7(View view) {
        Button btn7 = findViewById(R.id.btn7);
        TextView editTxtNum = findViewById(R.id.editTxtNum);
        if (editTxtNum.getText().length() == 1 && editTxtNum.getText().toString().equals("0")) {
            editTxtNum.setText("7");
        } else {
            editTxtNum.setText(editTxtNum.getText() + "7");
        }
        if (editTxtNum.getText().length() > 5) {
            editTxtNum.setText("0");
        }
    }

    public void onClick8(View view) {
        Button btn8 = findViewById(R.id.btn8);
        TextView editTxtNum = findViewById(R.id.editTxtNum);
        if (editTxtNum.getText().length() == 1 && editTxtNum.getText().toString().equals("0")) {
            editTxtNum.setText("8");
        } else {
            editTxtNum.setText(editTxtNum.getText() + "8");
        }
        if (editTxtNum.getText().length() > 5) {
            editTxtNum.setText("0");
        }
    }

    public void onClick9(View view) {
        Button btn9 = findViewById(R.id.btn9);
        TextView editTxtNum = findViewById(R.id.editTxtNum);
        if (editTxtNum.getText().length() == 1 && editTxtNum.getText().toString().equals("0")) {
            editTxtNum.setText("9");
        } else {
            editTxtNum.setText(editTxtNum.getText() + "9");
        }
        if (editTxtNum.getText().length() > 5) {
            editTxtNum.setText("0");
        }
    }

    public void onClick0(View view) {
        Button btn0 = findViewById(R.id.btn0);
        TextView editTxtNum = findViewById(R.id.editTxtNum);
        if (editTxtNum.getText().length() == 1 && editTxtNum.getText().toString().equals("0")) {
            editTxtNum.setText("0");
        } else {
            editTxtNum.setText(editTxtNum.getText() + "0");
        }
        if (editTxtNum.getText().length() > 5) {
            editTxtNum.setText("0");
        }
    }

    public void onClickDelete(View view) {
        TextView txtDatos = findViewById(R.id.textView7);
        Button btnDelete = findViewById(R.id.btnDelete);
        TextView editTxtNum = findViewById(R.id.editTxtNum);
        TextView txtToros = findViewById(R.id.txtToros);
        TextView txtC1 = findViewById(R.id.txtC1);
        TextView txtC2 = findViewById(R.id.txtC2);
        TextView txtC3 = findViewById(R.id.txtC3);
        TextView txtTn1 = findViewById(R.id.txtTn1);
        TextView txtTn2 = findViewById(R.id.txtTn2);
        TextView txtTn3 = findViewById(R.id.txtTn3);

        txtDatos.setText("Datos");
        txtTn1.setText("");
        txtTn2.setText("");
        txtTn3.setText("");
        txtC1.setText("");
        txtC2.setText("");
        txtC3.setText("");
        txtToros.setText("");
        editTxtNum.setText("0");
        txtDatos.setText("Mensajes");
    }

    public void onClickArchivo(View view) throws IOException {
        openActivity2();
    }

    public void readCSV(View view) {

        TextView txtDatos = findViewById(R.id.txtDatos);
        txtDatos.setText("VACAS");
        TextView editTxtNum = findViewById(R.id.editTxtNum);
        TextView txtToros = findViewById(R.id.txtToros);
        TextView txtDatos2 = findViewById(R.id.textView7);

        TextView txtC1 = findViewById(R.id.txtC1);
        TextView txtC2 = findViewById(R.id.txtC2);
        TextView txtC3 = findViewById(R.id.txtC3);
        TextView txtTn1 = findViewById(R.id.txtTn1);
        TextView txtTn2 = findViewById(R.id.txtTn2);
        TextView txtTn3 = findViewById(R.id.txtTn3);

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        txtToros.setText("");
        txtDatos2.setText("ID NO LOCALIZADO");
        File dir = commonDocumentDirPath();
        String csvFile =dir +"/vacas.csv";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {// read line by line
                String[] toro = line.split(cvsSplitBy); //split line by comma
                if (toro[0].equals(editTxtNum.getText().toString())) {//if the first column of the CSV file is equal to the number entered

                    try {
                        txtC1.setText(toro[12]);
                        txtC2.setText(toro[13]);
                        txtC3.setText(toro[14]);
                        txtTn1.setText(toro[15]);
                        txtTn2.setText(toro[16]);
                        txtTn3.setText(toro[17]);
//                        txtToros.setText( "          "+toro[12]+"          "+toro[15]+" \n"+"          "+ toro[13]+"          "+toro[16]+" \n"+"          "+toro[14]+"          "+toro[17]);//set the second column of the CSV file to the text view
//                        // txtToros.setText(toro[12]+"   "+toro[2]+"\n"+toro[13]+"   "+toro[4]+"\n"+toro[14]+"   "+toro[6]);//set the second column of the CSV file to the text view
                        txtDatos2.setText("OK");
                        MediaPlayer mediaPlayer2 = MediaPlayer.create(this, R.raw.okey);
                        mediaPlayer2.start();
                    } catch (Exception e) {
                        txtC1.setText(toro[12]);
                        txtC2.setText(toro[13]);
                        txtC3.setText(toro[14]);
                        txtTn1.setText("TORO 1");
                        txtTn2.setText("TORO 2");
                        txtTn3.setText("TORO 3");
//                        txtToros.setText( "          "+toro[12]+"          Toro 1"+" \n"+"          "+toro[13]+ "          Toro 2"+" \n"+"          "+toro[14]+"          Toro 3");//set the second column of the CSV file to the text view
//                        // txtToros.setText(toro[12]+"   "+toro[2]+"\n"+toro[13]+"   "+toro[4]+"\n"+toro[14]+"   "+toro[6]);//set the second column of the CSV file to the text view
                        txtDatos2.setText("OK");
                        MediaPlayer mediaPlayer2 = MediaPlayer.create(this, R.raw.okey);
                        mediaPlayer2.start();
                    }

                    // openActivity2();
                }else if(toro[0].equals("")) {
                    txtDatos2.setText("ID no localizado");
                    txtToros.setText("");
                }
            }
            if (txtDatos2.getText().toString().equals("ID NO LOCALIZADO")) {
                MediaPlayer mediaPlayer2 = MediaPlayer.create(this, R.raw.ide);
                mediaPlayer2.start();
            }
        } catch (FileNotFoundException e) {//catch exception
            e.printStackTrace();//print exception
            MediaPlayer mediaPlayer2 = MediaPlayer.create(this, R.raw.filenot);
            txtDatos2.setText("ARCHIVO NO LOCALIZADO");
            mediaPlayer2.start();
        } catch (IOException e) {//catch exception
            e.printStackTrace();//print exception
            MediaPlayer mediaPlayer2 = MediaPlayer.create(this, R.raw.filenot);
            mediaPlayer2.start();
        } finally {
            if (br != null) {
                try {
                    br.close();//close file
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void readCSVaquillas(View view) {
        TextView txtDatos = findViewById(R.id.txtDatos);
        txtDatos.setText("VAQUILLAS");
        TextView editTxtNum = findViewById(R.id.editTxtNum);
        TextView txtToros = findViewById(R.id.txtToros);
        TextView txtDatos2 = findViewById(R.id.textView7);

        TextView txtC1 = findViewById(R.id.txtC1);
        TextView txtC2 = findViewById(R.id.txtC2);
        TextView txtC3 = findViewById(R.id.txtC3);
        TextView txtTn1 = findViewById(R.id.txtTn1);
        TextView txtTn2 = findViewById(R.id.txtTn2);
        TextView txtTn3 = findViewById(R.id.txtTn3);

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        txtToros.setText("");
        txtDatos2.setText("ID NO LOCALIZADO");
        File dir = commonDocumentDirPath();
        String csvFile =dir +"/vaquillas.csv";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] toro = line.split(cvsSplitBy);
                if (toro[0].equals(editTxtNum.getText().toString())) {
                    try {
                        txtC1.setText(toro[12]);
                        txtC2.setText(toro[13]);
                        txtC3.setText(toro[14]);
                        txtTn1.setText(toro[15]);
                        txtTn2.setText(toro[16]);
                        txtTn3.setText(toro[17]);
//                        txtToros.setText( "          "+toro[12]+"          "+toro[15]+" \n"+"          "+ toro[13]+"          "+toro[16]+" \n"+"          "+toro[14]+"          "+toro[17]);//set the second column of the CSV file to the text view
//                        // txtToros.setText(toro[12]+"   "+toro[2]+"\n"+toro[13]+"   "+toro[4]+"\n"+toro[14]+"   "+toro[6]);//set the second column of the CSV file to the text view
                        txtDatos2.setText("OK");
                        MediaPlayer mediaPlayer2 = MediaPlayer.create(this, R.raw.okey);
                        mediaPlayer2.start();
                    } catch (Exception e) {
                        txtC1.setText(toro[12]);
                        txtC2.setText(toro[13]);
                        txtC3.setText(toro[14]);
                        txtTn1.setText("TORO 1");
                        txtTn2.setText("TORO 2");
                        txtTn3.setText("TORO 3");
//                        txtToros.setText( "          "+toro[12]+"          Toro 1"+" \n"+"          "+toro[13]+ "          Toro 2"+" \n"+"          "+toro[14]+"          Toro 3");//set the second column of the CSV file to the text view
//                        // txtToros.setText(toro[12]+"   "+toro[2]+"\n"+toro[13]+"   "+toro[4]+"\n"+toro[14]+"   "+toro[6]);//set the second column of the CSV file to the text view
                        txtDatos2.setText("OK");
                        MediaPlayer mediaPlayer2 = MediaPlayer.create(this, R.raw.okey);
                        mediaPlayer2.start();
                    }
                }else if(toro[0].equals("")) {
                    txtDatos2.setText("ID no localizado");
                    txtToros.setText("");
                }
            }
            if (txtDatos2.getText().toString().equals("ID NO LOCALIZADO")) {
                MediaPlayer mediaPlayer2 = MediaPlayer.create(this, R.raw.ide);
                mediaPlayer2.start();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            MediaPlayer mediaPlayer2 = MediaPlayer.create(this, R.raw.filenot);
            txtDatos2.setText("ARCHIVO NO LOCALIZADO");
            mediaPlayer2.start();
        } catch (IOException e) {
            e.printStackTrace();
            MediaPlayer mediaPlayer2 = MediaPlayer.create(this, R.raw.filenot);
            mediaPlayer2.start();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void subirVacas(View view) throws FileNotFoundException {

        File dir = commonDocumentDirPath();
        String csvFile = dir + "/VACAS.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<String[]> list = new ArrayList<String[]>();
        try {
            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
                HashMap<String, String> map = new HashMap<String, String>();
                String[] toro = line.split(cvsSplitBy);
                list.add(toro);

                for(int i = 0; i< list.size(); i++){
                    int vuelta = i+1;
                    if (vuelta == 100 || vuelta == 200 || vuelta == 300 || vuelta == 400 || vuelta == 500 || vuelta == 600 || vuelta == 700 || vuelta == 800 || vuelta == 900 || vuelta == 1000 || vuelta == 1100 || vuelta == 1200 || vuelta == 1300 || vuelta == 1400 || vuelta == 1500 ){
                        //sleep(1000);
                        sleep(10000);
                    }
                    map.put("numero", line.split(cvsSplitBy)[0]);
                    map.put("corral", line.split(cvsSplitBy)[1]);
                    map.put("dcc", line.split(cvsSplitBy)[10]);
                    map.put("del", line.split(cvsSplitBy)[2]);
                    map.put("lech", line.split(cvsSplitBy)[3]);
                    map.put("lechp", line.split(cvsSplitBy)[4]);
                    map.put("fcel", line.split(cvsSplitBy)[6]);
                    map.put("vins", line.split(cvsSplitBy)[7]);
                    map.put("lact", line.split(cvsSplitBy)[8]);
                    map.put("rpro", line.split(cvsSplitBy)[9]);
                    map.put("tecn", line.split(cvsSplitBy)[11]);
                    map.put("toro1", line.split(cvsSplitBy)[12]);
                    map.put("toro2", line.split(cvsSplitBy)[13]);
                    map.put("toro3", line.split(cvsSplitBy)[14]);

                    map.put("toro1n", line.split(cvsSplitBy)[15]);
                    map.put("toro2n", line.split(cvsSplitBy)[16]);
                    map.put("toro3n", line.split(cvsSplitBy)[17]);

                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("vacas").child(line.split(cvsSplitBy)[0]);
                    databaseReference.setValue(map);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void subirVaquillas (View view) throws FileNotFoundException{

        File dir = commonDocumentDirPath();
        String csvFile = dir + "/VAQUILLAS.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<String[]> list = new ArrayList<String[]>();
        try {
            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
                HashMap<String, String> map = new HashMap<String, String>();
                String[] toro = line.split(cvsSplitBy);
                list.add(toro);

                for(int i = 0; i< list.size(); i++){
                    int vuelta = i+1;
                    if (vuelta == 100 || vuelta == 200 || vuelta == 300 || vuelta == 400 || vuelta == 500 || vuelta == 600 || vuelta == 700 || vuelta == 800 || vuelta == 900 || vuelta == 1000 || vuelta == 1100 || vuelta == 1200 || vuelta == 1300 || vuelta == 1400 || vuelta == 1500 ){
                        //sleep(1000);
                        sleep(10000);
                    }
                    map.put("numero", line.split(cvsSplitBy)[0]);
                    map.put("corral", line.split(cvsSplitBy)[1]);
                    map.put("dcc", line.split(cvsSplitBy)[10]);
                    map.put("del", line.split(cvsSplitBy)[2]);
                    map.put("lech", line.split(cvsSplitBy)[3]);
                    map.put("lechp", line.split(cvsSplitBy)[4]);
                    map.put("fcel", line.split(cvsSplitBy)[6]);
                    map.put("vins", line.split(cvsSplitBy)[7]);
                    map.put("lact", line.split(cvsSplitBy)[8]);
                    map.put("rpro", line.split(cvsSplitBy)[9]);
                    map.put("tecn", line.split(cvsSplitBy)[11]);
                    map.put("toro1", line.split(cvsSplitBy)[12]);
                    map.put("toro2", line.split(cvsSplitBy)[13]);
                    map.put("toro3", line.split(cvsSplitBy)[14]);

                    map.put("toro1n", line.split(cvsSplitBy)[15]);
                    map.put("toro2n", line.split(cvsSplitBy)[16]);
                    map.put("toro3n", line.split(cvsSplitBy)[17]);

                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("vaquillas").child(line.split(cvsSplitBy)[0]);
                    databaseReference.setValue(map);
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}