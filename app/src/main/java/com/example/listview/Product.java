package com.example.listview;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Product implements Parcelable {
    int id;
    String name;
    int quatity;
    int price;
    String maker;

    public Product(int id, String name, int quatity, int price, String maker) {
        this.id = id;
        this.name = name;
        this.quatity = quatity;
        this.price = price;
        this.maker = maker;
    }

    protected Product(Parcel in) {
        id = in.readInt();
        name = in.readString();
        quatity = in.readInt();
        price = in.readInt();
        maker = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(quatity);
        dest.writeInt(price);
        dest.writeString(maker);
    }
}
