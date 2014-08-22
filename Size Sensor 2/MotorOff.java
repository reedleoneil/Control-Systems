class MotorOff {
  static {
    UserPort up;
    up = new UserPort();
    byte off = 127;
    off = (byte)(up.inportb(0x378)&off);
    up.outportb(0x378,off);
  }
}

