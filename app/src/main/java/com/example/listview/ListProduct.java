package com.example.listview;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ListProduct implements Parcelable {
    private static ArrayList<Product> listProduct = new ArrayList<>();

    static {
        listProduct.add(new Product(1, "Iphone 6", 500, 1000000, "Shi"));
        listProduct.add(new Product(2, "Iphone 7", 700, 2000000, "Shi"));
        listProduct.add(new Product(3, "Sony Abc", 800, 3000000, "Shi"));
        listProduct.add(new Product(4, "Samsung XYZ", 900, 8000000, "Shi"));
        listProduct.add(new Product(5, "SP 5", 500, 4000000, "Shi"));
        listProduct.add(new Product(6, "SP 6", 700, 5000000, "Shi"));
        listProduct.add(new Product(7, "SP 7", 800, 6000000, "Shi"));
        listProduct.add(new Product(8, "SP 8", 900, 7000000, "Shi"));
    }

    protected ListProduct(Parcel in) {
    }

    public static final Creator<ListProduct> CREATOR = new Creator<ListProduct>() {
        @Override
        public ListProduct createFromParcel(Parcel in) {
            return new ListProduct(in);
        }

        @Override
        public ListProduct[] newArray(int size) {
            return new ListProduct[size];
        }
    };

    public static ArrayList<Product> getListProduct() {
        return listProduct;
    }

    public static void AddProduct(Product product) {
        listProduct.add(product);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

    }
}
