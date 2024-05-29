package Controller;

import Model.Kategori;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class KategoriController {
    private View view;
    private ArrayList<Kategori> listKategori;

    public KategoriController(View view) {
        this.view = view;
        this.listKategori = new ArrayList<>();

        // Attach listeners to the view
        view.addCategoryListener(new AddCategoryListener());
        view.editCategoryListener(new EditCategoryListener());
        view.deleteCategoryListener(new DeleteCategoryListener());
        view.viewCategoryListener(new ViewCategoryListener());
    }

    public class AddCategoryListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logic to add a category
            System.out.println("Add category");
        }
    }

    public class EditCategoryListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logic to edit a category
            System.out.println("Edit category");
        }
    }

    public class DeleteCategoryListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logic to delete a category
            System.out.println("Delete category");
        }
    }

    public class ViewCategoryListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logic to view a category
            System.out.println("View category");
        }
    }
}
