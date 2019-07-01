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

import ir.spark_team.kanoonpfq.Adapter.RecyclerClassesAdapter;
import ir.spark_team.kanoonpfq.Model.Class;
import ir.spark_team.kanoonpfq.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ClassesActivity extends AppCompatActivity {

    Context context = this;
    ImageView back;
    TextView title;
    RecyclerView recyclerClasses;
    List<Class> classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);
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
        title.setText(R.string.classes_title);

        //Classes
        setClasses();
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
        recyclerClasses = findViewById(R.id.recycler_classes);
        title = findViewById(R.id.title);
    }

    private void setClasses() {

        classes = new ArrayList<>();
        classes.add(new Class(R.drawable.ic_paint, "نقاشی"));
        classes.add(new Class(R.drawable.ic_drawing, "طراحی"));
        classes.add(new Class(R.drawable.ic_hand_writing, "خوشنویسی"));
        classes.add(new Class(R.drawable.ic_innovation, "پرورش خلاقیت هنری"));
        classes.add(new Class(R.drawable.ic_print_color, "چاپ و رنگ"));
        classes.add(new Class(R.drawable.ic_color_game, "رنگ و بازی"));
        classes.add(new Class(R.drawable.ic_paint_cloth, "نقاشی روی پارچه"));
        classes.add(new Class(R.drawable.ic_collage, "کلاژ"));
        classes.add(new Class(R.drawable.ic_vocal_group, "سرود کودکانه"));
        classes.add(new Class(R.drawable.ic_animation, "انیمیشین"));
        classes.add(new Class(R.drawable.ic_paint, "نقاشی"));
        classes.add(new Class(R.drawable.ic_drawing, "طراحی"));
        classes.add(new Class(R.drawable.ic_hand_writing, "خوشنویسی"));
        classes.add(new Class(R.drawable.ic_innovation, "پرورش خلاقیت هنری"));
        classes.add(new Class(R.drawable.ic_print_color, "چاپ و رنگ"));
        classes.add(new Class(R.drawable.ic_color_game, "رنگ و بازی"));
        classes.add(new Class(R.drawable.ic_paint_cloth, "نقاشی روی پارچه"));
        classes.add(new Class(R.drawable.ic_collage, "کلاژ"));
        classes.add(new Class(R.drawable.ic_vocal_group, "سرود کودکانه"));
        classes.add(new Class(R.drawable.ic_animation, "انیمیشین"));

        recyclerClasses.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerClasses.setAdapter(new RecyclerClassesAdapter(context, classes));
    }
}
