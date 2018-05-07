package face.com.zdl.testpro.kongjian.recy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.List;

import face.com.zdl.testpro.R;

/**
 * Created by 89667 on 2018/5/6.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.Holder> {

    List<RelBean> relBeans;

    public Myadapter(List<RelBean> relBeans) {
        this.relBeans = relBeans;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chex_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        holder.checkBox.setChecked(relBeans.get(position).ischek);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.checkBox.isChecked()) {
                    holder.checkBox.setChecked(true);
                    relBeans.get(position).setIschek(true);
                } else {
                    holder.checkBox.setChecked(false);
                    relBeans.get(position).setIschek(false);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return relBeans.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        CheckBox checkBox;

        public Holder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.cb);
        }
    }
}
