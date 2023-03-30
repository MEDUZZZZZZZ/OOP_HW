package OOP_HW.final_work.Core.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import OOP_HW.final_work.Persons.Dummy;


public class View {
    private static int step = 1;
    private static final int[] l = { 0 };
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b")))
            + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e")))
            + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h")))
            + formatDiv("-i");


    private static void tabSetter(int cnt, int max) {
        int dif = max - cnt + 2;
        if (dif > 0)
            System.out.printf("%" + dif + "s", ":\t");
        else
            System.out.print(":\t");
        }


    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }


    private static String getChar(int x, int y, ArrayList<Dummy> allTeam, ArrayList<Dummy> radiant, ArrayList<Dummy> dire) {
        String out = "| ";
        for (Dummy hero : allTeam) {
            if (hero.getCords().getX() == x && hero.getCords().getY() == y) {
                if (hero.getHp() == 0) {
                    out = "|" + (Ansi.ANSI_RED + hero.getProf().charAt(0) + Ansi.ANSI_RESET);
                    break;
                }
                if (dire.contains(hero))
                    out = "|" + (Ansi.ANSI_PURPLE + hero.getProf().charAt(0) + Ansi.ANSI_RESET);
                if (radiant.contains(hero))
                    out = "|" + (Ansi.ANSI_YELLOW + hero.getProf().charAt(0) + Ansi.ANSI_RESET);
                break;
            }
        }
        return out;
    }


    public static void view(ArrayList<Dummy> allTeam,ArrayList<Dummy> radiant, ArrayList<Dummy> dire) {
        if (step == 1) {
            System.out.print(Ansi.ANSI_RED + "First step" + Ansi.ANSI_RESET);
        } else {
            System.out.print(Ansi.ANSI_RED + "Step:" + step + Ansi.ANSI_RESET);
        }
        step++;
        allTeam.forEach((v) -> l[0] = Math.max(l[0], v.getInfo().length()));
        System.out.print("_".repeat(l[0] * 2));
        System.out.println("");
        System.out.print(top10 + "    ");
        System.out.print("Radiant side");
        System.out.print(" ".repeat(l[0] - 9));
        System.out.println(": Dire side");
        for (int i = 1; i < 11; i++) {
            System.out.print(getChar(1, i, allTeam, radiant, dire));
        }
        System.out.print("|    ");
        System.out.print(radiant.get(0).getInfo());
        tabSetter(radiant.get(0).getInfo().length(), l[0]);
        System.out.println(dire.get(0).getInfo());
        System.out.println(midl10);

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(getChar(i, j, allTeam, radiant, dire));
            }
            System.out.print("|    ");
            System.out.print(radiant.get(i - 1).getInfo());
            tabSetter(radiant.get(i - 1).getInfo().length(), l[0]);
            System.out.println(dire.get(i - 1).getInfo());
            System.out.println(midl10);
        }
        for (int j = 1; j < 11; j++) {
            System.out.print(getChar(10, j, allTeam, radiant, dire));
        }
        System.out.print("|    ");
        System.out.print(radiant.get(9).getInfo());
        tabSetter(radiant.get(9).getInfo().length(), l[0]);
        System.out.println(dire.get(9).getInfo());
        System.out.println(bottom10);
    }

    public static void startGame(){
        Scanner button = new Scanner(System.in);
        System.out.println("Нажмите 'Enter' для старта игры.");
        button.nextLine();
        System.out.println("Да начнется БИТВА");
    }

    public static void showInfo(ArrayList<Dummy> team){
        for(Dummy hero : team){
            System.out.println(hero.getInfo());
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }

    public static void showWinner(int id){
        if (id == 2){
            System.out.println("Победил свет");
        }
        else{
            System.out.println("Победила тьма");
        }
        
        // заполнить
    }
}   
