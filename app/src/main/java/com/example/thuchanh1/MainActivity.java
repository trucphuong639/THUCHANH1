package com.example.thuchanh1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thuchanh1.R;

public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtAge;
    private Button btnCheck;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        btnCheck = findViewById(R.id.btnCheck);
        txtResult = findViewById(R.id.txtResult);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAge();
            }
        });
    }

    private void checkAge() {
        String name = edtName.getText().toString().trim();
        String ageText = edtAge.getText().toString().trim();

        if (name.isEmpty() || ageText.isEmpty()) {
            txtResult.setText("Vui lòng nhập đầy đủ thông tin!");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            txtResult.setText("Tuổi phải là số hợp lệ!");
            return;
        }

        String category;
        if (age < 2) {
            category = "Em bé";
        } else if (age < 6) {
            category = "Trẻ em";
        } else if (age <= 65) {
            category = "Người lớn";
        } else {
            category = "Người già";
        }

        txtResult.setText(name + " thuộc nhóm: " + category);
    }
}
