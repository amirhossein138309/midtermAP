
public class Main {
    // green = 0   blue = 1   white = 2    black = 3     red = 4    prize = 5      koin khas///////
    
    public static void main(String[] args) {
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Card[] cards_1 = new Card[15];
        Card[] cards_2 = new Card[15];
        Card[] cards_3 = new Card[15];
        Card[] cards_prize = new Card[3];
        SlotMachine[] slot = new SlotMachine[5];
        //String x = new String();


        cards_1[0] = new Card(1, 0, 1, 1, 2,0, 0, 0);
        cards_1[1] = new Card(1, 1, 2, 0, 1, 1, 1, 1);
        cards_1[2] = new Card(1, 0, 0, 1, 1, 0, 0, 1);
        cards_1[3] = new Card(1, 1, 4, 2, 2, 0, 0, 0);
        cards_1[4] = new Card(1,0,3,0,3,2,1,0);
        cards_1[5] = new Card(1,1,1,0,2,2,1,1);
        cards_1[6] = new Card(1,1,3,0,1,2,1,0);
        cards_1[7] = new Card(1,1,2,0,1,1,1,1);
        cards_1[8] = new Card(1,0,4,0,0,2,2,2);
        cards_1[9] = new Card(1,1,1,1,1,2,0,1);
        cards_1[10] = new Card(1,0,2,1,2,3,0,0);
        cards_1[11] = new Card(1,1,1,1,2,1,1,0);
        cards_1[12] = new Card(1,0,3,0,3,1,2,0);
        cards_1[13] = new Card(1,1,4,1,0,1,2,1);
        cards_1[14] = new Card(1,1,4,0,2,2,2,0);


        cards_2[0] = new Card(2,2,0,2,3,1,2,0);
        cards_2[1] = new Card(2,3,1,0,3,3,2,0);
        cards_2[2] = new Card(2,3,2,0,2,2,2,2);
        cards_2[3] = new Card(2,4,3,1,2,3,1,0);
        cards_2[4] = new Card(2,3,4,3,2,1,0,1);
        cards_2[5] = new Card(2,2,1,1,0,3,2,1);
        cards_2[6] = new Card(2,4,0,1,2,3,1,0);
        cards_2[7] = new Card(2,4,3,4,3,1,0,0);
        cards_2[8] = new Card(2,3,2,0,2,2,2,1);
        cards_2[9] = new Card(2,2,4,1,0,0,3,2);
        cards_2[10] = new Card(2,2,1,2,3,1,1,0);
        cards_2[11] = new Card(2,4,0,0,4,3,1,0);
        cards_2[12] = new Card(2,3,2,0,0,2,3,2);
        cards_2[13] = new Card(2,2,3,0,2,3,3,0);
        cards_2[14] = new Card(2,4,1,2,3,2,0,1);


        cards_3[0] = new Card(3,3,0,2,3,3,1,0);
        cards_3[1] = new Card(3,4,1,0,3,2,2,2);
        cards_3[2] = new Card(3,5,2,1,2,2,2,1);
        cards_3[3] = new Card(3,4,3,3,2,2,1,0);
        cards_3[4] = new Card(3,5,4,1,0,3,3,3);
        cards_3[5] = new Card(3,3,3,3,2,3,1,1);
        cards_3[6] = new Card(3,5,2,2,2,2,1,3);
        cards_3[7] = new Card(3,3,1,0,0,4,2,3);
        cards_3[8] = new Card(3,4,4,4,3,2,1,0);
        cards_3[9] = new Card(3,3,4,2,3,3,2,0);
        cards_3[10] = new Card(3,3,0,4,1,3,0,2);
        cards_3[11] = new Card(3,4,2,0,0,3,2,4);
        cards_3[12] = new Card(3,5,3,1,1,2,3,3);
        cards_3[13] = new Card(3,4,4,0,2,3,4,0);
        cards_3[14] = new Card(3,5,1,1,1,1,2,1);


        cards_prize[0] = new Card(0,3,5,2,3,3,2,1);
        cards_prize[1] = new Card(0,4,5,3,2,3,2,2);
        cards_prize[2] = new Card(0,4,5,1,3,4,3,1);


        slot[0] = new SlotMachine(0);
        slot[1] = new SlotMachine(1);
        slot[2] = new SlotMachine(2);
        slot[3] = new SlotMachine(3);
        slot[4] = new SlotMachine(4);

        Map map = new Map();
        map.myframe(p1,p2,cards_1,cards_2,cards_3,cards_prize,slot);
    }
}
