import java.util.Scanner;

enum Player {
    First,
    Second,
    NoOne
}

public class somethings {
    public static void main(String args[]) {
        // for render
        viewmodel obj1 = new viewmodel();
        obj1.boardModel();
        obj1.render();

        // for testing purpose
        // obj1.random();

        // if (true) {
        //     System.out.print("Checking for isGameOver:");
        //     System.out.println(obj1.isGameOver().toString());
        // }

        while(obj1.isGameOver() == Player.NoOne) {
            obj1.present();
            obj1.plotData(obj1.currentPlayer);
            obj1.changeCurrentPlayer();
        }
    }
}


class viewmodel {
    Player[][] boardData;
    Player currentPlayer = Player.First;
    public void boardModel() {
        boardData = new Player[3][3];
    }

    // for Rendering Board Datas.
    public void render() {
        System.out.println("[*] Rendering Board...");
        // Render boardData to null
        for (int i=0; i<3; i++) {
            for (int j=0; j<3;j++ ) {
                boardData[i][j] = Player.NoOne;
            }
        }
    }

    public void present() {
        System.out.println("[*] Representing model data...");

        // skipping one row
        stretch();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                // debug
                // System.out.println("i = "+Integer.toString(i)+"\tj = "+Integer.toString(j));
                System.out.print("|\t");
                System.out.print((boardData[i][j] == Player.NoOne) ? " \t" : (boardData[i][j] == Player.First) ? "X\t" : "O\t");
            }
            System.out.println("|");
            stretch();
        }
    }

    public void stretch() {
        System.out.println("|\t \t|\t \t|\t \t|");
    }

    public void random() {
        boardData[1][2] = Player.First;
        boardData[0][0] = Player.First;
        boardData[2][0] = Player.First;
        boardData[0][2] = Player.Second;
        boardData[1][0] = Player.First;
        boardData[2][2] = Player.Second;
    }

    public Player isGameOver() {
        // check linear horizontal
        for (int i=0;i<3 ;i++ ) {
            if ((boardData[i][0] == boardData[i][1] && boardData[i][1] == boardData[i][2]) && (boardData[i][0] != Player.NoOne)) {
                return boardData[i][0];
            }
        }

        // for linear vertical
        for (int i=0; i<3; i++) {
            if ((boardData[0][i] == boardData[1][i] && boardData[1][i] == boardData[2][i]) && (boardData[0][i] != Player.NoOne)) {
                return boardData[0][i];
            }
        }
        
        // for foreward diagonal
        if ((boardData[0][0] == boardData[1][1] && boardData[1][1] == boardData[2][2]) && (boardData[0][0] != Player.NoOne))  {
            return boardData[0][0];
        }

        // for backward diagonal
        if ((boardData[0][2] == boardData[1][1] &&  boardData[1][1] == boardData[2][0]) && (boardData[0][2] != Player.NoOne))  {
            return boardData[0][0];
        }

        return Player.NoOne;

    }

    public void plotData(Player plrname) {
        Scanner scanob = new Scanner(System.in);
        System.out.println("Player: "+plrname.name());
        int value = scanob.nextInt();
        if ((value < 00)  || (value > 22) || (value/10 > 2) || (value%10 > 2)) {
            throw new RuntimeException("Not allowded");
        } else {
            int a1 = value/10;
            int a2 = value%10;
            if (boardData[a1][a2]  != Player.NoOne) {
                throw new ArithmeticException("Already found somethings.");
            } else {
                boardData[a1][a2] = plrname;
            }
        }

    }

    public void changeCurrentPlayer() {
        currentPlayer = (currentPlayer == Player.First) ? Player.Second : Player.First;
    }
}
