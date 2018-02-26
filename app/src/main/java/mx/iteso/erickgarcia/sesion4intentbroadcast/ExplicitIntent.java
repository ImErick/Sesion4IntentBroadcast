package mx.iteso.erickgarcia.sesion4intentbroadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by erickgarcia on 07/02/18.
 */

public class ExplicitIntent extends Activity {

    EditText editTextName;
    EditText editTextCompany;
    EditText editTextMail;
    Button buttonSendInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explicit_intent);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextCompany = (EditText) findViewById(R.id.editTextCompany);
        editTextMail = (EditText) findViewById(R.id.editTextMail);
        buttonSendInfo = (Button) findViewById(R.id.btnSendData);

        buttonSendInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String user_name = editTextName.getText().toString();
                String company_name = editTextCompany.getText().toString();
                String email = editTextMail.getText().toString();

                if (!user_name.isEmpty() && !company_name.isEmpty() && !email.isEmpty()) {
                    Intent intent = new Intent(ExplicitIntent.this, ExplicitResults.class);
                    intent.putExtra("user_name", user_name);
                    intent.putExtra("company_name", company_name);
                    intent.putExtra("email", email);
                    startActivity(intent);
                } else {
                    Toast.makeText(ExplicitIntent.this, "Hay un campo vacio", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
