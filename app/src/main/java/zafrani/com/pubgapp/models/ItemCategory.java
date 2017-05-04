package zafrani.com.pubgapp.models;


import java.util.List;

public class ItemCategory {
    //@SerializedName("cat_name")
    private String cat_name;
    //@SerializedName("types")
    private List<ItemType> types;

    public String getCat_name() {
        return cat_name;
    }

    public List<ItemType> getTypes() {
        return types;
    }
}
