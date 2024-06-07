package Controller;

import Model.Barang;
import Model.Kategori;
import Service.InventoryService;
import View.View;

import java.awt.event.ActionEvent;

public class KategoriController {
    private View view;

    private InventoryService inventoryService;

    public KategoriController(View view) {
        this.view = view;

        inventoryService = InventoryService.getInstance();

        // Attach listeners to the view
        view.addCategoryListener((ActionEvent e) -> {
            String[] kategori = view.showAddCategoryDialog();

            int id = Integer.parseInt(kategori[0]);
            String name = kategori[1];

            inventoryService.addKategori(new Kategori(id, name));

            updateKategoriTable();
        });

        view.editCategoryListener((ActionEvent e) -> {
            int selectedRow = view.getSelectedKategoriRow();
            String id = view.getSelectedKategoriId(selectedRow);

            Kategori kategori = inventoryService.getKategoriById(id);

            String[] newKategori = view.showEditCategoryDialog(kategori);

            String name = newKategori[1];

            Kategori updatedKategori = new Kategori(Integer.parseInt(id), name);

            inventoryService.updateKategori(kategori.getName(), name);
            inventoryService.editKategori(updatedKategori);

            updateKategoriTable();
            updateProductTable();
        });

        view.deleteCategoryListener((ActionEvent e) -> {
            int selectedRow = view.getSelectedKategoriRow();
            String id = view.getSelectedKategoriId(selectedRow);

            inventoryService.deleteKategori(id);

            updateKategoriTable();
        });
    }

    private void updateKategoriTable() {
        view.clearKategoriTable();
        for (Kategori kategori : inventoryService.getKategoriList()) {
            view.addKategoriToTable(
                    new Object[] { kategori.getId(), kategori.getName(), kategori.getCreatedAt(),
                            kategori.getUpdatedAt() });
        }
    }

    private void updateProductTable() {
        view.clearProductTable();
        for (Barang barang : inventoryService.getBarangList()) {
            view.addProductToTable(
                    new Object[] { barang.getId(), barang.getNama(), barang.getStok(), barang.getHarga(),
                            barang.getDescription(), barang.getKategori(), barang.getCreatedAt(),
                            barang.getUpdatedAt() });
        }
    }
}
