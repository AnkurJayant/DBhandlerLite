package com.example.ankur.login;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity{
    public EditText Email, pass;
    Button btnSignup;
    TextView signin;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        Email = findViewById(R.id.ETemail);
        pass = findViewById(R.id.ETpassword);
        btnSignup = findViewById(R.id.btnSignUp);
        signin = findViewById(R.id.TVSignIn);


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String emailID, passwd;
                emailID = Email.getText().toString();
                passwd = pass.getText().toString();

                if (emailID.isEmpty()) {
                    Email.setError("Provide your E-mail first!!");
                    Email.requestFocus();
                } else if (passwd.isEmpty()) {
                    pass.setError("Set your password");
                    pass.requestFocus();
                } else if (emailID.isEmpty() && passwd.isEmpty()) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Fields Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(emailID.isEmpty() && passwd.isEmpty())) {

                    //Toast has 3 parameters:contxet,text to be displayed,duration
                    firebaseAuth.createUserWithEmailAndPassword(emailID, passwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Context context = getApplicationContext();
                            if (!task.isSuccessful()) {
                                Toast.makeText(context, "SignUP Unsuccesfull:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            } else {
                                //Intent
                                startActivity(new Intent(MainActivity.this, UserActivity.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(MainActivity.this, ActivityLogin.class);
                finish();
                startActivity(I);
            }
        });


    }
}
