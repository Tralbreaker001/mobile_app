package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

// Экран 1: Авторизация
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Инициализируем тестовые данные
        AppData.init();

        // Находим элементы на экране
        EditText etLogin    = findViewById(R.id.etLogin);
        EditText etPassword = findViewById(R.id.etPassword);
        Button   btnLogin   = findViewById(R.id.btnLogin);
        TextView tvError    = findViewById(R.id.tvError);

        // Нажатие на кнопку "Войти"
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String login    = etLogin.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // Проверяем логин и пароль вручную
                if (login.equals("zakazchik") && password.equals("123")) {
                    // Переходим на экран заказчика
                    Intent intent = new Intent(LoginActivity.this, CustomerHomeActivity.class);
                    startActivity(intent);
                    finish(); // закрываем этот экран — нельзя вернуться назад

                } else if (login.equals("manager") && password.equals("123")) {
                    // Переходим на экран менеджера
                    Intent intent = new Intent(LoginActivity.this, ManagerHomeActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    // Показываем ошибку
                    tvError.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
