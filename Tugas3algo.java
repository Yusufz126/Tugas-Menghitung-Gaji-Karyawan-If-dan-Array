import java.util.Scanner;

public class Tugas3algo {

    public static void main(String[] args) {
        // membuat scanner baru
        Scanner input = new Scanner(System.in);

        // Array untuk golongan dan Persen Lembur
        double[] gaji = { 5000000, 6500000, 9500000 };
        double[] persenLembur = { 0.30, 0.32, 0.34, 0.36, 0.38 };

        System.out.println("====== PROGRAM MENGHITUNG GAJI KARYAWAN =======");

        // Input Data Karyawan
        System.out.print("Masukkan golongan (A/B/C): ");
        char golongan = input.next().toUpperCase().charAt(0);

        // Variabel gajiPokok
        double gajiPokok = 0;

        // Validasi golongan dan ambil gaji pokok dari array
        boolean validGolongan = true;
        if (golongan == 'A') {
            gajiPokok = gaji[0];
        } else if (golongan == 'B') {
            gajiPokok = gaji[1];
        } else if (golongan == 'C') {
            gajiPokok = gaji[2];
        } else {
            validGolongan = false;
            System.out.println(">>>>>>Golongan tidak valid!<<<<<<");
            System.out.println("Masukkan golongan A, B, atau C.");
        }

        // Jika golongan valid, lanjutkan ke input jam lembur
        if (validGolongan) {
            System.out.print("Masukkan jamLembur: ");
            int jamLembur = input.nextInt();

            // Variabel gajiLembur
            double gajiLembur = 0;

            // Menghitung Gaji Lembur berdasarkan jam lembur
            if (jamLembur == 0) {
                gajiLembur = gajiPokok * 0;
            } else if (jamLembur >= 0 && jamLembur <= 5) {
                gajiLembur = gajiPokok * persenLembur[jamLembur - 1];
            } else if (jamLembur > 5) {
                gajiLembur = gajiPokok * persenLembur[4]; // untuk jam lembur lebih dari 5
            } else if (jamLembur < 0) {
                System.out.println(">>>>>>Jam lembur tidak valid!<<<<<<");
                System.out.println("Masukkan input jam lembur minimal 0");
            }

            // Menghitung total penghasilan
            double totalPenghasilan = gajiPokok + gajiLembur;

            // Menggabungkan angka jam lembur dengan kata "Jam" secara otomatis
            String jamString = jamLembur + " Jam";

            // Output Hasil Perhitungan
            System.out.println("============== SLIP GAJI KARYAWAN =============");
            System.out.printf(" Golongan      : %-22s %n", golongan);
            System.out.printf(" Jam Lembur    : %-22s %n", jamString);
            System.out.printf(" Gaji Pokok    : Rp%,.2f %n", gajiPokok);
            System.out.printf(" Gaji Lembur   : Rp%,.2f %n", gajiLembur);
            System.out.println("+---------------------------------------------+");
            System.out.printf(" Total Gaji    : Rp%,.2f %n", totalPenghasilan);
            System.out.println("===============================================");
        }
    }
}