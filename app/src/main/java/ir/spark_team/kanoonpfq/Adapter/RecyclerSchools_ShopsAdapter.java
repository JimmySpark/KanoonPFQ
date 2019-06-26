package ir.spark_team.kanoonpfq.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import ir.spark_team.kanoonpfq.Model.School_Shop;
import ir.spark_team.kanoonpfq.R;

public class RecyclerSchools_ShopsAdapter extends RecyclerView.Adapter<RecyclerSchools_ShopsAdapter.RecyclerViewHolder> {

    Context context;
    List<School_Shop> schoolShopList;
    int lastPosition = -1;

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

                showMore(schoolShop.getTitle(), schoolShop.getAddress(), schoolShop.getPhone(), schoolShop.getLocation());
            }
        });
        holder.showOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.showOnMap.setScaleX(0.98f);
                holder.showOnMap.setScaleY(0.98f);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        holder.showOnMap.setScaleX(1f);
                        holder.showOnMap.setScaleY(1f);
                        String uri = String.format(Locale.ENGLISH, "geo:0,0?q=%s(%s)", schoolShop.getLocation(), schoolShop.getTitle());
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                        context.startActivity(intent);
                    }
                }, 8);
            }
        });

        if (position > lastPosition) {

            holder.itemView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
            lastPosition = position;
        }
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

    private void showMore(final String title, String address, final String phone, final String location) {

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_school_info, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(view);

        TextView txtTitle = view.findViewById(R.id.txtTitle);
        TextView txtAddress = view.findViewById(R.id.txtAddress);
        TextView txtPhone = view.findViewById(R.id.txtPhone);
        final CardView call = view.findViewById(R.id.call);
        final CardView showOnMap = view.findViewById(R.id.showOnMap);

        AlertDialog dialog = builder.create();
        showOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showOnMap.setScaleX(0.98f);
                showOnMap.setScaleY(0.98f);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        showOnMap.setScaleX(1f);
                        showOnMap.setScaleY(1f);
                        Uri loc = Uri.parse(String.format(Locale.ENGLISH, "geo:0,0?q=%s(%s)", location, title));
                        Intent intent = new Intent(Intent.ACTION_VIEW, loc);
                        context.startActivity(intent);
                    }
                }, 8);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                call.setScaleX(0.98f);
                call.setScaleY(0.98f);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        call.setScaleX(1f);
                        call.setScaleY(1f);
                        Uri pho = null;
                        if (phone.length() == 8)
                            pho = Uri.parse("tel:025" + phone);
                        else if (phone.length() == 11)
                            pho = Uri.parse("tel:" + phone);
                        Intent intent1 = new Intent(Intent.ACTION_DIAL, pho);
                        context.startActivity(intent1);
                    }
                }, 8);
            }
        });
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
