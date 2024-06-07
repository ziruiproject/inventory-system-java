package Model;

import java.time.LocalDateTime;

/**
 * Barang
 */

public class Barang {
    protected String id;
    protected String nama;
    protected int stok;
    protected String description;
    protected String kategori;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
    protected int harga;

    public Barang(String id, String nama, int stok, int harga, String description, String kategori) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.description = description;
        this.kategori = kategori;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
