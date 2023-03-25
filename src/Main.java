import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int strike = 0;
        int ball = 0;
        int[] com = new int[3];

        System.out.println("안녕하세요 야구게임을 시작하겠습니다.");

        /* 컴퓨터 무작위 3자리 추출 - 230318 / gookbob */
        while(true) {
            for (int j = 0; j < com.length; j++) {
                com[j] = (int) (Math.random() * 10);
            }
            if(!(com[0] == com[1] || com[0] == com[2] || com[1] == com[2])) {
                System.out.printf("%d %d %d", com[0], com[1], com[2]);
                break;
            }
        }

        /* 총기회 10번 */
        for (int i = 0; i < 10; i++) {
            System.out.println("\n3자리의 숫자를 입력해주세요");

            /* null로 에러 잡기위해 - 230318 / gookbob */
            String input;
            input = scan.nextLine();

            /* 예외처리? 제대로 배우고 적용할 예정 - 230318 / gookbob */
            if (input == null || input.length() != 3) {
                while (input != null && input.length() == 3) {
                    System.out.println("다시 입력해주세요");
                    input = scan.nextLine();
                }
            }

            /* 정수형으로 자릿수 대로 나누기 - 230318 / gookbob */
            int myNum = Integer.parseInt(input);
            int myX = myNum / 100;
            int myY = myNum / 10 - myX * 10;
            int myZ = myNum - (myX * 100 + myY * 10);
            int[] myBall = {myX, myY, myZ};
            System.out.printf("\n%d %d %d", myX, myY, myZ);

            /* 동일 인덱스에 동일 숫자 일시 strike, 숫자는 같은데 인덱스가 다르면 ball counting - 230319 / gookbob */
            for (int l = 0; l < myBall.length; l++) {
                if (myBall[l] == com[l]) {
                    strike++;}
                for (int z = 0; z < myBall.length; z++) {
                    if (myBall[l] != com[l] && myBall[l] == com[z]) {
                        ball++;
                    }
                }
            }

            /* strike, ball, out 결과 반환 이후 초기화 - 230319 / gookbob */
            if (strike == 0 && ball == 0) {
                System.out.println("아웃");
            } else if(strike == 3){
                System.out.println("\n정답입니다");
                break;
            }
            else {
                System.out.printf("\n%d 스트라이크 %d 볼\n", strike, ball);
            }

            strike = 0;
            ball = 0;

            if(i >=9){
                System.out.printf("\n패배 정답은: %d %d %d", com[0], com[1], com[2]);
            }
        }


    }
}