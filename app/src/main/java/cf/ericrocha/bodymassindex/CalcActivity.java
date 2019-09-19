package cf.ericrocha.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {
    EditText w;
    EditText h;
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        w = findViewById(R.id.weight_tx);
        h = findViewById(R.id.height_tx);
        Result = findViewById(R.id.result_tx);
        getSupportActionBar().setTitle(getString(R.string.title));
    }
    public void calc(View view){

        if(w.getText().toString().length() == 0 || h.getText().toString().length() == 0){
            Result.setText(R.string.result_text_error);
        }else{
            String wt = w.getText().toString();
            Double wd = Double.parseDouble(wt);

            String ht = h.getText().toString();
            Double hd = Double.parseDouble(ht);
            double IMC;

            IMC = wd / (hd * hd) ;


            if(IMC < 18.5){
                Result.setText(R.string.result_text_2);
            }
            if(IMC > 18.5 && IMC < 24.9){
                Result.setText(R.string.result_text_3);
            }
            if(IMC > 25 && IMC < 29.9){
                Result.setText(R.string.result_text_4);
            }
            if(IMC > 30 && IMC < 34.9){
                Result.setText(R.string.result_text_5);
            }
            if(IMC > 35 && IMC < 39.9){
                Result.setText(R.string.result_text_6);
            }
            if(IMC > 40){
                Result.setText(R.string.result_text_7);
            }

        }
        clean(view);

    }
    public void exit(View view){
        finishAffinity();
    }
    public void clean(View view){
        w.setText("");
        h.setText("");
    }
    @Override
    public void onBackPressed(){
        finishAffinity();
    }
}
