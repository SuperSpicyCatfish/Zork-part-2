//
//  AUTHORS:        Julia and Tran
//  CLASS:          CPSC - 233j
//  TEACHER:        Professor McCarthy
//  TIME:           T-Th 8:00am-9:45am
//  DUE:            November 21, 2020
//

package com.company;
import com.company.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class SaveAndLoad {
    static Game game;

    private static void saveGame() {
        try {
            FileOutputStream fileOutPut = new FileOutputStream("ZorkGame");
            ObjectOutputStream objectOutPut = new ObjectOutputStream(fileOutPut);
            objectOutPut.writeObject(game);
            objectOutPut.flush();
            objectOutPut.close();
            System.out.print("Game saved\n");
        } catch (Exception e) {
            System.out.print("Error! Can't save :( \n" + e.getClass() + e.getMessage() + "\n");

        }
    }

    private static void Load() {
    try {
        FileInputStream fileInputStream = new FileInputStream("ZorkGame");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        game = (Game) objectInputStream.readObject();
        objectInputStream.close();
        System.out.print("\n************Game loaded*************\n");
    } catch (Exception e){
        System.out.print("Error! Can't save :( "+e.getClass() + e.getMessage() + "\n" );

    }


    }
    public static void main(String[] args) throws IOException{
            BufferedReader i;
            String input;
            String output = " ";
            game = new Game();
            i = new BufferedReader(new InputStreamReader(System.in));
                do {
                    System.out.print("> ");
                    input = i.readLine();
                    output = game.Commands /* this put in place while waiting for the Commands class */ (input);
                    System.out.println(output);

                } while (!"q".equals(input));



    }
}
