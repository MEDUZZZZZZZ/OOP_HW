package OOP_HW.ht_1;

import OOP_HW.ht_1.persons.*;

public class main {
    public static void main(String[] args) {
        Archer char_1 = new Archer("Robin");
        System.out.println(char_1.getInfo());
        Mage char_2 = new Mage("Merlin");
        System.out.println(char_2.getInfo());
        Monk char_3 = new Monk("Buddha");
        System.out.println(char_3.getInfo());
        Rogue char_4 = new Rogue("Eswin");
        System.out.println(char_4.getInfo());
        Sniper char_5 = new Sniper("Brann");
        System.out.println(char_5.getInfo());
        Spearman char_6 = new Spearman("Arthas");
        System.out.println(char_6.getInfo());
        Villager char_7 = new Villager("Magni", 7);
        System.out.println(char_7.getInfo());
        }
}
