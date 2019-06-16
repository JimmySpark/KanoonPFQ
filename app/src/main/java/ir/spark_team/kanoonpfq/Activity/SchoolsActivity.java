package ir.spark_team.kanoonpfq.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import ir.spark_team.kanoonpfq.Adapter.RecyclerSchoolsAdapter;
import ir.spark_team.kanoonpfq.Model.School;
import ir.spark_team.kanoonpfq.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SchoolsActivity extends AppCompatActivity {

    Context context = this;
    ImageView back;
    RecyclerView recyclerSchools;
    List<School> schoolList;

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
    }

    private void setSchools(){

        schoolList = new ArrayList<>();
        schoolList.add(new School("مرکز شماره 1", "بلوار امین، کوچه 18، پلاک 132", "32828596"));
        schoolList.add(new School("مرکز شماره 2", "زنبیل آباد، کوچه 6، پلاک 35", "36598745"));
        schoolList.add(new School("مرکز شماره 3", "نیروگاه، توحید 13، پلاک 231", "32535151"));

        recyclerSchools.setLayoutManager(new LinearLayoutManager(context));
        recyclerSchools.setAdapter(new RecyclerSchoolsAdapter(context, schoolList));
    }
}
