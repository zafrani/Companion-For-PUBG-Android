package tech.zafrani.companionforpubg.models;


public class Categories {


    public int getCount() {
        return 1;
    }


    public Category getPosition(int position) {
        switch (position) {
            case 0:
                return new WeaponCategory();
            default:
                return new WeaponCategory();
        }
    }





}
