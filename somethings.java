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
        obj1.random();


        obj1.present();
    }
}


class viewmodel {
    Player[][] boardData;
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
        boardData[1][0] = Player.Second;
        boardData[2][2] = Player.Second;
    }
}
