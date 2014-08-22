import java.text.*;

class SizeSensor {
	static void updateProgress(double progress, double scannedsize) {
		final int width = 60; // progress bar width in chars

		System.out.print("\r[");
    		int i = 0;
    		for (; i <= (int)(progress*width); i++) {
      			System.out.print(".");
    		}
    		for (; i < width; i++) {
      			System.out.print(" ");
    		}
		DecimalFormat dfsize = new DecimalFormat("#.##");
    		System.out.print("] " + dfsize.format(scannedsize*.1) + " inches");
  	}

	public static void main(String[] args) {
			UserPort up;
    			up = new UserPort();
			int scannedsize = 2;
			byte motoron = -128;
			System.out.println("Scanning...");
			System.out.println("0-----1-----2-----3-----4-----5-----6-----7-----8-----9-----10");
			double progress = 0.0;
			while(up.inportb(0x379) != 7) {
				try {
					up.outportb(0x378,motoron);
      					progress = progress + 0.01;
        				updateProgress(progress, (scannedsize++));
        				Thread.sleep(500);
    				} catch (InterruptedException e) {}
			}
			byte motoroff = 0;
			up.outportb(0x378,motoroff);
			System.out.println();
			System.out.println();
			DecimalFormat dfsize = new DecimalFormat("#.##");
			System.out.println("Size: " + dfsize.format(--scannedsize*.1) + " inches");
	}
}

