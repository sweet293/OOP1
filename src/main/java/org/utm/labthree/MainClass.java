package org.utm.labthree;

import org.utm.labthree.AppLoop;

import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.Scanner;
public class MainClass {

    public static void main(String[] args) {

        AppLoop appLoop = new AppLoop();
        appLoop.run();
    }
}
