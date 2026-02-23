package com.example.myapplication;

// Класс-контейнер для хранения данных заказа
public class Order {
    public int id;
    public String title;       // наименование
    public String customer;    // заказчик
    public String responsible; // ответственный исполнитель
    public String price;       // стоимость
    public String notes;       // примечания
    public String status;      // "В работе", "Выполнен", "Отменён"
    public String date;        // дата создания

    // Конструктор — задаём все поля при создании
    public Order(int id, String title, String customer, String responsible,
                 String price, String notes, String status, String date) {
        this.id = id;
        this.title = title;
        this.customer = customer;
        this.responsible = responsible;
        this.price = price;
        this.notes = notes;
        this.status = status;
        this.date = date;
    }
}
