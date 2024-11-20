package com.example.cellmax;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Map<String, List<String>> listChildItems;
        List<String> listGroupTitles;

        listGroupTitles = new ArrayList<>();
        listChildItems = new HashMap<>();

// Añadir los títulos de los grupos
        listGroupTitles.add("Cedula por primera vez");
        listGroupTitles.add("Duplicado");
        listGroupTitles.add("Certificacion");
        listGroupTitles.add("Correcciones");

// Añadir los hijos para cada grupo
        List<String> childItems1 = new ArrayList<>();
        childItems1.add("Para obtener la cédula de ciudadanía en Colombia, primero debes tener al menos 18 años y presentar una copia auténtica del registro civil de nacimiento o la tarjeta de identidad. Debes acudir a la Registraduría Nacional del Estado Civil, donde en algunos casos es necesario agendar una cita previa. ");


        List<String> childItems2 = new ArrayList<>();
        childItems2.add("Para solicitar un duplicado por pérdida o deterioro, puedes hacerlo en línea o presencialmente, presentando los documentos necesarios. Para información más detallada, visita la página web de la Registraduría.");


        List<String> childItems3 = new ArrayList<>();
        childItems3.add("Para obtener un certificado de cédula de ciudadanía en Colombia, debes dirigirte a la oficina de OPADI de la Registraduría Distrital del Estado Civil, donde puedes solicitar certificaciones excepcionales relacionadas con tu cédula, como el estado de la misma (vigente, cancelada, etc.) o información sobre documentos históricos. El trámite tiene un costo de $5.500 y se realiza de manera presencial en la sede ubicada en la calle 13 No. 37-35 SuperCADE Calle 13, con horario de atención de 8:00 a.m. a 4:00 p.m. También puedes obtener información a través de la línea telefónica 195, disponible las 24 horas.\n");


        List<String> childItems4 = new ArrayList<>();
        childItems4.add("Para realizar una corrección en tu cédula de ciudadanía en Colombia, primero debes reunir la documentación necesaria, que incluye tu cédula original y los documentos que justifiquen la corrección, como el registro civil de nacimiento o el acta de matrimonio. Luego, dirígete a la Registraduría Nacional del Estado Civil más cercana, donde podrás presentar tu solicitud de corrección junto con los documentos requeridos; es recomendable verificar si necesitas agendar una cita previa. ");


        listChildItems.put(listGroupTitles.get(0), childItems1);
        listChildItems.put(listGroupTitles.get(1), childItems2);
        listChildItems.put(listGroupTitles.get(2), childItems3);
        listChildItems.put(listGroupTitles.get(3), childItems4);

        ExpandableListView expandableListView = findViewById(R.id.expandableListView);

        MyExpandableListAdapter adapter = new MyExpandableListAdapter(this, listGroupTitles, listChildItems);
        expandableListView.setAdapter(adapter);

        ImageView imageView = findViewById(R.id.imageView6);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity6.this, MainActivity2.class);
                startActivity(intent);
            }
        });


        ImageView icono_Editar = findViewById(R.id.imageView9);
        icono_Editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity6.this, MainActivity5.class);
                startActivity(intent);
            }
        });
        ImageView icono_Home = findViewById(R.id.imageView8);
        icono_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity6.this, MainActivity4.class);
                startActivity(intent);
            }
        });
    }

    }
