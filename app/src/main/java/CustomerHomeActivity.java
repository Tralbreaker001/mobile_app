package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

// Экран 2: Главная страница заказчика
public class CustomerHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);

        Button btnGoCreateRequest = findViewById(R.id.btnGoCreateRequest);
        Button btnGoMyRequests    = findViewById(R.id.btnGoMyRequests);

        // Нажатие — переход на создание заявки
        btnGoCreateRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerHomeActivity.this, CreateRequestActivity.class);
                startActivity(intent);
            }
        });

        // Нажатие — переход на список моих заявок
        btnGoMyRequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerHomeActivity.this, MyRequestsActivity.class);
                startActivity(intent);
            }
        });
    }
}
