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

import ir.spark_team.kanoonpfq.Adapter.RecyclerProductShowAdapter;
import ir.spark_team.kanoonpfq.Model.ProductShow;
import ir.spark_team.kanoonpfq.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ProductShowActivity extends AppCompatActivity {

    Context context = this;
    ImageView back;
    TextView title;
    RecyclerView recyclerProductShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_show);
        initView();

        //Back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        //Title
        title.setText(getIntent().getStringExtra("title"));

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
        recyclerProductShow = findViewById(R.id.recycler_product_show);
    }

    private void setProducts() {

        List<ProductShow> productShows = new ArrayList<>();

        switch (getIntent().getStringExtra("title")) {

            case "کتاب":
                productShows.add(new ProductShow(R.drawable.book1, "کتاب کیمیاگر از پائولو کوئیلو"));
                productShows.add(new ProductShow(R.drawable.book2, "کتاب حکایت دولت و فرزانگی از مارک فیشر"));
                break;
            case "لوازم التحریر":
                productShows.add(new ProductShow(R.drawable.stationary1, "مداد نئون پاکن دار"));
                productShows.add(new ProductShow(R.drawable.stationary2, "مداد گلی"));
                productShows.add(new ProductShow(R.drawable.stationary3, "پاک کن استدلر"));
                productShows.add(new ProductShow(R.drawable.stationary4, "پاک کن رنگی"));
                productShows.add(new ProductShow(R.drawable.stationary5, "دفترچه پاپکو"));
                break;
            case "لوح فشرده بازی و انیمیشن":
                productShows.add(new ProductShow(R.drawable.anim1, "کارتون تام و جری (سرآشپز دیوانه)"));
                productShows.add(new ProductShow(R.drawable.anim2, "انیمیشن آلوین و سنجاب ها"));
                productShows.add(new ProductShow(R.drawable.anim3, "انیمیشن ماشا و خرسه"));
                productShows.add(new ProductShow(R.drawable.anim4, "کارتون هایدی"));
                productShows.add(new ProductShow(R.drawable.anim5, "کارتون تام و جری (گربه آوازخوان)"));
                productShows.add(new ProductShow(R.drawable.anim6, "کارتون تام و جری (حلقه شگفت انگیز)"));
                productShows.add(new ProductShow(R.drawable.anim7, "کارتون باب اسفنجی در تهران"));
                break;
            case "عروسک دارا و سارا":
                productShows.add(new ProductShow(R.drawable.dara_sara1, "دارا سارا سری 1"));
                productShows.add(new ProductShow(R.drawable.dara_sara2, "دارا و سارا با لباس محلی"));
                productShows.add(new ProductShow(R.drawable.dara_sara3, "دارا و سارا با لباس کرد"));
                break;
        }

        recyclerProductShow.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerProductShow.setAdapter(new RecyclerProductShowAdapter(context, productShows));
    }
}
