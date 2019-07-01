package ir.spark_team.kanoonpfq.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ir.spark_team.kanoonpfq.Adapter.RecyclerSchools_ShopsAdapter;
import ir.spark_team.kanoonpfq.Model.School_Shop;
import ir.spark_team.kanoonpfq.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ShopsActivity extends AppCompatActivity {

    Context context = this;
    ImageView back;
    TextView title;
    RecyclerView recyclerShops;
    List<School_Shop> shops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops);
        initView();

        //Back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

        //Title
        title.setText(R.string.shops_title);

        //Schools
        setShops();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    private void initView() {

        back = findViewById(R.id.back);
        title = findViewById(R.id.title);
        recyclerShops = findViewById(R.id.recycler_shops);
    }

    private void setShops() {

        shops = new ArrayList<>();
        shops.add(new School_Shop("فروشگاه قدس", "شهرک قدس، انتهای ولی عصر 7", "32857323", "34.650274, 50.888445"));
        shops.add(new School_Shop("فروشگاه نرگس", "امامزاده ابراهیم، روبه روی شهرداری منطقه 2، انتهای بوستان نرگس", "38903861", "34.650274, 50.888445"));

        recyclerShops.setLayoutManager(new LinearLayoutManager(context));
        recyclerShops.setAdapter(new RecyclerSchools_ShopsAdapter(context, shops));
    }
}
