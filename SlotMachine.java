import javax.swing.*;
import java.awt.*;

public class SlotMachine { // green = 0   blue = 1   white = 2    black = 3     red = 4  ......
    public int model;                
    public int count = 4;
    public JPanel slot_panel;
    public Icon photo;
    public JButton button;

    public SlotMachine(int model){
        this.model = model;
        this.make_slot_photo();
    }

    //                             ........................in okeye............................
    public void add_coin(Player p,int repeat){
        for(int i = 0 ; i < repeat;i++){
            if (this.count > 0){
            switch (this.model){
                case 0:
                p.countGreen++;
                this.count--;
                break;
    
                case 1:
                p.countBlue++;
                this.count--;
                break;
    
                case 2:
                p.countwhite++;
                this.count--;
                break;
    
                case 3:
                p.countBlack++;
                this.count--;
                break;
    
                case 4:
                p.countRed++;
                this.count--;
                break;
            }
        }
        }
    }
    public void make_slot_photo(){
        this.slot_panel = new JPanel();
        this.slot_panel.setLayout(new BorderLayout());
        JLabel slot_label = new JLabel();


        switch(this.model){
            case 0:
            this.photo = new ImageIcon("C:\\Users\\sazgar\\Desktop\\ap_midterm\\photo\\greenslot.jpg");
            slot_label.setIcon(photo);
            this.slot_panel.add(slot_label,JLabel.CENTER);
            this.slot_panel.setBackground(Color.green);
            this.button = new JButton();
            this.button.setBackground(Color.GREEN);
            break;

            case 1:
            this.photo = new ImageIcon("C:\\Users\\sazgar\\Desktop\\ap_midterm\\photo\\blueslot.jpg");
            slot_label.setIcon(photo);
            this.slot_panel.add(slot_label,JLabel.CENTER);
            this.slot_panel.setBackground(Color.BLUE);
            this.button = new JButton();
            this.button.setBackground(Color.BLUE);
            break;

            case 2:
            this.photo = new ImageIcon("C:\\Users\\sazgar\\Desktop\\ap_midterm\\photo\\whiteslot.jpg");
            slot_label.setIcon(photo);
            this.slot_panel.add(slot_label,JLabel.CENTER);
            this.slot_panel.setBackground(Color.white);
            this.button = new JButton();
            this.button.setBackground(Color.WHITE);
            break;

            case 3:
            this.photo = new ImageIcon("C:\\Users\\sazgar\\Desktop\\ap_midterm\\photo\\blackslot.jpg");
            slot_label.setIcon(photo);
            this.slot_panel.add(slot_label,JLabel.CENTER);
            this.slot_panel.setBackground(Color.BLACK);
            this.button = new JButton();
            this.button.setBackground(Color.BLACK);
            break;

            case 4:
            this.photo = new ImageIcon("C:\\Users\\sazgar\\Desktop\\ap_midterm\\photo\\redslot.jpg");
            slot_label.setIcon(photo);
            this.slot_panel.add(slot_label,JLabel.CENTER);
            this.slot_panel.setBackground(Color.RED);
            this.button = new JButton();
            this.button.setBackground(Color.RED);
            break;

        }
    }
}
