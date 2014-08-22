class MotorStatus {
  public static void main(String[] args) {
    byte status;
    
    UserPort up;
    up = new UserPort();

    while(true) {
      status = (byte)(up.inportb(0x378)&-128);
      if(status==-128) {
        System.out.print("\rmotor status: on ");
      } else if(status==0) {
        System.out.print("\rmotor status: off");
      }
    }
  }
}