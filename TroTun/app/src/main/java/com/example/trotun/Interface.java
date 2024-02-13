package com.example.trotun;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class Interface extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);
       initButtonClick2();
        initButtonClick();
    }
   protected void initButtonClick() {
        Button btn_connexion = (Button) findViewById(R.id.btn_connexion);
                btn_connexion.setOnClickListener(view -> openactivitycnx());
            }
            public void openactivitycnx(){
            Intent intent = new Intent(Interface.this,Login.class);
            startActivity(intent);
            finish();
            }
    protected void initButtonClick2() {
        Button btn_inscri = (Button) findViewById(R.id.btn_inscri);
        btn_inscri.setOnClickListener(view -> openactivityreg());
    }
    public void openactivityreg(){
        Intent intent2 = new Intent(Interface.this,Register.class);
        startActivity(intent2);
        finish();
    }

}
