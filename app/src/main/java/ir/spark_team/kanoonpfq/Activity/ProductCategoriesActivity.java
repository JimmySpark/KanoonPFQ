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

import ir.spark_team.kanoonpfq.Adapter.RecyclerProductCategoriesAdapter;
import ir.spark_team.kanoonpfq.Model.ProductCategory;
import ir.spark_team.kanoonpfq.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ProductCategoriesActivity extends AppCompatActivity {

    Context context = this;
    ImageView back;
    TextView title;
    RecyclerView recyclerProductCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_categories);
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

        //Classes
        setProductCategories();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void initView() {

        back = findViewById(R.id.back);
        title = findViewById(R.id.title);
        recyclerProductCategories = findViewById(R.id.recycler_product_category);
    }

    private void setProductCategories() {

        List<ProductCategory> productCategories = new ArrayList<>();
        productCategories.add(new ProductCategory("کتاب", R.drawable.img_book));
        productCategories.add(new ProductCategory("لوازم التحریر", R.drawable.img_stationery));
        productCategories.add(new ProductCategory("لوح فشرده بازی و انیمیشن", R.drawable.img_anim_game));
        productCategories.add(new ProductCategory("عروسک دارا و سارا", R.drawable.img_dara_sara));

        recyclerProductCategories.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerProductCategories.setAdapter(new RecyclerProductCategoriesAdapter(context, productCategories));
    }
}
