import java.util.Calendar;
import java.util.Scanner;

public class CalendarApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Meminta input tahun dan bulan dari pengguna
        System.out.print("Masukkan tahun: ");
        int year = scanner.nextInt();
        
        System.out.print("Masukkan bulan (1-12): ");
        int month = scanner.nextInt();
        
        // Validasi input bulan
        if (month < 1 || month > 12) {
            System.out.println("Bulan tidak valid. Harap masukkan angka antara 1 dan 12.");
            return;
        }
        
        // Menampilkan kalender
        printCalendar(year, month);
    }

    public static void printCalendar(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        
        String[] days = {"Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"};
        
        System.out.println("\n  Kalender " + month + " - " + year);
        System.out.println("---------------------------");
        
        for (String day : days) {
            System.out.print(day + " ");
        }
        System.out.println();
        
        int firstDay = calendar.get(Calendar.DAY_OF_WEEK);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        // Cetak spasi untuk hari pertama
        for (int i = 1; i < firstDay; i++) {
            System.out.print("    ");
        }
        
        // Cetak tanggal
        for (int day = 1; day <= maxDay; day++) {
            System.out.printf("%3d ", day);
            
            if ((day + firstDay - 1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n---------------------------");
    }
}