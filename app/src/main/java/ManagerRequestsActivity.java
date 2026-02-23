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

// Экран 6: Заявки заказчиков (менеджер видит все заявки)
public class ManagerRequestsActivity extends AppCompatActivity {

    // Индекс выбранной заявки в списке (-1 = ничего не выбрано)
    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_requests);

        ListView listRequests = findViewById(R.id.listRequests);
        Button   btnBack      = findViewById(R.id.btnBack);
        Button   btnCreateOrder = findViewById(R.id.btnCreateOrder);

        // Формируем список строк
        ArrayList<String> displayList = new ArrayList<>();
        for (Request r : AppData.requests) {
            String line = r.title + "\n"
                    + "Кол-во: " + r.quantity + " шт.   |   " + r.status + "\n"
                    + r.date;
            displayList.add(line);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_activated_1, displayList);
        listRequests.setAdapter(adapter);
        listRequests.setChoiceMode(ListView.CHOICE_MODE_SINGLE); // режим выбора одного элемента

        // Нажатие на заявку — запоминаем выбранный индекс
        listRequests.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedIndex = position;
                Toast.makeText(ManagerRequestsActivity.this,
                        "Выбрана: " + AppData.requests.get(position).title,
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Кнопка "Создать заказ" — переходим на экран создания заказа
        btnCreateOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedIndex == -1) {
                    Toast.makeText(ManagerRequestsActivity.this,
                            "Сначала выберите заявку из списка",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // Передаём индекс выбранной заявки на следующий экран
                Intent intent = new Intent(ManagerRequestsActivity.this, CreateOrderActivity.class);
                intent.putExtra("requestIndex", selectedIndex);
                startActivity(intent);
            }
        });
    }
}
