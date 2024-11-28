package pkg_ArrayList.compare;

import java.util.Objects;

public class ProductTwo implements Comparable<ProductTwo>{

    private String name;
    private int price;

    public ProductTwo(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductTwo product_two = (ProductTwo) o;
        return price == product_two .price && Objects.equals(name, product_two .name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    
    @Override
    public String toString() {
    	return "Product{name='" + name + "', price=" + price + '}';
    }


    // Comparable 인터페이스의 compareTo 메소드 오버라이드 (가격 기준 오름차순 정렬)
    @Override
    public int compareTo(ProductTwo p) {
    	return this.price - p.price;  // 가격을 기준으로 오름차순 정렬
    }


}
