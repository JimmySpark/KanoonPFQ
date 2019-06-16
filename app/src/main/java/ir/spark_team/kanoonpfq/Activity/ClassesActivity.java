package ir.spark_team.kanoonpfq.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import ir.spark_team.kanoonpfq.Adapter.RecyclerClassesAdapter;
import ir.spark_team.kanoonpfq.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ClassesActivity extends AppCompatActivity {

    Context context = this;
    ImageView back;
    RecyclerView recyclerClasses;
    List<String> titles;
    List<Integer> icons;

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
            }
        });

        //Classes
        setClasses();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void initView() {

        back = findViewById(R.id.back);
        recyclerClasses = findViewById(R.id.recycler_classes);
    }

    private void setClasses() {

        icons = new ArrayList<>();
        icons.add(R.drawable.ic_paint);
        icons.add(R.drawable.ic_drawing);
        icons.add(R.drawable.ic_hand_writing);
        icons.add(R.drawable.ic_innovation);
        icons.add(R.drawable.ic_print_color);
        icons.add(R.drawable.ic_color_game);
        icons.add(R.drawable.ic_paint_cloth);
        icons.add(R.drawable.ic_collage);
        icons.add(R.drawable.ic_vocal_group);
        icons.add(R.drawable.ic_animation);
        icons.add(R.drawable.ic_paint);
        icons.add(R.drawable.ic_drawing);
        icons.add(R.drawable.ic_hand_writing);
        icons.add(R.drawable.ic_innovation);
        icons.add(R.drawable.ic_print_color);
        icons.add(R.drawable.ic_color_game);
        icons.add(R.drawable.ic_paint_cloth);
        icons.add(R.drawable.ic_collage);
        icons.add(R.drawable.ic_vocal_group);
        icons.add(R.drawable.ic_animation);
        icons.add(R.drawable.ic_paint);
        icons.add(R.drawable.ic_drawing);
        icons.add(R.drawable.ic_hand_writing);
        icons.add(R.drawable.ic_innovation);
        icons.add(R.drawable.ic_print_color);
        icons.add(R.drawable.ic_color_game);
        icons.add(R.drawable.ic_paint_cloth);
        icons.add(R.drawable.ic_collage);
        icons.add(R.drawable.ic_vocal_group);
        icons.add(R.drawable.ic_animation);

        titles = new ArrayList<>();
        titles.add("نقاشی");
        titles.add("طراحی");
        titles.add("خوشنویسی");
        titles.add("پرورش خلاقیت هنری");
        titles.add("چاپ و رنگ");
        titles.add("رنگ و بازی");
        titles.add("نقاشی روی پارچه");
        titles.add("کلاژ");
        titles.add("سرود کودکانه");
        titles.add("انیمیشین");
        titles.add("نقاشی");
        titles.add("طراحی");
        titles.add("خوشنویسی");
        titles.add("پرورش خلاقیت هنری");
        titles.add("چاپ و رنگ");
        titles.add("رنگ و بازی");
        titles.add("نقاشی روی پارچه");
        titles.add("کلاژ");
        titles.add("سرود کودکانه");
        titles.add("انیمیشین");
        titles.add("نقاشی");
        titles.add("طراحی");
        titles.add("خوشنویسی");
        titles.add("پرورش خلاقیت هنری");
        titles.add("چاپ و رنگ");
        titles.add("رنگ و بازی");
        titles.add("نقاشی روی پارچه");
        titles.add("کلاژ");
        titles.add("سرود کودکانه");
        titles.add("انیمیشین");


        recyclerClasses.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerClasses.setAdapter(new RecyclerClassesAdapter(context, icons, titles));
        //recyclerClasses.getAdapter().notifyDataSetChanged();
    }
}
