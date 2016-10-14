package br.com.bsti.poclinkopenalertdialog;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final String dias[] = {
            "dom",
            "seg",
            "ter",
            "qua",
            "qui",
            "sex",
            "sáb"};

    final String horarios[] = {
            "18:00 às 01:00",
            "Fechado",
            "18:00 às 24:00",
            "18:00 às 24:00",
            "18:00 às 24:00",
            "18:00 às 24:00",
            "18:00 às 24:00"};

    TextView textview_horarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview_horarios = (TextView) findViewById(R.id.textview_horarios);
        textview_horarios.setPaintFlags(textview_horarios.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

    }

    /*
    public void openDialogAbout(View v) {
        View messageView = getLayoutInflater().inflate(R.layout.about,null);

        TextView textView = (TextView) messageView.findViewById(R.id.about_credits);
        int defaultColor = textView.getTextColors().getDefaultColor();
        textView.setTextColor(defaultColor);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setIcon()
        builder.setTitle(R.string.about);
        builder.setView(messageView);
        builder.create();
        builder.show();
    }

    public void openDialogHorarios(View v) {

        View messageView = getLayoutInflater().inflate(R.layout.horario_funcionamento, null, false);
        lvOpcoes = (ListView) findViewById(R.id.lvopcoes);

        opcoes = new ArrayList<String>();
        opcoes.add("Navegar na Internet");
        opcoes.add("Fazer uma ligação");
        opcoes.add("Sobre");
        opcoes.add("Sair");

        adaptador = new ArrayAdapter<String>(MainActivity.this, R.layout.horario_funcionamento , opcoes);
        //lvOpcoes.setAdapter(adaptador);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Horario de Funcionamento");
        builder.setView(messageView);
        builder.create();
        builder.setAdapter(adaptador,  new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

            }
        });
        builder.show();

        String horarios[] = {
                "dom      17:45 às 23:45",
                "seg      Fechado",
                "ter      17:45 às 23:45",
                "qua      17:45 às 23:45",
                "qui      17:45 às 23:45",
                "sex      17:45 às 23:45",
                "sáb      17:45 às 23:45"};

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View convertView = (View) inflater.inflate(R.layout.horario_funcionamento, null);
        alertDialog.setView(convertView);
        alertDialog.setTitle("Horario de Funcionamento");
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.horarios, R.layout.horario_funcionamento);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.horario_funcionamento, R.id.textview, horarios);

        ListView lv = (ListView) convertView.findViewById(R.id.lvopcoes);
        lv.setAdapter(adapter);
        alertDialog.show();
    }
    */

    public void openDialogHorariosSimpleAdapter(View v) {

        // Each row in the list stores country name, currency and flag
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 7; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("dia", dias[i]);
            hm.put("horario", horarios[i]);
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = {"dia", "horario"};

        // Ids of views in listview_layout
        int[] to = {R.id.dia, R.id.horario};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, aList, R.layout.item_horario, from, to);

        //AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this, R.style.CustomDialog);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View convertView = (View) inflater.inflate(R.layout.horario_funcionamento, null, false);

        // Getting a reference to listview of main.xml layout file
        Button btnFechar = (Button) convertView.findViewById(R.id.btn_fechar);
        ListView listView = (ListView) convertView.findViewById(R.id.lvopcoes);
        // Setting the adapter to the listView
        listView.setAdapter(adapter);

        alertDialog.setView(convertView);
        alertDialog.setTitle(R.string.horario_funcionamento);
        alertDialog.create();

        final AlertDialog dialog = alertDialog.create();

        btnFechar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
