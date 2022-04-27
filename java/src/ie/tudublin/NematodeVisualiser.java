package ie.tudublin;

import java.util.ArrayList;

import javax.xml.validation.Validator;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	public float border;
	public int limbSize = 40;
	public int rowheight = 60;
	public int index = 0;

	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	public void keyPressed()
	{		
			if (keyCode == LEFT)
			{
				index++;
			}		
	}

	public void loadNematode(){

		Table table = loadTable("nematodes.csv","header");

		for(TableRow row:table.rows()){
			Nematode nematode = new Nematode(row);
			nematodes.add(nematode);
		}

	}

	void printNematode()
    {
        for(Nematode n:nematodes)
        {
            System.out.println(n);
        }
    }

	public void settings()
	{
		size(600, 600);
	}

	public void setup() 
	{
		colorMode(HSB);

		loadNematode();
		printNematode();

		border = width * 0.1f;

		background(0);
		smooth();				
	}

	public void drawNematode()
	{

		
		if(index < nematodes.size())
		{
			nematodes.get(index).render(this, index);	
		}
		else{
			index = 0;
		}

	
	}

	public void draw()
	{	
		background(0);
		drawNematode();
	}
}
