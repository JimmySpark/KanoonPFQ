package ir.spark_team.kanoonpfq.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ir.spark_team.kanoonpfq.Activity.ClassInfoActivity;
import ir.spark_team.kanoonpfq.Model.Class;
import ir.spark_team.kanoonpfq.R;

public class RecyclerClassesAdapter extends RecyclerView.Adapter<RecyclerClassesAdapter.RecyclerViewHolder> {

    Context context;
    List<Class> classesList;
    int lastPosition = -1;

    public RecyclerClassesAdapter(Context context, List<Class> classesList) {
        this.context = context;
        this.classesList = classesList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecyclerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_classes, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {

        final Class classes = classesList.get(position);

        holder.imgIcon.setImageResource(classes.getIcon());
        holder.txtTitle.setText(classes.getTitle());

        switch (position % 10) {

            case 0:
                holder.itemLay.setBackground(context.getResources().getDrawable(R.drawable.classes_item1));
                break;
            case 1:
                holder.itemLay.setBackground(context.getResources().getDrawable(R.drawable.classes_item2));
                break;
            case 2:
                holder.itemLay.setBackground(context.getResources().getDrawable(R.drawable.classes_item3));
                break;
            case 3:
                holder.itemLay.setBackground(context.getResources().getDrawable(R.drawable.classes_item4));
                break;
            case 4:
                holder.itemLay.setBackground(context.getResources().getDrawable(R.drawable.classes_item5));
                break;
            case 5:
                holder.itemLay.setBackground(context.getResources().getDrawable(R.drawable.classes_item6));
                break;
            case 6:
                holder.itemLay.setBackground(context.getResources().getDrawable(R.drawable.classes_item7));
                break;
            case 7:
                holder.itemLay.setBackground(context.getResources().getDrawable(R.drawable.classes_item8));
                break;
            case 8:
                holder.itemLay.setBackground(context.getResources().getDrawable(R.drawable.classes_item9));
                break;
            case 9:
                holder.itemLay.setBackground(context.getResources().getDrawable(R.drawable.classes_item10));
                break;
        }

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.item.setScaleX(0.98f);
                holder.item.setScaleY(0.98f);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        holder.item.setScaleX(1f);
                        holder.item.setScaleY(1f);
                        Intent intent = new Intent(context, ClassInfoActivity.class);
                        intent.putExtra("title", classes.getTitle());
                        context.startActivity(intent);
                        ((Activity)context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                    }
                }, 8);
            }
        });

        if (position > lastPosition) {

            holder.itemView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.zoom_in));
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return classesList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        CardView item;
        LinearLayout itemLay;
        ImageView imgIcon;
        TextView txtTitle;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            item = itemView.findViewById(R.id.item);
            itemLay = itemView.findViewById(R.id.itemLay);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            imgIcon = itemView.findViewById(R.id.imgIcon);
        }
    }
}
