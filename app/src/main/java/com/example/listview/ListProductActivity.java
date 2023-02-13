package com.example.listview;

import  androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ListProductActivity extends AppCompatActivity {
    ListProduct listProduct;
    ProductAdapter  productAdapter;
    RecyclerView recyclerView;

    Button btnAdd;

    @Override
    protected void onResume() {
        super.onResume();

        recyclerView = findViewById(R.id.listproduct);
        recyclerView.setAdapter(productAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list_product);

        productAdapter  = new ProductAdapter(listProduct.getListProduct(), this);

        recyclerView = findViewById(R.id.listproduct);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(productAdapter);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);

        btnAdd = findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code xử lý khi nút "Add" được bấm
                Intent intent = new Intent(ListProductActivity.this, FormAddProductActivity.class);
                intent.putExtra("ListProduct", listProduct);
                startActivity(intent);
            }
        });
    }

    class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

        final ArrayList<Product> listProduct;
        private Context context;

        public ProductAdapter(ArrayList<Product> listProduct, Context context) {
            this.listProduct = listProduct;
            this.context = context;
        }

        @Override
        public ProductViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
            View viewProduct = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_view, parent, false);
            return new ProductViewHolder(viewProduct);
        }

        @Override
        public void onBindViewHolder(ProductViewHolder holder, int position) {
            Product product = listProduct.get(position);
            holder.textViewId.setText(String.format("ID = %d", product.id));
            holder.textViewName.setText(String.format("Tên SP : %s", product.name));
            holder.textViewQuatity.setText(String.format("Số lượng = %d", product.quatity));
            holder.textViewPrice.setText(String.format("Giá %d", product.price));
            holder.textViewMaker.setText(String.format("Maker : %s", product.maker));
        }

        @Override
        public int getItemCount() {
            return listProduct.size();
        }

        class ProductViewHolder extends RecyclerView.ViewHolder {
            TextView textViewId, textViewName, textViewQuatity, textViewPrice, textViewMaker;
            CardView card_view;

            ProductViewHolder(View itemView) {
                super(itemView);
                textViewId = itemView.findViewById(R.id.idproduct);
                textViewName = itemView.findViewById(R.id.nameproduct);
                textViewQuatity = itemView.findViewById(R.id.quatityproduct);
                textViewPrice = itemView.findViewById(R.id.priceproduct);
                textViewMaker = itemView.findViewById(R.id.makerproduct);

                card_view = itemView.findViewById(R.id.card_view);

                card_view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            Product product = listProduct.get(position);
                            Intent intent = new Intent(context, ProductDetailActivity.class);
                            intent.putExtra("product", product);
                            context.startActivity(intent);
                        }
                    }
                });
            }


        }
    }
}