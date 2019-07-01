package ir.spark_team.kanoonpfq.Activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.uncopt.android.widget.text.justify.JustifiedTextView;

import java.util.ArrayList;
import java.util.List;

import ir.spark_team.kanoonpfq.Adapter.ClassSliderAdapter;
import ir.spark_team.kanoonpfq.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ClassInfoActivity extends AppCompatActivity {

    Context context = this;
    ImageView back;
    TextView title;
    ViewPager sliderImages;
    JustifiedTextView txtInfo;
    List<Drawable> sliderPics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_info);
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
        title.setText(getIntent().getStringExtra("title"));

        //Slider
        setSliderValues(getIntent().getStringExtra("title"));
        sliderImages.setAdapter(new ClassSliderAdapter(context, sliderPics));
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
        sliderImages = findViewById(R.id.sliderImages);
        txtInfo = findViewById(R.id.txtInfo);
    }

    private void setSliderValues(String title) {

        sliderPics = new ArrayList<>();

        switch (title) {

            case "نقاشی":
                sliderPics.add(getResources().getDrawable(R.drawable.paint1));
                sliderPics.add(getResources().getDrawable(R.drawable.paint2));
                sliderPics.add(getResources().getDrawable(R.drawable.paint3));
                break;
            case "خوشنویسی":
                sliderPics.add(getResources().getDrawable(R.drawable.handwrite1));
                sliderPics.add(getResources().getDrawable(R.drawable.handwrite2));
                sliderPics.add(getResources().getDrawable(R.drawable.handwrite3));
                break;
            case "کلاژ":
                sliderPics.add(getResources().getDrawable(R.drawable.collage1));
                sliderPics.add(getResources().getDrawable(R.drawable.collage2));
                sliderPics.add(getResources().getDrawable(R.drawable.collage3));
                break;
            default:
                sliderPics.add(getResources().getDrawable(R.drawable.img_logo));
                sliderPics.add(getResources().getDrawable(R.drawable.img_logo));
                break;
        }
    }
}
