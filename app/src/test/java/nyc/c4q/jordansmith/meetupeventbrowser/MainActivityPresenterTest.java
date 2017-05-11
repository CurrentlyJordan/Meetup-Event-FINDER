package nyc.c4q.jordansmith.meetupeventbrowser;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

import nyc.c4q.jordansmith.meetupeventbrowser.main.MainContract;
import nyc.c4q.jordansmith.meetupeventbrowser.main.MainPresenter;

/**
 * Created by c4q on 5/8/17.
 */

public class MainActivityPresenterTest {

    private MainContract.View mockView;
    private MainPresenter mainPresenter;

    @Before
    public void init(){
        this.mockView= Mockito.mock(MainContract.View.class);
        mainPresenter = new MainPresenter(mockView);
    }



    @Test
    public void testWrongZipCodeEntered(){
        mainPresenter.evaluateZipCode("1234");
        Mockito.verify(mockView).showLengthErrorMessage();
    }



    @Test
    public void testRightZipCodeEntered(){
        mainPresenter.evaluateZipCode("12345");
        Mockito.verify(mockView).openDetailActivity("12345");
    }

    @Test
    public void additionTest(){
        assertEquals(2,2);
    }




}
