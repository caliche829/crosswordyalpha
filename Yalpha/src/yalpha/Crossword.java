/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package yalpha;

/**
 *
 * @author Patrick
 */
public class Crossword extends Puzzle {
        public void generate(final WordList words)
        {
            WordMap mList = new WordMap(words);
            System.out.println("CROSSWORD - GENERATE");
        }

}