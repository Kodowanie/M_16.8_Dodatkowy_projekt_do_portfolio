package sudoku.v2;

import sudoku.v2.abstraction.IGridFiller;
import sudoku.v2.abstraction.ISudokuSolver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public enum Board implements ActionListener {
    BOARD;
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
    //create buttons for game difficulty + sudokuSolver
    JButton easy = new JButton();
    JButton medium = new JButton();
    JButton hard = new JButton();
    JButton sudokuSolver = new JButton();
    static int gameDifficultyLevel;
    //number of iteration SudokuSolver.solveBoard()
    JButton empty = new JButton();
    //implemented class
    SudokuLayout sl = new SudokuLayout();
    SudokuButtons sb = new SudokuButtons();
    IGridFiller gf = new GridFiller();
    ISudokuSolver ss = new SudokuSolver();
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
        //add buttons
        easy.addActionListener(this);
        easy.setBounds(50, WIDTH-130 , 150, 60);
        easy.setText("Easy difficulty");
        frame.add(easy);
        medium.addActionListener(this);
        medium.setBounds(250, WIDTH-130 , 150, 60);
        medium.setText("Medium difficulty");
        frame.add(medium);
        hard.addActionListener(this);
        hard.setBounds(450, WIDTH-130 , 150, 60);
        hard.setText("Hard difficulty");
        frame.add(hard);
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

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        sb.addButtonsToGrid(this);
        if(e.getSource() == easy){
            gameDifficultyLevel  = 42;
            easy.setEnabled(false);
            medium.setEnabled(false);
            hard.setEnabled(false);
        } else if (e.getSource() == medium) {
            gameDifficultyLevel = 48;
        } else if (e.getSource() == hard){
            gameDifficultyLevel = 54;
        }
        gf.fillGridWithRandomNumbers();
        gf.removeNumbersFromValidGameBoard(SudokuButtons.gameLayout9x9);
        ss.solveBoard(SudokuButtons.gameLayout9x9);
    }
}
