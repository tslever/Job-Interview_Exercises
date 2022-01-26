/*
 * ExtractorOfBinaryNumbers
 * author Tom Lever
 * version 0.0
 * since 01/26/22
 */

package com.tsl.submarinediagnosticreportinterpreter.extractorofbinarynumbers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ExtractorOfBinaryNumbers {
    int bitsInABinaryNumber = -1;
	
	private void checksCharactersOf(String binaryNumber) throws InvalidCharacterException {
		for (int i = 0; i < binaryNumber.length(); i++) {
			char theCharacter = binaryNumber.charAt(i);
			if ((theCharacter != '0') && (theCharacter != '1')) {
				throw new InvalidCharacterException("A proposed binary number contains an invalid character.");
			}
		}
	}
	
	private void checksNumberOfBitsOf(String binaryNumber) throws InconsistentNumberOfBitsException {
		if (binaryNumber.length() != this.bitsInABinaryNumber) {
			throw new InconsistentNumberOfBitsException(
				"A binary number differs in its number of bits from the first read binary number.");
		}
	}
	
	public ArrayList<String> extractsBinaryNumbersFromDiagnosticReportAt(String pathToDiagnosticReport) throws
		ZeroBinaryNumbersException, InconsistentNumberOfBitsException, InvalidCharacterException, FileNotFoundException,
		IOException {
		ArrayList<String> binaryNumbers = new ArrayList<String>();
        FileReader fileReader = new FileReader(pathToDiagnosticReport);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String binaryNumber = "";
        if (bufferedReader.ready()) {
        	binaryNumber = bufferedReader.readLine();
        	this.checksCharactersOf(binaryNumber);
        	binaryNumbers.add(binaryNumber);
        	this.bitsInABinaryNumber = binaryNumber.length();
        }
        while (bufferedReader.ready()) {
        	binaryNumber = bufferedReader.readLine();
        	this.checksCharactersOf(binaryNumber);
        	this.checksNumberOfBitsOf(binaryNumber);
        	binaryNumbers.add(binaryNumber);
        }
        bufferedReader.close();
        if (binaryNumbers.isEmpty()) {
        	throw new ZeroBinaryNumbersException(
        		"An extractor of a list of binary numbers extracted zero binary numbers.");
        }
        return binaryNumbers;
	}
}