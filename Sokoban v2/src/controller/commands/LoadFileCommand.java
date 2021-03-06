package controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import model.Model;
import model.data.files.LevelLoader;
import model.data.files.LevelLoaderCreator;
import model.data.files.ObjectLevelLoaderCreator;
import model.data.files.TextLevelLoaderCreator;
import model.data.files.XMLLevelLoaderCreator;

/**
 * This class loads a file according to it's file extension.
 * If you wish to inherit this class, you should set the HashMap accordingly.
 * @author Or Priesender
 *
 */

public class LoadFileCommand extends CommonModelCommand {

	private HashMap<String,LevelLoaderCreator> map;

	protected LevelLoader loader;
	protected FileInputStream in;




	
	public LoadFileCommand(Model model) throws FileNotFoundException 
	{

		map = new HashMap<String,LevelLoaderCreator>();

		this.model = model;
		//configures the needed values to the map
		map.put("obj", new ObjectLevelLoaderCreator());
		map.put("xml", new XMLLevelLoaderCreator());
		map.put("txt",new TextLevelLoaderCreator());

		//loader creator  gets his right value according to the file ending



	}
	@Override
	public void execute() {


		try {
			String filename = params.removeFirst();	
			in = new FileInputStream(filename);
			//gets the last 3 letters of the filename (it's file extension)
			LevelLoaderCreator c = map.get(filename.substring(filename.length()-3));
			if (c!=null){
				loader = c.create();
				model.loadLevel(in, loader);
			}
		} catch (ClassNotFoundException | IOException e) {

			e.printStackTrace();
		}


	}
	public HashMap<String, LevelLoaderCreator> getMap() {
		return map;
	}
	public void setMap(HashMap<String, LevelLoaderCreator> map) {
		this.map = map;
	}
	public LevelLoader getLoader() {
		return loader;
	}
	public void setLoader(LevelLoader loader) {
		this.loader = loader;
	}
	public FileInputStream getIn() {
		return in;
	}
	public void setIn(FileInputStream in) {
		this.in = in;
	}


}
