import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so nhan vien n: ");
        int n = Integer.parseInt(sc.nextLine());

        NhanVien[] ds = new NhanVien[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap nhan vien thu " + (i + 1) + ":");
            ds[i] = new NhanVien();
            ds[i].nhap(sc);
        }

        int maxSnct = ds[0].getSnct();
        for (int i = 1; i < n; i++) {
            if (ds[i].getSnct() > maxSnct) {
                maxSnct = ds[i].getSnct();
            }
        }

        System.out.println("\n--- Nhan vien co so nam cong tac nhieu nhat ---");
        for (int i = 0; i < n; i++) {
            if (ds[i].getSnct() == maxSnct) {
                ds[i].xuat();
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ds[i].tinhLuong() < ds[j].tinhLuong()) {
                    NhanVien temp = ds[i];
                    ds[i] = ds[j];
                    ds[j] = temp;
                }
            }
        }

        System.out.println("\n--- Danh sach sap xep luong tu cao xuong thap ---");
        for (int i = 0; i < n; i++) {
            ds[i].xuat();
        }
    }
}

class Nguoi {
    protected String hoTen;
    protected int tuoi;

    public void nhap(Scanner sc) {
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap tuoi: ");
        tuoi = Integer.parseInt(sc.nextLine());
    }

    public void xuat() {
        System.out.print("Ho ten: " + hoTen + ", Tuoi: " + tuoi);
    }
}

class NhanVien extends Nguoi {
    private int snct;
    private double hsl;

    public int getSnct() {
        return snct;
    }

    public double tinhLuong() {
        return 1.5 * hsl + 0.2 * snct;
    }

    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap so nam cong tac: ");
        snct = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap he so luong: ");
        hsl = Double.parseDouble(sc.nextLine());
    }

    public void xuat() {
        super.xuat();
        System.out.println(", SNCT: " + snct + ", HSL: " + hsl + ", Luong: " + tinhLuong() + " trieu");
    }
}