package mx.iteso.erickgarcia.sesion4intentbroadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_explicit;
    Button btn_implicit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_explicit = (Button) findViewById(R.id.btnExplicit);
        btn_explicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExplicitIntent.class);
                startActivity(intent);
            }
        });

        btn_implicit = (Button) findViewById(R.id.btnImplicit);
        btn_implicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ImplicitIntent.class);
                startActivity(intent);
            }
        });
    }
}
