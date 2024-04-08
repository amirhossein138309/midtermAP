import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class Card { // green = 0   blue = 1   white = 2    black = 3     red = 4
    public int point;
    public int level;
    public int coin_khas;
    public int coin_Black;
    public int coin_Red;
    public int coin_Green;
    public int coin_White;
    public int coin_Blue;
    public int belong_player = 0;
    public int is_reserved = 0;
    public boolean show_center_map = true;



    public JPanel card_panel;
    public ImageIcon photo;
    public JLabel card_info;
    public JLabel add_card_photo;
    public JLabel add_card_khas;


    public JButton resereve_Button;
    public JButton buy_Button;

    public Card(int level,int point , int coin_khas,int coin_Black,int coin_Red,int coin_White,int coin_Blue,int coin_Green){
        this.point = point;
        this.level = level;
        this.coin_khas = coin_khas;
        this.coin_Black = coin_Black;
        this.coin_Red = coin_Red;
        this.coin_White = coin_White;
        this.coin_Blue = coin_Blue;
        this.coin_Green = coin_Green;
        this.belong_player = 0;
        this.show_center_map = true;
        this.is_reserved = 0;
        this.make_card_photo();
    }
    
    public static void khas_add_player(Player p,Card c){
        switch (c.coin_khas){

            case 0:
            p.khas_green++;
            break;

            case 1:
            p.khas_blue++;
            break;

            case 2:
            p.khas_white++;
            break;

            case 3:
            p.khas_black++;
            break;

            case 4:
            p.khas_red++;
            break;
        }
    }
    public static void add_prize_card(Player p,Card c[]){
        for(int i = 0 ; i < c.length;i++){
            if (c[i].belong_player == 0){
                if (p.khas_black >= c[i].coin_Black && p.countBlue >= c[i].coin_Blue && p.countGreen >= c[i].coin_Green && p.countRed >= c[i].coin_Red && p.countwhite >= c[i].coin_White){
                    c[i].belong_player = p.player;
                    p.point += c[i].point;
                    break;
                }
            }
        }
    }
    private void make_card_photo(){
        this.card_panel = new JPanel();
        this.card_panel.setLayout(new BorderLayout());
        this.card_panel.setBackground(Color.yellow);

        this.card_info = new JLabel(this.state_card());
        this.card_panel.add(this.card_info,BorderLayout.SOUTH);

        //JLabel add_card_photo;
        //JLabel add_card_khas;

        this.buy_Button = new JButton("Buy");
        this.resereve_Button = new JButton("Reserve");

        switch(this.coin_khas){

            case 0:
            this.add_card_khas = new JLabel("   "+String.valueOf(this.point) + "                            Green");
            this.card_panel.add(add_card_khas,BorderLayout.NORTH);
            break;

            case 1:
            this.add_card_khas = new JLabel("   "+String.valueOf(this.point) + "                             Blue");
            this.card_panel.add(add_card_khas,BorderLayout.NORTH);
            break;

            case 2:
            this.add_card_khas = new JLabel("   "+String.valueOf(this.point) + "                            White");
            this.card_panel.add(add_card_khas,BorderLayout.NORTH);
            break;

            case 3:
            this.add_card_khas = new JLabel("   "+String.valueOf(this.point) + "                            Black");
            this.card_panel.add(add_card_khas,BorderLayout.NORTH);
            break;

            case 4:
            this.add_card_khas = new JLabel("   "+String.valueOf(this.point) + "                             Red");
            this.card_panel.add(add_card_khas,BorderLayout.NORTH);
            break;

            case 5:
            this.add_card_khas = new JLabel("   " + String.valueOf(this.point) + "                      Prize Card");
            this.card_panel.add(add_card_khas,BorderLayout.NORTH);
            break;

        }



        switch (this.level){
            case 0:
            photo = new ImageIcon("C:\\Users\\sazgar\\Desktop\\ap_midterm\\photo\\level_0.jpg");
            this.add_card_photo = new JLabel(photo);
            this.card_panel.add(add_card_photo,BorderLayout.CENTER);
            break;

            
            case 1:
            photo = new ImageIcon("C:\\Users\\sazgar\\Desktop\\ap_midterm\\photo\\level_1.jpg");
            this.add_card_photo = new JLabel(photo);
            this.card_panel.add(add_card_photo,BorderLayout.CENTER);
            break;

            case 2:
            photo = new ImageIcon("C:\\Users\\sazgar\\Desktop\\ap_midterm\\photo\\level_2.jpg");
            this.add_card_photo = new JLabel(photo);
            this.card_panel.add(add_card_photo,BorderLayout.CENTER);
            break;

            case 3:
            photo = new ImageIcon("C:\\Users\\sazgar\\Desktop\\ap_midterm\\photo\\level_3.jpg");
            this.add_card_photo = new JLabel(photo);
            this.card_panel.add(add_card_photo,BorderLayout.CENTER);
            break;
            
        }
    }


    
    public String state_card(){
        String state = "";
        if (this.coin_Black > 0){
            state += "Black:" + String.valueOf(this.coin_Black);
        }
        if (this.coin_Blue > 0){
            state += "Blue:" + String.valueOf(this.coin_Blue);
        }
        if (this.coin_Green > 0){
            state += "Green:" + String.valueOf(this.coin_Green);
        }
        if (this.coin_Red > 0){
            state += "Red:" + String.valueOf(this.coin_Red); 
        }
        if (this.coin_White > 0){
            state += "White" + String.valueOf(this.coin_White);
        }
        return state;
    }
    public void make_reserve_card(int index){
        ImageIcon ph;
        //this.card_panel.setBackground(Color.BLUE);
        switch(this.level){
            case 1:
            ph = new ImageIcon("C:\\Users\\sazgar\\Desktop\\ap_midterm - Copy\\photo\\level_1re.jpg");
            this.add_card_photo.setIcon(ph);
            this.card_panel.add(this.add_card_photo,BorderLayout.CENTER);
            break;

            case 2:
            ph = new ImageIcon("C:\\Users\\sazgar\\Desktop\\ap_midterm - Copy\\photo\\level_1re.jpg");
            this.add_card_photo.setIcon(ph);
            this.card_panel.add(this.add_card_photo,BorderLayout.CENTER);
            break;

            case 3:
            ph = new ImageIcon("C:\\Users\\sazgar\\Desktop\\ap_midterm - Copy\\photo\\level_1re.jpg");
            this.add_card_photo.setIcon(ph);
            this.card_panel.add(this.add_card_photo,BorderLayout.CENTER);
        }
        this.resereve_Button.setBounds(0, 0, 0, 0);

        if (index == 1){
            this.card_panel.setBounds(400,0 ,70,90);
            this.buy_Button.setBounds(423,95,20,10);
        }
        else if (index == 2){
            this.card_panel.setBounds(500,0,70,90);
            this.buy_Button.setBounds(523,95,20,10);
        }
        else if (index == 3){
            this.card_panel.setBounds(600,0,70,90);
            this.buy_Button.setBounds(623,95,20,10);
        }

    }
}
