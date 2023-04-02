package baseballgame;
public class PlayBall {
    public void playBall() {
        ReadyBall readyBall = new ReadyBall();
        readyBall.comBall();
        for (int i = 0; i < 10; i++) {
            readyBall.playerBall();
            readyBall.checkBall();
            readyBall.printBall();
            if (readyBall.getResult() == 1){
                System.out.println("당신의 승리 입니다.");
                break;
            }
            if (i == 9){
                System.out.println("당신의 패패 입니다.");
            }
        }
    }
}
