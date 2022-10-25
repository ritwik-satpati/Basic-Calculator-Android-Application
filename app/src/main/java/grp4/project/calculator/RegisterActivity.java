package grp4.project.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText et1,et2, et3;
    String name, uname, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et1 = findViewById(R.id.getName);
        et2 = findViewById(R.id.getUsername);
        et3 = findViewById(R.id.getPassword);
    }

    public void register(View v) {
        name = et1.getText().toString();
        uname = et2.getText().toString();
        pass = et3.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("userDetails", MODE_PRIVATE);
        SharedPreferences.Editor myeditor = sharedPreferences.edit();
        myeditor.putString("name", name);
        myeditor.putString("uname", uname);
        myeditor.putString("pass", pass);
        myeditor.commit();

        Intent log = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(log);
        finish();
    }

    public void loginActivity(View v) {
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }


}