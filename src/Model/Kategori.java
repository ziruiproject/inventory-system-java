package Model;

import java.time.LocalDateTime;

/**
 * Kategori
 */

public class Kategori {
    protected int id;
    protected String nama;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public Kategori(int id, String nama) {
        this.id = id;
        this.nama = nama;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Kategori() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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
}