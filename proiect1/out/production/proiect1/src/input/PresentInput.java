package input;

import enums.Category;

public class PresentInput {
    private String productName;
    private Double price;
    private Category category;

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
     * @return - getter categoria din care face parte cadoul
     */
    public Category getCategory() {
        return category;
    }

    /**
     *
      * @param category - setter categoria din care face parte cadoul
     */
    public void setCategory(final Category category) {
        this.category = category;
    }
}
