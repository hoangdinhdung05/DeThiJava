// import java.io.*;
// import java.util.*;

// //Nếu dùng ObjectInputStream thì cần implement Serializable
// //Kế thừa maker interface Serializable để chỉ ra đây là object
// //Static: để quản lí bộ nhớ tốt hơn và có thể truy cập trực tiếp mà không cần thông qua hàm khởi tạo
// //final: khai báo là duy nhất (hằng biến)
// class Person implements Serializable {
//     private static final long serialVersionUID = 1L;
//     protected String hoTen, ngaySinh, diaChi, gioiTinh;

//     public Person() {}

//     public Person(String hoTen, String ngaySinh, String diaChi, String gioiTinh) {
//         this.hoTen = hoTen;
//         this.ngaySinh = ngaySinh;
//         this.diaChi = diaChi;
//         this.gioiTinh = gioiTinh;
//     }

//     public void nhap(Scanner sc) {
//         System.out.print("Ho ten: ");
//         this.hoTen = sc.nextLine();
//         System.out.print("Ngay sinh: ");
//         this.ngaySinh = sc.nextLine();
//         System.out.print("Dia chi: ");
//         this.diaChi = sc.nextLine();
//         System.out.print("Gioi tinh: ");
//         this.gioiTinh = sc.nextLine();
//     }

//     public void hienThi() {
//         System.out.printf("%-20s %-10s %-20s %-10s ", hoTen, ngaySinh, diaChi, gioiTinh);
//     }
// }

// class NhanVien extends Person {
//     private static final long serialVersionUID = 1L;
//     private String phongBan;
//     private int thamNien, luongCoBan;
//     private float heSoLuong;

//     public NhanVien() {}

//     public NhanVien(String hoTen, String ngaySinh, String diaChi, String gioiTinh, 
//                      String phongBan, int thamNien, int luongCoBan, float heSoLuong) {
//         super(hoTen, ngaySinh, diaChi, gioiTinh);
//         this.phongBan = phongBan;
//         this.thamNien = thamNien;
//         this.luongCoBan = luongCoBan;
//         this.heSoLuong = heSoLuong;
//     }

//     public void nhap(Scanner sc) {
//         super.nhap(sc);
//         System.out.print("Phong ban (Thiet bi/Nhan su/R&D/Kinh doanh): ");
//         this.phongBan = sc.nextLine();
//         System.out.print("Tham nien: ");
//         this.thamNien = sc.nextInt();
//         System.out.print("Luong co ban: ");
//         this.luongCoBan = sc.nextInt();
//         System.out.print("He so luong: ");
//         this.heSoLuong = sc.nextFloat();
//         sc.nextLine(); // Loại bỏ ký tự xuống dòng
//     }

//     public double tinhLuongThucLinh() {
//         return luongCoBan * heSoLuong * (1 + thamNien / 100.0);
//     }

//     public void hienThi() {
//         super.hienThi();
//         System.out.printf("%-15s %-10d %-10d %-10.2f %-10.2f\n", phongBan, thamNien, luongCoBan, heSoLuong, tinhLuongThucLinh());
//     }
// }

// class QuanLyNhanVien {
//     private static final String FILE_NAME = "nhanvien.dat";
//     private static ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();

//     public static void themNhanVien(Scanner sc) {
//         NhanVien nv = new NhanVien();
//         nv.nhap(sc);
//         danhSachNhanVien.add(nv);
//     }

//     public static void hienThiDanhSach() {
//         if (danhSachNhanVien.isEmpty()) {
//             System.out.println("Danh sach trong!");
//             return;
//         }
//         System.out.printf("%-20s %-10s %-20s %-10s %-15s %-10s %-10s %-10s %-10s\n", 
//                           "Ho ten", "Ngay sinh", "Dia chi", "Gioi tinh", "Phong ban", "Tham nien", "Luong CB", "He so luong", "Luong TL");
//         for (NhanVien nv : danhSachNhanVien) {
//             nv.hienThi();
//         }
//     }

//     public static void ghiFile() {
//         try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
//             oos.writeObject(danhSachNhanVien);
//             System.out.println("Ghi file thanh cong!");
//         } catch (IOException e) {
//             System.out.println("Loi khi ghi file: " + e.getMessage());
//         }
//     }

//     @SuppressWarnings("unchecked")
//     public static void docFile() {
//         try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
//             danhSachNhanVien = (ArrayList<NhanVien>) ois.readObject();
//             System.out.println("Doc file thanh cong!");
//         } catch (IOException | ClassNotFoundException e) {
//             System.out.println("Loi khi doc file: " + e.getMessage());
//         }
//     }
// }

// public class De2 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int thaotac;
//         do {
//             System.out.println("\n=== MENU ===");
//             System.out.println("1. Them nhan vien");
//             System.out.println("2. Hien thi danh sach nhan vien");
//             System.out.println("3. Ghi file");
//             System.out.println("4. Doc file");
//             System.out.println("0. Thoat");
//             System.out.print("Chon: ");
//             thaotac = sc.nextInt();
//             sc.nextLine();
            
//             switch (thaotac) {
//                 case 1:
//                     QuanLyNhanVien.themNhanVien(sc);
//                     break;
//                 case 2:
//                     QuanLyNhanVien.hienThiDanhSach();
//                     break;
//                 case 3:
//                     QuanLyNhanVien.ghiFile();
//                     break;
//                 case 4:
//                     QuanLyNhanVien.docFile();
//                     break;
//                 case 0:
//                     System.out.println("Thoat chuong trinh.");
//                     break;
//                 default:
//                     System.out.println("Lua chon khong hop le!");
//             }
//         } while (thaotac != 0);
//         sc.close();
//     }
// }

import java.io.*;
import java.util.*;

class Person {
    protected String hoTen, ngaySinh, diaChi, gioiTinh;

    public Person() {}

    public Person(String hoTen, String ngaySinh, String diaChi, String gioiTinh) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
    }

    public void nhap(Scanner sc) {
        System.out.print("Ho ten: ");
        this.hoTen = sc.nextLine();
        System.out.print("Ngay sinh: ");
        this.ngaySinh = sc.nextLine();
        System.out.print("Dia chi: ");
        this.diaChi = sc.nextLine();
        System.out.print("Gioi tinh: ");
        this.gioiTinh = sc.nextLine();
        chHoa();
    }

    public void chHoa() {
        String[] arr = this.hoTen.trim().split("\\s+");
        String res = "";
        for(String x : arr) {
            res += Character.toUpperCase(x.charAt(0));
            for(int j = 1; j < x.length(); j++) {
                res += Character.toLowerCase(x.charAt(j));
            }
            res += " ";
        }

        //gán lại tên
        this.hoTen = res.trim();

        //Chuẩn hóa nơi sinh
        String[] arr1 = this.diaChi.trim().split("\\s+");
        String res1 = "";
        for(String x : arr1) {
            res1 += Character.toUpperCase(x.charAt(0));
            for(int y = 1; y < x.length(); y++) {
                res1 += Character.toLowerCase(x.charAt(y));
            }
            res1 += " ";
        }

        //Gán địa chỉ
        this.diaChi = res1.trim();

        //chuan hóa ngày sinh
        StringBuilder sb = new StringBuilder(this.ngaySinh);
        if(sb.charAt(2) != '/') sb.insert(0, 0);
        if(sb.charAt(5) != '/') sb.insert(3, 0);
        this.ngaySinh = sb.toString();

    }

    public void hienThi() {
        System.out.printf("%-20s %-10s %-20s %-10s ", hoTen, ngaySinh, diaChi, gioiTinh);
    }
}

class NhanVien extends Person {

    /**
     *@list
     */
    public static final String[] listPhongBan = {"Thiet bi", "Nhan su", "R&D", "Kinh doanh"};

    private String phongBan;
    private int thamNien, luongCoBan;
    private float heSoLuong;

    public NhanVien() {}

    public NhanVien(String hoTen, String ngaySinh, String diaChi, String gioiTinh, 
                     String phongBan, int thamNien, int luongCoBan, float heSoLuong) {
        super(hoTen, ngaySinh, diaChi, gioiTinh);
        this.phongBan = phongBan;
        this.thamNien = thamNien;
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
    }

    public void nhap(Scanner sc) {
        super.nhap(sc);
        do {
            System.out.print("Phong ban (Thiet bi/Nhan su/R&D/Kinh doanh): ");
            this.phongBan = sc.nextLine();
        } while(!checkPhongBan(listPhongBan, this.phongBan));
        System.out.print("Tham nien: ");
        this.thamNien = Integer.parseInt(sc.nextLine());
        System.out.print("Luong co ban: ");
        this.luongCoBan = Integer.parseInt(sc.nextLine());
        System.out.print("He so luong: ");
        this.heSoLuong = Float.parseFloat(sc.nextLine());
    }

    public boolean checkPhongBan(String[] listPhongBan, String phongBanNhanVien) {
        String check = phongBanNhanVien.toLowerCase();
        for(String x : listPhongBan) {
            // x.toLowerCase();
            if(x.toLowerCase().equals(check)) {
                return true;
            }
        }
        return false;
    }

    public double tinhLuongThucLinh() {
        return luongCoBan * heSoLuong * (1 + thamNien / 100.0);
    }

    public void hienThi() {
        super.hienThi();
        System.out.printf("%-15s %-10d %-10d %-10.2f %-10.2f\n", phongBan, thamNien, luongCoBan, heSoLuong, tinhLuongThucLinh());
    }

    @Override
    public String toString() {
        return hoTen + "," + ngaySinh + "," + diaChi + "," + gioiTinh + "," + phongBan + "," + thamNien + "," + luongCoBan + "," + heSoLuong;
    }

    public static NhanVien fromString(String line) {
        String[] parts = line.split(",");
        return new NhanVien(parts[0], parts[1], parts[2], parts[3], parts[4], 
                            Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Float.parseFloat(parts[7]));
    }
}

class QuanLyNhanVien {
    private static final String FILE_NAME = "nhanvien.txt";
    private static ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();

    public static void themNhanVien(Scanner sc) {
        NhanVien nv = new NhanVien();
        nv.nhap(sc);
        danhSachNhanVien.add(nv);
    }

    public static void hienThiDanhSach() {
        if (danhSachNhanVien.isEmpty()) {
            System.out.println("Danh sach trong!");
            return;
        }
        System.out.printf("%-20s %-10s %-20s %-10s %-15s %-10s %-10s %-10s %-10s\n", 
                          "Ho ten", "Ngay sinh", "Dia chi", "Gioi tinh", "Phong ban", "Tham nien", "Luong CB", "He so luong", "Luong TL");
        for (NhanVien nv : danhSachNhanVien) {
            nv.hienThi();
        }
    }

    public static void ghiFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (NhanVien nv : danhSachNhanVien) {
                writer.write(nv.toString());
                writer.newLine();
            }
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    public static void docFile() {
        danhSachNhanVien.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                danhSachNhanVien.add(NhanVien.fromString(line));
            }
            System.out.println("Doc file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }
}

public class De2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int thaotac;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Hien thi danh sach nhan vien");
            System.out.println("3. Ghi file");
            System.out.println("4. Doc file");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            thaotac = Integer.parseInt(sc.nextLine());

            switch (thaotac) {
                case 1:
                    QuanLyNhanVien.themNhanVien(sc);
                    break;
                case 2:
                    QuanLyNhanVien.hienThiDanhSach();
                    break;
                case 3:
                    QuanLyNhanVien.ghiFile();
                    break;
                case 4:
                    QuanLyNhanVien.docFile();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (thaotac != 0);
        sc.close();
    }
}
