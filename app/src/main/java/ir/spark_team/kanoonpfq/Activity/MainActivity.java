package ir.spark_team.kanoonpfq.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import ir.spark_team.kanoonpfq.Adapter.SliderAdapterWithViewPager;
import ir.spark_team.kanoonpfq.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    ViewPager slider;
    List<Drawable> sliderPics;
    List<String> sliderCaptions;
    CardView itemClasses;
    CardView itemSchools;
    CardView itemProducts;
    CardView itemShops;
    CardView itemAbout;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //Slider
        setSliderValues();
        slider.setAdapter(new SliderAdapterWithViewPager(context, sliderPics, sliderCaptions));
        final long[] time = {10000};
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                if (slider.getCurrentItem() == sliderPics.size() - 1) {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            slider.setCurrentItem(0);
                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            slider.setCurrentItem(slider.getCurrentItem() + 1);
                        }
                    });
                }
                time[0] = 10000;
            }
        }, 5000, time[0]);

        //<<<Set animation while changing slides
        slider.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View view, float v) {

                float abs = Math.abs(Math.abs(v) - 1);
                view.setScaleX(abs / 2 + 0.5f);
                view.setScaleY(abs / 2 + 0.5f);
            }
        });

        //Classes
        itemClasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemClasses.setScaleX(0.98f);
                itemClasses.setScaleY(0.98f);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        itemClasses.setScaleX(1f);
                        itemClasses.setScaleY(1f);
                        startActivity(new Intent(context, ClassesActivity.class));
                    }
                }, 8);
            }
        });

        //Schools
        itemSchools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemSchools.setScaleX(0.98f);
                itemSchools.setScaleY(0.98f);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        itemSchools.setScaleX(1f);
                        itemSchools.setScaleY(1f);
                        startActivity(new Intent(context, SchoolsActivity.class));
                    }
                }, 8);
            }
        });

        //Products
        itemProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemProducts.setScaleX(0.98f);
                itemProducts.setScaleY(0.98f);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        itemProducts.setScaleX(1f);
                        itemProducts.setScaleY(1f);
                        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
                    }
                }, 8);
            }
        });

        //Shops
        itemShops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemShops.setScaleX(0.98f);
                itemShops.setScaleY(0.98f);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        itemShops.setScaleX(1f);
                        itemShops.setScaleY(1f);
                        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
                    }
                }, 8);
            }
        });

        //About
        itemAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemAbout.setScaleX(0.98f);
                itemAbout.setScaleY(0.98f);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        itemAbout.setScaleX(1f);
                        itemAbout.setScaleY(1f);
                        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
                    }
                }, 8);
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void initView() {

        slider = findViewById(R.id.slider);
        itemClasses = findViewById(R.id.item_classes);
        itemSchools = findViewById(R.id.item_schools);
        itemProducts = findViewById(R.id.item_products);
        itemShops = findViewById(R.id.item_shops);
        itemAbout = findViewById(R.id.item_about);
    }

    private void setSliderValues() {

        sliderPics = new ArrayList<>();
        sliderCaptions = new ArrayList<>();
        sliderPics.add(getResources().getDrawable(R.drawable.img1));
        sliderPics.add(getResources().getDrawable(R.drawable.img2));
        sliderPics.add(getResources().getDrawable(R.drawable.img3));
        sliderCaptions.add("با حضور فدایی حسین در کانون استان قم\n" +
                "قدم به قدم نزدیک تر به تولیدات نمایشی");
        sliderCaptions.add("پس از یک هفته فعالیت\n" +
                "پایان کار غرفه فرهنگی هنری و ادبی کانون استان قم در نمایشگاه شب های فیروزه ای");
        sliderCaptions.add("با حضور دبیر انجمن سرود کانون کشور\n" +
                "کارگاه آموزشی سرود در کانون قم برگزار شد");
    }
}