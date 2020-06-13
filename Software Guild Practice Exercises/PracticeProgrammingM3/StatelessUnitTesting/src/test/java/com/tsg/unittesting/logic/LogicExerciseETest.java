/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.unittesting.logic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author chelseamiller
 */
public class LogicExerciseETest {
    
    public LogicExerciseETest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of whatColor method, of class LogicExerciseE.
     *   * 
     * 	Color	Wavelength	Frequency	Photon energy
     * 	Violet	380–450 nm	668–789 THz	2.75–3.26 eV
     * 	Blue	450–495 nm	606–668 THz	2.50–2.75 eV
     * 	Green	495–570 nm	526–606 THz	2.17–2.50 eV
     * 	Yellow	570–590 nm	508–526 THz	2.10–2.17 eV
     * 	Orange	590–620 nm	484–508 THz	2.00–2.10 eV
     * 	Red	620–750 nm	400–484 THz	1.65–2.00 eV
     *
     * Ex:
     * whatColor( 575, 510, 2.15 ) ->  "Yellow"
     * whatColor( 449, 670, 3.00 ) ->  "Violet"
     * whatColor( 621, 475, 16.5 ) ->  "Unknown"
     * whatColor( 590, 508, 2.05 ) ->  "Orange"
     * whatColor( 570, 526, 2.17 ) ->  "Yellow-Green"
     */
    @Test
    public void testWhatColorYellow() {
        int waveLengthNM = 575;
        int frequencyTHZ = 510;
        double photonicEnergyEV = 2.15;
        String expResult = "Yellow";
        String result = LogicExerciseE.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        assertEquals(expResult, result);
    }
    @Test
    public void testWhatColorViolet() {
        int waveLengthNM = 449;
        int frequencyTHZ = 670;
        double photonicEnergyEV = 3.00;
        String expResult = "Violet";
        String result = LogicExerciseE.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        assertEquals(expResult, result);
    }
    @Test
    public void testWhatColorUnknown() {
        int waveLengthNM = 621;
        int frequencyTHZ = 475;
        double photonicEnergyEV = 16.5;
        String expResult = "Unknown";
        String result = LogicExerciseE.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        assertEquals(expResult, result);
    }
    @Test
    public void testWhatColorOrange() {
        int waveLengthNM = 590;
        int frequencyTHZ = 508;
        double photonicEnergyEV = 2.05;
        String expResult = "Orange";
        String result = LogicExerciseE.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        assertEquals(expResult, result);
    }
    @Test
    public void testWhatColorYellowGreen() {
        int waveLengthNM = 570;
        int frequencyTHZ = 526;
        double photonicEnergyEV = 2.17;
        String expResult = "Yellow-Green";
        String result = LogicExerciseE.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        assertEquals(expResult, result);
    }
}
