package com.issonet.uzastore;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterPack extends RecyclerView.Adapter<MyAdapterPack.MyViewHolderAMI>
        implements Filterable {

    List<MainData> list;
    List<MainData> listResult;
    Activity context;



    //ajouter un constructeur prenant en entrée une liste
    public MyAdapterPack(Activity context, List<MainData> list) {
        this.list = list;
        this.context = context;
        this.listResult = list;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public MyViewHolderAMI onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row_item, viewGroup, false);


        return new MyViewHolderAMI(view);
    }

    //c'est ici que entre allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(final MyViewHolderAMI myViewHolder, final int position) {
        final MainData myObject = listResult.get(position);
        myViewHolder.bind(myObject);

    }

    @Override
    public int getItemCount() {
        return listResult.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    listResult = list;
                } else {
                    List<MainData> filteredList = new ArrayList<>();
                    for (MainData row : listResult) {

                        // name match condition. this might differ depending on your requirement
////                        // here we are looking for name or phone number match
                        if (row.getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }


                    listResult = filteredList;

                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listResult;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                listResult = (ArrayList<MainData>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    public class MyViewHolderAMI extends RecyclerView.ViewHolder {

        private TextView tv_app_name,
                curr_ver_display,txt_entree;
        private ImageView iv_app_logo;

        private Button btn_check_update;

        public MyViewHolderAMI(final View itemView) {
            super(itemView);

            iv_app_logo = itemView.findViewById(R.id.iv_app_logo);
            tv_app_name = itemView.findViewById(R.id.tv_app_name);
            curr_ver_display = itemView.findViewById(R.id.curr_ver_display);
            btn_check_update = itemView.findViewById(R.id.btn_check_update);
        }

        //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
        double solde = 0;
        public void bind(MainData myObject) {
            iv_app_logo.setImageDrawable(myObject.getLogo());
           tv_app_name.setText(myObject.getName());
           curr_ver_display.setText(myObject.getCurrentVersionName());
        }
    }

}
