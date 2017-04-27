package nyc.c4q.jordansmith.meetupeventbrowser.main;

/**
 * Created by jordansmith on 4/25/17.
 */

interface  MainContract {

    interface View{
        void openDetailActivity(String zipCode);

        void onZipCodeEntered();

        void showLengthErrorMessage();
    }

    interface Presenter{
        void evaluateZipCode(String zipCode);




    }
}
