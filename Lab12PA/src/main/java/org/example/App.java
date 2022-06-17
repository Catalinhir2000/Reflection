package org.example;

import com.sun.org.apache.xpath.internal.operations.Mod;
import jdk.incubator.vector.VectorOperators;
import org.junit.Test;

import java.lang.reflect.*;
import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        File file = new File("C:/Users/Catalin/IdeaProjects/PAlab7/target/classes");
        URL[] urls = new URL[]{file.toURI().toURL()};
        URLClassLoader classLoader = new URLClassLoader(urls);

        //load the class
        Class<?> clazz = classLoader.loadClass("org.example.Tile");
        System.out.println("The class package is: " + clazz.getPackage());

        //print class details
        System.out.println("The class name is: " + clazz.getName());
        System.out.println("The class simple name is: " + clazz.getSimpleName());
        System.out.println("The class is an interface: " + clazz.isInterface());

        //print class methods
        System.out.println("The class methods are: ");
        for (java.lang.reflect.Method method : clazz.getDeclaredMethods()) {
            System.out.println("\t" + method.getName());

        }

        //print class constructors
        System.out.println("The class constructors are: ");
        for (java.lang.reflect.Constructor constructor : clazz.getDeclaredConstructors()) {
            System.out.println("\t" + constructor.getName());
        }

        //Annotation @Test for invoking the static methods with no arguments
        for (Method method : clazz.getMethods()) {
            if(Modifier.isStatic(method.getModifiers()) && method.getParameterCount() == 0 && method.isAnnotationPresent(Test.class)) {
                Method mToInvoke = clazz.getMethod(method.getName(), null);
                Object result = mToInvoke.invoke( null);
            }
        }
    }
}
