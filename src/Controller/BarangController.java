package Controller;

import Model.Barang;
import Service.InventoryService;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarangController {
    private View view;

    private InventoryService inventoryService;

    public BarangController(View view) {
        this.view = view;

        inventoryService = InventoryService.getInstance();

        // Sample initial data
        // inventoryService.addBarang(new Barang("1", "Product A", 10, 100, "lorem ipsum
        // dolor sit amet", "Minuman"));
        // inventoryService.addBarang(new Barang("2", "Product B", 20, 200, "lorem ipsum
        // dolor sit amet", "Makanan"));

        // Populate the view's table with initial data

        updateProductTable();

        // Attach listeners to the view
        view.addProductListener((ActionEvent e) -> {
            String[] barang = view.showAddProductDialog(inventoryService.getAllKategoriName());

            String id = barang[0];
            String name = barang[1];
            int quantity = Integer.parseInt(barang[2]);
            int price = Integer.parseInt(barang[3]);
            String description = barang[4];
            String category = barang[5];

            inventoryService.addBarang(new Barang(id, name, quantity, price, description, category));
            updateProductTable();
        });

        view.editProductListener((ActionEvent e) -> {
            int selectedRow = view.getSelectedProductRow();
            String id = view.getSelectedProductID(selectedRow);

            Barang barang = inventoryService.getBarangById(id);

            String[] newBarang = view.showEditProductDialog(inventoryService.getAllKategoriName(), barang);

            String name = newBarang[1];
            int quantity = Integer.parseInt(newBarang[2]);
            int price = Integer.parseInt(newBarang[3]);
            String description = newBarang[4];
            String category = newBarang[5];

            Barang updatedBarang = new Barang(id, name, quantity, price, description, category);

            inventoryService.editBarang(updatedBarang);

            updateProductTable();
        });

        view.deleteProductListener((ActionEvent e) -> {
            int selectedRow = view.getSelectedProductRow();
            String id = view.getSelectedProductID(selectedRow);

            inventoryService.deleteBarang(id);

            updateProductTable();
        });
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
