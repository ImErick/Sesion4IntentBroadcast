package mx.iteso.erickgarcia.sesion4intentbroadcast;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by erickgarcia on 08/02/18.
 */

public class ImplicitIntent extends Activity {

    EditText editTextPhone;
    EditText editTextWeb;
    Button btnCall;
    Button btnWeb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implicit_intent);

        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextWeb = (EditText) findViewById(R.id.editWebSite);
        btnCall = (Button) findViewById(R.id.btnCalling);
        btnWeb = (Button) findViewById(R.id.btnWebSite);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = editTextPhone.getText().toString();
                if (!phoneNumber.isEmpty()) {
                    Intent intentPhone = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + phoneNumber));
                    if (checkPermission(Manifest.permission.CALL_PHONE)) {
                        startActivity(intentPhone);
                    } else
                        // TODO: agregar una funcion para agregar permisos en runtime
                        Toast.makeText(ImplicitIntent.this, "no tienes permisos", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(ImplicitIntent.this, "no hay numero", Toast.LENGTH_SHORT).show();
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = editTextWeb.getText().toString();
                if (!url.isEmpty()) {
                    Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + url));
                    startActivity(intentWeb);
                } else
                    Toast.makeText(ImplicitIntent.this, "no hay direccion web", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // check if you have the permissions
    private boolean checkPermission(String permission){
        int result = this.checkCallingOrSelfPermission(permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }
}
