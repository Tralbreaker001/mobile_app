package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Экран 7: Создание заказа (менеджер)
public class CreateOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        EditText etOrderTitle      = findViewById(R.id.etOrderTitle);
        EditText etOrderCustomer   = findViewById(R.id.etOrderCustomer);
        EditText etOrderResponsible = findViewById(R.id.etOrderResponsible);
        Button   btnCreateOrder    = findViewById(R.id.btnCreateOrder);

        // Получаем индекс заявки, которую передал предыдущий экран
        int requestIndex = getIntent().getIntExtra("requestIndex", -1);

        // Если пришла заявка — предзаполняем поля её данными
        if (requestIndex >= 0 && requestIndex < AppData.requests.size()) {
            Request r = AppData.requests.get(requestIndex);
            etOrderTitle.setText(r.title);
            etOrderCustomer.setText("Иванов А.П."); // имитируем заказчика
        }

        btnCreateOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title       = etOrderTitle.getText().toString().trim();
                String customer    = etOrderCustomer.getText().toString().trim();
                String responsible = etOrderResponsible.getText().toString().trim();

                if (title.isEmpty()) {
                    Toast.makeText(CreateOrderActivity.this,
                            "Введите наименование", Toast.LENGTH_SHORT).show();
                    return;
                }

                String date = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
                        .format(new Date());

                // Создаём заказ и добавляем в общий список
                Order newOrder = new Order(
                        AppData.nextOrderId++,
                        title,
                        customer,
                        responsible,
                        "", // цена — пустая, заполнят при редактировании
                        "",
                        "В работе",
                        date
                );
                AppData.orders.add(newOrder);

                Toast.makeText(CreateOrderActivity.this,
                        "Заказ создан!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
