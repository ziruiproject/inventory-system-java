package Service;

import Model.Barang;
import Model.Kategori;

import java.util.List;

public class InventoryService {
    private static InventoryService instance;
    private Kategori[] kategoriList;
    private Barang[] barangList;

    private InventoryService() {
        kategoriList = new Kategori[1];
        barangList = new Barang[1];
    }

    public static InventoryService getInstance() {
        if (instance == null) {
            instance = new InventoryService();
        }
        return instance;
    }

    public Kategori[] getKategoriList() {

    }

    public void addKategori(Kategori kategori) {

    }

    public Barang[] getBarangList() {

    }

    public void addBarang(Barang barang) {

    }
}
