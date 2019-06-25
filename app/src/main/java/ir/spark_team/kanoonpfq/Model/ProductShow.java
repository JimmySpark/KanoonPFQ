package ir.spark_team.kanoonpfq.Model;

public class ProductShow {

    int image;
    String title;

    public ProductShow(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
