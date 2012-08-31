package uk.co.markberridge.test;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

abstract public class MockUnitTestCase implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    // @Before
    // public void setUp() throws Exception {
    // setUpMocks();
    // }
    //
    // /**
    // * Initialise all required mocks.
    // */
    // protected abstract void setUpMocks();

    /**
     * Get mocks required for this test.
     */
    protected abstract Object[] getMocks();

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
    protected static <T> T createMock(Class<T> toMock) {
        return EasyMock.createStrictMock(toMock.getSimpleName(), toMock);
    }
}
