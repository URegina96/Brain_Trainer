package com.example.braintrainer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTimer = findViewById(R.id.textViewTimer);
        //CountDownTimer  - это абстрактный класс, в котором можно реализовать методы (так как он нам понадобиться только один раз используем анонимный класс)
        CountDownTimer timer = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) { //метод вызывается в каждую секунду
                //получаем сколько секунд осталось и приводим результат к типу int
                int seconds = (int) (millisUntilFinished / 1000);
                seconds++;  //что бы при завершении отсчета не висело 0 на экране долго
                //выводим на экран
                textViewTimer.setText(Integer.toString(seconds));
            }

            @Override
            public void onFinish() {  //метод , который вызывается при завершении отчета
                Toast.makeText(MainActivity.this, " таймер завершен ", Toast.LENGTH_SHORT).show();
                textViewTimer.setText(Integer.toString(0)); //что бы при завершении отсчета не висело 0 на экране долго
            }
        };
        timer.start();
    }
}