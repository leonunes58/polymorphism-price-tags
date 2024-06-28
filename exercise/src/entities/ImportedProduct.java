package entities;

public class ImportedProduct extends Product{
    private Double customsFree;

    public ImportedProduct(String name, double price, Double customsFree) {
        super(name, price);
        this.customsFree = customsFree;
    }

    public Double getCustomsFree() {
        return customsFree;
    }

    public void setCustomsFree(Double price) {
        this.customsFree = price;
    }

    public Double totalPrice() {
        return super.getPrice() + customsFree;
    }

    @Override
    public String priceTag() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append(" $").append(totalPrice()).append(" (Custom fee: $").append(getCustomsFree()).append(")");
        return sb.toString();
    }
}
