package com.example.trotun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    TextInputEditText edittextemail,edittextpassword;
    Button buttonreg;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth =FirebaseAuth.getInstance();
        edittextemail =findViewById(R.id.login);
        edittextpassword=findViewById(R.id.password);
        buttonreg =findViewById(R.id.btt);
        progressBar =findViewById(R.id.progressBar);
        textView = findViewById(R.id.loginnow);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });
        buttonreg.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             progressBar.setVisibility(View.VISIBLE);
                                             String login,password;
                                             login =String.valueOf( edittextemail.getText());
                                             password=String.valueOf(edittextpassword.getText());
                                             if(TextUtils.isEmpty(login)){
                                                 Toast.makeText(Register.this , "Entrer votre Email",Toast.LENGTH_SHORT).show();
                                                 return;
                                             }
                                             if(TextUtils.isEmpty(password)){
                                                 Toast.makeText(Register.this , "Entrer votre mot de passe",Toast.LENGTH_SHORT).show();
                                                 return;
                                             }
                                             mAuth.createUserWithEmailAndPassword(login, password)
                                                     .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                                                         @Override
                                                         public void onComplete(@NonNull Task<AuthResult> task) {
                                                             progressBar.setVisibility(View.GONE);
                                                             if (task.isSuccessful()) {
                                                                 // Sign in success, update UI with the signed-in user's information
                                                                 Toast.makeText(Register.this, "Le compte est créé avec succès",
                                                                         Toast.LENGTH_SHORT).show();
                                                                 Intent intent = new Intent(getApplicationContext(),Login.class);
                                                                 startActivity(intent);
                                                                 finish();

                                                             } else {
                                                                 // If sign in fails, display a message to the user.
                                                                 Toast.makeText(Register.this, "Authentification échouée.",
                                                                         Toast.LENGTH_SHORT).show();
                                                             }
                                                         }
                                                     });


                                         }
                                     }
        );
    }
}