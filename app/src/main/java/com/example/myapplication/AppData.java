package com.example.myapplication;

import java.util.ArrayList;

// Глобальное хранилище данных приложения.
// Все списки static — они живут всё время работы приложения.
// Это самый простой способ передавать данные между экранами.
public class AppData {

    // Список всех заявок
    public static ArrayList<Request> requests = new ArrayList<>();

    // Список всех заказов
    public static ArrayList<Order> orders = new ArrayList<>();

    // Счётчики id для новых записей
    public static int nextRequestId = 1;
    public static int nextOrderId = 1;

    // Заполняем тестовыми данными при первом запуске
    public static void init() {
        if (!requests.isEmpty()) return; // уже инициализировано

        requests.add(new Request(nextRequestId++,
                "Сервер Dell PowerEdge",
                "2 сервера для серверной комнаты",
                2, "Новая", "10.02.2025"));

        requests.add(new Request(nextRequestId++,
                "Принтер HP LaserJet",
                "Принтер для бухгалтерии",
                1, "В обработке", "12.02.2025"));

        orders.add(new Order(nextOrderId++,
                "Принтер HP LaserJet",
                "Иванов А.П.",
                "Сидоров В.В.",
                "45 000 ₽",
                "Срочная поставка",
                "В работе", "13.02.2025"));
    }
}
