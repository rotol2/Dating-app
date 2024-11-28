package pkg_ArrayList.compare;

import java.util.ArrayList;
import java.util.Collections;

public class Run {
    public static void main(String[] args) {
        // Product 객체들을 ArrayList에 추가
        ArrayList<ProductTwo> products = new ArrayList<>();
        products.add(new ProductTwo("사과", 1000));
        products.add(new ProductTwo("바나나", 1500));
        products.add(new ProductTwo("딸기", 2000));
        products.add(new ProductTwo("오렌지", 1200));

        // 정렬 전 출력
        System.out.println("정렬 전:");
        for (ProductTwo p : products) {
            System.out.println(p);
        }

        // ============ Comparable ==============
        // Comparable을 이용한 내부 정렬 (기본: 가격 기준 정렬)
        System.out.println("\n(Comparable) 가격 기준 오름차순 정렬 후:");
        Collections.sort(products);
        for (ProductTwo p : products) {
            System.out.println(p);
        }

        
        // ============ Comparator ==============
        // Comparator를 이용한 외부 정렬 (가격 기준 정렬)
        System.out.println("\n(Comparator) 가격 기준 오름차순 정렬 후:");
        Collections.sort(products, new PriceComparator());
        for (ProductTwo p : products) {
            System.out.println(p);
        }

        // Comparator를 이용한 외부 정렬 (이름 기준 정렬)
        System.out.println("\n(Comparator) 이름 기준 오름차순 정렬 후:");
        Collections.sort(products, new NameComparator());
        for (ProductTwo p : products) {
            System.out.println(p);
        }
    }
}
