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

public class SchoolsActivity extends AppCompatActivity {

    Context context = this;
    ImageView back;
    TextView title;
    RecyclerView recyclerSchools;
    List<School_Shop> schoolList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schools);
        initView();

        //Back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        //Title
        title.setText(R.string.schools_title);

        //Schools
        setSchools();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void initView() {

        back = findViewById(R.id.back);
        recyclerSchools = findViewById(R.id.recycler_schools);
        title = findViewById(R.id.title);
    }

    private void setSchools() {

        schoolList = new ArrayList<>();
        schoolList.add(new School_Shop("مرکز شماره 1", "بلوار امین، کوچه 18، پلاک 132", "32828596"));
        schoolList.add(new School_Shop("مرکز شماره 2", "زنبیل آباد، کوچه 6، پلاک 35", "36598745"));
        schoolList.add(new School_Shop("مرکز شماره 3", "نیروگاه، توحید 13، پلاک 231", "32535151"));
        schoolList.add(new School_Shop("مرکز شماره 4", "شهرک امام حسن، کوچه 13، داخل پارک عباس آباد", "36659695"));
        schoolList.add(new School_Shop("مرکز شماره 5", "میدان پلیس، بلوار شهید دل آذر، شهرک اندیشه، داخل فضای سبز", "37228210"));
        schoolList.add(new School_Shop("مرکز شماره 6", "خیابان 19 دی، انتهای خیابان باجک 2، داخل بوستان مهدی", "37505066"));
        schoolList.add(new School_Shop("مرکز شماره 7", "خیابان امام زاده ابراهیم، 16 متری ولیعصر، داخل فضای سبز", "38848200"));
        schoolList.add(new School_Shop("مرکز شماره 8", "خیابان امامزاده ابراهیم، روبه روی شهرداری منطقه 2، داخل بوستان نرگس", "38903835"));
        schoolList.add(new School_Shop("مرکز شماره 9", "شهرک قدس، انتهای 45 متری چمران جنوبی، ابتدای 20 متری هدایت", "32853787"));
        schoolList.add(new School_Shop("کانون زبان (شعبه بزرگسالان)", "بلوار محمد امین، 20 متری گلستان، کوچه 3، پلاک 2", "32900564"));
        schoolList.add(new School_Shop("کانون زبان (شعبه کودک و نوجوان)", "45 متری صدوق، نبش کوچه 26", "32943450 - 32923574"));
        schoolList.add(new School_Shop("کتاب خانه ی پستی", "شهرک قدس، انتهای 45 متری چمران جنوبی، ابتدای 20 متری هدایت", "32855370"));
        schoolList.add(new School_Shop("کتاب خانه ی سیار روستایی (بخش کهک و بخش مرکزی)", "شهرک قدس، انتهای 45 متری چمران جنوبی، ابتدای 20 متری هدایت", "32857760 - 32857750"));

        recyclerSchools.setLayoutManager(new LinearLayoutManager(context));
        recyclerSchools.setAdapter(new RecyclerSchools_ShopsAdapter(context, schoolList));
    }
}
