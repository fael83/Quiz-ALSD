import java.util.Scanner;

public class ClassMain13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Perpustakaan13 perpustakaan = new Perpustakaan13();
        int jumlahBuku = 0, jumlahMhs = 0;
        System.out.println("Menu Peprpustakaan:");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Tambah Mahasiswa");
        System.out.println("3. Pinjam Buku");
        System.out.println("4. Kembalikan Buku");
        System.out.println("5. Tampilkan Peminjaman");
        System.out.println("6. Keluar");

        while (true) {
            System.out.print("Pilih menu: ");
            int menu = sc.nextInt();
            if (menu == 1) {
                perpustakaan.tambahBuku();
            } if (menu == 2) {
                perpustakaan.tambahMahasiswa();;
            } if (menu == 3) {
                System.out.print("Masukkan NIM mahasiswa: ");
                String nim = sc.next();
                Mahasiswa13 mahasiswa = perpustakaan.cariMahasiswa(nim);
                if (mahasiswa != null) {
                    System.out.print("Masukkan kode buku: ");
                    String kodeBuku = sc.next();
                    Buku13 buku = perpustakaan.cariBuku(kodeBuku);
                    if (buku != null) {
                        mahasiswa.pinjamBuku(buku);
                    } else {
                        System.out.println("Buku tidak ditemukan.");
                    }
                } else {
                        System.out.println("Mahasiswa tidak ditemukan.");
                }
            } if (menu == 4) {
            } if (menu == 5) {
                perpustakaan.tampilkanPeminjaman();
            } if (menu == 6) {
                System.out.println("Thank You!");
                break;
            } 
        }
    }
}
