package com.ifivetechnologies.justjava;

        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v7.app.ActionBarActivity;
        import android.text.Editable;
        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.TextView;

        import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, Activity3.class);
        /*EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // Get user's name
        EditText nameField = (EditText) findViewById(R.id.name_field);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();

        // Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        // Figure out if the user wants chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        // Calculate the price
        int price = calculatePrice(hasWhippedCream, hasChocolate);

        // Display the order summary on the screen
        String message = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
    }
    /**
     * This method is calculates price when plus button is clicked.
     */
    public int calculatePrice(boolean hasWhippedCream,boolean hasChocolate) {
        int price=5;
        if(hasWhippedCream) {
            price = price + 1;
        }
        if(hasChocolate){
            price = price+2;
        }
        price = quantity*price ;
        return price;
    }
    /**
     * This method is calculates price when plus button is clicked.
     */
    public String createOrderSummary(java.lang.String name,int price,boolean hasWhippedCream,boolean hasChocolate) {
        boolean state = hasWhippedCream;
        boolean state2 = hasChocolate;
        EditText etxt = (EditText) findViewById(R.id.name_field);
        String summery = "Name:Kaptain Kunal \n add cream? "+state+ "\nadd coco? "+state2+"\n Quantity:"+quantity+ "\n"+"total:"+price+"\n"+"Thank you!";
        summery = summery + "\n"+ etxt.getText().toString();

        composeEmail(summery, "nadav.yacov@gmail.com", "blabla");
        return summery;
    }

    public void composeEmail(String content,String addresses, String subject) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "blabla");
        intent.putExtra(Intent.EXTRA_TEXT, content);
        startActivity(Intent.createChooser(intent, "Send Email"));

    }


    /**
    /**
     * This method is called when plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity+1;
        displayQuantity(quantity);
    }

    public void open2activity(View view) {
        Intent intent = new Intent(this, activity2.class);
        /*EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);

    }
    public void open3activity(View view) {
        Intent intent = new Intent(this, Activity3.class);
        /*EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);

    }
    /**
     * This method is called when minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity-1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }



}