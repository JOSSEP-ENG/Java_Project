package src.ppt6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;

public class DBLoginApplication {
	private JTextField usernameField;
    private JPasswordField passwordField;
    
    public DBLoginApplication() {
        JFrame frame = new JFrame("로그인");
        frame.setBounds(500, 300, 300, 200);    	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 레이아웃 설정
        frame.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("사용자 이름:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("비밀번호:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("로그인");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                
                DBConnection users = new DBConnection();
                
                // 데이터베이스 연결.
                boolean result = users.connectDatabase();
                
                // 연결 성공 후 접속한 ID,PWD가 일치하면 로그인 성공 메세지 출력.
                if(result == true) {
                	// 창 띄어서 "로그인에 성공하였습니다" 출력.
                	System.out.println("로그인에 성공하였습니다.");
                	JOptionPane.showMessageDialog(null,"로그인 되었습니다.");
                }
                else {
                	// 창 띄어서 "일치하지 않는 정보입니다" 출력.
                	System.out.println("일치하지 않는 정보입니다.");
                	JOptionPane.showMessageDialog(null,"일치하지 않는 정보..!");
                }
                
                System.out.println("사용자 이름: " + username);
                System.out.println("비밀번호: " + password);
            }
        });

        // 컴포넌트 추가
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(new JLabel()); // 공백 레이블
        frame.add(loginButton);

        frame.setVisible(true);
    }

    class DBConnection {    	
    	    	
    	private String username = usernameField.getText();
    	private String password = new String(passwordField.getPassword());
    	    	
    	public boolean connectDatabase() {
    		String dbUrl = "jdbc:mysql://192.168.253.128:3306/employees";
    		String dbID = "mariadb";
    		String dbPWD = "1234";
    		Connection conn = null;
    		try {
				// 데이터베이스 접속
    			conn = DriverManager.getConnection(dbUrl,dbID,dbPWD);    			
    			
    			// 쿼리 실행 객체 생성.
				//SELECT 쿼리 실행.
    			String sql = "SELECT user_id,user_pwd FROM users where user_id = ? and user_pwd = ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, username);
				stmt.setString(2, password);			
				ResultSet resultSet = stmt.executeQuery();
				
				//SELECT 실행 결과
				while(resultSet.next()) {
					String col_id = resultSet.getString("user_id");
					String col_pwd = resultSet.getString("user_pwd");
					boolean result = checkUserInfo(col_id,col_pwd);
					if(result == true) 	{
						return true;
					}
				}
			}
    		catch (SQLException e) {
				e.printStackTrace();
			}
    		finally {
    			try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
    		}
    		return false;
    	}
    	
    	// 입력받은 username과 password가 users 데이터베이스에 존재하는지 확인.
    	// 일치하는 정보가 있으면 true 반환, 없으면 false 반환.
    	public boolean checkUserInfo(String col_id, String col_pwd) {
    		System.out.println(username + ", " + password);
    		System.out.println(col_id + ", " + col_pwd);
    		if(col_id.equals(username) && col_pwd.equals(password)) {
    			return true;
    		}
    		return false;
    	}
    }
    
    public static void main(String[] args) {
    	DBLoginApplication DBapp = new DBLoginApplication();
    }
            
}
