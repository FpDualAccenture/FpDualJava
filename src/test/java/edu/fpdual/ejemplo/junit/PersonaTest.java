package edu.fpdual.ejemplo.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class PersonaTest {

    Persona persona;

    @BeforeAll
    public static void initAll(){
        System.out.println("========BeforeAll========");
    }

    @BeforeEach
    public void init(){
        System.out.println("========BeforeEach========");
        persona = new Persona();
        persona.setNombre("JOSE");
        persona.setApellido("Prieto");
        persona.setEdad(32);
        persona.setFechaNacimiento(LocalDate.of(1989,5,19));
        persona.setHobbies(Arrays.asList(Hobbies.TROTAR, Hobbies.VIDEO_JUEGOS, Hobbies.MONTAR_EN_BICI));
    }

    @AfterEach
    public void destroy(){
        System.out.println("========DestroyEach========");
        persona = null;
    }

    @AfterAll
    public static void destroyAll(){
        System.out.println("========DestroyAll========");
    }

    @Test
    public void setNombre_ok(){
        assumeTrue(persona != null);
        String nombre = "Mesa";
        persona.setNombre(nombre.toUpperCase());
        assertAll(
                () -> assertEquals(nombre, persona.getNombre()),
                () -> assertEquals("Prieto", persona.getApellido()),
                () -> assertEquals(32, persona.getEdad()));
    }

    @Test
    public void setApellido_ok(){
        assumeTrue(persona != null);
        String apellido = "Mesa";
        persona.setApellido(apellido.toUpperCase());
        assertNotNull(persona);
        assertFalse(persona.getApellido().trim().isEmpty());
        assertEquals(apellido.toUpperCase(), persona.getApellido());
    }

    @Test
    public void setEdad_ok(){
        assumeTrue(persona != null);
        int nuevaEdad = 33;
        persona.setEdad(nuevaEdad);
        assertThat(persona.getEdad(), closeTo(34, 1));
    }

    @Test
    public void setHobbies_ok(){
        assumeTrue(persona != null);
        List<Hobbies> nuevosHobbies = Arrays.asList(Hobbies.TROTAR, Hobbies.VIDEO_JUEGOS, Hobbies.MONTAR_EN_BICI, Hobbies.NADAR);
        persona.setHobbies(nuevosHobbies);
        assertThat(persona.getHobbies(), hasSize(4));
        assertThat(persona.getHobbies(), hasItem(Hobbies.TROTAR));
        assertThat(persona.getHobbies(), is(nuevosHobbies));
        assertThat(persona.getHobbies().get(0).getMinutos(), is(Hobbies.TROTAR.getMinutos()));
    }

    @Test
    public void setFechaNacimiento_ok(){
        assumeTrue(persona != null);
        LocalDate nuevaFecha = LocalDate.of(2006,4,24);
        persona.setFechaNacimiento(nuevaFecha);
        assertThat(persona.getFechaNacimiento(), is(nuevaFecha));
    }

    @Test
    public void allArgConstructor_ok(){
        assumeTrue(persona != null);
        Persona persona2 = new Persona(persona.getNombre(), persona.getApellido(),  persona.getFechaNacimiento(),
                persona.getEdad(), persona.getHobbies());
        assertThat(persona, is(persona2));
    }

    @Test
    public void setNombre_ko(){
        assumeTrue(persona != null);
        assertThrows(NullPointerException.class, () -> persona.setNombre(null));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        assertTrue(number%2!=0);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void isBlank_ShouldReturnTrueForAllTypesOfBlankStrings_ok(String input) {
        assertTrue(input==null || input.trim().isEmpty());
    }

    @ParameterizedTest
    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValue_ok(String input, String expected) {
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/data.csv", numLinesToSkip = 1)
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValueCSVFile_ok(
                    String input, String expected) {
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue);
    }

}
