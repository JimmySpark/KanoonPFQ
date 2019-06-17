package ir.spark_team.kanoonpfq.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ir.spark_team.kanoonpfq.Model.School_Shop;
import ir.spark_team.kanoonpfq.R;

public class RecyclerSchools_ShopsAdapter extends RecyclerView.Adapter<RecyclerSchools_ShopsAdapter.RecyclerViewHolder> {

    Context context;
    List<School_Shop> schoolShopList;

    public RecyclerSchools_ShopsAdapter(Context context, List<School_Shop> schoolShopList) {
        this.context = context;
        this.schoolShopList = schoolShopList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecyclerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_schools, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {

        final School_Shop schoolShop = schoolShopList.get(position);

        holder.txtTitle.setText(schoolShop.getTitle());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showMore(schoolShop.getTitle(), schoolShop.getAddress(), schoolShop.getPhone());
            }
        });
        holder.showOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Open Location On Google Map
            }
        });
    }

    @Override
    public int getItemCount() {
        return schoolShopList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        CardView item;
        TextView txtTitle;
        ImageView showOnMap;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            item = itemView.findViewById(R.id.item);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            showOnMap = itemView.findViewById(R.id.showOnMap);
        }
    }

    private void showMore(String title, String address, String phone) {

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_school_info, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(view);

        TextView txtTitle = view.findViewById(R.id.txtTitle);
        TextView txtAddress = view.findViewById(R.id.txtAddress);
        TextView txtPhone = view.findViewById(R.id.txtPhone);
        CardView call = view.findViewById(R.id.call);
        CardView showOnMap = view.findViewById(R.id.showOnMap);

        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(context.getResources().getDrawable(R.drawable.bg_dialog));
        txtTitle.setText(title);
        txtAddress.setText(address);
        txtPhone.setText(phone);
        dialog.show();

        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        width = (int) ((width) * (4.5 / 5));
        dialog.getWindow().setLayout(width, LinearLayout.LayoutParams.WRAP_CONTENT);
    }
}
