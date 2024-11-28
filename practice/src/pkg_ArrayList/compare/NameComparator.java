package pkg_ArrayList.compare;

import java.util.Comparator;

public class NameComparator implements Comparator<ProductTwo> {
    @Override
    public int compare(ProductTwo p1, ProductTwo p2) {
        return p1.getName().compareTo(p2.getName());  // 이름 기준 오름차순 정렬
    }
}
