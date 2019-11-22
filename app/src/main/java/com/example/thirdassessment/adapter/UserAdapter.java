package com.example.thirdassessment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thirdassessment.R;
import com.example.thirdassessment.model.Users;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.myHolder> {
    List<Users> charactersList;
    public UserAdapter(List<Users> characters){
        this.charactersList= characters;
    }
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_details,parent,false);

        //inflater means kunchayi layout/design use garnai
        myHolder myHolder=new myHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, final int position) {
        final Users character=charactersList.get(position);
        holder.name.setText(character.getName());
        holder.age.setText(character.getAge());
        holder.address.setText(character.getAddress());
        holder.gender.setText(character.getGender());
        String gen= character.getGender();
        if (gen.equals("Male")){
            holder.image.setImageResource(R.drawable.male_logo);
        }
        else if (gen.equals("Female")){
            holder.image.setImageResource(R.drawable.female_logo);
        }
        else {
            holder.image.setImageResource(R.drawable.female_logo);

        }
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                charactersList.remove(character);
                notifyItemRemoved(position);
            }
        });

    }

    @Override
    public int getItemCount() {

        return charactersList.size();
    }

    public class myHolder extends RecyclerView.ViewHolder {

        TextView name,age,address,gender;
        ImageView image;
        Button delete;

        public myHolder(@NonNull View itemView) {

            super(itemView);
            name=itemView.findViewById(R.id.text_name);
            age=itemView.findViewById(R.id.text_age);
            address=itemView.findViewById(R.id.text_address);
            gender=itemView.findViewById(R.id.text_gender);
            image=itemView.findViewById(R.id.imageView);
            delete=itemView.findViewById(R.id.btn_delete);



        }

    }
}
