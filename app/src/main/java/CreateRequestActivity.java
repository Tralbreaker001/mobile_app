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

// Экран 3: Создание заявки
public class CreateRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_request);

        EditText etTitle       = findViewById(R.id.etTitle);
        EditText etDescription = findViewById(R.id.etDescription);
        EditText etQuantity    = findViewById(R.id.etQuantity);
        Button   btnCreate     = findViewById(R.id.btnCreate);
        Button   btnBack       = findViewById(R.id.btnBack);

        // Кнопка "Назад" — просто закрывает этот экран
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Кнопка "Создать"
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = etTitle.getText().toString().trim();

                // Проверяем: наименование обязательно
                if (title.isEmpty()) {
                    Toast.makeText(CreateRequestActivity.this,
                            "Введите наименование", Toast.LENGTH_SHORT).show();
                    return;
                }

                String description = etDescription.getText().toString().trim();

                // Количество — если не введено, ставим 1
                int quantity = 1;
                String qtyText = etQuantity.getText().toString().trim();
                if (!qtyText.isEmpty()) {
                    quantity = Integer.parseInt(qtyText);
                }

                // Текущая дата
                String date = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
                        .format(new Date());

                // Создаём новую заявку и добавляем в общий список
                Request newRequest = new Request(
                        AppData.nextRequestId++,
                        title,
                        description,
                        quantity,
                        "Новая",
                        date
                );
                AppData.requests.add(newRequest);

                Toast.makeText(CreateRequestActivity.this,
                        "Заявка создана!", Toast.LENGTH_SHORT).show();

                finish(); // возвращаемся назад
            }
        });
    }
}
