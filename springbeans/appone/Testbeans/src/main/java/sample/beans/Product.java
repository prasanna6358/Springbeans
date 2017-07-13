package sample.beans;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {

    private String pname;
    private double pprice;
    private int pquantity;
    private List<String> pitems;
    private Map<String,Object> mapItems;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    public int getPquantity() {
        return pquantity;
    }

    public void setPquantity(int pquantity) {
        this.pquantity = pquantity;
    }

    public List<String> getPitems() {
        return pitems;
    }

    public void setPitems(List<String> pitems) {
        this.pitems = new ArrayList<String>(pitems);
    }

    public Map<String, Object> getMapItems() {
        return mapItems;
    }

    public void setMapItems(Map<String, Object> mapItems) {
        this.mapItems =new HashMap<String, Object>(mapItems);
    }

    @Override
    public String toString() {
        return "Product{" +
                "pname='" + pname + '\'' +
                ", pprice=" + pprice +
                ", pquantity=" + pquantity +
                ", pitems=" + pitems +
                ", mapItems=" + mapItems +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (Double.compare(product.getPprice(), getPprice()) != 0) return false;
        if (getPquantity() != product.getPquantity()) return false;
        if (getPname() != null ? !getPname().equals(product.getPname()) : product.getPname() != null) return false;
        if (getPitems() != null ? !getPitems().equals(product.getPitems()) : product.getPitems() != null) return false;
        return getMapItems() != null ? getMapItems().equals(product.getMapItems()) : product.getMapItems() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getPname() != null ? getPname().hashCode() : 0;
        temp = Double.doubleToLongBits(getPprice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getPquantity();
        result = 31 * result + (getPitems() != null ? getPitems().hashCode() : 0);
        result = 31 * result + (getMapItems() != null ? getMapItems().hashCode() : 0);
        return result;
    }
}
