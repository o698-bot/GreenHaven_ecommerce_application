package com.example.myapplication.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.NavCategoryDetailedAdapter;
import com.example.myapplication.models.NavCategoryDetailedModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

//public class NavCategoryActivity extends AppCompatActivity {
//
//    RecyclerView recyclerView;
//    List<NavCategoryDetailedModel> list;
//    NavCategoryDetailedAdapter adapter;
//    FirebaseFirestore db;
//    ProgressBar progressBar;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_nav_category);
//
//
//        progressBar = findViewById(R.id.progressbar);
//        progressBar.setVisibility(View.VISIBLE);
//        recyclerView = findViewById(R.id.nav_cat_det_rec);
//        recyclerView.setVisibility(View.GONE);
//
//        db = FirebaseFirestore.getInstance();
//        String type = getIntent().getStringExtra("type");
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        list = new ArrayList<>();
//        adapter = new NavCategoryDetailedAdapter(this,list);
//        recyclerView.setAdapter(adapter);
//
//        if (type != null && type.equalsIgnoreCase("drink")) {
//
//            db.collection("NavCategoryDetailed").whereEqualTo("type", "drink").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                @Override
//                public void onComplete(@NonNull Task<QuerySnapshot> task) {
//
//                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
//                        NavCategoryDetailedModel navCategoryDetailedModel =
//                                documentSnapshot.toObject(NavCategoryDetailedModel.class);
//                        list.add(navCategoryDetailedModel);
//                        adapter.notifyDataSetChanged();
//                        progressBar.setVisibility(View.GONE);
//                        recyclerView.setVisibility(View.VISIBLE);
//                    }
//
//                }
//            });
//        }
//
//    }
//}

public class NavCategoryActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    List<NavCategoryDetailedModel> list;
    NavCategoryDetailedAdapter adapter;
    FirebaseFirestore db;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_category);

        progressBar = findViewById(R.id.progressbar);
        recyclerView = findViewById(R.id.nav_cat_det_rec); // Initialize recyclerView here
        recyclerView.setVisibility(View.GONE); // Set visibility after initialization

        db = FirebaseFirestore.getInstance();
        String type = getIntent().getStringExtra("type");
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Moved after initialization
        list = new ArrayList<>();
        adapter = new NavCategoryDetailedAdapter(this, list);
        recyclerView.setAdapter(adapter);



        if (type != null && type.equalsIgnoreCase("drink")) {

            db.collection("NavCategoryDetailed").whereEqualTo("type", "drink").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                        NavCategoryDetailedModel navCategoryDetailedModel =
                                documentSnapshot.toObject(NavCategoryDetailedModel.class);
                        list.add(navCategoryDetailedModel);
                        adapter.notifyDataSetChanged();
                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                    }

                }
            });
        }

        if (type != null && type.equalsIgnoreCase("meat")) {

            db.collection("NavCategoryDetailed").whereEqualTo("type", "meat").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                        NavCategoryDetailedModel navCategoryDetailedModel =
                                documentSnapshot.toObject(NavCategoryDetailedModel.class);
                        list.add(navCategoryDetailedModel);
                        adapter.notifyDataSetChanged();
                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                    }

                }
            });
        }

    }
}



