package ir.spark_team.kanoonpfq.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import ir.spark_team.kanoonpfq.Adapter.SliderAdapter;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //Slider
        setSliderValues();
        slider.setAdapter(new SliderAdapter(context, sliderPics, sliderCaptions));
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
                        startActivity(new Intent(context, ProductsActivity.class));
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
                        startActivity(new Intent(context, ShopsActivity.class));
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
                        showAboutDialog();
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
        sliderPics.add(getResources().getDrawable(R.mipmap.img1));
        sliderPics.add(getResources().getDrawable(R.mipmap.img2));
        sliderPics.add(getResources().getDrawable(R.mipmap.img3));
        sliderCaptions.add("با حضور فدایی حسین در کانون استان قم\n" +
                "قدم به قدم نزدیک تر به تولیدات نمایشی");
        sliderCaptions.add("پس از یک هفته فعالیت\n" +
                "پایان کار غرفه فرهنگی هنری و ادبی کانون استان قم در نمایشگاه شب های فیروزه ای");
        sliderCaptions.add("با حضور دبیر انجمن سرود کانون کشور\n" +
                "کارگاه آموزشی سرود در کانون قم برگزار شد");
    }

    private void showAboutDialog() {

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_about, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(view);

        TextView txtAbout = view.findViewById(R.id.txtAbout);

        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(context.getResources().getDrawable(R.drawable.bg_dialog));
        txtAbout.setText("نام: کانون پرورش فکری کودکان و نوجوانان \n" +
                "\n" +
                "سال تاسیس: 1344 \n" +
                "\n" +
                "شخصیت حقوقی: شرکت سهامی دولتی بر اساس مصوبه قانونی مورخ 13/2/1359 \n" +
                "\n" +
                "شرایط عضویت: داشتن شرایط سنی (6-16 سال)، حضور والدین هنگام ثبت نام، پرداخت حق عضویت، دو قطعه عکس \n" +
                "\n" +
                " \n" +
                "\n" +
                "تاریخچه: \n" +
                "\n" +
                "کانون پرورش فکری کودکان و نوجوانان به عنوان یک موسسه خیریه و غیر انتفاعی بازرگانی در دی ماه سال 1344 تاسیس شد. تا سال 1358 زیر نظر هیئت امنا، هیئت مدیره و مدیر عامل فعالیت می کرد. \n" +
                "\n" +
                "بر اساس جلسه 31/2/59 شورای انقلاب جمهوری اسلامی ایران، اساس نامه کانون با تغییراتی تصویب و به صورت یک شرکت دولتی وابسته به وزارت فرهنگ و آموزش عالی درآمد و در همان سال پیش از آن که به طورکامل تحت پوشش این وزارت خانه قرار گیرد نظارت آن به وزارت آموزش و پرورش سپرده شد. \n" +
                "\n" +
                " \n" +
                "\n" +
                "هدف اصلی: \n" +
                "\n" +
                "ایجاد امکانات لازم جهت رشد و خلاقیت کودکان و نوجوانان و شکوفایی استعداد های هنری آنها بر اساس ارزشهای نظام تعلیم و تربیت اسلامی در اوقات فراغت است. \n" +
                "\n" +
                "وظایف کلی: \n" +
                "\n" +
                "یکی از مهمترین وظایف کانون، تاسیس مراکز جهت ارائه فعالیتهای فرهنگی هنری، ادبی و عرضه کتاب مخصوص کودکان و نوجوانان در نقاط مختلف کشور به منظور غنی ساختن اوقات فراغت، کشف استعداد های خلاق و ترویج ادبیات کودک و نوجوان و همچنین همکاری با سایر سازمان ها و موسساتی است که عملکرد و خدمت مشابهی با اهداف کانون دارند از وظایف کلی کانون می باشد. \n" +
                "\n" +
                " \n" +
                "\n" +
                "آدرس و شماره تلفن دفتر استان قم: \n" +
                "\n" +
                "شهرک قدس، انتهای 45 متری چمران جنوبی، ابتدای 20 متری هدایت، مجمتع فرهنگی هنری کانون پرورش فکری کودکان و نوجوانان استان قم. تلفن: 32857750 – 32857760 تلفکس: 32857800 ");
        dialog.show();

        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        width = (int) ((width) * (4.5 / 5));
        height = (int) ((height) * (4.5 / 5));
        dialog.getWindow().setLayout(width, height);
    }
}