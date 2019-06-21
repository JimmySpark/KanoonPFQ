package ir.spark_team.kanoonpfq.Model;

public class ProductCategory {

    String title;
    int image;

    public ProductCategory(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}
