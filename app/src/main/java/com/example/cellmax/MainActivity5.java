package com.example.cellmax;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity5 extends AppCompatActivity {

    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;
    private static final int CAMERA_REQUEST_CODE = 101;

    private ImageView imageView11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);

        // Manejo de insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar navegación entre actividades
        ImageView imageView6 = findViewById(R.id.imageView6);
        imageView6.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity5.this, MainActivity2.class);
            startActivity(intent);
        });

        ImageView iconoInformacion = findViewById(R.id.imageView7);
        iconoInformacion.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
            startActivity(intent);
        });

        ImageView icono_Home = findViewById(R.id.imageView8);
        icono_Home.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity5.this, MainActivity4.class);
            startActivity(intent);
        });

        Button btn_Guardar = findViewById(R.id.btn_guardar);
        btn_Guardar.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity5.this, MainActivity4.class);
            startActivity(intent);
        });

        // Configurar el ImageView para tomar fotos
        imageView11 = findViewById(R.id.imageView11);
        imageView11.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                // Solicitar permisos de cámara si no están concedidos
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        CAMERA_PERMISSION_REQUEST_CODE);
            } else {
                // Iniciar la cámara si ya se tienen permisos
                abrirCamara();
            }
        });
    }

    // Método para abrir la cámara
    private void abrirCamara() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CAMERA_REQUEST_CODE);
        }
    }

    // Manejar permisos
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permiso de cámara concedido", Toast.LENGTH_SHORT).show();
                abrirCamara();
            } else {
                Toast.makeText(this, "Permiso de cámara denegado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Manejar resultado de la cámara
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView11.setImageBitmap(photo); // Mostrar la foto en el mismo ImageView
        }
    }
}
