/*
 * ZeroBinaryNumbersException
 * author Tom Lever
 * version 0.0
 * since 01/26/22
 */

package com.tsl.submarinediagnosticreportinterpreter.extractorofbinarynumbers;

public class ZeroBinaryNumbersException extends Exception {
    
    public ZeroBinaryNumbersException(String errorMessage) {
        super(errorMessage);
    }
}