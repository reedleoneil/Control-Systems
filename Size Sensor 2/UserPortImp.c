#include <jni.h>
#include "UserPort.h"
#include <windows.h>

void outport(unsigned int portid, unsigned int value)
{
  __asm mov edx,portid;
  __asm mov eax,value;
  __asm out dx,ax;
}
void outportb(unsigned int portid, unsigned char value)
{
  __asm mov edx,portid
  __asm mov al,value
  __asm out dx,al
}

unsigned char inportb(unsigned int portid)
{
  unsigned char value;
  
  __asm mov edx,portid
  __asm in al,dx
  __asm mov value,al
  return value;
}

unsigned int inport(unsigned int portid)
{
  int value=0;
  __asm mov edx,portid
  __asm in ax,dx
  __asm mov value,eax
  return value;
}

JNIEXPORT void JNICALL Java_UserPort_outport(JNIEnv *env, jobject obj, jint portid, jint value)
{
  outport(portid, value);
}

JNIEXPORT void JNICALL Java_UserPort_outportb(JNIEnv *env, jobject obj, jint portid, jbyte value)
{
  outportb(portid, value);
}

JNIEXPORT jbyte JNICALL Java_UserPort_inportb(JNIEnv *env, jobject obj, jint portid)
{
   return inportb(portid);
}

JNIEXPORT jint JNICALL Java_UserPort_inport(JNIEnv *env, jobject obj, jint portid)
{
   return inport(portid);
}

