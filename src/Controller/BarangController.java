package Controller;

import Model.Barang;
import Service.InventoryService;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BarangController {
    private View view;

    private InventoryService inventoryService;

    public BarangController(View view) {
        this.view = view;

        inventoryService = InventoryService.getInstance();

        // Sample initial data
        inventoryService.addBarang(new Barang("1", "Product A", 10, 100));
        inventoryService.addBarang(new Barang("2", "Product B", 20, 200));

        // Populate the view's table with initial data
        updateProductTable();

        // Attach listeners to the view
        view.addProductListener((ActionEvent e) -> {

        });
    }

    private void updateProductTable() {
        view.clearProductTable();
        for (Barang barang : inventoryService.getBarangList()) {
            view.addProductToTable(new Object[]{barang.getId(), barang.getNama(), barang.getStok(), barang.getHarga()});
        }
    }
}
