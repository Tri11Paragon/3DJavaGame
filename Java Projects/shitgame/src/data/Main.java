package data;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import data.physics.Collider;

public class Main extends JFrame implements Runnable, KeyListener {
	
	private Draw draw;
	
	public int x = 50;
    public int y = 50;
	
	private static final long serialVersionUID = -319514038107295922L;
	public static Thread thread = new Thread();
	public static boolean isRunning = true;
	public JFrame frame = new JFrame();
	
	public Main() {
		thread.start();
		this.draw = new Draw();
		run();
	}
	
	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void run() {
		JFrame frame = new JFrame();
        frame.setTitle("Sheep");
        frame.setResizable(false);
        frame.setSize(800, 600);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
        frame.getContentPane().add(this.draw);
        frame.pack();
        frame.setVisible(true);
		while(true) {
			draw.moveTo(x, y, 0);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()== KeyEvent.VK_ESCAPE) {
			draw.add(new Collider(0, x, y, 50, 50, Color.CYAN));
		}
		if(e.getKeyCode()== KeyEvent.VK_RIGHT)
            moveRight();
        else if(e.getKeyCode()== KeyEvent.VK_LEFT)
            moveLeft();
        else if(e.getKeyCode()== KeyEvent.VK_DOWN)
            moveDown();
        else if(e.getKeyCode()== KeyEvent.VK_UP)
            moveUp();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	public void moveRight() {
        x = x + 5;
        repaint();
    }

    public void moveLeft() {
        x = x - 5;
        repaint();
    }

    public void moveDown() {
        y = y + 5;
        repaint();
    }

    public void moveUp() {
        y = y - 5;
        repaint();
    }

}
