package edu.qc.seclass.replace;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class MyMainTest {
    private ByteArrayOutputStream outStream;
    private ByteArrayOutputStream errStream;
    private PrintStream outOrig;
    private PrintStream errOrig;
    private Charset charset = StandardCharsets.UTF_8;

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void setUp() throws Exception {
        outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);
        errStream = new ByteArrayOutputStream();
        PrintStream err = new PrintStream(errStream);
        outOrig = System.out;
        errOrig = System.err;
        System.setOut(out);
        System.setErr(err);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(outOrig);
        System.setErr(errOrig);
    }

    // Some utilities

    private File createTmpFile() throws IOException {
        File tmpfile = temporaryFolder.newFile();
        tmpfile.deleteOnExit();
        return tmpfile;
    }

    private File createInputFile1() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("Howdy Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"howdy bill\" again!");

        fileWriter.close();
        return file1;
    }

    private File createInputFile2() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("Howdy Bill,\n" +
                "This is another test file for the replace utility\n" +
                "that contains a list:\n" +
                "-a) Item 1\n" +
                "-b) Item 2\n" +
                "...\n" +
                "and says \"howdy Bill\" twice");

        fileWriter.close();
        return file1;
    }

    private File createInputFile3() throws Exception {
        // Empty file
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("");

        fileWriter.close();
        return file1;
    }

    private String getFileContent(String filename) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(filename)), charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    // Test cases


    /*
        Test Case 1  		<single>
        Size :  Empty
     */
    @Test
    public void test1() throws Exception {
        File inputFile = createInputFile3();
        String args[] = {"-b", "hello", "Hello", "--", inputFile.getPath()};
        Main.main(args);
        String expected = "";
        String acutal = getFileContent(inputFile.getPath());
        assertEquals("File is empty", expected, acutal);
        assertTrue(Files.exists(Paths.get(inputFile.getPath() + ".bck")));
    }

    /*
        Test Case 1  		<single>
        Size :  Empty
     */
    @Test
    public void test2() throws Exception {
        File inputFile = createInputFile3();
        String args[] = {"-f", "hello", "Hello", "--", inputFile.getPath()};
        Main.main(args);
        String expected = "";
        String acutal = getFileContent(inputFile.getPath());
        assertEquals("File is empty", expected, acutal);
        assertFalse(Files.exists(Paths.get(inputFile.getPath() + ".bck")));
    }

    /*
        Test Case 1  		<single>
        Size :  Empty
     */
    @Test
    public void test3() throws Exception {
        File inputFile = createInputFile3();
        String args[] = {"-l", "hello", "Hello", "--", inputFile.getPath()};
        Main.main(args);
        String expected = "";
        String acutal = getFileContent(inputFile.getPath());
        assertEquals("File is empty", expected, acutal);
        assertFalse(Files.exists(Paths.get(inputFile.getPath() + ".bck")));
    }

    /*
        Test Case 1  		<single>
        Size :  Empty
     */
    @Test
    public void test4() throws Exception {
        File inputFile = createInputFile3();
        String args[] = {"-i", "hello", "Hello", "--", inputFile.getPath()};
        Main.main(args);
        String expected = "";
        String acutal = getFileContent(inputFile.getPath());
        assertEquals("File is empty", expected, acutal);
        assertFalse(Files.exists(Paths.get(inputFile.getPath() + ".bck")));
    }

    // only OPT picked
    @Test
    public void test5() throws Exception {
        File inputFile = createInputFile1();
        String args[] = {"-b"};
        Main.main(args);
        assertEquals("Usage: Replace [-b] [-f] [-l] [-i] <from> <to> -- <filename> [<filename>]*", errStream.toString().trim());
        assertFalse(Files.exists(Paths.get(inputFile.getPath() + ".bck")));
    }

    // only OPT picked
    @Test
    public void test6() throws Exception {
        File inputFile = createInputFile1();
        String args[] = {"-f", "-l"};
        Main.main(args);
        assertEquals("Usage: Replace [-b] [-f] [-l] [-i] <from> <to> -- <filename> [<filename>]*", errStream.toString().trim());
        assertFalse(Files.exists(Paths.get(inputFile.getPath() + ".bck")));
    }

    // only OPT picked
    @Test
    public void test7() throws Exception {
        File inputFile = createInputFile1();
        String args[] = {"-l", "-i", "-f", "-b"};
        Main.main(args);
        assertEquals("Usage: Replace [-b] [-f] [-l] [-i] <from> <to> -- <filename> [<filename>]*", errStream.toString().trim());
        assertFalse(Files.exists(Paths.get(inputFile.getPath() + ".bck")));
    }

    // no file picked
    @Test
    public void test8() throws Exception {
        File inputFile = createInputFile1();
        String args[] = {"Howdy", "Hello", "--"};
        Main.main(args);
        assertEquals("Usage: Replace [-b] [-f] [-l] [-i] <from> <to> -- <filename> [<filename>]*", errStream.toString().trim());
        assertFalse(Files.exists(Paths.get(inputFile.getPath() + ".bck")));
    }

    /*
        Test Case 2  		<error>
        No or wrong operation picked :  true
     */
    @Test
    public void test9() throws Exception {
        File inputFile = createInputFile1();
        String args[] = {"-s", "Howdy", "Hello", "--", inputFile.getPath()};
        Main.main(args);
        assertEquals("Usage: Replace [-b] [-f] [-l] [-i] <from> <to> -- <filename> [<filename>]*", errStream.toString().trim());
        assertFalse(Files.exists(Paths.get(inputFile.getPath() + ".bck")));
    }

    // No arguments
    @Test
    public void test10() throws Exception {
        File inputFile = createInputFile1();
        String args[] = {};
        Main.main(args);
        assertEquals("Usage: Replace [-b] [-f] [-l] [-i] <from> <to> -- <filename> [<filename>]*", errStream.toString().trim());
        assertFalse(Files.exists(Paths.get(inputFile.getPath() + ".bck")));
    }

    /*
        Test Case 3  		<error>
        Length of 'from' string :  Empty
     */
    @Test
    public void test11() throws Exception {
        File inputFile = createInputFile1();
        String args[] = {"-i", "", "Hello", "--", inputFile.getPath()};
        Main.main(args);
        assertEquals("\"from\" can't be an empty string!!!", errStream.toString().trim());
        assertFalse(Files.exists(Paths.get(inputFile.getPath() + ".bck")));
    }

    // usage test
    @Test
    public void test12() throws Exception {
        File inputFile = createInputFile1();
        String args[] = {"-f Howdy Hello -- inputFile.getPath()"};
        Main.main(args);
        assertEquals("Usage: Replace [-b] [-f] [-l] [-i] <from> <to> -- <filename> [<filename>]*", errStream.toString().trim());
    }

    /*
        Test Case 4  		<error>
        Presence of a file corresponding to the name :  Not present
     */
    @Test
    public void test13() throws Exception {
        File inputFile = createInputFile1();
        inputFile.delete();
        String args[] = {"-f", "Howdy", "Hello", "--", inputFile.getPath()};
        Main.main(args);
        assertEquals("File " + inputFile.getName() + " not found", errStream.toString().trim());
        assertFalse(Files.exists(Paths.get(inputFile.getPath() + ".bck")));
    }

    // no operation
    @Test
    public void test14() throws Exception {
        File inputFile = createInputFile1();
        String args[] = {"Howdy", "Hello", "--", inputFile.getPath()};
        Main.main(args);
        String expected = "Hello Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"howdy bill\" again!";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
        assertFalse(Files.exists(Paths.get(inputFile.getPath() + ".bck")));
    }

    // OPT not in order
    @Test
    public void test15() throws Exception {
        File inputFile = createInputFile1();
        String args[] = {"-l", "-i", "-f", "Howdy", "Hello", "--", inputFile.getPath()};
        Main.main(args);
        String expected = "Hello Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"Hello bill\" again!";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
        assertFalse(Files.exists(Paths.get(inputFile.getPath() + ".bck")));
    }

    /*
       Test Case 6  		(Key = 2.1.1.1.1.2.2.1.2.2.2.)
       Size                                         :  Not empty
       Operation b                                  :  -b
       Operation f                                  :  -f
       Operation l                                  :  -l
       Operation i                                  :  -i
       No or wrong operation picked                 :  false
       Length of 'from' string                      :  Non-Empty
       Has 'from' string                            :  true
       Length of 'to' String                        :  Non-Empty
       Presence of a file corresponding to the name :  Present
       Back up file copy                            :  true
     */
    @Test
    public void test16() throws Exception{
        File file1 = createInputFile1();

        String args[] = {"-b", "-f", "-l", "-i", "Howdy", "Hello", "--", file1.getPath()};
        Main.main(args);

        String expected = "Hello Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"Hello bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced",expected, actual);
        assertTrue(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    /*
       Test Case 9  		(Key = 2.1.1.1.2.2.2.1.1.2.2.)
       Size                                         :  Not empty
       Operation b                                  :  -b
       Operation f                                  :  -f
       Operation l                                  :  -l
       Operation i                                  :  -i_Disabled
       No or wrong operation picked                 :  false
       Length of 'from' string                      :  Non-Empty
       Has 'from' string                            :  true
       Length of 'to' String                        :  Empty
       Presence of a file corresponding to the name :  Present
       Back up file copy                            :  true
     */
    @Test
    public void test17() throws Exception{
        File file1 = createInputFile1();

        String args[] = {"-b", "-f", "-l", "Howdy", "", "--", file1.getPath()};
        Main.main(args);

        String expected = " Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"howdy bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced",expected, actual);
        assertTrue(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    /*
        Test Case 10 		(Key = 2.1.1.1.2.2.2.1.2.2.2.)
       Size                                         :  Not empty
       Operation b                                  :  -b
       Operation f                                  :  -f
       Operation l                                  :  -l
       Operation i                                  :  -i_Disabled
       No or wrong operation picked                 :  false
       Length of 'from' string                      :  Non-Empty
       Has 'from' string                            :  true
       Length of 'to' String                        :  Non-Empty
       Presence of a file corresponding to the name :  Present
       Back up file copy                            :  true
     */
    @Test
    public void test18() throws Exception{
        File file1 = createInputFile1();

        String args[] = {"-b", "-f", "-l", "Howdy", "Hello", "--", file1.getPath()};
        Main.main(args);

        String expected = "Hello Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"howdy bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced",expected, actual);
        assertTrue(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    /*
        Test Case 13 		(Key = 2.1.1.2.1.2.2.1.1.2.2.)
       Size                                         :  Not empty
       Operation b                                  :  -b
       Operation f                                  :  -f
       Operation l                                  :  -l_Disabled
       Operation i                                  :  -i
       No or wrong operation picked                 :  false
       Length of 'from' string                      :  Non-Empty
       Has 'from' string                            :  true
       Length of 'to' String                        :  Empty
       Presence of a file corresponding to the name :  Present
       Back up file copy                            :  true
     */
    @Test
    public void test19() throws Exception{
        File file1 = createInputFile1();

        String args[] = {"-b", "-f", "-i", "Howdy", "", "--", file1.getPath()};
        Main.main(args);

        String expected = " Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"howdy bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced",expected, actual);
        assertTrue(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    /*
    Test Case 14 		(Key = 2.1.1.2.1.2.2.1.2.2.2.)
   Size                                         :  Not empty
   Operation b                                  :  -b
   Operation f                                  :  -f
   Operation l                                  :  -l_Disabled
   Operation i                                  :  -i
   No or wrong operation picked                 :  false
   Length of 'from' string                      :  Non-Empty
   Has 'from' string                            :  true
   Length of 'to' String                        :  Non-Empty
   Presence of a file corresponding to the name :  Present
   Back up file copy                            :  true
     */
    @Test
    public void test20() throws Exception{
        File file1 = createInputFile1();

        String args[] = {"-b", "-f", "-i", "Howdy", "Hello", "--", file1.getPath()};
        Main.main(args);

        String expected = "Hello Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"howdy bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced",expected, actual);
        assertTrue(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    /*
    Test Case 21 		(Key = 2.1.2.1.1.2.2.1.1.2.2.)
   Size                                         :  Not empty
   Operation b                                  :  -b
   Operation f                                  :  -f_Disabled
   Operation l                                  :  -l
   Operation i                                  :  -i
   No or wrong operation picked                 :  false
   Length of 'from' string                      :  Non-Empty
   Has 'from' string                            :  true
   Length of 'to' String                        :  Empty
   Presence of a file corresponding to the name :  Present
   Back up file copy                            :  true
     */
    @Test
    public void test21() throws Exception{
        File file1 = createInputFile1();

        String args[] = {"-b", "-l", "-i", "Howdy", "", "--", file1.getPath()};
        Main.main(args);

        String expected = "Howdy Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \" bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced",expected, actual);
        assertTrue(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    /*
    Test Case 22 		(Key = 2.1.2.1.1.2.2.1.2.2.2.)
   Size                                         :  Not empty
   Operation b                                  :  -b
   Operation f                                  :  -f_Disabled
   Operation l                                  :  -l
   Operation i                                  :  -i
   No or wrong operation picked                 :  false
   Length of 'from' string                      :  Non-Empty
   Has 'from' string                            :  true
   Length of 'to' String                        :  Non-Empty
   Presence of a file corresponding to the name :  Present
   Back up file copy                            :  true
     */
    @Test
    public void test22() throws Exception{
        File file1 = createInputFile1();

        String args[] = {"-b", "-l", "-i", "Howdy", "Hello", "--", file1.getPath()};
        Main.main(args);

        String expected = "Howdy Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"Hello bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced",expected, actual);
        assertTrue(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    /*
    Test Case 37 		(Key = 2.2.1.1.1.2.2.1.1.2.1.)
   Size                                         :  Not empty
   Operation b                                  :  -b_Disabled
   Operation f                                  :  -f
   Operation l                                  :  -l
   Operation i                                  :  -i
   No or wrong operation picked                 :  false
   Length of 'from' string                      :  Non-Empty
   Has 'from' string                            :  true
   Length of 'to' String                        :  Empty
   Presence of a file corresponding to the name :  Present
   Back up file copy                            :  false
     */
    @Test
    public void test23() throws Exception{
        File inputFile = createInputFile1();

        String args[] = {"-f", "-l", "-i", "Howdy", "", "--", inputFile.getPath()};
        Main.main(args);

        String expected = " Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \" bill\" again!";

        String actual = getFileContent(inputFile.getPath());
        assertEquals("replaced",expected, actual);
        assertFalse(Files.exists(Paths.get(inputFile.getPath() + ".bck")));
    }

    /*
    Test Case 38 		(Key = 2.2.1.1.1.2.2.1.2.2.1.)
   Size                                         :  Not empty
   Operation b                                  :  -b_Disabled
   Operation f                                  :  -f
   Operation l                                  :  -l
   Operation i                                  :  -i
   No or wrong operation picked                 :  false
   Length of 'from' string                      :  Non-Empty
   Has 'from' string                            :  true
   Length of 'to' String                        :  Non-Empty
   Presence of a file corresponding to the name :  Present
   Back up file copy                            :  false
     */
    @Test
    public void test24() throws Exception{
        File file1 = createInputFile1();

        String args[] = {"-f", "-l", "-i", "Howdy", "Hello", "--", file1.getPath()};
        Main.main(args);

        String expected = "Hello Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"Hello bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced",expected, actual);
        assertFalse(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    // test -b
    @Test
    public void test25() throws Exception {
        File file1 = createInputFile1();

        String args[] = {"-b", "Howdy", "Hello", "--", file1.getPath()};
        Main.main(args);

        String expected = "Hello Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"howdy bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced", expected, actual);
        assertTrue(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    // test -f
    @Test
    public void test26() throws Exception {
        File file1 = createInputFile1();

        String args[] = {"-f", "Howdy", "Hello", "--", file1.getPath()};
        Main.main(args);

        String expected = "Hello Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"howdy bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced", expected, actual);
        assertFalse(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    // test -l
    @Test
    public void test27() throws Exception {
        File file1 = createInputFile1();

        String args[] = {"-l", "Howdy", "Hello", "--", file1.getPath()};
        Main.main(args);

        String expected = "Hello Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"howdy bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced", expected, actual);
        assertFalse(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    // test -i
    @Test
    public void test28() throws Exception {
        File file1 = createInputFile1();

        String args[] = {"-i", "howdy", "Hello", "--", file1.getPath()};
        Main.main(args);

        String expected = "Hello Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"Hello bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced", expected, actual);
        assertFalse(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    // test -b with empty <to>
    @Test
    public void test29() throws Exception {
        File file1 = createInputFile1();

        String args[] = {"-b", "Howdy", "", "--", file1.getPath()};
        Main.main(args);

        String expected = " Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"howdy bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced", expected, actual);
        assertTrue(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    // test -f with empty <to>
    @Test
    public void test30() throws Exception {
        File file1 = createInputFile1();

        String args[] = {"-f", "Howdy", "", "--", file1.getPath()};
        Main.main(args);

        String expected = " Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"howdy bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced", expected, actual);
        assertFalse(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    // test -l with empty <to>
    @Test
    public void test31() throws Exception {
        File file1 = createInputFile1();

        String args[] = {"-l", "Howdy", "", "--", file1.getPath()};
        Main.main(args);

        String expected = " Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"howdy bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced", expected, actual);
        assertFalse(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    // test -i with empty <to>
    @Test
    public void test32() throws Exception {
        File file1 = createInputFile1();

        String args[] = {"-i", "howdy", "", "--", file1.getPath()};
        Main.main(args);

        String expected = " Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \" bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced", expected, actual);
        assertFalse(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    // test -b and -f
    @Test
    public void test33() throws Exception {
        File file1 = createInputFile1();

        String args[] = {"-b", "-f", "Howdy", "Hello", "--", file1.getPath()};
        Main.main(args);

        String expected = "Hello Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"howdy bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced", expected, actual);
        assertTrue(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    // test repeated OPT
    @Test
    public void test34() throws Exception {
        File file1 = createInputFile1();

        String args[] = {"-l", "-l", "-i", "Howdy", "Hello", "--", file1.getPath()};
        Main.main(args);

        String expected = "Hello Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"Hello bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced", expected, actual);
        assertFalse(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    // test -l and -i
    @Test
    public void test35() throws Exception {
        File file1 = createInputFile1();

        String args[] = {"-l", "-i", "Howdy", "Hello", "--", file1.getPath()};
        Main.main(args);

        String expected = "Howdy Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"Hello bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced", expected, actual);
        assertFalse(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    // test -f and -i
    @Test
    public void test36() throws Exception {
        File file1 = createInputFile1();

        String args[] = {"-f", "-i", "Howdy", "Hello", "--", file1.getPath()};
        Main.main(args);

        String expected = "Hello Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"howdy bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced", expected, actual);
        assertFalse(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    // test -b and -f with empty <to>
    @Test
    public void test37() throws Exception {
        File file1 = createInputFile1();

        String args[] = {"-b", "-f", "Howdy", "", "--", file1.getPath()};
        Main.main(args);

        String expected = " Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"howdy bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced", expected, actual);
        assertTrue(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    // test -f and -l with empty <to>
    @Test
    public void test38() throws Exception {
        File file1 = createInputFile1();

        String args[] = {"-f", "-l", "Howdy", "", "--", file1.getPath()};
        Main.main(args);

        String expected = " Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"howdy bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced", expected, actual);
        assertFalse(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    // test -l and -i with empty <to>
    @Test
    public void test39() throws Exception {
        File file1 = createInputFile1();

        String args[] = {"-l", "-i", "Howdy", "", "--", file1.getPath()};
        Main.main(args);

        String expected = "Howdy Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \" bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced", expected, actual);
        assertFalse(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }

    // test -f and -i with empty <to>
    @Test
    public void test40() throws Exception {
        File file1 = createInputFile1();

        String args[] = {"-f", "-i", "Howdy", "", "--", file1.getPath()};
        Main.main(args);

        String expected = " Bill,\n" +
                "This is a test file for the replace utility\n" +
                "Let's make sure it has at least a few lines\n" +
                "so that we can create some interesting test cases...\n" +
                "And let's say \"howdy bill\" again!";

        String actual = getFileContent(file1.getPath());
        assertEquals("replaced", expected, actual);
        assertFalse(Files.exists(Paths.get(file1.getPath() + ".bck")));
    }
}
