/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class UserPort */

#ifndef _Included_UserPort
#define _Included_UserPort
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     UserPort
 * Method:    outport
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_UserPort_outport
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     UserPort
 * Method:    outportb
 * Signature: (IB)V
 */
JNIEXPORT void JNICALL Java_UserPort_outportb
  (JNIEnv *, jobject, jint, jbyte);

/*
 * Class:     UserPort
 * Method:    inportb
 * Signature: (I)B
 */
JNIEXPORT jbyte JNICALL Java_UserPort_inportb
  (JNIEnv *, jobject, jint);

/*
 * Class:     UserPort
 * Method:    inport
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_UserPort_inport
  (JNIEnv *, jobject, jint);

#ifdef __cplusplus
}
#endif
#endif
