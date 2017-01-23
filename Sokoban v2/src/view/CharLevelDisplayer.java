package view;


import model.data.level.Box;
import model.data.level.Destination;
import model.data.level.Level;
import model.data.level.LevelObject;
import model.data.level.Player;
import model.data.level.Wall;

public class CharLevelDisplayer extends LevelDisplayer {

	public CharLevelDisplayer(LevelObject[][] levelData)
	{
		super(levelData);
	}
	@Override
	public void display() {
		
		System.out.println();
	
		for(int i=0;i<levelData.length;i++)
		{
			for(int j=0;j<levelData[i].length;j++) 
			{
				System.out.print(LevelObjectToChar(levelData[i][j]));
				
			}
			System.out.println();
			
		}
		

	}
	
	private char LevelObjectToChar(LevelObject o)
	{
		if (o instanceof Box)
			return '@';
		else if(o instanceof Wall)
			return '#';
		else if(o instanceof Destination)
			return 'o';
		else if(o instanceof Player)
			return 'A';
		else return ' ';
	}

}
