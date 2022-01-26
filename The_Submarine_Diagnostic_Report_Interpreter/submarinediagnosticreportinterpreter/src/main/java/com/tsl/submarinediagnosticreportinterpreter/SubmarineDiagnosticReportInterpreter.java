/*
 * SubmarineDiagnosticReportInterpreter
 * author Tom Lever
 * version 0.0
 * since 01/26/22
 */

package com.tsl.submarinediagnosticreportinterpreter;

import com.tsl.submarinediagnosticreportinterpreter.extractorofbinarynumbers.ZeroBinaryNumbersException;
import com.tsl.submarinediagnosticreportinterpreter.extractorofbinarynumbers.ExtractorOfBinaryNumbers;
import com.tsl.submarinediagnosticreportinterpreter.extractorofbinarynumbers.InconsistentNumberOfBitsException;
import com.tsl.submarinediagnosticreportinterpreter.extractorofbinarynumbers.InvalidCharacterException;
import java.io.IOException;
import java.util.ArrayList;

public class SubmarineDiagnosticReportInterpreter {
    
    public static void main(String[] args)
        throws InconsistentNumberOfBitsException, InvalidCharacterException, IOException, ZeroBinaryNumbersException {
        String pathToDiagnosticReport = args[0];
        ArrayList<String> binaryNumbers =
            (new ExtractorOfBinaryNumbers()).extractsBinaryNumbersFromDiagnosticReportAt(pathToDiagnosticReport);
        GeneratorOfSubmarineStatistics generatorOfSubmarineStatistics = new GeneratorOfSubmarineStatistics(binaryNumbers);
        System.out.printf(
            "The power consumption of the submarine corresponding to the diagnostic report at\n\""
            + pathToDiagnosticReport + "\"\nis %.0f.\n\n",
            generatorOfSubmarineStatistics.providesSubmarinesPowerConsumption());
        System.out.printf(
            "The life-support rating of the submarine corresponding to the diagnostic report at\n\""
            + pathToDiagnosticReport + "\"\nis %.0f.", generatorOfSubmarineStatistics.providesSubmarinesLifeSupportRating());
        
    }
}