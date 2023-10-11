package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<FoodModel> listFoods;
    private Context context;

    public FoodAdapter(List<FoodModel> listFoods, Context context) {
        this.listFoods = listFoods;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.bind(listFoods.get(position));
    }

    @Override
    public int getItemCount() {
        if (listFoods == null || listFoods.size() == 0){
            return 0;
        }
        return listFoods.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvAddress, tvBusinessType, tvDistance, tvRate;
        ImageView img;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgViewFood);
            tvName = itemView.findViewById(R.id.txtViewName);
            tvAddress = itemView.findViewById(R.id.txtViewAddress);
            tvBusinessType = itemView.findViewById(R.id.txtViewCategory);
            tvDistance = itemView.findViewById(R.id.txtViewDistance);
            tvRate = itemView.findViewById(R.id.txtViewRating);
        }

        public void bind(FoodModel foodModel){
            img.setImageResource(foodModel.getImage());
            tvName.setText(foodModel.getName());
            tvAddress.setText(foodModel.getAddress());
            tvDistance.setText(foodModel.getDistance() + " km");
            tvRate.setText(foodModel.getRate() + "");
            tvBusinessType.setText(foodModel.getBusinessType().toString());
        }
    }
}
