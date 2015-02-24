package nona.gameengine2d.core;

public class CoreEngine implements Runnable {

	public static final boolean IGNORE_FRAMECAP = true;
	
	private boolean running;
	
	private double nsPerUpdate;
	
	public CoreEngine(int width, int height, String title, int fps) {
		this.nsPerUpdate = 1000000000.0 / fps;
		
		this.running = false;
	}
	
	public void start() {
		running = true;
		run();
	}
	
	public void stop() {
		running = false;
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long now;
		double delta = 0;
		
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		
		boolean shouldRender = false;
		
		while (running) {
			now = System.nanoTime();
			delta += now - lastTime;
			lastTime = now;
			
			while (delta >= nsPerUpdate) {
				delta -= nsPerUpdate;
				update((float) delta);
				updates++;
				shouldRender = true;
			}
			
			if(IGNORE_FRAMECAP || (!IGNORE_FRAMECAP && shouldRender)) {
				render();
				frames++;
				shouldRender = false;
			}
			
			if (System.currentTimeMillis() - timer >= 1000) {
				timer += 1000;
				System.out.println(updates + " updates, " + frames + " frames");
				updates = 0;
				frames = 0;
			}
		}
	}
	
	private void update(float delta) {
		
	}
	
	private void render() {
		
	}
	
}
