package ie.tudublin;

import processing.data.TableRow;
import processing.core.PApplet;


public class Nematode
{
    private String name;
    private int length;
    private int limbs;
    private String gender;
    private int eyes;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public int getLimbs() {
        return limbs;
    }
    public void setLimbs(int limbs) {
        this.limbs = limbs;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getEyes() {
        return eyes;
    }
    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    public Nematode(String name, int length, int limbs, String gender, int eyes)
    {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;

    }

    public Nematode(TableRow tr){
        this
        (
            tr.getString("name"),
            tr.getInt("length"),
            tr.getInt("limbs"),
            tr.getString("gender"),
            tr.getInt("eyes")
        );
    }


    public void render(NematodeVisualiser nv, int value)
    {

			
        nv.stroke(nv.map(value, 0, 10, 0, 255), 255, 255);
        
        int width = nv.width;
        int height = nv.height;
        float border = nv.border;
        int limbSize = nv.limbSize;

        // System.out.println(this.limbs);

        for(int i = 1; i <= this.length; i++)
        {
            float limb = (height/2 - border - border) + limbSize * i;
            nv.noFill();
    
            nv.circle(width/2, height - limb, limbSize);
        }



        nv.noFill();



        //Left arrow
        nv.line(width - border * 2, width/2, width - border * 3, width/2);
        nv.line(width - border * 2, width/2, width - border * 2 - 10, height/2 - 10);
		nv.line(width - border * 2, width/2, width - border * 2 - 10, height/2 + 10);

		//right arrow
		nv.line(border * 2, width/2, border * 3, width/2);
		nv.line(border * 2, width/2,border * 2 + 10, height/2 - 10);
		nv.line(border * 2, width/2,border * 2 + 10, height/2 + 10);

    }



    @Override
    public String toString() {
        return "Nematode [eyes=" + eyes + ", gender=" + gender + ", length=" + length + ", limbs=" + limbs + ", name="
                + name + "]";
    }
    

}