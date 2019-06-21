package ir.spark_team.kanoonpfq.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ir.spark_team.kanoonpfq.Model.ProductCategory;
import ir.spark_team.kanoonpfq.R;

public class RecyclerProductCategoriesAdapter extends RecyclerView.Adapter<RecyclerProductCategoriesAdapter.RecyclerViewHolder> {

    Context context;
    List<ProductCategory> productCategoryList;

    public RecyclerProductCategoriesAdapter(Context context, List<ProductCategory> productCategoryList) {
        this.context = context;
        this.productCategoryList = productCategoryList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecyclerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_product_categories, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        ProductCategory productCategory = productCategoryList.get(position);

        holder.imgIcon.setImageResource(productCategory.getImage());
        holder.txtTitle.setText(productCategory.getTitle());

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
    }

    @Override
    public int getItemCount() {
        return productCategoryList.size();
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
