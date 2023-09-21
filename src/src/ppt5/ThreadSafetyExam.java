package src.ppt5;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ThreadSafetyExam {

	public static void main(String[] args) {
		//Vector와 ArrayList의 스레드 안전성.
		
		int num = 3;
		
		// Integer형 ArrayList 객체 할당
		List<Integer> threadUnsafe = new ArrayList<>();
		
		// Integer형 Vector 객체 할당
		List<Integer> threadSafe = new Vector<>();
		
		// Thread형 ArrayList 객체 할당
		List<Thread> threads = new ArrayList<>();
		

		// 
		for(int i=0;i<num;i++) {
			// 스레드 객체 생성.
			Thread thread = new Thread(()->{
				// ArrayList에 반복적으로 0~999를 대입,
				// Vector에 반복적으로 0~999를 대입,
				// 하는 작업 스레드.
				for(int j=0;j<1000;j++) {					
					threadUnsafe.add(j);
					threadSafe.add(j);
				}
			});
			// 각 스레드를 배열에 추가.
			threads.add(thread);
		}
		
		// 각 배열에 있는 작업스레드들을 스타트.
		for(Thread thread : threads) {
			thread.start();
		}
		
		// 각 배열에 있는 작업스레드들이 모두 완료될 때까지 
		// 메인 스레드 대기.
		for(Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("ArrayList의 사이즈 : " + threadUnsafe.size());
		System.out.println("Vector의 사이즈 : " + threadSafe.size());
	}
}
