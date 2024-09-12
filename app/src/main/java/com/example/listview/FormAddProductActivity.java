package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormAddProductActivity extends AppCompatActivity {

    EditText etID, etName, etQuantity, etPrice, etMaker;
    Button btnAdd, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_form_add_product);

        etID = findViewById(R.id.txtID);
        etName = findViewById(R.id.txtName);
        etQuantity = findViewById(R.id.txtQuantity);
        etPrice = findViewById(R.id.txtPrice);
        etMaker = findViewById(R.id.txtMaker);
        btnAdd = findViewById(R.id.btnAdd);
        btnBack = findViewById(R.id.btnBack);

        ListProduct listProduct = getIntent().getParcelableExtra("ListProduct");

        int id = listProduct.getListProduct().get(listProduct.getListProduct().size() - 1).id + 1;
        etID.setText(Integer.toString(id));


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                int quantity = Integer.parseInt(etQuantity.getText().toString().trim());
                int price = Integer.parseInt(etPrice.getText().toString().trim());
                String maker = etMaker.getText().toString().trim();

                Product newProduct = new Product(id, name, quantity, price, maker);


                listProduct.AddProduct(newProduct);

                Intent intent = new Intent();
                setResult(RESULT_OK, intent);

                finish();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }
}