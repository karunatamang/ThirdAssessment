package com.example.thirdassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLogin extends AppCompatActivity implements View.OnClickListener {
    Button login;
    EditText username,password;
    String uusername,upassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        username=findViewById(R.id.et_username);
        password=findViewById(R.id.et_password);
        login=findViewById(R.id.btn_login);



        login.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_login){
            uusername=username.getText().toString();
            upassword=password.getText().toString();
            if (uusername.equals("vogue") && upassword.equals("vogue")){
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "username or password incoorect", Toast.LENGTH_SHORT).show();
            }
        }

    }
}

