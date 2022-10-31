package nhl69.luansapp.quanlymaytinh;

public class Computer {
    private int id;
    private String ten, loai;

    public Computer(int id, String ten, String loai) {
        this.id = id;
        this.ten = ten;
        this.loai = loai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
}
