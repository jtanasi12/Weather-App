package com.cs505.group.state;

/**
 * Author: Sean Oushana
 * Class Description: Sun State is the class that will be called on by the Context class
 * whenever the state of the page is changed. When Context's request() method is called
 * with "sun" as the parameter, this class's handle method will be executed 
 * @throws IOException
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/** 
 * Handle takes no parameter and is an implementation of the IState interface's handle method.
 * It goes into the template.html file and sets the image source attribute to be the path to 
 * the sun image.
 * @see StatePattern#handle(StatePattern state)
 */
public class CloudState extends StateOriginator{

	/**
	 * Constructor - sets the stateType
	 */
	public CloudState(String dateAndTime) {
		stateType = dateAndTime + ": Clouds";
		
	}
	
	/**
	 * @return - returns the stateType.
	 */
    public String stateToString(){
        return stateType;
    }

    /**
     * Calls the method that displays the stateType
     */
    public String toString() {
    	return stateToString();
    }

    
    /**
     *  prints to the website an image of the weather state
     */
    public void goToState(){
       // File htmlTemplateFile = new File("template.html");

    	File htmlTemplateFile = new File("template.html");
        String imageSource = "clouds.png";
        String oldContent = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(htmlTemplateFile));
            String line = reader.readLine();
            while (line != null){
                    oldContent = oldContent + line + System.lineSeparator();
                    line = reader.readLine();
            }
            String newContent = oldContent.replaceAll("$image", imageSource);
    
            FileWriter writer = new FileWriter(htmlTemplateFile);
            
            writer.write(newContent);
            writer.close();
            reader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
