package nhl69.luansapp.quanlymaytinh;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListOfComputer extends AppCompatActivity {
    ListView listView;
    ArrayList<Computer> arrayList;
    AdapterComputer adapterComputer;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_computer);

        listView = (ListView) findViewById(R.id.listviewcomputer);
        arrayList = new ArrayList<>();
        dbHelper = new DBHelper(this, "Maytinh.db", null, 1);

        Cursor dataComputer = dbHelper.GetData("SELECT * FROM Computer");
        while (dataComputer.moveToNext()) {
            int stt = dataComputer.getInt(1);
            String ten = dataComputer.getString(2);
            String loai = dataComputer.getString(3);
            arrayList.add(new Computer(stt, ten, loai));
        }

        adapterComputer = new AdapterComputer(ListOfComputer.this, R.layout.design_computer_list, arrayList);
        listView.setAdapter(adapterComputer);
    }
}