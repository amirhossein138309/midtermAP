
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// green = 0   blue = 1   white = 2    black = 3     red = 4    prize = 5      koin khas//////
//p1,p2,cards_1,cards_2,cards_3,cards_prize,slot
public class Map{  //green = 0   blue = 1   white = 2    black = 3     red = 4   
    //public Card cardShow_center[] = new Card[12];
    public int turn = 1;// player1 = trueplayer2 = false...................


    public JPanel player1_map = new JPanel();
    public JLabel player1_label = new JLabel();
    public JLabel player1_label2 = new JLabel();
    public JLabel player1_label3 = new JLabel();
    public JLabel player1_label4 = new JLabel();
    public JLabel player1_label5 = new JLabel();
    public JLabel player1_label6 = new JLabel();
    public JLabel player1_label7 = new JLabel();
    public JLabel player1_label8 = new JLabel();
    public JLabel player1_label9 = new JLabel();
    public JLabel player1_label10 = new JLabel();
    public JLabel player1_label11 = new JLabel();
    public JLabel player1_label12 = new JLabel();

    public JPanel player2_map = new JPanel();
    public JLabel player2_label = new JLabel();
    public JLabel player2_label2 = new JLabel();
    public JLabel player2_label3 = new JLabel();
    public JLabel player2_label4 = new JLabel();
    public JLabel player2_label5 = new JLabel();
    public JLabel player2_label6 = new JLabel();
    public JLabel player2_label7 = new JLabel();
    public JLabel player2_label8 = new JLabel();
    public JLabel player2_label9 = new JLabel();
    public JLabel player2_label10 = new JLabel();
    public JLabel player2_label11 = new JLabel();
    public JLabel player2_label12 = new JLabel();

    public JPanel card_center = new JPanel();

    public void myframe (Player p1,Player p2,Card[] cards_1,Card[] cards_2,Card[] cards_3,Card[] cards_prize,SlotMachine[] slot){
        // show the main map...
        JFrame frame = new JFrame();
        frame.setTitle("Amusement Park");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1200, 850);
        frame.setLayout(new BorderLayout());
        ImageIcon image = new ImageIcon("C:\\Users\\sazgar\\Desktop\\ap_midterm\\photo\\ph.jpg");
        frame.setIconImage(image.getImage());
        
        player1_panel(p1,p2,cards_1,cards_2,cards_3,cards_prize,slot);
        player1_map.setBackground(new Color(153,168,170));
        player1_map.setPreferredSize(new Dimension(150, 130));
        player1_map.setLayout(null);


        player2_panel(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
        player2_map.setBackground(new Color(153,168,170));
        player2_map.setPreferredSize(new Dimension(150, 130));
        player2_map.setLayout(null);


        center(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
        card_center.setLayout(null);
        card_center.setBackground(new Color(153,168,170));



        frame.add(player2_map,BorderLayout.NORTH);
        frame.add(player1_map,BorderLayout.SOUTH);
        frame.add(slot_right_panel(p1,p2,cards_1,cards_2,cards_3,cards_prize,slot),BorderLayout.EAST);
        frame.add(card_center,BorderLayout.CENTER);
                    
        
        
        cards_action1(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot, frame);
        cards_action2(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot, frame);
        cards_action3(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot, frame);
        slot_action(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot, frame);
        coin_player1_action(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot, frame);
        coin_player2_action(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot, frame);
        


       
        frame.setVisible(true);

    }



    public void player1_panel(Player p1,Player p2,Card[] cards_1,Card[] cards_2,Card[] cards_3,Card[] cards_prize,SlotMachine[] slot){

        player1_label.setText("Red Coin : " + String.valueOf(p1.countRed));
        player1_label.setBounds(0, -8, 100, 30);
        p1.red_button.setBounds(80, 3, 20, 10);
        player1_map.add(p1.red_button);
        player1_map.add(player1_label);

        player1_label2.setText("Blue Coin : " + String.valueOf(p1.countBlue));
        player1_label2.setBounds(0, 12, 100, 30);
        p1.blue_button.setBounds(85,24,20,10);
        player1_map.add(p1.blue_button);
        player1_map.add(player1_label2);

        player1_label3.setText("Green Coin : " + String.valueOf(p1.countGreen));
        player1_label3.setBounds(0, 32, 100, 30);
        p1.green_button.setBounds(90,43,20,10);
        player1_map.add(p1.green_button);
        player1_map.add(player1_label3);


        player1_label4.setText("White Coin : " + String.valueOf(p1.countwhite));
        player1_label4.setBounds(0,52,100,30);
        p1.white_button.setBounds(85, 64, 20, 10);
        player1_map.add(p1.white_button);
        player1_map.add(player1_label4);

        player1_label5.setText("Black Coin : " + String.valueOf(p1.countBlack));
        player1_label5.setBounds(0, 72, 100, 30);
        p1.black_button.setBounds(83,85,20,10);
        player1_map.add(p1.black_button);
        player1_map.add(player1_label5);

        player1_label6.setText("Gold Coin : " + String.valueOf(p1.countGold));
        player1_label6.setBounds(0, 92, 100, 30);
        player1_map.add(player1_label6);

        player1_label7.setText("Point : " + String .valueOf(p1.point));
        player1_label7.setBounds(1130, 0, 150, 40);
        player1_map.add(player1_label7);

        player1_label8.setText("Special Red Coin : " + String.valueOf(p1.khas_red));
        player1_label8.setBounds(200,-8,200,30);
        player1_map.add(player1_label8);

        player1_label9.setText("Special Blue Coin : " + String.valueOf(p1.khas_blue));
        player1_label9.setBounds(200,12,200,30);
        player1_map.add(player1_label9);

        player1_label10.setText("Special Green Coin : " + String.valueOf(p1.khas_green));
        player1_label10.setBounds(200,32,200,30);
        player1_map.add(player1_label10);

        player1_label11.setText("Special White Coin : " + String.valueOf(p1.khas_white));
        player1_label11.setBounds(200,52,200,30);
        player1_map.add(player1_label11);

        player1_label12.setText("Special Black Coin : " + String.valueOf(p1.khas_black));
        player1_label12.setBounds(200,72,200,30);
        player1_map.add(player1_label12);

        int index = 1;
        for(int i = 0 ; i < 15 ;i++){
            if (cards_1[i].belong_player == 1 && cards_1[i].show_center_map == true){
                cards_1[i].card_panel.setBackground(Color.BLUE);
                cards_1[i].make_reserve_card(index);
                player1_map.add(cards_1[i].buy_Button);
                player1_map.add(cards_1[i].card_panel);
                index++;
            }
        }

        for(int i = 0 ; i < 15 ;i++){
            if (cards_2[i].belong_player == 1 && cards_2[i].show_center_map == true){
                cards_2[i].card_panel.setBackground(Color.BLUE);
                cards_2[i].make_reserve_card(index);
                player1_map.add(cards_2[i].buy_Button);
                player1_map.add(cards_2[i].card_panel);
                index++;
            }
        }



    }



    public void player2_panel(Player p1,Player p2,Card[] cards_1,Card[] cards_2,Card[] cards_3,Card[] cards_prize,SlotMachine[] slot){

        player2_label.setText("Red Coin : " + String.valueOf(p2.countRed));
        player2_label.setBounds(0, -8, 100, 30);
        p2.red_button.setBounds(80, 3, 20, 10);
        player2_map.add(p2.red_button);
        player2_map.add(player2_label);

        player2_label2.setText("Blue Coin : " + String.valueOf(p2.countBlue));
        player2_label2.setBounds(0, 12, 100, 30);
        p2.blue_button.setBounds(85,24,20,10);
        player2_map.add(p2.blue_button);
        player2_map.add(player2_label2);

        player2_label3.setText("Green Coin : " + String.valueOf(p2.countGreen));
        player2_label3.setBounds(0, 32, 100, 30);
        p2.green_button.setBounds(90,43,20,10);
        player2_map.add(p2.green_button);
        player2_map.add(player2_label3);


        player2_label4.setText("White Coin : " + String.valueOf(p2.countwhite));
        player2_label4.setBounds(0,52,100,30);
        p2.white_button.setBounds(85, 64, 20, 10);
        player2_map.add(p2.white_button);
        player2_map.add(player2_label4);

        player2_label5.setText("Black Coin : " + String.valueOf(p2.countBlack));
        player2_label5.setBounds(0, 72, 100, 30);
        p2.black_button.setBounds(83,85,20,10);
        player2_map.add(p2.black_button);
        player2_map.add(player2_label5);

        player2_label6.setText("Gold Coin : " + String.valueOf(p2.countGold));
        player2_label6.setBounds(0, 92, 100, 30);
        player2_map.add(player2_label6);

        player2_label7.setText("Point : " + String.valueOf(p2.point));
        player2_label7.setBounds(1130, 0, 150, 40);
        player2_map.add(player2_label7);

        player2_label8.setText("Special Red Coin : " + String.valueOf(p2.khas_red));
        player2_label8.setBounds(200,-8,200,30);
        player2_map.add(player2_label8);

        player2_label9.setText("Special Blue Coin : " + String.valueOf(p2.khas_blue));
        player2_label9.setBounds(200,12,200,30);
        player2_map.add(player2_label9);

        player2_label10.setText("Special Green Coin : " + String.valueOf(p2.khas_green));
        player2_label10.setBounds(200,32,200,30);
        player2_map.add(player2_label10);

        player2_label11.setText("Special White Coin : " + String.valueOf(p2.khas_white));
        player2_label11.setBounds(200,52,200,30);
        player2_map.add(player2_label11);

        player2_label12.setText("Special Black Coin : " + String.valueOf(p2.khas_black));
        player2_label12.setBounds(200,72,200,30);
        player2_map.add(player2_label12);

        int index = 1;
        for(int i = 0 ; i < 15 ;i++){
            if (cards_1[i].belong_player == 2 && cards_1[i].show_center_map == true){
                cards_1[i].card_panel.setBackground(Color.CYAN);
                cards_1[i].make_reserve_card(index);
                player2_map.add(cards_1[i].buy_Button);
                player2_map.add(cards_1[i].card_panel);
                index++;
            }
        }

        for(int i = 0 ; i < 15 ; i++){
            if (cards_2[i].belong_player == 2 && cards_2[i].show_center_map == true){
                cards_2[i].card_panel.setBackground(Color.CYAN);
                cards_2[i].make_reserve_card(index);
                player2_map.add(cards_2[i].buy_Button);
                player2_map.add(cards_2[i].card_panel);
                index++;
            }
        }


        
    }



    public JPanel slot_right_panel(Player p1,Player p2,Card[] cards_1,Card[] cards_2,Card[] cards_3,Card[] cards_prize,SlotMachine[] slot){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(153,168,170));
        panel.setPreferredSize(new Dimension(150, 150));
        panel.setLayout(null);


        slot[0].slot_panel.setBounds(50, 0, 100, 90);
        slot[0].button.setBounds(85,90,30,15);
        panel.add(slot[0].button);
        panel.add(slot[0].slot_panel);

        slot[1].slot_panel.setBounds(50, 110, 100, 90);
        slot[1].button.setBounds(85,200,30,15);
        panel.add(slot[1].button);
        panel.add(slot[1].slot_panel);

        slot[2].slot_panel.setBounds(50, 220, 100, 90);
        slot[2].button.setBounds(85,310,30,15);
        panel.add(slot[2].button);
        panel.add(slot[2].slot_panel);

        slot[3].slot_panel.setBounds(50, 330, 100, 90);
        slot[3].button.setBounds(85, 420, 30, 15);
        panel.add(slot[3].button);
        panel.add(slot[3].slot_panel);

        slot[4].slot_panel.setBounds(50, 440, 100, 90);
        slot[4].button.setBounds(85, 530, 30, 15);
        panel.add(slot[4].button);
        panel.add(slot[4].slot_panel);



        return panel;
    }


    public void update_map(Player p1,Player p2,Card[] cards_1,Card[] cards_2,Card[] cards_3,Card[] cards_prize,SlotMachine[] slot){
        setb(cards_1, cards_2, cards_3, cards_prize);
        player1_panel(p1,p2,cards_1,cards_2,cards_3,cards_prize,slot);
        player2_panel(p1,p2,cards_1,cards_2,cards_3,cards_prize,slot);
        //setb(cards_1, cards_2, cards_3, cards_prize);
        center(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
    }
    public void center(Player p1,Player p2,Card[] cards_1,Card[] cards_2,Card[] cards_3,Card[] cards_prize,SlotMachine[] slot){
        int count = 0;
        int max = 0;
        for(int i = 0 ; i < 15 ;i++){
            if (cards_1[i].show_center_map == true && cards_1[i].belong_player == 0){
                set_card_mokhtasat(count, cards_1[i]);
                count++;
                max++;
            }
            if (max == 3){
                break;
            }
        }
        int count2 = 3;
        max = 0;
        for(int j = 0 ; j < 15 ;j++){
            if ( cards_2[j].show_center_map == true && cards_2[j].belong_player == 0){
                set_card_mokhtasat(count2, cards_2[j]);
                count2++;
                max++;
            }
            if (max == 3){
                break;
            }
        }
        int count3 = 6;
        max = 0;
        for(int k = 0 ; k < 15 ;k++){
            if ( cards_3[k].show_center_map == true && cards_3[k].belong_player == 0){
                set_card_mokhtasat(count3, cards_3[k]);
                count3++;
                max++;
            }
            if (max == 3){
                break;
            }
        }
        int count4 = 9;
        max = 0;
        for(int d = 0 ; d < 3 ;d++){
            if (cards_prize[d].show_center_map == true && cards_prize[d].belong_player == 0){
                set_card_mokhtasat(count4, cards_prize[d]);
                count4++;
                max++;
            }
            if (max == 3){
                break;
            }
        }
    }

    public void set_card_mokhtasat(int count,Card card){
        if (count == 0){
            card.card_panel.setBounds(0,0,150 ,230);
            card.buy_Button.setBounds(30,240,40,30);
            card.resereve_Button.setBounds(80,240,40,30);
        }
        else if (count == 1){
            card.card_panel.setBounds(170,0 ,150 ,230);
            card.buy_Button.setBounds(200,240,40,30);
            card.resereve_Button.setBounds(250,240,40,30);
        }
        else if (count == 2){
            card.card_panel.setBounds(340,0,150 ,230);
            card.buy_Button.setBounds(370,240,40,30);
            card.resereve_Button.setBounds(420,240,40,30);
        }
        else if (count == 3){
            card.card_panel.setBounds(510, 0,150 ,230);
            card.buy_Button.setBounds(540,240,40,30);
            card.resereve_Button.setBounds(590,240,40,30);
        }
        else if (count == 4){
            card.card_panel.setBounds(680,0 ,150 ,230);
            card.buy_Button.setBounds(710,240,40,30);
            card.resereve_Button.setBounds(760,240,40,30);
        }
        else if (count == 5){
            card.card_panel.setBounds(850,0 ,150 ,230);
            card.buy_Button.setBounds(880,240,40,30);
            card.resereve_Button.setBounds(930,240,40,30);
        }
        else if (count == 6){
            card.card_panel.setBounds(0,280 ,150 ,230);
            card.buy_Button.setBounds(30,520,40,30);
            card.resereve_Button.setBounds(80,520,40,30);
        }
        else if (count == 7){
            card.card_panel.setBounds(170,280 ,150 ,230);
            card.buy_Button.setBounds(200,520,40,30);
            card.resereve_Button.setBounds(250,520,40,30);
        }
        else if (count == 8){
            card.card_panel.setBounds(340,280 ,150 ,230);
            card.buy_Button.setBounds(370,520,40,30);
            card.resereve_Button.setBounds(420,520,40,30);
        }
        else if (count == 9){
            card.card_panel.setBounds(510,280 ,150 ,230);
            //card.buy_Button.setBounds(540,520,40,30);
            //card.resereve_Button.setBounds(590,520,40,30);
        }
        else if (count == 10){
            card.card_panel.setBounds(680,280 ,150 ,230);
            //card.buy_Button.setBounds(710,520,40,30);
            //card.resereve_Button.setBounds(760,520,40,30);
        }
        else if (count == 11){
            card.card_panel.setBounds(850,280 ,150 ,230);
            //card.buy_Button.setBounds(880,520,40,30);
            //card.resereve_Button.setBounds(930,520,40,30);
        }
            card_center.add(card.card_panel);
            card_center.add(card.buy_Button);
            card_center.add(card.resereve_Button);
    }


    public void setb(Card cards_1[],Card cards_2[],Card cards_3[],Card cards_prize[]){
        for(int i = 0 ; i < 15 ;i++){
            cards_1[i].card_panel.setBounds(0, 0, 0, 0);
            cards_1[i].buy_Button.setBounds(0,0,0,0);
            cards_1[i].resereve_Button.setBounds(0,0,0,0);
        }
        for(int i = 0 ; i < 15 ;i++){
            cards_2[i].card_panel.setBounds(0, 0, 0, 0);
            cards_2[i].buy_Button.setBounds(0,0,0,0);
            cards_2[i].resereve_Button.setBounds(0,0,0,0);
        }
        for(int i = 0 ; i < 15 ;i++){
            cards_3[i].card_panel.setBounds(0,0,0,0);
            cards_3[i].buy_Button.setBounds(0,0,0,0);
            cards_3[i].resereve_Button.setBounds(0,0,0,0);
        }
        for(int i = 0 ; i < 3;i++){
            cards_prize[i].card_panel.setBounds(0,0,0,0);
        }
    }
    
    public void cards_action1(Player p1,Player p2,Card[] cards_1,Card[] cards_2,Card[] cards_3,Card[] cards_prize,SlotMachine[] slot,JFrame frame){

        // ooooon show mappppppppppppppppppp kirioooooooooo barayyyyyyy hasmaaaaashooooon bayad falseeeeeee koniiiiiiiiii
        cards_1[0].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_1[0])){
                        p1.buy_card(cards_1[0]);
                        turn = 2;
                        cards_1[0].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_1[0])){
                        turn = 1;
                        p2.buy_card(cards_1[0]);
                        cards_1[0].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_1[1].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_1[1])){
                        p1.buy_card(cards_1[1]);
                        cards_1[1].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_1[1])){
                        p2.buy_card(cards_1[1]);
                        cards_1[1].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_1[2].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_1[2])){
                        p1.buy_card(cards_1[2]);
                        cards_1[2].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_1[2])){
                        p2.buy_card(cards_1[2]);
                        cards_1[2].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_1[3].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_1[3])){
                        p1.buy_card(cards_1[3]);
                        cards_1[3].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_1[3])){
                        p2.buy_card(cards_1[3]);
                        cards_1[3].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_1[4].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_1[4])){
                        p1.buy_card(cards_1[4]);
                        cards_1[4].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_1[4])){
                        p2.buy_card(cards_1[4]);
                        cards_1[4].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_1[5].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_1[5])){
                        p1.buy_card(cards_1[5]);
                        cards_1[5].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 1){
                    if (p2.allow_buy_card(cards_1[5])){
                        p2.buy_card(cards_1[5]);
                        cards_1[5].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
            }
        });

        cards_1[6].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_1[6])){
                        p1.buy_card(cards_1[6]);
                        cards_1[6].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 1){
                    if (p2.allow_buy_card(cards_1[6])){
                        p2.buy_card(cards_1[6]);
                        cards_1[6].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
            }
        });

        cards_1[7].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_1[7])){
                        p1.buy_card(cards_1[7]);
                        cards_1[7].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_1[7])){
                        p2.buy_card(cards_1[7]);
                        cards_1[7].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_1[8].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_1[8])){
                        p1.buy_card(cards_1[8]);
                        cards_1[8].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_1[8])){
                        p2.buy_card(cards_1[8]);
                        cards_1[8].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_1[9].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_1[9])){
                        p1.buy_card(cards_1[9]);
                        cards_1[9].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_1[9])){
                        p2.buy_card(cards_1[9]);
                        cards_1[9].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_1[10].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_1[10])){
                        p1.buy_card(cards_1[10]);
                        cards_1[10].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_1[10])){
                        p2.buy_card(cards_1[10]);
                        cards_1[10].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_1[11].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1 ){
                    if (p1.allow_buy_card(cards_1[11])){
                        p1.buy_card(cards_1[11]);
                        cards_1[11].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_1[11])){
                        p2.buy_card(cards_1[11]);
                        cards_1[11].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_1[12].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_1[12])){
                        p1.buy_card(cards_1[12]);
                        cards_1[12].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_1[12])){
                        p2.buy_card(cards_1[12]);
                        cards_1[12].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_1[13].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_1[13])){
                        p1.buy_card(cards_1[13]);
                        cards_1[13].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_1[13])){
                        p2.buy_card(cards_1[13]);
                        cards_1[13].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
            }
        });

        cards_1[14].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_1[14])){
                        p1.buy_card(cards_1[14]);
                        cards_1[14].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_1[14])){
                        p2.buy_card(cards_1[14]);
                        cards_1[14].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_1[0].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_1[0].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_1[0].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_1[1].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_1[1].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_1[1].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_1[2].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_1[2].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_1[2].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_1[3].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_1[3].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_1[3].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_1[4].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_1[4].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_1[4].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_1[5].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_1[5].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_1[5].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_1[6].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_1[6].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_1[6].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_1[7].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_1[7].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_1[7].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_1[8].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_1[8].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_1[8].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_1[9].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_1[9].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_1[9].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_1[10].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_1[10].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_1[10].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_1[11].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_1[11].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.countGold + p1.countGold < 5){
                        p2.countGold++;
                    }
                    turn = 1;
                    p2.count_reserved_card++;
                    cards_1[11].belong_player = 2;
                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                    frame.setVisible(true);
                }
            }
        });

        cards_1[12].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_1[12].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_1[12].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_1[13].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_1[13].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_1[13].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_1[14].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_1[14].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                        p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_1[14].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });


        
    }
    


    public void slot_action(Player p1,Player p2,Card[] cards_1,Card[] cards_2,Card[] cards_3,Card[] cards_prize,SlotMachine[] slot,JFrame frame){
        slot[0].button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (slot[0].count > 0){
                        if (p1.three_slot > 0){
                            p1.three_slot--;
                            slot[0].add_coin(p1,1);
                            slot[0].button.setVisible(false);
                            update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                            frame.setVisible(true);
                            if (p1.three_slot == 0){
                                if (p1.sum_coin() > 10){
                                    able_coin_button(p1);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    p1.give_slot = p1.sum_coin() - 10;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else{
                                    able_cards(cards_1, cards_2, cards_3);
                                    disable_coin_button(p1);
                                    able_slots(slot);
                                    turn = 2;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                        }
                        else if (p1.three_slot == 0){
                            if (slot[0].count == 4){
                                slot[0].add_coin(p1, 2);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                                if (p1.sum_coin() > 10){
                                    p1.give_slot = p1.sum_coin() - 10;
                                    able_coin_button(p1);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else {
                                    turn = 2;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                            else if (slot[0].count < 4){
                                slot[0].add_coin(p1,1);
                                slot[0].button.setVisible(false);
                                p1.three_slot = 2;
                                disable_cards(cards_1, cards_2, cards_3);
                                disable_coin_button(p1);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                            }
                        }
                    }
                }
                else if (turn == 2){
                    if (slot[0].count > 0){
                        if (p2.three_slot > 0){
                            p2.three_slot--;
                            slot[0].add_coin(p2,1);
                            slot[0].button.setVisible(false);
                            update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                            frame.setVisible(true);
                            if (p2.three_slot == 0){
                                if (p2.sum_coin() > 10){
                                    able_coin_button(p2);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    p2.give_slot = p2.sum_coin() - 10;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else{
                                    able_cards(cards_1, cards_2, cards_3);
                                    disable_coin_button(p2);
                                    able_slots(slot);
                                    turn = 1;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                        }
                        else if (p2.three_slot == 0){
                            if (slot[0].count == 4){
                                slot[0].add_coin(p2, 2);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                                if (p2.sum_coin() > 10){
                                    p2.give_slot = p2.sum_coin() - 10;
                                    able_coin_button(p2);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else {
                                    turn = 1;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                            else if (slot[0].count < 4){
                                slot[0].add_coin(p2,1);
                                slot[0].button.setVisible(false);
                                p2.three_slot = 2;
                                disable_cards(cards_1, cards_2, cards_3);
                                disable_coin_button(p2);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                            }
                        }
                    }
                }
            }
        });

        slot[1].button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (slot[1].count > 0){
                        if (p1.three_slot > 0){
                            p1.three_slot--;
                            slot[1].add_coin(p1,1);
                            slot[1].button.setVisible(false);
                            update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                            frame.setVisible(true);
                            if (p1.three_slot == 0){
                                if (p1.sum_coin() > 10){
                                    able_coin_button(p1);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    p1.give_slot = p1.sum_coin() - 10;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else{
                                    able_cards(cards_1, cards_2, cards_3);
                                    disable_coin_button(p1);
                                    able_slots(slot);
                                    turn = 2;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                        }
                        else if (p1.three_slot == 0){
                            if (slot[1].count == 4){
                                slot[1].add_coin(p1, 2);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                                if (p1.sum_coin() > 10){
                                    p1.give_slot = p1.sum_coin() - 10;
                                    able_coin_button(p1);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else {
                                    turn = 2;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                            else if (slot[1].count < 4){
                                slot[1].add_coin(p1,1);
                                slot[1].button.setVisible(false);
                                p1.three_slot = 2;
                                disable_cards(cards_1, cards_2, cards_3);
                                disable_coin_button(p1);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                            }
                        }
                    }
                }
                else if (turn == 2){
                    if (slot[1].count > 0){
                        if (p2.three_slot > 0){
                            p2.three_slot--;
                            slot[1].add_coin(p2,1);
                            slot[1].button.setVisible(false);
                            update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                            frame.setVisible(true);
                            if (p2.three_slot == 0){
                                if (p2.sum_coin() > 10){
                                    able_coin_button(p2);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    p2.give_slot = p2.sum_coin() - 10;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else{
                                    able_cards(cards_1, cards_2, cards_3);
                                    disable_coin_button(p2);
                                    able_slots(slot);
                                    turn = 1;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                        }
                        else if (p2.three_slot == 0){
                            if (slot[1].count == 4){
                                slot[1].add_coin(p2, 2);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                                if (p2.sum_coin() > 10){
                                    p2.give_slot = p2.sum_coin() - 10;
                                    able_coin_button(p2);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else {
                                    turn = 1;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                            else if (slot[1].count < 4){
                                slot[1].add_coin(p2,1);
                                slot[1].button.setVisible(false);
                                p2.three_slot = 2;
                                disable_cards(cards_1, cards_2, cards_3);
                                disable_coin_button(p2);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                            }
                        }
                    }
                }
            }
        });

        slot[2].button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (slot[2].count > 0){
                        if (p1.three_slot > 0){
                            p1.three_slot--;
                            slot[2].add_coin(p1,1);
                            slot[2].button.setVisible(false);
                            update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                            frame.setVisible(true);
                            if (p1.three_slot == 0){
                                if (p1.sum_coin() > 10){
                                    able_coin_button(p1);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    p1.give_slot = p1.sum_coin() - 10;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else{
                                    able_cards(cards_1, cards_2, cards_3);
                                    disable_coin_button(p1);
                                    able_slots(slot);
                                    turn = 2;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                        }
                        else if (p1.three_slot == 0){
                            if (slot[2].count == 4){
                                slot[2].add_coin(p1, 2);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                                if (p1.sum_coin() > 10){
                                    p1.give_slot = p1.sum_coin() - 10;
                                    able_coin_button(p1);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else {
                                    turn = 2;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                            else if (slot[1].count < 4){
                                slot[2].add_coin(p1,1);
                                slot[2].button.setVisible(false);
                                p1.three_slot = 2;
                                disable_cards(cards_1, cards_2, cards_3);
                                disable_coin_button(p1);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                            }
                        }
                    }
                }
                else if (turn == 2){
                    if (slot[2].count > 0){
                        if (p2.three_slot > 0){
                            p2.three_slot--;
                            slot[2].add_coin(p2,1);
                            slot[2].button.setVisible(false);
                            update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                            frame.setVisible(true);
                            if (p2.three_slot == 0){
                                if (p2.sum_coin() > 10){
                                    able_coin_button(p2);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    p2.give_slot = p2.sum_coin() - 10;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else{
                                    able_cards(cards_1, cards_2, cards_3);
                                    disable_coin_button(p2);
                                    able_slots(slot);
                                    turn = 1;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                        }
                        else if (p2.three_slot == 0){
                            if (slot[2].count == 4){
                                slot[2].add_coin(p2, 2);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                                if (p2.sum_coin() > 10){
                                    p2.give_slot = p2.sum_coin() - 10;
                                    able_coin_button(p2);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else {
                                    turn = 1;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                            else if (slot[2].count < 4){
                                slot[2].add_coin(p2,1);
                                slot[2].button.setVisible(false);
                                p2.three_slot = 2;
                                disable_cards(cards_1, cards_2, cards_3);
                                disable_coin_button(p2);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                            }
                        }
                    }
                }
            }
        });

        slot[3].button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (slot[3].count > 0){
                        if (p1.three_slot > 0){
                            p1.three_slot--;
                            slot[3].add_coin(p1,1);
                            slot[3].button.setVisible(false);
                            update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                            frame.setVisible(true);
                            if (p1.three_slot == 0){
                                if (p1.sum_coin() > 10){
                                    able_coin_button(p1);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    p1.give_slot = p1.sum_coin() - 10;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else{
                                    able_cards(cards_1, cards_2, cards_3);
                                    disable_coin_button(p1);
                                    able_slots(slot);
                                    turn = 2;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                        }
                        else if (p1.three_slot == 0){
                            if (slot[3].count == 4){
                                slot[3].add_coin(p1, 2);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                                if (p1.sum_coin() > 10){
                                    p1.give_slot = p1.sum_coin() - 10;
                                    able_coin_button(p1);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else {
                                    turn = 2;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                            else if (slot[3].count < 4){
                                slot[3].add_coin(p1,1);
                                slot[3].button.setVisible(false);
                                p1.three_slot = 2;
                                disable_cards(cards_1, cards_2, cards_3);
                                disable_coin_button(p1);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                            }
                        }
                    }
                }
                else if (turn == 2){
                    if (slot[3].count > 0){
                        if (p2.three_slot > 0){
                            p2.three_slot--;
                            slot[3].add_coin(p2,1);
                            slot[3].button.setVisible(false);
                            update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                            frame.setVisible(true);
                            if (p2.three_slot == 0){
                                if (p2.sum_coin() > 10){
                                    able_coin_button(p2);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    p2.give_slot = p2.sum_coin() - 10;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else{
                                    able_cards(cards_1, cards_2, cards_3);
                                    disable_coin_button(p2);
                                    able_slots(slot);
                                    turn = 1;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                        }
                        else if (p2.three_slot == 0){
                            if (slot[3].count == 4){
                                slot[3].add_coin(p2, 2);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                                if (p2.sum_coin() > 10){
                                    p2.give_slot = p2.sum_coin() - 10;
                                    able_coin_button(p2);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else {
                                    turn = 1;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                            else if (slot[3].count < 4){
                                slot[3].add_coin(p2,1);
                                slot[3].button.setVisible(false);
                                p2.three_slot = 2;
                                disable_cards(cards_1, cards_2, cards_3);
                                disable_coin_button(p2);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                            }
                        }
                    }
                }
            }
        });

        slot[4].button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (slot[4].count > 0){
                        if (p1.three_slot > 0){
                            p1.three_slot--;
                            slot[4].add_coin(p1,1);
                            slot[4].button.setVisible(false);
                            update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                            frame.setVisible(true);
                            if (p1.three_slot == 0){
                                if (p1.sum_coin() > 10){
                                    able_coin_button(p1);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    p1.give_slot = p1.sum_coin() - 10;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else{
                                    able_cards(cards_1, cards_2, cards_3);
                                    disable_coin_button(p1);
                                    able_slots(slot);
                                    turn = 2;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                        }
                        else if (p1.three_slot == 0){
                            if (slot[4].count == 4){
                                slot[4].add_coin(p1, 2);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                                if (p1.sum_coin() > 10){
                                    p1.give_slot = p1.sum_coin() - 10;
                                    able_coin_button(p1);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else {
                                    turn = 2;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                            else if (slot[4].count < 4){
                                slot[4].add_coin(p1,1);
                                slot[4].button.setVisible(false);
                                p1.three_slot = 2;
                                disable_cards(cards_1, cards_2, cards_3);
                                disable_coin_button(p1);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                            }
                        }
                    }
                }
                else if (turn == 2){
                    if (slot[4].count > 0){
                        if (p2.three_slot > 0){
                            p2.three_slot--;
                            slot[4].add_coin(p2,1);
                            slot[4].button.setVisible(false);
                            update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                            frame.setVisible(true);
                            if (p2.three_slot == 0){
                                if (p2.sum_coin() > 10){
                                    able_coin_button(p2);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    p2.give_slot = p2.sum_coin() - 10;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else{
                                    able_cards(cards_1, cards_2, cards_3);
                                    disable_coin_button(p2);
                                    able_slots(slot);
                                    turn = 1;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                        }
                        else if (p2.three_slot == 0){
                            if (slot[4].count == 4){
                                slot[4].add_coin(p2, 2);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                                if (p2.sum_coin() > 10){
                                    p2.give_slot = p2.sum_coin() - 10;
                                    able_coin_button(p2);
                                    disable_cards(cards_1, cards_2, cards_3);
                                    disable_slots(slot);
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                                else {
                                    turn = 1;
                                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                    frame.setVisible(true);
                                }
                            }
                            else if (slot[4].count < 4){
                                slot[4].add_coin(p2,1);
                                slot[4].button.setVisible(false);
                                p2.three_slot = 2;
                                disable_cards(cards_1, cards_2, cards_3);
                                disable_coin_button(p2);
                                update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                                frame.setVisible(true);
                            }
                        }
                    }
                }
            }
        });
    
    }

    public void disable_cards(Card cards_1[],Card cards_2[],Card cards_3[]){
        for(int i = 0 ; i < 15 ;i++){
            cards_1[i].buy_Button.setVisible(false);
            cards_2[i].buy_Button.setVisible(false);
            cards_3[i].buy_Button.setVisible(false);

            cards_1[i].resereve_Button.setVisible(false);
            cards_2[i].resereve_Button.setVisible(false);
            cards_3[i].resereve_Button.setVisible(false);
        }
    }
    
    public void able_cards(Card cards_1[],Card cards_2[],Card cards_3[]){
        for(int i = 0 ; i < 15 ;i++){
            cards_1[i].buy_Button.setVisible(true);
            cards_2[i].buy_Button.setVisible(true);
            cards_3[i].buy_Button.setVisible(true);

            cards_1[i].resereve_Button.setVisible(true);
            cards_2[i].resereve_Button.setVisible(true);
            cards_3[i].resereve_Button.setVisible(true);
        }
    }

    public void able_coin_button(Player p){
        p.black_button.setVisible(true);
        p.blue_button.setVisible(true);
        p.green_button.setVisible(true);
        p.red_button.setVisible(true);
        p.white_button.setVisible(true);
    }
    public void disable_coin_button(Player p){
        p.black_button.setVisible(false);
        p.blue_button.setVisible(false);
        p.green_button.setVisible(false);
        p.red_button.setVisible(false);
        p.white_button.setVisible(false);
    }

    public void able_slots(SlotMachine slot[]){
        for(int i = 0 ; i < 5 ;i++){
            slot[i].button.setVisible(true);
        }
    }

    public void disable_slots(SlotMachine slot[]){
        for(int i = 0 ; i < 5 ;i++){
            slot[i].button.setVisible(false);
        }
    }

    public void cards_action3(Player p1,Player p2,Card[] cards_1,Card[] cards_2,Card[] cards_3,Card[] cards_prize,SlotMachine[] slot,JFrame frame){
        cards_3[0].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_3[0])){
                        p1.buy_card(cards_3[0]);
                        turn = 2;
                        cards_3[0].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_3[0])){
                        turn = 1;
                        p2.buy_card(cards_3[0]);
                        cards_3[0].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_3[1].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_3[1])){
                        p1.buy_card(cards_3[1]);
                        cards_3[1].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_3[1])){
                        p2.buy_card(cards_3[1]);
                        cards_3[1].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_3[2].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_3[2])){
                        p1.buy_card(cards_3[2]);
                        cards_3[2].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_3[2])){
                        p2.buy_card(cards_3[2]);
                        cards_3[2].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_3[3].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_3[3])){
                        p1.buy_card(cards_3[3]);
                        cards_3[3].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_3[3])){
                        p2.buy_card(cards_3[3]);
                        cards_3[3].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_3[4].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_3[4])){
                        p1.buy_card(cards_3[4]);
                        cards_3[4].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_3[4])){
                        p2.buy_card(cards_3[4]);
                        cards_3[4].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_3[5].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_3[5])){
                        p1.buy_card(cards_3[5]);
                        cards_3[5].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 1){
                    if (p2.allow_buy_card(cards_3[5])){
                        p2.buy_card(cards_3[5]);
                        cards_3[5].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
            }
        });

        cards_3[6].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_3[6])){
                        p1.buy_card(cards_3[6]);
                        cards_3[6].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 1){
                    if (p2.allow_buy_card(cards_3[6])){
                        p2.buy_card(cards_3[6]);
                        cards_3[6].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
            }
        });

        cards_3[7].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_3[7])){
                        p1.buy_card(cards_3[7]);
                        cards_3[7].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_3[7])){
                        p2.buy_card(cards_3[7]);
                        cards_3[7].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_3[8].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_3[8])){
                        p1.buy_card(cards_3[8]);
                        cards_3[8].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_3[8])){
                        p2.buy_card(cards_3[8]);
                        cards_3[8].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_3[9].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_3[9])){
                        p1.buy_card(cards_3[9]);
                        cards_3[9].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_3[9])){
                        p2.buy_card(cards_3[9]);
                        cards_3[9].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_3[10].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_3[10])){
                        p1.buy_card(cards_3[10]);
                        cards_3[10].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_3[10])){
                        p2.buy_card(cards_3[10]);
                        cards_3[10].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_3[11].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1 ){
                    if (p1.allow_buy_card(cards_3[11])){
                        p1.buy_card(cards_3[11]);
                        cards_3[11].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_3[11])){
                        p2.buy_card(cards_3[11]);
                        cards_3[11].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_3[12].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_3[12])){
                        p1.buy_card(cards_3[12]);
                        cards_3[12].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_3[12])){
                        p2.buy_card(cards_3[12]);
                        cards_3[12].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_3[13].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_3[13])){
                        p1.buy_card(cards_3[13]);
                        cards_3[13].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_3[13])){
                        p2.buy_card(cards_3[13]);
                        cards_3[13].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
            }
        });

        cards_3[14].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_3[14])){
                        p1.buy_card(cards_3[14]);
                        cards_3[14].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_3[14])){
                        p2.buy_card(cards_3[14]);
                        cards_3[14].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_3[0].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_3[0].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_3[0].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_3[1].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_3[1].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_3[1].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_3[2].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_3[2].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_3[2].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_3[3].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_3[3].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_3[3].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_3[4].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_3[4].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_3[4].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_3[5].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_3[5].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_3[5].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_3[6].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_3[6].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_3[6].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_3[7].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_3[7].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_3[7].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_3[8].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_3[8].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_3[8].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_3[9].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_3[9].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_3[9].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_3[10].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_3[10].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_3[10].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_3[11].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_3[11].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.countGold + p1.countGold < 5){
                        p2.countGold++;
                    }
                    turn = 1;
                    p2.count_reserved_card++;
                    cards_3[11].belong_player = 2;
                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                    frame.setVisible(true);
                }
            }
        });

        cards_3[12].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_3[12].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_3[12].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_3[13].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_3[13].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_3[13].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_3[14].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_2[14].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                        p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_3[14].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });
    }
    public void coin_player1_action(Player p1,Player p2,Card[] cards_1,Card[] cards_2,Card[] cards_3,Card[] cards_prize,SlotMachine[] slot,JFrame frame){
        p1.black_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(p1.countBlack > 0){
                    p1.give_slot--;
                    p1.countBlack--;
                    slot[3].count++;
                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                    frame.setVisible(true);
                    if (p1.give_slot == 0){
                        able_cards(cards_1, cards_2, cards_3);
                        disable_coin_button(p1);
                        able_slots(slot);
                        turn = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                } 
            }
        });
        p1.blue_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(p1.countBlue > 0){
                    p1.give_slot--;
                    p1.countBlue--;
                    slot[1].count++;
                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                    frame.setVisible(true);
                    if (p1.give_slot == 0){
                        able_cards(cards_1, cards_2, cards_3);
                        disable_coin_button(p1);
                        able_slots(slot);
                        turn = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                } 
            }
        });
        p1.white_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(p1.countwhite > 0){
                    p1.give_slot--;
                    p1.countwhite--;
                    slot[2].count++;
                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                    frame.setVisible(true);
                    if (p1.give_slot == 0){
                        able_cards(cards_1, cards_2, cards_3);
                        disable_coin_button(p1);
                        able_slots(slot);
                        turn = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                } 
            }
        });
        p1.green_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(p1.countGreen > 0){
                    p1.give_slot--;
                    p1.countGreen--;
                    slot[0].count++;
                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                    frame.setVisible(true);
                    if (p1.give_slot == 0){
                        able_cards(cards_1, cards_2, cards_3);
                        disable_coin_button(p1);
                        able_slots(slot);
                        turn = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                } 
            }
        });
        p1.red_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(p1.countRed > 0){
                    p1.give_slot--;
                    p1.countRed--;
                    slot[4].count++;
                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                    frame.setVisible(true);
                    if (p1.give_slot == 0){
                        able_cards(cards_1, cards_2, cards_3);
                        disable_coin_button(p1);
                        able_slots(slot);
                        turn = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                } 
            }
        });
    }
    public void coin_player2_action(Player p1,Player p2,Card[] cards_1,Card[] cards_2,Card[] cards_3,Card[] cards_prize,SlotMachine[] slot,JFrame frame){
        p2.black_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(p2.countBlack > 0){
                    p2.give_slot--;
                    p2.countBlack--;
                    slot[3].count++;
                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                    frame.setVisible(true);
                    if (p1.give_slot == 0){
                        able_cards(cards_1, cards_2, cards_3);
                        disable_coin_button(p2);
                        able_slots(slot);
                        turn = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                } 
            }
        });
        p2.blue_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(p2.countBlue > 0){
                    p2.give_slot--;
                    p2.countBlue--;
                    slot[1].count++;
                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                    frame.setVisible(true);
                    if (p2.give_slot == 0){
                        able_cards(cards_1, cards_2, cards_3);
                        disable_coin_button(p2);
                        able_slots(slot);
                        turn = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                } 
            }
        });
        p2.white_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(p2.countwhite > 0){
                    p2.give_slot--;
                    p2.countwhite--;
                    slot[2].count++;
                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                    frame.setVisible(true);
                    if (p2.give_slot == 0){
                        able_cards(cards_1, cards_2, cards_3);
                        disable_coin_button(p2);
                        able_slots(slot);
                        turn = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                } 
            }
        });
        p2.green_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(p2.countGreen > 0){
                    p2.give_slot--;
                    p2.countGreen--;
                    slot[0].count++;
                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                    frame.setVisible(true);
                    if (p2.give_slot == 0){
                        able_cards(cards_1, cards_2, cards_3);
                        disable_coin_button(p2);
                        able_slots(slot);
                        turn = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                } 
            }
        });
        p2.red_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(p2.countRed > 0){
                    p2.give_slot--;
                    p2.countRed--;
                    slot[4].count++;
                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                    frame.setVisible(true);
                    if (p2.give_slot == 0){
                        able_cards(cards_1, cards_2, cards_3);
                        disable_coin_button(p2);
                        able_slots(slot);
                        turn = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                } 
            }
        });
    }
    public void cards_action2(Player p1,Player p2,Card[] cards_1,Card[] cards_2,Card[] cards_3,Card[] cards_prize,SlotMachine[] slot,JFrame frame){
        cards_2[0].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_2[0])){
                        p1.buy_card(cards_2[0]);
                        turn = 2;
                        cards_2[0].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_2[0])){
                        turn = 1;
                        p2.buy_card(cards_2[0]);
                        cards_2[0].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_2[1].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_2[1])){
                        p1.buy_card(cards_2[1]);
                        cards_2[1].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_2[1])){
                        p2.buy_card(cards_2[1]);
                        cards_2[1].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_2[2].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_2[2])){
                        p1.buy_card(cards_2[2]);
                        cards_2[2].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_2[2])){
                        p2.buy_card(cards_2[2]);
                        cards_2[2].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_2[3].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_2[3])){
                        p1.buy_card(cards_2[3]);
                        cards_2[3].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_2[3])){
                        p2.buy_card(cards_2[3]);
                        cards_2[3].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_2[4].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_2[4])){
                        p1.buy_card(cards_2[4]);
                        cards_2[4].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_2[4])){
                        p2.buy_card(cards_2[4]);
                        cards_2[4].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_2[5].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_2[5])){
                        p1.buy_card(cards_2[5]);
                        cards_2[5].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 1){
                    if (p2.allow_buy_card(cards_2[5])){
                        p2.buy_card(cards_2[5]);
                        cards_2[5].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
            }
        });

        cards_2[6].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_2[6])){
                        p1.buy_card(cards_2[6]);
                        cards_2[6].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 1){
                    if (p2.allow_buy_card(cards_2[6])){
                        p2.buy_card(cards_2[6]);
                        cards_2[6].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
            }
        });

        cards_2[7].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_2[7])){
                        p1.buy_card(cards_2[7]);
                        cards_2[7].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_2[7])){
                        p2.buy_card(cards_2[7]);
                        cards_2[7].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_2[8].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_2[8])){
                        p1.buy_card(cards_2[8]);
                        cards_2[8].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_2[8])){
                        p2.buy_card(cards_2[8]);
                        cards_2[8].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_2[9].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_2[9])){
                        p1.buy_card(cards_2[9]);
                        cards_2[9].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_2[9])){
                        p2.buy_card(cards_2[9]);
                        cards_2[9].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_2[10].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_2[10])){
                        p1.buy_card(cards_2[10]);
                        cards_2[10].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_2[10])){
                        p2.buy_card(cards_2[10]);
                        cards_2[10].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_2[11].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1 ){
                    if (p1.allow_buy_card(cards_2[11])){
                        p1.buy_card(cards_2[11]);
                        cards_2[11].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_2[11])){
                        p2.buy_card(cards_2[11]);
                        cards_2[11].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_2[12].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_2[12])){
                        p1.buy_card(cards_2[12]);
                        cards_2[12].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_2[12])){
                        p2.buy_card(cards_2[12]);
                        cards_2[12].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_2[13].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_2[13])){
                        p1.buy_card(cards_2[13]);
                        cards_2[13].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_2[13])){
                        p2.buy_card(cards_2[13]);
                        cards_2[13].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
            }
        });

        cards_2[14].buy_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.allow_buy_card(cards_2[14])){
                        p1.buy_card(cards_2[14]);
                        cards_2[14].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 2;
                    }
                }
                else if (turn == 2){
                    if (p2.allow_buy_card(cards_2[14])){
                        p2.buy_card(cards_2[14]);
                        cards_2[14].show_center_map = false;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                        turn = 1;
                    }
                }
            }
        });

        cards_2[0].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_2[0].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_2[0].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_2[1].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_2[1].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_2[1].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_2[2].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_2[2].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_2[2].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_2[3].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_2[3].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_2[3].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_2[4].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_2[4].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_2[4].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_2[5].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_2[5].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_2[5].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_2[6].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_2[6].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_2[6].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_2[7].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_2[7].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_2[7].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_2[8].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_2[8].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_2[8].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_2[9].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_2[9].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_2[9].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_2[10].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_2[10].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_2[10].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_2[11].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_2[11].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.countGold + p1.countGold < 5){
                        p2.countGold++;
                    }
                    turn = 1;
                    p2.count_reserved_card++;
                    cards_2[11].belong_player = 2;
                    update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                    frame.setVisible(true);
                }
            }
        });

        cards_2[12].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_2[12].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_2[12].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_2[13].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_2[13].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                            p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_2[13].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });

        cards_2[14].resereve_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn == 1){
                    if (p1.count_reserved_card < 3){
                        if (p1.countGold + p2.countGold < 5){
                            p1.countGold++;
                        }
                        turn = 2;
                        p1.count_reserved_card++;
                        cards_2[14].belong_player = 1;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
                else if (turn == 2){
                    if (p2.count_reserved_card < 3){
                        if (p2.countGold + p1.countGold < 5){
                        p2.countGold++;
                        }
                        turn = 1;
                        p2.count_reserved_card++;
                        cards_2[14].belong_player = 2;
                        update_map(p1, p2, cards_1, cards_2, cards_3, cards_prize, slot);
                        frame.setVisible(true);
                    }
                }
            }
        });
    }
}

