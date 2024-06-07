package Controller;

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

            updateProductTable();
        });

        view.deleteCategoryListener((ActionEvent e) -> {
            int selectedRow = view.getSelectedKategoriRow();
            String id = view.getSelectedKategoriId(selectedRow);

            inventoryService.deleteKategori(id);

            updateProductTable();
        });
    }

    private void updateProductTable() {
        view.clearKategoriTable();
        for (Kategori kategori : inventoryService.getKategoriList()) {
            view.addKategoriToTable(
                    new Object[] { kategori.getId(), kategori.getName(), kategori.getCreatedAt(),
                            kategori.getUpdatedAt() });
        }
    }
}
