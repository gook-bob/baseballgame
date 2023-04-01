package baseballgame;
import  java.util.*;

public class ReadyBall {
    Scanner scan = new Scanner(System.in);
    private int BALL_SIZE = 3;
    private int[] comNum = new int[BALL_SIZE];
    private int[] playerNum = new int[BALL_SIZE];
    private int strike;
    private int ball;

    /*랜덤으로 생성하는 메소드 23.04.01*/
    public void comBall() {
        while (true) {
            for (int i = 0; i < BALL_SIZE; i++) {
                comNum[i] = (int) (Math.random() * 10);
            }
            if (!(comNum[0] == comNum[1] || comNum[0] == comNum[2] || comNum[1] == comNum[2])) {
                System.out.printf("%d %d %d\n", comNum[0], comNum[1], comNum[2]);
                break;
            }
        }
    }

    /*플레이어 숫자 입력 23.04.01*/
    public void playerBall () {
        int input = scan.nextInt();
        int myX = input / 100;
        int myY = input / 10 - myX * 10;
        int myZ = input - (myX * 100 + myY * 10);
        int[] ballInput = {myX, myY, myZ};
        for (int i = 0; i < BALL_SIZE; i++) {
            playerNum[i] = ballInput[i];
        }
            System.out.printf("\n%d %d %d", myX, myY, myZ);
        }

    /*숫자 비교후 출력*/
    public void checkBall(){
        for (int i = 0; i < BALL_SIZE; i++) {
              if (playerNum[i] == comNum[i]) {
                    strike++;}
              for (int z = 0; z < BALL_SIZE; z++) {
                    if (playerNum[i] != comNum[i] && playerNum[i] == comNum[z]) {
                        ball++;
                    }
                }
            }
        System.out.printf("\n%d스트라이크\n%d볼", strike,ball);
    }
}
