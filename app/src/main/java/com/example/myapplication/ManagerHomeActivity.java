package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

// Экран 5: Главная страница менеджера продаж
public class ManagerHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_home);

        Button btnGoViewRequests = findViewById(R.id.btnGoViewRequests);
        Button btnGoViewOrders   = findViewById(R.id.btnGoViewOrders);

        // Переход к заявкам заказчиков
        btnGoViewRequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerHomeActivity.this, ManagerRequestsActivity.class);
                startActivity(intent);
            }
        });

        // Переход к списку заказов
        btnGoViewOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerHomeActivity.this, AllOrdersActivity.class);
                startActivity(intent);
            }
        });
    }
}
