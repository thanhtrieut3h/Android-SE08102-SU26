package com.example.aimentor.activities.categories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aimentor.R;
import com.example.aimentor.activities.MenuActivity;

public class AddCategoryActivity extends AppCompatActivity {
    EditText edtCategoryName, edtDescription;
    Button btnSave, btnBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        edtCategoryName = findViewById(R.id.edtCategoryName);
        edtDescription  = findViewById(R.id.edtDescription);
        btnSave = findViewById(R.id.btnSaveCategory);
        btnBack = findViewById(R.id.btnBackCategory);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddCategoryActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
