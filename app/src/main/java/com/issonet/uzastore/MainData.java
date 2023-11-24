package com.issonet.uzastore;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class MainData {
    private String name,packageName,currentVersionName;

    int currentVersionCode;
    private Drawable logo;

    public MainData() {
    }

    public MainData(String name, String packageName,Drawable  logo, int currentVersionCode, String currentVersionName) {
        this.name = name;
        this.packageName = packageName;
        this.logo = logo;
        this.currentVersionCode = currentVersionCode;
        this.currentVersionName = currentVersionName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setLogo(Drawable logo) {
        this.logo = logo;
    }

    public void setCurrentVersionCode(int currentVersionCode) {
        this.currentVersionCode = currentVersionCode;
    }

    public void setCurrentVersionName(String currentVersionName) {
        this.currentVersionName = currentVersionName;
    }

    public String getName() {
        return name;
    }

    public String getPackageName() {
        return packageName;
    }

    public Drawable getLogo() {
        return logo;
    }

    public int getCurrentVersionCode() {
        return currentVersionCode;
    }

    public String getCurrentVersionName() {
        return currentVersionName;
    }
}
