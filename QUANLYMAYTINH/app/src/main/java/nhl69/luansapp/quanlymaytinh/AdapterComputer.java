package nhl69.luansapp.quanlymaytinh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterComputer extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Computer> arrayList;

    public AdapterComputer(Context context, int layout, List<Computer> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        Computer computers =arrayList.get(i);

        TextView id = convertView.findViewById(R.id.stt);
        TextView tenmaytinh = convertView.findViewById(R.id.tenmayds);
        TextView loaimaytinh = convertView.findViewById(R.id.tenloaids);

        id.setText(computers.getId());
        tenmaytinh.setText(computers.getTen());
        loaimaytinh.setText(computers.getLoai());

        return convertView;
    }
}
