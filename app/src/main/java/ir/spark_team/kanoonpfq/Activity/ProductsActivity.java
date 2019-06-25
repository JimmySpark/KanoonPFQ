package ir.spark_team.kanoonpfq.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ir.spark_team.kanoonpfq.Adapter.RecyclerProductsAdapter;
import ir.spark_team.kanoonpfq.Model.Product;
import ir.spark_team.kanoonpfq.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ProductsActivity extends AppCompatActivity {

    Context context = this;
    ImageView back;
    TextView title;
    RecyclerView recyclerProductCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        initView();

        //Back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        //Title
        title.setText(R.string.products_title);

        //Products
        setProducts();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void initView() {

        back = findViewById(R.id.back);
        title = findViewById(R.id.title);
        recyclerProductCategories = findViewById(R.id.recycler_products);
    }

    private void setProducts() {

        List<Product> productCategories = new ArrayList<>();
        productCategories.add(new Product("کتاب", R.drawable.img_book));
        productCategories.add(new Product("لوازم التحریر", R.drawable.img_stationery));
        productCategories.add(new Product("لوح فشرده بازی و انیمیشن", R.drawable.img_anim_game));
        productCategories.add(new Product("عروسک دارا و سارا", R.drawable.img_dara_sara));

        recyclerProductCategories.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerProductCategories.setAdapter(new RecyclerProductsAdapter(context, productCategories));
    }
}
