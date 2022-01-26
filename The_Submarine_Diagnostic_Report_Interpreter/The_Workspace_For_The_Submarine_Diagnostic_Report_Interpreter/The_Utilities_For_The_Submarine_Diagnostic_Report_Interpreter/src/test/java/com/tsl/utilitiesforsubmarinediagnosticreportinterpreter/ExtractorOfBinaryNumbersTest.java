/*
 * ExtractorOfBinaryNumbersTest
 * author Tom Lever
 * version 0.0
 * since 01/26/22
 */

package com.tsl.utilitiesforsubmarinediagnosticreportinterpreter;

import com.tsl.submarinediagnosticreportinterpreter.extractorofbinarynumbers.ZeroBinaryNumbersException;
import com.tsl.submarinediagnosticreportinterpreter.extractorofbinarynumbers.ExtractorOfBinaryNumbers;
import com.tsl.submarinediagnosticreportinterpreter.extractorofbinarynumbers.InconsistentNumberOfBitsException;
import com.tsl.submarinediagnosticreportinterpreter.extractorofbinarynumbers.InvalidCharacterException;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class ExtractorOfBinaryNumbersTest {
		
	@Test
	void testExtractingWithInconsistentNumberOfBits() {
		System.out.println("Running testExtractingWithInconsistentNumberOfBits");
		String pathToDiagnosticReport = "resources/The_Diagnostic_Report_With_An_Inconsistent_Number_Of_Bits.txt";
		try {
			(new ExtractorOfBinaryNumbers()).extractsBinaryNumbersFromDiagnosticReportAt(pathToDiagnosticReport);
			System.out.println("Extracting a list of binary numbers succeeded.\n");
		} catch (ZeroBinaryNumbersException zeroBinaryNumbersException) {
			System.out.println("The extractor found zero binary numbers.\n");
		} catch (InconsistentNumberOfBitsException inconsistentNumberOfBitsException) {
			System.out.println("The extractor found an inconsistent number of bits when trying to read a line.\n");
		} catch (InvalidCharacterException invalidCharacterException) {
			System.out.println("The extractor found an invalid character when trying to read a line.\n");
		} catch (IOException ioException) {
			System.out.println("A BufferedReader threw an IOException when trying to read a line.\n");
		}
	}
	
	@Test
	void testExtractingWithInvalidCharacter() {
		System.out.println("Running testExtractingWithAnInvalidCharacter");
		String pathToDiagnosticReport = "resources/The_Diagnostic_Report_With_An_Invalid_Character.txt";
		try {
			(new ExtractorOfBinaryNumbers()).extractsBinaryNumbersFromDiagnosticReportAt(pathToDiagnosticReport);
			System.out.println("Extracting a list of binary numbers succeeded.\n");
		} catch (ZeroBinaryNumbersException zeroBinaryNumbersException) {
			System.out.println("The extractor found zero binary numbers.\n");
		} catch (InconsistentNumberOfBitsException inconsistentNumberOfBitsException) {
			System.out.println("The extractor found an inconsistent number of bits when trying to read a line.\n");
		} catch (InvalidCharacterException invalidCharacterException) {
			System.out.println("The extractor found an invalid character when trying to read a line.\n");
		} catch (IOException ioException) {
			System.out.println("A BufferedReader threw an IOException when trying to read a line.\n");
		}
	}

	@Test
	void testExtractingWithZeroBits() {
		System.out.println("Running testExtractingWithZeroBits");
		String pathToDiagnosticReport = "resources/The_Diagnostic_Report_With_Zero_Bits.txt";
		try {
			(new ExtractorOfBinaryNumbers()).extractsBinaryNumbersFromDiagnosticReportAt(pathToDiagnosticReport);
			System.out.println("Extracting a list of binary numbers succeeded.\n");
		} catch (ZeroBinaryNumbersException zeroBinaryNumbersException) {
			System.out.println("The extractor found zero binary numbers.\n");
		} catch (InconsistentNumberOfBitsException inconsistentNumberOfBitsException) {
			System.out.println("The extractor found an inconsistent number of bits when trying to read a line.\n");
		} catch (InvalidCharacterException invalidCharacterException) {
			System.out.println("The extractor found an invalid character when trying to read a line.\n");
		} catch (IOException ioException) {
			System.out.println("A BufferedReader threw an IOException when trying to read a line.\n");
		}
	}
	
	@Test
	void testWellBehavedExtracting() {
		System.out.println("Running testWellBehavedExtracting");
		String pathToDiagnosticReport = "resources/The_Diagnostic_Report_With_Few_Bits.txt";
		try {
			(new ExtractorOfBinaryNumbers()).extractsBinaryNumbersFromDiagnosticReportAt(pathToDiagnosticReport);
			System.out.println("Extracting a list of binary numbers succeeded.\n");
		} catch (ZeroBinaryNumbersException zeroBinaryNumbersException) {
			System.out.println("The extractor found zero binary numbers.\n");
		} catch (InconsistentNumberOfBitsException inconsistentNumberOfBitsException) {
			System.out.println("The extractor found an inconsistent number of bits when trying to read a line.\n");
		} catch (InvalidCharacterException invalidCharacterException) {
			System.out.println("The extractor found an invalid character when trying to read a line.\n");
		} catch (IOException ioException) {
			System.out.println("A BufferedReader threw an IOException when trying to read a line.\n");
		}
	}
}