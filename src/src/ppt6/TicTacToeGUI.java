package src.ppt6;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI {
	// JButton 타입 [3][3] 배열을 참조하는 변수 선언
    private static JButton[][] buttons = new JButton[3][3];
    // 현재 플레이어 초기화
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
    	// 프레임 설정
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout());
        
        JPanel pSouth = new JPanel();        
        JButton restartBTN = new JButton("Restart");
        restartBTN.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		for(int i=0;i<3;i++) {
        			for(int j=0;j<3;j++) {
        				// 모든 버튼을 재활성화.
        				buttons[i][j].setEnabled(true);
        				// 모든 버튼의 텍스트를 초기화.
        				buttons[i][j].setText(String.valueOf(""));
        			}
        		}
        	}
        });
        pSouth.add(restartBTN);
        frame.add(pSouth,BorderLayout.SOUTH);
        
        JPanel pCenter = new JPanel();
        pCenter.setLayout(new GridLayout(3, 3));      
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            	// 해당 좌표에 버튼 객체 생성.
                buttons[i][j] = new JButton("");
                // 해당 버튼의 Font 설정
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                // 해당 버튼의 ActionListener 추가. 
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                // 프레임에 설정된 버튼 추가.
                pCenter.add(buttons[i][j]);
            }
        }
        frame.add(pCenter,BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
    private static class ButtonClickListener implements ActionListener {
        int row, col;

        ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void actionPerformed(ActionEvent e) {
        	// 해당 좌표 버튼의 Text가 비어있다면
            if (buttons[row][col].getText().equals("")) {
            	// currentPlayer의 값으로 setting.
                buttons[row][col].setText(String.valueOf(currentPlayer));
                // 눌려진 버튼 비활성화
                buttons[row][col].setEnabled(false);
                
                // 이기거나 비기면 모든 버튼 비활성화.
                if (checkWin(row, col) || checkDraw()) {
                    disableAllButtons();
                }
                // Player 전환.
                switchPlayer();
            }
        }
    }

    private static void switchPlayer() {
    	// 현재 Player가 X면 O를 대입하고, X가 아니면 X를 대입.
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean checkWin(int row, int col) {
    	int flag = 0;
    	
    	// Check rows
    	for(int i=0;i<3;i++) {
    		if(buttons[row][i].getText().equals(String.valueOf(currentPlayer))) {
    			++flag;
    			if(flag == 3) {
    				flag = 0;
    				JOptionPane.showMessageDialog(null,"Player " + currentPlayer + "wins!");
    				return true;
    			}
    		}    		
    	}
    	flag = 0;
    	
    	// Check columns
    	for(int i=0;i<3;i++) {
    		if(buttons[i][col].getText().equals(String.valueOf(currentPlayer))) {
    			++flag;
    			if(flag == 3) {
    				flag = 0;
    				JOptionPane.showMessageDialog(null,"Player " + currentPlayer + "wins!");
    				return true;
    			}
    		}    		
    	}
    	flag = 0;
    	
    	// Check decreasedDiagonal
    	if(row == col) {
    		for(int i=0; i<3; i++) {
    			if(buttons[i][i].getText().equals(String.valueOf(currentPlayer))) {
    				++flag;
    				if(flag == 3) {
    					flag = 0;
    					JOptionPane.showMessageDialog(null, "Player " + currentPlayer + "wins!");
    				}
    			}
    		}
    		flag = 0;
    	}
    	
    	// Check increasedDiagonal
    	if(row+col == 2) {
    		for(int i=0; i<3; i++) {
    			if(buttons[i][2-i].getText().equals(String.valueOf(currentPlayer))) {
    				++flag;
    				if(flag == 3) {
    					flag = 0;
    					JOptionPane.showMessageDialog(null, "Player " + currentPlayer + "wins!");
    				}
    			}
    		}
    		flag = 0;
    	}
    	
        /*// Check rows    	
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[i][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[i][2].getText().equals(String.valueOf(currentPlayer))) {
                JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
                return true;
            }
        }*/
        
        /*// Check columns
        for (int j = 0; j < 3; j++) {        	
            if (buttons[0][j].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][j].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][j].getText().equals(String.valueOf(currentPlayer))) {
                JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
                return true;
            }
        }*/
    	
        /*// Check diagonals
        if (buttons[0][0].getText().equals(String.valueOf(currentPlayer)) &&
            buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
            buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
            return true;
        }*/
       /* if (buttons[0][2].getText().equals(String.valueOf(currentPlayer)) &&
            buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
            buttons[2][0].getText().equals(String.valueOf(currentPlayer))) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
            return true;
        }*/
        
        return false;
    }

    private static boolean checkDraw() {
    	// 반복문을 통해 눌려져 있지 않은 버튼이 있는지 확인.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            	// 만약 눌려져 있지 않은 버튼이 있다면 return false;
                if (buttons[i][j].getText().equals("")) {                	
                    return false;
                }
            }       
        }
        // 모든 버튼이 눌려졌다면 draw 메세지 실행하고 return true;
        JOptionPane.showMessageDialog(null, "It's a draw!");
        return true;
    }

    private static void disableAllButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }
}
