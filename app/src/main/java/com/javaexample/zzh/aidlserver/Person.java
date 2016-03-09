package com.javaexample.zzh.aidlserver;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zzh on 16/3/6.
 */
public class Person implements Parcelable {
    String name;
    int age;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person(Parcel source) {
        this.name = source.readString();
        this.age = source.readInt();
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
