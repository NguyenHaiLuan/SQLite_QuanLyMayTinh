package nhl69.luansapp.quanlymaytinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemLoai extends AppCompatActivity {

    EditText maloai, tenloai;
    Button luu;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_loai);

        tenloai = (EditText) findViewById(R.id.tenloai);
        luu = (Button) findViewById(R.id.luu);
        dbHelper = new DBHelper(this, "Maytinh.db", null, 1);

        luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenloai1 = tenloai.getText().toString().trim();
                
                if (TextUtils.isEmpty(tenloai1)){
                    Toast.makeText(ThemLoai.this, "Vui lòng nhập đầy đủ dữ liệu trước khi Lưu", Toast.LENGTH_SHORT).show();
                }
                dbHelper.QuerryData("INSERT INTO Category VALUES (null, "+  tenloai1 + ")");
            }
        });

    }

}