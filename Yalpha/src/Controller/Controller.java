package Controller;

import Model.Model;
import java.util.Scanner;

import Model.*;
import View.View;

/**
 * Gathers all user input and tells the model and view what to do and when to
 * update.
 *
 * @author Team Yalpha, specifically Bob Grube AND Matthew Maze
 * @version 1.0
 */
public class Controller {
/*
    public Controller(){
        run();
    }*/
	/**
	 * Gathers input until user exits. Based on input tells model and view how
	 * to update.
	 *
	 * @param args
	 */
	public static void main(String[] args) {

                Model model = new Model();
		View view = new View();
		boolean exit = false;
		Scanner input = new Scanner(System.in);
		char command;
		String line;

                view.printGreeting();

		while (!exit) {
			line = input.nextLine().toLowerCase();
                        if(line.length() > 0)
                        {
                            command = line.charAt(0);
                            switch (command) {
                            case 'a':
                                    if (line.length() > 2 && line.charAt(1) == ' ') {
                                            //System.out.println("Added: " + line.substring(2));
                                            model.add(line.substring(2));
                                    } else if (line.length() > 4 && line.startsWith("add ")) {
                                            //System.out.println("Added: " + line.substring(4));
                                            model.add(line.substring(4));
                                    }
                                    break;
                            case 'e':
                                    //System.out.println("Goodbye");
                                    exit = true;
                                    break;
                            case 'g':
                                    model.generate();
                                    view.printPuzzle(model.getMatrix());
                                    //view.printPuzzle(puz);
                                    break;
                            case 'h':
                                    view.printHelp();
                                    break;
                            case 'i':
                                    if (line.length() > 2 && line.charAt(1) == ' ') {
                                            //System.out.println("Import: " + line.substring(2));
                                            model.loadWordList(line.substring(2));
                                    } else if (line.length() > 7 && line.startsWith("import ")) {
                                            //System.out.println("Import: " + line.substring(7));
                                            model.loadWordList(line.substring(7));
                                    }
                                    break;
                            case 'o':
                                    System.out.println("Open");
                                    if (line.length() > 2 && line.charAt(1) == ' ') {
                                            //System.out.println("Open file: " + line.substring(2));
                                            model.loadPuzzle(line.substring(2));
                                    } else if (line.length() > 5 && line.startsWith("open ")) {
                                            //System.out.println("Open file: " + line.substring(5));
                                            model.loadPuzzle(line.substring(5));
                                    }
                                    
                            case 'p':
                                    view.printPuzzle(model.getMatrix());
                                    //view.printPuzzle(puz);
                                    break;
                            case 'r':
                            case 'd':
                                    if (line.length() > 2 && line.charAt(1) == ' ') {
                                            //System.out.println("Remove word: " + line.substring(2));
                                            model.remove(line.substring(2));
                                    } else if (line.length() > 7
                                                    && (line.startsWith("remove ") || line
                                                                    .startsWith("delete "))) {
                                            //System.out.println("Remove word: " + line.substring(7));
                                            model.remove(line.substring(7));
                                    }
                                    break;
                            case 's':
                                    if (line.length() > 2 && line.charAt(1) == ' ') {
                                            //System.out.println("Save To: " + line.substring(2));
                                            model.savePuzzle(line.substring(2));
                                    } else if (line.length() > 5 && line.startsWith("save ")) {
                                            //System.out.println("Save To: " + line.substring(5));
                                            model.savePuzzle(line.substring(5));
                                    }
                                    break;
                            case 'w':
                                    if (line.length() > 2 && line.charAt(1) == ' ') {
                                            //System.out.println("Save To: " + line.substring(2));
                                            model.saveWordList(line.substring(2));
                                    } else if (line.length() > 5 && line.startsWith("word ")) {
                                            //System.out.println("Save To: " + line.substring(5));
                                            model.saveWordList(line.substring(5));
                                    }
                                    break;
                            }
                        }
		}
	}
}