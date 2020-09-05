package eShop.Model;

import utils.StringFormat;

import java.util.Calendar;
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

    //</editor-fold>
}
