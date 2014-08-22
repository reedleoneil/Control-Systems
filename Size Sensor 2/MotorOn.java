class MotorOn {
  static {
    UserPort up;
    up = new UserPort();
    byte on = -128;
    on = (byte)(up.inportb(0x378)|on);
    up.outportb(0x378,on);
  }
}

