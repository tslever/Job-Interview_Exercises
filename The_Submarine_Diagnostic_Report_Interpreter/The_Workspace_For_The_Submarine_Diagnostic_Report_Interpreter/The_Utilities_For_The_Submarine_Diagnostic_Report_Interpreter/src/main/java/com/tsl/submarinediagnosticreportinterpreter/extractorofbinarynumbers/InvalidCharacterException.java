/*
 * InvalidCharacterException
 * author Tom Lever
 * version 0.0
 * since 01/26/22
 */

package com.tsl.submarinediagnosticreportinterpreter.extractorofbinarynumbers;

public class InvalidCharacterException extends Exception {

    public InvalidCharacterException(String errorMessage) {
        super(errorMessage);
    }
}