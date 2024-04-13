import java.awt.*;
import javax.swing.*;

public class Player { //green = 0   blue = 1   white = 2    black = 3     red = 4    prize = 5  
    public int point = 0;
    public int player;

    public int countBlue = 0;
    public int countRed = 0;
    public int countwhite = 0;
    public int countBlack = 0;
    public int countGreen = 0;
    public int countGold = 0;
    public int komaki_gold = 0;

    public int khas_blue = 0;
    public int khas_red = 0;
    public int khas_white = 0;
    public int khas_black = 0;
    public int khas_green = 0;

    public Card reserved_card[] = new Card[3];
    public int count_reserved_card = 0;

    public int give_slot = 0;
    public int three_slot = 0;


    public JButton blue_button;
    public JButton red_button;
    public JButton white_button;
    public JButton black_button;
    public JButton green_button;


    public Player(int player){
        this.player = player;
        this.make_coin_button();
    }

    public static int check_winner(Player p1,Player p2){
        if (p1.point >= 15 ){
            return 1;
        }
        else if (p2.point >= 15){
            return 2;
        }
        else {
            return 0;
        }
    }

    public void buy_card(Card c){
        //                                  black count
        if (this.countBlack + this.khas_black >= c.coin_Black){
            this.countBlack = this.countBlack + this.khas_black - c.coin_Black;
        }
        else if (this.countBlack + this.khas_black + this.countGold >= c.coin_Black){
            int temp_black = this.countBlack + this.countGold + this.khas_black - c.coin_Black;
            this.countGold = this.countGold + this.countBlack + this.khas_black - c.coin_Black;
            this.countBlack = temp_black;
        }

        //                                   green count
        if (this.countGreen + this.khas_green >= c.coin_Green){
            this.countGreen = this.countGreen + this.khas_green - c.coin_Green;
        }
        else if(this.countGreen + this.khas_green + this.countGold >= c.coin_khas){
            int temp_green = this.countGreen + this.countGold + this.khas_green - c.coin_Green;
            this.countGold = this.countGold + this.countGreen + this.khas_green - c.coin_Green;
            this.countGreen = temp_green;
        }
        //                                   blue count
        if (this.countBlue + this.khas_blue >= c.coin_Blue){
            this.countBlue = this.countBlue + this.khas_blue - c.coin_Blue;
        }
        else if (this.countBlue + this.khas_blue + this.countGold >= c.coin_Blue){
            int temp_blue = this.countBlue + this.khas_blue + this.countGold - c.coin_Blue;
            this.countGold = this.countGold + this.khas_blue + this.countBlue - c.coin_Blue;
            this.countBlue = temp_blue;
        }

        //                                     white count
        if (this.countwhite + this.khas_white >= c.coin_White){
            this.countwhite = this.countwhite + this.khas_white - c.coin_White;
        }
        else if (this.countwhite + this.khas_white + this.countGold >= c.coin_White){
            int temp_white = this.countwhite + this.khas_white + this.countGold - c.coin_White;
            this.countGold = this.countwhite + this.khas_white + this.countGold - c.coin_White;
            this.countwhite = temp_white;
        }

        //                                      red count
        if (this.countRed + this.khas_red >= c.coin_Red){
            this.countRed = this.countRed + this.khas_red - c.coin_Red;
        }
        else if (this.countRed + this.khas_red + this.countGold >= c.coin_Red){
            int temp_red = this.countRed + this.khas_red + this.countGold - c.coin_Red;
            this.countGold = this.countRed + this.khas_red + this.countGold - c.coin_Red;
            this.countwhite = temp_red;
        }

        /// generate     count    golddddddd
        this.komaki_gold = this.countGold;
        this.point += c.point;
        Card.khas_add_player(this, c);
    }



    public boolean allow_buy_card(Card c){
        //                     black
        if (this.countBlack + this.khas_black + this.komaki_gold < c.coin_Black){
            return false;
        }
        else if (this.countBlack + this.khas_black + this.komaki_gold >= c.coin_Black){
            if (this.countBlack + this.khas_black < c.coin_Black){
                this.komaki_gold = this.komaki_gold + this.countBlack + this.khas_black - c.coin_Black;
            }
        }
        //                     blue

        if (this.countBlue + this.khas_blue + this.komaki_gold < c.coin_Blue){
            return false;
        }
        else if (this.countBlue + this.countBlue + this.komaki_gold >= c.coin_Blue){
            if (this.countBlue + this.khas_blue < c.coin_Blue){
                this.komaki_gold = this.komaki_gold + this.countBlue + this.khas_blue - c.coin_Blue;
            }
        }
        //                     green

        if (this.countGreen + this.khas_green + this.komaki_gold < c.coin_Green){
            return false;
        }
        else if (this.countGreen + this.khas_green + this.komaki_gold >= c.coin_Green){
            if (this.countGreen + this.khas_green < c.coin_Green){
                this.komaki_gold = this.komaki_gold + this.countGreen + this.khas_green - c.coin_Green;
            }
        }
        //                    white

        if (this.countwhite + this.khas_white + this.komaki_gold < c.coin_White){
            return false;
        }
        else if(this.countwhite + this.khas_white + this.komaki_gold >= c.coin_White){
            if (this.countwhite + this.khas_white < c.coin_White){
                this.komaki_gold = this.komaki_gold + this.countwhite + this.khas_white - c.coin_White;
            }
        }
        //                    red

        if (this.countRed + this.khas_red + this.komaki_gold < c.coin_Red){
            return false;
        }
        else if(this.countRed + this.khas_red + this.komaki_gold >= c.coin_Red){
            if (this.countRed + this.khas_red < c.coin_Red){
                this.komaki_gold = this.komaki_gold + this.countRed + this.khas_red - c.coin_Red;
            }
        }
        return true;

    }


    public boolean add_reserved_card(Card c){
        if (this.count_reserved_card >= 3 ||c.belong_player != 0){
            return false;
        }
        this.reserved_card[count_reserved_card] = c;
        c.belong_player = this.player;
        c.is_reserved = this.player;
        this.count_reserved_card++;
        return true;
    }

    private void make_coin_button(){
        this.blue_button = new JButton();
        this.blue_button.setBackground(Color.BLUE);
        this.blue_button.setVisible(false);

        this.black_button = new JButton();
        this.black_button.setBackground(Color.BLACK);
        this.black_button.setVisible(false);

        this.red_button = new JButton();
        this.red_button.setBackground(Color.RED);
        this.red_button.setVisible(false);

        this.white_button = new JButton();
        this.white_button.setBackground(Color.WHITE);
        this.white_button.setVisible(false);

        this.green_button = new JButton();
        this.green_button.setBackground(Color.GREEN);
        this.green_button.setVisible(false);
    }
    public int sum_coin(){
        return this.countBlack + this.countBlue + this.countGreen + this.countRed + this.countwhite + this.countGold;
    }
}