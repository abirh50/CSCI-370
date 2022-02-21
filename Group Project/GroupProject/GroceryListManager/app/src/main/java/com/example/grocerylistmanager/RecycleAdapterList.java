package com.example.grocerylistmanager;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleAdapterList extends RecyclerView.Adapter<RecycleAdapterList.MyViewHolderItem> {
    ArrayList<String> brand, type, units;
    ArrayList<Float> quantity;
    ArrayList<Boolean> checkMark;
    Context context;
    public RecycleAdapterList(Context context, ArrayList<String> brand, ArrayList<String> type, ArrayList<Float> quantity, ArrayList<String> units, ArrayList<Boolean> checkMark){
        this.brand = brand;
        this.type = type;
        this.quantity = quantity;
        this.checkMark = checkMark;
        this.units = units;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card, parent, false);
        return new MyViewHolderItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderItem holder, int position) {
        holder.brand.setText(brand.get(position));
        holder.type.setText(type.get(position));
        holder.quantity.setText("" + quantity.get(position));
        holder.units.setText(units.get(position));
        holder.checkBox.setChecked(checkMark.get(position));

    }

    @Override
    public int getItemCount() {
        return brand.size();
    }

    public class MyViewHolderItem extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        TextView brand, type, quantity, units;
        CheckBox checkBox;
        CardView cardView;
        public MyViewHolderItem(@NonNull View itemView) {
            super(itemView);
            brand = itemView.findViewById(R.id.itemBrandString);
            type = itemView.findViewById(R.id.itemTypeString);
            quantity = itemView.findViewById(R.id.quantityString);
            units = itemView.findViewById(R.id.unitsString);
            checkBox = itemView.findViewById(R.id.checkboxBoolean);
            cardView = itemView.findViewById(R.id.itemCardView);
            cardView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {

            final int CHANGE_QUANTITY = 0;
            final int DELETE_ITEM = 1;

            contextMenu.setHeaderTitle("Options");
            contextMenu.add(this.getAdapterPosition(),CHANGE_QUANTITY, Menu.NONE, "Change Quantity");
            contextMenu.add(this.getAdapterPosition(),DELETE_ITEM, Menu.NONE, "Delete Item");

        }
    }
}
