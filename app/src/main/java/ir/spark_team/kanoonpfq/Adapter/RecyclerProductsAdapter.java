package ir.spark_team.kanoonpfq.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ir.spark_team.kanoonpfq.Activity.ProductShowActivity;
import ir.spark_team.kanoonpfq.Model.Product;
import ir.spark_team.kanoonpfq.R;

public class RecyclerProductsAdapter extends RecyclerView.Adapter<RecyclerProductsAdapter.RecyclerViewHolder> {

    Context context;
    List<Product> productList;
    int lastPosition = -1;

    public RecyclerProductsAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecyclerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_products, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {

        final Product product = productList.get(position);

        holder.imgIcon.setImageResource(product.getImage());
        holder.txtTitle.setText(product.getTitle());

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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.itemView.setScaleX(0.98f);
                holder.itemView.setScaleY(0.98f);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        holder.itemView.setScaleX(1f);
                        holder.itemView.setScaleY(1f);

                        Intent intent = new Intent(context, ProductShowActivity.class);
                        intent.putExtra("title", product.getTitle());
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
        return productList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        LinearLayout itemLay;
        ImageView imgIcon;
        TextView txtTitle;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            itemLay = itemView.findViewById(R.id.itemLay);
            imgIcon = itemView.findViewById(R.id.imgIcon);
            txtTitle = itemView.findViewById(R.id.txtTitle);
        }
    }
}
