import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Person3 {
    //Thuộc tính lớp cha có thể dùng đc private và protected
    //Sự khác nhau
    //private: thì ta dùng getter và setter để lấy dữ liệu hoặc thay đổi dữ liệu
    //protected: gọi trực tiếp ra được
    //=>bài này dùng private
    private String hoTen, ngaySinh, diaChi, gioiTinh;

    //Contructor có tham số
    public Person3(String hoTen, String ngaySinh, String diaChi, String gioiTinh) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
    }

    //Không tham số
    public Person3() {

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
        //trim() dùng loại bỏ khoảng trắng
        //split() dùng cắt từ
        String[] a = this.hoTen.trim().split("\\s+");
        String res = "";
        for(String x : a) {
            res += Character.toUpperCase(x.charAt(0));
            for(int j = 1; j < x.length(); j++) {
                res += Character.toLowerCase(x.charAt(j));
            }
        }
        res += " ";
        //Gán lại tên
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

    public String getHoTen() {
        return hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    @Override
    public String toString() {
        return hoTen + " $ " + ngaySinh + " $ " + diaChi + " $ " + gioiTinh + " $ ";
    }
}

class NhanVien3 extends Person3 {
    /**
     *@list
     */
    public static final String[] listPhongBan = {"Thiet bi", "Nhan su", "R&D", "Kinh doanh"};

    private String phongBan;
    private int thamNien, luongCoBan;
    private float heSoLuong;

    public NhanVien3() {}

    public NhanVien3(String hoTen, String ngaySinh, String diaChi, String gioiTinh, 
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

    @Override
    public String toString() {
        return super.toString() + phongBan + " $ " + thamNien + " $ " + luongCoBan + " $ " + heSoLuong;
    }
    
    public static NhanVien3 fromString(String line) {
        String[] parts = line.split("\\$");
        return new NhanVien3(parts[0], parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5].trim()), Integer.parseInt(parts[6].trim()), Float.parseFloat(parts[7].trim()));
    }

}
    
    class QuanLyNhanVien3 {
        //tên file
        private static final String FILE_NAME = "nhanvien3.dat";
        //Cho nhân viên vào một list
        private static ArrayList<NhanVien3> nhanVien3s = new ArrayList<>(); 
    
        //thêm nhân viên
        public static void addNhanVien(Scanner sc) {
            NhanVien3 a = new NhanVien3();
            a.nhap(sc);
            nhanVien3s.add(a);
        }
    
        public static void xuatNhanVien() {
            if(nhanVien3s.isEmpty()) {
                System.out.println("Danh sach nhan vien trong");
            } else {
                for(NhanVien3 x : nhanVien3s) {
                    System.out.println(x);
                }
            }
        }
    
        //Thao tác với File: Sử dụng BufferedRead và BufferedWrite
    
        //Ghi File
        public static void ghiFile() {
            //Sử dụng try catch bắt lỗi 
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
    
                //Duyệt để ghi 
                for(NhanVien3 x : nhanVien3s) {
                    writer.write(x.toString());
                    writer.newLine();
                }
                System.out.println("Ghi File thanh cong");
                writer.close();
    
            } catch (IOException e) {
                System.out.println("Loi khi ghi File" + e.getMessage());
            }
        }
    
        //Doc file
        public static void docFile() {
            nhanVien3s.clear();
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line; 
                if((line = reader.readLine()) != null) {
                    //nếu file không trống => đọc
                    nhanVien3s.add(NhanVien3.fromString(line));
            }

        } catch (IOException e) {
            System.out.println("Loi khi doc File" + e.getMessage());
        }
    }

}

public class De3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int thaotac;
        do {

            System.out.println("\n===MENU===");
            System.out.println("1. Them nhan vien.");
            System.out.println("2. Hien thi nhan vien");
            System.out.println("3. Ghi file");
            System.out.println("4. Doc file");
            System.out.println("0. Thoat");

            thaotac = sc.nextInt();
            sc.nextLine(); //
            if(thaotac == 1) {
                QuanLyNhanVien3.addNhanVien(sc);
            }
            else if(thaotac == 2) {
                QuanLyNhanVien3.xuatNhanVien();
            }
            else if(thaotac == 3) {
                QuanLyNhanVien3.ghiFile();
            }
            else if(thaotac == 4) {
                QuanLyNhanVien3.docFile();
            }
            else if(thaotac == 0) {
                System.out.println("Thoat khoi chuong trinh");
            }
            else {
                System.out.println("Khong co thao tac duoc chon");
            }

        } while (thaotac != 0);

        sc.close();
    }

}
