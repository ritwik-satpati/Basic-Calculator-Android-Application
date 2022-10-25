package grp4.project.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView tv1, tvError;
    private EditText et1, et2;
    String username, password;
    String uname, name, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv1 = findViewById(R.id.userNameView);
        et1 = findViewById(R.id.getUname);
        et2 = findViewById(R.id.getPass);
        tvError = findViewById(R.id.loginError);

        SharedPreferences sharedPreferences = getSharedPreferences("userDetails", MODE_PRIVATE);
        name = sharedPreferences.getString("name","");
        uname = sharedPreferences.getString("uname","");
        pw = sharedPreferences.getString("pass","");

    }

    public void signIn(View v) {
        username = et1.getText().toString();
        password = et2.getText().toString();
        if(username.equals(uname)) {
            if(password.equals(pw)) {
                SharedPreferences sharedPreferences = getSharedPreferences("loginDetails", MODE_PRIVATE);
                SharedPreferences.Editor LoginEditor = sharedPreferences.edit();
                LoginEditor.putString("name", name);
                LoginEditor.commit();
                Intent calc = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(calc);
                finish();
            }
            else {
                tvError.setText("Password Incorrect");
                tv1.setText(name);
            }
        }
        else {
            tvError.setText("Username Incorrect");
        }

    }

    public void registerActivity(View v) {
        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(i);
        finish();
    }

}