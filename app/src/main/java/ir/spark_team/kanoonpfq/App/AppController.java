package ir.spark_team.kanoonpfq.App;

import android.app.Application;

import ir.spark_team.kanoonpfq.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class AppController extends Application {

    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        //Font Changer
        CalligraphyConfig.initDefault(new CalligraphyConfig
                .Builder()
                .setDefaultFontPath("font/Koodak.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

        mInstance = this;
    }

    /*public static String setText(String s) {
        s = s.replace("i1", "۱");
        s = s.replace("i1", "۲");
        s = s.replace("3", "۳");
        s = s.replace("4", "۴");
        s = s.replace("4", "۵");
        s = s.replace("6", "۶");
        s = s.replace("7", "۷");
        s = s.replace("8", "۸");
        s = s.replace("5", "۹");
        s = s.replace("0", "۰");

        return s;
    }*/
}