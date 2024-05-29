package Service;

import Model.Barang;
import Model.Kategori;

import java.util.Objects;

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
        Kategori[] copy = new Kategori[kategoriList.length];
        for (int i = 0; i < kategoriList.length; i++) {
            copy[i] = kategoriList[i];
        }
        return copy;
    }

    public void addKategori(Kategori kategori) {
        Kategori[] newArray = new Kategori[kategoriList.length + 1];
        for (int i = 0; i < kategoriList.length; i++) {
            newArray[i] = kategoriList[i];
        }
        newArray[kategoriList.length] = kategori;
        kategoriList = newArray;
        System.out.println("Kategori ditambahkan: " + kategori);
    }

    public void editKategori(Kategori updatedKategori) {
        for (int i = 0; i < kategoriList.length; i++) {
            if (kategoriList[i].getId() == updatedKategori.getId()) {
                kategoriList[i].setNama(updatedKategori.getNama());
                kategoriList[i].setUpdatedAt((int) (System.currentTimeMillis() / 1000L));
                System.out.println("Update Terakhir Kategori: " + kategoriList[i]);
                return;
            }
        }
        System.out.println("Kategori dengan id: " + updatedKategori.getId() + " tidak ditemukan.");
    }

    public void deleteKategori(String id) {
        int kategoriId = Integer.parseInt(id);
        for (int i = 0; i < kategoriList.length; i++) {
            if (kategoriList[i].getId() == kategoriId) {
                Kategori deletedKategori = kategoriList[i];
                Kategori[] newKategoriList = new Kategori[kategoriList.length - 1];
                System.arraycopy(kategoriList, 0, newKategoriList, 0, i);
                System.arraycopy(kategoriList, i + 1, newKategoriList, i, kategoriList.length - i - 1);
                kategoriList = newKategoriList;
                System.out.println("Kategori " + deletedKategori + " dihapus.");
                return;
            }
        }
        System.out.println("Kategori dengan id " + id + " tidak ditemukan.");
    }


    public Barang[] getBarangList() {
        Barang[] copy = new Barang[barangList.length];
        System.arraycopy(barangList, 0, copy, 0, barangList.length);
        return copy;
    }

    public void addBarang(Barang barang) {
        Barang[] newArray = new Barang[barangList.length + 1];
        System.arraycopy(barangList, 0, newArray, 0, barangList.length);
        newArray[barangList.length] = barang;
        barangList = newArray;
        System.out.println("Barang ditambahkan: " + barang);
    }

    public void editBarang(Barang updatedBarang) {
        for (int i = 0; i < barangList.length; i++) {
            if (barangList[i].getId() == updatedBarang.getId()) {
                barangList[i].setNama(updatedBarang.getNama());
                barangList[i].setUpdatedAt((int) (System.currentTimeMillis() / 1000L));
                System.out.println("Update Terakhir Barang: " + barangList[i]);
                return;
            }
        }
        System.out.println("Barang dengan id: " + updatedBarang.getId() + " tidak ditemukan.");
    }

    public void deleteBarang(String id) {
//        int barangId = Integer.parseInt(id);
        for (int i = 0; i < barangList.length; i++) {
            if (Objects.equals(barangList[i].getId(), id)) {
                Barang deletedBarang = barangList[i];
                Barang[] newBarangList = new Barang[barangList.length - 1];
                System.arraycopy(barangList, 0, newBarangList, 0, i);
                System.arraycopy(barangList, i + 1, newBarangList, i, barangList.length - i - 1);
                barangList = newBarangList;
                System.out.println("Barang " + deletedBarang + " dihapus.");
                return;
            }
        }
        System.out.println("Barang dengan id " + id + " tidak ditemukan.");
    }
}
