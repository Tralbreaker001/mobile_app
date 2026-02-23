package com.example.myapplication;

// Класс-контейнер для хранения данных заявки
public class Request {
    public int id;
    public String title;       // наименование оборудования
    public String description; // описание
    public int quantity;       // количество
    public String status;      // "Новая", "В обработке", "Согласована", "Отклонена"
    public String date;        // дата создания

    // Конструктор — задаём все поля при создании
    public Request(int id, String title, String description, int quantity, String status, String date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.status = status;
        this.date = date;
    }
}
