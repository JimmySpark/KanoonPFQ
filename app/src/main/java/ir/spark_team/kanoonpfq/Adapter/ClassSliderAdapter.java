package ir.spark_team.kanoonpfq.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ir.spark_team.kanoonpfq.R;

public class ClassSliderAdapter extends PagerAdapter {

    Context context;
    List<Drawable> pics;

    public ClassSliderAdapter(Context context, List<Drawable> pics) {
        this.context = context;
        this.pics = pics;
    }

    @Override
    public int getCount() {
        return pics.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, int position) {

        final View view = LayoutInflater.from(context).inflate(R.layout.layout_class_slider, container, false);

        final ImageView img = view.findViewById(R.id.imgSlider);

        img.setImageDrawable(pics.get(position));
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }
}
