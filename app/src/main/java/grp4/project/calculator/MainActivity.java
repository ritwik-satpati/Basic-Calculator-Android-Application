package grp4.project.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView tvUser, tvRes;
    Double val1, val2;
    //Integer val1pow, val2pow;
    private EditText etNum1, etNum2;

    double res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvUser = findViewById(R.id.helloName);
        tvRes = findViewById(R.id.resultText);
        etNum1 = findViewById(R.id.getNum1);
        etNum2 = findViewById(R.id.getNum2);

        SharedPreferences sharedPreferences = getSharedPreferences("loginDetails", MODE_PRIVATE);
        String name = sharedPreferences.getString("name","");
        tvUser.setText("Hello "+name+",");

    }

    public void addition(View v) {
        val1 = Double.parseDouble(etNum1.getText().toString());
        val2 = Double.parseDouble(etNum2.getText().toString());
        res = (double)val1+val2;
        tvRes.setText("Result: "+String.valueOf(res));
    }
    public void subtraction(View v) {
        val1 = Double.parseDouble(etNum1.getText().toString());
        val2 = Double.parseDouble(etNum2.getText().toString());
        res = (double)val1-val2;
        tvRes.setText("Result: "+String.valueOf(res));
    }
    public void division(View v) {
        val1 = Double.parseDouble(etNum1.getText().toString());
        val2 = Double.parseDouble(etNum2.getText().toString());
        res = (double)val1/val2;
        tvRes.setText("Result: "+String.valueOf(res));
    }
    public void multiplication(View v) {
        val1 = Double.parseDouble(etNum1.getText().toString());
        val2 = Double.parseDouble(etNum2.getText().toString());
        res = (double)val1*val2;
        tvRes.setText("Result: "+String.valueOf(res));
    }
    public void modulus(View v) {
        val1 = Double.parseDouble(etNum1.getText().toString());
        val2 = Double.parseDouble(etNum2.getText().toString());
        res = (double)val1%val2;
        tvRes.setText("Result: "+String.valueOf(res));
    }
    public void power(View v) {
        //val1pow = Integer.parseInt(etNum1.getText().toString());
        //val2pow = Integer.parseInt(etNum2.getText().toString());
        val1 = Double.parseDouble(etNum1.getText().toString());
        val2 = Double.parseDouble(etNum2.getText().toString());
        res = Math.pow(val1, val2);
        tvRes.setText("Result: "+String.valueOf(res));
    }
    public void percentage(View v) {
        val1 = Double.parseDouble(etNum1.getText().toString());
        val2 = Double.parseDouble(etNum2.getText().toString());
        res = (double)(val1/val2)*100;
        tvRes.setText("Result: "+String.valueOf(res));
    }
    public void clear(View v) {
        etNum1.getText().clear();
        etNum2.getText().clear();
        tvRes.setText("Result: ");
    }

}