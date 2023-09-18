package src.ppt4;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		UpDownGame game = new UpDownGame(); // 난수발생
		int input = 0;
		
		try(Scanner scann = new Scanner(System.in)){
			
			while (true) {
				
				// 정수 입력했을때
				if(scann.hasNextInt()) {
					input = scann.nextInt();
					if(input <=0 || input > 100) {
						throw new NumberFormatException("1~100만 입력 가능합니다.");
					}
					if(game.chkNum(input)) {
						break;
					}
				// 종료 문자 입력 시
				} else if (scann.hasNext("q") || scann.hasNext("quit")) {
					throw new UserQuitException("게임을 종료합니다.");
				} else if(scann.hasNext()) {
					throw new NumberFormatException("뭘 입력한거야!!!");
				}
			}
			
		} catch (NumberFormatException e) {
			System.out.println(e);
		} catch (UserQuitException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}

class UserQuitException extends Exception{
	public UserQuitException(String message) {
		super(message);
	}
}