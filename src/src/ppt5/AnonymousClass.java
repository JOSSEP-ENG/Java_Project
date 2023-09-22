package src.ppt5;

public class AnonymousClass {
	
	public static void main(String[] args) {
		Person lee = new Person("lee");
		Student kim = new Student("kim","ansan univ");
		
		kim.greeting();
		kim.study();
		
		Student james = new Student() {			
			@Override
			public void greeting() {
				System.out.println("Hello, My name is " + getName());
				System.out.println("I'm studying in" + getSchool());
			}
			@Override
			public void study() {
				play();
			}
			public void play() {
				System.out.println("Play");
			}
		};
		
		james.setName("james");
		james.setSchool("ansan Univ");
		james.greeting();
		james.study();
	}
}

class Person {
	private String name;
		
	public Person() {}	
	public Person(String name) {
		this.name = name;
	}
	public void greeting() {
		System.out.println("안녕하세요" + name + " 입니다.");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class Student extends Person {
	
	private String school;	
	private int score = 0;
	
	public Student() {}
	public Student(String name, String school) {
		super(name);
		this.school = school;
	}
	@Override
	public void greeting() {
		super.greeting();
		System.out.println("저는 " + school + "에 재학 중 입니다.");
	}
	
	public void study() {
		System.out.println("열공!!");
		setScore(getScore() + 1);
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}	
	
}