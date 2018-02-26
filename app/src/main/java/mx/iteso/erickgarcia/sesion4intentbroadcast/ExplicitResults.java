package mx.iteso.erickgarcia.sesion4intentbroadcast;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by erickgarcia on 07/02/18.
 */

public class ExplicitResults extends Activity {
    TextView getName, getCompany, getEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explicit_results);

        getName = (TextView) findViewById(R.id.textGetName);
        getCompany = (TextView) findViewById(R.id.textGetCompany);
        getEmail = (TextView) findViewById(R.id.textGetEmail);

        Bundle information = getIntent().getExtras();
        if (information != null) {
            String user_name = information.getString("user_name");
            String company_name = information.getString("company_name");
            String email = information.getString("email");
            getName.setText(user_name);
            getCompany.setText(company_name);
            getEmail.setText(email);
        }
    }
}
