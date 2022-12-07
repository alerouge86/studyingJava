package com.alerouge.demo.codewars;

import java.util.*;
import java.lang.reflect.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VersionManagerTest {

    @Test
    public void initializationTests() {
        try {
            assertEquals("0.0.1", new VersionManager().release());
            assertEquals("0.0.1", new VersionManager("").release());
            assertEquals("1.2.3", new VersionManager("1.2.3").release());
            assertEquals("1.2.3", new VersionManager("1.2.3.4").release());
            assertEquals("1.2.3", new VersionManager("1.2.3.d").release());
            assertEquals("1.0.0", new VersionManager("1").release());
            assertEquals("1.1.0", new VersionManager("1.1").release());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void majorReleasesTests() {
        try {
            assertEquals("1.0.0", new VersionManager().major().release());
            assertEquals("2.0.0", new VersionManager("1.2.3").major().release());
            assertEquals("3.0.0", new VersionManager("1.2.3").major().major().release());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void minorReleasesTests() {
        try {
            assertEquals("0.1.0", new VersionManager().minor().release());
            assertEquals("1.3.0", new VersionManager("1.2.3").minor().release());
            assertEquals("1.1.0", new VersionManager("1").minor().release());
            assertEquals("4.2.0", new VersionManager("4").minor().minor().release());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void patchReleasesTests() {
        try {
            assertEquals("0.0.2", new VersionManager().patch().release());
            assertEquals("1.2.4", new VersionManager("1.2.3").patch().release());
            assertEquals("4.0.2", new VersionManager("4").patch().patch().release());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void rollbacksTests() {
        try {
            assertEquals("0.0.1", new VersionManager().major().rollback().release());
            assertEquals("0.0.1", new VersionManager().minor().rollback().release());
            assertEquals("0.0.1", new VersionManager().patch().rollback().release());
            assertEquals("1.0.0", new VersionManager().major().patch().rollback().release());
            assertEquals("1.0.0", new VersionManager().major().patch().rollback().major().rollback().release());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void seperatedCallsTests() {
        try {
            VersionManager m = new VersionManager("1.2.3");
            m.major();
            m.minor();
            assertEquals("2.1.0", m.release());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void exceptionsTests() {
        try {
            VersionManager m = new VersionManager("a.b.c");
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertEquals("Error occured while parsing version!", e.getMessage());
        }
        try {
            VersionManager m = new VersionManager().rollback();
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertEquals("Cannot rollback!", e.getMessage());
        }
    }

    private static int getRandomInt(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    private static String makeVersion() {
        ArrayList<String> str = new ArrayList<String>();
        for (int i = VersionManagerTest.getRandomInt(1, 5); i > 0; i--) {
            int n = VersionManagerTest.getRandomInt(0, 75);
            str.add(n > 64 ? String.valueOf(Character.toChars(n + 32)) : "" + n);
        }
        return String.join(".", str);
    }

    private static String[] makeSteps() {
        String[] steps = new String[]{"major", "minor", "patch", "rollback"};
        ArrayList<String> result = new ArrayList<String>();
        for (int i = VersionManagerTest.getRandomInt(0, 10); i > 0; i--) {
            result.add(steps[VersionManagerTest.getRandomInt(0, 3)]);
        }
        return result.toArray(new String[result.size()]);
    }

    @SuppressWarnings("unchecked")
    private static String exec(Class manager, String version, String[] steps) {
        try {
            Object vm = manager.getDeclaredConstructor(new Class[]{String.class}).newInstance(version);
            ;
            for (int i = 0; i < steps.length; i++) {
                Method m = vm.getClass().getMethod(steps[i]);
                m.invoke(vm);
            }
            Method release = vm.getClass().getMethod("release");
            return (String) release.invoke(vm);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Test
    public void myTest1() {
        assertEquals(null, new VersionManager("5.8.56.33.22").major().rollback().release());
    }

    @Test
    public void randomTests() {
        for (int i = 100; i > 0; i--) {
            String version = VersionManagerTest.makeVersion();
            String[] steps = VersionManagerTest.makeSteps();

            System.out.println("version = " + version);
            System.out.println("steps = " + String.join(" ", steps));

            String exec = VersionManagerTest.exec(VM.class, version, steps);
            String exec1 = VersionManagerTest.exec(VersionManager.class, version, steps);

            if ((exec == null && exec1 == null)
                    ||
                    (exec != null && exec.equals(exec1))) {
                System.out.println("test OK");
            } else {
                System.out.println("test KO");
            }
            System.out.println("-------");

            assertEquals(VersionManagerTest.exec(VM.class, version, steps), VersionManagerTest.exec(VersionManager.class, version, steps));
        }
    }
}

class VM {
    private int x;
    private int y;
    private int z;
    private ArrayList<int[]> log;

    public VM() {
        this.x = 0;
        this.y = 0;
        this.z = 1;
        this.initLog();
    }

    public VM(String version) throws Exception {
        if (version.equals("")) {
            version = "0.0.1";
        }
        String[] splitted = version.split("\\.");
        try {
            this.x = Integer.parseInt(splitted[0]);
            try {
                this.y = Integer.parseInt(splitted[1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                this.y = 0;
            }
            try {
                this.z = Integer.parseInt(splitted[2]);
            } catch (ArrayIndexOutOfBoundsException e) {
                this.z = 0;
            }
        } catch (Exception e) {
            throw new Exception("Error occured while parsing version!");
        }
        this.initLog();
    }

    private void initLog() {
        this.log = new ArrayList<int[]>();
    }

    private void logVersion() {
        this.log.add(new int[]{
                this.x, this.y, this.z
        });
    }

    private void setVersion(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public VM major() {
        this.logVersion();
        this.setVersion(this.x + 1, 0, 0);
        return this;
    }

    public VM minor() {
        this.logVersion();
        this.setVersion(this.x, this.y + 1, 0);
        return this;
    }

    public VM patch() {
        this.logVersion();
        this.setVersion(this.x, this.y, this.z + 1);
        return this;
    }

    public VM rollback() throws Exception {
        int size = this.log.size();
        if (size > 0) {
            int[] p = this.log.get(size - 1);
            this.log.remove(size - 1);
            this.setVersion(p[0], p[1], p[2]);
            return this;
        }

        throw new Exception("Cannot rollback!");
    }

    public String release() {
        return "" + this.x + "." + this.y + "." + this.z;
    }
}