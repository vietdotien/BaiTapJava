import java.util.ArrayList;

public class Bai2 {
    public static void main(String[] args) {
        ArrayList<Diem2D> ds = new ArrayList<>();

        ds.add(new Diem2D(1, 2));
        ds.add(new Diem2D(4, 6));
        ds.add(new Diem2D(2, 5));

        ds.add(new Diem3D(1, 2, 3));
        ds.add(new Diem3D(4, 0, 5));
        ds.add(new Diem3D(2, 3, 1));

        ArrayList<Diem2D> ds2D = new ArrayList<>();
        ArrayList<Diem3D> ds3D = new ArrayList<>();

        for (Diem2D d : ds) {
            if (d instanceof Diem3D) {
                ds3D.add((Diem3D) d);
            } else {
                ds2D.add(d);
            }
        }

        double tongKc2D = 0;
        for (int i = 0; i < ds2D.size() - 1; i++) {
            tongKc2D += ds2D.get(i).khoangCach(ds2D.get(i + 1));
        }

        double tongKc3D = 0;
        for (int i = 0; i < ds3D.size() - 1; i++) {
            tongKc3D += ds3D.get(i).khoangCach(ds3D.get(i + 1));
        }

        System.out.println("Tong khoang cach cac diem 2D: " + tongKc2D);
        System.out.println("Tong khoang cach cac diem 3D: " + tongKc3D);

        ArrayList<Diem2D> dsDoiXung = new ArrayList<>();
        for (Diem2D d : ds) {
            dsDoiXung.add(d.doiXung());
        }

        ds.addAll(dsDoiXung);

        System.out.println("\n--- Danh sach tat ca cac diem sau khi them doi xung ---");
        for (Diem2D d : ds) {
            d.xuat();
        }
    }
}

class Diem2D {
    protected double x;
    protected double y;

    public Diem2D() {
        this.x = 0;
        this.y = 0;
    }

    public Diem2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double khoangCach(Diem2D d) {
        return Math.sqrt(Math.pow(this.x - d.x, 2) + Math.pow(this.y - d.y, 2));
    }

    public Diem2D doiXung() {
        return new Diem2D(-this.x, -this.y);
    }

    public void tinhTien(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public void xuat() {
        System.out.println("Diem 2D: (" + x + ", " + y + ")");
    }
}

class Diem3D extends Diem2D {
    protected double z;

    public Diem3D() {
        super();
        this.z = 0;
    }

    public Diem3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double khoangCach(Diem3D d) {
        return Math.sqrt(Math.pow(this.x - d.x, 2) + Math.pow(this.y - d.y, 2) + Math.pow(this.z - d.z, 2));
    }

    @Override
    public Diem2D doiXung() {
        return new Diem3D(-this.x, -this.y, -this.z);
    }

    public void tinhTien(double dx, double dy, double dz) {
        super.tinhTien(dx, dy);
        this.z += dz;
    }

    @Override
    public void xuat() {
        System.out.println("Diem 3D: (" + x + ", " + y + ", " + z + ")");
    }
}