// AidlTest.aidl
package com.javaexample.zzh.aidlserver;

// Declare any non-default types here with import statements
import com.javaexample.zzh.aidlserver.Person;
interface AidlTest {
      List<Person> add(in Person person);
}
