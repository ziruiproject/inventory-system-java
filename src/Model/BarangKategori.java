package Model;

/**
 * BarangKategori
 */

public class BarangKategori {
    protected Barang barang;
    protected Kategori kategori;

    public BarangKategori(Barang barang, Kategori kategori) {
        this.barang = barang;
        this.kategori = kategori;
    }
    public void setBarang(Barang barang) {
        this.barang = barang;
    }
    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }
    public Barang getBarang() {
        return barang;
    }
    public Kategori getKategori() {
        return kategori;
    }
}