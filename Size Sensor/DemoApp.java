class DemoApp {
  public static void main(String[] args) {
    UserPort up;
    up = new UserPort();
System.out.println(up);
    byte value;
    value = up.inportb(0x379);
System.out.println(value);
    value = (byte)((int)value & 0xfb);
System.out.println(value);
    up.outportb(0x378,value);
    try {
      Thread.sleep(100);
    } catch(Exception e) {
      // Do nothing
    }
    value = (byte)((int)value | 0x04);
    up.outportb(0x37a,value);
  }
}

