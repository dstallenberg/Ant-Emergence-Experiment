package com.dimitri.antemergence.program.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    
    private static boolean[] keyTyped = new boolean[256];
    private static boolean[] keyPressed = new boolean[256];
    private static boolean[] keyReleased = new boolean[256];
    
    public void update(){
        for (int i = 0; i < keyTyped.length; i++) {
            keyTyped[i] = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        keyTyped[e.getKeyCode()] = true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyPressed[e.getKeyCode()] = true;
        keyReleased[e.getKeyCode()] = false;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyPressed[e.getKeyCode()] = false;
        keyReleased[e.getKeyCode()] = true;
    }

    public static boolean[] getKeyTyped() {
        return keyTyped;
    }

    public static boolean[] getKeyPressed() {
        return keyPressed;
    }

    public static boolean[] getKeyReleased() {
        return keyReleased;
    }

    public static boolean isKeyTyped(int key) {
        return keyTyped[key];
    }

    public static boolean isKeyPressed(int key) {
        return keyPressed[key];
    }

    public static boolean isKeyReleased(int key) {
        return keyReleased[key];
    }
}
