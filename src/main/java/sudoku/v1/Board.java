package sudoku.v1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board implements ActionListener {

    private final static int WIDTH = 1100;
    private final static int HEIGHT = 1100;
    //create game frame + banner + grid
    JFrame frame = new JFrame();
    JLabel sudokuSign = new JLabel();
    JPanel sudokuSignBanner = new JPanel();
    JPanel bordersNorth = new JPanel();
    JPanel bordersWest = new JPanel();
    JPanel bordersEast = new JPanel();
    JPanel bordersSouth = new JPanel();
    JPanel gameGrid = new JPanel();
    //implemented class
    SudokuLayout sl = new SudokuLayout();
    SudokuButtons sb = new SudokuButtons();
    GridFiller gf = new GridFiller();
    SudokuSolver ss = new SudokuSolver();
    public void gameBoard() {
        //create game frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.GREEN);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        //create banner
        sudokuSign.setBackground(Color.GREEN);
        sudokuSign.setForeground(Color.BLACK);
        bordersNorth.setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        sudokuSign.setFont(new Font("Forte", Font.BOLD, 80));
        sudokuSign.setHorizontalAlignment(JLabel.CENTER);
        sudokuSign.setText("Sudoku solver");
        sudokuSignBanner.setLayout(new BorderLayout());
        sudokuSignBanner.setBackground(Color.GREEN);
        sudokuSignBanner.setBounds(0, 0, WIDTH, 100);
        sudokuSignBanner.add(sudokuSign);
        frame.add(sudokuSignBanner, BorderLayout.NORTH);
        //other game borders
        bordersNorth.setBackground(Color.GREEN);
        bordersNorth.setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        bordersWest.setBackground(Color.GREEN);
        bordersWest.setBorder(BorderFactory.createEmptyBorder(0,100,0,0));
        bordersEast.setBackground(Color.GREEN);
        bordersEast.setBorder(BorderFactory.createEmptyBorder(0,0,0,100));
        bordersSouth.setBackground(Color.GREEN);
        bordersSouth.setBorder(BorderFactory.createEmptyBorder(0,0,100,0));
        frame.add(bordersNorth, BorderLayout.NORTH);
        frame.add(bordersWest, BorderLayout.WEST);
        frame.add(bordersEast, BorderLayout.EAST);
        frame.add(bordersSouth, BorderLayout.SOUTH);
        //class
        sl.createSudokuLayout(this);
        sb.addButtonsToGrid(this);
        gf.fillGridWithRandomNumbers();
        ss.solveBoard(SudokuButtons.gameLayout9x9);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
