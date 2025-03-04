import java.util.Scanner;

public class Perpustakaan13 {
    Scanner sc = new Scanner(System.in);
    public Buku13[] daftarBuku;
    public Mahasiswa13[] daftarMahasiswa;
    public int jumlahBuku, jumlahMahasiswa;
    
        public Perpustakaan13() {
            daftarBuku = new Buku13[5]; 
            daftarMahasiswa = new Mahasiswa13[2];  
            jumlahBuku = 0;
            jumlahMahasiswa = 0;
        }
    
        public void tambahBuku() {
            for (int i = 0; i < daftarBuku.length; i++) {
                if (jumlahBuku < 5) {
                    System.out.print("Masukkan kode buku: ");
                    String kode = sc.nextLine();
                    System.out.print("Masukkan nama buku: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan penulis: ");
                    String penulis = sc.nextLine();
                    daftarBuku[jumlahBuku++]=new Buku13(kode, nama, penulis);
                    System.out.println("Buku berhasil ditambahkan!");
                    break;
                    } else {
                        System.out.println("Gagal menambahkan buku: Kapasitas penuh!");
                    }
            }
            
        }
    
        public void tambahMahasiswa() {
            Scanner sc = new Scanner(System.in);
            if (jumlahMahasiswa < daftarMahasiswa.length) {
                System.out.print("Masukkan NIM mahasiswa: ");
                String nim = sc.nextLine();
                System.out.print("Masukkan nama mahasiswa: ");
                String nama = sc.nextLine();
                daftarMahasiswa[jumlahMahasiswa++] = new Mahasiswa13(nim, nama);
                System.out.println("Mahasiswa berhasil ditambahkan!");
            } else {
                System.out.println("Gagal menambahkan mahasiswa: Kapasitas penuh!");
            }
        }
    
        public Buku13 cariBuku(String kodeBuku) {
            for (int i = 0; i < jumlahBuku; i++) {
                if (daftarBuku[i] != null && daftarBuku[i].kodeBuku.equals(kodeBuku)) {
                    return daftarBuku[i];
                }
            }
            return null;
        }
    
        public Mahasiswa13 cariMahasiswa(String nim) {
            for (int i = 0; i < jumlahMahasiswa; i++) {
                if (daftarMahasiswa[i] != null && daftarMahasiswa[i].NIM.equals(nim)) { 
                    return daftarMahasiswa[i];
                }
            }
            return null;
        }
    
        public void tampilkanPeminjaman() {
            System.out.println("Daftar Peminjaman Buku:");
            for (int i = 0; i < jumlahMahasiswa; i++) {
                Mahasiswa13 mahasiswa = daftarMahasiswa[i];
                if (mahasiswa != null && mahasiswa.jumlahDipinjam > 0) {
                    System.out.print(mahasiswa.nama + " meminjam: ");
                    for (int j = 0; j < mahasiswa.jumlahDipinjam; j++) {
                    if (mahasiswa.bukuDipinjam[j] != null) {
                        System.out.print(mahasiswa.bukuDipinjam[j].judulBuku + ", "); // Perbaikan disini
                    }
                }
                System.out.println();
            }
        }
    }
}
