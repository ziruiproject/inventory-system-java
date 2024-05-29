import Controller.BarangController;
import Controller.KategoriController;
import View.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        BarangController productController = new BarangController(view);
        KategoriController categoryController = new KategoriController(view);
    }
}
