package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

// Экран 8: Все созданные заказы (менеджер)
public class AllOrdersActivity extends AppCompatActivity {

    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_orders);

        ListView listOrders = findViewById(R.id.listOrders);
        Button   btnBack    = findViewById(R.id.btnBack);
        Button   btnModerate = findViewById(R.id.btnModerate);

        // Формируем список строк для отображения
        ArrayList<String> displayList = new ArrayList<>();
        for (Order o : AppData.orders) {
            String line = o.title + "\n"
                    + "Заказчик: " + o.customer + "   |   " + o.status + "\n"
                    + "Исполнитель: " + (o.responsible.isEmpty() ? "не назначен" : o.responsible);
            displayList.add(line);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_activated_1, displayList);
        listOrders.setAdapter(adapter);
        listOrders.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // Нажатие на заказ — запоминаем индекс
        listOrders.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedIndex = position;
                Toast.makeText(AllOrdersActivity.this,
                        "Выбран: " + AppData.orders.get(position).title,
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Кнопка "Модерирование заказа"
        btnModerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedIndex == -1) {
                    Toast.makeText(AllOrdersActivity.this,
                            "Сначала выберите заказ из списка",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // Передаём индекс выбранного заказа
                Intent intent = new Intent(AllOrdersActivity.this, EditOrderActivity.class);
                intent.putExtra("orderIndex", selectedIndex);
                startActivity(intent);
            }
        });
    }
}
