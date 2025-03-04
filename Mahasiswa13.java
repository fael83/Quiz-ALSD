public class Mahasiswa13 {
    public String NIM;
    public String nama;
    public Buku13[] bukuDipinjam;
    public int jumlahDipinjam;

    public Mahasiswa13(String nim, String nama) {
        this.NIM = nim;
        this.nama = nama;
        this.bukuDipinjam = new Buku13[2];
        this.jumlahDipinjam = 0;
    }

    public boolean pinjamBuku(Buku13 buku) {
        if (jumlahDipinjam >= 2) {
            System.out.println(nama + " tidak bisa meminjam lebih dari 2 buku.");
            return false;
        }
        if (buku.statusPeminjaman) {
            System.out.println("Gagal meminjam: " + buku.judulBuku + " sudah dipinjam orang lain.");
            return false;
        }
        buku.statusPeminjaman = true;
        bukuDipinjam[jumlahDipinjam++] = buku;
        System.out.println(nama + " berhasil meminjam " + buku.judulBuku);
        return true;
    }

    public void kembalikanBuku(Buku13 buku) {
        for (int i = 0; i < jumlahDipinjam; i++) {
            if (bukuDipinjam[i] == buku) {
                buku.statusPeminjaman = false;
                bukuDipinjam[i] = bukuDipinjam[--jumlahDipinjam];
                bukuDipinjam[jumlahDipinjam] = null;
                System.out.println(nama + " mengembalikan " + buku.judulBuku);
                return;
            }
        }
        System.out.println("Buku tidak ditemukan dalam daftar pinjaman " + nama);
    }
    
}
