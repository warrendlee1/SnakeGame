import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class GAMEOBJECT extends Rectangle{
	int dx, dy;
	int speed;
	Color col;

	int column;
	int row;
	Point p;
	
	public GAMEOBJECT(int column, int row) {
		
		super(50*column,50*row,50,50);
		speed = 1;
		
		col = Color.BLUE;
		
		this.column = column;
		this.row = row;
		
		p = new Point();
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public void setGridLocation(Point p) {
		this.setGridLocation((int)p.getX(), (int)p.getY());
	}
	
	public void setGridLocation(int column, int row) {
		this.column = column;
		this.row = row;
		this.setLocation(50*column, 50*row);
	}
	
	public Point getGridLocation() {
		p = new Point(column, row);
		return p;
	}
	
	public void moveAndDraw(Graphics2D win) {
		win.setColor(col);
		win.draw(this);
		
	}
	
}