package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

/**
 * Graphically sets and displays buttons and text field for puzzles and word
 * list. Also includes a menu to quit.
 * 
 * @author Team Yalpha, specificially Bob Grube and Matt Maze
 * @version 1.0
 */
public class ViewGUI {

    Font defaultFont = new Font("Courier New", Font.PLAIN, 12);
    ImageIcon aboutImage;
    JButton addButton;
    JButton clearButton;
    JButton exportButton;
    JButton generateButton;
    JButton removeButton;
    JButton solutionButton;
    JComboBox changePuzzle;
    JComboBox puzzleSize;
    JFrame frame;
    JLabel aboutLabel;
    JMenu menuFile;
    JMenu menuHelp;
    JMenuBar menuBar;
    JMenuItem aboutMenuItem;
    JMenuItem exitMenuItem;
    JMenuItem helpMenuItem;
    JMenuItem openPuzzle;
    JMenuItem openWordList;
    JMenuItem savePuzzle;
    JMenuItem saveWordList;
    JTextArea wordArea;
    JTextField wordBox;
    PuzzleAreaGUI puzzleArea = new PuzzleAreaGUI();

    /**
     * Creates and formats the graphical user interface.
     */
    public ViewGUI() {

        // Find file path for the about image
        String imagePath = "";

        try {
            char separator = File.separatorChar;
            imagePath = ViewGUI.class.getClassLoader().getResource("View/ViewGUI.class").getPath();
            imagePath = imagePath.replace('/', separator);
            int start = (separator == '\\' ? imagePath.indexOf('\\') + 1 : imagePath.indexOf(separator));
            imagePath = imagePath.substring(start, imagePath.lastIndexOf(separator));
            imagePath = imagePath.substring(0, imagePath.lastIndexOf(separator));
            imagePath = imagePath.substring(0, imagePath.lastIndexOf(separator) + 1) + "about.gif";
        }
        catch (Exception e) {
            imagePath = "about.jpg";
        }

        frame = new JFrame("Team Yalpha Word Search Iteration 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setResizable(false);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        frame.setLocation((screenSize.width - 800) / 2,
                (screenSize.height - 600) / 2);

        aboutImage = new ImageIcon(imagePath);

        menuBar = new JMenuBar();

        menuFile = new JMenu("File");
        exitMenuItem = new JMenuItem("Exit");
        openPuzzle = new JMenuItem("Open Puzzle");
        openWordList = new JMenuItem("Open Word List");
        savePuzzle = new JMenuItem("Save Puzzle");
        saveWordList = new JMenuItem("Save Word List");
        menuFile.add(openPuzzle);
        menuFile.add(openWordList);
        menuFile.add(savePuzzle);
        menuFile.add(saveWordList);
        menuFile.add(exitMenuItem);

        menuHelp = new JMenu("Help");
        helpMenuItem = new JMenuItem("Help");
        menuHelp.add(helpMenuItem);
        aboutMenuItem = new JMenuItem("About");
        menuHelp.add(aboutMenuItem);

        addButton = new JButton("Add");
        addButton.setLocation(10, 500);
        addButton.setSize(90, 30);

        clearButton = new JButton("Clear");
        clearButton.setLocation(190, 500);
        clearButton.setSize(90, 30);

        exportButton = new JButton("Export");
        exportButton.setLocation(570, 500);
        exportButton.setSize(110, 30);

        generateButton = new JButton("Generate");
        generateButton.setLocation(350, 500);
        generateButton.setSize(110, 30);

        removeButton = new JButton("Remove");
        removeButton.setLocation(100, 500);
        removeButton.setSize(90, 30);

        solutionButton = new JButton("Solution");
        solutionButton.setLocation(460, 500);
        solutionButton.setSize(110, 30);

        changePuzzle = new JComboBox();
        changePuzzle.setLocation(490, 10);
        changePuzzle.setSize(120, 20);
        changePuzzle.addItem("Word Search");
        changePuzzle.addItem("Crossword");

        puzzleSize = new JComboBox();
        puzzleSize.setLocation(410, 10);
        puzzleSize.setSize(80, 20);
        puzzleSize.addItem("10x10");
        puzzleSize.addItem("15x15");
        puzzleSize.addItem("20x20");

        Border lineBorder = BorderFactory.createLineBorder(new Color(100, 100, 255));
        wordBox = new JTextField("Enter Word");
        wordBox.setLocation(10, 470);
        wordBox.setSize(200, 25);
        wordBox.setBorder(lineBorder);

        wordArea = new JTextArea();
        wordArea.setLocation(10, 10);
        wordArea.setSize(200, 450);
        wordArea.setEditable(false);
        wordArea.setBorder(lineBorder);

        menuBar.add(menuFile);
        menuBar.add(menuHelp);

        puzzleArea.setLocation(250, 40);
        puzzleArea.setSize(500, 450);
        puzzleArea.setBorder(lineBorder);
        puzzleArea.setFont(defaultFont);

        frame.getContentPane().add(puzzleArea);
        frame.getContentPane().add(wordArea);
        frame.getContentPane().add(addButton);
        frame.getContentPane().add(clearButton);
        frame.getContentPane().add(exportButton);
        frame.getContentPane().add(generateButton);
        frame.getContentPane().add(removeButton);
        frame.getContentPane().add(solutionButton);
        frame.getContentPane().add(changePuzzle);
        frame.getContentPane().add(puzzleSize);
        frame.getContentPane().add(wordBox);
        frame.setJMenuBar(menuBar);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Adds an action listener to the view to send actions to the controller.
     * @param click- The ActionListener class from the Controller.
     */
    public void addAboutMenuListener(ActionListener click) {
        aboutMenuItem.addActionListener(click);
    }

    /**
     * Adds an action listener to the view to send actions to the controller.
     * @param click- The ActionListener class from the Controller.
     */
    public void addAddButtonListener(ActionListener click) {
        addButton.addActionListener(click);
    }

    /**
     * Adds an action listener to the view to send actions to the controller.
     * @param click- The ActionListener class from the Controller.
     */
    public void addChangePuzzleListener(ActionListener click) {
        changePuzzle.addActionListener(click);
    }

    /**
     * Adds an action listener to the view to send actions to the controller.
     * @param click- The ActionListener class from the Controller.
     */
    public void addClearButtonListener(ActionListener click) {
        clearButton.addActionListener(click);
    }

    /**
     * Adds an action listener to the view to send actions to the controller.
     * @param click- The ActionListener class from the Controller.
     */
    public void addExportButtonListener(ActionListener click) {
        exportButton.addActionListener(click);
    }

    /**
     * Adds an action listener to the view to send actions to the controller.
     * @param click- The ActionListener class from the Controller.
     */
    public void addExitMenuListener(ActionListener click) {
        exitMenuItem.addActionListener(click);
    }

    /**
     * Adds an action listener to the view to send actions to the controller.
     * @param click- The ActionListener class from the Controller.
     */
    public void addGenerateButtonListener(ActionListener click) {
        generateButton.addActionListener(click);
    }

    /**
     * Adds an action listener to the view to send actions to the controller.
     * @param click- The ActionListener class from the Controller.
     */
    public void addHelpMenuItemListener(ActionListener click) {
        helpMenuItem.addActionListener(click);
    }

    /**
     * Adds an action listener to the view to send actions to the controller.
     * @param click- The ActionListener class from the Controller.
     */
    public void addOpenPuzzleListener(ActionListener click) {
        openPuzzle.addActionListener(click);
    }

    /**
     * Adds an action listener to the view to send actions to the controller.
     * @param click- The ActionListener class from the Controller.
     */
    public void addOpenWordListListener(ActionListener click) {
        openWordList.addActionListener(click);
    }

    /**
     * Adds an action listener to the view to send actions to the controller.
     * @param click- The ActionListener class from the Controller.
     */
    public void addRemoveButtonListener(ActionListener click) {
        removeButton.addActionListener(click);
    }

    /**
     * Adds an action listener to the view to send actions to the controller.
     * @param click- The ActionListener class from the Controller.
     */
    public void addSavePuzzleListener(ActionListener click) {
        savePuzzle.addActionListener(click);
    }

    /**
     * Adds an action listener to the view to send actions to the controller.
     * @param click- The ActionListener class from the Controller.
     */
    public void addSaveWordListListener(ActionListener click) {
        saveWordList.addActionListener(click);
    }

    public void addSolutionButtonListener(ActionListener click) {
        solutionButton.addActionListener(click);
    }

    /**
     * Adds an action listener to the view to send actions to the controller.
     * @param click- The ActionListener class from the Controller.
     */
    public void addWordBoxListener(ActionListener click) {
        wordBox.addActionListener(click);
    }

    /**
     * Adds an action listener to the view to send actions to the controller.
     * @param click- The ActionListener class from the Controller.
     */
    public void addWordBoxMouseListener(MouseListener click) {
        wordBox.addMouseListener(click);
    }

    /**
     * Clears the puzzle area
     */
    public void clearPuzzle() {
        puzzleArea.clear();
        puzzleArea.repaint();
    }

    /**
     * Creates a message dialog box
     * @param Description Text in the box
     * @param Title Title of the box
     * @param Symbol Symbol to display
     */
    public void createJOptionPane(String Description, String Title, int Symbol) {
        JOptionPane.showMessageDialog(null, Description, Title, Symbol);
    }

//    public char[][] createSolution(WordMap map, int numRows, int numCols) {
//        Word[] arrayMap = new Word[map.size()];
//        map.toArray(arrayMap);
//
//        char[][] puzzle = new char[numRows][numCols];
//
//        for (int word = 0; word <= arrayMap.length; ++word) {
//            for (int letter = 0; letter < arrayMap[word].size(); ++letter) {
//                puzzle[arrayMap[word].getCharPosX(letter)][arrayMap[word].getCharPosY(letter)] = arrayMap[word].getCharAt(letter);
//            }
//        }
//        return puzzle;
//    }

    /**
     * Display the about box
     */
    public void displayAbout() {
        JOptionPane.showMessageDialog(frame, "", "", 0, aboutImage);
    }

    /**
     * Get user selected size for puzzle to generate
     * @return Selected size
     */
    public int getPuzzleSize() {
        String selected = (String) puzzleSize.getSelectedItem();
        if (selected.equals("10x10")) {
            return 10;
        } else if (selected.equals("15x15")) {
            return 15;
        } else {
            return 20;
        }
    }

    /**
     * Get user selected puzzle type to generate
     * @return Selected puzzle type
     */
    public String getPuzzleType() {
        return (String) changePuzzle.getSelectedItem();
    }

    /**
     * Get text from word entry box
     * @return Line of words
     */
    public String getWord() {
        String word = wordBox.getText();
        wordBox.setText("");
        return word;
    }

    /**
     * Get selected text from word list display
     * @return Selected text from text area
     */
    public String getSelected() {
        return wordArea.getSelectedText();
    }

    /**
     * Display file open browser window
     * @return selected file path
     */
    public String fileOpenDialog() {
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(frame) == fc.APPROVE_OPTION) {
            return fc.getSelectedFile().getAbsolutePath();
        }
        return "";
    }

    /**
     * Show file save browser window
     * @return Selected file path
     */
    public String fileSaveDialog() {
        JFileChooser fc = new JFileChooser();
        if (fc.showSaveDialog(frame) == fc.APPROVE_OPTION) {
            return fc.getSelectedFile().getAbsolutePath();
        }
        return "";
    }

    /**
     * Display a message dialog box
     * @param message  message to display
     * @param title    title of dialog box
     */
    public void messageBox(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, 1);
    }

    /**
     * Tells puzzleArea to paint the Generating text.
     */
    public void paintGenerating() {
        puzzleArea.setGenerating(true);
        puzzleArea.paintImmediately(200, 200, 120, 25);
    }

    /**
     * Print the crossword puzzle to screen
     * @param puzzle    Takes a matrix of characters
     */
    public void printCrossword(char[][] puzzle) {
        puzzleArea.setPuzzle(puzzle);
        puzzleArea.setGenerating(false);
        puzzleArea.setPuzzleType(false);
        puzzleArea.repaint();
    }

    /**
     * Prints greeting.
     */
    public void printGreeting() {
        JOptionPane.showMessageDialog(null, "Welcome to Team Yalpha's puzzle generator! "
                + "\nEvery word needs to be over 1 and under 20 letters in length."
                + "\nA maximum of 25 words can be added.", "Greetings!", 1);
    }

    /**
     * Print the word search puzzle to the screen
     * @param puzzle  Takes a matrix of characters
     */
    public void printWordsearch(char[][] puzzle) {
        puzzleArea.setPuzzle(puzzle);
        puzzleArea.setGenerating(false);
        puzzleArea.setPuzzleType(true);
        puzzleArea.repaint(100);
    }

    /**
     * Show dialog box with unused words in puzzle
     * @param words The unused words
     */
    public void printWordsNotUsed(ArrayList<String> words) {
        if (words.size() > 0) {
            String list = "";
            for (int i = 0; i < words.size() - 1; ++i) {
                list += words.get(i) + ", ";
                if (i % 10 == 9) {
                    list += "\n";
                }
            }
            if (!list.equals("")) {
                list += "and ";
            }
            list += words.get(words.size() - 1) + ".";
            JOptionPane.showMessageDialog(null, list, "Words Not in Puzzle", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Select all text in word list area
     */
    public void selectText() {
        wordBox.selectAll();
    }

    /**
     * Set puzzle size selection
     * @param size The size of the puzzle.
     */
    public void setPuzzleSize(int size) {
        if (size == 10) {
            puzzleSize.setSelectedIndex(0);
        } else if (size == 15) {
            puzzleSize.setSelectedIndex(1);
        } else {
            puzzleSize.setSelectedIndex(2);
        }
    }

    /**
     * Set selected puzzle type
     * @param isWordsearch Whether the puzzle type is a wordsearch or not.
     */
    public void setPuzzleType(boolean isWordsearch) {
        if (isWordsearch) {
            changePuzzle.setSelectedIndex(0);
        } else {
            changePuzzle.setSelectedIndex(1);
        }
    }

    /**
     * Set solution display mode on or off
     * @param isSolution Whether the solution should show or not.
     */
    public void setSolution(boolean isSolution) {
        puzzleArea.setSolution(isSolution);
        puzzleArea.repaint();
    }

    /**
     * Give the solution matrix to the view
     * @param puzzleSolution Solution configuration.
     */
    public void setSolutionMatrix(char[][] puzzleSolution) {
        puzzleArea.setSolutionMatrix(puzzleSolution);
    }

    /**
     * Give the updated word list to the view
     * @param words Takes the list of words
     */
    public void updateWordArea(String[] words) {
        String puzzleList = "";
        if (words != null) {
            for (int i = 0; i < words.length; ++i) {
                puzzleList += words[i] + "\n";
            }
        }
        wordArea.setText(puzzleList);
    }
}
