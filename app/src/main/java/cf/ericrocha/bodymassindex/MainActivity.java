package cf.ericrocha.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText lg_text;
    EditText pw_text;
    private AlertDialog alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lg_text = findViewById(R.id.login_tx);
        pw_text = findViewById(R.id.pw_tx);

    }

    public void login(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setPositiveButton(R.string.al_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                lg_text.setText("");
                pw_text.setText("");
            }
        });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                lg_text.setText("");
                pw_text.setText("");
            }
        });

        String lg_tx = lg_text.getText().toString();
        String pw_tx = pw_text.getText().toString();

        if(lg_tx.equals("Admin")  && pw_tx.equals("Admin")){
            Intent intent = new Intent(this, CalcActivity.class);
            startActivity(intent);
        }else{
            builder.setTitle(R.string.al_t);
            builder.setMessage(R.string.al_m);

            if(!lg_tx.equals("Admin")){
                builder.setTitle(R.string.al_t);
                builder.setMessage(R.string.al_m_1);
            }else{
                if(!pw_tx.equals("Admin")){
                    builder.setTitle(R.string.al_t);
                    builder.setMessage(R.string.al_m_2);
                }
            }
            alert = builder.create();
            alert.show();
        }


    }
    public void exit(View view){
        finishAffinity();
    }
    @Override
    public void onBackPressed(){
        finishAffinity();
    }
}
