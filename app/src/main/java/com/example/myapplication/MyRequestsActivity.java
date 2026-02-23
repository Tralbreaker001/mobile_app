package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

// Экран 4: Мои заявки (заказчик видит свой список)
public class MyRequestsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_requests);

        ListView listRequests = findViewById(R.id.listRequests);
        Button   btnBack      = findViewById(R.id.btnBack);

        // Формируем список строк для отображения
        // Каждая строка = одна заявка в виде текста
        ArrayList<String> displayList = new ArrayList<>();
        for (Request r : AppData.requests) {
            String line = r.title + "\n"
                    + "Кол-во: " + r.quantity + " шт.   |   " + r.status + "\n"
                    + r.date;
            displayList.add(line);
        }

        // ArrayAdapter — стандартный способ показать список строк в ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, // стандартный шаблон строки
                displayList
        );
        listRequests.setAdapter(adapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
