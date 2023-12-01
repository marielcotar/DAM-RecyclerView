package com.example.cafes2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cafes2.Producto;
import com.example.cafes2.R;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {

    private List<Producto> productosList;

    public ProductoAdapter(List<Producto> productosList) {
        this.productosList = productosList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Producto producto = productosList.get(position);

        holder.textViewNombre.setText(producto.getNombre());
        holder.textViewPedido.setText(producto.getPedido());

        // Define la acción de eliminar al hacer clic en el botón
        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productosList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productosList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombre;
        TextView textViewPedido;
        Button btnEliminar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
            textViewPedido = itemView.findViewById(R.id.textViewPedido);
            btnEliminar = itemView.findViewById(R.id.btnEliminar);
        }
    }
}
