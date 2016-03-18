package me.appa.geekly.picture.widget;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.util.Random;
import me.appa.geekly.R;

/**
 * Created by niuxm on 2016/3/17.
 */
public class PictureAdatper
        extends RecyclerView.Adapter<PictureAdatper.ItemViewHolder> {

    private ItemViewHolder.ClickListener mClickListener;


    public PictureAdatper(ItemViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
        final int iceCreamSandwichMr1 = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1;
    }


    @Override
    public PictureAdatper.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 根据viewtype判断不同类型的布局

        View view = LayoutInflater.from(parent.getContext())
                                     .inflate(R.layout.item_pic, parent, false);
        return new ItemViewHolder(view,mClickListener);
    }


    @Override
    public void onBindViewHolder(final PictureAdatper.ItemViewHolder holder, int position) {
         int [] img = new int[3];
        img [0] =R.drawable.ic_avatar;
        img [1] =R.drawable.juwan;
        img [2] =R.drawable.jujingyi;
        Random random = new Random();

       /* Bitmap bm = BitmapFactory.decodeResource(holder.item_im
                .getResources(),
                R.drawable.ic_avatar);*/

        /*Palette.from(bm).generate(new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
                if (vibrantSwatch != null) {
                    holder.item_tv.setBackgroundColor(vibrantSwatch.getRgb());
                }
            }
        });*/
        holder.item_im.setImageResource(img[random.nextInt(img.length)]);
        holder.item_tv.setText("mmmmmmmmmmmmmmmmmmm");

    }


    @Override public int getItemCount() {
        return 100;
    }


    public static class ItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener,View.OnLongClickListener{

        @Bind(R.id.item_imageview) ImageView item_im;
        @Bind(R.id.item_tv) TextView item_tv;
        private ClickListener mClickListener;


        public ItemViewHolder(View itemView, ClickListener clickListener) {

            super(itemView);
            ButterKnife.bind(this, itemView);

            this.mClickListener = clickListener;

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }


        @Override public void onClick(View v) {
            if (mClickListener == null) {
                mClickListener.onItemClicked(getAdapterPosition());
            }
        }


        @Override public boolean onLongClick(View v) {
            if (mClickListener == null) {
                mClickListener.onItemLongClickListener(getAdapterPosition());
            }
            return false;
        }


        public interface ClickListener {
            void onItemClicked(int position);

            boolean onItemLongClickListener(int position);
        }
    }

}
