package kosa.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExam01 {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("홍길동", 10), new Student("신용권", 20), new Student("유미선", 30));

//		double avg = list.stream().mapToInt(a -> a.getScore()).average().getAsDouble();
//		System.out.println(avg);
		
//		list.stream().mapToInt(s->s.getScore()).forEach(score->System.out.println(score));
		
//		list.stream().map(Student::getName).forEach(name->System.out.println(name));
		
//		list.stream().filter(s -> s.getName().startsWith("홍")).forEach(name->System.out.println(name.getName()));
		
//		List<Integer> list2 = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
//		list2.stream().forEach(System.out::println);
//		
//		List<Integer> list3 = IntStream.of(2,4,6,8,10).boxed().collect(Collectors.toList());
//		list3.stream().forEach(System.out::println);
		
		//문자열 배열 => List, stream 변환
		String arr[] = {"BB", "CC", "AA"};
		List<String> list3 = Arrays.asList(arr);
		
		list3.stream().sorted().forEach(System.out::println);
		
		Stream<String> stream2 = Arrays.stream(arr);
		stream2.sorted().forEach(System.out::println);
		
		list.stream().sorted(Comparator.reverseOrder()).forEach(s->System.out.println(s.getScore()));
		
	}
}