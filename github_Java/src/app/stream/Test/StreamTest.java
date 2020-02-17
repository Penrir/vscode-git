package app.stream.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamTest {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.add("aaa");
		list.add("bbb");
		Random r = new Random();

		LinkedList<ThreeAttr> list2 = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			list2.offer(new ThreeAttr(r.nextInt(50) + 1,
					String.format("%c%c%c%c", r.nextInt(26) + 65,
							r.nextInt(26) + 65, r.nextInt(26) + 65,
							r.nextInt(26) + 65),
					r.nextInt(100000) + 1000));
		}

		list2.parallelStream().forEach(s -> System.out.println(s.toString()));
		System.out.println(list2.parallelStream()
				.filter(s -> s.name.contains("T")).count());
		list2.stream().map((s) -> {
			return s.getName().concat("abcd");
		}).forEach(s -> System.out.println(s));
		LinkedList<ThreeAttr> list3;
		Collections.sort(list2, new Comparator<ThreeAttr>() {

			@Override
			public int compare(ThreeAttr o1, ThreeAttr o2) {
				// TODO Auto-generated method stub
				return o1.num - o2.num;
			}
		});
		list2.stream().forEach(s -> System.out.println(s.toString()));
		System.out.println("Before reverse");
		list2.stream()
				.sorted(Comparator.comparing(ThreeAttr::getNum).reversed())
				.forEach(System.out::println);
		;

//		LinkedList<ThreeAttr> list3 = (LinkedList<ThreeAttr>) list2.stream().sorted().collect(Collectors.toList());
//		list3.parallelStream().forEach(s -> System.out.println(s.toString()));

	}
}

class ThreeAttr {
	int num;
	String name;
	int price;

	public ThreeAttr() {
	}

	public ThreeAttr(int num, String name, int price) {
		this.num = num;
		this.name = name;
		this.price = price;
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public ThreeAttr num(int num) {
		this.num = num;
		return this;
	}

	public ThreeAttr name(String name) {
		this.name = name;
		return this;
	}

	public ThreeAttr price(int price) {
		this.price = price;
		return this;
	}

	@Override
	public String toString() {
		return "{" + " num='" + getNum() + "'" + ", name='" + getName() + "'"
				+ ", price='" + getPrice() + "'" + "}";
	}

}