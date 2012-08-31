package uk.co.markberridge.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;

abstract public class MockUnitTestCase {

    /**
     * Get mocks required for this test.
     */
    protected Object[] getMocks() {
        List<Object> mocks = new ArrayList<Object>();
        for (Field field : getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Mock.class)) {
                try {
                    if (field.isAccessible()) {
                        mocks.add(field.get(this));
                    } else {
                        field.setAccessible(true);
                        mocks.add(field.get(this));
                        field.setAccessible(false);
                    }
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return mocks.toArray();
    }

    /**
     * Move all mocks into replay mode.
     */
    protected void playbackMocks() {
        EasyMock.replay(getMocks());
    }

    /**
     * Verify all mocks when test has finished.
     */
    @After
    public void verifyMocks() {
        EasyMock.verify(getMocks());
    }

    /**
     * Move all mocks into reset mode.
     */
    @Before
    public void resetMocks() {
        EasyMock.reset(getMocks());
    }

    /**
     * Helper to create a strict mock with the name of the mock set to the simple name of the class
     * 
     * @param <T>
     * @param toMock
     * @return mock for required class
     */
    public static <T> T createMock(Class<T> toMock) {
        return EasyMock.createStrictMock(toMock.getSimpleName(), toMock);
    }
}
