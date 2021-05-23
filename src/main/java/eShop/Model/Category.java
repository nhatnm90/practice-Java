package eShop.Model;

import bank.Account;
import utils.StringFormat;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Category {
    //<editor-fold desc="Constant">
    private static final long INITIALIZED_BALANCE = 100;

    public enum Period {
        Week,
        Month,
        Quarter,
        Year
    }
    //</editor-fold>

    //<editor-fold desc="Propeties">
    private UUID categoryId;
    private String categoryName;
    private int order;
    private UUID parentCategoryId;
    private Calendar createdDate;
    private boolean isActive;
    //</editor-fold>

    //<editor-fold desc="Getter Setter">
    public UUID getCategoryId() {
        return categoryId;
    }
    //</editor-fold>

    //<editor-fold desc="Constructor">
    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.parentCategoryId = null;
        this.createdDate = Calendar.getInstance();
        this.categoryId = UUID.randomUUID();
    }

    public Category(String categoryName, UUID parentCategoryId) {
        this.categoryName = categoryName;
        this.parentCategoryId = parentCategoryId;
        this.createdDate = Calendar.getInstance();
        this.categoryId = UUID.randomUUID();
    }
    //</editor-fold>

    //<editor-fold desc="Private functions">

    //</editor-fold>

    //<editor-fold desc="Public functions">
    public int countCharacter(){
        return this.categoryName.length();
    }

    public int countCharacter(String categoryName){
        return categoryName.length();
    }


    public String findCategoryById(List<Category> categoryList, UUID categoryId) {
        Category category = categoryList.stream().filter(id -> id.getCategoryId() == categoryId)
                .findAny().orElse(null);
        String categoryName = category.getCategoryName();
        if (categoryName == "Da" || categoryName == "Mặt") {
            categoryName = " Chăm sóc " + categoryName.toLowerCase();

        }
        return categoryName;
    }

    public String addTextToCategoryName(){
        String categoryName = this.getCategoryName();
        if (categoryName == "Da" || categoryName == "Mặt") {
            categoryName = "Chăm sóc " + categoryName.toLowerCase();
        }
        return categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public UUID getParentCategoryId() {
        return parentCategoryId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setOrder(int order) {
        this.order = order;
    }



    //</editor-fold>
}
