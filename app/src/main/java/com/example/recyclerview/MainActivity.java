package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRcvFood;
    List<FoodModel> mListFood;
    FoodAdapter mFoodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRcvFood  = findViewById(R.id.recyclerViewFood);

        mListFood = FoodModel.getMock();

        mFoodAdapter = new FoodAdapter(mListFood, MainActivity.this);

        // tính toán trc cái kích thước của item hiển thị nhanh hơn
        mRcvFood.setHasFixedSize(true);
        mRcvFood.setAdapter(mFoodAdapter);
    }
}