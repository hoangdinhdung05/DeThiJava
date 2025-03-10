import java.io.*;
import java.util.*;

class Person1 {
    private String hoten, ngaysinh, diachi, gioitinh;

    public Person1(String hoten, String ngaysinh, String diachi, String gioitinh) {
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
    }

    public Person1() {}

    public void nhap(Scanner sc) {
        System.out.print("Họ tên: ");
        this.hoten = sc.nextLine();
        System.out.print("Ngày sinh (dd/MM/yyyy): ");
        this.ngaysinh = sc.nextLine();
        System.out.print("Địa chỉ: ");
        this.diachi = sc.nextLine();
        System.out.print("Giới tính: ");
        this.gioitinh = sc.nextLine();
    }

    public void chuanHoa() {
        String[] arr = this.hoten.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for (String x : arr) {
            res.append(Character.toUpperCase(x.charAt(0)))
               .append(x.substring(1).toLowerCase())
               .append(" ");
        }
        this.hoten = res.toString().trim();
    }

    public String getSortHoTen() {
        String[] arr = this.hoten.split(" ");
        return arr[arr.length - 1] + " " + String.join(" ", Arrays.copyOf(arr, arr.length - 1));
    }

    public String getHoten() { return hoten; }
    public String getNgaysinh() { return ngaysinh; }
    public String getDiachi() { return diachi; }
    public String getGioitinh() { return gioitinh; }
}

class Student1 extends Person1 {
    private String msv, email;
    private double gpa;

    public Student1(String msv, String hoten, String ngaysinh, String diachi, String gioitinh, String email, double gpa) {
        super(hoten, ngaysinh, diachi, gioitinh);
        this.msv = msv;
        this.email = email;
        this.gpa = gpa;
    }

    public Student1() {}

    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Mã sinh viên: ");
        this.msv = sc.nextLine();
        System.out.print("Email: ");
        this.email = sc.nextLine();
        System.out.print("GPA: ");
        this.gpa = sc.nextDouble();
        sc.nextLine();
    }

    public String getMsv() { return msv; }
    public String getEmail() { return email; }
    public double getGpa() { return gpa; }

    @Override
    public String toString() {
        return msv + " " + getHoten() + " " + getNgaysinh() + " " + getDiachi() + " " + getGioitinh() + " " + email + " " + String.format("%.2f", gpa);
    }
}

class StudentManager {
    private static final String FILE_NAME = "sinhvien.txt";
    private static ArrayList<Student1> students = new ArrayList<>();

    public static void docFile() {
        students.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ", 7);
                students.add(new Student1(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], Double.parseDouble(parts[6])));
            }
        } catch (IOException e) {
            System.out.println("Không thể đọc file.");
        }
    }

    public static void ghiFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student1 sv : students) {
                writer.write(sv.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file.");
        }
    }

    public static void hienThiDanhSach() {
        if (students.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (Student1 sv : students) {
            System.out.println(sv);
        }
    }

    public static void xoaSinhVien(String id) {
        students.removeIf(sv -> sv.getMsv().equals(id));
        ghiFile();
        System.out.println("Đã xóa sinh viên!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        docFile();

        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Nhập sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Sắp xếp sinh viên theo GPA");
            System.out.println("4. Tìm kiếm sinh viên");
            System.out.println("5. Xóa sinh viên");
            System.out.println("6. Sắp xếp sinh viên theo họ tên");
            System.out.println("7. Thoát");
            System.out.print("Chọn: ");
            int chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    System.out.println("Số lượng sinh viên: ");
                    int n = sc.nextInt(); sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        Student1 sv = new Student1();
                        sv.nhap(sc);
                        students.add(sv);
                    }
                    ghiFile();
                    break;
                case 2:
                    hienThiDanhSach();
                    break;
                case 3:
                    students.sort(Comparator.comparingDouble(Student1::getGpa));
                    ghiFile();
                    break;
                case 4:
                    System.out.print("Nhập mã sinh viên: ");
                    String id = sc.nextLine();
                    students.stream().filter(sv -> sv.getMsv().equals(id)).forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Nhập mã sinh viên cần xóa: ");
                    xoaSinhVien(sc.nextLine());
                    break;
                case 6:
                    students.sort(Comparator.comparing(Student1::getSortHoTen));
                    ghiFile();
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }
}
