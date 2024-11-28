package pkg_ArrayList.compare;

import java.util.Comparator;

public class PriceComparator implements Comparator<ProductTwo> {
    @Override
    public int compare(ProductTwo p1, ProductTwo p2) {
        return p1.getPrice() - p2.getPrice();  // 가격 기준으로 오름차순 정렬
    }
}

