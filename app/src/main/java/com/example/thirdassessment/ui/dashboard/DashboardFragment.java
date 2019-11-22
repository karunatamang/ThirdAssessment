package com.example.thirdassessment.ui.dashboard;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.thirdassessment.R;
import com.example.thirdassessment.model.Users;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;



    Button Save;
    EditText Name,Age,Address;
    RadioGroup Gender;
    RadioButton Male,Female,Others;
    String uname,uage,uaddress,ugender;
    public static List<Users> characters=new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        Save=root.findViewById(R.id.btn_save);
        Name=root.findViewById(R.id.et_name);
        Age=root.findViewById(R.id.et_age);
        Address=root.findViewById(R.id.et_address);
        Gender=root.findViewById(R.id.rg_gender);
        Male=root.findViewById(R.id.rb_male);
        Female=root.findViewById(R.id.rb_female);
        Others=root.findViewById(R.id.rb_others);


        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                Gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if(i==R.id.rb_male){
                            ugender="Male";
                        }
                        if(i==R.id.rb_female){
                            ugender="Female";

                        }
                        if(i==R.id.rb_others){
                            ugender="Others";

                        }
                    }
                });

                Save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        uname=Name.getText().toString();
                        uage=Age.getText().toString();
                        uaddress=Address.getText().toString();
                        if (validate()) {
                            characters.add(new Users(uage, uname, uaddress, ugender));
                            Toast.makeText(getContext(), "User Detail sucessfully added", Toast.LENGTH_SHORT).show();

                            Name.setText(null);
                            Age.setText(null);
                            Address.setText(null);

                        }
                    }
                });



            }
        });
        return root;
    }
    public boolean validate(){
        if (TextUtils.isEmpty(uname)){
            Name.setError("please enter your Full name");
            return false;
        }

        if (TextUtils.isEmpty(uage)){
            Age.setError("please enter your age");
            return false;
        }
        if (TextUtils.isEmpty(uaddress)){
            Address.setError("please enter your address");
            return false;
        }

        if (TextUtils.isEmpty(ugender)){
            Toast.makeText(getContext(), "please select your gender ", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }

}
