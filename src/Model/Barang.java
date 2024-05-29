package Model;

/**
 * Barang
 */

public class Barang {
    protected String id;
    protected String nama;
    protected int stok;
    protected String description;
    protected Kategori kategori;
    protected int createdAt;
    protected int updatedAt;
    protected int harga;

    public Barang(String id, String nama, int stok, int harga) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
//        this.description = description;
//        this.kategori = kategori;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt; k
    }

    public String getId(){
        return id;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStok(){
        return stok;
    }
    public void setStok(int stok){
        this.stok = stok;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description= description;
    }
    public Kategori getKategori() {
        return kategori;
    }
    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
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
    public void create(){

    }
    public void update(Barang barang){

    }
    public Barang find(String id){
        return null;
    }
    public Barang delete(String id){
        return null;
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

