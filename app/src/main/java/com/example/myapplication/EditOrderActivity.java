package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// Экран 9: Модерирование заказа (менеджер)
public class EditOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_order);

        EditText etEditTitle       = findViewById(R.id.etEditTitle);
        EditText etEditResponsible = findViewById(R.id.etEditResponsible);
        EditText etEditStatus      = findViewById(R.id.etEditStatus);
        Button   btnSave           = findViewById(R.id.btnSave);

        // Получаем индекс заказа от предыдущего экрана
        int orderIndex = getIntent().getIntExtra("orderIndex", -1);

        if (orderIndex < 0 || orderIndex >= AppData.orders.size()) {
            finish();
            return;
        }

        // Достаём заказ из общего списка
        Order order = AppData.orders.get(orderIndex);

        // Заполняем поля текущими данными заказа
        etEditTitle.setText(order.title);
        etEditResponsible.setText(order.responsible);
        etEditStatus.setText(order.status);

        // Кнопка "Сохранить изменения"
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newTitle       = etEditTitle.getText().toString().trim();
                String newResponsible = etEditResponsible.getText().toString().trim();
                String newStatus      = etEditStatus.getText().toString().trim();

                if (newTitle.isEmpty()) {
                    Toast.makeText(EditOrderActivity.this,
                            "Введите наименование", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Сохраняем изменения прямо в объект (он в AppData.orders)
                order.title       = newTitle;
                order.responsible = newResponsible;
                order.status      = newStatus.isEmpty() ? "В работе" : newStatus;

                Toast.makeText(EditOrderActivity.this,
                        "Изменения сохранены!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
