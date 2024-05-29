package Model;

/**
 * Kategori
 */

public class Kategori {
    protected int id;
    protected String nama;
    protected int createdAt;
    protected int updatedAt;

    public Kategori(int id, String nama, int createdAt, int updatedAt) {
        this.id = id;
        this.nama = nama;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Kategori() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public int getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(int updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void create() {

    }

    public void update(Kategori kategori) {
        this.nama = kategori.getNama();
        this.updatedAt = (int) (System.currentTimeMillis() / 1000L);
        System.out.println("Kategori diupdate: " + this.toString());
    }


    public static Kategori find(int id) {
        return new Kategori(id, "Nama Barang: ", (int) (System.currentTimeMillis() / 1000L), (int) (System.currentTimeMillis() / 1000L));
    }


    public static Kategori delete(int id) {
        Kategori deletedKategori = find(id);
        System.out.println("Kategori dihapus : " + deletedKategori.toString());
        return deletedKategori;
    }
}