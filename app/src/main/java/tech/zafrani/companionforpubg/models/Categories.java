package tech.zafrani.companionforpubg.models;


public class Categories {


    public int getCount() {
        return 1;
    }


    public Category getPosition(int position) {
        switch (position) {
            case 0:
                break;
            default:

        }
        return (new Category(){

            @Override
            public CharSequence getTitle() {
                return "Test Category 1";
            }

        });
    }





}
