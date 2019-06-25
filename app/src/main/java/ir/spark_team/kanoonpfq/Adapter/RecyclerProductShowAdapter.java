package ir.spark_team.kanoonpfq.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ir.spark_team.kanoonpfq.Model.ProductShow;
import ir.spark_team.kanoonpfq.R;

public class RecyclerProductShowAdapter extends RecyclerView.Adapter<RecyclerProductShowAdapter.RecyclerViewHolder> {

    Context context;
    List<ProductShow> productShowList;

    public RecyclerProductShowAdapter(Context context, List<ProductShow> productShowList) {
        this.context = context;
        this.productShowList = productShowList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecyclerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_product_show, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        ProductShow productShow = productShowList.get(position);

        holder.image.setImageResource(productShow.getImage());
        holder.title.setText(productShow.getTitle());
    }

    @Override
    public int getItemCount() {
        return productShowList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
        }
    }
}
