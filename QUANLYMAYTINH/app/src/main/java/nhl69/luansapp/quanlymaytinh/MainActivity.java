package nhl69.luansapp.quanlymaytinh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database = null;
    private Button themloai, dsmaytinh;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        themloai = (Button) findViewById(R.id.themloai);
        dsmaytinh = (Button) findViewById(R.id.quanlymaytinh);
        //Tạo database
        dbHelper = new DBHelper(this, "MayTinh.db", null, 1);

        //Tạo bảng Category
        dbHelper.QuerryData("CREATE TABLE IF NOT EXISTS Category(id integer primary key autoincrement, ten VARCHAR(200))");
        //Tạo bảng computer
        dbHelper.QuerryData("CREATE TABLE IF NOT EXISTS Computer(id integer primary key autoincrement, ten VARCHAR(200), category integer not null constraint cate references Category(id) on delete cascade)");

        //Thêm dữ liệu:


        //nút thêm loại
        themloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ThemLoai.class);
                startActivity(intent);
            }
        });

        //nút quản lý máy tính
        dsmaytinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ListOfComputer.class);
                startActivity(intent);
            }
        });
    }


//    //Kiểm tra bảng có tồn tại hay không
//    public boolean isTableExists(SQLiteDatabase database, String tableName) {
//        Cursor cursor = database.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + tableName + "'", null);
//        if (cursor != null) {
//            if (cursor.getCount() > 0) {
//                cursor.close();
//                return true;
//            }
//            cursor.close();
//        }
//        return false;
//    }
//
//    // Tạo SQL
//    @SuppressLint("WrongConstant")
//    public SQLiteDatabase getDatabase() {
//        try {
//            database = openOrCreateDatabase("Maytinh.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
//            if (database != null) {
//                if (isTableExists(database, "Category"))
//                    return database;
//                database.setLocale(Locale.getDefault());
//                database.setVersion(1);
//                String sqlCategory = "create table Category ("
//                        + "id integer primary key autoincrement,"
//                        + "ten text)";
//                database.execSQL(sqlCategory);
//
//                String sqlComputer = "create table Computer ("
//                        + "id integer primary key autoincrement,"
//                        + "name text, "
//                        + "category integer not null constraint cate references Category(id) on delete cascade)";
//                database.execSQL(sqlComputer);
//            }
//        } catch (Exception e) {
//            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
//        }
//        return database;
//    }
}