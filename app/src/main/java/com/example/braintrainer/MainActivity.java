package com.example.braintrainer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //получаем объект класса = PreferenceManager.getDefaultSharedPreferences(в качестве параметра принимает контекст); - выберем этот способ -самый быстрый, так как нам малого количества данных
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        //для того что бы занести какие-либо данные вызываем первым метод edit() - редактировать , putInt("test"-ключ ,5 - значение) - заносим данные, apply() - метод для сохранения значения
        preferences.edit().putInt("test", 5).apply();  //даже если закоментировать эту строку  и перезакрыть приложение Toast выдаст число, так как использовали постоянное хранение данных
        //получаем переменную   getInt - метод для получения необходимого значения указав тип, который нам нужен ("test" - ключ,0-значение по умолчанию, если значение отсутствует)
        int test = preferences.getInt("test", 0);
        // в виде Toast выводим значение на экран, Integer.toString(test) - метод для того что бы показать число
        Toast.makeText(this, Integer.toString(test), Toast.LENGTH_SHORT).show();
    }
}