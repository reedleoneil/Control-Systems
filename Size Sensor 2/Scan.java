import java.text.*;

class Scan {
  public static void main(String[] args) {
    DecimalFormat dfsize = new DecimalFormat("#.##");
    UserPort up = new UserPort();

    System.out.println("SizeScanner 1.0");
    System.out.println("Scan ready.");
    
    //while switch off do nothing
    while(up.inportb(0x379) != 7){
      
    }

    System.out.println("Scanning.");
    System.out.println("0-----1-----2-----3-----4-----5-----6-----7-----8-----9-----10   Inches");
    new MotorOn();

    //while switch is on move motor
    double progress = 0.00;
    final int width = 60;
    double size = 0;
    while(up.inportb(0x379) == 7) {
      size++;
      try {
        System.out.print("\r[");
    	int i = 0;
    	for (; i <= (int)(progress*width); i++) {
      	  System.out.print(".");
    	}
    	for (; i < width; i++) {
      	  System.out.print(" ");
    	}
    	System.out.print("]   " + dfsize.format(size*.1) + "     ");
        progress = progress + 0.01;
        Thread.sleep(100);
      } catch (InterruptedException e) {}
    }

    new MotorOff();
    System.out.println("\nSize:  " + dfsize.format(size*.1) + " inches");



    //move back motor
    //delay and loop
  }
}

