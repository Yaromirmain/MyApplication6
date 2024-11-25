package com.example.myapplication6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editA;
    private EditText editB;
    private EditText editC;
    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editA = findViewById(R.id.editTexta);
        editB = findViewById(R.id.editTextb);
        editC = findViewById(R.id.editTextc);
        btn = findViewById(R.id.button);
        tv = findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSolve();
            }
        });
    }

    public void doSolve() {
        String str_a = editA.getText().toString();
        String str_b = editB.getText().toString();
        String str_c = editC.getText().toString();

        // Проверка на пустые поля
        if (str_a.isEmpty() || str_b.isEmpty() || str_c.isEmpty()) {
            Toast.makeText(this, "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double a = Double.parseDouble(str_a);
            double b = Double.parseDouble(str_b);
            double c = Double.parseDouble(str_c);

            // Проверка на нулевое значение a
            if (a == 0) {
                Toast.makeText(this, "Коэффициент a не может быть равен 0", Toast.LENGTH_SHORT).show();
                return;
            }

            double d = b * b - 4 * a * c;
            if (d == 0) {
                double x = -b / (2 * a);
                tv.setText("x = " + x);
            } else if (d > 0) {
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                tv.setText(String.format("x1 = %.2f, x2 = %.2f", x1, x2));
            } else {
                tv.setText(R.string.not_solve);
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Введите корректные числа", Toast.LENGTH_SHORT).show();
        }
    }
}