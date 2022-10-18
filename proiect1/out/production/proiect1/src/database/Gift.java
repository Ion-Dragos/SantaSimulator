package database;

import enums.Category;

public class Gift {
    private String productName;
    private Double price;
    private Category category;

    public Gift(final String productName,
                final Double price,
                final Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    /**
     *
     * @return - getter nume cadou
     */
    public String getProductName() {
        return productName;
    }

    /**
     *
     * @param productName - setter nume cadou
     */
    public void setProductName(final String productName) {
        this.productName = productName;
    }

    /**
     *
     * @return - getter pret cadou
     */
    public Double getPrice() {
        return price;
    }

    /**
     *
     * @param price - setter pret cadou
     */
    public void setPrice(final Double price) {
        this.price = price;
    }

    /**
     *
     * @return - getter categorie cadou
     */
    public Category getCategory() {
        return category;
    }

    /**
     *
     * @param category - setter categorie cadou
     */
    public void setCategory(final Category category) {
        this.category = category;
    }
}
