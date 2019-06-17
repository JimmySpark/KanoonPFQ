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
            }
        });

        //Title
        title.setText(R.string.shops_title);

        //Schools
        setShops();
    }

    private void initView() {

        back = findViewById(R.id.back);
        title = findViewById(R.id.title);
        recyclerShops = findViewById(R.id.recycler_shops);
    }

    private void setShops() {

        shops = new ArrayList<>();
        shops.add(new School_Shop("فروشگاه قدس", "شهرک قدس، انتهای ولی عصر 7", "32857323"));
        shops.add(new School_Shop("فروشگاه نرگس", "امامزاده ابراهیم، روبه روی شهرداری منطقه 2، انتهای بوستان نرگس", "38903861"));

        recyclerShops.setLayoutManager(new LinearLayoutManager(context));
        recyclerShops.setAdapter(new RecyclerSchools_ShopsAdapter(context, shops));
    }
}
